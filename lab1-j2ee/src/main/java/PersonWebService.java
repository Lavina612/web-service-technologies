import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.sql.DataSource;

@WebService(serviceName = "PersonService")
public class PersonWebService {
    @Resource(lookup = "jdbc/ifmo-ws")
    private DataSource dataSource;

    @WebMethod(operationName = "getPersons")
    public List<Person> getPersons(@WebParam(name = "idParam") String idParam,
                                   @WebParam(name = "nameParam") String nameParam,
                                   @WebParam(name = "maleParam") String maleParam,
                                   @WebParam(name = "ageParam") String ageParam,
                                   @WebParam(name = "positionParam") String positionParam) {
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
        List<Person> persons = dao.getPersons(idParam, nameParam, maleParam, ageParam, positionParam);
        return persons;
    }

    private Connection getConnection() {
        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(PersonWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}