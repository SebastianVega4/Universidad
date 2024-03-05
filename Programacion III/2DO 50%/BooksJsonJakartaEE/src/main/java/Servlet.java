import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Service bookService;

    @Override
    public void init() {
        bookService = new BookServiceImpl();
        bookService.loadBooks();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        int pages = Integer.parseInt(request.getParameter("pages"));

        Book newBook = new Book();
        newBook.setId(id);
        newBook.setTitle(title);
        newBook.setAuthor(author);
        newBook.setPages(pages);

        bookService.save(newBook);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(bookService.getBooks()));
    }
}