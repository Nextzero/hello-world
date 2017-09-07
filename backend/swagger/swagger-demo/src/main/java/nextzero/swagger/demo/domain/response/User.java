package nextzero.swagger.demo.domain.response;


public class User {
    protected Integer id;
    protected String Name;
    protected Integer age;

    public User() {

    }

    public User(Integer id, String name, Integer age) {
        this.id = id;
        Name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
