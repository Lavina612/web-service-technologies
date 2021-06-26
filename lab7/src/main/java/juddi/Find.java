package juddi;

import juddi.generated._0._0._0._0._9070.personservice.PersonService;
import juddi.generated._0._0._0._0._9070.personservice.PersonWebService;
import org.apache.juddi.v3.client.config.UDDIClerk;
import org.apache.juddi.v3.client.config.UDDIClient;
import org.apache.juddi.v3.client.mapping.ServiceLocator;
import org.uddi.api_v3.BindingTemplate;
import org.uddi.api_v3.BusinessEntity;
import org.uddi.api_v3.BusinessService;

import javax.xml.ws.BindingProvider;
import java.net.URL;
import java.util.Map;

public class Find {

    public static void FindAndCall () {
        find();
        call();
    }

    public static void find() {
        try {
            UDDIClient uddiClient = new UDDIClient("META-INF/wsdl2uddi-uddi.xml");
            UDDIClerk clerk = uddiClient.getClerk("elizabeth");

            BusinessEntity businessEntity = clerk.findBusiness("uddi:uddi.elizabethpublisher.com:business-for-wsdl");
            if (businessEntity!=null) {
                System.out.println("Found business with name " + businessEntity.getName().get(0).getValue());
                if (businessEntity.getBusinessServices() !=null) {
                    System.out.println("Number of services: " + businessEntity.getBusinessServices().getBusinessService().size());

                    for (BusinessService businessService: businessEntity.getBusinessServices().getBusinessService()) {
                        System.out.println("Service Name        = '" + businessService.getName().get(0).getValue() + "'");
                        System.out.println("Service Key         = '" + businessService.getServiceKey() + "'");
                        System.out.println("Service Description = '" + businessService.getDescription().get(0).getValue() + "'");
                        System.out.println("BindingTemplates: " + businessService.getBindingTemplates().getBindingTemplate().size());

                        for (int i=0; i<businessService.getBindingTemplates().getBindingTemplate().size(); i++) {
                            BindingTemplate bindingTemplate = businessService.getBindingTemplates().getBindingTemplate().get(i);
                            System.out.println("--BindingTemplate" + " " + i + ":");
                            System.out.println("  bindingKey          = " + bindingTemplate.getBindingKey());
                            System.out.println("  accessPoint useType = " + bindingTemplate.getAccessPoint().getUseType());
                            System.out.println("  accessPoint value   = " + bindingTemplate.getAccessPoint().getValue());
                            System.out.println("  description         = " + bindingTemplate.getDescription().get(0).getValue());
                        }
                    }
                }
            }

            businessEntity.getBusinessServices();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void call() {
        try {
            UDDIClient uddiClient = new UDDIClient("META-INF/wsdl2uddi-uddi.xml");
            UDDIClerk clerk = uddiClient.getClerk("elizabeth");

            System.out.println("The clientside of a runtime lookup usually knows the serviceKey.");
            System.out.println("To get updated binding information you should use the ServiceLocator with a live cache.");
            String helloWorldServiceKey = "uddi:uddi.elizabethpublisher.com:service_person";

            long startTime = System.currentTimeMillis();
            ServiceLocator serviceLocator = new ServiceLocator(clerk);
            System.out.println("Created Cache in " + (System.currentTimeMillis() - startTime) + " [milliseconds]");
            System.out.println("Now adding a listener to the cache..."); //expensive
            startTime = System.currentTimeMillis();
            serviceLocator.withLiveCache(new URL("http://localhost:18079"));
            System.out.println("Add Listener to Cache in " + (System.currentTimeMillis() - startTime) + " [milliseconds]");

            startTime = System.currentTimeMillis();
            String endpoint = serviceLocator.lookupEndpoint(helloWorldServiceKey);
            long duration = System.currentTimeMillis() - startTime;
            System.out.println("1. UDDI Lookup - Elapsed time: " + duration + "[milliseconds] Endpoint=" + endpoint);

            long startTime2 = System.currentTimeMillis();;
            String endpoint2 = serviceLocator.lookupEndpoint(helloWorldServiceKey);
            long duration2 = System.currentTimeMillis() - startTime2;
            System.out.println("2. Cache Lookup - Elapsed time: " + duration2 + "[milliseconds] Endpoint=" + endpoint2);

            PersonService personService = new PersonService();
            PersonWebService service = personService.getPersonWebServicePort();
            Map<String, Object> requestContext = ((BindingProvider) service).getRequestContext();
            requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint2);
            String reply = service.getPersons().toString();
            System.out.println("*************** Service reply: " + reply);
            Thread.sleep(10l);
            serviceLocator.shutdown();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}