import java.util.Scanner;

public class Fysio extends User {
    private String role;

    public Fysio(int id, String name, String password) {
        super(id, name, password);
        role = "Fysio";

    }

    @Override
    void viewData() {
        super.viewData();
        System.out.format("%-17s %s\n", "lungCapacity:", Administration.getCurrentPatient().getLungCapacity());



    }
    @Override
    void editPatient(){
        super.editPatient();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Height:\t");
        String newHeightScan = scanner.nextLine();
        double newHeight;
        if (newHeightScan.isEmpty()){
            newHeight = Administration.getCurrentPatient().getHeight();
        }
        else {newHeight = Double.parseDouble(newHeightScan);
            Administration.getCurrentPatient().setHeight(newHeight);
        }

        System.out.println("Weight:\t");
        String newWeightScan = scanner.nextLine();
        double newWeight;
        if (newWeightScan.isEmpty()){
            newWeight = Administration.getCurrentPatient().getWeight();
        }
        else {newWeight = Double.parseDouble(newWeightScan);
            Administration.getCurrentPatient().setWeight(newWeight);
        }


    }

    public String getRole() {
        return role;
    }
}