class ZorgApp {
    public static void main(String[] args) {

        User user = Authentication.login();

        Administration administration = new Administration(user);
        Authentication auth = new Authentication();


        administration.menu();
    }
}
