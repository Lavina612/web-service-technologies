
package _0._0._0._0._9020.personservice;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PersonWebService", targetNamespace = "http://0.0.0.0:9020/PersonService")
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
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addPerson", targetNamespace = "http://0.0.0.0:9020/PersonService", className = "_0._0._0._0._9020.personservice.AddPerson")
    @ResponseWrapper(localName = "addPersonResponse", targetNamespace = "http://0.0.0.0:9020/PersonService", className = "_0._0._0._0._9020.personservice.AddPersonResponse")
    @Action(input = "http://0.0.0.0:9020/PersonService/PersonWebService/addPersonRequest", output = "http://0.0.0.0:9020/PersonService/PersonWebService/addPersonResponse")
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
        String positionParam);

    /**
     * 
     * @param maleParam
     * @param positionParam
     * @param idParam
     * @param ageParam
     * @param nameParam
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updatePerson", targetNamespace = "http://0.0.0.0:9020/PersonService", className = "_0._0._0._0._9020.personservice.UpdatePerson")
    @ResponseWrapper(localName = "updatePersonResponse", targetNamespace = "http://0.0.0.0:9020/PersonService", className = "_0._0._0._0._9020.personservice.UpdatePersonResponse")
    @Action(input = "http://0.0.0.0:9020/PersonService/PersonWebService/updatePersonRequest", output = "http://0.0.0.0:9020/PersonService/PersonWebService/updatePersonResponse")
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
        String positionParam);

    /**
     * 
     * @param maleParam
     * @param positionParam
     * @param idParam
     * @param ageParam
     * @param nameParam
     * @return
     *     returns java.util.List<_0._0._0._0._9020.personservice.Person>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPersons", targetNamespace = "http://0.0.0.0:9020/PersonService", className = "_0._0._0._0._9020.personservice.GetPersons")
    @ResponseWrapper(localName = "getPersonsResponse", targetNamespace = "http://0.0.0.0:9020/PersonService", className = "_0._0._0._0._9020.personservice.GetPersonsResponse")
    @Action(input = "http://0.0.0.0:9020/PersonService/PersonWebService/getPersonsRequest", output = "http://0.0.0.0:9020/PersonService/PersonWebService/getPersonsResponse")
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
        String positionParam);

    /**
     * 
     * @param idParam
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deletePerson", targetNamespace = "http://0.0.0.0:9020/PersonService", className = "_0._0._0._0._9020.personservice.DeletePerson")
    @ResponseWrapper(localName = "deletePersonResponse", targetNamespace = "http://0.0.0.0:9020/PersonService", className = "_0._0._0._0._9020.personservice.DeletePersonResponse")
    @Action(input = "http://0.0.0.0:9020/PersonService/PersonWebService/deletePersonRequest", output = "http://0.0.0.0:9020/PersonService/PersonWebService/deletePersonResponse")
    public String deletePerson(
        @WebParam(name = "idParam", targetNamespace = "")
        String idParam);

}