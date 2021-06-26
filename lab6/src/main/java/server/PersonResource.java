package server;

import server.constants.*;
import server.exceptions.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.StringTokenizer;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {
    @GET
    public List<Person> getPersons(@QueryParam("id") String idParam,
                                   @QueryParam("name") String nameParam,
                                   @QueryParam("male") String maleParam,
                                   @QueryParam("age") String ageParam,
                                   @QueryParam("position") String positionParam)
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

    @POST
    @Path("/add")
    public String addPerson(@HeaderParam("authorization") String credentials, Person person)
            throws ParamTypeException, EmptyParamException, NegativeParamException, NullParamException, SQLException, AuthenticationException {
        authentication(credentials);
        String idParam = person.getId() == null ? null : String.valueOf(person.getId());
        String nameParam = person.getName();
        String maleParam = person.getMale() == null ? null : String.valueOf(person.getMale());
        String ageParam = person.getAge() == null ? null : String.valueOf(person.getAge());
        String positionParam = person.getPosition();

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
        int newPersonId = dao.addPerson(person);

        if (newPersonId == -1) {
            throw new SQLException(ResultConstants.FAIL + ": Make sure that the person with this id does not exist.");
        } else {
            return String.valueOf(Integer.valueOf(newPersonId));
        }
    }

    @PUT
    @Path("/update/{id}")
    public String updatePerson(@HeaderParam("authorization") String credentials, @PathParam("id") String id, Person person)
            throws ParamTypeException, EmptyParamException, NegativeParamException, NullParamException, SQLException, AuthenticationException {
        authentication(credentials);
        String idParam = person.getId() == null ? null : String.valueOf(person.getId());
        String nameParam = person.getName();
        String maleParam = person.getMale() == null ? null : String.valueOf(person.getMale());
        String ageParam = person.getAge() == null ? null : String.valueOf(person.getAge());

        checkIdParamOnNull(id);
        checkIdParamOnEmpty(id);
        int idPathParam = checkIdParamOnNumber(id);
        checkIdParamOnPositive(idParam, idPathParam);

        checkIdParamOnNull(idParam);
        checkIdParamOnEmpty(idParam);
        int personId = checkIdParamOnNumber(idParam);
        checkIdParamOnPositive(idParam, personId);

        checkNameParamOnEmpty(nameParam);

        checkMaleParamOnEmpty(maleParam);
        checkMaleParamOnBoolean(maleParam);

        checkAgeParamOnEmpty(ageParam);
        int age = checkAgeParamOnNumber(ageParam);
        checkAgeParamOnPositive(ageParam, age);

        PostgreSQLDAO dao = new PostgreSQLDAO();
        String result = dao.updatePerson(id, person);

        if (result.equals(ResultConstants.FAIL)) {
            throw new SQLException(ResultConstants.FAIL + ": Make sure that the person with this id exists.");
        } else {
            return result;
        }
    }

    @DELETE
    @Path("/delete/{id}")
    public String deletePerson(@HeaderParam("authorization") String credentials, @PathParam("id") String idPathParam)
            throws ParamTypeException, EmptyParamException, NegativeParamException, NullParamException, SQLException, AuthenticationException {
        authentication(credentials);
        checkIdParamOnNull(idPathParam);
        checkIdParamOnEmpty(idPathParam);
        int id = checkIdParamOnNumber(idPathParam);
        checkIdParamOnPositive(idPathParam, id);

        PostgreSQLDAO dao = new PostgreSQLDAO();
        String result = dao.deletePerson(idPathParam);

        if (result.equals(ResultConstants.FAIL)) {
            throw new SQLException(ResultConstants.FAIL + ": Make sure that the person with this id exists.");
        } else {
            return result;
        }
    }

    private void authentication(String authenticationString) throws AuthenticationException {
        if (authenticationString == null)
            throw AuthenticationException.DEFAULT_INSTANCE;

        final String credentials = authenticationString.replaceFirst("Basic ", "");
        String usernameAndPassword;
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(credentials);
            usernameAndPassword = new String(decodedBytes, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        final StringTokenizer tokenizer = new StringTokenizer(credentials, ":");
        final String username = tokenizer.nextToken();
        final String password = tokenizer.nextToken();

        if (!username.equals("user") || !password.equals("pswd")) {
            throw AuthenticationException.DEFAULT_INSTANCE;
        }
    }

    private void checkIdParamOnNull(String idParam) throws NullParamException {
        if (idParam == null) {
            throw new NullParamException("idParam should not be null.");
        }
    }

    private void checkIdParamOnEmpty(String idParam) throws EmptyParamException {
        if (idParam != null && idParam.trim().equals("")) {
            throw new EmptyParamException("idParam should not be empty.");
        }
    }

    private int checkIdParamOnNumber(String idParam) throws ParamTypeException {
        int id = 0;
        try {
            if (idParam != null) {
                id = Integer.parseInt(idParam);
            }
        } catch(Exception ex) {
            throw new ParamTypeException("idParam should be a number.");
        }

        return id;
    }

    private void checkIdParamOnPositive(String idParam, int id) throws NegativeParamException {
        if (idParam != null && id <= 0) {
            throw new NegativeParamException("idParam should be positive.");
        }
    }

    private void checkNameParamOnNull(String nameParam) throws NullParamException {
        if (nameParam == null) {
            throw new NullParamException("nameParam should not be null.");
        }
    }

    private void checkNameParamOnEmpty(String nameParam) throws EmptyParamException {
        if (nameParam != null && nameParam.trim().equals("")) {
            throw new EmptyParamException("nameParam should not be empty.");
        }
    }

    private void checkMaleParamOnNull(String maleParam) throws NullParamException {
        if (maleParam == null) {
            throw new NullParamException("maleParam should not be null.");
        }
    }

    private void checkMaleParamOnEmpty(String maleParam) throws EmptyParamException {
        if (maleParam != null && maleParam.trim().equals("")) {
            throw new EmptyParamException("maleParam should not be empty.");
        }
    }

    private void checkMaleParamOnBoolean(String maleParam) throws ParamTypeException {
        if (maleParam != null && !maleParam.equalsIgnoreCase(BooleanConstants.TRUE) && !maleParam.equalsIgnoreCase(BooleanConstants.FALSE)) {
            throw new ParamTypeException("maleParam should be boolean: only 'true' or 'false'.");
        }
    }

    private void checkAgeParamOnNull(String ageParam) throws NullParamException {
        if (ageParam == null) {
            throw new NullParamException("ageParam should not be null.");
        }
    }

    private void checkAgeParamOnEmpty(String ageParam) throws EmptyParamException {
        if (ageParam != null && ageParam.trim().equals("")) {
            throw new EmptyParamException("ageParam should not be empty.");
        }
    }

    private int checkAgeParamOnNumber(String ageParam) throws ParamTypeException {
        int age = 0;
        try {
            if (ageParam != null) {
                age = Integer.parseInt(ageParam);
            }
        } catch(Exception ex) {
            throw new ParamTypeException("ageParam should be a number.");
        }

        return age;
    }

    private void checkAgeParamOnPositive (String ageParam, int age) throws NegativeParamException {
        if (ageParam != null && age <= 0) {
            throw new NegativeParamException("ageParam should be positive.");
        }
    }

    private void checkPositionParamOnEmpty(String positionParam) throws EmptyParamException {
        if (positionParam != null && positionParam.trim().equals("")) {
            throw new EmptyParamException("positionParam should not be empty.");
        }
    }
}