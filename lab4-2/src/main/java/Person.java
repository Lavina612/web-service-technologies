import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
    private int id;
    private String name;
    private boolean male;
    private int age;
    private String position;

    public Person() {
    }

    public Person(int id, String name, boolean male, int age, String position) {
        this.id = id;
        this.name = name;
        this.male = male;
        this.age = age;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean getMale() {
        return male;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Person {id = " + id + ", name = " + name + ", male = " + male + ", age = " + age + ", position = " + position + "}";
    }
}