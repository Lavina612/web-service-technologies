package juddi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class PostgreSQLDAO {
    public List<Person> getPersons() {
        List<Person> persons = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from person order by id;");
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