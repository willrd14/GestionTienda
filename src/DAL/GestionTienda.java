package DAL;
import BLL.Cliente;

import java.util.*;

public class GestionTienda {
    private ArrayList<Cliente> clientes = new ArrayList<>(); // Lista de clientes
    private LinkedList<String> historialCompras = new LinkedList<>(); //Historial de compras
    private HashSet<String> productosUnicos = new HashSet<>(); // Productos sin duplicados
    private TreeSet<String> productosOrdenados = new TreeSet<>(); // Productos ordenados alfabeticamente
    private  HashMap<String, Double> inventario = new HashMap<>(); //Mapa de productos con precio

    //Método para registrar un nuevo cliente
    public void registrarClientes(String nombre) {
        clientes.add(new Cliente(nombre)); // agrega un nuevo cliente a la lista
        System.out.println("Cliente " + nombre + "registrado con éxito");
    }

    //Método para agregar productos al inventario
    public void agregarProducto(String nombre, double precio){
        if (productosUnicos.add(nombre)) { // HashSet evita productos duplicados
            productosOrdenados.add(nombre); // TreeSet mantiene los produdctos ordenados
            inventario.put(nombre, precio); // HashMap almacena productos con precios
            System.out.println("Producto ' " + nombre + "' agregado correctamente.");
        } else {
            System.out.println("El producto ya existe en el inventario.");
        }
    }

    //Mostrar los productos ordenados alfabéticamente
    public void mostrarProductos(){
        if (productosOrdenados.isEmpty()){
            System.out.println("No hay productos en el inventario.");
            return;
        }
        System.out.println("\n=== INVENTARIO DE PRODUCTOS ===");
        for (String producto : productosOrdenados) { //TreeSet garantiza el orden alfabético.
            System.out.println(" " + producto + " - Precio: $" + inventario.get(producto));
        }
    }

    //Método para registrar una compra
    public void registrarCompra(String nombreCliente, String nombreProducto){
        //Verificar si el cliente existe
        boolean clienteExiste = false;
        for (Cliente cliente : clientes){
            if (cliente.getNombre().equalsIgnoreCase(nombreCliente)){
                clienteExiste = true;
                break;
            }
        }
        if (!clienteExiste){
            System.out.println("Cliente no registrado.");
            return;
        }
        //Verificar si el producto está en inventario
        if(!inventario.containsKey(nombreProducto)){
            System.out.println("Producto no disponible en el inventario");
            return;
        }

        // Registrar la compra en 'LinkedList'
        historialCompras.add(nombreCliente + " compró " + nombreProducto);
        System.out.println("Compra registrada con éxito.");
    }

    //Método para mostrar el historial de compras
    public void mostrarHistorialCompras(){
        if(historialCompras.isEmpty()){
            System.out.println("No hay compras registradas.");
            return;
        }

        System.out.println("\n=== HISTORIAL DE COMPRAS ===");
        for (String compra : historialCompras){
            System.out.println(" " + compra);
        }

    }
}
