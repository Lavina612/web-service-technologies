import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {
    @GET
    public List<Person> getPersons(@QueryParam("id") String id,
                                   @QueryParam("name") String name,
                                   @QueryParam("male") String male,
                                   @QueryParam("age") String age,
                                   @QueryParam("position") String position) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.getPersons(id, name, male, age, position);
    }

    @POST
    @Path("/add")
    public String addPerson(Person person) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return String.valueOf(Integer.valueOf(dao.addPerson(person)));
    }

    @PUT
    @Path("/update/{id}")
    public String updatePerson(@PathParam("id") String id, Person person) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.updatePerson(id, person);
    }

    @DELETE
    @Path("/delete/{id}")
    public String deletePerson(@PathParam("id") String id) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.deletePerson(id);
    }
}