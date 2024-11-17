package com.banckend1.ReservaTurnos.service.impl;

import com.dh.C20S_InyeccionDependencias.dao.IDAO;
import com.dh.C20S_InyeccionDependencias.dao.implementation.ImplTurnoList;
import com.dh.C20S_InyeccionDependencias.model.Turno;
import com.dh.C20S_InyeccionDependencias.service.ITurnoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplTurnoService implements ITurnoService {

    private IDAO<Turno> iDao;

    public ImplTurnoService() {
        this.iDao = new ImplTurnoList();
    }

    @Override
    public Turno guardar(Turno turno) {
        return iDao.insert(turno);
    }

    @Override
    public Turno buscarPorId(Integer id) {
        return iDao.selectById(id);
    }

    @Override
    public List<Turno> listarTodos() {
        return iDao.selectAll();
    }
}
