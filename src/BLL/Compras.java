package BLL;

import java.util.LinkedList;

public class Compras {

   private final LinkedList<String> historialCompras = new LinkedList<>(); //Historial de compras

    //Método para registrar compras
       public void registrarCompra(String producto){
        historialCompras.add(producto);
        System.out.println("Compra registrada: " + producto);
    }

    //Método para mostrar el historial de compras
    public void mostrarHistorialCompras(){
        if(historialCompras.isEmpty()){
            System.out.println("No hay compras registradas.");
            return;
        }

        System.out.println("\n=== HISTORIAL DE COMPRAS ===");
        for (String compra : historialCompras){
            System.out.println("Compra: " + compra);
        }
    }
}
