package com.carros.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.carros.api.exception.ObjectNotFoundException;
import com.carros.domain.dto.CarroDTO;

@Service
public class CarroService {

	@Autowired
	private CarroRepository rep;

	public List<CarroDTO> getCarros() {
		List<CarroDTO> list = rep.findAll().stream().map(CarroDTO::consumeFromVO).collect(Collectors.toList());
		return list;
	}

	public CarroDTO getCarroById(Long id) {
		Optional<Carro> carro = rep.findById(id);
		return carro.map(CarroDTO::consumeFromVO)
				.orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
	}

	public CarroDTO getCarroTipoNome(String tipo, String nome) {
		Optional<Carro> carro = rep.findByTipoAndNome(tipo, nome);
		return carro.map(CarroDTO::consumeFromVO)
				.orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
	}

	public List<CarroDTO> getCarrosByTipo(String tipo) {
		return rep.findByTipo(tipo).stream().map(CarroDTO::consumeFromVO).collect(Collectors.toList());
	}

	public CarroDTO insert(Carro carro) {
		Assert.isNull(carro.getId(), "Não foi possível inserir o registro");

		return CarroDTO.consumeFromVO(rep.save(carro));
	}

	public CarroDTO update(Carro carro, Long id) {
		Assert.notNull(id, "Não foi possível atualizar o registro");

		// Busca o carro no banco de dados
		Optional<Carro> optional = rep.findById(id);

		if (optional.isPresent()) {

			Carro db = optional.get();

			// Copiar as propriedades
			db.setNome(carro.getNome());
			db.setTipo(carro.getTipo());

			System.out.println("Carro id " + db.getId());

			// Atualiza o carro
			rep.save(db);

			return CarroDTO.consumeFromVO(db);
		} else {
			throw new ObjectNotFoundException("Não foi possível atualizar o registro");
			// throw new RuntimeException("Não foi possível atualizar o registro");
		}
	}

	public void delete(Long id) {
		rep.deleteById(id);
	}
}
