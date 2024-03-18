package epv.tecnologia.sistemapos.servicio;

import epv.tecnologia.sistemapos.entidad.Imagen;
import epv.tecnologia.sistemapos.repositorio.ImagenRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImagenSrv implements ServicioGenerico<Imagen,String>{
    @Autowired
    private ImagenRepositorio imgRep;
    @Override
    public Imagen guardar(Imagen imagen) {

        return imgRep.save(imagen);
    }

    @Override
    public List<Imagen> listar() {

        return imgRep.findAll();
    }

    @Override
    public List<Imagen> listar(String parametro) {

        return (List<Imagen>) imgRep.findById(parametro).get();
    }

    @Override
    public void eliminar(String id) {
       imgRep.deleteById(id);
    }

    @Override
    public void actualizar(Imagen imagen) {
        imgRep.actualizar(imagen.getUrl(),imagen.getProducto(), imagen.getId());
    }


}
