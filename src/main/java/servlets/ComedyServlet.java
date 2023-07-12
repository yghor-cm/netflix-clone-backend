package servlets;

import api.MovieAPI;
import api.CategoryUtils;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/comedy")
public class ComedyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        MovieAPI movieAPI = MovieAPI.getInstance();
        String categoryPath = CategoryUtils.getCategoryPath("comedy");
        String jsonResponse = movieAPI.getMovies(categoryPath);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse);
    }
}

