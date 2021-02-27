package com.carros.domain.dto;

import com.carros.domain.Fabricante;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class FabricanteDTO  {

	private Integer codigo;
	private String nome;


	/*
	 * public static void consumeFromVO(Fabricante parsable) {
	 * FabricanteDTO.builder() .codigo(parsable.getCodigo())
	 * .nome(parsable.getNome()) .build();
	 * 
	 * }
	 */
	
	public FabricanteDTO(Fabricante fab) {
		this.codigo = fab.getCodigo();
		this.nome = fab.getNome();
	}
	
}
