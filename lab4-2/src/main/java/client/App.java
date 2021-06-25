package client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import java.util.List;
import java.util.Scanner;
import javax.ws.rs.core.MediaType;

public class App {
    private static final String URL = "http://localhost:9040/rest/persons";

    public static void main(String[] args) {
        System.out.println("Hello! Let's find some persons by parameters.\r\n" +
                "If parameter is not required leave the empty string (just type Enter).");
        Scanner scanner = new Scanner(System.in);
        String idParam = getParam(scanner, "Id");
        String nameParam = getParam(scanner, "Name");
        String maleParam = getParam(scanner, "Male (enter 'true' if male, 'false' if not)");
        String ageParam = getParam(scanner, "Age");
        String positionParam = getParam(scanner, "Position");

        Client client = Client.create();
        List<Person> personList = getAllPersons(client, idParam, nameParam, maleParam, ageParam, positionParam);

        if (personList.size() != 0) {
            System.out.println("See the results:");
            for (Person person : personList) {
                System.out.println(person.toString());
            }
        } else {
            System.out.printf("Not found any person with Id = %s, Name = %s, Male = %s, Age = %s, Position = %s.\r\n",
                    idParam, nameParam, maleParam, ageParam, positionParam);
        }

        System.out.println("Total persons: " + personList.size());
    }

    private static List<Person> getAllPersons(Client client, String id, String name, String male, String age, String position) {
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

        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        if (response.getStatus() != ClientResponse.Status.OK.getStatusCode()) {
            throw new IllegalStateException("Request failed");
        }

        GenericType<List<Person>> type = new GenericType<List<Person>>() {};
        return response.getEntity(type);
    }

    private static String getParam(Scanner scanner, String paramName) {
        System.out.println("Enter " + paramName + ":");
        String param = scanner.nextLine();
        return param.equals("") ? null : param;
    }
}
