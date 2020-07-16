package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITramite extends Remote {

    int getFolio() throws RemoteException;

    void setFolio(int folio) throws RemoteException;

    String getMatricula() throws RemoteException;

    void setMatricula(String matricula) throws RemoteException;

    String getFecha() throws RemoteException;

    void setFecha(String fecha) throws RemoteException;

    String getEstado() throws RemoteException;

    void setEstado(String estado) throws RemoteException;

    String getString() throws RemoteException;

}
