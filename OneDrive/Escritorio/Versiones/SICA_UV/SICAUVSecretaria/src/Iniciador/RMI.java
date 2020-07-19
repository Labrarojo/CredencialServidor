package Iniciador;

import Interfaces.ICarreraController;
import Interfaces.IEstudianteController;
import Interfaces.IFacultadController;
import Interfaces.ISecretarioController;
import Interfaces.ITramiteController;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RMI {
    private static ICarreraController carreraController;
    private static IEstudianteController estudianteController;
    private static IFacultadController facultadController;
    private static ISecretarioController secretarioController;
    private static ITramiteController tramiteController;

    public static ICarreraController getICarreraController() {
        try {
            if (carreraController == null) {
                carreraController = (ICarreraController) Naming.lookup("rmi://localhost/carreracontroller");
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(RMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(RMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(RMI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return carreraController;
    }

    public static IEstudianteController getIEstudianteController() {
        try {
            if (estudianteController == null) {
                estudianteController = (IEstudianteController) Naming.lookup("rmi://localhost/estudiantecontroller");
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(RMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(RMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(RMI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estudianteController;
    }

    public static IFacultadController getIFacultadController() {
        try {
            if (facultadController == null) {
                facultadController = (IFacultadController) Naming.lookup("rmi://localhost/facultadcontroller");
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(RMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(RMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(RMI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return facultadController;
    }

    public static ISecretarioController getISecretarioController() {
        try {
            if (secretarioController == null) {
                secretarioController = (ISecretarioController) Naming.lookup("rmi://localhost/secretariocontroller");
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(RMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(RMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(RMI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return secretarioController;
    }
    
    public static ITramiteController getITramiteController() {
        try {
            if (tramiteController == null) {
                tramiteController = (ITramiteController) Naming.lookup("rmi://localhost/tramitecontroller");
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(RMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(RMI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(RMI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tramiteController;
    }
}
