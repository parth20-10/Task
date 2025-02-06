
public class Manager extends Employee {


    private Manager() {
        setDesignation("Manager");
    }
    

    public static Manager createManager() {
        
        return new Manager();
    }
    

    
}
