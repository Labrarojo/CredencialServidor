package Servidor;

import Interfaces.IFacultad;
import Interfaces.IFacultadController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacultadController extends UnicastRemoteObject implements IFacultadController {

    private DBManager dbManager;
    private final String TABLE = "FACULTAD";

    public FacultadController() throws RemoteException {
        dbManager = DBManager.getInstance();
    }

    public IFacultad newInstance() throws RemoteException {
        return new Facultad();
    }

    public int add(IFacultad facultad) throws RemoteException {
        IFacultad facultadEncontrado = findOne(facultad.getId());

        boolean existe = (facultadEncontrado.getId() != 0);

        if (existe) {
            return ADD_ID_DUPLICADO;
        }

        Map<String, Object> datos = Facultad.toMap(facultad);

        int respuesta = dbManager.insertar(TABLE, datos);

        return respuesta > 0 ? ADD_EXITO : ADD_SIN_EXITO;
    }

    public int update(IFacultad facultad) throws RemoteException {
        if (facultad.getId() == 0) {
            return UPDATE_ID_NULO;
        }

        IFacultad facultadEncontrado = findOne(facultad.getId());
        if (facultadEncontrado.getId() == 0) {
            return UPDATE_ID_INEXISTE;
        }

        Map<String, Object> datos = Facultad.toMap(facultad);
        Map<String, Object> where = new HashMap<>();
        where.put("IdFacultad", facultad.getId());
        int respuesta = dbManager.actualizar(TABLE, datos, where);

        return (respuesta > 0) ? UPDATE_EXITO : UPDATE_SIN_EXITO;
    }

    public int delete(IFacultad facultad) throws RemoteException {
        IFacultad facultadTemp = findOne(facultad.getId());
        if (facultadTemp.getId() == 0) {
            return DELETE_ID_INEXISTE;
        }
        Map<String, Object> where = new HashMap<>();
        where.put(TABLE, facultad.getId());

        int respuesta = dbManager.eliminar(TABLE, where);
        if (respuesta == 0) {
            return DELETE_SIN_EXITO;
        } else {
            return DELETE_EXITO;
        }
    }

    public int delete(String nombreFacultad) throws RemoteException {
        IFacultad proveedorTemp = findOne(nombreFacultad);
        if (proveedorTemp.getId() == 0) {
            return DELETE_ID_INEXISTE;
        }
        Map<String, Object> where = new HashMap<>();
        where.put("NombreFacultad", nombreFacultad);

        int respuesta = dbManager.eliminar(TABLE, where);
        if (respuesta == 0) {
            return DELETE_SIN_EXITO;
        } else {
            return DELETE_EXITO;
        }
    }

    public int delete(int idFacultad) throws RemoteException {
        IFacultad facultadTemp = findOne(idFacultad);
        if (facultadTemp.getId() == 0) {
            return DELETE_ID_INEXISTE;
        }
        Map<String, Object> where = new HashMap<>();
        where.put("IdFacultad", idFacultad);

        int respuesta = dbManager.eliminar(TABLE, where);
        if (respuesta == 0) {
            return DELETE_SIN_EXITO;
        } else {
            return DELETE_EXITO;
        }
    }

    public List<IFacultad> list() throws RemoteException {
        List<IFacultad> listaIFacultad = new ArrayList<>();

        List<Map<String, Object>> registros = dbManager.listar(TABLE);

        for (Map<String, Object> registro : registros) {
            IFacultad facultad = Facultad.fromMap(registro);

            listaIFacultad.add(facultad);

        }

        return listaIFacultad;
    }

    public IFacultad findOne(int idFacultad) throws RemoteException {
        Map<String, Object> where = new HashMap<>();
        where.put("IdFacultad", idFacultad);
        Map<String, Object> registro = dbManager.buscarUno(TABLE, where);

        return Facultad.fromMap(registro);
    }

    public IFacultad findOne(String nombreFacultad) throws RemoteException {
        Map<String, Object> where = new HashMap<>();
        where.put("NombreFacultad", nombreFacultad);
        Map<String, Object> registro = dbManager.buscarUno(TABLE, where);

        return Facultad.fromMap(registro);
    }

    public List<IFacultad> find(IFacultad facultad) throws RemoteException {
        List<IFacultad> listaIFacultad = new ArrayList<>();

        Map<String, Object> where = Facultad.toMap(facultad);
        List<Map<String, Object>> registros = dbManager.listar(TABLE, where);

        for (Map<String, Object> registro : registros) {
            IFacultad facultadTemp = Facultad.fromMap(registro);

            listaIFacultad.add(facultadTemp);

        }

        return listaIFacultad;
    }

}
