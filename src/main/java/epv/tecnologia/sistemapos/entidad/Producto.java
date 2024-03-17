package epv.tecnologia.sistemapos.entidad;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "PRODUCTOS")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
     private String id;
     private String codigoBarras;
     private String nombreProducto;
     private double valCompraUnd;
     private double valCompraCaja;
     private Integer cantidad;
     private Integer cantMax;
     private Integer cantMin;
     private Integer unidadesCaja;
     private double  valVentaUnd;
     private double  valVentaCaja;
     @ManyToOne()
     @JoinColumn(name = "id_categoria")
     private Categoria categoria;
     @OneToMany(mappedBy = "producto")
     private List<Imagen> urlsImagen;

}
