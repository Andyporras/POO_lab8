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
  private ArrayList<Ruta> rutas;//
  // metodo constructor

  public AppCaminatas() {
    senderistas = new ArrayList<Senderista>();
    lugares = new ArrayList<Lugar>();
    caminatas = new ArrayList<Caminata>();
    rutas = new ArrayList<Ruta>();//
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
      if (lugar.getDireccion().getProvincia().equals(pProvincia)) {
        System.out.println(lugar.toString());
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
        System.out.println(rutas.toString());
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

  public void registrarCaminata(int pIdLugar, Date pFecha, Double pHoraInicio, Double pHoraFin, String pComentario) {
    if (lugares.size() == 0) {
      System.out.println("No hay lugar donde realizar la caminata");
    } else {
      for (Lugar lugar : lugares) {
        if (lugar.getIdLugar() == pIdLugar) {
          Caminata nuevo = new Caminata(lugar, pFecha, pHoraInicio, pHoraFin, pComentario);
          caminatas.add(nuevo);
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

  public void consultarParticipantesEnCaminataConFecha(Date pFecha) {
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
      try {
        if (caminata.calcularDuracionTotalMinutos() >= pDuracion) {
          System.out.println(caminata.toString());
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
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

}
