package epv.tecnologia.sistemapos.servicio;

import epv.tecnologia.sistemapos.entidad.Categoria;
import epv.tecnologia.sistemapos.repositorio.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaSrv implements ServicioGenerico<Categoria,String>{
    @Autowired
    private CategoriaRepositorio catRep;

    public Categoria guardar(Categoria categoria){

        return catRep.save(categoria);
    }

    @Override
    public List<Categoria> listar() {

        return catRep.findAll();
    }

    @Override
    public List<Categoria> listar(String id) {

        return catRep.findByIdLikeIgnoreCase(id);
    }

    @Override
    public void eliminar(String id) {

        catRep.deleteById(id);

    }

    @Override
    public void actualizar(Categoria categoria) {


        catRep.updateNombreByIdLikeIgnoreCaseAllIgnoreCase(categoria.getNombre(), categoria.getId());
    }

}
