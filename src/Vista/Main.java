package Vista;

import Modelo.Mesa;
import Modelo.Conexion;
import Persistencia.MesaData;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Connection connection; // Conexión a la base de datos
    private static MesaData mesaData; // Objeto de acceso a datos de Mesa
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Establecer la conexión a la base de datos usando el Singleton
        connection = Conexion.getConexion();

        // Verificar si la conexión fue exitosa
        if (connection != null) {
            // Inicializar MesaData con la conexión
            mesaData = new MesaData(connection);
            
            // Mostrar el menú principal
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
                    case 7 -> buscarMesasPorSituacion();
                    case 0 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción no válida. Intente de nuevo.");
                }
            } while (opcion != 0);

        } else {
            System.out.println("No se pudo establecer la conexión con la base de datos.");
        }
    }

    // Mostrar el menú principal
    private static void mostrarMenu() {
        System.out.println("\n----- Menú de Gestión de Mesas -----");
        System.out.println("1. Agregar Mesa");
        System.out.println("2. Buscar Mesa por ID");
        System.out.println("3. Modificar Mesa");
        System.out.println("4. Dar de Alta Mesa");
        System.out.println("5. Dar de Baja Mesa");
        System.out.println("6. Listar Todas las Mesas");
        System.out.println("7. Buscar Mesas por Situación");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Agregar una nueva mesa
    private static void agregarMesa() {
        if (mesaData == null) {
            System.out.println("Error: MesaData no está inicializado.");
            return;
        }
        
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

    // Buscar una mesa por ID
    private static void buscarMesa() {
        if (mesaData == null) {
            System.out.println("Error: MesaData no está inicializado.");
            return;
        }

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

    // Modificar una mesa existente
    private static void modificarMesa() {
        if (mesaData == null) {
            System.out.println("Error: MesaData no está inicializado.");
            return;
        }

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

    // Dar de alta lógicamente una mesa
    private static void altaLogicaMesa() {
        if (mesaData == null) {
            System.out.println("Error: MesaData no está inicializado.");
            return;
        }

        System.out.println("\n--- Dar de Alta Mesa ---");
        System.out.print("Ingrese el ID de la Mesa: ");
        int id = scanner.nextInt();
        mesaData.altaLogicaMesa(id);
    }

    // Dar de baja lógicamente una mesa
    private static void bajaLogicaMesa() {
        if (mesaData == null) {
            System.out.println("Error: MesaData no está inicializado.");
            return;
        }

        System.out.println("\n--- Dar de Baja Mesa ---");
        System.out.print("Ingrese el ID de la Mesa: ");
        int id = scanner.nextInt();

        Mesa mesa = mesaData.buscarMesa(id);
        if (mesa != null) {
            mesaData.bajaLogicaMesa(id);
        } else {
            System.out.println("No se encontró la mesa con ID: " + id);
        }
    }

    // Listar todas las mesas
    private static void listarMesas() {
        if (mesaData == null) {
            System.out.println("Error: MesaData no está inicializado.");
            return;
        }

        System.out.println("\n--- Listar Todas las Mesas ---");
        List<Mesa> mesas = mesaData.listarMesas();

        if (!mesas.isEmpty()) {
            for (Mesa mesa : mesas) {
                System.out.println(mesa);
            }
        } else {
            System.out.println("No hay mesas registradas en la base de datos.");
        }
    }

    // Buscar mesas por situación
    private static void buscarMesasPorSituacion() {
        if (mesaData == null) {
            System.out.println("Error: MesaData no está inicializado.");
            return;
        }

        System.out.println("\n--- Buscar Mesas por Situación ---");
        System.out.print("Ingrese la situación (libre, ocupada, reservada): ");
        String situacion = scanner.nextLine();

        List<Mesa> mesas = mesaData.buscarMesasPorSituacion(situacion);

        if (!mesas.isEmpty()) {
            for (Mesa mesa : mesas) {
                System.out.println(mesa);
            }
        } else {
            System.out.println("No se encontraron mesas con la situación: " + situacion);
        }
    }
}
