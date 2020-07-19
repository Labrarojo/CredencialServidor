package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ICarreraController extends Remote {

    ICarrera newInstance() throws RemoteException;

    int add(ICarrera carrera) throws RemoteException;

    int update(ICarrera carrera) throws RemoteException;

    int delete(ICarrera carrera) throws RemoteException;

    int delete(int idCarrera) throws RemoteException;

    int delete(String nombreCarrera) throws RemoteException;

    List<ICarrera> list() throws RemoteException;

    ICarrera findOne(int idCarrera) throws RemoteException;

    ICarrera findOne(String nombreCarrera) throws RemoteException;

    List<ICarrera> find(ICarrera carrera) throws RemoteException;

    int ADD_EXITO = 1;
    int ADD_ID_DUPLICADO = 2;
    int ADD_SIN_EXITO = 3;

    int UPDATE_EXITO = 1;
    int UPDATE_ID_INEXISTE = 2;
    int UPDATE_ID_NULO = 3;
    int UPDATE_SIN_EXITO = 4;

    int DELETE_EXITO = 1;
    int DELETE_ID_INEXISTENTE = 2;
    int DELETE_ID_NULO = 3;
    int DELETE_SIN_EXITO = 4;
}
