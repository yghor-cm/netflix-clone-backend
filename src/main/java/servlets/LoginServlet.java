package servlets;

import com.google.gson.Gson;
import controller.UsuarioController;
import model.Erro;
import model.Usuario;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Gson gson = new Gson();
        Usuario user = gson.fromJson(request.getReader(), Usuario.class);

        UsuarioController ucontrol = new UsuarioController();

        if(ucontrol.login(user)){
            request.getSession().setAttribute("usuario", user);
            getServletContext().setAttribute(request.getSession().getId(), request.getSession());
            user.setSessionID(request.getSession().getId());
            String json = gson.toJson(user);
            response.getWriter().println(json);

        }else{
            request.getSession().removeAttribute("usuario");

            Erro erro = new Erro();
            erro.setDescricao("Login Não Realizado!");
            erro.setCodigo("001");

            String json = gson.toJson(erro);
            response.getWriter().println(json);
        }
    }
}

