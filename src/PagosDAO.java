import java.time.LocalDate;
import java.util.*;

public class PagosDAO {

    private final Almacenamiento almacenamiento;

    public PagosDAO(Almacenamiento almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public void ProcesarPagoRepostaje() {
        Scanner sc = new Scanner(System.in);
        List<Cliente> clientes = almacenamiento.leerClientes();

        if (clientes.isEmpty()) {
            System.out.println("Primero debes dar de alta un cliente.");
            return;
        }

        // Mostrar clientes disponibles
        System.out.println("ID | NOMBRE | TELEFONO | MATRICULA");
        for (Cliente c : clientes) {
            System.out.println(c.getId() + " | " + c.getNombre() + " | " + c.getTelefono() + " | " + c.getMatricula());
        }

        // Pedir ID de cliente
        System.out.print("ID del cliente: ");
        int idCliente = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer del scanner

        // Comprobar si existe el cliente
        Cliente clienteEncontrado = null;
        for (Cliente c : clientes) {
            if (c.getId() == idCliente) {
                clienteEncontrado = c;
            }
        }

        if (clienteEncontrado == null) {
            System.out.println("No existe un cliente con ese identificador. No se ha registrado el pago.");
            return;
        }

        // Pedir Fecha
        System.out.print("Fecha (yyyy-mm-dd; vacio para hoy): ");
        String textoFecha = sc.nextLine().trim();
        LocalDate fecha;

        if (textoFecha.isEmpty()) {
            fecha = LocalDate.now();
        } else {
            fecha = LocalDate.parse(textoFecha);
        }

        // Pedir Importe
        System.out.print("Importe: ");
        double importe = sc.nextDouble();
        while (importe <= 0) {
            System.out.println("No puedes dejar el campo vacio o poner un importe menor o igual a 0");
            System.out.print("Importe: ");
            importe = sc.nextDouble();
        }

        // Pedir Litros
        System.out.print("Litros: ");
        double litros = sc.nextDouble();
        while (litros <= 0) {
            System.out.println("No puedes dejar el campo vacio o poner litros menor o igual a 0");
            System.out.print("Litros: ");
            litros = sc.nextDouble();
        }
        sc.nextLine(); // Limpiar buffer

        // Pedir Combustible
        System.out.print("Combustible: ");
        String combustible = sc.nextLine().trim();
        while (combustible.isEmpty()) {
            System.out.println("No puedes dejar el campo vacio");
            System.out.print("Combustible: ");
            combustible = sc.nextLine().trim();
        }

        // Calcular el nuevo ID del pago (maximo + 1)
        List<Pagos> pagos = almacenamiento.leerPagos();
        int nuevoId = 1;
        for (Pagos p : pagos) {
            if (p.getId() >= nuevoId) {
                nuevoId = p.getId() + 1;
            }
        }

        // Guardar pago
        Pagos nuevoPago = new Pagos(nuevoId, idCliente, fecha, importe, litros, combustible);
        if (almacenamiento.escribirPagos(nuevoPago)) {
            System.out.println("Pago " + nuevoId + " registrado para " + clienteEncontrado.getNombre() + ": " + importe);
        }
    }

    public void ConsultarPagos() {
        List<Pagos> listaPagos = almacenamiento.leerPagos();
        List<Cliente> clientes = almacenamiento.leerClientes();

        if (listaPagos.isEmpty()) {
            System.out.println("No hay pagos registrados.");
            return;
        }

        // Ordenar por Fecha descendente e ID descendente con el bucle tradicional
        for (int i = 0; i < listaPagos.size() - 1; i++) {
            for (int j = i + 1; j < listaPagos.size(); j++) {
                Pagos p1 = listaPagos.get(i);
                Pagos p2 = listaPagos.get(j);

                if (p1.getFecha().isBefore(p2.getFecha())) { //Cambiamos la ordenacion por otra
                    listaPagos.set(i, p2);
                    listaPagos.set(j, p1);
                } else if (p1.getFecha().isEqual(p2.getFecha())) {
                    if (p1.getId() < p2.getId()) {
                        listaPagos.set(i, p2);
                        listaPagos.set(j, p1);
                    }
                }
            }
        }

        System.out.println("ID | CLIENTE | FECHA | IMPORTE | LITROS | COMBUSTIBLE");
        for (Pagos p : listaPagos) {
            String nombreCliente = "Desconocido";
            for (Cliente c : clientes) {
                if (c.getId() == p.getId_cliente()) {
                    nombreCliente = c.getNombre();
                }
            }
            System.out.println(p.getId() + " | " + nombreCliente + " | " + p.getFecha() + " | " + p.getImporte() + " € | " + p.getLitros() + " L | " + p.getCombustible());
        }
    }
}