package Servidor;

import Interfaces.ICarrera;
import Interfaces.ICarreraController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarreraController extends UnicastRemoteObject implements ICarreraController {

    private DBManager dbManager;
    private final String TABLE = "CARRERA";

    public CarreraController() throws RemoteException {
        dbManager = new DBManager();
    }

    public ICarrera newInstance() throws RemoteException {
        return new Carrera();
    }

    public int add(ICarrera carrera) throws RemoteException {
        ICarrera carreraEncontrada = findOne(carrera.getCodCarrera());
        boolean existe = carreraEncontrada.getCodCarrera() != 0;

        if (existe) {
            return ADD_ID_DUPLICADO;
        }

        Map<String, Object> datos = Carrera.toMap(carrera);

        int respuesta = dbManager.insertar(TABLE, datos);

        return (respuesta > 0) ? ADD_EXITO : ADD_SIN_EXITO;
    }

    @Override
    public int update(ICarrera carrera) throws RemoteException {
        if (carrera.getCodCarrera() == 0) {
            return UPDATE_ID_NULO;
        }

        ICarrera carreraEncontrada = findOne(carrera.getCodCarrera());
        if (carreraEncontrada.getCodCarrera() == 0) {
            return UPDATE_ID_INEXISTE;
        }

        Map<String, Object> datos = Carrera.toMap(carrera);
        Map<String, Object> where = new HashMap<>();
        where.put("CodCarrera", carrera.getCodCarrera());
        int respuesta = dbManager.actualizar(TABLE, datos, where);

        return (respuesta > 0) ? UPDATE_EXITO : UPDATE_SIN_EXITO;

    }

    @Override
    public int delete(ICarrera carrera) throws RemoteException {
        ICarrera carreraTemp = findOne(carrera.getCodCarrera());
        if (carreraTemp.getCodCarrera() == 0) {
            return DELETE_ID_INEXISTENTE;
        }

        Map<String, Object> where = new HashMap<>();
        where.put("CodCarrera", carrera.getCodCarrera());

        int respuesta = dbManager.eliminar(TABLE, where);

        if (respuesta == 0) {
            return DELETE_SIN_EXITO;
        } else {
            return DELETE_EXITO;
        }
    }

    @Override
    public int delete(int CodCarrera) throws RemoteException {
        ICarrera carrera = new Carrera();
        carrera.setCodCarrera(CodCarrera);
        return delete(carrera);
    }

    @Override
    public List<ICarrera> list() throws RemoteException {
        List<ICarrera> listaICarrera = new ArrayList<>();

        List<Map<String, Object>> registros = dbManager.listar(TABLE);

        for (Map<String, Object> registro : registros) {
            ICarrera carrera = Carrera.fromMap(registro);
            listaICarrera.add(carrera);

        }

        return listaICarrera;

    }

    @Override
    public ICarrera findOne(int codCarrera) throws RemoteException {

        Map<String, Object> where = new HashMap<>();
        where.put("CodCarrera", codCarrera);
        Map<String, Object> registro = dbManager.buscarUno(TABLE, where);

        return Carrera.fromMap(registro);
    }

    @Override
    public List<ICarrera> find(ICarrera carrera) throws RemoteException {
        List<ICarrera> listaICarrera = new ArrayList<>();

        Map<String, Object> where = Carrera.toMap(carrera);
        List<Map<String, Object>> registros = dbManager.listar(TABLE, where);

        for (Map<String, Object> registro : registros) {
            ICarrera carreraTemp = Carrera.fromMap(registro);
            listaICarrera.add(carreraTemp);

        }

        return listaICarrera;

    }

    @Override
    public ICarrera findOne(String nombreCarrera) throws RemoteException {
        Map<String, Object> where = new HashMap<>();
        where.put("carrera", nombreCarrera);
        Map<String, Object> registro = dbManager.buscarUno(TABLE, where);

        return Carrera.fromMap(registro);
    }
}
