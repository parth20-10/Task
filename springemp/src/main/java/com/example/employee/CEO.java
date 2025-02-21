package com.example.employee;


import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Component;

import com.example.handler.DatabaseConnectivityMongoDB;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;


@Component("ceo")
public class CEO extends Employee {
    public static boolean ceo;

    private CEO() {
        setDesignation("CEO");
        System.out.println("CEO created. Enter Employee details.");
    }

    public static void createCEO() {

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("EmployeeManagementApp");
        MongoCollection<Document> collection = database.getCollection("employee");
        Bson appraisalFilter = Filters.eq("designation", "CEO");
        FindIterable<Document> iterable = collection.find(appraisalFilter);

        try {
            if (iterable.iterator().hasNext()) {
                ceo = true;
            }
        } catch (Exception e) {
            System.out.println(e);

        }
        if (ceo != true) {
            System.out.println("CEO is not created Enter his details first...");
            ceo = true;
            CEO ceo = new CEO();
            DatabaseConnectivityMongoDB.store(ceo);
        }

    }
}
