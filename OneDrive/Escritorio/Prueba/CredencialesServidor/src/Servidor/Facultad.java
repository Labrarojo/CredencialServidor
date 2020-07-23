package Servidor;

import Interfaces.IFacultad;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class Facultad extends UnicastRemoteObject implements IFacultad {

    private int id;
    private String facultad;

    public Facultad() throws RemoteException {

    }

    public Facultad(int id, String facultad) throws RemoteException {
        this.id = id;
        this.facultad = facultad;
    }

    public int getId() throws RemoteException {
        return id;
    }

    public void setId(int id) throws RemoteException {
        this.id = id;
    }

    public String getFacultad() throws RemoteException {
        return facultad;
    }

    public void setFacultad(String facultad) throws RemoteException {
        this.facultad = facultad;
    }

    public String getString() throws RemoteException {
        return String.format("Clave de la facultad: %d, Nombre de la facultad: %s", id, facultad);
    }

    public static IFacultad fromMap(Map<String, Object> map) throws RemoteException {
        IFacultad facultad = new Facultad();

        if (map.containsKey("IdFacultad")) {
            facultad.setId((Integer) map.get("IdFacultad"));
        }
        if (map.containsKey("NombreFacultad")) {
            facultad.setFacultad((String) map.get("NombreFacultad"));
        }

        return facultad;
    }

    public static Map<String, Object> toMap(IFacultad facultad) throws RemoteException {
        Map<String, Object> datos = new HashMap<>();
        if (facultad.getId() != 0) {
            datos.put("IdFacultad", facultad.getId());
        }
        if (facultad.getFacultad() != null) {
            datos.put("NombreFacultad", facultad.getFacultad());
        }

        return datos;
    }

}
