package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITramite extends Remote {

    int getFolio() throws RemoteException;

    void setFolio(int folio) throws RemoteException;

    String getMatricula() throws RemoteException;

    void setMatricula(String matricula) throws RemoteException;
    
    int getCarrera() throws RemoteException;

    void setCarrera(int carrera) throws RemoteException;

    String getFecha() throws RemoteException;

    void setFecha(String fecha) throws RemoteException;

    String getFoto() throws RemoteException;

    void setFoto(String foto) throws RemoteException;

    String getFirma() throws RemoteException;

    void setFirma(String firma) throws RemoteException;

    boolean getEstado() throws RemoteException;

    void setEstado(boolean estado) throws RemoteException;

    String getString() throws RemoteException;

}
