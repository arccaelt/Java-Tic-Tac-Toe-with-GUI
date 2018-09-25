package UI;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import Game.State;

public class GameOverFrame
{
	public GameOverFrame(State endState) 
	{
		JFrame f = new JFrame();
		f.setLayout(new GridLayout(2, 1));
		
		Font fontdata = new Font("Arial", Font.PLAIN, 42);
		
		JLabel title;
		
		if(endState == State.WINNER)
			title = new JLabel(((endState.winner_value.equals("X")) ? "X " : "O") + " IS THE WINNER");
		else
			title = new JLabel("NO WINNER, IT'S A TIE");
		title.setFont(fontdata);
		f.add(title);
		
		// add a new game button
		JButton newgame = new JButton("New Game");
		newgame.setFont(fontdata);
		
		newgame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StartFrame sf = new StartFrame();
				
				// destroy the game over frame afterwards
				f.setVisible(false);
				f.dispose();
			}
		});
		
		f.add(newgame);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setTitle("Game over");
		f.setVisible(true);
		f.setResizable(false);
		f.pack();
	}
}
