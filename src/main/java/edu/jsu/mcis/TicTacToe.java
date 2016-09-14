package edu.jsu.mcis;


import java.util.Scanner;

public class TicTacToe {

    TicTacToeModel m = new TicTacToeModel();
    char[][] showGrid = m.getGrid();

    public void makeBoard() {
        System.out.println(showGrid[0][0] + " | " + showGrid[0][1] + " | " + showGrid[0][2]);
        System.out.println("----------");
        System.out.println(showGrid[1][0] + " | " + showGrid[1][1] + " | " + showGrid[1][2]);
        System.out.println("----------");
        System.out.println(showGrid[2][0] + " | " + showGrid[2][1] + " | " + showGrid[2][2]);
    }

    public void changeBoard(char player, int row, int column) {
        showGrid[row][column] = player;
        makeBoard();
    }

    public boolean checkWins() {
        if(m.getWinner() != ' '){
            System.out.println("Winner!");
            return true;
        }else if(m.checkTie()){
            System.out.println("Tie Game!");
            return true;
        }else
            return false;
        
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        TicTacToeModel model = new TicTacToeModel();
        char player = 'X';
        boolean play = true;

        Scanner scanner = new Scanner(System.in);
        System.out.println("                Tic Tac Toe");
        System.out.println("Enter choice by: row number then column number");
        System.out.println();
        game.makeBoard();

        while (true) {
            System.out.println();
            System.out.print("Player " + player + " - Enter Row: ");
            int row = scanner.nextInt();
            System.out.print("Player " + player + "  - Enter Column: ");
            int col = scanner.nextInt();
            System.out.println();
            
            if(row > 2 || row < 0)
                System.out.println("Numbers between 0 and 2 only! Please try again.");
            else if(col > 2 || col < 0)
                System.out.println("Numbers between 0 and 2 only! Please try again.");
            else if (game.showGrid[row][col] != ' ') {
                System.out.println("Spot is taken. Please try again.");
            } else {
                game.changeBoard(player, row, col);
                if(player == 'X') {
                    player = 'O';
                } else {
                    player = 'X';
                }
            }
            
            if(game.checkWins()){
                    break;
            }
        }
    }
}
