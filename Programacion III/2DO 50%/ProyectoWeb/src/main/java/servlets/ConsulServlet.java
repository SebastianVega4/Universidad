package servlets;

import co.edu.uptc.proyectoweb.Afiliado;
import co.edu.uptc.proyectoweb.MongoDBManager;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "consulServlet", value = "/consulServlet")
public class ConsulServlet extends HttpServlet {
    private MongoDBManager mongoDBManager = new MongoDBManager();
    private Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {
        List<Afiliado> afiliados = mongoDBManager.obtenerAfiliados();
        String json = gson.toJson(afiliados);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws IOException {
        try {
            String consulPor = req.getParameter("consulPor");
            String queConsulta = req.getParameter("queConsulta");
            boolean consultaValida = (queConsulta != "" && queConsulta != null );
            List<Afiliado> afiliados = null;
            if (consulPor == null || consulPor.isEmpty()) {
                afiliados = mongoDBManager.obtenerAfiliados();
                throw new IllegalArgumentException("Coloca algun parametro para Consultar   jeje");
            } else {
                switch (consulPor){
                    case "MostrarTodos":
                        afiliados = mongoDBManager.obtenerAfiliados();
                        break;
                    case "Nombre":
                        if (consultaValida){
                            afiliados = mongoDBManager.obtenerAfiliadosPorNombre(queConsulta);
                        } else {
                            throw new IllegalArgumentException("Coloca que Nombre quieres consultar");
                        }
                        break;
                    case "Apellido":
                        if (consultaValida){
                            afiliados = mongoDBManager.obtenerAfiliadosPorApellido(queConsulta);
                        } else {
                            throw new IllegalArgumentException("Coloca que Apellido quieres consultar");
                        }
                        break;
                    case "IdDisciplina":
                        if (consultaValida) {
                            afiliados = mongoDBManager.obtenerAfiliadosPorIdDisciplina(Integer.parseInt(queConsulta));
                        } else {
                            throw new IllegalArgumentException("Coloca el ID de la Disciplina quieres consultar");
                        }
                        break;
                    case "Disciplina":
                        if (consultaValida){
                            afiliados = mongoDBManager.obtenerAfiliadosPorDisciplina(queConsulta);
                        } else {
                            throw new IllegalArgumentException("Coloca que Disciplina quieres consultar");
                        }
                        break;
                    case "IdEvento":
                        if (consultaValida) {
                            afiliados = mongoDBManager.obtenerAfiliadosPorIDEvento(Integer.parseInt(queConsulta));
                        } else {
                            throw new IllegalArgumentException("Coloca el ID del Evento quieres consultar");
                        }
                        break;
                    case "Evento":
                        if (consultaValida){
                            afiliados = mongoDBManager.obtenerAfiliadosPorEvento(queConsulta);
                        } else {
                            throw new IllegalArgumentException("Coloca que Evento quieres consultar");
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Coloca algun parametro para Consultar");
                }
            }
            String json = gson.toJson(afiliados);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } catch (IllegalArgumentException e) {
            System.out.println("error en switch consulServlet");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("error", e.getMessage());
            String errorJson = new Gson().toJson(errorMap);
            response.getWriter().write(errorJson);
        }
    }
}