package jsges.nails.domain.articulos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jsges.nails.domain.organizacion.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ArticuloVenta {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  String denominacion;

  int estado;

  String observacion;

  @ManyToOne(cascade = CascadeType.ALL)
  private Linea linea;

  @ManyToOne
  private Cliente cliente;

  public void asEliminado() {
    this.setEstado(1);
  }
}
