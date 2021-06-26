import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.sql.DataSource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {
    @Resource(lookup = "jdbc/ifmo-ws")
    private DataSource dataSource;

    @GET
    public List<Person> getPersons(@QueryParam("id") String id,
                                   @QueryParam("name") String name,
                                   @QueryParam("male") String male,
                                   @QueryParam("age") String age,
                                   @QueryParam("position") String position) {
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
        List<Person> persons = dao.getPersons(id, name, male, age, position);
        return persons;
    }

    private Connection getConnection() {
        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(PersonResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}