package epv.tecnologia.sistemapos.repositorio;

import epv.tecnologia.sistemapos.entidad.Categoria;
import epv.tecnologia.sistemapos.entidad.Producto;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;

import java.util.List;

public interface ProductoRepositorio extends JpaRepository<Producto,String> {
    @Modifying
    @Query("""
            update Producto p set p.codigoBarras = :codigoBarras, p.nombreProducto = :nombreProducto, p.valCompraUnd = :valCompraUnd, p.valCompraCaja = :valCompraCaja, p.cantidad = :cantidad, p.cantMax = :cantMax, p.cantMin = :cantMin, p.unidadesCaja = :unidadesCaja, p.valVentaUnd = :valVentaUnd, p.categoria = :categoria, p.valVentaCaja = :valVentaCaja
            where upper(p.id) like upper(:id)""")
    void actualizar(@Param("codigoBarras") String codigoBarras, @Param("nombreProducto") String nombreProducto, @Param("valCompraUnd") double valCompraUnd, @Param("valCompraCaja") double valCompraCaja, @Param("cantidad") Integer cantidad, @Param("cantMax") Integer cantMax, @Param("cantMin") Integer cantMin, @Param("unidadesCaja") Integer unidadesCaja, @Param("valVentaUnd") double valVentaUnd, @Param("categoria") Categoria categoria, @Param("valVentaCaja") double valVentaCaja, @NonNull @Param("id") String id);

    @Query("select p from Producto p where upper(p.nombreProducto) like upper(:nombreProducto) order by p.codigoBarras")
    List<Producto> buscarNombre(@Param("nombreProducto") @NonNull String nombreProducto, Sort sort);

}
