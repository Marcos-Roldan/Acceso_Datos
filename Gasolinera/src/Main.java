package gasolinera;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        Cliente_DAO cliente_metodos = new Cliente_DAO();
        Pagos_Repostajes_DAO pagos_repostajes_metodos = new Pagos_Repostajes_DAO();

        do {
            Menu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    cliente_metodos.AltaCliente();
                    break;
                case 2:
                    cliente_metodos.ListarCliente();
                    break;
                case 3:
                    cliente_metodos.BuscarCliente();
                    break;
                case 4:
                    pagos_repostajes_metodos.ProcesarPagoRepostaje();
                    break;
                case 0:
                    System.out.println("Has salido del programa");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while(opcion != 0);
    }

    public static void Menu() {
        System.out.println("== GESTION DE GASOLINERA ==");
        System.out.println("1. Dar de alta un cliente");
        System.out.println("2. Listar clientes");
        System.out.println("3. Buscar clientes");
        System.out.println("4. Procesar un pago de repostaje");
        System.out.println("0. Salir");
        System.out.println("Opcion: ");
    }
}