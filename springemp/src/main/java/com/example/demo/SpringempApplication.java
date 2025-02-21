package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.handler.DatabaseConnectivityMongoDB;
import com.example.handler.EmployeeHandler;

@SpringBootApplication
public class SpringempApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringempApplication.class, args);
		
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
                    DatabaseConnectivityMongoDB.appraisal();
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
            System.out.println(e);
        } finally {
        }
    }
	

}
