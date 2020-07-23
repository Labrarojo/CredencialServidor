package Servidor;

import Interfaces.ISecretario;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class Secretario extends UnicastRemoteObject implements ISecretario {

    private String matriculaSecretario;
    private int idFacultad;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String contraseña;

    public Secretario() throws RemoteException {

    }

    public Secretario(String matriculasecretario, int idfacultad, String nombres, String apellidopaterno, String apellidomaterno, String contraseña) throws RemoteException {
        this.matriculaSecretario = matriculasecretario;
        this.idFacultad = idfacultad;
        this.nombres = nombres;
        this.apellidoPaterno = apellidopaterno;
        this.apellidoMaterno = apellidomaterno;
        this.contraseña = contraseña;
    }

    public String getMatriculaSecretario() throws RemoteException {
        return matriculaSecretario;
    }

    public void setMatriculaSecretario(String matricula) throws RemoteException {
        this.matriculaSecretario = matricula;
    }

    public int getIdFacultad() throws RemoteException {
        return idFacultad;

    }

    public void setIdFacultad(int idFacultad) throws RemoteException {
        this.idFacultad = idFacultad;
    }

    public String getNombres() throws RemoteException {
        return nombres;
    }

    public void setNombres(String nombreSecretario) throws RemoteException {
        this.nombres = nombreSecretario;
    }

    public String getApellidoPaterno() throws RemoteException {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) throws RemoteException {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() throws RemoteException {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) throws RemoteException {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getContraseña() throws RemoteException {
        return contraseña;
    }

    public void setContraseña(String contraseña) throws RemoteException {
        this.contraseña = contraseña;
    }

    public String getString() {
        return String.format("MatriculaSecretario: %s, IdFacultad: %d, Nombres: %s, ApellidoPaterno: %s, ApellidoMaterno: %s, Contraseña: %s", matriculaSecretario, idFacultad, nombres, apellidoPaterno, apellidoMaterno, contraseña);
    }

    public static ISecretario fromMap(Map<String, Object> map) throws RemoteException {
        ISecretario secretario = new Secretario();

        if (map.containsKey("MatriculaSecretario")) {
            secretario.setMatriculaSecretario((String) map.get("MatriculaSecretario"));
        }

        if (map.containsKey("IdFacultad")) {
            secretario.setIdFacultad((Integer) map.get("IdFacultad"));
        }

        if (map.containsKey("Nombres")) {
            secretario.setNombres((String) map.get("Nombres"));
        }

        if (map.containsKey("ApellidoPaterno")) {
            secretario.setApellidoPaterno((String) map.get("ApellidoPaterno"));
        }

        if (map.containsKey("ApellidoMaterno")) {
            secretario.setApellidoMaterno((String) map.get("ApellidoMaterno"));
        }

        if (map.containsKey("Contraseña")) {
            secretario.setContraseña((String) map.get("Contraseña"));
        }

        return secretario;
    }

    public static Map<String, Object> toMap(ISecretario secretario) throws RemoteException {
        Map<String, Object> datos = new HashMap<>();

        if (secretario.getMatriculaSecretario() != null) {
            datos.put("MatriculaSecretario", secretario.getMatriculaSecretario());
        }
        if (secretario.getIdFacultad() != 0) {
            datos.put("IdFacultad", secretario.getIdFacultad());
        }
        if (secretario.getNombres() != null) {
            datos.put("Nombres", secretario.getNombres());
        }
        if (secretario.getApellidoPaterno() != null) {
            datos.put("ApellidoPaterno", secretario.getApellidoPaterno());
        }
        if (secretario.getApellidoMaterno() != null) {
            datos.put("ApellidoMaterno", secretario.getApellidoMaterno());
        }
        if (secretario.getContraseña() != null) {
            datos.put("Contraseña", secretario.getContraseña());
        }
        return datos;
    }
}
