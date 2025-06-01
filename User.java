public class User {
    private String name;
    private String email;
    private String phone;
    private String password;

    public User(String name, String email, String phone, String password) {
        if (name == null || email == null || phone == null || password == null) {
            throw new IllegalArgumentException("Name, email, phone, and password cannot be null");
        }
        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("Name, email, phone, and password cannot be empty");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Email must contain '@'");
        }
        if (phone.length() < 10) {
            throw new IllegalArgumentException("Phone number must be at least 10 digits");
        }
        this.password = password;
        if (password.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long");
        }
        if (!phone.matches("\\d+")) {
            throw new IllegalArgumentException("Phone number must contain only digits");
        }
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Email format is invalid");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException("Name must be at least 3 characters long");
        }
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getPhone(){
        return phone;
    }
    public String getPassword() {
        return password;
    }
}
