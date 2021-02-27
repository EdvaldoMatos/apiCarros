package com.carros.domain.dto;

import com.carros.domain.Carro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Data
@Getter
@Setter
public class CarroDTO implements Parsable<Carro> {
	private Long id;
    private String nome;
    private String tipo;
    private String descricao;
    private String urlFoto;
    private String urlVideo;
    private String latitude;
    private String longitude;
	private FabricanteDTO fabricante;
	
	
	public CarroDTO(Carro ent) {
		this.id = ent.getId();
		this.nome = ent.getNome();
		this.tipo = ent.getTipo();
		this.descricao = ent.getDescricao();
		this.urlFoto = ent.getUrlFoto();
		this.urlVideo = ent.getUrlVideo();
		this.latitude = ent.getLatitude();
		this.longitude = ent.getLongitude();
		if (ent.getFabricante() != null ) {
			this.setFabricante(new FabricanteDTO(ent.getFabricante()));			
		}
		
	}
	
	@Override
	public Carro convert() {		
		return new Carro(this);
	}
}
