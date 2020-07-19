package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IEstudianteController extends Remote {

    IEstudiante newInstance() throws RemoteException;

    int add(IEstudiante estudiante) throws RemoteException;

    int update(IEstudiante estudiante) throws RemoteException;

    int delete(IEstudiante estudiante) throws RemoteException;

    int delete(String matricula) throws RemoteException;

    List<IEstudiante> list() throws RemoteException;

    IEstudiante findOne(String matricula) throws RemoteException;

    List<IEstudiante> find(IEstudiante estudiante) throws RemoteException;

    int ADD_EXITO = 1;
    int ADD_ESTUDIANTE_DUPLICADO = 2;
    int ADD_SIN_EXITO = 3;

    int UPDATE_EXITO = 1;
    int UPDATE_ESTUDIANTE_INEXISTE = 2;
    int UPDATE_ESTUDIANTE_NULO = 3;
    int UPDATE_SIN_EXITO = 4;

    int DELETE_EXITO = 1;
    int DELETE_ESTUDIANTE_INEXISTENTE = 2;
    int DELETE_ESTUDIANTE_NULO = 3;
    int DELETE_SIN_EXITO = 4;

}
