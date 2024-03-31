package co.edu.uptc.persistence;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;

public class MongoDBManager {
    private MongoClient mongoClient = null;

    public MongoDBManager() {
        mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("clubDeportivo");
        if (!database.listCollectionNames().into(new ArrayList<String>()).contains("afiliados")) {
            database.createCollection("afiliados");
        }
    }

    public MongoDatabase getConnection(){
        return mongoClient.getDatabase("clubDeportivo");
    }
}