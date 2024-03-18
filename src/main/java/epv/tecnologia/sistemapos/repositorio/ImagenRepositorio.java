package epv.tecnologia.sistemapos.repositorio;

import epv.tecnologia.sistemapos.entidad.Imagen;
import epv.tecnologia.sistemapos.entidad.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;

public interface ImagenRepositorio extends JpaRepository<Imagen,String> {
    @Modifying
    @Query("update Imagen i set i.url = :url, i.producto = :producto where upper(i.id) like upper(:id)")
    void actualizar(@NonNull @Param("url") String url,@Param("producto") Producto producto, @NonNull @Param("id") String id);
}
