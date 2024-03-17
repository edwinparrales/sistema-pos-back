package epv.tecnologia.sistemapos.repositorio;

import epv.tecnologia.sistemapos.entidad.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CategoriaRepositorio extends JpaRepository<Categoria,String> {

    List<Categoria> findByIdLikeIgnoreCase(@NonNull String id);

    @Modifying
    @Query("update Categoria c set c.nombre = :nombre where upper(c.id) like upper(:id)")
    void updateNombreByIdLikeIgnoreCaseAllIgnoreCase(@NonNull @Param("nombre") String nombre, @NonNull @Param("id") String id);

}
