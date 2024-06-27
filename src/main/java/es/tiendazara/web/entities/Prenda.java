package es.tiendazara.web.entities;

import es.tiendazara.web.common.GeneroPrenda;
import es.tiendazara.web.common.TipoPrenda;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prenda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String talla;
	private String color;

	@Enumerated(EnumType.ORDINAL)
	private GeneroPrenda genero;

	@Enumerated(EnumType.ORDINAL)
	private TipoPrenda tipo;

}
