import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "PersonService", targetNamespace = "http://0.0.0.0:9000/PersonService")
public class PersonWebService {
    @WebMethod(operationName = "getPersons")
    public List<Person> getPersons(@WebParam(name = "idParam") String idParam,
                                   @WebParam(name = "nameParam") String nameParam,
                                   @WebParam(name = "maleParam") String maleParam,
                                   @WebParam(name = "ageParam") String ageParam,
                                   @WebParam(name = "positionParam") String positionParam) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        List<Person> persons = dao.getPersons(idParam, nameParam, maleParam, ageParam, positionParam);
        return persons;
    }
}