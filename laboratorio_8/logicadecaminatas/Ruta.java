package logicadecaminatas;

/**
 * Clase Ruta que representa una ruta de un lugar a otro.
 * con sus atributos nombre, distancia, dificultad y una lista de lugares.
 * 
 * @author Andy Porras
 */
public class Ruta {
  private static int contadorRutas;
  private int idRuta;
  private String nombre;
  private double distanciaEnKm;
  private String dificultad;

  /**
   * Constructor de la clase Ruta.
   * 
   * @param pNombre
   * @param pDistanciaEnKm
   * @param pDificultad
   */
  public Ruta(String pNombre, double pDistanciaEnKm, String pDificultad) {
    contadorRutas++;
    idRuta = contadorRutas;
    nombre = pNombre;
    distanciaEnKm = pDistanciaEnKm;
    dificultad = pDificultad;
  }

  /**
   * Metodo que retorna el los datos de la class Ruta.
   * 
   * @return un String de los atributos de la clase Ruta.
   * @param parametro
   */
  public String toString() {
    String msg;
    msg = ("IdRuta: " + getIdRuta() + "\n");
    msg = ("Nombre: " + getNombre() + "\n");
    msg = ("Distancia en KM: " + getDistancia() + "\n");
    if ("B".equals(getDificulta())) {
      msg = ("Dificulta: Baja\n");
    } else if ("M".equals(getDificulta())) {
      msg = ("Dificulta: Medio\n");
    } else if ("A".equals(getDificulta())) {
      msg = ("Dificulta: alto\n");
    }
    return msg;
  }

  public int getIdRuta() {
    return idRuta;
  }

  public String getNombre() {
    return nombre;
  }

  public double getDistancia() {
    return distanciaEnKm;
  }

  public String getDificulta() {
    return dificultad;
  }
}
