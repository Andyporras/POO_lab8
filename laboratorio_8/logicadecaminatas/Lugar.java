package logicadecaminatas;

import java.util.ArrayList;

/**
 * Clase Lugar, la cual permite ingresar las características de un lugar a
 * visitar por
 * los senderistas, esta clase está relacionada estructuralmente con las clases:
 * Ruta y
 * Dirreción.
 * Posee los atributos: contadorLugares, idLugar, nombre, costoDeIngreso,
 * tipoLugar,
 * accesibilidad, parqueo, camping, contacto, telefono, indicaciones,
 * ArrayList<Direccion>
 * y ArrayList<Ruta>.
 * 
 * @author
 */
public class Lugar {
  private static int contadorLugares;
  private int idLugar;
  private String nombre;
  private double costoDeIngreso;
  private String tipoLugar;
  private boolean accesibilidad;
  private boolean parqueo;
  private boolean camping;
  private String contacto;
  private String telefono;
  private String indicaciones;
  private Direccion direccion = null;
  private ArrayList<Ruta> rutas;

  /**
   * Constructor de la clase Lugar
   * 
   * @param pNombre
   * @param pCostoDeIngreso
   * @param pTipoLugar
   * @param pAccesibilidad
   * @param pParqueo
   * @param pCamping
   * @param pContacto
   * @param pTelefono
   * @param pIndicaciones
   */
  public Lugar(String pNombre, double pCostoDeIngreso, String pTipoLugar,
      boolean pAccesibilidad, boolean pParqueo, boolean pCamping, String pContacto,
      String pTelefono, String pIndicaciones) {
    rutas = new ArrayList<Ruta>();
    contadorLugares++;
    idLugar = contadorLugares;
    nombre = pNombre;
    costoDeIngreso = pCostoDeIngreso;
    tipoLugar = pTipoLugar;
    accesibilidad = pAccesibilidad;
    parqueo = pParqueo;
    camping = pCamping;
    telefono = pTelefono;
    indicaciones = pIndicaciones;
  }

  // método agregado.
  public ArrayList<Ruta> getRutas() {
    return rutas;
  }

  public double calcularDistaciaTotalEnRutas() {
    // ArrayList<Ruta> lista = new ArrayList<Ruta>();
    double total = 0;
    for (Ruta ruta : rutas) {
      total += ruta.getDistancia();
    }
    return total;
  }

  /**
   * funcion que registra la ruta.
   * 
   * @param pNombre
   * @param pDistancia
   * @param pDificultad
   */
  public void registrarRuta(String pNombre, double pDistancia, String pDificultad) {
    Ruta nuevo = new Ruta(pNombre, pDistancia, pDificultad);
    agregarRuta(nuevo);
  }

  // no esta bien implementado
  public void registrarDireccion(String pProvincia, String pCanton, String pDistricto, String pSenas) {
    Direccion nuevo = new Direccion(pProvincia, pCanton, pDistricto, pSenas);
    agregarDireccion(nuevo);
  }

  private void agregarRuta(Ruta pRuta) {
    rutas.add(pRuta);
  }

  private void agregarDireccion(Direccion pDireccion) {
    direccion = pDireccion;
  }

  /**
   * Retorna el nombre.
   * 
   * @return un String con el nombre
   */
  public String getNombre() {
    return nombre;
  }

  public int getIdLugar() {
    return idLugar;
  }

  /**
   * Modifica el nombre de la ruta.
   * 
   * @param pNombre.
   */
  public void setNombre(String pNombre) {
    nombre = pNombre;
  }

  /**
   * Retorna el costo del ingreso al lugar.
   * 
   * @return un double indicando el costo de ingreso.
   */
  public double getCostoDeIngreso() {
    return costoDeIngreso;
  }

  /**
   * Retorna el tipo de lugar.
   * 
   * @return un String con el tipo de lugar.
   */
  public String getTipoLugar() {
    return tipoLugar;
  }

  public void setCostoDeIngreso(double pCostoDeIngreso) {
    costoDeIngreso = pCostoDeIngreso;
  }

  public void setTipoLugar(String pTipoLugar) {
    tipoLugar = pTipoLugar;
  }

  public Direccion getDireccion() {
    return direccion;
  }

  public boolean getAcesibilidad() {
    return accesibilidad;
  }

  public boolean getCamping() {
    return camping;
  }

  public boolean getParqueo() {
    return parqueo;
  }

  public String getTelefono() {
    return telefono;
  }

  public String getIndicaciones() {
    return indicaciones;
  }

  public String toString() {
    String msg;
    msg = ("Nombre del lugar: " + getNombre() + "\n");
    msg += ("Costo de ingreso: " + getCostoDeIngreso());
    if (getTipoLugar().equals("p")) {
      msg += ("Tipo de lugar: Playa\n");
    } else {
      msg += ("Tipo de lugar Montaña\n");
    }
    if (getAcesibilidad()) {
      msg += ("Acesibilida: si \n");
    } else {
      msg += ("Acesibilida: no \n");
    }
    if (getParqueo()) {
      msg += ("Parqueo: si \n");
    } else {
      msg += ("Parqueo: no \n");
    }
    if (getCamping()) {
      msg += ("Camping: si \n");
    } else {
      msg += ("Camping: no \n");
    }
    msg += ("Telefono del lugar: " + getTelefono() + "\n");
    msg += ("Indicaciones: " + getIndicaciones() + "\n");
    return msg;
  }
}
