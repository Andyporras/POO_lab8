package logicadecaminatas;

public class Direccion{
  private String provincia;
  private String canton;
  private String districto;
  private String senas;
  
  public Direccion(String  pProvincia,String pCanton, String pDistricto, String pSenas){
    provincia = pProvincia;
    canton = pCanton;
    districto = pDistricto;
    senas = pSenas;
  }
  public String toString(){
    String msg;
    msg=("Provincia: "+getProvincia()+"\n");
    msg+=("Cánto: "+getCanton()+"\n");
    msg+=("Districto: "+getDistricto()+"\n");
    msg+=("Señas: "+getSenas()+"\n");
    return msg;
  }
  public String getProvincia(){
    return provincia;  
  }
  public String getCanton(){
    return canton;
  }
  public String getDistricto(){
    return districto;
  }
  public String getSenas(){
    return senas;
  }
}
