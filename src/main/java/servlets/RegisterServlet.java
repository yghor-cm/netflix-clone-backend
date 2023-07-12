package servlets;

import com.google.gson.Gson;
import controller.UsuarioController;
import model.Erro;
import model.Usuario;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Gson gson = new Gson();
        Usuario newUser = gson.fromJson(request.getReader(), Usuario.class);

        UsuarioController ucontrol = new UsuarioController();

        if (ucontrol.register(newUser)) {
            String json = gson.toJson(newUser);
            response.getWriter().println(json);
        } else {
            Erro erro = new Erro();
            erro.setDescricao("Falha na inscrição! Email já existe.");
            erro.setCodigo("001");
            String json = gson.toJson(erro);
            response.getWriter().println(json);
        }
    }
}

