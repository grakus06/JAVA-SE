package com.m2i.poec.sept15.javse.exception;

public class BoardColumnFullException extends RuntimeException {

	public BoardColumnFullException(int column) {
		super("La colonne est pleine " + column);
	}

	
	
}
