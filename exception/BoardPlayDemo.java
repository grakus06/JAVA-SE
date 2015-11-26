package com.m2i.poec.sept15.javse.exception;

public class BoardPlayDemo {

	public static void main(String[] args) {

		
		/**
		 * 1) Demander au joueur de jouer dans une colonne valide.
		 * Une colonne est valide si:
		 * <ul>
		 * <li>elle est dans les bornes acceptables du board, cad entre 0 et 6
		 * <li> elle est n'est pas pleine</li>
		 * </ul>
		 * On redemande au joueur de choisir une colonne 
		 * tant qu'il n'a pas choisi une colonne valide.
		 * 2) Placer le jeton dans la colonne jouée par le joueur.
		 */
		
		// CQRS 
		// <STRATEGY HUMAIN> 
		do {
			System.out.println("Choisir une colonne non pleine entre 1 et 7");
			int i = consoleView.readColumnNumber();
		} while (
				! board.isBetweenBoardAcceptableColumnRange(i); 
			|| 	board.isColumnFull(i);
		);
		
		// autre solution => int i = consoleView.readValidColumnNumber();
		board.placeInBoard(i);
		
		
		// </STRATEGY HUMAIN>
		
		// <CONSOLE VIEW>

		/**
		 * Obtient un numéro de colonne auprès de l'utilisateur.
		 * Cette méthode est bloquante et boucle 
		 * tant que l'utilisateur n'a pas saisi une valeur entière.
		 * @return int le numéro de colonne choisi par l'utilisateur.
		 */
		public int readColumnNumber() {
			while(true) {
				String line = scanner.nextLine();
				try {
					return Integer.parseInt(line);
				} catch(NumberFormatException ex) {
					System.out.println("Veuillez saisir une valeur entière");
				}
			}
		}
		
		
		// </CONSOLE VIEW>
		
		// <BOARD>
		
		/**
		 * Place un jeton dans la première case vide de la colonne spécifiée.
		 * La colonne spécifiée doit être valide cad:
		 * - non pleine
		 * - faisant partie du board
		 * @param int la colonne dans laquelle placer le jeton
		 * @throws BoardColumnFullException si la colonne spécifiée est pleine
		 * @throws BoardColumnIndexOutOfRangeException si la colonne spécifiée ne fait pas
		 * partie du board. 
		 */
		public void placeInBoard(int column) throws BoardColumnFullException, BoardColumnIndexOutOfRangeException{
			if(isColumnFull(column)) {
				throw new BoardColumnFullException(column);
			}
			
			if(isBetweenBoardAcceptableColumnRange(column)) {
				throw new BoardColumnIndexOutOfRangeException(column);
			}
			
			// BOARD_COLUMN_LINE_NUMBER = 6
			for(int line = BOARD_COLUMN_LINE_NUMBER - 1; line >= 0; line--) {
				if (cases[column-1][line] == null) {
					cases[column-1][line] = new Case();
					break;
				}
			}	
			
		}
		
		/**
		 * Vérifie que le numéro de colonne column correspond a une colonne du board
		 * cad est compris entre BOARD_MIN_COLUMN_INDEX et BOARD_MAX_COLUMN_INDEX
		 * @param int le numero de colonne a vérifier
		 * @return true si la colonne est dans un range valide, false sinon.
		 */
		public boolean isBetweenBoardAcceptableColumnRange(int column) {
			return column >= BOARD_MIN_COLUMN_INDEX
				&& column <= BOARD_MAX_COLUMN_INDEX;
		}
		
		/**
		 * Vérifie que le numéro de colonne column correspond a une colonne du board
		 * pleine ou non.
		 * @param int le numero de colonne a vérifier
		 * @return true si la colonne est pleine, false sinon.
		 * @throws BoardColumnIndexOutOfRangeException si column ne fait pas partie des colonnes du board
		 */
		public boolean isColumnFull(int column) {
			if(! isBetweenBoardAcceptableColumnRange(column)) {
				throw new BoardColumnIndexOutOfRangeException(column);
			}
			return cases[column-1][0] != null;	
		}
		
		// </BOARD>
		
		
		
		

	}

}
