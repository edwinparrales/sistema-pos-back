package epv.tecnologia.sistemapos.servicio;

import epv.tecnologia.sistemapos.entidad.Producto;
import epv.tecnologia.sistemapos.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoSrv {
    @Autowired
    private ProductoRepositorio proRep;

    public List<Producto> listar(){


        return proRep.findAll();
    }

    public Producto guardar(Producto producto){


        return proRep.save(producto);
    }



}
