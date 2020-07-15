package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICarrera extends Remote {

    int getCodCarrera() throws RemoteException;

    void setCodCarrera(int codigocarrera) throws RemoteException;

    String getNombreCarrera() throws RemoteException;

    void setNombreCarrera(String nombrecarrera) throws RemoteException;

    int getFacultad() throws RemoteException;

    void setFacultad(int facultad) throws RemoteException;

    String getString() throws RemoteException;
}
