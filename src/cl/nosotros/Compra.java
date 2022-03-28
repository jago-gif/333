package cl.nosotros;


public class Compra extends Producto{
    private int total;
    private String fecha;
    public Compra(int valorProducto, String nombreProducto, int stock) {
        super(valorProducto, nombreProducto, stock);
    }

    public Compra(int valorProducto, String nombreProducto, int total, String fecha) {
        super(valorProducto, nombreProducto);
        this.total = total;
        this.fecha = fecha;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
