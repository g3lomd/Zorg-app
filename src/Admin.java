public class Admin extends User {
    private String role;

    public Admin(int id, String name, String password) {
        super(id, name, password);
        role = "Admin";

    }

    @Override
    void viewData() {
        super.viewData();


    }
    public String getRole() { return role;}
}
