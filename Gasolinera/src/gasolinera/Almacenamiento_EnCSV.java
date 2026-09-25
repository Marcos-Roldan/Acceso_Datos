package gasolinera;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Almacenamiento_EnCSV implements Almacenamiento {

    private Path rutaClientes = Path.of("Cliente.csv");
    private Path rutaPagos = Path.of("Pagos_Repostaje.csv");

    @Override
    public List<Cliente> leerClientes() {
        List<Cliente> lista = new ArrayList<>();

        //Si el archivo no existe devolvemos la lista vacia
        if(!Files.exists(rutaClientes)) {
            return lista;
        }

        //ABRIMOS EL ARCHIVO EN MODO LECTURA
        try(BufferedReader in = Files.newBufferedReader(rutaClientes)) {

            String linea = in.readLine(); //Leemos la primera linea
            while(linea != null) { //Mientras siga habiendo lineas en el archivo
                if(!linea.isBlank()) { //Comprobamos que la linea no esta vacia ni contiene espacios
                    String[] datos = linea.split(","); //Cada vez que hay , hay salto de linea
                    int id = Integer.parseInt(datos[0].trim()); //String a Entero
                    String nombre = datos[1].trim();
                    String telefono = datos[2].trim();
                    String matricula = datos[3].trim();

                    lista.add(new Cliente(id, nombre, telefono, matricula));
                }

                linea = in.readLine();
            }

        } catch (IOException ex) {
            System.out.println("Error al leer el archivo de los clientes");
        }

        return lista;
    }

    @Override
    public boolean escribirCliente(Cliente cliente) {
        try {
            Files.createDirectories(rutaClientes.getParent()); //Nos aseguramos de que la carpeta existe, si no existe la crea
        } catch (IOException ex) {
            System.out.println("Error al crear el archivo " +ex);
        }

        try(BufferedWriter out = Files.newBufferedWriter(rutaClientes, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)) { //CREATE para crear el archivo en caso de no existir, APPEND pone el texto al final

            String linea = cliente.getId() + "," + cliente.getNombre() + "," + cliente.getTelefono() + "," + cliente.getMatricula(); //Convierto los atributos del objeto cliente en una solo linea separado por ,

            out.write(linea); //Escribimos la linea en el fichero
            out.newLine(); //Salto de linea para que el siguiente registro se ponga abajo

            return true; //Esta correcto

        } catch (IOException ex) {
            System.out.println("Error al escribir el archivo");
            return false;
        }
    }

    @Override
    public List<Pagos_Repostaje> leerPago() {
        List<Pagos_Repostaje> lista = new ArrayList<>();

        if(!Files.exists(rutaPagos)) {
            return lista;
        }

        try(BufferedReader in = Files.newBufferedReader(rutaPagos)) {

            String linea = in.readLine();
            while(linea != null) {
                if(!linea.isBlank()) {
                    String[] datos = linea.split(";");
                    int id = Integer.parseInt(datos[0]);
                    int id_cliente = Integer.parseInt(datos[1]);
                    LocalDate fecha = LocalDate.parse(datos[2]);
                    double litros = Double.parseDouble(datos[3]);
                    double importe = Double.parseDouble(datos[4]);
                    String combustible = datos[5];

                    lista.add(new Pagos_Repostaje(id, id_cliente, fecha, litros, importe, combustible));
                }

                linea = in.readLine();
            }

        } catch (IOException ex) {
            System.out.println("Error al leer el archivo de los pagos");
        }

        return lista;
    }

    @Override
    public boolean escribirPago(Pagos_Repostaje pago) {
        try {
            Files.createDirectories(rutaPagos.getParent());
        } catch (IOException ex) {
            System.out.println("Error al crear el archivo" + ex);
        }

        try(BufferedWriter out = Files.newBufferedWriter(rutaPagos, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {

            String linea = pago.getId() + "," + pago.getId_cliente() + "," + pago.getFecha() + "," + pago.getImporte() + "," + pago.getLitros() + "," + pago.getCombustible();

            out.write(linea);
            out.newLine();

            return true;

        } catch (IOException ex) {
            System.out.println("Error al escribir el archivo");
            return false;
        }
    }
}