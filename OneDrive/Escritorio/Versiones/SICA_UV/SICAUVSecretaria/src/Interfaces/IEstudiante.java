package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Blob;

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

    Blob getFoto() throws RemoteException;

    void setFoto(Blob foto) throws RemoteException;

    Blob getFirma() throws RemoteException;

    void setFirma(Blob firma) throws RemoteException;
}
