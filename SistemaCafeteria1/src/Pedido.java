
import java.util.LinkedList;

class Pedido {
    private final String nombreCliente;
    private final LinkedList<Producto> productos;

    public Pedido(String nombreCliente) {
        this.nombreCliente = nombreCliente;
        this.productos = new LinkedList<>();
    }

    public void agregarProducto(String nombreProducto, int cantidad) {
        productos.add(new Producto(nombreProducto, cantidad));
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public LinkedList<Producto> getProductos() {
        return productos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente: ").append(nombreCliente).append("\nProductos:\n");
        for (Producto producto : productos) {
            sb.append("- ").append(producto).append("\n");
        }
        return sb.toString();
    }
}
