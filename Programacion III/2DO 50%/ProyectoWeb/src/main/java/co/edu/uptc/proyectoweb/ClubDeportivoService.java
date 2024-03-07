package co.edu.uptc.proyectoweb;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ClubDeportivoService {

    private MongoDBManager mongoDBManager;

    public ClubDeportivoService() {
        mongoDBManager = new MongoDBManager();
    }

    public void gestionarDisciplinas(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String accion = request.getParameter("accion");
        String idAfiliado = request.getParameter("idAfiliado");
        switch (accion) {
            case "agregar":
                String nombreDisciplina = request.getParameter("nombreDisciplina");
                boolean esIndividual = Boolean.parseBoolean(request.getParameter("esIndividual"));

                if (nombreDisciplina != null && !nombreDisciplina.isEmpty()) {
                    Disciplina disciplina = new Disciplina(nombreDisciplina, esIndividual);
                    mongoDBManager.insertarDisciplina(disciplina, idAfiliado);
                } else {
                    // Manejar el caso de datos no válidos
                    response.getWriter().write("Error: Datos no válidos");
                }
                break;
            // ...
        }
    }

    public void gestionarEventos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String accion = request.getParameter("accion");
        String idAfiliado = request.getParameter("idAfiliado");
        switch (accion) {
            case "agregar":
                String nombreEvento = request.getParameter("nombreEvento");
                String resultado = request.getParameter("resultado");

                if (nombreEvento != null && !nombreEvento.isEmpty() && resultado != null && !resultado.isEmpty()) {
                    Evento evento = new Evento(nombreEvento, resultado);
                    mongoDBManager.insertarEvento(evento, idAfiliado);
                } else {
                    // Manejar el caso de datos no válidos
                    response.getWriter().write("Error: Datos no válidos");
                }
                break;
            // ...
        }
    }
}