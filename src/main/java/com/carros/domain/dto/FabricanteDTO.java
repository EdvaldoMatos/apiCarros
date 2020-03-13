package com.carros.domain.dto;

import com.carros.domain.Fabricante;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FabricanteDTO  {

	private Integer codigo;
	
	private String nome;


	public static void consumeFromVO(Fabricante parsable) {
		FabricanteDTO.builder()
		.codigo(parsable.getCodigo())
		.nome(parsable.getNome())
		.build();
		
	}
}
