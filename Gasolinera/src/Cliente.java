package Gasolinera;

public class Cliente {
    private int id; //Entero mayor que cero
    private String nombre; //Obligatorio (No puede estar el campo vacio)
    private String telefono; //Obligatorio
    private String matricula;//Obligatorio, no se puede repetir y en mayusculas(.toUpperCase)

    public Cliente(int id, String nombre, String telefono, String matricula) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.matricula = matricula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "ID = " + id + ", Nombre = " + nombre + ", Telefono = " + telefono + ", Matricula = " + matricula;
    }
}

//Usaremos .trim para eliminar los textos de al principio y al final
//Si registramos una matricula que ya este, ya sea minuscula o mayuscula se considera la misma