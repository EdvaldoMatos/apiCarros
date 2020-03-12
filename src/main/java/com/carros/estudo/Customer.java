package com.carros.estudo;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Customer {
	List<Name> names = new ArrayList<Name>();
}
