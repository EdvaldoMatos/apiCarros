package com.carros.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.carros.api.exception.ObjectNotFoundException;
import com.carros.domain.dto.CarroDTO_old;

@Service
public class CarroService2 {

	@Autowired
	private CarroRepository rep;

	public List<CarroDTO_old> getCarros() {
		List<CarroDTO_old> list = rep.findAll().stream().map(CarroDTO_old::consumeFromVO).collect(Collectors.toList());
		return list;
	}

    public CarroDTO_old getCarroById(Long id) {
        Optional<Carro> carro = rep.findById(id);
        return carro.map(CarroDTO_old::consumeFromVO).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }
    
    public List<CarroDTO_old> getCarrosByTipo(String tipo) {
        return rep.findByTipo(tipo).stream().map(CarroDTO_old::consumeFromVO).collect(Collectors.toList());
    }

    public CarroDTO_old insert(Carro carro) {
        Assert.isNull(carro.getId(),"Não foi possível inserir o registro");

        return CarroDTO_old.consumeFromVO(rep.save(carro));
    }

    public CarroDTO_old update(Carro carro, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Carro> optional = rep.findById(id);
        if(optional.isPresent()) {
            Carro db = optional.get();
            // Copiar as propriedades
            db.setNome(carro.getNome());
            db.setTipo(carro.getTipo());
            System.out.println("Carro id " + db.getId());

            // Atualiza o carro
            rep.save(db);

            return CarroDTO_old.consumeFromVO(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        rep.deleteById(id);
    }
}
