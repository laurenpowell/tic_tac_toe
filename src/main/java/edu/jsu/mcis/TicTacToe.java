package edu.jsu.mcis;

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class TicTacToe {


    public static void main(String[] args) {
        JFrame frame = new JFrame("Tic Tac Toe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TicTacToeGUI panel = new TicTacToeGUI();
		frame.add(panel);
        frame.setPreferredSize(new Dimension(500, 500));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}