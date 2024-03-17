package epv.tecnologia.sistemapos.entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "IMAGENES")
public class Imagen {
     @Id
     @GeneratedValue(strategy =  GenerationType.UUID)
     private String id;
     private String url;
     @ManyToOne
     @JoinColumn(name = "id_producto")
     @JsonIgnore
     private Producto producto;

}
