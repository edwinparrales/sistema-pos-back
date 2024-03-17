package epv.tecnologia.sistemapos.controlador;

import epv.tecnologia.sistemapos.entidad.Producto;
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

    @GetMapping("listar")
    public ResponseEntity<List<Producto>> listar(){

        return new ResponseEntity<>(productoSrv.listar(), HttpStatus.OK);

    }

    @PostMapping("guardar")
    public ResponseEntity<Producto> guardar(@RequestBody Producto producto){
        return new ResponseEntity<Producto>(productoSrv.guardar(producto),HttpStatus.CREATED);
    }


}
