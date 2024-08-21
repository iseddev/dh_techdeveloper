package odontologo.service;

import odontologo.dao.IDao;
import odontologo.dao.implementacion.OdontologoDao2;
import odontologo.dao.implementacion.OdontologoDaoH2;
import odontologo.model.Odontologo;

import java.util.List;

public class OdontologoService {
    private IDao<Odontologo> IDao;
    OdontologoDao2 odonto2 = new OdontologoDao2();
    public OdontologoService() {
        this.IDao = new OdontologoDaoH2();
    }

    public Odontologo guardar(Odontologo odontologo) {

        return IDao.insertarRegistro(odontologo);
    }

    public List<Odontologo> listarTodos() {

        return IDao.listarTodos();
    }

    public Odontologo guardarModo2(Odontologo odontologo) {
        odonto2.insertarRegistro(odontologo);
        return odontologo;
    }

    public List<Odontologo> listarTodos2() {
        return odonto2.listarTodos();
    }
}
