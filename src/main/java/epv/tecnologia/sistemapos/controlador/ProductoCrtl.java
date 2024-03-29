package epv.tecnologia.sistemapos.controlador;

import epv.tecnologia.sistemapos.entidad.Imagen;
import epv.tecnologia.sistemapos.entidad.Producto;
import epv.tecnologia.sistemapos.servicio.ImagenSrv;
import epv.tecnologia.sistemapos.servicio.ProductoSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/producto/")
public class ProductoCrtl {
    @Autowired
    ProductoSrv productoSrv;
    @Autowired
    ImagenSrv imgSrv;

    @GetMapping("listar")
    public ResponseEntity<List<Producto>> listar(){

        return new ResponseEntity<>(productoSrv.listar(), HttpStatus.OK);

    }

    @PostMapping("guardar")
    public ResponseEntity<Producto> guardar(@RequestBody Producto producto){

        List<Imagen> imagenes = producto.getUrlsImagen();
        Producto productoNuevo = productoSrv.guardar(producto);
        imagenes.stream().forEach(imagen -> imagen.setProducto(productoNuevo));
        imagenes.addAll(imagenes);
        imgSrv.guardar(imagenes);


        return new ResponseEntity<Producto>(productoNuevo,HttpStatus.CREATED);
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity eliminar(@PathVariable(name = "id") String id){
        productoSrv.eliminar(id);
        return  ResponseEntity.ok("Producto Eliminado");
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity actualizar(@PathVariable(name = "id") String id,@RequestBody Producto producto){

        return  ResponseEntity.ok("Producto acutalizado");
    }

    @GetMapping("buscar/{nombre}")
    public ResponseEntity<List<Producto>> buscarNombre(@PathVariable("nombre")String nombre){
        return new ResponseEntity<>(productoSrv.buscarNombre(nombre),HttpStatus.ACCEPTED);
    }


}
