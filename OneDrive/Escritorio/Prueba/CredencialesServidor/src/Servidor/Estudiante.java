package Servidor;

import Interfaces.IEstudiante;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Blob;
import java.util.HashMap;
import java.util.Map;

public class Estudiante extends UnicastRemoteObject implements IEstudiante {

    private Blob foto;
    private Blob firma;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String matricula;
    private int idCarrera;
    private int idFacultad;

    public Estudiante() throws RemoteException {

    }

    public Estudiante(Blob foto, Blob firma, String nombres, String apellidoPaterno, String apellidoMaterno, String matricula, int idCarrera, int idFacultad) throws RemoteException {
        this.foto = foto;
        this.firma = firma;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.matricula = matricula;
        this.idCarrera = idCarrera;
        this.idFacultad = idFacultad;
    }

    public String getMatricula() throws RemoteException {
        return matricula;
    }

    public void setMatricula(String matricula) throws RemoteException {
        this.matricula = matricula;
    }

    public int getIdCarrera() throws RemoteException {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) throws RemoteException {
        this.idCarrera = idCarrera;
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

    public void setNombres(String nombres) throws RemoteException {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Blob getFoto() throws RemoteException {
        return foto;
    }

    public void setFoto(Blob foto) throws RemoteException {
        this.foto = foto;
    }

    public Blob getFirma() throws RemoteException {
        return foto;
    }

    public void setFirma(Blob firma) throws RemoteException {
        this.foto = firma;
    }

    public String getString() {
        return String.format("nombreAlumno: %s \napellido paterno: %s \napellido materno: %s \nmatricula: %s \nprogramaEducativo: %d \nfacultad: %d", nombres, apellidoPaterno, apellidoMaterno, matricula, idCarrera, idFacultad);
    }

    public static IEstudiante fromMap(Map<String, Object> map) throws RemoteException {
        IEstudiante estudiante = new Estudiante();

        if (map.containsKey("Matricula")) {
            estudiante.setMatricula((String) map.get("Matricula"));
        }
        if (map.containsKey("IdFacultad")) {
            estudiante.setIdFacultad((Integer) map.get("IdFacultad"));
        }
        if (map.containsKey("IdCarrera")) {
            estudiante.setIdCarrera((Integer) map.get("IdCarrera"));
        }
        if (map.containsKey("Nombres")) {
            estudiante.setNombres((String) map.get("Nombres"));
        }
        if (map.containsKey("ApellidoPaterno")) {
            estudiante.setApellidoPaterno((String) map.get("ApellidoPaterno"));
        }
        if (map.containsKey("ApellidoMaterno")) {
            estudiante.setApellidoMaterno((String) map.get("ApellidoMaterno"));
        }
        if (map.containsKey("Foto")) {
            estudiante.setFoto((Blob) map.get("Foto"));
        }
        if (map.containsKey("Firma")) {
            estudiante.setFirma((Blob) map.get("Firma"));
        }

        return estudiante;
    }

    public static Map<String, Object> toMap(IEstudiante estudiante) throws RemoteException {
        Map<String, Object> datos = new HashMap<>();

        if (estudiante.getMatricula() != null) {
            datos.put("Matricula", estudiante.getMatricula());
        }
        if (estudiante.getIdFacultad() != 0) {
            datos.put("IdFacultad", estudiante.getIdFacultad());
        }
        if (estudiante.getIdCarrera() != 0) {
            datos.put("IdCarrera", estudiante.getIdCarrera());
        }
        if (estudiante.getNombres() != null) {
            datos.put("Nombres", estudiante.getNombres());
        }
        if (estudiante.getApellidoPaterno() != null) {
            datos.put("ApellidoPaterno", estudiante.getApellidoPaterno());
        }
        if (estudiante.getApellidoMaterno() != null) {
            datos.put("ApellidoMaterno", estudiante.getApellidoMaterno());
        }
        if (estudiante.getFoto()!= null) {
            datos.put("Foto", estudiante.getFoto());
        }
        if (estudiante.getFirma()!= null) {
            datos.put("Firma", estudiante.getFirma());
        }

        return datos;
    }

}
