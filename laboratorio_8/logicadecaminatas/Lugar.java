package logicadecaminatas;
import logicadecaminatas.Direccion;
import logicadecaminatas.Ruta;
import java.util.ArrayList;

public class Lugar{
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
  private ArrayList<Direccion> direcciones;
  private ArrayList<Ruta> rutas;

  public Lugar(String pNombre,double pCostoDeIngreso,String pTipoLugar,
  boolean pAccesibilidad, boolean pParqueo, boolean pCamping,String pContacto,
  String pTelefono,String pIndicaciones){
    nombre= pNombre;
    costoDeIngreso = pCostoDeIngreso;
    tipoLugar = tipoLugar;  
    accesibilidad = pAccesibilidad;
    parqueo = pParqueo;
    camping = pCamping;
    telefono = pTelefono;
    indicaciones = pIndicaciones;
    contadorLugares++;
  }
  public double calcularDistaciaTotalEnRutas(){
    ArrayList<Ruta> lista = new ArrayList<Ruta>();
    double total = 0;
    for(Ruta ruta: rutas){  
      total+=ruta.getDistancia();
    }
    return total;
  }
  public void registrarRuta(String pNombre, double pDistancia,String pDificultad){
    Ruta nuevo = new Ruta (pNombre, pDistancia, pDificultad);
    agregarRuta(nuevo);
  }
  public void registrarDireccion(String  pProvincia,String pCanton, String pDistricto, String pSenas){
    Direccion nuevo = new Direccion(pProvincia,pCanton,pDistricto,pSenas);
    
  }
  private void agregarRuta(Ruta pRuta){
    rutas.add(pRuta);
  }
  private void agregarDireccion(Direccion pDireccion){
    direcciones.add(pDireccion);
  }
  public String getNombre(){
    return nombre;
  }
  public void setNombre(String pNombre){
    nombre = pNombre;
  }
  public double getCostoDeIngreso(){
    return costoDeIngreso;
  }
  public String getTipoLugar(){
    return tipoLugar;  
  }
  public void setCostoDeIngreso(double pCostoDeIngreso){
    costoDeIngreso = pCostoDeIngreso;
  }
  public void setTipoLugar(String pTipoLugar){
    tipoLugar=pTipoLugar;
  }
  public ArrayList getDireccion(){
    return direcciones;
  }
  public boolean getAcesibilidad(){
    return accesibilidad;
  }
  public boolean getCamping(){
    return camping;
  }
  public boolean getParqueo(){
    return parqueo;
  }
  public String getTelefono(){
    return telefono;
  }
  public String getIndicaciones(){
    return indicaciones;
  }
  public String toString(){
    String msg;
    msg = ("Nombre del lugar: "+getNombre()+"\n");
    msg += ("Costo de ingreso: "+getCostoDeIngreso());
    if(getTipoLugar().equals("p")){
        msg +=("Tipo de lugar: Playa\n");
    }else{msg +=("Tipo de lugar Montaña\n");}
    msg +=("Acesibilida: "+getAcesibilidad()+"\n");
    msg +=("Parqueo: "+getParqueo()+"\n");
    msg +=("Camping: "+getCamping()+"\n");
    msg +=("Telefono del lugar: "+getTelefono()+"\n");
    msg +=("Indicaciones: "+getIndicaciones()+"\n");
    return msg;
  }
}
