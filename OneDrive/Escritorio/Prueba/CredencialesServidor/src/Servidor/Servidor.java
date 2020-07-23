package Servidor;

import Interfaces.IFacultadController;
import Interfaces.ISecretarioController;
import Interfaces.IEstudianteController;
import Interfaces.ICarreraController;
import Interfaces.ITramiteController;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            IFacultadController facultadController = new FacultadController();
            ISecretarioController secretarioController = new SecretarioController();
            IEstudianteController estudianteController = new EstudianteController();
            ICarreraController carreraController = new CarreraController();
            ITramiteController tramiteController = new TramiteController();
            Naming.rebind("rmi://localhost/facultadcontroller", (facultadController));
            Naming.rebind("rmi://localhost/secretariocontroller", (secretarioController));
            Naming.rebind("rmi://localhost/estudiantecontroller", (estudianteController));
            Naming.rebind("rmi://localhost/carreracontroller", (carreraController));
            Naming.rebind("rmi://localhost/tramitecontroller", (tramiteController));
            System.out.println("Escuchando...");
        } catch (RemoteException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
