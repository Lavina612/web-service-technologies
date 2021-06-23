
package _0._0._0._0._9030.personservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the _0._0._0._0._9030.personservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetPersons_QNAME = new QName("http://0.0.0.0:9030/PersonService", "getPersons");
    private final static QName _ParamTypeException_QNAME = new QName("http://0.0.0.0:9030/PersonService", "ParamTypeException");
    private final static QName _UpdatePersonResponse_QNAME = new QName("http://0.0.0.0:9030/PersonService", "updatePersonResponse");
    private final static QName _DeletePersonResponse_QNAME = new QName("http://0.0.0.0:9030/PersonService", "deletePersonResponse");
    private final static QName _UpdatePerson_QNAME = new QName("http://0.0.0.0:9030/PersonService", "updatePerson");
    private final static QName _SQLException_QNAME = new QName("http://0.0.0.0:9030/PersonService", "SQLException");
    private final static QName _NullParamException_QNAME = new QName("http://0.0.0.0:9030/PersonService", "NullParamException");
    private final static QName _GetPersonsResponse_QNAME = new QName("http://0.0.0.0:9030/PersonService", "getPersonsResponse");
    private final static QName _NegativeParamException_QNAME = new QName("http://0.0.0.0:9030/PersonService", "NegativeParamException");
    private final static QName _AddPersonResponse_QNAME = new QName("http://0.0.0.0:9030/PersonService", "addPersonResponse");
    private final static QName _DeletePerson_QNAME = new QName("http://0.0.0.0:9030/PersonService", "deletePerson");
    private final static QName _AddPerson_QNAME = new QName("http://0.0.0.0:9030/PersonService", "addPerson");
    private final static QName _EmptyParamException_QNAME = new QName("http://0.0.0.0:9030/PersonService", "EmptyParamException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: _0._0._0._0._9030.personservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddPersonResponse }
     * 
     */
    public AddPersonResponse createAddPersonResponse() {
        return new AddPersonResponse();
    }

    /**
     * Create an instance of {@link DeletePerson }
     * 
     */
    public DeletePerson createDeletePerson() {
        return new DeletePerson();
    }

    /**
     * Create an instance of {@link NegativeParamFault }
     * 
     */
    public NegativeParamFault createNegativeParamFault() {
        return new NegativeParamFault();
    }

    /**
     * Create an instance of {@link SqlFault }
     * 
     */
    public SqlFault createSqlFault() {
        return new SqlFault();
    }

    /**
     * Create an instance of {@link NullParamFault }
     * 
     */
    public NullParamFault createNullParamFault() {
        return new NullParamFault();
    }

    /**
     * Create an instance of {@link GetPersonsResponse }
     * 
     */
    public GetPersonsResponse createGetPersonsResponse() {
        return new GetPersonsResponse();
    }

    /**
     * Create an instance of {@link EmptyParamFault }
     * 
     */
    public EmptyParamFault createEmptyParamFault() {
        return new EmptyParamFault();
    }

    /**
     * Create an instance of {@link AddPerson }
     * 
     */
    public AddPerson createAddPerson() {
        return new AddPerson();
    }

    /**
     * Create an instance of {@link ParamTypeFault }
     * 
     */
    public ParamTypeFault createParamTypeFault() {
        return new ParamTypeFault();
    }

    /**
     * Create an instance of {@link UpdatePersonResponse }
     * 
     */
    public UpdatePersonResponse createUpdatePersonResponse() {
        return new UpdatePersonResponse();
    }

    /**
     * Create an instance of {@link DeletePersonResponse }
     * 
     */
    public DeletePersonResponse createDeletePersonResponse() {
        return new DeletePersonResponse();
    }

    /**
     * Create an instance of {@link GetPersons }
     * 
     */
    public GetPersons createGetPersons() {
        return new GetPersons();
    }

    /**
     * Create an instance of {@link UpdatePerson }
     * 
     */
    public UpdatePerson createUpdatePerson() {
        return new UpdatePerson();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersons }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://0.0.0.0:9030/PersonService", name = "getPersons")
    public JAXBElement<GetPersons> createGetPersons(GetPersons value) {
        return new JAXBElement<GetPersons>(_GetPersons_QNAME, GetPersons.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParamTypeFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://0.0.0.0:9030/PersonService", name = "ParamTypeException")
    public JAXBElement<ParamTypeFault> createParamTypeException(ParamTypeFault value) {
        return new JAXBElement<ParamTypeFault>(_ParamTypeException_QNAME, ParamTypeFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://0.0.0.0:9030/PersonService", name = "updatePersonResponse")
    public JAXBElement<UpdatePersonResponse> createUpdatePersonResponse(UpdatePersonResponse value) {
        return new JAXBElement<UpdatePersonResponse>(_UpdatePersonResponse_QNAME, UpdatePersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://0.0.0.0:9030/PersonService", name = "deletePersonResponse")
    public JAXBElement<DeletePersonResponse> createDeletePersonResponse(DeletePersonResponse value) {
        return new JAXBElement<DeletePersonResponse>(_DeletePersonResponse_QNAME, DeletePersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://0.0.0.0:9030/PersonService", name = "updatePerson")
    public JAXBElement<UpdatePerson> createUpdatePerson(UpdatePerson value) {
        return new JAXBElement<UpdatePerson>(_UpdatePerson_QNAME, UpdatePerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SqlFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://0.0.0.0:9030/PersonService", name = "SQLException")
    public JAXBElement<SqlFault> createSQLException(SqlFault value) {
        return new JAXBElement<SqlFault>(_SQLException_QNAME, SqlFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NullParamFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://0.0.0.0:9030/PersonService", name = "NullParamException")
    public JAXBElement<NullParamFault> createNullParamException(NullParamFault value) {
        return new JAXBElement<NullParamFault>(_NullParamException_QNAME, NullParamFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://0.0.0.0:9030/PersonService", name = "getPersonsResponse")
    public JAXBElement<GetPersonsResponse> createGetPersonsResponse(GetPersonsResponse value) {
        return new JAXBElement<GetPersonsResponse>(_GetPersonsResponse_QNAME, GetPersonsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NegativeParamFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://0.0.0.0:9030/PersonService", name = "NegativeParamException")
    public JAXBElement<NegativeParamFault> createNegativeParamException(NegativeParamFault value) {
        return new JAXBElement<NegativeParamFault>(_NegativeParamException_QNAME, NegativeParamFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://0.0.0.0:9030/PersonService", name = "addPersonResponse")
    public JAXBElement<AddPersonResponse> createAddPersonResponse(AddPersonResponse value) {
        return new JAXBElement<AddPersonResponse>(_AddPersonResponse_QNAME, AddPersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeletePerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://0.0.0.0:9030/PersonService", name = "deletePerson")
    public JAXBElement<DeletePerson> createDeletePerson(DeletePerson value) {
        return new JAXBElement<DeletePerson>(_DeletePerson_QNAME, DeletePerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://0.0.0.0:9030/PersonService", name = "addPerson")
    public JAXBElement<AddPerson> createAddPerson(AddPerson value) {
        return new JAXBElement<AddPerson>(_AddPerson_QNAME, AddPerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmptyParamFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://0.0.0.0:9030/PersonService", name = "EmptyParamException")
    public JAXBElement<EmptyParamFault> createEmptyParamException(EmptyParamFault value) {
        return new JAXBElement<EmptyParamFault>(_EmptyParamException_QNAME, EmptyParamFault.class, null, value);
    }

}
