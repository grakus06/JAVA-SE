package com.m2i.poec.sept15.javse.keywordstatic;

public class MaClasse {
	
	public static String maVariableStatic = "je suis une variable statique";
	
	private String maVariableNonStatic = "je ne suis pas statique";

	public String getMaVariableNonStatic() {
		return maVariableNonStatic;
	}
	
	public void uneMethodeNonStatic() {
		System.out.println("je ne suis pas statique non plus");
	}
	
	public static void uneMethodeStatic() {
		System.out.println("je suis statique");
	}
	
	public static void changeLaVariableStatique() {
		maVariableStatic = "j'ai changé depuis la méthode statique";
	}
	

	
}
