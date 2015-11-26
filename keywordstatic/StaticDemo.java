package com.m2i.poec.sept15.javse.keywordstatic;

public class StaticDemo {

	public static void main(String[] args) {
		MaClasse monObjet = new MaClasse();
		monObjet.getMaVariableNonStatic();
		monObjet.uneMethodeNonStatic();
		
		MaClasse.uneMethodeStatic();
		
		String s = MaClasse.maVariableStatic;
		System.out.println("s " + s);

		String s2 = MaClasse.maVariableStatic;
		System.out.println("s2 " + s2);

		//MaClasse.maVariableStatic = "j'ai changé";
/*		MaClasse.changeLaVariableStatique();
		System.out.println(MaClasse.maVariableStatic);
		System.out.println("s " + s);
		System.out.println("s2 " + s2);*/

	}

}
