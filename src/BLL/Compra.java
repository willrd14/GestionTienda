package BLL;

public class Compra {
    public String articulo;
    public Double precio;
    public int cantidadProducto;

    public Compra(String articulo, Double precio, int cantidadProducto) {
        this.articulo = articulo;
        this.precio = precio;
        this.cantidadProducto = cantidadProducto;
    }

    public double calcularPrecio() {
        return precio * cantidadProducto;
    }

}
