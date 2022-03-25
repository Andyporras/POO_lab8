package logicadecaminatas;

import java.util.*;
import java.sql.Time;
import java.text.*;

public class Caminata {
  private static int contadorCaminatas = 0;
  private int idCaminata;
  private Date fecha;
  private Time horaInicio;
  private Time horaFinalizacion;
  private String comentario = null;
  private ArrayList<Senderista> senderistas;
  private Lugar lugar;

  public Caminata(Lugar pLugar, Date pFecha, String pHoraInicio, String pHoraFinalizacion, String pComentario) {
    senderistas = new ArrayList<Senderista>();
    fecha = pFecha;
    lugar = pLugar;
    setHoraInicio(pHoraInicio);
    setHoraFinalizacion(pHoraFinalizacion);
    contadorCaminatas++;
    idCaminata = contadorCaminatas;
    comentario = pComentario;
  }

  private void setHoraFinalizacion(String pHoraFinalizacion) {
    DateFormat dateFormat = new SimpleDateFormat("HH:mm");
    try {
      horaFinalizacion = new Time(dateFormat.parse(pHoraFinalizacion).getTime());
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  private void setHoraInicio(String pHoraInicio) {
    DateFormat dateFormat = new SimpleDateFormat("HH:mm");
    try {
      horaInicio = new Time(dateFormat.parse(pHoraInicio).getTime());
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

  public int getIdCaminata() {
    return idCaminata;
  }

  public int calcularDuracion() {
    int duracion = 0;
    duracion = (int) (horaFinalizacion.getMinutes() - horaInicio.getMinutes());
    System.out.println(duracion + " minutos\n");
    return duracion;
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
