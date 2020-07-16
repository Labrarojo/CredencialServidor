package Servidor;

import Interfaces.ITramite;
import Interfaces.ITramiteController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TramiteController extends UnicastRemoteObject implements ITramiteController {

    private DBManager dbManager;
    private final String TABLE = "TRAMITE";

    public TramiteController() throws RemoteException {
        dbManager = DBManager.getInstance();
    }

    public ITramite newInstance() throws RemoteException {
        return new Tramite();
    }

    public int add(ITramite tramite) throws RemoteException {
        ITramite tramiteEncontrado = findOne(tramite.getFolio());

        boolean existe = (tramiteEncontrado.getFolio() != 0);

        if (existe) {
            return ADD_FOLIO_DUPLICADO;
        }

        Map<String, Object> datos = Tramite.toMap(tramite);

        int respuesta = dbManager.insertar(TABLE, datos);

        return respuesta > 0 ? ADD_EXITO : ADD_SIN_EXITO;
    }

    public int update(ITramite tramite) throws RemoteException {
        if (tramite.getFolio() == 0) {
            return UPDATE_FOLIO_NULO;
        }

        ITramite tramiteEncontrado = findOne(tramite.getFolio());
        if (tramiteEncontrado.getFolio() == 0) {
            return UPDATE_FOLIO_INEXISTE;
        }

        Map<String, Object> datos = Tramite.toMap(tramite);
        Map<String, Object> where = new HashMap<>();
        where.put("Folio", tramite.getFolio());
        int respuesta = dbManager.actualizar(TABLE, datos, where);

        return (respuesta > 0) ? UPDATE_EXITO : UPDATE_SIN_EXITO;
    }

    public int delete(ITramite tramite) throws RemoteException {
        ITramite tramiteTemp = findOne(tramite.getFolio());
        if (tramiteTemp.getFolio() == 0) {
            return DELETE_FOLIO_INEXISTE;
        }
        Map<String, Object> where = new HashMap<>();
        where.put(TABLE, tramite.getFolio());

        int respuesta = dbManager.eliminar(TABLE, where);
        if (respuesta == 0) {
            return DELETE_SIN_EXITO;
        } else {
            return DELETE_EXITO;
        }
    }

    public int delete(String matricula) throws RemoteException {
        ITramite proveedorTemp = findOne(matricula);
        if (proveedorTemp.getFolio() == 0) {
            return DELETE_FOLIO_INEXISTE;
        }
        Map<String, Object> where = new HashMap<>();
        where.put("Matricula", matricula);

        int respuesta = dbManager.eliminar(TABLE, where);
        if (respuesta == 0) {
            return DELETE_SIN_EXITO;
        } else {
            return DELETE_EXITO;
        }
    }

    public int delete(int folio) throws RemoteException {
        ITramite tramiteTemp = findOne(folio);
        if (tramiteTemp.getFolio() == 0) {
            return DELETE_FOLIO_INEXISTE;
        }
        Map<String, Object> where = new HashMap<>();
        where.put("Folio", folio);

        int respuesta = dbManager.eliminar(TABLE, where);
        if (respuesta == 0) {
            return DELETE_SIN_EXITO;
        } else {
            return DELETE_EXITO;
        }
    }

    public List<ITramite> list() throws RemoteException {
        List<ITramite> listaITramite = new ArrayList<>();

        List<Map<String, Object>> registros = dbManager.listar(TABLE);

        for (Map<String, Object> registro : registros) {
            ITramite tramite = Tramite.fromMap(registro);

            listaITramite.add(tramite);

        }

        return listaITramite;
    }

    public ITramite findOne(int folio) throws RemoteException {
        Map<String, Object> where = new HashMap<>();
        where.put("Folio", folio);
        Map<String, Object> registro = dbManager.buscarUno(TABLE, where);

        return Tramite.fromMap(registro);
    }

    public ITramite findOne(String matricula) throws RemoteException {
        Map<String, Object> where = new HashMap<>();
        where.put("Matricula", matricula);
        Map<String, Object> registro = dbManager.buscarUno(TABLE, where);

        return Tramite.fromMap(registro);
    }

    public List<ITramite> find(ITramite tramite) throws RemoteException {
        List<ITramite> listaITramite = new ArrayList<>();

        Map<String, Object> where = Tramite.toMap(tramite);
        List<Map<String, Object>> registros = dbManager.listar(TABLE, where);

        for (Map<String, Object> registro : registros) {
            ITramite tramiteTemp = Tramite.fromMap(registro);

            listaITramite.add(tramiteTemp);

        }

        return listaITramite;
    }

}
