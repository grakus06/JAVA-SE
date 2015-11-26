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
		 * 2) Placer le jeton dans la colonne jou�e par le joueur.
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
		 * Obtient un num�ro de colonne aupr�s de l'utilisateur.
		 * Cette m�thode est bloquante et boucle 
		 * tant que l'utilisateur n'a pas saisi une valeur enti�re.
		 * @return int le num�ro de colonne choisi par l'utilisateur.
		 */
		public int readColumnNumber() {
			while(true) {
				String line = scanner.nextLine();
				try {
					return Integer.parseInt(line);
				} catch(NumberFormatException ex) {
					System.out.println("Veuillez saisir une valeur enti�re");
				}
			}
		}
		
		
		// </CONSOLE VIEW>
		
		// <BOARD>
		
		/**
		 * Place un jeton dans la premi�re case vide de la colonne sp�cifi�e.
		 * La colonne sp�cifi�e doit �tre valide cad:
		 * - non pleine
		 * - faisant partie du board
		 * @param int la colonne dans laquelle placer le jeton
		 * @throws BoardColumnFullException si la colonne sp�cifi�e est pleine
		 * @throws BoardColumnIndexOutOfRangeException si la colonne sp�cifi�e ne fait pas
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
		 * V�rifie que le num�ro de colonne column correspond a une colonne du board
		 * cad est compris entre BOARD_MIN_COLUMN_INDEX et BOARD_MAX_COLUMN_INDEX
		 * @param int le numero de colonne a v�rifier
		 * @return true si la colonne est dans un range valide, false sinon.
		 */
		public boolean isBetweenBoardAcceptableColumnRange(int column) {
			return column >= BOARD_MIN_COLUMN_INDEX
				&& column <= BOARD_MAX_COLUMN_INDEX;
		}
		
		/**
		 * V�rifie que le num�ro de colonne column correspond a une colonne du board
		 * pleine ou non.
		 * @param int le numero de colonne a v�rifier
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
