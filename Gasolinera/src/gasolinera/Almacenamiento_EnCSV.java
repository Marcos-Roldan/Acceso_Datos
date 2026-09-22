package gasolinera;

import java.util.List;

public class Almacenamiento_EnCSV implements Almacenamiento {

    @Override
    public List<Cliente> leerClientes() {
        return List.of();
    }

    @Override
    public boolean escribirCliente(Cliente cliente) {
        return false;
    }

    @Override
    public List<Pagos_Repostaje> leerPago() {
        return List.of();
    }

    @Override
    public boolean escribirPago(Pagos_Repostaje pago) {
        return false;
    }
}
