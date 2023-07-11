package servlets;

import api.CategoryUtils;
import api.MovieAPI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/trending")
public class TrendingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MovieAPI movieAPI = MovieAPI.getInstance();
        String categoryPath = CategoryUtils.getCategoryPath("trending");
        String jsonResponse = movieAPI.getMovies(categoryPath);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse);
    }
}


