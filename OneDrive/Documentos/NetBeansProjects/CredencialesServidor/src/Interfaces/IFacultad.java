package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFacultad extends Remote {

    int getId() throws RemoteException;

    void setId(int id) throws RemoteException;

    String getFacultad() throws RemoteException;

    void setFacultad(String facultad) throws RemoteException;

    String getString() throws RemoteException;

}
