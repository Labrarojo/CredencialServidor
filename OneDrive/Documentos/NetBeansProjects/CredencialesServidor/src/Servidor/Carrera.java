package Servidor;

import Interfaces.ICarrera;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class Carrera extends UnicastRemoteObject implements ICarrera {

    private int codcarrera;
    private String nombrecarrera;
    private int facultad;

    public Carrera() throws RemoteException {

    }

    public Carrera(int codcarrera, String nombrecarrera, int facultad) throws RemoteException {
        this.codcarrera = codcarrera;
        this.nombrecarrera = nombrecarrera;
        this.facultad = facultad;
    }

    @Override
    public int getCodCarrera() throws RemoteException {
        return codcarrera;
    }

    public void setCodCarrera(int codcarrera) throws RemoteException {
        this.codcarrera = codcarrera;
    }

    public String getNombreCarrera() throws RemoteException {
        return nombrecarrera;
    }

    public void setNombreCarrera(String nombrecarrera) throws RemoteException {
        this.nombrecarrera = nombrecarrera;
    }

    public int getFacultad() throws RemoteException {
        return facultad;
    }

    public void setFacultad(int facultad) throws RemoteException {
        this.facultad = facultad;
    }

    public String getString() throws RemoteException {
        return String.format("Código: %d, Carrera: %s, Facultad: %d",
                codcarrera, nombrecarrera, facultad);
    }

    public static ICarrera fromMap(Map<String, Object> map) throws RemoteException {
        ICarrera carrera = new Carrera();

        if (map.containsKey("Código")) {
            carrera.setCodCarrera((Integer) map.get("Código"));
        }

        if (map.containsKey("Carrera")) {
            carrera.setNombreCarrera((String) map.get("Nombre"));
        }

        if (map.containsKey("Facultad")) {
            carrera.setFacultad((Integer) map.get("Facultad"));
        }

        return carrera;
    }

    public static Map<String, Object> toMap(ICarrera carrera) throws RemoteException {
        Map<String, Object> datos = new HashMap<>();

        if (carrera.getCodCarrera() != 0) {
            datos.put("Codigo", carrera.getCodCarrera());
        }
        if (carrera.getNombreCarrera() != null) {
            datos.put("Carrera", carrera.getNombreCarrera());
        }
        if (carrera.getFacultad() != 0) {
            datos.put("Facultad", carrera.getFacultad());
        }

        return datos;

    }

}
