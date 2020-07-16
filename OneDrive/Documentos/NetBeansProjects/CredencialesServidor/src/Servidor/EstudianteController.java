package Servidor;

import Interfaces.IEstudiante;
import Interfaces.IEstudianteController;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EstudianteController extends UnicastRemoteObject implements IEstudianteController {

    private DBManager dbManager;
    private final String TABLE = "ESTUDIANTE";

    public EstudianteController() throws RemoteException {
        dbManager = new DBManager();
    }

    public IEstudiante newInstance() throws RemoteException {
        return new Estudiante();
    }

    public int add(IEstudiante estudiante) throws RemoteException {
        IEstudiante estudianteEncontrado = findOne(estudiante.getMatricula());
        boolean existe = estudianteEncontrado.getMatricula() != null;

        if (existe) {
            return ADD_ESTUDIANTE_DUPLICADO;
        }
        Map<String, Object> datos = Estudiante.toMap(estudiante);
        int respuesta = dbManager.insertar(TABLE, datos);
        return (respuesta > 0) ? ADD_EXITO : ADD_SIN_EXITO;
    }

    public int update(IEstudiante estudiante) throws RemoteException {
        if (estudiante.getMatricula() == null) {
            return UPDATE_ESTUDIANTE_NULO;
        }

        IEstudiante estudianteEncontrado = findOne(estudiante.getMatricula());
        if (estudianteEncontrado.getMatricula() == null) {
            return UPDATE_ESTUDIANTE_INEXISTE;
        }

        Map<String, Object> datos = Estudiante.toMap(estudiante);
        Map<String, Object> where = new HashMap<>();
        where.put("Matricula", estudiante.getMatricula());
        int respuesta = dbManager.actualizar(TABLE, datos, where);
        if (respuesta > 0) {
            return UPDATE_EXITO;
        } else {
            return UPDATE_SIN_EXITO;
        }
    }

    public int delete(IEstudiante estudiante) throws RemoteException {
        IEstudiante estudianteTemp = findOne(estudiante.getMatricula());
        if (estudianteTemp.getMatricula() == null) {
            return DELETE_ESTUDIANTE_INEXISTENTE;
        }

        Map<String, Object> where = new HashMap<>();
        where.put("Matricula", estudiante.getMatricula());
        int respuesta = dbManager.eliminar(TABLE, where);

        if (respuesta == 0) {
            return DELETE_SIN_EXITO; //Return No fue posible eliminar...
        } else {
            return DELETE_EXITO;
        }
    }

    public int delete(String matricula) throws RemoteException {
        IEstudiante estudianteTemp = findOne(matricula);
        if (estudianteTemp.getMatricula() == null) {
            return DELETE_ESTUDIANTE_INEXISTENTE;
        }

        Map<String, Object> where = new HashMap<>();
        where.put("Matricula", matricula);
        int respuesta = dbManager.eliminar(TABLE, where);

        if (respuesta == 0) {
            return DELETE_SIN_EXITO; //Return No fue posible eliminar...
        } else {
            return DELETE_EXITO;
        }
    }

    public List<IEstudiante> list() throws RemoteException {
        List<IEstudiante> listaIEstudiante = new ArrayList<>();

        List<Map<String, Object>> registros = dbManager.listar(TABLE);

        for (Map<String, Object> registro : registros) {
            IEstudiante estudiante = Estudiante.fromMap(registro);

            listaIEstudiante.add(estudiante);
        }//FIN FOR

        return listaIEstudiante;
    }

    public IEstudiante findOne(String matricula) throws RemoteException {
        Map<String, Object> where = new HashMap<>();
        where.put("Matricula", matricula);
        Map<String, Object> registro = dbManager.buscarUno(TABLE, where);

        return Estudiante.fromMap(registro);
    }

    public List<IEstudiante> find(IEstudiante estudiante) throws RemoteException {
        List<IEstudiante> listaIEstudiante = new ArrayList<>();

        Map<String, Object> where = Estudiante.toMap(estudiante);
        List< Map<String, Object>> registros = dbManager.listar(TABLE, where);

        for (Map<String, Object> registro : registros) {
            IEstudiante estudianteTemp = Estudiante.fromMap(registro);

            listaIEstudiante.add(estudianteTemp);
        }//FIN FOR

        return listaIEstudiante;
    }

}
