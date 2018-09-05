package UI;

import java.awt.Font;

import javax.swing.*;
import Game.State;

public class GameOverFrame
{
	public GameOverFrame(State endState) 
	{
		JFrame f = new JFrame();
		
		Font fontdata = new Font("Arial", Font.PLAIN, 42);
		
		JLabel title;
		
		if(endState == State.WINNER)
			title = new JLabel(((endState.winner_value.equals("X")) ? "X " : "O") + " IS THE WINNER");
		else
			title = new JLabel("NO WINNER, IT'S A TIE");
		title.setFont(fontdata);
		f.add(title);
		
		f.setLocationRelativeTo(null);
		f.setTitle("Game over");
		f.setVisible(true);
		f.pack();
	}
}
