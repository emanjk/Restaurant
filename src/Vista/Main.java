package Vista;

/*Importamos las clases de entidad */
import Modelo.Mesa;
import Modelo.Mesero;
import Modelo.Producto;
import Modelo.Reserva;

/*Importamos las clases Data*/
import java.sql.Connection;
import Persistencia.Conexion;
import Persistencia.MesaData;
import Persistencia.MeseroData;
import Persistencia.ProductoData;
import Persistencia.ReservaData;

/*clases de utilidad + JDBC*/
import java.time.LocalDate;
import java.time.LocalDateTime; //para fecha y hora
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {

    private static Connection connection; // Conexión a la base de datos
    private static MesaData mesaData; 
    private static MeseroData meseroData;
    private static ReservaData reservaData;
    private static ProductoData productoData;
    
    private static Scanner scanner = new Scanner(System.in);

    //Main static
    public static void main(String[] args) {   
        connection = Conexion.getConexion(); //conexion a la bd
        
        if (connection == null) {
            JOptionPane.showMessageDialog(null, "No se pudo establecer la conexion con la BDS");
        }else {
            mesaData = new MesaData(connection); // vinculada a la conexion bds
            meseroData = new MeseroData (connection);// vinculada a la conexion bds
            reservaData = new ReservaData (connection);// vinculada a la conexion bds
            productoData = new ProductoData (connection);// vinculada a la conexion bds
            
            // menuPrincipal(); mesaData ya fue testeado en la anterior entrega.
            testMeseros(meseroData);
            testReservas(reservaData);
            testProductos(productoData);
                 
        }
    }
   
          
    
    
    
    //Test meseroData. (Ope. CRUD)
    private static void testMeseros(MeseroData meseroData){
     System.out.println("----------------------------------------------------------");   
     System.out.println("**TEST MeseroData**\n");
     
     //1. Crear y guardar un Mesero
     Mesero nuevoMesero = new Mesero ("Matias", 4134576, "266343234", "matiSo@gmail.com", LocalDate.of(2024,10,26), "noche", "Interior", true);
     Mesero meseroExistente= meseroData.buscarMeseroPorDni(nuevoMesero.getDni());
     if(meseroExistente==null){
         meseroData.guardarMesero(nuevoMesero); 
     }else {
         System.out.println("El mesero que quire agregar ya se encuentra registrado. DNI: " +nuevoMesero.getDni());   
     }
      System.out.println("\n");
     
      
     // 2. Listar meseros
     System.out.println("Lista de Meseros disponibles: ");
     List<Mesero> meseros = meseroData.listarMeseros();
     System.out.println(meseros);
     
     //3. Actualizar mesero
     System.out.println("Actualizar mesero con ID 2");
     meseroExistente = meseroData.buscarMeseroPorId(2);
     if(meseroExistente!=null){
         meseroExistente.setEstado(false);
         meseroData.modificarMesero(meseroExistente);  
     }else{
         System.out.println("No se encontro el mesero con ID 2");
     }
         
    //4. Dar de alta un mesero
    System.out.println("Dar de alta al mesero con ID 2");
    meseroExistente= meseroData.buscarMeseroPorId(2);
    if(meseroExistente!=null){
        meseroData.altaLogicaMesero(2);
    }else{
        System.out.println("No se encontro el mesero con ID 2"); 
    }
     
    // 5. Dar de baja un mesero 
    System.out.println("Dar de baja un mesero con el ID 3");
    meseroExistente =  meseroData.buscarMeseroPorId(3);
    if(meseroExistente!=null){
       meseroData.bajaLogicaMesero(3);
    }else{
        System.out.println("No se encontro mesero con el ID 3");
    }        
  
    System.out.println("----------------------------------------------------------");   
    }
    
    
    //Test reservaData. (Ope. CRUD)
    private static void testReservas(ReservaData reservaData){
       System.out.println("**TEST ReservaData**\n");
       
       //1. Guardar una reserva de mesa.    
       System.out.println("Agregar una reserva");
    
       Mesa mesa = new Mesa(1, 4, true, "Principal", "libre"); 
       LocalDateTime fechaHora = LocalDateTime.of(2024, 10, 27, 19, 30); // Fecha y hora de la reserva
       Reserva nuevaReserva = new Reserva(mesa, "Emanuel Q.", "265867744", 4, "Terraza", fechaHora, true);

       // Verificar disponibilidad antes de agregar
       if (reservaData.verificarDisponibilidad(mesa.getIdMesa(), fechaHora)) {
           reservaData.agregarReserva(nuevaReserva);
           System.out.println("Reserva agregada con éxito: " + nuevaReserva);
       }else {
            System.out.println("La mesa no esta disponible para la fecha y hora seleccionadas.");
       }
        System.out.println("\n");
        
       //2. Mostrar todas las reservas
       System.out.println("Listado de reservas: ");
       List<Reserva> listaReservas = reservaData.listarReservas()  ;
       for(Reserva r: listaReservas){
           System.out.println(r);
       }
        System.out.println("\n");
       
       //3. Mostrar reserva por ID
       System.out.println("Mostrar la reserva con ID 1: \n");
       Reserva reservaPorId = reservaData.obtenerReservaPorId(1) ;
       System.out.println(reservaPorId);    
        System.out.println("\n");
       
       //4. Actualizar reserva
       System.out.println("Actualizar la reserva con ID 1: ");
       Reserva reservaActualizar = new Reserva(mesa, "Emanuel Q. Actualizado", "265867711", 6, "Terraza", fechaHora, true);
       reservaActualizar.setIdReserva(1);
       
       //5. Verificar disponibilidad antes de actualizar
       if (reservaData.verificarDisponibilidad(mesa.getIdMesa(), reservaActualizar.getFechaHora())) {
           reservaData.modificarReserva(reservaActualizar);
       }else {
           System.out.println("La mesa no esta disponible para la nueva fecha y hora seleccionadas.");
       }
      
       
       //6. Alta reserva
       System.out.println("Alta logica de la reserva con ID 2");
       reservaData.altaLogicaReserva(2);
       
       //7.Baa logica
       System.out.println("Baja logica de la reserva con ID 1");
       reservaData.bajaLogicaReserva(1);
       
       
        System.out.println("----------------------------------------------------------");
    }   
    
     
    
    
    
    //Test productoData. (Ope. CRUD)
    private static void testProductos(ProductoData productoData){
        System.out.println("**TEST productoData**\n");
        
        //1.  Guardar producto
        Producto nuevoProducto = new Producto (126, "waffles", "desayuno", "waffles de avena", 550, 20, true);
        Producto productoExistente = productoData.buscarProductoPorCodigo(126);
        if(productoExistente==null){
          productoData.guardarProducto(nuevoProducto);       
        }else{
          System.out.println("El producto con codigo "+nuevoProducto.getCodigo()+" Ya existe");
        }
        System.out.println("\n");
        
        
        //2. Buscar producto por codigo
        System.out.println("Buscar producto por codigo");
        int codigoABuscar = 126;
        Producto productoEncontrado = productoData.buscarProductoPorCodigo(codigoABuscar);

        if (productoEncontrado != null) {
            System.out.println("Producto encontrado: " + productoEncontrado.getNombre() + " - " + productoEncontrado.getDescripcion());
        } else {
            System.out.println("No se encontró ningún producto con el código " + codigoABuscar);
        }
        System.out.println("\n");
        
        //3. Listar productos
        System.out.println("Listar productos");
        List<Producto> productos= productoData.mostrarMenu();
        System.out.println(productos);
        System.out.println("\n");
        
        //4.Modificar producto
        System.out.println("Actualizar producto con ID 126");
        productoExistente = productoData.buscarProductoPorCodigo(126);
        if(productoExistente==null){
          System.out.println("El producto que quiere modificar no esta registrado.");
        }else{
          productoExistente.setDescripcion("Waffles de chocolate");
          productoExistente.setPrecio(600);
          productoData.modificarProducto(productoExistente);
        }
        System.out.println("\n");
          
        //5. Alta producto(sabemos q existe)
        System.out.println("Damos de alta a un producto con ID: 16" );
        productoData.altaLogicaProducto(16);
        System.out.println("\n");
        
        //6. Baja producto(sabemos q existe)
        System.out.println("Damos de baja a un producto con ID: 15");
        productoData.bajaLogicaProducto(15);
         
      System.out.println("----------------------------------------------------------");  
   
    }
    
    
    
    
    private static void menuPrincipal(){
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
                case 7 ->  listarPorSector();
                case 8 -> buscarMesasPorSituacion();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opcion no valida. Intente de nuevo.");
            }
        } while (opcion != 0);
        
    }
    

    //Test mesaData. (Ope. CRUD)
    private static void mostrarMenu() {
        System.out.println("\n ***MENU DE GESTION DE MESAS***");
        System.out.println("1. Agregar Mesa");
        System.out.println("2. Buscar Mesa por ID");
        System.out.println("3. Modificar Mesa");
        System.out.println("4. Dar de Alta Mesa");
        System.out.println("5. Dar de Baja Mesa");
        System.out.println("6. Listar Todas las Mesas");
        System.out.println("7. Listar las mesas por sector");
        System.out.println("8. Listar las mesas por  Situacion"); //chequaer tipo
        System.out.println("0. Salir");
    }

    // 1. Agregar una nueva mesa
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

    // 2. Buscar una mesa por ID
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

    // 3.  Modificar una mesa existente
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

    // 4. Dar de alta una mesa
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

    // 5. Dar de baja una mesa
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

    // 6. Listar todas las mesas
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

    // 7. Listar mesas por sector
    private static void listarPorSector(){ 
         if (mesaData == null) {
        System.out.println("Error: MesaData no está inicializado.");
        return;
        }

        System.out.println("\n--- Listar Mesas por Sector ---");
        System.out.print("Ingrese el sector (por ejemplo: terraza, interior, etc.): ");
        String sector = scanner.nextLine();

        List<Mesa> mesas = mesaData.listarMesasPorSector(sector);

        if (!mesas.isEmpty()) {
            for (Mesa mesa : mesas) {
                System.out.println(mesa);
            }
        } else {
            System.out.println("No se encontraron mesas en el sector: " + sector);
        }

        }
    
    
    // 8. Buscar mesas por situación
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
