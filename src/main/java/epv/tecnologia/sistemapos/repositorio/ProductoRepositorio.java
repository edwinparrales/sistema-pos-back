package epv.tecnologia.sistemapos.repositorio;

import epv.tecnologia.sistemapos.entidad.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto,String> {
}
