package UI;
import java.util.*;
import DAL.GestionTienda;

//Clase principal : Contiene menú interactivo y método main
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //Scanner para entrada de datos
        GestionTienda tienda = new GestionTienda(); // Instancia de la tienda
        boolean salir = false;

        //Bucle para mostrar el menú hasta que el usuario decida salor
        while (!salir){
            System.out.println("\n=== SISTEMA GESTIÓN TIENDA ===");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Agregar Productos ordenados.");
            System.out.println("3. Mostrar productos ordeandos.");
            System.out.println("4. Registrar compra..");
            System.out.println("5. Mostrar Historial de Compras");
            System.out.println("6. Salir");

            int opcion = sc.nextInt();
            sc.nextLine(); //Limpia el buffer de entrada

            switch (opcion){
                case 1:
                    System.out.print("Nombre: ");
                    String nombreCliente = sc.nextLine();
                    tienda.registrarClientes(nombreCliente);
                    break;
                case 2:
                    System.out.print("Nombre Producto: ");
                    String nombreProducto = sc.nextLine();
                    System.out.println( " Precio: ");
                    double precioProducto = sc.nextDouble();
                    tienda.agregarProducto(nombreProducto, precioProducto);
                    break;
                case 3:
                    tienda.mostrarProductos();
                    break;
                case 4:
                    System.out.print("Nombre del cliente: ");
                    String clienteCompra = sc.nextLine();
                    System.out.print("Nombre del producto: ");
                    String productoCompra = sc.nextLine();
                    tienda.registrarCompra(clienteCompra, productoCompra);
                    break;
                case 5:
                    tienda.mostrarHistorialCompras();
                    break;
                case 6:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println(" Opción inválida, intente de nuevo.");
            }

        }
        sc.close(); // Cerrar el scanner y liberar recursos de memoria RAM

    }
}


