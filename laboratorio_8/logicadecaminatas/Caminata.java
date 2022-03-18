package logicadecaminatas;
import logicadecaminatas.Senderista;
import java.util.*;
import java.text.*;
import java.time.*;
import java.util.Date;
import java.time.Instant;

public class Caminata{
  private static int contadorCaminatas;
  private int idCaminata;
  private Date fecha;
  private Instant horaInicio;
  private int horaFinalización;
  private String comentario;
  private ArrayList<Senderista> senderistas;  
  public Caminata(){
    fecha = new Date();
    horaInicio = Instant.now();  
    contadorCaminatas ++;
  }
  //public int calcularDuracionTotalMinutos(){
  // return;
 // }
  public void asignarSenderista(Senderista pSenderista){
  }
  public int getContadorCaminatas(){
    return contadorCaminatas;
  }
  public String toString(){
    String msg;
    msg = ("Cantidad de caminatas");
    return msg;
  }
   
}
