package com.carros.domain.dto;

public interface Parsable<T> {

	/**
	 * @return O objeto convertido para VO
	 */
	T convertToVO();

	/**
	 * Consome o objeto do VO
	 * 
	 * @param parsable
	 */
	void consumeFromVO(T parsable);

}