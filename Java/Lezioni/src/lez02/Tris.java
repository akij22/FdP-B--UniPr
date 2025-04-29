package lez02;
import java.util.Scanner;

public class Tris {
	private char matrix[][];
	int winner;

	private void initialize() {
		matrix = new char[3][3];
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				matrix[i][j] = '-';
		winner = -1;
	}
	
	public Tris() {
		initialize();
	} 

	private boolean playerWon(char c) {
		if (matrix[0][0] == c && matrix[0][1] == c && matrix[0][2] == c)
			return true;
		if (matrix[0][0] == c && matrix[1][0] == c && matrix[2][0] == c)
			return true;
		if (matrix[0][0] == c && matrix[1][1] == c && matrix[2][2] == c)
			return true;
		if (matrix[2][0] == c && matrix[1][1] == c && matrix[0][2] == c)
			return true;
		if (matrix[2][0] == c && matrix[2][1] == c && matrix[2][2] == c)
			return true;
		if (matrix[0][2] == c && matrix[1][2] == c && matrix[2][2] == c)
			return true;
		if (matrix[1][0] == c && matrix[1][1] == c && matrix[1][2] == c)
			return true;
		if (matrix[0][1] == c && matrix[1][1] == c && matrix[2][1] == c)
			return true;
		return false;
	}

	// X
	public boolean movePlayer1(int row, int col) {
		if (row < 0 || row > 2 || col < 0 || col > 2) {
			System.err.println("Posizione non valida");
			return false;
		} else if (isFull()) {
			System.err.println("Gioco terminato");
			return false;
		} else if (matrix[row][col] != '-') {
			System.err.println("Cella occupata");
			return false;
		}

		matrix[row][col] = 'X';
		if (player1Won())
			winner = 1;
		return true;
	}

	// O
	public boolean movePlayer2(int row, int col) {
		if (row < 0 || row > 2 || col < 0 || col > 2) {
			System.err.println("Posizione non valida");
			return false;
		} else if (isFull()) {
			System.err.println("Gioco terminato");
			return false;
		} else if (matrix[row][col] != '-') {
			System.err.println("Cella occupata");
			return false;
		}

		matrix[row][col] = 'O';
		if (player2Won())
			winner = 2;
		return true;
	}

	private boolean player1Won() {
		return playerWon('X');
	}

	private boolean player2Won() {
		return playerWon('O');
	}		

	public int getWinner() {
		return winner;
	}

	private boolean someoneWon() {
		return winner != -1;
	}

	private boolean isFull() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (matrix[i][j] == '-')
					return false;
		return true;
	}

	private void print() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
	}


	public static void main(String[] args) {
		Tris game = new Tris();
		boolean player = false;
		Scanner sc = new Scanner(System.in);

		do {
			int row, col;

			game.print();
			if (!player) {
				// Giocatore 1
				System.out.println("Giocatore 1: ");
				row = sc.nextInt();
				col = sc.nextInt();
				if (!game.movePlayer1(row, col)) {
					System.err.println("Mossa invalida!");
					continue;
				}

			} else {
				// Giocatore 2
				System.out.println("Giocatore 2: ");
				row = sc.nextInt();
				col = sc.nextInt();
				if (!game.movePlayer2(row, col)) {
					System.err.println("Mossa invalida!");
					continue;
				}
			}

			player = !player;
		} while (!game.someoneWon() && !game.isFull());

		game.print();

		if (game.getWinner() == -1)
			System.out.println("Patta!");
		else
			System.out.println("Vincitore: Giocatore " + game.getWinner());
	}
}
