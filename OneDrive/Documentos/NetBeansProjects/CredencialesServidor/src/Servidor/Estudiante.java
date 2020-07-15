package Servidor;

import Interfaces.IEstudiante;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class Estudiante extends UnicastRemoteObject implements IEstudiante {

    private String foto;
    private String firma;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String matricula;
    private int programaEducativo;
    private int facultad;

    public Estudiante() throws RemoteException {

    }

    public Estudiante(String foto, String firma, String nombre, String apellidoPaterno, String apellidoMaterno, String matricula, int programaEducativo, int facultad) throws RemoteException {
        this.foto = foto;
        this.firma = firma;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.matricula = matricula;
        this.programaEducativo = programaEducativo;
        this.facultad = facultad;
    }

    @Override
    public String getNombre() throws RemoteException {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) throws RemoteException {
        this.nombre = nombre;
    }

    @Override
    public String getMatricula() throws RemoteException {
        return matricula;
    }

    @Override
    public void setMatricula(String matricula) throws RemoteException {
        this.matricula = matricula;
    }

    @Override
    public int getProgramaEducativo() throws RemoteException {
        return programaEducativo;
    }

    @Override
    public void setProgramaEducativo(int programaEducativo) throws RemoteException {
        this.programaEducativo = programaEducativo;
    }

    @Override
    public int getFacultad() throws RemoteException {
        return facultad;
    }

    @Override
    public void setFacultad(int facultad) throws RemoteException {
        this.facultad = facultad;
    }

    public String getString() {
        return String.format("nombreAlumno: %s \napellido paterno: %s \napellido materno: %s \nmatricula: %s \nprogramaEducativo: %d \nfacultad: %d", nombre, apellidoPaterno, apellidoMaterno, matricula, programaEducativo, facultad);
    }

    public static IEstudiante fromMap(Map<String, Object> map) throws RemoteException {
        IEstudiante estudiante = new Estudiante();

        if (map.containsKey("nombres")) {
            estudiante.setNombre((String) map.get("nombres"));
        }
        if (map.containsKey("ApellidoPaterno")) {
            estudiante.setApellidoPaterno((String) map.get("ApellidoPaterno"));
        }
        if (map.containsKey("ApellidoMaterno")) {
            estudiante.setApellidoMaterno((String) map.get("ApellidoMaterno"));
        }

        if (map.containsKey("matricula")) {
            estudiante.setMatricula((String) map.get("matricula"));
        }

        if (map.containsKey("programaEducativo")) {
            estudiante.setProgramaEducativo((Integer) map.get("programaEducativo"));
        }

        if (map.containsKey("facultad")) {
            estudiante.setFacultad((Integer) map.get("facultad"));
        }

        return estudiante;
    }

    public static Map<String, Object> toMap(IEstudiante estudiante) throws RemoteException {
        Map<String, Object> datos = new HashMap<>();
        if (estudiante.getNombre() != null) {
            datos.put("nombres", estudiante.getNombre());
        }
        if (estudiante.getApellidoPaterno()!= null) {
            datos.put("ApellidoPaterno", estudiante.getApellidoPaterno());
        }
        if (estudiante.getApellidoMaterno()!= null) {
            datos.put("ApellidoMaterno", estudiante.getApellidoMaterno());
        }
        if (estudiante.getMatricula() != null) {
            datos.put("matricula", estudiante.getMatricula());
        }
        if (estudiante.getProgramaEducativo() != 0) {
            datos.put("programaEducativo", estudiante.getProgramaEducativo());
        }
        if (estudiante.getFacultad() != 0) {
            datos.put("facultad", estudiante.getFacultad());
        }
        return datos;
    }

    @Override
    public String getFoto() throws RemoteException {
        return foto;
    }

    @Override
    public void setFoto(String foto) throws RemoteException {
        this.foto = foto;
    }

    @Override
    public String getFirma() throws RemoteException {
        return foto;
    }

    @Override
    public void setFirma(String firma) throws RemoteException {
        this.foto = firma;
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

}
