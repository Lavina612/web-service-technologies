package juddi;

import java.rmi.RemoteException;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.juddi.api_v3.Publisher;
import org.apache.juddi.api_v3.SavePublisher;
import org.apache.juddi.v3.client.config.UDDIClerk;
import org.apache.juddi.v3.client.config.UDDIClient;
import org.apache.juddi.v3.client.transport.TransportException;
import org.apache.juddi.v3_service.JUDDIApiPortType;
import org.uddi.api_v3.AuthToken;
import org.uddi.api_v3.BusinessEntity;
import org.uddi.api_v3.CategoryBag;
import org.uddi.api_v3.Description;
import org.uddi.api_v3.GetAuthToken;
import org.uddi.api_v3.KeyedReference;
import org.uddi.api_v3.Name;
import org.uddi.api_v3.OverviewDoc;
import org.uddi.api_v3.OverviewURL;
import org.uddi.api_v3.TModel;
import org.uddi.v3_service.UDDISecurityPortType;

public class Setup {

    private static UDDIClient uddiClient;

    public static void Setup() {
        Setup setup = new Setup();
        try {
            uddiClient = new UDDIClient("META-INF/wsdl2uddi-uddi.xml");
            UDDIClerk clerk = uddiClient.getClerk("elizabeth");

            setup.setupElizabethPublisher(clerk);
            setup.publishBusiness(clerk);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void publishBusiness(UDDIClerk clerk) {
        BusinessEntity busEntity = new BusinessEntity();
        Name busName = new Name();
        busName.setValue("Person-Business");
        busEntity.getName().add(busName);
        busEntity.setBusinessKey("uddi:uddi.elizabethpublisher.com:business-for-wsdl");
        clerk.register(busEntity);
    }

    private void setupElizabethPublisher(UDDIClerk clerk)
            throws RemoteException, ConfigurationException, TransportException {
        UDDISecurityPortType security = uddiClient.getTransport("default").getUDDISecurityService();

        GetAuthToken getAuthTokenRoot = new GetAuthToken();
        getAuthTokenRoot.setUserID("root");
        getAuthTokenRoot.setCred("");
        AuthToken rootAuthToken = security.getAuthToken(getAuthTokenRoot);
        System.out.println ("root AUTHTOKEN = " + rootAuthToken.getAuthInfo());

        JUDDIApiPortType juddiApi = uddiClient.getTransport("default").getJUDDIApiService();
        Publisher p = new Publisher();
        p.setAuthorizedName("elizabethpublisher");
        p.setPublisherName("Elizabeth Publisher");
        SavePublisher sp = new SavePublisher();
        sp.getPublisher().add(p);
        sp.setAuthInfo(rootAuthToken.getAuthInfo());
        juddiApi.savePublisher(sp);

        TModel keyGenerator = new TModel();
        keyGenerator.setTModelKey("uddi:uddi.elizabethpublisher.com:keygenerator");
        Name name = new Name();
        name.setValue("Elizabeth Publisher's Key Generator");
        keyGenerator.setName(name);
        Description description = new Description();
        description.setValue("This is the key generator for Elizabeth Publisher's UDDI entities!");
        keyGenerator.getDescription().add(description);

        OverviewDoc overviewDoc = new OverviewDoc();
        OverviewURL overviewUrl = new OverviewURL();
        overviewUrl.setUseType("text");
        overviewUrl.setValue("http://uddi.org/pubs/uddi_v3.htm#keyGen");
        overviewDoc.setOverviewURL(overviewUrl);
        keyGenerator.getOverviewDoc().add(overviewDoc);

        CategoryBag categoryBag = new CategoryBag();
        KeyedReference keyedReference = new KeyedReference();
        keyedReference.setKeyName("uddi-org:types:keyGenerator");
        keyedReference.setKeyValue("keyGenerator");
        keyedReference.setTModelKey("uddi:uddi.org:categorization:types");
        categoryBag.getKeyedReference().add(keyedReference);
        keyGenerator.setCategoryBag(categoryBag);
        clerk.register(keyGenerator);
    }
}
