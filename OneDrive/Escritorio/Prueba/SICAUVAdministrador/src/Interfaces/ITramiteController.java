package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ITramiteController extends Remote{

    ITramite newInstance() throws RemoteException;

    int add(ITramite tramite) throws RemoteException;

    int update(ITramite tramite, String folioAnterior) throws RemoteException;

    int delete(ITramite tramite) throws RemoteException;

    int delete(String folio) throws RemoteException;

    List<ITramite> list() throws RemoteException;

    ITramite findOne(String folio) throws RemoteException;

    List<ITramite> find(ITramite tramite) throws RemoteException;

    int ADD_EXITO = 1;
    int ADD_FOLIO_DUPLICADO = 2;
    int ADD_SIN_EXITO = 3;

    int UPDATE_EXITO = 1;
    int UPDATE_FOLIO_INEXISTE = 2;
    int UPDATE_FOLIO_NULO = 3;
    int UPDATE_SIN_EXITO = 4;

    int DELETE_EXITO = 1;
    int DELETE_FOLIO_INEXISTE = 2;
    int DELETE_FOLIO_NULO = 3;
    int DELETE_SIN_EXITO = 4;
}
