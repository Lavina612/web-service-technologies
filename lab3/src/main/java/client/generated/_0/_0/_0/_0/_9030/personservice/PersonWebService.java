
package _0._0._0._0._9030.personservice;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PersonWebService", targetNamespace = "http://0.0.0.0:9030/PersonService")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PersonWebService {


    /**
     * 
     * @param maleParam
     * @param positionParam
     * @param idParam
     * @param ageParam
     * @param nameParam
     * @return
     *     returns java.util.List<_0._0._0._0._9030.personservice.Person>
     * @throws ParamTypeException
     * @throws NegativeParamException
     * @throws EmptyParamException
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPersons", targetNamespace = "http://0.0.0.0:9030/PersonService", className = "_0._0._0._0._9030.personservice.GetPersons")
    @ResponseWrapper(localName = "getPersonsResponse", targetNamespace = "http://0.0.0.0:9030/PersonService", className = "_0._0._0._0._9030.personservice.GetPersonsResponse")
    @Action(input = "http://0.0.0.0:9030/PersonService/PersonWebService/getPersonsRequest", output = "http://0.0.0.0:9030/PersonService/PersonWebService/getPersonsResponse", fault = {
        @FaultAction(className = ParamTypeException.class, value = "http://0.0.0.0:9030/PersonService/PersonWebService/getPersons/Fault/ParamTypeException"),
        @FaultAction(className = EmptyParamException.class, value = "http://0.0.0.0:9030/PersonService/PersonWebService/getPersons/Fault/EmptyParamException"),
        @FaultAction(className = NegativeParamException.class, value = "http://0.0.0.0:9030/PersonService/PersonWebService/getPersons/Fault/NegativeParamException")
    })
    public List<Person> getPersons(
        @WebParam(name = "idParam", targetNamespace = "")
        String idParam,
        @WebParam(name = "nameParam", targetNamespace = "")
        String nameParam,
        @WebParam(name = "maleParam", targetNamespace = "")
        String maleParam,
        @WebParam(name = "ageParam", targetNamespace = "")
        String ageParam,
        @WebParam(name = "positionParam", targetNamespace = "")
        String positionParam)
        throws EmptyParamException, NegativeParamException, ParamTypeException
    ;

    /**
     * 
     * @param maleParam
     * @param positionParam
     * @param idParam
     * @param ageParam
     * @param nameParam
     * @return
     *     returns int
     * @throws ParamTypeException
     * @throws NullParamException
     * @throws NegativeParamException
     * @throws SQLException
     * @throws EmptyParamException
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addPerson", targetNamespace = "http://0.0.0.0:9030/PersonService", className = "_0._0._0._0._9030.personservice.AddPerson")
    @ResponseWrapper(localName = "addPersonResponse", targetNamespace = "http://0.0.0.0:9030/PersonService", className = "_0._0._0._0._9030.personservice.AddPersonResponse")
    @Action(input = "http://0.0.0.0:9030/PersonService/PersonWebService/addPersonRequest", output = "http://0.0.0.0:9030/PersonService/PersonWebService/addPersonResponse", fault = {
        @FaultAction(className = ParamTypeException.class, value = "http://0.0.0.0:9030/PersonService/PersonWebService/addPerson/Fault/ParamTypeException"),
        @FaultAction(className = EmptyParamException.class, value = "http://0.0.0.0:9030/PersonService/PersonWebService/addPerson/Fault/EmptyParamException"),
        @FaultAction(className = NegativeParamException.class, value = "http://0.0.0.0:9030/PersonService/PersonWebService/addPerson/Fault/NegativeParamException"),
        @FaultAction(className = NullParamException.class, value = "http://0.0.0.0:9030/PersonService/PersonWebService/addPerson/Fault/NullParamException"),
        @FaultAction(className = SQLException.class, value = "http://0.0.0.0:9030/PersonService/PersonWebService/addPerson/Fault/SQLException")
    })
    public int addPerson(
        @WebParam(name = "idParam", targetNamespace = "")
        String idParam,
        @WebParam(name = "nameParam", targetNamespace = "")
        String nameParam,
        @WebParam(name = "maleParam", targetNamespace = "")
        String maleParam,
        @WebParam(name = "ageParam", targetNamespace = "")
        String ageParam,
        @WebParam(name = "positionParam", targetNamespace = "")
        String positionParam)
        throws EmptyParamException, NegativeParamException, NullParamException, ParamTypeException, SQLException
    ;

    /**
     * 
     * @param idParam
     * @return
     *     returns java.lang.String
     * @throws ParamTypeException
     * @throws NullParamException
     * @throws NegativeParamException
     * @throws EmptyParamException
     * @throws SQLException
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deletePerson", targetNamespace = "http://0.0.0.0:9030/PersonService", className = "_0._0._0._0._9030.personservice.DeletePerson")
    @ResponseWrapper(localName = "deletePersonResponse", targetNamespace = "http://0.0.0.0:9030/PersonService", className = "_0._0._0._0._9030.personservice.DeletePersonResponse")
    @Action(input = "http://0.0.0.0:9030/PersonService/PersonWebService/deletePersonRequest", output = "http://0.0.0.0:9030/PersonService/PersonWebService/deletePersonResponse", fault = {
        @FaultAction(className = ParamTypeException.class, value = "http://0.0.0.0:9030/PersonService/PersonWebService/deletePerson/Fault/ParamTypeException"),
        @FaultAction(className = EmptyParamException.class, value = "http://0.0.0.0:9030/PersonService/PersonWebService/deletePerson/Fault/EmptyParamException"),
        @FaultAction(className = NegativeParamException.class, value = "http://0.0.0.0:9030/PersonService/PersonWebService/deletePerson/Fault/NegativeParamException"),
        @FaultAction(className = NullParamException.class, value = "http://0.0.0.0:9030/PersonService/PersonWebService/deletePerson/Fault/NullParamException"),
        @FaultAction(className = SQLException.class, value = "http://0.0.0.0:9030/PersonService/PersonWebService/deletePerson/Fault/SQLException")
    })
    public String deletePerson(
        @WebParam(name = "idParam", targetNamespace = "")
        String idParam)
        throws EmptyParamException, NegativeParamException, NullParamException, ParamTypeException, SQLException
    ;

    /**
     * 
     * @param maleParam
     * @param positionParam
     * @param idParam
     * @param ageParam
     * @param nameParam
     * @return
     *     returns java.lang.String
     * @throws ParamTypeException
     * @throws NullParamException
     * @throws NegativeParamException
     * @throws EmptyParamException
     * @throws SQLException
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updatePerson", targetNamespace = "http://0.0.0.0:9030/PersonService", className = "_0._0._0._0._9030.personservice.UpdatePerson")
    @ResponseWrapper(localName = "updatePersonResponse", targetNamespace = "http://0.0.0.0:9030/PersonService", className = "_0._0._0._0._9030.personservice.UpdatePersonResponse")
    @Action(input = "http://0.0.0.0:9030/PersonService/PersonWebService/updatePersonRequest", output = "http://0.0.0.0:9030/PersonService/PersonWebService/updatePersonResponse", fault = {
        @FaultAction(className = ParamTypeException.class, value = "http://0.0.0.0:9030/PersonService/PersonWebService/updatePerson/Fault/ParamTypeException"),
        @FaultAction(className = EmptyParamException.class, value = "http://0.0.0.0:9030/PersonService/PersonWebService/updatePerson/Fault/EmptyParamException"),
        @FaultAction(className = NegativeParamException.class, value = "http://0.0.0.0:9030/PersonService/PersonWebService/updatePerson/Fault/NegativeParamException"),
        @FaultAction(className = NullParamException.class, value = "http://0.0.0.0:9030/PersonService/PersonWebService/updatePerson/Fault/NullParamException"),
        @FaultAction(className = SQLException.class, value = "http://0.0.0.0:9030/PersonService/PersonWebService/updatePerson/Fault/SQLException")
    })
    public String updatePerson(
        @WebParam(name = "idParam", targetNamespace = "")
        String idParam,
        @WebParam(name = "nameParam", targetNamespace = "")
        String nameParam,
        @WebParam(name = "maleParam", targetNamespace = "")
        String maleParam,
        @WebParam(name = "ageParam", targetNamespace = "")
        String ageParam,
        @WebParam(name = "positionParam", targetNamespace = "")
        String positionParam)
        throws EmptyParamException, NegativeParamException, NullParamException, ParamTypeException, SQLException
    ;

}