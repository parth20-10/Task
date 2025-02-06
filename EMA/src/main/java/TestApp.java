

public class TestApp {

    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        System.out.println("Welcome!");

        try{while (true) {
            menu.displayMain();
            int choice = menu.readChoice(6);

            switch (choice) {
                case 1 -> EmployeeHandler.createEmployee();
                case 2 -> EmployeeHandler.displayAll();
                case 3 -> DatabaseConnectivity.appraisal();
                case 4 -> EmployeeHandler.deleteEmployee();
                case 5 -> EmployeeHandler.searchEmployee();
                case 6 -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }}
        catch(Exception e){
            System.out.println("Exited with error");
        } finally {
        }
    }
}
