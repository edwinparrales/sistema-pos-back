package epv.tecnologia.sistemapos.repositorio;

import epv.tecnologia.sistemapos.entidad.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagenRepositorio extends JpaRepository<Imagen,String> {
}
