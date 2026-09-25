package gasolinera;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Pagos_Repostajes_DAO {

    private Almacenamiento almacenamiento;
    private Cliente_DAO clienteDAO;

    public Pagos_Repostajes_DAO() {
        this.almacenamiento = almacenamiento;
    }

    public void ProcesarPagoRepostaje(Scanner scanner) {
        Scanner sc = new Scanner(System.in);

        List<Cliente> cliente = almacenamiento.leerClientes();

        if(cliente.isEmpty()) {
            System.out.println("Error: Primero debe darse de alta un cliente");
            //Volver al menu
        }

        System.out.println("=== LOS CLIENTES DISPONIBLES SON ===");
        clienteDAO.ListarCliente();

        System.out.println("Introduce el ID del cliente: ");
        int idCliente = sc.nextInt();

        while(!scanner.hasNextInt()) {
            System.out.println("Error: El numero intorducido no es un entero");
            System.out.println("Introduce el ID del cliente: ");
            idCliente = sc.nextInt();
        }

        boolean encontrado = false;

        for(Cliente c : cliente) {
            if(c.getId() == idCliente) {
                System.out.println("Cliente encontrado: " + c);
                encontrado = true;
                break;
            }
        }

        if(!encontrado) {
            System.out.println("No se encontro ningun cliente con este ID");
            //Llevar al menu sin registrar el pago
        }

        System.out.println("Introduce la fecha: ");
        LocalDate fecha = LocalDate.parse(sc.next());

        while(!scanner.hasNext()) {
            System.out.println("Error: La fecha introducida no corresonde a un campo valido");
            System.out.println("Introduce la fecha: ");
            fecha = LocalDate.parse(sc.next());
        }
    }

    public void ConsultarPagoRepostaje() {
        System.out.println("Has consultadp el pago de repostaje");
    }
}