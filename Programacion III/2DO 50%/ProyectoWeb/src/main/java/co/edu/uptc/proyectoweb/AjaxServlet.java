package co.edu.uptc.proyectoweb;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ajaxEndpoint")
public class AjaxServlet extends HttpServlet {
    private ClubDeportivoService clubDeportivoService;

    public AjaxServlet() {
        clubDeportivoService = new ClubDeportivoService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        switch (accion) {
            case "agregarDisciplina":
                clubDeportivoService.gestionarDisciplinas(request, response);
                break;
            case "agregarEvento":
                clubDeportivoService.gestionarEventos(request, response);
                break;
            // ...
        }
    }
}
