
package com.carros;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;
import org.modelmapper.ModelMapper;

import com.carros.estudo.Address;
import com.carros.estudo.Customer;
import com.carros.estudo.Name;
import com.carros.estudo.Order;
import com.carros.estudo.OrderDTO;

public class OrderTest {
	
	@Test
	public void TestDataMapper() {
		
		Order order = new Order();
		Address add = new Address();
		Name name = new Name();
		Name name2 = new Name();
		Customer customer = new Customer();
		
		add.setCity("Osasco");
		add.setStreet("Joaquim lapas Veigas");
		name.setFirstName("Edvaldo");
		name.setLastName("Matos");
		name2.setFirstName("Edvaldo");
		name2.setLastName("Matos");
		customer.getNames().add(name);
		customer.getNames().add(name2);
		order.setBillingAddress(add);
		order.setCustomer(customer);
		
		ModelMapper modelMapper = new ModelMapper();
		OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);
		
		assertEquals(order.getBillingAddress().getStreet(), orderDTO.getBillingStreet());
		assertEquals(order.getBillingAddress().getCity(), orderDTO.getBillingCity());
		assertEquals(2, orderDTO.getCustomerNames().size());
		assertEquals(order.getCustomer().getNames().get(0).getFirstName(), orderDTO.getCustomerNames().get(0).getFirstName());
		assertEquals(order.getCustomer().getNames().get(0).getLastName(), orderDTO.getCustomerNames().get(0).getLastName());
		
	}

}
