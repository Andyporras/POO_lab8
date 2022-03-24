package logicadecaminatas;

import java.util.*;
import java.text.*;

public class Caminata {
  private static int contadorCaminatas = 0;
  private int idCaminata;
  private Date fecha;
  private double horaInicio;
  private double horaFinalizacion;
  private String comentario = null;
  private ArrayList<Senderista> senderistas;
  private Lugar lugar;

  public Caminata(Lugar pLugar, Date pFecha, Double pHoraInicio, Double pHoraFinalizacion, String pComentario) {
    setFecha();
    lugar = pLugar;
    horaInicio = System.currentTimeMillis();
    contadorCaminatas++;
    idCaminata = contadorCaminatas;
  }

  public int getIdCaminata() {
    return idCaminata;
  }

  public int calcularDuracionTotalMinutos() throws InterruptedException {
    long horaInicio = System.currentTimeMillis();
    Thread.sleep(2000);
    long horaFinalizacion = System.currentTimeMillis();
    int tiempo = (int) ((horaFinalizacion - horaInicio) / 1000);
    return tiempo;
    // System.out.println(tiempo + " minutos");

  }

  public int getId() {
    return idCaminata;
  }

  public void asignarSenderista(Senderista pSenderista) {
    senderistas.add(pSenderista);
  }

  public String getComentario() {
    return comentario;
  }

  public void setComentario(String pComentario) {
    comentario = pComentario;
  }

  public Lugar getLugar() {
    return lugar;
  }

  public String getFecha() {
    SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yy");
    return mascara.format(fecha);
  }

  public void setFecha() {
    Calendar calendario;
    calendario = Calendar.getInstance();
    fecha = (Date) calendario.getTime();
  }

  public String toString() {
    String resultado = "";
    resultado += "Caminata: " + idCaminata + "\n";
    resultado += "Fecha: " + getFecha() + "\n";
    resultado += "Hora de inicio: " + horaInicio + "\n";
    resultado += "Hora de finalizacion: " + horaFinalizacion + "\n";
    resultado += "Comentario: " + getComentario() + "\n";
    resultado += "Senderistas:\n";
    for (Senderista senderista : senderistas) {
      resultado += senderista.toString() + "\n";
    }
    return resultado;
  }

  public ArrayList<Senderista> getSenderistas() {
    return senderistas;
  }

}
