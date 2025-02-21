

public class TestApp {

    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        System.out.println("Welcome!");

        try{while (true) {
            menu.displayMain();
            int choice = menu.readChoice(6);

            switch (choice) {
                case 1:
                    EmployeeHandler.createEmployee();
                    break;
                case 2:
                    EmployeeHandler.displayAll();
                    break;
                case 3:
                    DatabaseConnectivity.appraisal();
                    break;
                case 4:
                    EmployeeHandler.deleteEmployee();
                    break;
                case 5:
                    EmployeeHandler.searchEmployee();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }}
        catch(Exception e){
            System.out.println("Exited with error");
        } finally {
        }
    }
}
