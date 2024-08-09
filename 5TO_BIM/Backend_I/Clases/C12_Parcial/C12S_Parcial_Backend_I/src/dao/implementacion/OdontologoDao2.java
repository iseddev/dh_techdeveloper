package dao.implementacion;

import dao.IDao;
import model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDao2 implements IDao<Odontologo> {
    private static final Logger LOGGER = Logger.getLogger(OdontologoDao2.class);
    List<Odontologo> listaOdontologos;

    public OdontologoDao2() {
        this.listaOdontologos = new ArrayList<>();
    }

    private Integer contador = 1;
    @Override
    public Odontologo insertarRegistro(Odontologo odontologo) {
        try {
            odontologo.setId(contador);
            this.listaOdontologos.add(odontologo);
            LOGGER.info("Se agregó el odontologo al listado");
        }catch (Exception e){
            LOGGER.error("No se pudo agregar al odontologo");
        }
        contador++;
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        try {

            LOGGER.info("Se muestra la lista de odontologos");
            for(Odontologo odonto:listaOdontologos){
                System.out.println(odonto.toString());
            }
        }catch (Exception e){
            LOGGER.error("No se pudo mostrar la lista");
        }
        return this.listaOdontologos;
    }
}
