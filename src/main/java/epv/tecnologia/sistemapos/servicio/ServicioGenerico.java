package epv.tecnologia.sistemapos.servicio;

import java.util.List;

public interface ServicioGenerico<Object,String> {

    public Object guardar(Object object);
    public List<Object> listar();
    public List<Object> listar(String parametro);


    public void eliminar(String id);
    public void actualizar(Object object);
}
