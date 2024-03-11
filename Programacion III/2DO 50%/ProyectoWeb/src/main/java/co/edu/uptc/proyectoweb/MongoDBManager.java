package co.edu.uptc.proyectoweb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoDBManager {
    private MongoClient mongoClient = null;

    public MongoDBManager() {
        mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("clubDeportivo");
        if (!database.listCollectionNames().into(new ArrayList<String>()).contains("afiliados")) {
            database.createCollection("afiliados");
        }
    }

    public void insertarAfiliado(Afiliado afiliado) {
        try {
            MongoDatabase database = mongoClient.getDatabase("clubDeportivo");
            MongoCollection<Document> collection = database.getCollection("afiliados");

            List<Document> eventosList = new ArrayList<>();
            for (Evento evento : afiliado.getEventos()) {
                Document eventoDoc = new Document()
                        .append("id", evento.getId())
                        .append("nombre", evento.getNombre())
                        .append("resultado", evento.getResultado());
                eventosList.add(eventoDoc);
            }

            Document disciplinaDoc = new Document()
                    .append("id", afiliado.getDisciplina().getId())
                    .append("nombre", afiliado.getDisciplina().getNombre())
                    .append("esIndividual", afiliado.getDisciplina().getEsIndividual());

            Document document = new Document()
                    .append("id", afiliado.getId())
                    .append("nombre", afiliado.getNombre())
                    .append("apellido", afiliado.getApellido())
                    .append("disciplina", disciplinaDoc)
                    .append("eventos", eventosList);

            collection.insertOne(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Afiliado> obtenerAfiliados() {
        try {
            MongoDatabase database = mongoClient.getDatabase("clubDeportivo");
            MongoCollection<Document> collection = database.getCollection("afiliados");

            List<Afiliado> afiliados = new ArrayList<>();
            for (Document doc : collection.find()) {
                List<Evento> eventos = new ArrayList<>();
                for (Document eventoDoc : (List<Document>) doc.get("eventos")) {
                    Evento evento = new Evento(
                            eventoDoc.getInteger("id"),
                            eventoDoc.getString("nombre"),
                            eventoDoc.getString("resultado")
                    );
                    eventos.add(evento);
                }

                Disciplina disciplina = new Disciplina(
                        doc.get("disciplina", Document.class).getInteger("id"),
                        doc.get("disciplina", Document.class).getString("nombre"),
                        doc.get("disciplina", Document.class).getBoolean("esIndividual")
                );

                Afiliado afiliado = new Afiliado(
                        doc.getInteger("id"),
                        doc.getString("nombre"),
                        doc.getString("apellido"),
                        disciplina,
                        eventos
                );
                afiliados.add(afiliado);
            }
            return afiliados;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void actualizarAfiliado(Afiliado afiliado) {
        try {
            MongoDatabase database = mongoClient.getDatabase("clubDeportivo");
            MongoCollection<Document> collection = database.getCollection("afiliados");

            List<Document> eventosList = new ArrayList<>();
            for (Evento evento : afiliado.getEventos()) {
                Document eventoDoc = new Document()
                        .append("id", evento.getId())
                        .append("nombre", evento.getNombre())
                        .append("resultado", evento.getResultado());
                eventosList.add(eventoDoc);
            }

            Document disciplinaDoc = new Document()
                    .append("id", afiliado.getDisciplina().getId())
                    .append("nombre", afiliado.getDisciplina().getNombre())
                    .append("esIndividual", afiliado.getDisciplina().getEsIndividual());

            Document newDocument = new Document()
                    .append("id", afiliado.getId())
                    .append("nombre", afiliado.getNombre())
                    .append("apellido", afiliado.getApellido())
                    .append("disciplina", disciplinaDoc)
                    .append("eventos", eventosList);

            collection.replaceOne(new Document("id", afiliado.getId()), newDocument);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Afiliado> obtenerAfiliadosPorNombre(String nombre) {
        try {
            MongoDatabase database = mongoClient.getDatabase("clubDeportivo");
            MongoCollection<Document> collection = database.getCollection("afiliados");

            List<Afiliado> afiliados = new ArrayList<>();

            for (Document doc : collection.find(Filters.eq("nombre", nombre))) {
                List<Evento> eventos = new ArrayList<>();
                for (Document eventoDoc : (List<Document>) doc.get("eventos")) {
                    Evento evento = new Evento(
                            eventoDoc.getInteger("id"),
                            eventoDoc.getString("nombre"),
                            eventoDoc.getString("resultado")
                    );
                    eventos.add(evento);
                }

                Disciplina disciplina = new Disciplina(
                        doc.get("disciplina", Document.class).getInteger("id"),
                        doc.get("disciplina", Document.class).getString("nombre"),
                        doc.get("disciplina", Document.class).getBoolean("esIndividual")
                );

                Afiliado afiliado = new Afiliado(
                        doc.getInteger("id"),
                        doc.getString("nombre"),
                        doc.getString("apellido"),
                        disciplina,
                        eventos
                );
                afiliados.add(afiliado);
            }
            return afiliados;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<Afiliado> obtenerAfiliadosPorApellido(String apellido) {
        try {
            MongoDatabase database = mongoClient.getDatabase("clubDeportivo");
            MongoCollection<Document> collection = database.getCollection("afiliados");

            List<Afiliado> afiliados = new ArrayList<>();

            for (Document doc : collection.find(Filters.eq("apellido", apellido))) {
                List<Evento> eventos = new ArrayList<>();
                for (Document eventoDoc : (List<Document>) doc.get("eventos")) {
                    Evento evento = new Evento(
                            eventoDoc.getInteger("id"),
                            eventoDoc.getString("nombre"),
                            eventoDoc.getString("resultado")
                    );
                    eventos.add(evento);
                }

                Disciplina disciplina = new Disciplina(
                        doc.get("disciplina", Document.class).getInteger("id"),
                        doc.get("disciplina", Document.class).getString("nombre"),
                        doc.get("disciplina", Document.class).getBoolean("esIndividual")
                );

                Afiliado afiliado = new Afiliado(
                        doc.getInteger("id"),
                        doc.getString("nombre"),
                        doc.getString("apellido"),
                        disciplina,
                        eventos
                );
                afiliados.add(afiliado);
            }
            return afiliados;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<Afiliado> obtenerAfiliadosPorIDEvento(int idEvento) {
        try {
            MongoDatabase database = mongoClient.getDatabase("clubDeportivo");
            MongoCollection<Document> collection = database.getCollection("afiliados");

            List<Afiliado> afiliados = new ArrayList<>();

            for (Document doc : collection.find()) {
                List<Document> eventos = (List<Document>) doc.get("eventos");
                boolean eventoEncontrado = false;
                for (Document evento : eventos) {
                    if (evento.getInteger("id") == idEvento) {
                        eventoEncontrado = true;
                        break;
                    }
                }
                if (eventoEncontrado) {
                    List<Evento> eventosList = new ArrayList<>();
                    for (Document eventoDoc : eventos) {
                        Evento evento = new Evento(
                                eventoDoc.getInteger("id"),
                                eventoDoc.getString("nombre"),
                                eventoDoc.getString("resultado")
                        );
                        eventosList.add(evento);
                    }

                    Disciplina disciplina = new Disciplina(
                            doc.get("disciplina", Document.class).getInteger("id"),
                            doc.get("disciplina", Document.class).getString("nombre"),
                            doc.get("disciplina", Document.class).getBoolean("esIndividual")
                    );

                    Afiliado afiliado = new Afiliado(
                            doc.getInteger("id"),
                            doc.getString("nombre"),
                            doc.getString("apellido"),
                            disciplina,
                            eventosList
                    );
                    afiliados.add(afiliado);
                }
            }
            return afiliados;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<Afiliado> obtenerAfiliadosPorEvento(String evento) {
        try {
            MongoDatabase database = mongoClient.getDatabase("clubDeportivo");
            MongoCollection<Document> collection = database.getCollection("afiliados");

            List<Afiliado> afiliados = new ArrayList<>();

            for (Document doc : collection.find()) {
                List<Document> eventos = (List<Document>) doc.get("eventos");
                boolean eventoEncontrado = false;
                for (Document eventoDoc : eventos) {
                    if (eventoDoc.getString("nombre").equalsIgnoreCase(evento)) {
                        eventoEncontrado = true;
                        break;
                    }
                }
                if (eventoEncontrado) {
                    List<Evento> eventosList = new ArrayList<>();
                    for (Document eventoDoc : eventos) {
                        Evento eventoObj = new Evento(
                                eventoDoc.getInteger("id"),
                                eventoDoc.getString("nombre"),
                                eventoDoc.getString("resultado")
                        );
                        eventosList.add(eventoObj);
                    }

                    Disciplina disciplina = new Disciplina(
                            doc.get("disciplina", Document.class).getInteger("id"),
                            doc.get("disciplina", Document.class).getString("nombre"),
                            doc.get("disciplina", Document.class).getBoolean("esIndividual")
                    );

                    Afiliado afiliado = new Afiliado(
                            doc.getInteger("id"),
                            doc.getString("nombre"),
                            doc.getString("apellido"),
                            disciplina,
                            eventosList
                    );
                    afiliados.add(afiliado);
                }
            }
            return afiliados;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<Afiliado> obtenerAfiliadosPorIdDisciplina(int idDisciplina) {
        try {
            MongoDatabase database = mongoClient.getDatabase("clubDeportivo");
            MongoCollection<Document> collection = database.getCollection("afiliados");

            List<Afiliado> afiliados = new ArrayList<>();

            for (Document doc : collection.find(Filters.eq("disciplina.id", idDisciplina))) {
                List<Evento> eventos = new ArrayList<>();
                for (Document eventoDoc : (List<Document>) doc.get("eventos")) {
                    Evento evento = new Evento(
                            eventoDoc.getInteger("id"),
                            eventoDoc.getString("nombre"),
                            eventoDoc.getString("resultado")
                    );
                    eventos.add(evento);
                }

                Disciplina disciplina = new Disciplina(
                        doc.get("disciplina", Document.class).getInteger("id"),
                        doc.get("disciplina", Document.class).getString("nombre"),
                        doc.get("disciplina", Document.class).getBoolean("esIndividual")
                );

                Afiliado afiliado = new Afiliado(
                        doc.getInteger("id"),
                        doc.getString("nombre"),
                        doc.getString("apellido"),
                        disciplina,
                        eventos
                );
                afiliados.add(afiliado);
            }
            return afiliados;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<Afiliado> obtenerAfiliadosPorDisciplina(String disciplina) {
        try {
            MongoDatabase database = mongoClient.getDatabase("clubDeportivo");
            MongoCollection<Document> collection = database.getCollection("afiliados");

            List<Afiliado> afiliados = new ArrayList<>();

            for (Document doc : collection.find(Filters.eq("disciplina.nombre", disciplina))) {
                List<Evento> eventos = new ArrayList<>();
                for (Document eventoDoc : (List<Document>) doc.get("eventos")) {
                    Evento evento = new Evento(
                            eventoDoc.getInteger("id"),
                            eventoDoc.getString("nombre"),
                            eventoDoc.getString("resultado")
                    );
                    eventos.add(evento);
                }

                Disciplina disciplinaObj = new Disciplina(
                        doc.get("disciplina", Document.class).getInteger("id"),
                        doc.get("disciplina", Document.class).getString("nombre"),
                        doc.get("disciplina", Document.class).getBoolean("esIndividual")
                );

                Afiliado afiliado = new Afiliado(
                        doc.getInteger("id"),
                        doc.getString("nombre"),
                        doc.getString("apellido"),
                        disciplinaObj,
                        eventos
                );
                afiliados.add(afiliado);
            }
            return afiliados;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}