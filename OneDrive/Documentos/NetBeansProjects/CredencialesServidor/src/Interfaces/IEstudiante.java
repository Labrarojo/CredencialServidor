package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IEstudiante extends Remote {

    String getNombre() throws RemoteException;

    void setNombre(String nombreAlumno) throws RemoteException;

    String getApellidoPaterno() throws RemoteException;

    void setApellidoPaterno(String apellidoPaterno) throws RemoteException;

    String getApellidoMaterno() throws RemoteException;

    void setApellidoMaterno(String apellidoMaterno) throws RemoteException;

    String getMatricula() throws RemoteException;

    void setMatricula(String matricula) throws RemoteException;

    int getProgramaEducativo() throws RemoteException;

    void setProgramaEducativo(int programaEducativo) throws RemoteException;

    int getFacultad() throws RemoteException;

    void setFacultad(int facultad) throws RemoteException;

    //Foto y firma ¿? 
    String getFoto() throws RemoteException;

    void setFoto(String foto) throws RemoteException;

    String getFirma() throws RemoteException;

    void setFirma(String firma) throws RemoteException;

}
