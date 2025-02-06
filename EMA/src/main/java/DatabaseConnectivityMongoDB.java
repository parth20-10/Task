
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.result.DeleteResult;

import java.io.BufferedReader;
import java.io.InputStreamReader;


import org.bson.Document;
import org.bson.conversions.Bson;

public class DatabaseConnectivityMongoDB {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
    static MongoDatabase database = mongoClient.getDatabase("EmployeeManagementApp");
    static MongoCollection<Document> collection = database.getCollection("employee");

    public static void store(Employee emp) {
        Document doc = new Document();
        doc.append("name", emp.getName()).append("age", emp.getAge()).append("salary", emp.getSalary())
                .append("designation", emp.getDesignation()).append("department", emp.getDepartment());
        collection.insertOne(doc);
    }

    public static void display(String criteria) {
        Bson sort = Sorts.ascending(criteria);
        FindIterable<Document> iterable = collection.find().sort(sort);
        for (Document d : iterable) {
            System.out.println(d.toJson());
        }
    }

    public static boolean delete(int EID) {
        Bson deleteFilter = Filters.eq("_id", EID);
        DeleteResult result = collection.deleteOne(deleteFilter);
        return result.getDeletedCount() > 0;
    }

    public static void appraisal() {
        try {
            System.out.println("Enter the employee's Eid: ");
            int id = Integer.parseInt(reader.readLine());
            Bson appraisalFilter = Filters.eq("_id", id);
            FindIterable<Document> iterable = collection.find(appraisalFilter);
            for (Document d : iterable) {
                System.out.println(d.toJson());
            }

            System.out.println("Enter the delta amount of appraisal: ");
            int raise = Integer.parseInt(reader.readLine());

            Document update = new Document("$inc", new Document("salary", raise));
            collection.updateOne(appraisalFilter, update);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void search(String crtieria, String value) {
        Bson searchFilter = Filters.eq(crtieria, value);
            FindIterable<Document> iterable = collection.find(searchFilter);
            for (Document d : iterable) {
                System.out.println(d.toJson());
            }
    }

	public static void  search(String crtieria, Integer value) {
		// TODO Auto-generated method stub
		 Bson searchFilter = Filters.eq(crtieria, value);
         FindIterable<Document> iterable = collection.find(searchFilter);
         for (Document d : iterable) {
             System.out.println(d.toJson());
         }
	}
}
