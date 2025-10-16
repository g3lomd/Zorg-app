import java.time.LocalDate;
import java.util.HashMap;

class Patient {
   static final int RETURN      = 0;
   static final int SURNAME     = 1;
   static final int FIRSTNAME   = 2;
   static final int DATEOFBIRTH = 3;


   private int       id;
   private String    surname;
   private String    firstName;
   private LocalDate dateOfBirth;
   private double height;
   private double weight;
   private double bmi;
   private HashMap<String, Double> meds;
   private double lungCapacity;

    /**
     * Constructor
     */
    Patient(int id, String surname, String firstName, LocalDate dateOfBirth, double height, double weight) {
        this.id = id;
        this.surname = surname;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.height = height;
        this.bmi = weight / (height * height);
        this.meds = new HashMap<>();
    }
    //GETTERS
    public int getPatientID() {return id;}
    public String getSurname() {return surname;}
    public String getFirstName() {
        return firstName;
    }
    public LocalDate getDateOfBirth() {return dateOfBirth;}
    public double getWeight() {return weight;}
    public double getHeight() {
        return height;
    }
    public HashMap<String, Double> getMeds() {return meds;}
    public Double getBmi() { return bmi;}
    public double getLungCapacity() {
        return lungCapacity;
    }

    // SETTERS
     public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;}


     public void setSurname(String newSurname) {
        this.surname = newSurname;}

     public void setDateOfBirth(LocalDate newDateOfBirth) {
        this.dateOfBirth = newDateOfBirth;}

    public void setHeight(double newHeight) {
        this.height = newHeight;}

     public void setWeight(double newWeight) {
        this.weight = newWeight;}

    public void setMeds(String key, Double value) {
        if (value != 0) {
            meds.put(key, value);
        } else {
            meds.remove(key);
        }
    }
    public void addMed(String name, Double dose){
       this.meds.put(name, dose);
    }


    /**
     * Display patient data.
     */
    void viewData() {
        System.out.format("===== Patient id=%d ==============================\n", id);
        System.out.format("%-17s %s\n", "Surname:", surname);
        System.out.format("%-17s %s\n", "firstName:", firstName);
        System.out.format("%-17s %s\n", "Date of birth:", dateOfBirth);
        System.out.format("%-17s %s\n", "height:", height + "M");
        System.out.format("%-17s %s\n", "weight:", weight + "Kg");
        System.out.format("%-17s %.1f\n", "BMI:", bmi);
        System.out.format("medication:%s",meds);

        if (meds.isEmpty()){
            System.out.println("No medications assigned");
        } else {
            System.out.println("Medications");

            for (var entry : meds.entrySet()) {
                System.out.format("  %s: %.2f\n", entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * Shorthand for a Patient's full name
     */
    String fullName() {
        return String.format("%s %s [%s]", firstName, surname, dateOfBirth.toString());
    }
}
