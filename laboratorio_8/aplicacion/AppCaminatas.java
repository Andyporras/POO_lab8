package aplicacion;

import logicadecaminatas.Ruta;//
import logicadecaminatas.Lugar;
import logicadecaminatas.Senderista;
import logicadecaminatas.Caminata;
import java.util.ArrayList;
import java.text.*;
import java.util.Date;

/**
 * Clase AppCaminatas, la cual contiene las funcionalidades del programa.
 * Esta clase está relacionada de manera estructural con las clases: Caminata,
 * Senderista y
 * Lugar.
 * 
 * @author
 */
public class AppCaminatas {
  private ArrayList<Senderista> senderistas;
  private ArrayList<Lugar> lugares;
  private ArrayList<Caminata> caminatas;
  // metodo constructor

  public AppCaminatas() {
    senderistas = new ArrayList<Senderista>();
    lugares = new ArrayList<Lugar>();
    caminatas = new ArrayList<Caminata>();
  }

  private void agregarSenderista(Senderista pSenderista) {
    senderistas.add(pSenderista);
    System.out.println("El senderista ha sido registrado exitosamente");
  }

  private void agregarLugar(Lugar pLugar) {
    lugares.add(pLugar);
  }

  public void registrarSenderista(String pNombre, String pApellido, String pFechaNacimiento,
      double pPeso, double pAltura, String pNumeroTelefono, String pCorreoElectronico) {
    Senderista nuevo = new Senderista(pNombre, pApellido, pFechaNacimiento, pPeso,
        pAltura, pNumeroTelefono, pCorreoElectronico);
    agregarSenderista(nuevo);
  }

  public void consultarSenderistaPorNombre(String pNombre) {
    for (Senderista senderista : senderistas) {
      if (pNombre.equals(senderista.getNombre())) {
        System.out.println(senderista.toString());
      }
    }
  }

  public void consultarSenderistasMayoresDeNEdad() {
    for (Senderista senderista : senderistas) {
      if (senderista.calcularEdad() >= 18) {
        System.out.println(senderista.toString());
      }
    }
  }

  public void registrarLugar(String pNombre, double pCostoDeIngreso, String pTipoLugar,
      boolean pAccesibilidad, boolean pParqueo, boolean pCamping, String pContacto,
      String pTelefono, String pIndicaciones) {
    Lugar nuevo = new Lugar(pNombre, pCostoDeIngreso, pTipoLugar, pAccesibilidad, pParqueo, pCamping, pContacto,
        pTelefono, pIndicaciones);
    agregarLugar(nuevo);
  }

  public void registrarRutaALugar(String pNombreLugar, String pNombreRuta, double pDistanciaEnKm, String pDificultad) {
    for (Lugar lugar : lugares) {
      if (lugar.getNombre().equals(pNombreLugar)) {
        lugar.registrarRuta(pNombreRuta, pDistanciaEnKm, pDificultad);
      }
    }
  }

  public void asignarDirreccionAUnLugar(String pNombreLugar, String pProvincia, String pCanton, String pDistricto,
      String pSenas) {
    for (Lugar lugar : lugares) {
      if (lugar.getNombre().equals(pNombreLugar)) {
        lugar.registrarDireccion(pProvincia, pDistricto, pCanton, pSenas);
      }
    }
  }

  public void consultarLugaresPorProvincia(String pProvincia) {
    for (Lugar lugar : lugares) {
      if (lugar.getDireccion() != null) {
        if (lugar.getDireccion().getProvincia().equals(pProvincia)) {
          System.out.println(lugar.toString());
        }

      }
    }
  }

  public void consultarLugaresPorTipoLugar(String pTipo) {
    for (Lugar lugar : lugares) {
      if (lugar.getTipoLugar().equals(pTipo)) {
        System.out.println(lugar.toString());
      }
    }
  }

  public void consultarRutasDeUnLugar(int pIdLugar) {
    for (Lugar lugar : lugares) {
      if (lugar.getIdLugar() == pIdLugar) {
        for (Ruta ruta : lugar.getRutas()) {
          System.out.println(ruta.toString());
        }
      }
    }
  }

  public void consultarDistanciaTotalEnRutasDeUnLugar(int pIdLugar) {
    double distanciaTotal = 0;
    for (Lugar lugar : lugares) {
      if (lugar.getIdLugar() == pIdLugar) {
        for (Ruta ruta : lugar.getRutas()) {
          distanciaTotal += ruta.getDistancia();
        }
      }
    }
    System.out.println("La distancia total de las rutas es: " + distanciaTotal);
  }

  public void registrarCaminata(int pIdLugar, String pFecha, String pHoraInicio, String pHoraFin, String pComentario) {
    if (lugares.size() == 0) {
      System.out.println("No hay lugar donde realizar la caminata");
    } else {
      for (Lugar lugar : lugares) {
        if (lugar.getIdLugar() == pIdLugar) {
          SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy");
          Date fecha;
          try {
            fecha = dateFormat.parse(pFecha);
            Caminata nuevo = new Caminata(lugar, fecha, pHoraInicio, pHoraFin, pComentario);
            caminatas.add(nuevo);
          } catch (ParseException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }

  public void asignarSenderistaACaminata(String pApellido, int pIdCaminata) {
    for (Caminata caminata : caminatas) {
      if (caminata.getId() == pIdCaminata) {
        for (Senderista senderista : senderistas) {
          if (senderista.getApellido().equals(pApellido)) {
            caminata.asignarSenderista(senderista);
            senderista.asignarCaminata(caminata);
          }
        }
      }
    }

  }

  public void consultarParticipantesEnCaminataConFecha(String pFecha) {
    SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yy");
    for (Caminata caminata : caminatas) {
      if (caminata.getFecha().equals(mascara.format(pFecha))) {
        for (Senderista senderista : caminata.getSenderistas()) {
          System.out.println(senderista.toString());
        }
      }
    }
  }

  public void consultarCaminatasEnRangoFechas(Date pFechaInicio, Date pFechaFin) throws ParseException {
    SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yy");
    for (Caminata caminata : caminatas) {
      Date dataFormateada = mascara.parse(caminata.getFecha());
      if (dataFormateada.compareTo(pFechaInicio) >= 0 && dataFormateada.compareTo(pFechaFin) <= 0) {
        System.out.println(caminata.toString());
      }
    }
  }

  public void consultarCaminatasConDuracionMayorAXMinutos(int pDuracion) {
    for (Caminata caminata : caminatas) {
      if (caminata.calcularDuracion() >= pDuracion) {
        System.out.println(caminata.toString());
      }
    }
  }

  // Por un senderista
  public void consultarRutasRealizadas(int pIdSenderista) {
    for (Senderista senderista : senderistas) {
      if (senderista.getIdSenderista() == pIdSenderista) {
        for (Caminata caminata : senderista.getCaminatas()) {
          for (Ruta ruta : caminata.getLugar().getRutas()) {
            System.out.println(ruta.toString());
          }
        }

      }
    }
  }

  // A un senderista
  public void registrarRuta(int pIdSenderista, int pIdRuta) {
    for (Senderista senderista : senderistas) {
      if (senderista.getIdSenderista() == pIdSenderista) {
        senderista.asignarRuta(pIdRuta);
      }
    }
  }

  public void getIdLugares() {
    for (Lugar lugar : lugares) {
      System.out.println("Lugar " + lugar.getNombre() + " id : " + lugar.getIdLugar());
    }
  }

  public void getIdSenderistas() {
    for (Senderista senderista : senderistas) {
      System.out.println("id del senderista " + senderista.getNombre() + " : " + senderista.getIdSenderista());
    }
  }

  public void getIdCaminata() {
    for (Caminata caminata : caminatas) {
      System.out.println("id de la caminata: " + caminata.getId());
    }
  }

  public void getNombreLugares() {
    int i = 0;
    for (Lugar lugar : lugares) {
      System.out.println("Nombre del Lugar " + i + ": " + lugar.getNombre());
      i++;
    }
  }

  public void getApellidoSenderista() {
    for (Senderista senderista : senderistas) {
      System.out.println("Apellido del senderista " + senderista.getNombre() + " : " + senderista.getApellido());
    }
  }

}
