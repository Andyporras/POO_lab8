package logicadecaminatas;
import logicadecaminatas.Senderista;
import java.util.*;
import java.text.*;


public class Caminata{
  private static int contadorCaminatas = 0;
  private int idCaminata;
  private Date fecha;
  private long horaInicio;
  private long horaFinalizacion;
  private String comentario = null;
  private ArrayList<Senderista> senderistas;  
  public Caminata(){
    setFecha();
    horaInicio = System.currentTimeMillis();
    contadorCaminatas ++;
  }
  public int getIdCaminata(){
    return idCaminata;
  }
  public void calcularDuracionTotalMinutos()throws InterruptedException{
    long horaInicio = System.currentTimeMillis();;
    Thread.sleep(2000);
         
    long horaFinalizacion = System.currentTimeMillis();
         
    int tiempo = (int) ((horaFinalizacion - horaInicio)/1000);
         
    System.out.println(tiempo +" minutos");
         
  }
  public void asignarSenderista(Senderista pSenderista){
    ArrayList<Caminata> caminatas = new ArrayList<Caminata>();
    for(Caminata caminata: caminatas){
      caminatas.add(pSenderista);
    }
  }    
  public int getCantidadCaminatas(){
    return contadorCaminatas;
  }
  public int getContadorCaminatas(){
    return contadorCaminatas;
  }
  public String getComentario(){
    return comentario;  
  }
  public void setComentario(String pComentario){
    comentario = pComentario;
  }
  public String getFecha(){
    SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yy");
    return mascara.format(fecha);
  }
  public void setFecha(){
    Calendar calendario;
    calendario = Calendar.getInstance();
    fecha = (Date) calendario.getTime();
  }
  public String toString(){
    String msg;
    msg = "Fecha de inicio de la caminata "+ getFecha();
    msg += "Comentario: " + getComentario();
    return msg;
  }
   
}
