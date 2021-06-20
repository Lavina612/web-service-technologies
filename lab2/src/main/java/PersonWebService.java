import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "PersonService", targetNamespace = "http://0.0.0.0:9020/PersonService")
public class PersonWebService {
    @WebMethod(operationName = "getPersons")
    public List<Person> getPersons(@WebParam(name = "idParam") String idParam,
                                   @WebParam(name = "nameParam") String nameParam,
                                   @WebParam(name = "maleParam") String maleParam,
                                   @WebParam(name = "ageParam") String ageParam,
                                   @WebParam(name = "positionParam") String positionParam) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.getPersons(idParam, nameParam, maleParam, ageParam, positionParam);
    }

    @WebMethod(operationName = "addPerson")
    public int addPerson(@WebParam(name = "idParam") String idParam,
                                   @WebParam(name = "nameParam") String nameParam,
                                   @WebParam(name = "maleParam") String maleParam,
                                   @WebParam(name = "ageParam") String ageParam,
                                   @WebParam(name = "positionParam") String positionParam) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.addPerson(idParam, nameParam, maleParam, ageParam, positionParam);
    }

    @WebMethod(operationName = "updatePerson")
    public String updatePerson(@WebParam(name = "idParam") String idParam,
                         @WebParam(name = "nameParam") String nameParam,
                         @WebParam(name = "maleParam") String maleParam,
                         @WebParam(name = "ageParam") String ageParam,
                         @WebParam(name = "positionParam") String positionParam) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.updatePerson(idParam, nameParam, maleParam, ageParam, positionParam);
    }

    @WebMethod(operationName = "deletePerson")
    public String deletePerson(@WebParam(name = "idParam") String idParam) {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.deletePerson(idParam);
    }
}