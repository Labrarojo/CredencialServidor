package Servidor;

import Interfaces.IFacultad;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class Facultad extends UnicastRemoteObject implements IFacultad {

    private int id;
    private String secretario;
    private String facultad;

    public Facultad() throws RemoteException{

    }

    public Facultad(int id, String secretario, String facultad) throws RemoteException{
        this.id = id;
        this.secretario = secretario;
        this.facultad = facultad;
    }

    public int getId() throws RemoteException{
        return id;
    }

    public void setId(int id) throws RemoteException{
        this.id = id;
    }

    public String getSecretario() throws RemoteException{
        return secretario;
    }

    public void setSecretario(String secretario) throws RemoteException{
        this.secretario = secretario;
    }

    public String getFacultad() throws RemoteException{
        return facultad;
    }

    public void setFacultad(String facultad) throws RemoteException{
        this.facultad = facultad;
    }

    public String getString() throws RemoteException {
        return String.format("Clave de la facultad: %d, Nombre del secretario: %s, Nombre de la facultad: %s", id, secretario, facultad);
    }

    public static IFacultad fromMap(Map<String, Object> map) throws RemoteException {
        IFacultad facultad = new Facultad();

        if (map.containsKey("CodFacultad")) {
            facultad.setId((Integer) map.get("CodFacultad"));
        }
        if (map.containsKey("Secretario")) {
            facultad.setSecretario((String) map.get("Secretario"));
        }
        if (map.containsKey("NombreFac")) {
            facultad.setFacultad((String) map.get("NombreFac"));
        }

        return facultad;
    }

    public static Map<String, Object> toMap(IFacultad facultad) throws RemoteException {
        Map<String, Object> datos = new HashMap<>();
        if (facultad.getId() != 0) {
            datos.put("CodFacultad", facultad.getId());
        }
        if (facultad.getSecretario() != null) {
            datos.put("Secretario", facultad.getSecretario());
        }
        if (facultad.getFacultad() != null) {
            datos.put("NombreFac", facultad.getFacultad());
        }

        return datos;
    }

}
