package jsges.nails.domain.articulos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import jsges.nails.dto.articulos.LineaDTO;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Linea {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false, unique = true)
  private String denominacion;

  private int estado;

  @Column
  private String observacion;

  @OneToMany(mappedBy = "linea")
  private List<ArticuloVenta> articulosVenta;

  public Linea() {}

  public Linea(String nombre) {
    this.setDenominacion(nombre);
  }

  public Linea(LineaDTO dto) {
    this.setDenominacion(dto.getDenominacion());
  }

  public void asEliminado() {
    this.setEstado(1);
  }
}
