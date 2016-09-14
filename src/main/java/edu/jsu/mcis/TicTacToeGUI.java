package edu.jsu.mcis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeGUI extends JPanel implements ActionListener{

    private JLabel turnLabel;
	private JLabel winLabel;
    private JButton[][] button;
    private int turnCount;
    private TicTacToeModel model;

    public TicTacToeGUI() {

        model = new TicTacToeModel();

        JPanel labelPanel = new JPanel();
		char turn = 'X';
        turnLabel = new JLabel("Turn: " + turn, SwingConstants.CENTER);
		winLabel = new JLabel();
		winLabel.setName("winLabel");
        labelPanel.add(turnLabel);
		labelPanel.add(winLabel);

        GridLayout layout = new GridLayout(3, 3);
        JPanel buttonPanel = new JPanel(layout);
        layout.setHgap(8);
        layout.setVgap(8);

		button = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                button[i][j] = new JButton();
				button[i][j].setName("Location" + String.valueOf(i) + String.valueOf(j));
                buttonPanel.add(button[i][j]);
                button[i][j].setEnabled(true);
                button[i][j].addActionListener(this);
            }
        }
		setLayout(new BorderLayout());
        add(labelPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
	}
	
	public void checkWins(){
		if (model.getWinner() != ' ') {
			winLabel.setText("The Winner is " + model.getWinner());
		}
		if(model.checkTie()) {
			winLabel.setText("The Winner is TIE");
		}
	}
	
	public void actionPerformed(ActionEvent event) {
        turnCount++;
		for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                if (event.getSource() == button[i][k]) {
                    if (turnCount % 2 != 0) {
                        button[i][k].setFont(new Font("Arial", Font.PLAIN, 40));
                        button[i][k].setText(Character.toString(model.makeMark('X', i, k)));
                        turnLabel.setText("Turn: O");
                        button[i][k].setEnabled(false);
						checkWins();
					}else{
                        button[i][k].setFont(new Font("Arial", Font.PLAIN, 40));
                        button[i][k].setText(Character.toString(model.makeMark('O', i, k)));
                        turnLabel.setText("Turn: X");
                        button[i][k].setEnabled(false);
						checkWins();
                    }
				}
            }
        }
	}
}