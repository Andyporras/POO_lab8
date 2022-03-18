package logicadecaminatas;

public class Ruta {
  private static int contadorRutas;
  private int idRuta;
  private String nombre;
  private double distanciaEnKm;
  private String dificultad;

  public Ruta(String pNombre, double pDistanciaEnKm, String pDificultad) {
    contadorRutas++;
    idRuta = contadorRutas;
    nombre = pNombre;
    distanciaEnKm = pDistanciaEnKm;
    dificultad = pDificultad;
  }

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
