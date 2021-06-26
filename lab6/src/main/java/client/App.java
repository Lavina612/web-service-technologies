package client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final String URL = "http://localhost:9060/rest/persons";

    public static void main(String[] args) {
        System.out.println("Hello!");
        System.out.println("What do you want to do? Enter '1', '2', '3' or '4'.");
        System.out.println("1 - Get persons;");
        System.out.println("2 - Add person;");
        System.out.println("3 - Update person;");
        System.out.println("4 - Delete person.");

        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine();
        Client client = Client.create();
        switch (action) {
            case "1":
                getPersons(client, scanner);
                break;
            case "2":
                addPerson(client, scanner);
                break;
            case "3":
                updatePerson(client, scanner);
                break;
            case "4":
                deletePerson(client, scanner);
                break;
            default:
                System.out.println("Unrecognized command. Expected only '1', '2', '3' or '4'. Try again in another time.");
        }
    }

    private static void getPersons(Client client, Scanner scanner) {
        System.out.println("Let's find some persons by parameters.");
        System.out.println("If parameter is not required leave the empty string (just type Enter).");
        String id = getParam(scanner, "Id");
        String name = getParam(scanner, "Name");
        String male = getParam(scanner, "Male (enter 'true' if male, 'false' if not)");
        String age = getParam(scanner, "Age");
        String position = getParam(scanner, "Position (click 'Enter' if this parameter is not required, or enter 'null' if position should not be set)");

        if (position != null && position.equalsIgnoreCase("null")) {
            position = "";
        }

        WebResource webResource = client.resource(URL);
        if (id != null) {
            webResource = webResource.queryParam("id", id);
        }
        if (name != null) {
            webResource = webResource.queryParam("name", name);
        }
        if (male != null) {
            webResource = webResource.queryParam("male", male);
        }
        if (age != null) {
            webResource = webResource.queryParam("age", age);
        }
        if (position != null) {
            webResource = webResource.queryParam("position", position);
        }

        ClientResponse response;
        try {
            response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        } catch(Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
            return;
        }

        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }

        GenericType<List<Person>> type = new GenericType<List<Person>>() {};
        List<Person> personList = response.getEntity(type);

        if (personList.size() != 0) {
            System.out.println("See the results:");
        } else {
            System.out.printf("Not found any person with Id = %s, Name = %s, Male = %s, Age = %s, Position = %s.\r\n",
                    id, name, male, age, position);
        }
        for (Person person : personList) {
            System.out.println(person.toString());
        }

        System.out.println("Total persons: " + personList.size());
    }

    private static void addPerson(Client client, Scanner scanner) {
        System.out.println("Let's add new person.");
        String id = getParam(scanner, "Id");
        String name = getParam(scanner, "Name");
        String male = getParam(scanner, "Male (enter 'true' if male, 'false' if not)");
        String age = getParam(scanner, "Age");
        String position = getParam(scanner, "Position (position can be skipped)");

        if (position != null && position.equalsIgnoreCase("null")) {
            position = "";
        }

        Person person = new Person(Integer.parseInt(id), name, Boolean.parseBoolean(male), Integer.parseInt(age), position);

        WebResource webResource = client.resource(URL + "/add");
        ClientResponse response;
        try {
            response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, person);
        } catch(Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
            return;
        }

        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }

        GenericType<String> type = new GenericType<String>() {};
        String newPersonId = response.getEntity(type);

        if (!newPersonId.equals("-1")) {
            System.out.println("server.Person with id = " + id + " was added successful.");
        } else {
            System.out.println("Adding person with id = " + id + " failed.");
        }
    }

    private static void updatePerson(Client client, Scanner scanner) {
        System.out.println("Let's update a person found by Id.");
        System.out.println("If parameter should not be changed leave the empty string (just type Enter).");
        String id = getParam(scanner, "Id");
        String name = getParam(scanner, "Name");
        String male = getParam(scanner, "Male (enter 'true' if male, 'false' if not)");
        String age = getParam(scanner, "Age");
        String position = getParam(scanner, "Position (click 'Enter' if this parameter should not be changed, or enter 'null' if person should not have any position)");

        if (position != null && position.equalsIgnoreCase("null")) {
            position = "";
        }
        Integer personId = id == null ? null : Integer.parseInt(id);
        Boolean personMale = male == null ? null : Boolean.parseBoolean(male);
        Integer personAge = age == null ? null : Integer.parseInt(age);
        Person person = new Person(personId, name, personMale, personAge, position);

        WebResource webResource = client.resource(URL + "/update/" + id);
        ClientResponse response;
        try {
            response = webResource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, person);
        } catch(Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
            return;
        }

        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }

        GenericType<String> type = new GenericType<String>() {};
        String result = response.getEntity(type);
        System.out.println(result);
    }

    private static void deletePerson(Client client, Scanner scanner) {
        System.out.println("Let's delete a person by Id");
        String id = getParam(scanner, "Id");

        WebResource webResource = client.resource(URL + "/delete/" + id);
        ClientResponse response;
        try {
            response = webResource.accept(MediaType.APPLICATION_JSON).delete(ClientResponse.class);
        } catch(Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
            return;
        }

        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }

        GenericType<String> type = new GenericType<String>() {};
        String result = response.getEntity(type);
        System.out.println(result);
    }

    private static String getParam(Scanner scanner, String paramName) {
        System.out.println("Enter " + paramName + ":");
        String param = scanner.nextLine();
        return param.equals("") ? null : param;
    }
}
