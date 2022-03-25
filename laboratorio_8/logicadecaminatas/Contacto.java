package logicadecaminatas;


/**
 * Clase contacto.
 * Esta clase permite registrar un contacto.
 * Tiene los atributos: contacto, numeroContacto, indicaciones e Id.
 * 
 * @author 
 * @version 1.0
 */
public class Contacto {
  private String contacto;
  private int numeroContacto;
  private String indicaciones;
  private int id = 0;
  
  public Contacto(String pContacto, int pnumeroContacto, String pIndicaciones, int pId) {
    contacto = pContacto;
    numeroContacto = pnumeroContacto;
    indicaciones = pIndicaciones;
    id ++;
  }
  public String getContacto(){
    return contacto;
  }
  public int getnumeroContacto(){
    return numeroContacto;
  }
  public String getIndicaciones(){
    return indicaciones;
  }
  public int getId(){
    return id;
  }
}