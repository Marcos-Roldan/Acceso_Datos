package gasolinera;
import java.util.*;

public class Cliente_DAO  {

    private Almacenamiento almacenamiento;

    public Cliente_DAO() {
        this.almacenamiento = almacenamiento;
    }

    public void AltaCliente() {
        Scanner sc = new Scanner(System.in);

        List<Cliente> listaClientes = almacenamiento.leerClientes(); //Actualizamos la lista Clientes

        String nombre;
        String telefono;
        String matriculaNueva;

        System.out.println("Introduce el nombre: ");
        nombre = sc.nextLine().trim();
        while(nombre.isEmpty()) {
            System.out.println("No puedes dejar el campo vacio");
            System.out.println("Introduce el nombre: ");
            nombre = sc.nextLine().trim();
        }

        System.out.println("Introduce el telefono: ");
        telefono = sc.nextLine().trim();
        while(telefono.isEmpty()) {
            System.out.println("No puedes dejar el campo vacio");
            System.out.println("Introduce el telefono: ");
            telefono = sc.nextLine().trim();
        }

        System.out.println("Introduce la matricula: ");
        matriculaNueva = sc.nextLine().trim().toUpperCase();
        while(matriculaNueva.isEmpty()) {
            System.out.println("No puedes dejar el campo vacio");
            System.out.println("Introduce el matricula: ");
            matriculaNueva = sc.nextLine().trim().toUpperCase();
        }

        //Comprobamos si la matricula esta repetida
        boolean existe = false;
        for(Cliente c : listaClientes) {
            if(c.getMatricula().equalsIgnoreCase(matriculaNueva)) {
                existe = true;
                break;
            }
        }

        if(existe) {
            System.out.println("Error: La matricua ya esta registrada");
        } else {
            int nuevoID = listaClientes.size() + 1; //.size(): numero total de elementos
            Cliente nuevoCliente = new Cliente(nuevoID, nombre, telefono, matriculaNueva);

            if(almacenamiento.escribirCliente(nuevoCliente)) {
                System.out.println("Cliente guardado correctamente en el archivo CSV");
            }
        }
    }

    public void ListarCliente() {
        List<Cliente> cliente = almacenamiento.leerClientes();
        if(cliente.isEmpty()) {
            System.out.println("No hay clientes registrados");
        } else {
            System.out.println("=== LISTA CLIENTES ===");
            for(Cliente c : cliente) {
                System.out.println(c);
            }
        }
    }

    public void BuscarCliente() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la matricula: ");
        String matricula = sc.nextLine();

        List<Cliente> clientes = almacenamiento.leerClientes();
        boolean encontrado = false;

        for(Cliente c : clientes) {
            if(c.getMatricula().equalsIgnoreCase(matricula)) {
                System.out.println("Cliente encontrado: " + c);
                encontrado = true;
                break;
            }
        }

        if(!encontrado) {
            System.out.println("No se encontro ningun cliente con esta matricula");
        }
    }

}