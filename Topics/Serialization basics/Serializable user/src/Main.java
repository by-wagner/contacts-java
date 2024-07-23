import java.io.Serializable;

class User implements Serializable {
    private static final long serialVersionUID = 1L;

    String name;
    transient String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', password='" + password + "'}";
    }
}