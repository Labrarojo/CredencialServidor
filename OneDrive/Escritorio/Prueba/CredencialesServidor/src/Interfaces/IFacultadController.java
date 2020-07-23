package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IFacultadController extends Remote {

    IFacultad newInstance() throws RemoteException;

    int add(IFacultad facultad) throws RemoteException;

    int update(IFacultad facultad) throws RemoteException;

    int delete(IFacultad facultad) throws RemoteException;

    int delete(String nombreFacultad) throws RemoteException;

    int delete(int idFacultad) throws RemoteException;

    List<IFacultad> list() throws RemoteException;

    IFacultad findOne(int idFacultad) throws RemoteException;

    IFacultad findOne(String nombreFacultad) throws RemoteException;

    List<IFacultad> find(IFacultad facultad) throws RemoteException;

    int ADD_EXITO = 1;
    int ADD_ID_DUPLICADO = 2;
    int ADD_SIN_EXITO = 3;

    int UPDATE_EXITO = 1;
    int UPDATE_ID_INEXISTE = 2;
    int UPDATE_ID_NULO = 3;
    int UPDATE_SIN_EXITO = 4;

    int DELETE_EXITO = 1;
    int DELETE_ID_INEXISTE = 2;
    int DELETE_ID_NULO = 3;
    int DELETE_SIN_EXITO = 4;
}
