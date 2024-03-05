package co.edu.uptc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet("/dragonball")
public class DragonBallServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (InputStream inputStream = getServletContext().getResourceAsStream("/resources/dragonball.json")) {
            List<DragonBallCharacter> characters = DragonBallDataLoader.loadDragonBallCharacters(inputStream);

            request.setAttribute("characters", characters);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/dragonball.jsp");
            dispatcher.forward(request, response);
        } catch (IOException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().print("Error loading Dragon Ball characters data.");
            e.printStackTrace();
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
}