package Servidor;

import Interfaces.ITramite;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class Tramite extends UnicastRemoteObject implements ITramite {

    private String folio;
    private String matricula;
    private String fecha;
    private String estado;

    public Tramite() throws RemoteException {

    }

    public Tramite(String folio, String matricula, String fecha, String estado) throws RemoteException {
        this.folio = folio;
        this.matricula = matricula;
        this.fecha = fecha;
        this.estado = estado;
    }

    public String getFolio() throws RemoteException {
        return folio;
    }

    public void setFolio(String folio) throws RemoteException {
        this.folio = folio;
    }

    public String getMatricula() throws RemoteException {
        return matricula;
    }

    public void setMatricula(String matricula) throws RemoteException {
        this.matricula = matricula;
    }

    public String getFecha() throws RemoteException {
        return fecha;
    }

    public void setFecha(String fecha) throws RemoteException {
        this.fecha = fecha;
    }

    public String getEstado() throws RemoteException {
        return estado;
    }

    public void setEstado(String estado) throws RemoteException {
        this.estado = estado;
    }

    public String getString() throws RemoteException {
        return String.format("Folio: %s, Matricula: %s, Fecha: %s, Estado: %s", folio, matricula, fecha, estado);
    }

    public static ITramite fromMap(Map<String, Object> map) throws RemoteException {
        ITramite tramite = new Tramite();

        if (map.containsKey("Folio")) {
            tramite.setFolio((String) map.get("Folio"));
        }
        if (map.containsKey("Matricula")) {
            tramite.setMatricula((String) map.get("Matricula"));
        }
        if (map.containsKey("Fecha")) {
            tramite.setFecha((String) map.get("Fecha"));
        }
        if (map.containsKey("Estado")) {
            tramite.setEstado((String) map.get("Estado"));
        }

        return tramite;
    }

    public static Map<String, Object> toMap(ITramite tramite) throws RemoteException {
        Map<String, Object> datos = new HashMap<>();

        if (tramite.getFolio() != null) {
            datos.put("Folio", tramite.getFolio());
        }
        if (tramite.getMatricula() != null) {
            datos.put("Matricula", tramite.getMatricula());
        }
        if (tramite.getFecha() != null) {
            datos.put("Fecha", tramite.getFecha());
        }
        if (tramite.getEstado() != null) {
            datos.put("Estado", tramite.getEstado());
        }

        return datos;

    }

}
