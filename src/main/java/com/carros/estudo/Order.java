package com.carros.estudo;

import lombok.Data;

@Data
public class Order {
	  Customer customer;
	  Address billingAddress;
}
