package it.prova.pizzastore.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import it.prova.pizzastore.model.Ordine;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrdineDTO {

	private Long id;

	@NotNull(message = "{data.notnull}")
	private LocalDate data;

	@NotBlank(message = "{codice.notblank}")
	private String codice;

	@NotNull(message = "{costototale.notnull}")
	private Integer costoTotale;

	private Boolean closed;

	public OrdineDTO() {
		super();
	}

	public OrdineDTO(Long id, LocalDate data, String codice, Integer costoTotale, Boolean closed) {
		super();
		this.id = id;
		this.data = data;
		this.codice = codice;
		this.costoTotale = costoTotale;
		this.closed = closed;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public Integer getCostoTotale() {
		return costoTotale;
	}

	public void setCostoTotale(Integer costoTotale) {
		this.costoTotale = costoTotale;
	}

	public Boolean getClosed() {
		return closed;
	}

	public void setClosed(Boolean closed) {
		this.closed = closed;
	}

	public Ordine buildOrdineModel() {
		return new Ordine(this.id, this.data, this.codice, this.costoTotale, this.closed);
	}

	public static OrdineDTO buildOrdineDTOFromModel(Ordine ordineModel) {
		return new OrdineDTO(ordineModel.getId(), ordineModel.getData(), ordineModel.getCodice(),
				ordineModel.getCostoTotale(), ordineModel.getClosed());
	}

	public static List<OrdineDTO> createOrdineDTOListFromModelList(List<Ordine> modelListInput) {
		return modelListInput.stream().map(ordineEntity -> {
			OrdineDTO result = OrdineDTO.buildOrdineDTOFromModel(ordineEntity);
			return result;
		}).collect(Collectors.toList());
	}

}
