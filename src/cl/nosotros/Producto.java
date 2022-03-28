package cl.nosotros;

public class Producto {
    private int valorProducto;
    private String nombreProducto;
    private int stock;

    //constructor
    public Producto(int valorProducto, String nombreProducto, int stock) {
        this.valorProducto = valorProducto;
        this.nombreProducto = nombreProducto;
        this.stock = stock;
    }
    public Producto(int valorProducto, String nombreProducto) {
        this.valorProducto = valorProducto;
        this.nombreProducto = nombreProducto;
    }

    public Producto() {

    }

    //getters and setters

    public int getValorProducto() {
        return valorProducto;
    }

    public void setValorProducto(int valorProducto) {
        this.valorProducto = valorProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return
                " -> "+nombreProducto +
                " Valor=$" + valorProducto +
                "stock= " + stock ;
    }

}
