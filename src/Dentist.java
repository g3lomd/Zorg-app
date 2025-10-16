public class Dentist extends User {
    private String role;

    public Dentist(int id, String name, String password) {
        super(id, name, password);
        role = "Dentist";

    }

    @Override
    void viewData() {
        super.viewData();


    }
    public String getRole() { return role;}
}
