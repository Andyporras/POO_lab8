package logicadecaminatas;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Senderista{
  private String nombre;
  private String apellido;
  private Date fechaNacimiento;
  private double peso;
  private double altura;
  private String numeroTelefono;
  private String correoElectronico;
  
  public Senderista(String pNombre,String pApellido,String pFechaNacimiento,
  double pPeso,double pAltura,String pNumeroTelefono,String pCorreoElectronico){
    nombre = pNombre;
    apellido = pApellido;
    fechaNacimiento = StringToDate(pFechaNacimiento);
    peso = pPeso;
    altura = pAltura;
    numeroTelefono = pNumeroTelefono;
    correoElectronico = pCorreoElectronico;
  }
  public Date StringToDate(String pFecha){
    Date result = null;
    try{
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy");
      result  = dateFormat.parse(pFecha);                 
    }
    catch(ParseException e){
      e.printStackTrace();
    }
    return result ;
  }
  public int calcularEdad(){
    int result = 0;
    int fecha = getFechaNacimiento().getYear();
    result = 2021-fecha;
    return result;
  }
  public void asignarCaminata(Caminata pCaminata){
    
  }
  public String getNombre(){
    return nombre;
  }
  public String getApellido(){
    return apellido;
  }
  public Date getFechaNacimiento(){
    return fechaNacimiento;
  }
  public double getPeso(){
    return peso;
  }
  public double getAltura(){
    return altura;
  }
  public String getNumeroTelefono(){
    return numeroTelefono;
  }
  public String getCorreoElectronico(){
    return correoElectronico;
  }
  public String toString(){
    String msg= "";
    msg +=( "Nombre: "+getNombre()+"\n");
    msg += ("Apellido: "+getApellido()+"\n");
    msg += ("Fecha de nacimiento: "+getFechaNacimiento()+"\n");
    msg += ("Peso: "+getPeso()+"\n");
    msg += ("Altura: "+getAltura()+"\n");
    msg += ("Numero de telefono: "+getNumeroTelefono()+"\n");
    msg += ("Correo Eletronico: "+getCorreoElectronico()+"\n");
    return msg;
  }
  
}
