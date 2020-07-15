package Servidor;

import Interfaces.ISecretario;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class Secretario extends UnicastRemoteObject implements ISecretario {

    private String matriculaSecr;
    private int facultad;
    private String nombreSecr;

    public Secretario() throws RemoteException {

    }

    @Override
    public String getMatriculaSecr() throws RemoteException {
        return matriculaSecr;
    }

    @Override
    public void setMatriculaSecr(String matriculaSecr) throws RemoteException {
        this.matriculaSecr = matriculaSecr;
    }

    @Override
    public int getFacultad() throws RemoteException {
        return facultad;

    }

    @Override
    public void setFacultad(int facultad) throws RemoteException {
        this.facultad = facultad;
    }

    @Override
    public String getNombreSecr() throws RemoteException {
        return nombreSecr;
    }

    @Override
    public void setNombreSecr(String nombreSecr) throws RemoteException {
        this.nombreSecr = nombreSecr;
    }

    public String getString() {
        return String.format("matriculaSecr; %s, facultad: %d, nombre: %s",
                matriculaSecr, facultad, nombreSecr);
    }

    public static ISecretario fromMap(Map<String, Object> map) throws RemoteException {
        ISecretario secretario = new Secretario();

        if (map.containsKey("MatriculaSecr")) {
            secretario.setMatriculaSecr((String) map.get("MatriculaSecr"));
        }

        if (map.containsKey("Facultad")) {
            secretario.setFacultad((Integer) map.get("Facultad"));
        }

        if (map.containsKey("NombreSecr")) {
            secretario.setNombreSecr((String) map.get("Hora"));
        }

        return secretario;
    }

    public static Map<String, Object> toMap(ISecretario secretario) throws RemoteException {
        Map<String, Object> datos = new HashMap<>();

        if (secretario.getMatriculaSecr() != null) {
            datos.put("MatriculaSecr", secretario.getMatriculaSecr());
        }
        if (secretario.getFacultad() != 0) {
            datos.put("Facultad", secretario.getFacultad());
        }
        if (secretario.getNombreSecr() != null) {
            datos.put("NombreSecr", secretario.getNombreSecr());
        }
        return datos;
    }
}
