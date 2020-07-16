package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISecretario extends Remote {

    String getMatriculaSecretario() throws RemoteException;

    void setMatriculaSecretario(String matriculaSecretario) throws RemoteException;

    int getIdFacultad() throws RemoteException;

    void setIdFacultad(int idfacultad) throws RemoteException;

    String getNombres() throws RemoteException;

    void setNombres(String nombres) throws RemoteException;

    String getApellidoPaterno() throws RemoteException;

    void setApellidoPaterno(String apellidoPaterno) throws RemoteException;

    String getApellidoMaterno() throws RemoteException;

    void setApellidoMaterno(String apellidoMaterno) throws RemoteException;

    String getContraseña() throws RemoteException;

    void setContraseña(String contraseña) throws RemoteException;

    String getString() throws RemoteException;

}
