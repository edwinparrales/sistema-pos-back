package epv.tecnologia.sistemapos.servicio;

import epv.tecnologia.sistemapos.entidad.Producto;
import epv.tecnologia.sistemapos.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    public void eliminar(String id){
        proRep.deleteById(id);
    }

    public void acutalizar(Producto producto){
        proRep.actualizar(
                producto.getCodigoBarras(),
                producto.getNombreProducto(),
                producto.getValCompraUnd(),
                producto.getValCompraCaja(),
                producto.getCantidad(),
                producto.getCantMax(),
                producto.getCantMin(),
                producto.getUnidadesCaja(),
                producto.getValVentaUnd(),
                producto.getCategoria(),
                producto.getValVentaCaja(),
                producto.getId()

                );

    }

    public List<Producto> buscarNombre(String nombre){
        Sort ord = Sort.by(Sort.Direction.ASC,"codigoBarras");

       return   proRep.buscarNombre("%"+nombre+"%",ord);

    }



}
