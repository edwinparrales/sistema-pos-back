package epv.tecnologia.sistemapos.controlador;

import epv.tecnologia.sistemapos.entidad.Categoria;
import epv.tecnologia.sistemapos.servicio.CategoriaSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categoria/")
public class CategoriaCtrl {
    @Autowired
    CategoriaSrv catSrv;

    @PostMapping("guardar")
    public ResponseEntity<Categoria> guardar(@RequestBody Categoria categoria){
        return  new ResponseEntity<>(catSrv.guardar(categoria), HttpStatus.CREATED)  ;
    }
    @GetMapping("listar")
    public ResponseEntity<List<Categoria>> listar(){
        return new ResponseEntity<>(catSrv.listar(),HttpStatus.OK);
    }
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity eliminar(@PathVariable(name = "id")String id){

        catSrv.eliminar(id);
        return  ResponseEntity.ok("Categoria eliminada");
    }


}
