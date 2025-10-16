import java.time.LocalDate;
import java.util.Scanner;

class User {
    private final String userName;
    private int userID;
    private String password;
    private String role;

    // Constructor
    public User(int id, String name, String password) {
        this.userID = id;
        this.userName = name;
        this.password = password;


    }
    /**
     * Display patient data.
     */
    void viewData() {
        System.out.format("===== Patient id=%d ==============================\n", Administration.getCurrentPatient().getPatientID());
        System.out.format("%-17s %s\n", "Surname:", Administration.getCurrentPatient().getSurname());
        System.out.format("%-17s %s\n", "firstName:", Administration.getCurrentPatient().getFirstName());
        System.out.format("%-17s %s\n", "Date of birth:", Administration.getCurrentPatient().getDateOfBirth());


        if (Administration.getCurrentPatient().getMeds().isEmpty()){
            System.out.println("No medications assigned");
        } else {
            System.out.println("Medications:");

            for (var entry : Administration.getCurrentPatient().getMeds().entrySet()) {
                System.out.format("  %s: %.2f\n", entry.getKey(), entry.getValue());
            }
        }
    }
    void editPatient(){
        System.out.println("===| EDIT PATIENT |===");
        var scanner = new Scanner(System.in);

        System.out.println("First name:\t"); //Nieuwe firstname
        String newFirstName = scanner.nextLine(); if (newFirstName.isEmpty()){ // Niet ingevuld, dan huidige naam
            newFirstName = Administration.getCurrentPatient().getFirstName();
        }
        else{
            Administration.getCurrentPatient().setFirstName(newFirstName);
        }


        System.out.println("Surname:\t"); //Nieuwe surname
        String newSurname = scanner.nextLine(); if (newSurname.isEmpty()) {
            newSurname = Administration.getCurrentPatient().getSurname();
        }
        else{
            Administration.getCurrentPatient().setSurname(newSurname);
        }

        System.out.println("DateOfBirth (yyyy-mm-dd): "); // Nieuwe dateOfBirth
        String newDateOfBirthScan = scanner.nextLine();
        LocalDate newDateOfBirth;
        if (newDateOfBirthScan.isEmpty()){
            newDateOfBirth = Administration.getCurrentPatient().getDateOfBirth();
        }
        else {newDateOfBirth = LocalDate.parse(newDateOfBirthScan);
            Administration.getCurrentPatient().setDateOfBirth(newDateOfBirth);
        }
        System.out.println("LungCapacity:");//ToDo


        System.out.println("Medication name:\t");
        String medName = scanner.nextLine();
        System.out.println("Medication dose:\t");
        String medDosis = scanner.nextLine();

        if (medDosis.isEmpty() || medDosis.equals("0")) {
            System.out.println("Geen dosis ingevoerd of dosis is 0 — medicatie niet aangepast.");
        } else if (!medName.isEmpty()) {
            Administration.getCurrentPatient().addMed(medName, Double.parseDouble(medDosis));
        }

        else if (!medName.isEmpty() && !medDosis.isEmpty())       {
            Administration.getCurrentPatient().addMed(medName,Double.parseDouble(medDosis));
        }

    }


    String getUserName() {
        return userName;
    }

    int getUserID() {
        return userID;
    }
    public String getRole() { return role;}
    public String getPassword(){
        return password;
    }
}
