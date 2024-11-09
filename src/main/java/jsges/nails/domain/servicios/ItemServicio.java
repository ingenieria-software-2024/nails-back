package jsges.nails.domain.servicios;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@ToString
public class ItemServicio {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  int estado;

  @Column(columnDefinition = "TEXT")
  String observacion;

  @ManyToOne(cascade = CascadeType.ALL)
  private TipoServicio tipoServicio;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn
  private Servicio servicio;

  private Double precio;

  public void asEliminado() {
    this.setEstado(1);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ItemServicio that = (ItemServicio) o;
    return (
      estado == that.estado &&
      Objects.equals(id, that.id) &&
      Objects.equals(observacion, that.observacion) &&
      Objects.equals(tipoServicio, that.tipoServicio) &&
      Objects.equals(servicio, that.servicio)
    );
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, estado, observacion, tipoServicio, servicio);
  }

  public ItemServicio() {}

  public ItemServicio(
    Servicio servicio,
    TipoServicio tipo,
    Double precio,
    String observacion
  ) {
    this.servicio = servicio;
    this.tipoServicio = tipo;
    this.precio = precio;
    this.observacion = observacion;
  }
}
