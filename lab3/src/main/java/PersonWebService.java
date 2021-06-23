import constants.BooleanConstants;
import constants.ResultConstants;
import exceptions.*;
import faults.*;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "PersonService", targetNamespace = "http://0.0.0.0:9030/PersonService")
public class PersonWebService {
    @WebMethod(operationName = "getPersons")
    public List<Person> getPersons(@WebParam(name = "idParam") String idParam,
                                   @WebParam(name = "nameParam") String nameParam,
                                   @WebParam(name = "maleParam") String maleParam,
                                   @WebParam(name = "ageParam") String ageParam,
                                   @WebParam(name = "positionParam") String positionParam)
            throws ParamTypeException, EmptyParamException, NegativeParamException {
        checkIdParamOnEmpty(idParam);
        int id = checkIdParamOnNumber(idParam);
        checkIdParamOnPositive(idParam, id);

        checkNameParamOnEmpty(nameParam);

        checkMaleParamOnEmpty(maleParam);
        checkMaleParamOnBoolean(maleParam);

        checkAgeParamOnEmpty(ageParam);
        int age = checkAgeParamOnNumber(ageParam);
        checkAgeParamOnPositive(ageParam, age);

        PostgreSQLDAO dao = new PostgreSQLDAO();
        return dao.getPersons(idParam, nameParam, maleParam, ageParam, positionParam);
    }

    @WebMethod(operationName = "addPerson")
    public int addPerson(@WebParam(name = "idParam") String idParam,
                                   @WebParam(name = "nameParam") String nameParam,
                                   @WebParam(name = "maleParam") String maleParam,
                                   @WebParam(name = "ageParam") String ageParam,
                                   @WebParam(name = "positionParam") String positionParam)
            throws ParamTypeException, EmptyParamException, NegativeParamException, NullParamException, SQLException {
        checkIdParamOnNull(idParam);
        checkIdParamOnEmpty(idParam);
        int id = checkIdParamOnNumber(idParam);
        checkIdParamOnPositive(idParam, id);

        checkNameParamOnNull(nameParam);
        checkNameParamOnEmpty(nameParam);

        checkMaleParamOnNull(maleParam);
        checkMaleParamOnEmpty(maleParam);
        checkMaleParamOnBoolean(maleParam);

        checkAgeParamOnNull(ageParam);
        checkAgeParamOnEmpty(ageParam);
        int age = checkAgeParamOnNumber(ageParam);
        checkAgeParamOnPositive(ageParam, age);

        checkPositionParamOnEmpty(positionParam);

        PostgreSQLDAO dao = new PostgreSQLDAO();
        int newPersonId = dao.addPerson(idParam, nameParam, maleParam, ageParam, positionParam);

        if (newPersonId == -1) {
            SQLFault sqlf = SQLFault.defaultInstance();
            throw new SQLException(ResultConstants.FAIL + ": Make sure that the person with this id does not exist.", sqlf);
        } else {
            return newPersonId;
        }
    }

    @WebMethod(operationName = "updatePerson")
    public String updatePerson(@WebParam(name = "idParam") String idParam,
                         @WebParam(name = "nameParam") String nameParam,
                         @WebParam(name = "maleParam") String maleParam,
                         @WebParam(name = "ageParam") String ageParam,
                         @WebParam(name = "positionParam") String positionParam)
            throws ParamTypeException, EmptyParamException, NegativeParamException, NullParamException, SQLException {
        checkIdParamOnNull(idParam);
        checkIdParamOnEmpty(idParam);
        int id = checkIdParamOnNumber(idParam);
        checkIdParamOnPositive(idParam, id);

        checkNameParamOnEmpty(nameParam);

        checkMaleParamOnEmpty(maleParam);
        checkMaleParamOnBoolean(maleParam);

        checkAgeParamOnEmpty(ageParam);
        int age = checkAgeParamOnNumber(ageParam);
        checkAgeParamOnPositive(ageParam, age);

        PostgreSQLDAO dao = new PostgreSQLDAO();
        String result = dao.updatePerson(idParam, nameParam, maleParam, ageParam, positionParam);

        if (result.equals(ResultConstants.FAIL)) {
            SQLFault sqlf = SQLFault.defaultInstance();
            throw new SQLException(ResultConstants.FAIL + ": Make sure that the person with this id exists.", sqlf);
        } else {
            return result;
        }
    }

    @WebMethod(operationName = "deletePerson")
    public String deletePerson(@WebParam(name = "idParam") String idParam)
            throws ParamTypeException, EmptyParamException, NegativeParamException, NullParamException, SQLException {
        checkIdParamOnNull(idParam);
        checkIdParamOnEmpty(idParam);
        int id = checkIdParamOnNumber(idParam);
        checkIdParamOnPositive(idParam, id);

        PostgreSQLDAO dao = new PostgreSQLDAO();
        String result = dao.deletePerson(idParam);

        if (result.equals(ResultConstants.FAIL)) {
            SQLFault sqlf = SQLFault.defaultInstance();
            throw new SQLException(ResultConstants.FAIL + ": Make sure that the person with this id exists.", sqlf);
        } else {
            return result;
        }
    }

    private void checkIdParamOnNull(String idParam) throws NullParamException {
        if (idParam == null) {
            NullParamFault npf = NullParamFault.defaultInstance();
            throw new NullParamException("idParam should not be null.", npf);
        }
    }

    private void checkIdParamOnEmpty(String idParam) throws EmptyParamException {
        if (idParam != null && idParam.trim().equals("")) {
            EmptyParamFault epf = EmptyParamFault.defaultInstance();
            throw new EmptyParamException("idParam should not be empty.", epf);
        }
    }

    private int checkIdParamOnNumber(String idParam) throws ParamTypeException {
        int id = 0;
        try {
            if (idParam != null) {
                id = Integer.parseInt(idParam);
            }
        } catch(Exception ex) {
            ParamTypeFault ptf = ParamTypeFault.defaultInstance();
            throw new ParamTypeException("idParam should be a number.", ptf);
        }

        return id;
    }

    private void checkIdParamOnPositive(String idParam, int id) throws NegativeParamException {
        if (idParam != null && id <= 0) {
            NegativeParamFault ptf = NegativeParamFault.defaultInstance();
            throw new NegativeParamException("idParam should be positive.", ptf);
        }
    }

    private void checkNameParamOnNull(String nameParam) throws NullParamException {
        if (nameParam == null) {
            NullParamFault npf = NullParamFault.defaultInstance();
            throw new NullParamException("nameParam should not be null.", npf);
        }
    }

    private void checkNameParamOnEmpty(String nameParam) throws EmptyParamException {
        if (nameParam != null && nameParam.trim().equals("")) {
            EmptyParamFault epf = EmptyParamFault.defaultInstance();
            throw new EmptyParamException("nameParam should not be empty.", epf);
        }
    }

    private void checkMaleParamOnNull(String maleParam) throws NullParamException {
        if (maleParam == null) {
            NullParamFault npf = NullParamFault.defaultInstance();
            throw new NullParamException("maleParam should not be null.", npf);
        }
    }

    private void checkMaleParamOnEmpty(String maleParam) throws EmptyParamException {
        if (maleParam != null && maleParam.trim().equals("")) {
            EmptyParamFault epf = EmptyParamFault.defaultInstance();
            throw new EmptyParamException("maleParam should not be empty.", epf);
        }
    }

    private void checkMaleParamOnBoolean(String maleParam) throws ParamTypeException {
        if (maleParam != null && !maleParam.equalsIgnoreCase(BooleanConstants.TRUE) && !maleParam.equalsIgnoreCase(BooleanConstants.FALSE)) {
            ParamTypeFault ptf = ParamTypeFault.defaultInstance();
            throw new ParamTypeException("maleParam should be boolean: only 'true' or 'false'.", ptf);
        }
    }

    private void checkAgeParamOnNull(String ageParam) throws NullParamException {
        if (ageParam == null) {
            NullParamFault npf = NullParamFault.defaultInstance();
            throw new NullParamException("ageParam should not be null.", npf);
        }
    }

    private void checkAgeParamOnEmpty(String ageParam) throws EmptyParamException {
        if (ageParam != null && ageParam.trim().equals("")) {
            EmptyParamFault epf = EmptyParamFault.defaultInstance();
            throw new EmptyParamException("ageParam should not be empty.", epf);
        }
    }

    private int checkAgeParamOnNumber(String ageParam) throws ParamTypeException {
        int age = 0;
        try {
            if (ageParam != null) {
                age = Integer.parseInt(ageParam);
            }
        } catch(Exception ex) {
            ParamTypeFault ptf = ParamTypeFault.defaultInstance();
            throw new ParamTypeException("ageParam should be a number.", ptf);
        }

        return age;
    }

    private void checkAgeParamOnPositive (String ageParam, int age) throws NegativeParamException {
        if (ageParam != null && age <= 0) {
            NegativeParamFault ptf = NegativeParamFault.defaultInstance();
            throw new NegativeParamException("ageParam should be positive.", ptf);
        }
    }

    private void checkPositionParamOnEmpty(String positionParam) throws EmptyParamException {
        if (positionParam != null && positionParam.trim().equals("")) {
            EmptyParamFault epf = EmptyParamFault.defaultInstance();
            throw new EmptyParamException("positionParam should not be empty.", epf);
        }
    }
}