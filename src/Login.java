
import java.util.HashMap;

public class Login {
    private HashMap<String, String> usuarios;

    public Login() {
        this.usuarios = new HashMap<>();
    }

    public void addUsuario(String usuario, String senha) {
        usuarios.put(usuario, senha);
    }

    public void removerUsuario(String usuario) {
        usuarios.remove(usuario);
    }

    public boolean verificarCredenciais(String usuario, String senha) {
        String senhaSalva = usuarios.get(usuario);
        return senhaSalva != null && senhaSalva.equals(senha);
    }
}