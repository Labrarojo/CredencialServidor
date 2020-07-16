package Servidor;

import Interfaces.ICarrera;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class Carrera extends UnicastRemoteObject implements ICarrera {

    private int idcarrera;
    private String nombrecarrera;
    private int idfacultad;

    public Carrera() throws RemoteException {

    }

    public Carrera(int idcarrera, String nombrecarrera, int facultad) throws RemoteException {
        this.idcarrera = idcarrera;
        this.nombrecarrera = nombrecarrera;
        this.idfacultad = facultad;
    }

    public int getIdCarrera() throws RemoteException {
        return idcarrera;
    }

    public void setIdCarrera(int idcarrera) throws RemoteException {
        this.idcarrera = idcarrera;
    }

    public String getNombreCarrera() throws RemoteException {
        return nombrecarrera;
    }

    public void setNombreCarrera(String nombrecarrera) throws RemoteException {
        this.nombrecarrera = nombrecarrera;
    }

    public int getIdFacultad() throws RemoteException {
        return idfacultad;
    }

    public void setIdFacultad(int idfacultad) throws RemoteException {
        this.idfacultad = idfacultad;
    }

    public String getString() throws RemoteException {
        return String.format("IdCarrera: %d, NombreCarrera: %s, IdFacultad: %d", idcarrera, nombrecarrera, idfacultad);
    }

    public static ICarrera fromMap(Map<String, Object> map) throws RemoteException {
        ICarrera carrera = new Carrera();

        if (map.containsKey("IdCarrera")) {
            carrera.setIdCarrera((Integer) map.get("IdCarrera"));
        }

        if (map.containsKey("NombreCarrera")) {
            carrera.setNombreCarrera((String) map.get("NombreCarrera"));
        }

        if (map.containsKey("IdFacultad")) {
            carrera.setIdFacultad((Integer) map.get("IdFacultad"));
        }

        return carrera;
    }

    public static Map<String, Object> toMap(ICarrera carrera) throws RemoteException {
        Map<String, Object> datos = new HashMap<>();

        if (carrera.getIdCarrera() != 0) {
            datos.put("IdCarrera", carrera.getIdCarrera());
        }
        if (carrera.getNombreCarrera() != null) {
            datos.put("NombreCarrera", carrera.getNombreCarrera());
        }
        if (carrera.getIdFacultad() != 0) {
            datos.put("IdFacultad", carrera.getIdFacultad());
        }

        return datos;

    }

}
