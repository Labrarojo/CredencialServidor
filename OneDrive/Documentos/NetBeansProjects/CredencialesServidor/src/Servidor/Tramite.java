package Servidor;

import Interfaces.ITramite;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class Tramite extends UnicastRemoteObject implements ITramite {

    private int folio;
    private String matricula;
    private int carrera;
    private String fecha;
    private String foto;
    private String firma;
    private boolean estado;

    public Tramite() throws RemoteException {

    }

    public Tramite(int folio, String matricula, int carrera, String fecha, String foto, String firma, boolean estado) throws RemoteException{
        this.folio = folio;
        this.matricula = matricula;
        this.carrera = carrera;
        this.fecha = fecha;
        this.foto = foto;
        this.firma = firma;
        this.estado = estado;
    }

    public int getFolio() throws RemoteException{
        return folio;
    }

    public void setFolio(int folio) throws RemoteException{
        this.folio = folio;
    }

    public String getMatricula() throws RemoteException{
        return matricula;
    }

    public void setMatricula(String matricula) throws RemoteException{
        this.matricula = matricula;
    }

    public int getCarrera() throws RemoteException{
        return carrera;
    }

    public void setCarrera(int carrera) throws RemoteException{
        this.carrera = carrera;
    }

    public String getFecha() throws RemoteException{
        return fecha;
    }

    public void setFecha(String fecha) throws RemoteException{
        this.fecha = fecha;
    }

    public String getFoto() throws RemoteException{
        return foto;
    }

    public void setFoto(String foto) throws RemoteException{
        this.foto = foto;
    }

    public String getFirma() throws RemoteException{
        return firma;
    }

    public void setFirma(String firma) throws RemoteException{
        this.firma = firma;
    }

    public boolean getEstado() throws RemoteException{
        return estado;
    }

    public void setEstado(boolean estado) throws RemoteException{
        this.estado = estado;
    }

    public String getString() throws RemoteException {
        return String.format("Folio: %d, Matricula: %s, Carrera: %s, Fecha: %s, Foto: %s, Firma: %s, Estado: %s", folio, matricula, carrera, fecha, foto, firma, estado);
    }

    public static ITramite fromMap(Map<String, Object> map) throws RemoteException {
        ITramite tramite = new Tramite();

        if (map.containsKey("Folio")) {
            tramite.setFolio((Integer) map.get("Folio"));
        }
        if (map.containsKey("Estudiante")) {
            tramite.setMatricula((String) map.get("Estudiante"));
        }
        if (map.containsKey("Carrera")) {
            tramite.setCarrera((Integer) map.get("Carrera"));
        }
        if (map.containsKey("Fecha")) {
            tramite.setFecha((String) map.get("Fecha"));
        }
        if (map.containsKey("Foto")) {
            tramite.setFoto((String) map.get("Foto"));
        }
        if (map.containsKey("Firma")) {
            tramite.setFirma((String) map.get("Firma"));
        }
        if (map.containsKey("Estado")) {
            tramite.setEstado((Boolean) map.get("Estado"));
        }

        return tramite;
    }

    public static Map<String, Object> toMap(ITramite tramite) throws RemoteException {
        Map<String, Object> datos = new HashMap<>();

        if (tramite.getFolio() != 0) {
            datos.put("Folio", tramite.getFolio());
        }
        if (tramite.getMatricula() != null) {
            datos.put("Estudiante", tramite.getMatricula());
        }
        if (tramite.getCarrera() != 0) {
            datos.put("Carrera", tramite.getCarrera());
        }
        if (tramite.getFecha() != null) {
            datos.put("Fecha", tramite.getFecha());
        }
        if (tramite.getFoto() != null) {
            datos.put("Foto", tramite.getFoto());
        }
        if (tramite.getFirma() != null) {
            datos.put("Firma", tramite.getFirma());
        }
        if (tramite.getEstado() != false) {
            datos.put("Estado", tramite.getEstado());
        }

        return datos;

    }

}
