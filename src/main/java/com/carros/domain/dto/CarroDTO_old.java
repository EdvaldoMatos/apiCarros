package com.carros.domain.dto;

import com.carros.domain.Carro;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarroDTO_old {
	private Long id;
	private String nome;
	private String tipo;
	private FabricanteDTO fabricante;

	/*
	 * public CarroDTO(Carro carro) { this.id = carro.getId(); this.nome =
	 * carro.getNome(); this.tipo = carro.getTipo(); }
	 */

	/*
	 * public static CarroDTO create(Carro carro) { ModelMapper modelMapper = new
	 * ModelMapper(); return modelMapper.map(carro, CarroDTO.class); }
	 */

	
	public static  CarroDTO_old consumeFromVO(Carro parsable) {
		return CarroDTO_old.builder()
		.id(parsable.getId())
		.nome(parsable.getNome())
		.tipo(parsable.getTipo())
		.fabricante(parsable.getFabricante() !=null ?
				FabricanteDTO
				.builder()
				.codigo(parsable.getFabricante().getCodigo())
				.nome(parsable.getFabricante().getNome())
				.build()
				: null
				)		
		.build();

	}


	

}
