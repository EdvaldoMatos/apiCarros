package com.carros.estudo;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data	
public class OrderDTO {
	/*
	 * String customerFirstName; String customerLastName;
	 */
	List<NameDTO> customerNames = new ArrayList<NameDTO>();
	String billingStreet;
	String billingCity;
}
