import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreSQLDAO {
    public List<Person> getPersons(String idParam,
                                   String nameParam,
                                   String maleParam,
                                   String ageParam,
                                   String positionParam) {
        List<Person> persons = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(
                    "select * from person where (? is null or id = ? :: integer) " +
                            "and (? is null or name = ?) " +
                            "and (? is null or male = ? :: boolean) " +
                            "and (? is null or age = ? :: integer) " +
                            "and (? is null or position = ?) ");
            statement.setString(1, idParam);
            statement.setString(2, idParam);
            statement.setString(3, nameParam);
            statement.setString(4, nameParam);
            statement.setString(5, maleParam);
            statement.setString(6, maleParam);
            statement.setString(7, ageParam);
            statement.setString(8, ageParam);
            statement.setString(9, positionParam);
            statement.setString(10, positionParam);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                boolean male = rs.getBoolean("male");
                int age = rs.getInt("age");
                String position = rs.getString("position");

                Person person = new Person(id, name, male, age, position);
                persons.add(person);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return persons;
    }
}