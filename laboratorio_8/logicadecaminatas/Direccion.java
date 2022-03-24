package logicadecaminatas;

/**
 * Clase Direccion permite definir las indicaciones para llegar a un lugar.
 * Posee los atributos: provincia, canton distrito y senas (señas).
 * 
 * @author
 */
public class Direccion{
  private String provincia;
  private String canton;
  private String distrito;
  private String senas;
  
  public Direccion(String  pProvincia,String pCanton, String pDistrito, String pSenas){
    provincia = pProvincia;
    canton = pCanton;
    distrito = pDistrito;
    senas = pSenas;
  }
  public String toString(){
    String msg;
    msg=("Provincia: "+getProvincia()+"\n");
    msg+=("Cánto: "+getCanton()+"\n");
    msg+=("Districto: "+getDistrito()+"\n");
    msg+=("Señas: "+getSenas()+"\n");
    return msg;
  }
  public String getProvincia(){
    return provincia;  
  }
  public String getCanton(){
    return canton;
  }
  public String getDistrito(){
    return distrito;
  }
  public String getSenas(){
    return senas;
  }
}
