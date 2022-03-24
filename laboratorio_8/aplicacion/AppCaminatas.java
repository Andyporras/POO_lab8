package aplicacion;
import logicadecaminatas.Ruta;//
import logicadecaminatas.Lugar;
import logicadecaminatas.Senderista;
import logicadecaminatas.Caminata;
import java.util.ArrayList;
import java.util.*;
import java.text.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Clase AppCaminatas, la cual contiene las funcionalidades del programa.
 * Esta clase está relacionada de manera estructural con las clases: Caminata, Senderista y
 * Lugar.
 * 
 * @author
 */
public class AppCaminatas{
  private ArrayList<Senderista> senderistas;
  private ArrayList<Lugar> lugares;
  private ArrayList<Caminata> caminatas;
  private ArrayList<Ruta> rutas;//
  //metodo constructor
  public AppCaminatas(){
    senderistas  = new ArrayList<Senderista>();
    lugares = new ArrayList<Lugar>();
    caminatas = new ArrayList<Caminata>();
    rutas = new ArrayList<Ruta>();//
  }
  private void agregarSenderista(Senderista pSenderista){
    senderistas.add(pSenderista); 
    System.out.println("El senderista ha sido registrado exitosamente");
  }
  private void agregarLugar(Lugar pLugar){
    lugares.add(pLugar);    
  }
  public void registrarSenderista(String pNombre,String pApellido,String pFechaNacimiento,
  double pPeso,double pAltura,String pNumeroTelefono,String pCorreoElectronico){
    Senderista nuevo = new Senderista(pNombre,pApellido,pFechaNacimiento,pPeso,
    pAltura, pNumeroTelefono,pCorreoElectronico);
    agregarSenderista(nuevo);
  }
  public String consultarSenderistaPorNombre(String pNombre){
    ArrayList<Senderista> lista = new ArrayList<Senderista>();
    for(Senderista senderista: senderistas){
      if(pNombre.equals(senderista.getNombre())){
        return senderista.toString();
      }
    }
    return "No se encontro ningún senderista";
  }
  public void consultarSenderistasMayoresDeNEdad(){
    ArrayList<Senderista> lista = new ArrayList<Senderista>();
    String mensaje;
    mensaje = "";
    for(Senderista senderista: senderistas){
      if(senderista.calcularEdad()>=18){
        mensaje += senderista.toString();  
      }
    }
    if(mensaje == ""){
       System.out.println("No hay mayores de edad");
    }else{System.out.println(mensaje);};
  }
  public void registrarLugar(String pNombre,double pCostoDeIngreso,String pTipoLugar,
  boolean pAccesibilidad, boolean pParqueo, boolean pCamping,String pContacto,
  String pTelefono,String pIndicaciones){
    Lugar nuevo = new Lugar(pNombre,pCostoDeIngreso,pTipoLugar,pAccesibilidad,pParqueo,pCamping,pContacto,
    pTelefono,pIndicaciones);
    agregarLugar(nuevo);
  }
  public void registrarRutaALugar(String pNombreLugar,String pNombreRuta,double pDistanciaEnKm,String pDificultad){
    ArrayList<Lugar> lista = new ArrayList<Lugar>();
    for(Lugar lugar: lugares){
      if(lugar.getNombre().equals(pNombreLugar)){
        lugar.registrarRuta(pNombreRuta,pDistanciaEnKm,pDificultad);
      }
    }
  }
  public void asignarDirreccionAUnLugar(String pNombreLugar,String  pProvincia,String pCanton, String pDistricto, String pSenas){
    ArrayList<Lugar> lista = new ArrayList<Lugar>();
    for(Lugar lugar: lugares){
      if(lugar.getNombre().equals(pNombreLugar)){
        lugar.registrarDireccion(pProvincia,pDistricto,pCanton,pSenas);
      }
    }    
  }
  public void consultarLugaresPorProvincia(String pProvincia){
    ArrayList<Lugar> lista = new ArrayList<Lugar>();
    for(Lugar lugar: lugares){
      if(lugar.getDireccion().equals(pProvincia)){
        lugar.toString();
      }
    }
  }
  public void consultarLugaresPorTipoLugar(String pTipo){
    ArrayList<Lugar> lista = new ArrayList<Lugar>();
    for(Lugar lugar: lugares){
      if(lugar.getTipoLugar().equals(pTipo)){
        lugar.toString();
      }
    }
  }
  public void consultarRutasDeUnLugar(String pLugar){
     ArrayList<Lugar> lista = new ArrayList<Lugar>();
    for(Lugar lugar: lugares){
      if(lugar.getRutas().equals(pLugar)){
        rutas.toString();
      }
    } 
  }
  public void consultarDistanciaTotalEnRutasDeUnLugar(){}
  
  public void registrarCaminata(){
    Caminata nuevo = new Caminata();
    caminatas.add(nuevo);
  }
  public void asignarSenderistaACaminata(){
    ArrayList<Senderista> lista = new ArrayList<Senderista>();
    ArrayList<Caminata> lista2 = new ArrayList<Caminata>();
    for(Senderista senderista: senderistas){
      for(Caminata caminata: caminatas){
         senderistas.add(caminata);
      }
    }
  }
  public void consultarParticipantesEnCaminataConFecha(){}
  public void consultarCaminatasEnRangoFechas(){}
  public void consultarCaminatasConDuracionMayorAXMinutos(){}
  //A un senderista
  public void registrarRuta(){}
  // Por un senderista
  public void consultarRutasRealizadas(){}
}
