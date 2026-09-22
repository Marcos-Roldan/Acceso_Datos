package gasolinera;
import java.util.*;

public class Cliente_DAO {

    ArrayList<Cliente> matriculaRepetida = new ArrayList<>();

    public void AltaCliente() {
        Scanner sc = new Scanner(System.in);

        String nombre;
        String telefono;
        String matriculaNueva;

        System.out.println("Introduce el nombre: ");
        nombre = sc.nextLine();
        while(nombre.isEmpty()) {
            System.out.println("No puedes dejar el campo vacio");
            System.out.println("Introduce el nombre: ");
            nombre = sc.nextLine();
        }

        System.out.println("Introduce el telefono: ");
        telefono = sc.nextLine();
        while(telefono.isEmpty()) {
            System.out.println("No puedes dejar el campo vacio");
            System.out.println("Introduce el telefono: ");
            telefono = sc.nextLine();
        }

        System.out.println("Introduce la matricula: ");
        matriculaNueva = sc.nextLine();
        while(matriculaNueva.isEmpty()) {
            System.out.println("No puedes dejar el campo vacio");
            System.out.println("Introduce el matricula: ");
            matriculaNueva = sc.nextLine();
        }

        for(Cliente cliente : matriculaRepetida) {
            if(matriculaNueva.equalsIgnoreCase(cliente.getMatricula())) {
                System.out.println("ERROR: La matricula esta repetida");
            } else {
                System.out.println("Cliente guardado correctamente");
            }
        }
    }

    public void ListarCliente() {
        System.out.println("Listado de los clientes...");
    }

    public void BuscarCliente() {
        System.out.println("Has buscado a un cliente...");
    }

}