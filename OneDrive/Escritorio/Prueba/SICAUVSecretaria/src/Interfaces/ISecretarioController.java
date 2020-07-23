package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ISecretarioController extends Remote {

    ISecretario newInstance() throws RemoteException;

    int add(ISecretario secretario) throws RemoteException;

    int update(ISecretario secretario, String matriculaAnterior) throws RemoteException;

    int delete(ISecretario secretario) throws RemoteException;

    int delete(String matriculaSecretario) throws RemoteException;

    List<ISecretario> list() throws RemoteException;

    ISecretario findOne(String matriculaSecretario) throws RemoteException;

    List<ISecretario> find(ISecretario secretario) throws RemoteException;

    int ADD_EXITO = 1;
    int ADD_MATRICULA_DUPLICADA = 2;
    int ADD_SIN_EXITO = 3;

    int UPDATE_EXITO = 1;
    int UPDATE_MATRICULA_INEXISTE = 2;
    int UPDATE_MATRICULA_NULA = 3;
    int UPDATE_SIN_EXITO = 4;

    int DELETE_EXITO = 1;
    int DELETE_MATRICULA_INEXISTENTE = 2;
    int DELETE_MATRICULA_NULO = 3;
    int DELETE_SIN_EXITO = 4;

}
