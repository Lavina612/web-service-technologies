import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {
    @GET
    public List<Person> getPersons(@QueryParam("id") String id,
                                   @QueryParam("name") String name,
                                   @QueryParam("male") String male,
                                   @QueryParam("age") String age,
                                   @QueryParam("position") String position) {
        List<Person> persons = new PostgreSQLDAO().getPersons(id, name, male, age, position);
        return persons;
    }
}