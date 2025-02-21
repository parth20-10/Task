package com.example.handler;


import java.util.Scanner;
import org.springframework.stereotype.Component;
import com.example.demo.MainMenu;
import com.example.employee.Clerk;
import com.example.employee.Manager;
import com.example.employee.Programmer;

@Component
public class EmployeeHandler {

    private static final Scanner scanner = new Scanner(System.in);

    public static void createEmployee() {
        int choice;do{System.out.println("""
                    Press 1 : Programmer
                    Press 2 : Clerk
                    Press 3 : Manager
                    Press 4 : Exit Create functionality
                    """);choice=new MainMenu().readChoice(4);switch(choice){case 1->DatabaseConnectivityMongoDB.store(Programmer.createProgrammer());case 2->DatabaseConnectivityMongoDB.store(Clerk.createClerk());case 3->DatabaseConnectivityMongoDB.store(Manager.createManager());case 4->System.out.println("Exiting create functionality.");}}while(choice!=4);
    }

    public static void displayAll() {
 

        System.out.println("""
                Sort employees by:
                1: ID
                2: Name
                3: Age
                4: Salary
                5: Designation
                """);int choice=new MainMenu().readChoice(5);switch(choice){case 1->DatabaseConnectivityMongoDB.display("eid");case 2->DatabaseConnectivityMongoDB.display("name");case 3->DatabaseConnectivityMongoDB.display("age");case 4->DatabaseConnectivityMongoDB.display("salary");case 5->DatabaseConnectivityMongoDB.display("designation");default->throw new IllegalArgumentException("Invalid choice");};
        
    }

    public static void deleteEmployee() {
        System.out.print("Enter eID to delete: ");
        int deleteID = Integer.parseInt(scanner.nextLine());
        if (deleteID == 1) {
            System.out.println("CEO can tbe deleted");
            return;
        }
        if (DatabaseConnectivityMongoDB.delete(deleteID)) {

            System.out.println("Employee deleted.");

        } else {
            System.out.println("Employee not found.");
        }
    }

    public static void searchEmployee() {
        System.out.println("""
                Search employee by:
                1: ID
                2: Name
                3: Designation
                """);int choice=new MainMenu().readChoice(3);
        
        System.out.print("Enter value to search: ");Object value=switch(choice){case 1->Integer.parseInt(scanner.nextLine());case 2,3->scanner.nextLine();default->throw new IllegalArgumentException("Invalid input");};switch(choice){case 1->DatabaseConnectivityMongoDB.search("eid",(Integer)value);case 2->DatabaseConnectivityMongoDB.search("name",(String)value);case 3->DatabaseConnectivityMongoDB.search("designation",(String)value);default->throw new IllegalArgumentException("Invalid choice");}


    }
}
