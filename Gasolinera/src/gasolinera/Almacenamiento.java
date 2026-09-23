package gasolinera;

import java.util.List;

public interface Almacenamiento {

    //METODOS PARA CLIENTES
    List<Cliente> leerClientes();
    boolean escribirCliente(Cliente cliente);

    //METODOS PARA PAGOS_REPOSTAJES
    List<Pagos_Repostaje> leerPago();
    boolean escribirPago(Pagos_Repostaje pago);
}