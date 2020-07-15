package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISecretario extends Remote {

    String getMatriculaSecr() throws RemoteException;

    void setMatriculaSecr(String matriculaSecr) throws RemoteException;

    int getFacultad() throws RemoteException;

    void setFacultad(int facultad) throws RemoteException;

    String getNombreSecr() throws RemoteException;

    void setNombreSecr(String nombreSecr) throws RemoteException;

}
