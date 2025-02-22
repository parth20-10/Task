

 import java.io.BufferedReader;
 import java.io.InputStreamReader;
 import java.sql.*;

 public class DatabaseConnectivity {

     private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
     private static Connection con=DBConnection.con;

 

     public static void store(Employee emp) {
         String query = "insert into employee(name,age,salary,designation,department) values (?,?,?,?,?)";
         try (PreparedStatement pstmt = con.prepareStatement(query)) {
             pstmt.setString(1, emp.getName());
             pstmt.setInt(2, emp.getAge());
             pstmt.setInt(3, emp.getSalary());
             pstmt.setString(4, emp.getDesignation());
             pstmt.setString(5, emp.getDepartment());
             pstmt.execute();
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }

     public static void display(String criteria) {
         String query = "select * from employee order by " + criteria;
         try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
             while (rs.next()) {
                 System.out.println("Eid: " + rs.getInt(1)
                         + " Name:" + rs.getString(2)
                         + " Age: " + rs.getInt(3)
                         + " Salary: " + rs.getInt(4)
                         + " Designation: " + rs.getString(5)
                         + " Department: " + rs.getString(6));
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }

     public static boolean delete(int EID) {
         String query = "delete from employee where eid = " + EID;
         try (Statement stmt = con.createStatement()) {
             stmt.executeUpdate(query);
             return true;
         } catch (SQLException e) {
             e.printStackTrace();
             return false;
         }
     }

     public static void appraisal() {
         try {
             System.out.println("Enter the employee's Eid: ");
             int id = Integer.parseInt(reader.readLine());

             String selectQuery = "select * from employee where eid = " + id;
             try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(selectQuery)) {
                 while (rs.next()) {
                     System.out.println("Eid: " + rs.getInt(1)
                             + " Name:" + rs.getString(2)
                             + " Age: " + rs.getInt(3)
                             + " Salary: " + rs.getInt(4)
                             + " Designation: " + rs.getString(5)
                             + " Department: " + rs.getString(6));
                 }
             }

             System.out.println("Enter the delta amount of appraisal: ");
             int raise = Integer.parseInt(reader.readLine());

             String updateQuery = "UPDATE employee SET salary = salary + ? WHERE eid = ?";
             try (PreparedStatement pstmt = con.prepareStatement(updateQuery)) {
                 pstmt.setInt(1, raise);
                 pstmt.setInt(2, id);
                 pstmt.executeUpdate();
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
     }

     public static void search(String criteria, String value) {
         String query = "select * from employee where " + criteria + " = ?";
         try (PreparedStatement pstmt = con.prepareStatement(query)) {
             pstmt.setString(1, value);
             try (ResultSet rs = pstmt.executeQuery()) {
                 while (rs.next()) {
                     System.out.println("Eid: " + rs.getInt(1)
                             + " Name:" + rs.getString(2)
                             + " Age: " + rs.getInt(3)
                             + " Salary: " + rs.getInt(4)
                             + " Designation: " + rs.getString(5)
                             + " Department: " + rs.getString(6));
                 }
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }

     public static void search(String criteria, int value) {
         String query = "select * from employee where " + criteria + " = ?";
         try (PreparedStatement pstmt = con.prepareStatement(query)) {
             pstmt.setInt(1, value);
             try (ResultSet rs = pstmt.executeQuery()) {
                 while (rs.next()) {
                     System.out.println("Eid: " + rs.getInt(1)
                             + " Name:" + rs.getString(2)
                             + " Age: " + rs.getInt(3)
                             + " Salary: " + rs.getInt(4)
                             + " Designation: " + rs.getString(5)
                             + " Department: " + rs.getString(6));
                 }
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
 }