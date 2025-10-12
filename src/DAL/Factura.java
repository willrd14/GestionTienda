/*
 * Generar facturas detalladas sobre todos las compras en base a los datos de package BLL
 */

package DAL;

import BLL.Producto;
import java.util.List;

public class Factura {

    private final int id;
    private final String cliente;
    private final List<Producto> productos;
    private final double total;
    private final double precio;
    private final int cantidad;

    public Factura(int id, String cliente, List<Producto> productos, double precioFactura, int cantidadFactura) {
        this.id = id;
        this.cliente = cliente;
        this.productos = productos;
        this.precio = precioFactura;
        this.cantidad = cantidadFactura;
        this.total = calcularTotal();
    }
    
    private double calcularTotal() {
        double totalCalculo = 0;
        for (Producto p : productos) {
            totalCalculo += p.getPrecio() * p.getCantidad();
        }
        return totalCalculo;
    }

    // Getters y Setters
    public double getPrecio() {
        return precio;
    }
    
    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public int getCantidad() {
    return cantidad;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        StringBuilder facturaStr = new StringBuilder();
        facturaStr.append("Factura ID: ").append(id).append("\n");
        facturaStr.append("Cliente: ").append(cliente).append("\n");
        facturaStr.append("Productos:\n");
        for (Producto p : productos) {
            facturaStr.append("- ").append(p.getNombre())
                      .append(" x").append(p.getCantidad())
                      .append(" @ $").append(p.getPrecio())
                      .append(" = $").append(p.getPrecio() * p.getCantidad())
                      .append("\n");
        }
        facturaStr.append("Total: $").append(total).append("\n");
        return facturaStr.toString();
    }
        
}
