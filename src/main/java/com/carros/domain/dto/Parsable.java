package com.carros.domain.dto;

public interface Parsable<T> {

	/**
	 * 
	 * @param parsable
	 * @return
	 */
	T convert();


}