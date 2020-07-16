package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IEstudiante extends Remote {

    String getMatricula() throws RemoteException;

    void setMatricula(String matricula) throws RemoteException;

    int getIdFacultad() throws RemoteException;

    void setIdFacultad(int idFacultad) throws RemoteException;

    int getIdCarrera() throws RemoteException;

    void setIdCarrera(int idCarrera) throws RemoteException;

    String getNombres() throws RemoteException;

    void setNombres(String nombres) throws RemoteException;

    String getApellidoPaterno() throws RemoteException;

    void setApellidoPaterno(String apellidoPaterno) throws RemoteException;

    String getApellidoMaterno() throws RemoteException;

    void setApellidoMaterno(String apellidoMaterno) throws RemoteException;

    String getFoto() throws RemoteException;

    void setFoto(String foto) throws RemoteException;

    String getFirma() throws RemoteException;

    void setFirma(String firma) throws RemoteException;
}
