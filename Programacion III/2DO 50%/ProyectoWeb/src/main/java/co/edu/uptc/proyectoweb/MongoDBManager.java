package co.edu.uptc.proyectoweb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MongoDBManager {
    private MongoClient mongoClient;

    public MongoDBManager() {
        mongoClient = (MongoClient) MongoClients.create("mongodb://localhost:27017");
    }

    public void insertarAfiliado(Afiliado afiliado) {
        // Implementar la lógica para insertar un afiliado en la base de datos
    }

    public List<Afiliado> obtenerAfiliados() {
        // Implementar la lógica para obtener todos los afiliados de la base de datos
        return null;
    }

    public void insertarDisciplina(Disciplina disciplina, String idAfiliado) {
        try {
            MongoDatabase database = mongoClient.getDatabase("clubDeportivo");
            MongoCollection<Document> collection = database.getCollection("disciplinas");

            Document document = new Document();
            document.append("_id", new ObjectId())
                    .append("idAfiliado", idAfiliado)
                    .append("nombre", disciplina.getNombre())
                    .append("esIndividual", disciplina.isEsIndividual());

            collection.insertOne(document);
        } catch (Exception e) {
            // Manejar excepciones adecuadamente
            e.printStackTrace();
        }
    }

    public void insertarEvento(Evento evento, String idAfiliado) {
        try {
            MongoDatabase database = mongoClient.getDatabase("clubDeportivo");
            MongoCollection<Document> collection = database.getCollection("eventos");

            Document document = new Document();
            document.append("_id", new ObjectId())
                    .append("idAfiliado", idAfiliado)
                    .append("nombre", evento.getNombre())
                    .append("resultado", evento.getResultado());

            collection.insertOne(document);
        } catch (Exception e) {
            // Manejar excepciones adecuadamente
            e.printStackTrace();
        }
    }

    // Métodos similares para actualizar y eliminar disciplinas y eventos
}