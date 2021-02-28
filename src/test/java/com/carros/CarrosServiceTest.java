package com.carros;


import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.fail;

import java.util.List;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarrosServiceTest {

	/*
	 * @Autowired private CarroService service;
	 * 
	 * @Test public void testSave() {
	 * 
	 * Carro carro = new Carro(); carro.setNome("Porshe");
	 * carro.setTipo("esportivos");
	 * 
	 * Fabricante fabri = new Fabricante(); fabri.setCodigo(1);
	 * 
	 * carro.setFabricante(fabri);
	 * 
	 * Fabricante fab = new Fabricante(); fab.setCodigo(2);
	 * 
	 * carro.setFabricante(fab);
	 * 
	 * CarroDTO_old c = service.insert(carro);
	 * 
	 * assertNotNull(c);
	 * 
	 * Long id = c.getId(); assertNotNull(id);
	 * 
	 * // Buscar o objeto c = service.getCarroById(id); assertNotNull(c);
	 * 
	 * assertEquals("Porshe",c.getNome()); assertEquals("esportivos",c.getTipo());
	 * 
	 * // Deletar o objeto service.delete(id);
	 * 
	 * // Verificar se deletou try { service.getCarroById(id);
	 * fail("O carro não foi excluído"); } catch (ObjectNotFoundException e) { // OK
	 * } }
	 * 
	 * @Test public void testLista() {
	 * 
	 * List<CarroDTO_old> carros = service.getCarros();
	 * 
	 * assertEquals(30, carros.size()); }
	 * 
	 * @Test public void testListaPorTipo() {
	 * 
	 * assertEquals(10, service.getCarrosByTipo("classicos").size());
	 * assertEquals(10, service.getCarrosByTipo("esportivos").size());
	 * assertEquals(10, service.getCarrosByTipo("luxo").size());
	 * 
	 * assertEquals(0, service.getCarrosByTipo("x").size()); }
	 * 
	 * @Test public void testGet() {
	 * 
	 * CarroDTO_old c = service.getCarroById(11L);
	 * 
	 * assertNotNull(c);
	 * 
	 * 
	 * assertEquals("Ferrari FF", c.getNome()); }
	 */

}
