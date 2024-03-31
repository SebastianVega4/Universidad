package co.edu.uptc.persistence;

import co.edu.uptc.model.Afiliado;
import co.edu.uptc.model.Disciplina;
import co.edu.uptc.model.Evento;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class DAOafiliado {

    private MongoDBManager mongoDB;
    private MongoCollection<Document> collection;

    public DAOafiliado() {
        mongoDB = new MongoDBManager();
        collection = mongoDB.getConnection().getCollection("afiliados");
    }

    public void insertarAfiliado(Afiliado afiliado) {
        try {
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

    public Afiliado obtenerAfiliadoPorID(int id){
        try {
            Afiliado afiliado = null;
            for (Document doc : collection.find(Filters.eq("id", id))) {
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

                afiliado = new Afiliado(
                        doc.getInteger("id"),
                        doc.getString("nombre"),
                        doc.getString("apellido"),
                        disciplina,
                        eventos
                );
            }
            return afiliado;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Afiliado eliminarUsuario(Afiliado afiliadoExistente){
        Document filtro = new Document("id", afiliadoExistente.getId());
        collection.deleteOne(filtro);
        return afiliadoExistente;
    }
}