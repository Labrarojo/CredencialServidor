package Servidor;

import Interfaces.ISecretario;
import Interfaces.ISecretarioController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecretarioController extends UnicastRemoteObject implements ISecretarioController {

    private DBManager dbManager;
    private final String TABLE = "SECRETARIO";

    public SecretarioController() throws RemoteException {
        dbManager = new DBManager();
    }

    public ISecretario newInstance() throws RemoteException {
        return new Secretario();
    }

    public int add(ISecretario secretario) throws RemoteException {
        ISecretario secretarioEncontrado = findOne(secretario.getMatriculaSecretario());
        boolean existe = secretarioEncontrado.getMatriculaSecretario() != null;

        if (existe) {
            return ADD_MATRICULA_DUPLICADA;
        }
        Map<String, Object> datos = Secretario.toMap(secretario);

        int respuesta = dbManager.insertar(TABLE, datos);

        return (respuesta > 0) ? ADD_EXITO : ADD_SIN_EXITO;
    }

    public int update(ISecretario secretario) throws RemoteException {
        if (secretario.getMatriculaSecretario() == null) {
            return UPDATE_MATRICULA_NULA;
        }

        ISecretario secretarioEncontrado = findOne(secretario.getMatriculaSecretario());
        if (secretarioEncontrado.getMatriculaSecretario() == null) {
            return UPDATE_MATRICULA_INEXISTE;
        }

        Map<String, Object> datos = Secretario.toMap(secretario);
        Map<String, Object> where = new HashMap<>();
        where.put("MatriculaSecretario", secretario.getMatriculaSecretario());
        int respuesta = dbManager.actualizar(TABLE, datos, where);

        return (respuesta > 0) ? UPDATE_EXITO : UPDATE_SIN_EXITO;
    }

    public int delete(ISecretario secretario) throws RemoteException {
        ISecretario secretarioTemp = findOne(secretario.getMatriculaSecretario());
        if (secretarioTemp.getMatriculaSecretario() == null) {
            return DELETE_MATRICULA_INEXISTENTE;
        }

        Map<String, Object> where = new HashMap<>();
        where.put("MatriculaSecretario", secretario.getMatriculaSecretario());

        int respuesta = dbManager.eliminar(TABLE, where);

        if (respuesta == 0) {
            return DELETE_SIN_EXITO;
        } else {
            return DELETE_EXITO;
        }
    }

    public int delete(String matriculaSecretario) throws RemoteException {
        ISecretario secretario = new Secretario();
        secretario.setMatriculaSecretario(matriculaSecretario);
        return delete(secretario);
    }

    public List<ISecretario> list() throws RemoteException {
        List<ISecretario> listaISecretario = new ArrayList<>();

        List<Map<String, Object>> registros = dbManager.listar(TABLE);

        for (Map<String, Object> registro : registros) {
            ISecretario secretario = Secretario.fromMap(registro);
            listaISecretario.add(secretario);

        }

        return listaISecretario;
    }

    public ISecretario findOne(String matriculaSecretario) throws RemoteException {
        Map<String, Object> where = new HashMap<>();
        where.put("MatriculaSecretario", matriculaSecretario);
        Map<String, Object> registro = dbManager.buscarUno(TABLE, where);

        return Secretario.fromMap(registro);
    }

    public List<ISecretario> find(ISecretario secretario) throws RemoteException {
        List<ISecretario> listaISecretario = new ArrayList<>();

        Map<String, Object> where = Secretario.toMap(secretario);
        List<Map<String, Object>> registros = dbManager.listar(TABLE, where);

        for (Map<String, Object> registro : registros) {
            ISecretario secretarioTemp = Secretario.fromMap(registro);
            listaISecretario.add(secretarioTemp);

        }

        return listaISecretario;
    }

}
