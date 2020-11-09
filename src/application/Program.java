package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch(); 
		List<ChessPiece> captured = new ArrayList<>();
		while (!chessMatch.getCheckMatch()) {
			try {
				UI.clearScreen();
				UI.printMatch(chessMatch, captured);
				System.out.println();
				System.out.println("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
				System.out.println();
				System.out.println("Target: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				if (capturedPiece != null) {
					captured.add(capturedPiece); // adicionar a lista
				}

			}catch(ChessException e) {
				
				System.out.println(e.getMessage());
				System.out.println(UI.ANSI_RED + "Press any key..." + UI.ANSI_RESET);
				System.out.print("----");
				sc.nextLine();
			}catch(InputMismatchException e) {
				
				System.out.println(e.getMessage());
				System.out.println(UI.ANSI_RED + "Press any key..." + UI.ANSI_RESET);
				
				sc.nextLine();
			}
		}
		UI.clearScreen();
		UI.printMatch(chessMatch, captured);

	}

}
