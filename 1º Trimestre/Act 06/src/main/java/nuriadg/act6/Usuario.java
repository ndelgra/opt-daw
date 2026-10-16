package nuriadg.act6;

import java.util.Random;

public class Usuario {
    String nombre;
    String apellidos;
    String email;
    boolean emptyPswd = false;
    String password;


    public Usuario() {
    }

    public Usuario(String nombre, String apellidos, String email, boolean emptyPswd, String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.emptyPswd = emptyPswd;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEmptyPswd() {
        return emptyPswd;
    }

    public void setEmptyPswd(boolean emptyPswd) {
        this.emptyPswd = emptyPswd;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.isBlank()){
            setEmptyPswd(true);
            Random rnd = new Random();
            int num = rnd.nextInt(1000000);
            this.password = String.format("%06d", num);

        } else {
            this.password = password;
        }
    }
}
