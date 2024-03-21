package servlets;

import co.edu.uptc.model.Afiliado;
import co.edu.uptc.model.Disciplina;
import co.edu.uptc.model.Evento;
import co.edu.uptc.persistence.DAOafiliado;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

@WebServlet(name = "ajaxServlet", value = "/ajaxServlet")
public class AjaxServlet extends HttpServlet {
    private DAOafiliado DAOafiliado = new DAOafiliado();
    private List<Afiliado> afiliados;
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {
        List<Afiliado> afiliados = DAOafiliado.obtenerAfiliados();
        String json = gson.toJson(afiliados);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int idAfiliado = Integer.parseInt(request.getParameter("idAfiliado"));
            // Buscar el afiliado existente
            afiliados = DAOafiliado.obtenerAfiliados();
            Afiliado afiliadoExistente = DAOafiliado.obtenerAfiliadoPorID(idAfiliado);
            if (afiliadoExistente != null) {
                if(request.getParameter("modificar").equalsIgnoreCase("2")){
                    Afiliado delete = DAOafiliado.eliminarUsuario(afiliadoExistente);
                    response.getWriter().write("Nombre: " + delete.getNombre() +"\nApellido: " + delete.getApellido());
                    return;
                }
                if (request.getParameter("modificar").equalsIgnoreCase("0")) {
                    Evento evento = crearEvento(request, afiliados, afiliadoExistente);
                    // Si el afiliado existe, agregar el nuevo evento a su lista de eventos
                    afiliadoExistente.getEventos().add(evento);
                }else{
                    String eventosJSON = request.getParameter("eventosAfiliado");
                    Gson gson = new Gson();
                    Type eventoListType = new TypeToken<List<Evento>>(){}.getType();
                    List<Evento> eventos = gson.fromJson(eventosJSON, eventoListType);
                    Set<Integer> idSet = new HashSet<>();
                    for(Evento e: eventos){
                        if(idSet.contains(e.getId())) {
                            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                            return;
                        } else {
                            idSet.add(e.getId());
                        }
                    }
                    afiliadoExistente.setNombre(request.getParameter("nombre"));
                    afiliadoExistente.setApellido(request.getParameter("apellido"));
                    afiliadoExistente.setDisciplina(new Disciplina(Integer.parseInt(request.getParameter("idDisciplina")),
                            request.getParameter("nombreDisciplina"), Boolean.parseBoolean(request.getParameter("esIndividual"))));

                    afiliadoExistente.setEventos(eventos);
                }
                DAOafiliado.actualizarAfiliado(afiliadoExistente);
            } else {

                // Si el afiliado NO existe se crear un nuevo afiliado
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                int idDisciplina = Integer.parseInt(request.getParameter("idDisciplina"));
                String nombreDisciplina = request.getParameter("nombreDisciplina");
                boolean esIndividual = Boolean.parseBoolean(request.getParameter("esIndividual"));
                if (idAfiliado == 0) {
                    throw new IllegalArgumentException("Tiene que digitar el ID del afiliado");
                }
                if (nombre == "") {
                    throw new IllegalArgumentException("Tiene que digitar el Nombre del afiliado con ID: " + idAfiliado);
                }
                if (apellido == "") {
                    throw new IllegalArgumentException("Tiene que digitar el Apellido del afiliado " + nombre);
                }
                if (idDisciplina == 0) {
                    throw new IllegalArgumentException("Tiene que digitar el ID de la Disciplina que practica " + nombre + " " + apellido);
                }
                if (nombreDisciplina.isEmpty()) {
                    Disciplina disciplinaExistente = null;
                    for (Afiliado afiliado : afiliados) {
                        if (afiliado.getDisciplina().getId() == idDisciplina) {
                            disciplinaExistente = afiliado.getDisciplina();
                            break;
                        }
                    }
                    if (disciplinaExistente != null) {
                        nombreDisciplina = disciplinaExistente.getNombre();
                        esIndividual = disciplinaExistente.getEsIndividual();

                    } else {
                        throw new IllegalArgumentException("Tiene que digitar el Nombre de la nueva Disciplina " + idDisciplina + " del afiliado: " + nombre);
                    }
                }
                Disciplina disciplina = new Disciplina(idDisciplina, nombreDisciplina, esIndividual);
                List<Evento> eventos = new ArrayList<>();
                Afiliado afiliado = new Afiliado(idAfiliado, nombre, apellido, disciplina, eventos);
                Evento evento = crearEvento(request, afiliados, afiliado);
                eventos.add(evento);
                DAOafiliado.insertarAfiliado(afiliado);
            }
            response.setStatus(HttpServletResponse.SC_CREATED);
        } catch (IllegalArgumentException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("error", e.getMessage());
            String errorJson = new Gson().toJson(errorMap);
            response.getWriter().write(errorJson);
        }
    }

    private Evento crearEvento(HttpServletRequest request, List<Afiliado> afiliados, Afiliado afiliadoExiste) {
        Evento eventoExiste = null;
        int idEvento = Integer.parseInt(request.getParameter("idEvento"));
        if (idEvento != 0) {
            // Verificar si el id del evento ya existe en algún afiliado
            for (Afiliado afiliado : afiliados) {
                // Buscar el evento en cada afiliado
                eventoExiste = afiliado.getEventos().stream()
                        .filter(evento -> evento.getId() == idEvento)
                        .findFirst()
                        .orElse(null);
                if (eventoExiste != null) {
                    break;
                }
            }
            if (eventoExiste != null && eventoExiste.getId() == idEvento) {
                Evento eventoYaEnAfiliado = afiliadoExiste.getEventos().stream()
                        .filter(evento -> evento.getId() == idEvento)
                        .findFirst()
                        .orElse(null);
                if (eventoYaEnAfiliado == null) {
                    if (request.getParameter("resultadoEvento") == null || request.getParameter("resultadoEvento").isEmpty()) {
                        throw new IllegalArgumentException("Tiene que digitar el puesto obtenido en " + eventoExiste.getNombre() + " para " + afiliadoExiste.getNombre());
                    } else {
                        String nuevoResultado = request.getParameter("resultadoEvento");
                        Evento nuevoEvento = new Evento(eventoExiste.getId(), eventoExiste.getNombre(), nuevoResultado);
                        return nuevoEvento;
                    }
                } else {
                    throw new IllegalArgumentException(afiliadoExiste.getNombre() + " ya obtuvo un puesto en el evento " + eventoExiste.getNombre());
                }
            } else {
                String nombreEvento = request.getParameter("nombreEvento");
                String resultadoEvento = request.getParameter("resultadoEvento");

                if (nombreEvento == null || resultadoEvento == null || nombreEvento.isEmpty() || resultadoEvento.isEmpty()) {
                    throw new IllegalArgumentException("Digite datos del nuevo evento para" + afiliadoExiste.getNombre());
                } else {
                    // Crear el nuevo evento y agregarlo a la lista de eventos del afiliado
                    Evento evento = new Evento(idEvento, nombreEvento, resultadoEvento);
                    return evento;
                }
            }
        } else {
            throw new IllegalArgumentException("Tiene que digitar el ID del evento para " + afiliadoExiste.getNombre());
        }
    }
}