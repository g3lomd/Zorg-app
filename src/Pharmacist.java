public class Pharmacist extends User {
        private String role;

        public Pharmacist(int id, String name, String password) {
            super(id, name, password);
            role = "Dentist";

        }

        @Override
        void viewData() {
            super.viewData();
            System.out.format("%-17s %s\n", "height:", Administration.getCurrentPatient().getHeight());


        }

        public String getRole() {
            return role;
        }
}

