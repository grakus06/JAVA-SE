package com.m2i.poec.sept15.javse.exception;

public class BoardColumnIndexOutOfRangeException extends RuntimeException {

	public BoardColumnIndexOutOfRangeException(int column) {
		super("Column out of range " + column);
	}

	
	
}
