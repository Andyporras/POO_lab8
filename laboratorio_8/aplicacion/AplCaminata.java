package aplicacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.io.InputStreamReader;

/**
 * Clase AplCaminata, la cual permite mostrar los distintos menús en consola
 * que permiten ejecutar las funcionalidades de la clase AppCaminatas.
 * Esta clase contiene los atributos estáticos: nombres, apellido, fecha, peso,
 * altura, telefono, correo.
 * 
 * @author
 */
public class AplCaminata {
  static String[] nombres;
  static String[] apellido;
  static String[] fecha;
  static double[] peso;
  static double[] altura;
  static String[] telefono;
  static String[] correo;
  static AppCaminatas C1 = new AppCaminatas();
  // Estas son las declaraciones de los objetos de la entrada y salida estándar
  static BufferedReader in;
  static PrintStream out;

  public static void main(String[] args) throws ParseException, java.io.IOException {
    nombres = new String[10];
    apellido = new String[10];
    peso = new double[10];
    fecha = new String[10];
    // Se crean los objetos tanto para la entrada de datos desde el
    // teclado (in) como para la salida de datos a la consola (out)
    in = new BufferedReader(new InputStreamReader(System.in));
    out = System.out;
    boolean noSalir = true;
    int pOpcion;
    do {
      mostrarMenu();
      pOpcion = leerpOpcion();
      noSalir = ejecutarAccion(pOpcion);
    } while (noSalir);
    out.println("Hasta luego, vuelva pronto.");
  }

  public static void mostrarMenu() {
    out.println("1. Senderismo");
    out.println("2. Lugares");
    out.println("3. Caminatas");
    out.println("4. Salir");
  }

  static int leerpOpcion() throws java.io.IOException {
    int pOpcion;
    out.print("Seleccione su opción: ");
    pOpcion = Integer.parseInt(in.readLine());
    out.println();
    return pOpcion;
  }

  static boolean ejecutarAccion(int pOpcion) throws ParseException, java.io.IOException {
    boolean noSalir = true;
    switch (pOpcion) {
      case 1:
        menuSenderista();
        pOpcion = leerpOpcion();
        ejecutarMenuSenderista(pOpcion);
        break;
      case 2:
        menuLugares();
        int opcion = leerpOpcion();
        ejecutarMenuLugares(opcion);
        break;
      case 3:
        menuCaminatas();
        int opcion2 = leerpOpcion();
        ejecutarMenuCaminatas(opcion2);
        break;
      case 4:
        noSalir = false;
        break;
      default:
        out.println("Opción no válida");
        break;
    } // fin del switch
    out.println();
    return noSalir;
  }

  static void menuLugares() {
    out.println("1. Registrar lugar");
    out.println("2. Registrar ruta a lugar");
    out.println("3. Asignar direccion a un lugar");
    out.println("4. Consultar lugares por provincia");
    out.println("5. Consultar lugares por tipo lugar");
    out.println("6. consultar rutas de un lugar");
    out.println("7. consultar distancia total en rutas de un lugar");
    out.println("8. salir");
  }

  static void ejecutarMenuLugares(int pOpcion) throws java.io.IOException {
    boolean noSalir = true;
    switch (pOpcion) {
      case 1:
        String nombre;
        String contacto;
        String indicaciones;
        out.println("Ingrese el nombre del lugar");
        nombre = in.readLine();
        out.println("Ingrese el costo de ingreso al lugar");
        double costo = Double.parseDouble(in.readLine());
        out.println("Ingrese el tipo de lugar Playa(p) o Montaña (m)");
        String tipo = in.readLine();
        out.println("Es accesible:\n(1).si (2).no");
        boolean accesible1, parqueo1, camping1;
        int accesible = Integer.parseInt(in.readLine());
        if (accesible == 1) {
          accesible1 = true;
        } else {
          accesible1 = false;
        }
        out.println("Tiene parqueo 1.si 2. no");
        int parqueo = Integer.parseInt(in.readLine());
        if (parqueo == 1) {
          parqueo1 = true;
        } else {
          parqueo1 = false;
        }
        out.println("Tiene camping 1. si 2. no");
        int camping = Integer.parseInt(in.readLine());
        if (camping == 1) {
          camping1 = true;
        } else {
          camping1 = false;
        }
        out.println("Ingrese un contacto: ");
        contacto = in.readLine();
        out.println("Ingrese el numero de telefono: ");
        String telefono = in.readLine();
        out.println("Ingrese las indicaciones: ");
        String indicaciones1 = in.readLine();
        C1.registrarLugar(nombre, costo, tipo, accesible1, parqueo1, camping1, contacto, telefono, indicaciones1);
        break;
      case 2:
        out.println("Ingrese el nombre del lugar que le desea registrar una ruta:");
        String nombre1 = in.readLine();
        out.println("Nombre de la ruta: ");
        String nombreRuta = in.readLine();
        out.println("Ingrese la distancia: ");
        double distancia = Double.parseDouble(in.readLine());
        out.println("Dificulta (B). Bajo (M). Medio (A). alto");
        String dificulta = in.readLine();
        C1.registrarRutaALugar(nombre1, nombreRuta, distancia, dificulta);
        break;
      case 3:
        String nombreLugar, provincia;
        String canton, districto, senas;
        out.println("Ingrese el nombre del lugar: ");
        nombreLugar = in.readLine();
        out.println("Ingrese la provincia: ");
        provincia = in.readLine();
        out.println("ingrese el canton: ");
        canton = in.readLine();
        out.println("ingrese districto: ");
        districto = in.readLine();
        out.println("Ingrese las señas del lugar: ");
        senas = in.readLine();
        C1.asignarDirreccionAUnLugar(nombreLugar, provincia, canton, districto, senas);
        break;
      case 4:
        out.println("Ingrese la provincia del lugar a buscar: ");
        provincia = in.readLine();
        C1.consultarLugaresPorProvincia(provincia);
        break;
      case 5:
        out.println("Ingrese el tipo Playa(p) Montaña(m)");
        tipo = in.readLine();
        C1.consultarLugaresPorTipoLugar(tipo);
        break;
      case 8:
        noSalir = false;
        break;
      default:
        out.println("Opción no válida");
        break;
    } // fin del switch
    out.println();
  }

  static void menuSenderista() {
    out.println("1. registrar Senderista");
    out.println("2. consultar Senderista por nombre");
    out.println("3. consultar senderistas Mayores de edad");
    out.println("4. consultar todas las rutas realizadas por un senderista");
    out.println("5. registrar una ruta a un senderista");
    out.println("6. salir");
  }

  static void ejecutarMenuSenderista(int pOpcion) throws java.io.IOException {
    boolean noSalir = true;
    switch (pOpcion) {
      case 1:
        String nombre;
        String apellido;
        String fecha;
        out.println("Ingrese el nombre del senderista");
        nombre = in.readLine();
        out.println("Ingrese el Apellido");
        apellido = in.readLine();
        out.println("Ingrese la fecha de nacimiento (dd-MM-yyy)");
        fecha = in.readLine();
        out.println("Ingrese el peso");
        double peso = Double.parseDouble(in.readLine());
        out.println("Ingrese la altura");
        double altura = Double.parseDouble(in.readLine());
        out.println("Ingrese el numero de telefono");
        String telefono = in.readLine();
        out.println("Ingrese el correo electronico");
        String correo = in.readLine();
        C1.registrarSenderista(nombre, apellido, fecha, peso, altura, telefono, correo);
        break;
      case 2:
        out.println("Ingrese el nombre del senderista a consultar");
        String nombre1 = in.readLine();
        C1.consultarSenderistaPorNombre(nombre1);
        break;

      case 3:
        C1.consultarSenderistasMayoresDeNEdad();
        break;
      case 4:
        out.println("Ingrese el id del senderista a consultar");
        int idSenderista = Integer.parseInt(in.readLine());
        C1.consultarRutasRealizadas(idSenderista);
        break;
      case 5:
        out.println("Ingrese el id del senderista a registrar una ruta");
        int idSenderista2 = Integer.parseInt(in.readLine());
        out.println("Ingrese el id de la ruta. ");
        int idRuta = Integer.parseInt(in.readLine());
        C1.registrarRuta(idSenderista2, idRuta);
        break;
      case 6:
        noSalir = false;
        break;
      default:
        out.println("Opción no válida");
        break;
    } // fin del switch
    out.println();
  }

  static void menuCaminatas() {
    out.println("1. registrar Caminata");
    out.println("2. asignar un senderista a una caminata. ");
    out.println("3. consultar participantes de una caminata en una fecha especifica. ");
    out.println("4. consultar caminatas en un rango de fechas. ");
    out.println("5. consultar caminatas que tuvieron una duracion mayor a. ");
    out.println("6. salir. ");

  }

  static void ejecutarMenuCaminatas(int pOpcion) throws IOException, ParseException {
    boolean noSalir = true;
    switch (pOpcion) {
      case 1:
        out.println("Ingrese el id del lugar de la caminata. ");
        int idLugar = Integer.parseInt(in.readLine());
        out.println("Ingrese la fecha de la caminata.\n con el formato dd-MM-yyyy.");
        String fecha = in.readLine();
        out.println("Ingrese la hora de inicio de la caminata. ");
        Double horaInicio = Double.parseDouble(in.readLine());
        out.println("Ingrese la hora de finalizacion de la caminata. ");
        Double horaFin = Double.parseDouble(in.readLine());
        out.println("Ingrese un comentario sobre la caminata. ");
        String comentario = in.readLine();
        SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yy");
        Date fechaC = (Date) mascara.parse(fecha);
        C1.registrarCaminata(idLugar, fechaC, horaInicio, horaFin, comentario);
        break;
      case 2:
        out.println("Ingrese el id de la caminata. ");
        int idCaminata = Integer.parseInt(in.readLine());
        out.println("Ingrese el apellido del senderista. ");
        String apellidoSenderista = in.readLine();
        C1.asignarSenderistaACaminata(apellidoSenderista, idCaminata);
        break;
      case 3:
        out.println("Ingrese la fecha a consultar de las caminatas. ");
        String fechaConsulta = in.readLine();
        SimpleDateFormat mascara2 = new SimpleDateFormat("dd/MM/yy");
        Date fechaC2 = (Date) mascara2.parse(fechaConsulta);
        C1.consultarParticipantesEnCaminataConFecha(fechaC2);
        break;
      case 4:
        out.println("Ingrese una fecha del rango a consultar. ");
        String fechaInicio = in.readLine();
        SimpleDateFormat mascara3 = new SimpleDateFormat("dd/MM/yy");
        Date fechaC3 = (Date) mascara3.parse(fechaInicio);
        out.println("Ingrese la otra fecha del rango a consultar. ");
        String fechaFin = in.readLine();
        SimpleDateFormat mascara4 = new SimpleDateFormat("dd/MM/yy");
        Date fechaC4 = (Date) mascara4.parse(fechaFin);
        C1.consultarCaminatasEnRangoFechas(fechaC3, fechaC4);
        break;
      case 5:
        out.println("Ingrese la duracion minima que debe tener la caminata a consultar. ");
        int duracion = Integer.parseInt(in.readLine());
        C1.consultarCaminatasConDuracionMayorAXMinutos(duracion);
        break;
      case 6:
        noSalir = false;
        break;
      default:
        out.println("Opción no válida");
        break;
    }
    out.println();
  }
}
