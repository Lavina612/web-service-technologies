package client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class WebServiceClient {
    public static void main(String[] args)
            throws MalformedURLException,
            _0._0._0._0._9030.personservice.EmptyParamException,
            _0._0._0._0._9030.personservice.NegativeParamException,
            _0._0._0._0._9030.personservice.NullParamException,
            _0._0._0._0._9030.personservice.ParamTypeException,
            _0._0._0._0._9030.personservice.SQLException {
        System.out.println("Hello!");
        System.out.println("What do you want to do? Enter '1', '2', '3' or '4'.");
        System.out.println("1 - Get persons;");
        System.out.println("2 - Add person;");
        System.out.println("3 - Update person;");
        System.out.println("4 - Delete person.");

        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine();
        URL url = new URL("http://localhost:9030/PersonService?wsdl");
        _0._0._0._0._9030.personservice.PersonService personService = new _0._0._0._0._9030.personservice.PersonService(url);
        switch (action) {
            case "1":
                getPersons(scanner, personService);
                break;
            case "2":
                addPerson(scanner, personService);
                break;
            case "3":
                updatePerson(scanner, personService);
                break;
            case "4":
                deletePerson(scanner, personService);
                break;
            default:
                System.out.println("Unrecognized command. Expected only '1', '2', '3' or '4'. Try again in another time.");
        }
    }

    private static void getPersons(Scanner scanner, _0._0._0._0._9030.personservice.PersonService personService) {
        System.out.println("Let's find some persons by parameters.");
        System.out.println("If parameter is not required leave the empty string (just type Enter).");
        String idParam = getParam(scanner, "Id");
        String nameParam = getParam(scanner, "Name");
        String maleParam = getParam(scanner, "Male (enter 'true' if male, 'false' if not)");
        String ageParam = getParam(scanner, "Age");
        String positionParam = getParam(scanner, "Position (click 'Enter' if this parameter is not required, or enter 'null' if position should not be set)");

        if (positionParam != null && positionParam.equalsIgnoreCase("null")) {
            positionParam = "";
        }

        List<_0._0._0._0._9030.personservice.Person> persons;
        try {
            persons = personService.getPersonWebServicePort().getPersons(idParam, nameParam, maleParam, ageParam, positionParam);
        } catch(Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
            return;
        }

        if (persons.size() != 0) {
            System.out.println("See the results:");
        } else {
            System.out.printf("Not found any person with Id = %s, Name = %s, Male = %s, Age = %s, Position = %s.\r\n",
                    idParam, nameParam, maleParam, ageParam, positionParam);
        }
        for (_0._0._0._0._9030.personservice.Person person : persons) {
            System.out.println("Person {id = " + person.getId() + ", name = " + person.getName()
                    + ", male = " + person.isMale() + ", age = " + person.getAge() + ", position = " + person.getPosition() + "}");
        }

        System.out.println("Total persons: " + persons.size());
    }

    private static void addPerson(Scanner scanner, _0._0._0._0._9030.personservice.PersonService personService) {
        System.out.println("Let's add new person. Only Position parameter can be skipped.");
        String idParam = getParam(scanner, "Id");
        String nameParam = getParam(scanner, "Name");
        String maleParam = getParam(scanner, "Male (enter 'true' if male, 'false' if not)");
        String ageParam = getParam(scanner, "Age");
        String positionParam = getParam(scanner, "Position (position can be skipped)");

        if (positionParam != null && positionParam.equalsIgnoreCase("null")) {
            positionParam = "";
        }

        int id;
        try {
            id = personService.getPersonWebServicePort().addPerson(idParam, nameParam, maleParam, ageParam, positionParam);
        } catch(Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
            return;
        }

        if (id != -1) {
            System.out.println("Person with id = " + id + " was added successful.");
        } else {
            System.out.println("Adding person with id = " + id + " failed.");
        }
    }

    private static void updatePerson(Scanner scanner, _0._0._0._0._9030.personservice.PersonService personService) {
        System.out.println("Let's update a person found by Id.");
        System.out.println("If parameter should not be changed leave the empty string (just type Enter).");
        String idParam = getParam(scanner, "Id");
        String nameParam = getParam(scanner, "Name");
        String maleParam = getParam(scanner, "Male (enter 'true' if male, 'false' if not)");
        String ageParam = getParam(scanner, "Age");
        String positionParam = getParam(scanner, "Position (click 'Enter' if this parameter should not be changed, or enter 'null' if person should not have any position)");

        if (positionParam != null && positionParam.equalsIgnoreCase("null")) {
            positionParam = "";
        }

        String result;
        try {
            result = personService.getPersonWebServicePort().updatePerson(idParam, nameParam, maleParam, ageParam, positionParam);
        } catch(Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
            return;
        }

        System.out.println(result);
    }

    private static void deletePerson(Scanner scanner, _0._0._0._0._9030.personservice.PersonService personService) {
        System.out.println("Let's delete a person by Id");
        String idParam = getParam(scanner, "Id");

        String result;
        try {
            result = personService.getPersonWebServicePort().deletePerson(idParam);
        } catch(Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
            return;
        }

        System.out.println(result);
    }

    private static String getParam(Scanner scanner, String paramName) {
        System.out.println("Enter " + paramName + ":");
        String param = scanner.nextLine();
        return param.equals("") ? null : param;
    }
}