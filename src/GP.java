import java.util.Scanner;

public class GP extends User {
    private String role;

    public GP(int id, String name, String password) {
        super(id, name, password);
        role = "GP";
    }

    @Override
    void viewData() {
        super.viewData();
        System.out.format("%-17s %s\n", "height:", Administration.getCurrentPatient().getHeight());
        System.out.format("%-17s %s\n", "weight:", Administration.getCurrentPatient().getWeight());
        System.out.format("%-17s %.1f\n", "BMI:", Administration.getCurrentPatient().getBmi());
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
        System.out.println("LungCapacity:\t");
        String newLungCapacityScan = scanner.nextLine();
        double newLungCapacity;
        if (newLungCapacityScan.isEmpty()){
            newLungCapacity = Administration.getCurrentPatient().getLungCapacity();
        }
        else {newLungCapacity = Double.parseDouble(newLungCapacityScan);
            Administration.getCurrentPatient().setLungCapacity(newLungCapacity);
        }


    }
    public String getRole() { return role;}
}
