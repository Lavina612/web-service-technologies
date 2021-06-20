import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class WebServiceClient {
    public static void main(String[] args) throws MalformedURLException {
        System.out.println("Hello! Let's find some persons by parameters.\r\n" +
                "If parameter is not required leave the empty string (just type Enter).");
        Scanner scanner = new Scanner(System.in);
        String idParam = getParam(scanner, "Id");
        String nameParam = getParam(scanner, "Name");
        String maleParam = getParam(scanner, "Male (enter 'true' if male, 'false' if not)");
        String ageParam = getParam(scanner, "Age");
        String positionParam = getParam(scanner, "Position");

        URL url = new URL("http://localhost:9000/PersonService?wsdl");
        _0._0._0._0._9000.personservice.PersonService personService = new _0._0._0._0._9000.personservice.PersonService(url);
        List<_0._0._0._0._9000.personservice.Person> persons = personService.getPersonWebServicePort().getPersons(idParam, nameParam, maleParam, ageParam, positionParam);

        if (persons.size() != 0) {
            System.out.println("See the results:");
        } else {
            System.out.printf("Not found any person with Id = %s, Name = %s, Male = %s, Age = %s, Position = %s.\r\n",
                    idParam, nameParam, maleParam, ageParam, positionParam);
        }
        for (_0._0._0._0._9000.personservice.Person person : persons) {
            System.out.println("Person {id = " + person.getId() + ", name = " + person.getName()
                    + ", male = " + person.isMale() + ", age = " + person.getAge() + ", position = " + person.getPosition() + "}");
        }

        System.out.println("Total persons: " + persons.size());
    }

    private static String getParam(Scanner scanner, String paramName) {
        System.out.println("Enter " + paramName + ":");
        String param = scanner.nextLine();
        return param.equals("") ? null : param;
    }
}