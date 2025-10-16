import java.util.ArrayList;
import java.util.Scanner;

class Authentication {
    public static User login() {
        ArrayList<User> userArray = new ArrayList<>();

        userArray.add(new GP(1, "mart", "1234"));
        userArray.add(new Dentist(2, "Gert Boom", "1234"));
        userArray.add(new User(3, "Zwieber Meppel", "1234"));
        userArray.add(new Fysio(4, "Bas Bos", "1234"));
        userArray.add(new Pharmacist(5, "Cas Smor", "1234"));
        userArray.add(new Admin (6, "Ad Mor", "1234"));

        while (true) {

            System.out.println("=|Enter username|=");
            var scanner = new Scanner(System.in);
            String userScan = scanner.nextLine();

            System.out.println("Enter password:");
            String password = scanner.nextLine();

            for (User userEntry : userArray) {
                if (userEntry.getUserName().equals(userScan)) {
                    if (userEntry.getPassword().equals(password)) {
                        // als er een match is
                        return userEntry;
                    }
                }
            }
            System.out.println("Wrong credentials");
        }
    }
}