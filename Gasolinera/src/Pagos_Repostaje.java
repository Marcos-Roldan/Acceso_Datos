import java.time.LocalDate;

public class Pagos_Repostaje {

    private int id;
    private int id_cliente;
    private LocalDate fecha;
    private double importe;
    private double litros;
    private String combustible;

    public Pagos_Repostaje(int id, int id_cliente, LocalDate fecha, double importe, double litros, String combustible) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.fecha = fecha;
        this.importe = importe;
        this.litros = litros;
        this.combustible = combustible;
    }

    public int getId() {
        return id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getImporte() {
        return importe;
    }

    public double getLitros() {
        return litros;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }
}
