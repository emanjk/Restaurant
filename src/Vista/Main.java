
package Vista;
import Modelo.Mesa;
import Persistencia.MesaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    private static Connection connection;
    private static MesaData mesaData;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Conexión a la base de datos
        conectarBaseDeDatos();

        // Inicializar MesaData
        mesaData = new MesaData(connection);

        // Menú principal
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1 -> agregarMesa();
                case 2 -> buscarMesa();
                case 3 -> modificarMesa();
                case 4 -> altaLogicaMesa();
                case 5 -> bajaLogicaMesa();
                case 6 -> listarMesas();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);

        cerrarConexion();
    }

    private static void mostrarMenu() {
        System.out.println("\n----- Menú de Gestión de Mesas -----");
        System.out.println("1. Agregar Mesa");
        System.out.println("2. Buscar Mesa por ID");
        System.out.println("3. Modificar Mesa");
        System.out.println("4. Dar de Alta Mesa");
        System.out.println("5. Dar de Baja Mesa");
        System.out.println("6. Listar Mesas");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void agregarMesa() {
        System.out.println("\n--- Agregar Nueva Mesa ---");
        System.out.print("Capacidad: ");
        int capacidad = scanner.nextInt();
        System.out.print("Estado (1 = Activo, 0 = Inactivo): ");
        boolean estado = scanner.nextInt() == 1;
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Sector: ");
        String sector = scanner.nextLine();
        System.out.print("Situación (libre, ocupada, reservada): ");
        String situacion = scanner.nextLine();

        Mesa mesa = new Mesa(capacidad, estado, sector, situacion);
        mesaData.guardarMesa(mesa);
    }

    private static void buscarMesa() {
        System.out.println("\n--- Buscar Mesa por ID ---");
        System.out.print("Ingrese el ID de la Mesa: ");
        int id = scanner.nextInt();

        Mesa mesa = mesaData.buscarMesa(id);
        if (mesa != null) {
            System.out.println(mesa);
        } else {
            System.out.println("No se encontró la mesa con ID: " + id);
        }
    }

    private static void modificarMesa() {
        System.out.println("\n--- Modificar Mesa ---");
        System.out.print("Ingrese el ID de la Mesa a modificar: ");
        int id = scanner.nextInt();

        Mesa mesa = mesaData.buscarMesa(id);
        if (mesa != null) {
            System.out.print("Nueva Capacidad: ");
            mesa.setCapacidad(scanner.nextInt());
            System.out.print("Nuevo Estado (1 = Activo, 0 = Inactivo): ");
            mesa.setEstado(scanner.nextInt() == 1);
            scanner.nextLine(); // Consumir el salto de línea
            System.out.print("Nuevo Sector: ");
            mesa.setSector(scanner.nextLine());
            System.out.print("Nueva Situación (libre, ocupada, reservada): ");
            mesa.setSituacion(scanner.nextLine());

            mesaData.modificarMesa(mesa);
        } else {
            System.out.println("No se encontró la mesa con ID: " + id);
        }
    }

    private static void altaLogicaMesa() {
        System.out.println("\n--- Dar de Alta Mesa ---");
        System.out.print("Ingrese el ID de la Mesa: ");
        int id = scanner.nextInt();
        mesaData.altaLogicaMesa(id);
    }

    private static void bajaLogicaMesa() {
        System.out.println("\n--- Dar de Baja Mesa ---");
        System.out.print("Ingrese el ID de la Mesa: ");
        int id = scanner.nextInt();
        mesaData.bajaLogicaMesa(id);
    }

    private static void listarMesas() {
        System.out.println("\n--- Listar Todas las Mesas ---");
        // Método para listar mesas (puede agregarse en MesaData)
        // Ejemplo:
        // List<Mesa> mesas = mesaData.listarMesas();
        // mesas.forEach(System.out::println);
    }

    private static void conectarBaseDeDatos() {
        try {
            String url = "jdbc:mysql://localhost:3306/tu_base_de_datos";
            String user = "root";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    private static void cerrarConexion() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
