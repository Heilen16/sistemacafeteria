
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SistemaCafeteria1 {
    private static final Queue<Pedido> pedidos = new LinkedList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("=== Sistema de Gestión de Pedidos en la Cafetería ===");
            System.out.println("1. Registrar un Pedido");
            System.out.println("2. Atender el Próximo Pedido");
            System.out.println("3. Verificar el Estado de los Pedidos Pendientes");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarPedido();
                    break;
                case 2:
                    atenderPedido();
                    break;
                case 3:
                    verificarPedidosPendientes();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
            System.out.println();
        } while (opcion != 4);
    }

    private static void registrarPedido() {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();

        Pedido pedido = new Pedido(nombreCliente);

        String continuar;
        do {
            System.out.print("Ingrese el nombre del producto: ");
            String nombreProducto = scanner.nextLine();
            System.out.print("Ingrese la cantidad del producto: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            pedido.agregarProducto(nombreProducto, cantidad);

            System.out.print("¿Desea agregar otro producto al pedido? (s/n): ");
            continuar = scanner.nextLine();
        } while (continuar.equalsIgnoreCase("s"));

        pedidos.add(pedido);
        System.out.println("Pedido registrado exitosamente.");
    }

    private static void atenderPedido() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos pendientes.");
        } else {
            Pedido pedido = pedidos.poll();
            System.out.println("Atendiendo el pedido de: " + pedido.getNombreCliente());
            System.out.println(pedido);
        }
    }

    private static void verificarPedidosPendientes() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos pendientes.");
        } else {
            System.out.println("Pedidos pendientes:");
            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
            }
     } 
 }
}
