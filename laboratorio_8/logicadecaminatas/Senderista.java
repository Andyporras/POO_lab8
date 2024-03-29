package logicadecaminatas;

import java.util.ArrayList;
//import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * Clase Senderista, la cual permite asignar a los participantes de las
 * caminatas.
 * Está relacinada de manera estructural con la clase Caminata.
 * Posee los atributos: nombre, apellido, fechaNacimiento, peso, altura,
 * numeroTelefono y
 * correoElectronico.
 * 
 * @author
 */
public class Senderista {
  private static int contadorSenderistas = 0;
  private int idSenderista;
  private String nombre;
  private String apellido;
  private Date fechaNacimiento;
  private double peso;
  private double altura;
  private String numeroTelefono;
  private String correoElectronico;
  private ArrayList<Caminata> caminatas;
  private ArrayList<Ruta> rutas;

  public Senderista(String pNombre, String pApellido, String pFechaNacimiento,
      double pPeso, double pAltura, String pNumeroTelefono, String pCorreoElectronico) {
    caminatas = new ArrayList<Caminata>();
    rutas = new ArrayList<Ruta>();
    nombre = pNombre;
    apellido = pApellido;
    fechaNacimiento = StringToDate(pFechaNacimiento);
    peso = pPeso;
    altura = pAltura;
    numeroTelefono = pNumeroTelefono;
    correoElectronico = pCorreoElectronico;
    contadorSenderistas++;
    idSenderista = contadorSenderistas;
  }

  public Date StringToDate(String pFecha) {
    Date result = null;
    try {
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy");
      result = dateFormat.parse(pFecha);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return result;
  }

  public int calcularEdad() {
    int edad = 0;
    Date fechaActual = new Date();
    edad = (int) ((fechaActual.getYear() - fechaNacimiento.getYear()));
    return edad;
  }

  public void asignarCaminata(Caminata pCaminata) {
    caminatas.add(pCaminata);
  }

  public String getNombre() {
    return nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public int getIdSenderista() {
    return idSenderista;
  }

  public Date getFechaNacimiento() {
    return fechaNacimiento;
  }

  public ArrayList<Caminata> getCaminatas() {
    return caminatas;
  }

  public double getPeso() {
    return peso;
  }

  public double getAltura() {
    return altura;
  }

  public String getNumeroTelefono() {
    return numeroTelefono;
  }

  public String getCorreoElectronico() {
    return correoElectronico;
  }

  public void asignarRuta(int pIdRuta) {
    for (Caminata caminata : caminatas) {
      for (Ruta ruta : caminata.getLugar().getRutas()) {
        if (ruta.getIdRuta() == pIdRuta) {
          rutas.add(ruta);
        }
      }

    }

  }

  public String toString() {
    String msg = "";
    msg += ("Nombre: " + getNombre() + "\n");
    msg += ("Apellido: " + getApellido() + "\n");
    msg += ("Fecha de nacimiento: " + getFechaNacimiento() + "\n");
    msg += ("Peso: " + getPeso() + "\n");
    msg += ("Altura: " + getAltura() + "\n");
    msg += ("Numero de telefono: " + getNumeroTelefono() + "\n");
    msg += ("Correo Eletronico: " + getCorreoElectronico() + "\n");
    return msg;
  }

  public boolean equals(Object pO) {
    if (this == pO) {
      return true;
    }
    if (pO == null) {
      return false;
    }
    if (getClass() != pO.getClass()) {
      return false;
    }

    Senderista senderista = (Senderista) pO;

    boolean equalsNombre = (nombre == senderista.getNombre());
    boolean equalsApellido = (apellido.equals(senderista.getApellido()));
    boolean equalsFechanacimiento = (fechaNacimiento.equals(senderista.getFechaNacimiento()));
    boolean equalsNumeroTelefono = (numeroTelefono.equals(senderista.getNumeroTelefono()));
    boolean equalsCorreoElectronico = (correoElectronico.equals(senderista.getCorreoElectronico()));
    boolean resultado = equalsNombre && equalsApellido && equalsFechanacimiento;
    resultado = resultado && equalsNumeroTelefono && equalsCorreoElectronico;

    return resultado;
  }
}
