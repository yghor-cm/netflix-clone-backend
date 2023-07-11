package controller;
import model.Usuario;

import java.util.ArrayList;

public class UsuarioController {
    public static ArrayList<Usuario> usuarios = createUsers();

    public UsuarioController(){}

    public static ArrayList<Usuario> createUsers(){
        ArrayList<Usuario> users = new ArrayList();

        Usuario u1 = new Usuario();
        u1.setNome("Yghor");
        u1.setEmail("yghor@teste.com");
        u1.setSenha("1234");

        users.add(u1);

        Usuario u2 = new Usuario();
        u2.setNome("Augusto");
        u2.setEmail("augusto@teste.com");
        u2.setSenha("1234");

        users.add(u2);

        return users;
    }

    public boolean login(Usuario user){

        boolean logado = false;

        for(Usuario u: UsuarioController.usuarios){

            if(u.getEmail().equals(user.getEmail()) && u.getSenha().equals(user.getSenha())){
                logado = true;
                user.setNome(u.getNome());
                break;
            }

        }

        return logado;
    }

    public boolean register(Usuario newUser) {
        for (Usuario user : usuarios) {
            if (user.getEmail().equals(newUser.getEmail())) {
                return false;
            }
        }
        usuarios.add(newUser);
        return true;
    }

}
