package client;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
    private Integer id;
    private String name;
    private Boolean male;
    private Integer age;
    private String position;

    public Person() {
    }

    public Person(Integer id, String name, Boolean male, Integer age, String position) {
        this.id = id;
        this.name = name;
        this.male = male;
        this.age = age;
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getMale() {
        return male;
    }

    public Integer getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMale(Boolean male) {
        this.male = male;
    }

    public void setAge(Integer age) {
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