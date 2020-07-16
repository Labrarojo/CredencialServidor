package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICarrera extends Remote {

    int getIdCarrera() throws RemoteException;

    void setIdCarrera(int idCarrera) throws RemoteException;

    String getNombreCarrera() throws RemoteException;

    void setNombreCarrera(String nombrecarrera) throws RemoteException;

    int getIdFacultad() throws RemoteException;

    void setIdFacultad(int idFacultad) throws RemoteException;

    String getString() throws RemoteException;
}
