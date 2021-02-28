package com.carros.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.carros.domain.dto.CarroDTO;
import com.carros.domain.dto.Parsable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Carro implements Parsable<CarroDTO> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String tipo;
    private String descricao;
    private String urlFoto;
    private String urlVideo;
    private String latitude;
    private String longitude;

    @ManyToOne
    private Fabricante fabricante;


	public Carro(CarroDTO dto) {
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.tipo = dto.getTipo();
		this.descricao = dto.getDescricao();
		this.urlFoto = dto.getUrlFoto();
		this.urlVideo = dto.getUrlVideo();
		this.latitude = dto.getLatitude();
		this.longitude = dto.getLongitude();
		if (dto.getFabricante() != null ) {
			this.setFabricante(new Fabricante(dto.getFabricante()));			
		}
		
	}


	@Override
	public CarroDTO convert() {
		return new CarroDTO(this);
	}
}
