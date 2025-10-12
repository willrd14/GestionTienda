package BLL;

import java.util.HashMap;

public class Inventario {

     private final HashMap<String, Double> inventario = new HashMap<>(); //Mapa de productos con precio

    //Método para agregar productos al inventario
    public void agregarProducto(String nombre, double precio){
        inventario.put(nombre, precio);
        System.out.println("Producto " + nombre + " agregado al inventario con precio $" + precio);
    }

    //Mostrar productos disponibles sin el precio
    public void mostrarProductosDisponibles(){
        if(inventario.isEmpty()){
            System.out.println("El inventario está vacío.");
            return;
        }

        System.out.println("\n=== PRODUCTOS DISPONIBLES ===");
        for (String producto : inventario.keySet()){
            System.out.println("Producto: " + producto);
        }
    }

    //Método para mostrar valor total del inventario
    public void mostrarValorTotalInventario(){
        if(inventario.isEmpty()){
            System.out.println("El inventario está vacío.");
            return;
        }

        double valorTotal = 0.0;
        for (double precio : inventario.values()){
            valorTotal += precio;
        }

        System.out.printf("El valor total del inventario es: $%.2f%n", valorTotal);
    }
    
}
