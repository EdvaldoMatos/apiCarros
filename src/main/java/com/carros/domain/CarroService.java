package com.carros.domain;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.carros.api.exception.ObjectNotFoundException;
import com.carros.domain.dto.CarroDTO;

@Service
public class CarroService implements GenericService<Carro, Long, CarroDTO> {

	@Autowired
	private CarroRepository repository;

	@Override
	public JpaRepository<Carro, Long> getRepository() {
		return repository;
	}

	public List<CarroDTO> getCarrosByTipo(String tipo) {
		List<Carro> list = repository.findByTipo(tipo);
		if (list.isEmpty())
			throw new ObjectNotFoundException("Nenhum registro encontrado");
		return list.stream().map(carr -> carr.convert()).collect(Collectors.toList());

	}

}
