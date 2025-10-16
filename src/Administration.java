import java.lang.classfile.PseudoInstruction;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * class Administration represents the core of the application by showing
 * the main menu, from where all other functionality is accessible, either
 * directly or via sub-menus.
 * An Administration instance needs a User as input, which is passed via the
 * constructor to the data member 'currentUser'.
 * The patient data is available via the data member currentPatient.
 */
class Administration {
    private static final int STOP = 0;
    private static final int VIEW = 1;
    private static final int ADD = 2;
    private static final int SEARCH = 3;
    private static final int EDIT = 4;


    private ArrayList<Patient> PatientsArray = new ArrayList<>();
    private static Patient currentPatient;            // The currently selected patient
    private User currentUser;               // the current user of the program.

    /**
     * Constructor
     */
    Administration(User user) {
        currentUser = user;
        currentPatient = new Patient(1, "Van Puffelen", "Pierre", LocalDate.of(2000, 2, 29),1.9,54);

        System.out.format("Current user: [%d] %s role: %s\n", user.getUserID(), user.getUserName(), user.getRole());
    }


    void addPatients() {
        var scanner = new Scanner(System.in);
        System.out.print("Enter patient name: ");
        String newFirstName = scanner.nextLine();
        System.out.print("Enter patient surname: ");
        String newSurname = scanner.nextLine();
        System.out.print("Enter patient patient date of birth: ");
        String newDateOfBirth = scanner.nextLine();
        System.out.print("Enter patient height: ");
        String newHeightScan = scanner.nextLine();
        double newHeight = Double.parseDouble(newHeightScan);
        System.out.print("Enter patient weight: ");
        String newWeightScan = scanner.nextLine();
        double newWeight = Double.parseDouble(newWeightScan);
        System.out.print("Enter medication name:");
        String medName = scanner.nextLine();
        if (medName.isEmpty()) {
            medName = null;
        }
        System.out.print("Enter medication dose:");
        Double medDose = null;
        if (medName != null) {
            System.out.print("Enter medication dose (press Enter to skip): ");
            String medDoseInput = scanner.nextLine();
            if (!medDoseInput.isEmpty()) {
                medDose = Double.parseDouble("0");
            }
        }






        Patient newPatient = new Patient(PatientsArray.size() + 1, newSurname, newFirstName, LocalDate.parse(newDateOfBirth), newHeight, newWeight);
        PatientsArray.add(newPatient);
        for (Patient patient : PatientsArray) System.out.println(patient.getFirstName() + " " + patient.getSurname());

    }

    void searchPatient(){
        var scanner = new Scanner(System.in);
        System.out.println("Please enter search term:");
       String searchTerm = scanner.nextLine();


       for (Patient patient : PatientsArray){
            if ((patient.getFirstName() + " " + patient.getSurname()).contains(searchTerm)) { //true
                currentPatient = patient;
            }
       }
    }



    public void menu() {
        var scanner = new Scanner(System.in);  // User input via this scanner.

        boolean nextCycle = true;
        while (nextCycle) {
            System.out.format("%s\n", "=".repeat(80));
            System.out.format("Current patient: %s\n", currentPatient.fullName());

            /*
             Print menu on screen
            */
            System.out.format("%d:  STOP\n", STOP);
            System.out.format("%d:  View patient data\n", VIEW);
            System.out.format("%d:  Add new patient\n", ADD);
            System.out.format("%d:  Search patient\n", SEARCH);
            System.out.format("%d:  Edit patient\n", EDIT);

            System.out.print("enter #choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case STOP: // interrupt the loop
                    nextCycle = false;
                    break;

                case VIEW:
                    currentUser.viewData();
                    break;

                case ADD:
                    addPatients();
                    break;

                case EDIT:
                    currentUser.editPatient();
                    break;

                case SEARCH:
                    searchPatient();
                    break;


                default:
                    System.out.println("Please enter a *valid* digit");
                    break;
            }
        }
    }
    public static Patient getCurrentPatient() {
        return currentPatient;
    }
}
