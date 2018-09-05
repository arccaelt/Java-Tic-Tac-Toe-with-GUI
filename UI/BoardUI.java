package UI;

import java.awt.*;
import java.awt.event.*;

import Game.TTCBoard;
import Game.State;
import javax.swing.*;

public class BoardUI
{
	private JPanel board_panel;
	private TTCBoard tb;
	private JFrame main_window;
	public BoardUI(int gameMode, TTCBoard tb) 
	{
		this.tb = tb;
		
		main_window = new JFrame();
		board_panel = new JPanel();
		board_panel.setLayout(new GridLayout(3, 3));
		addButtons();
		
		main_window.add(board_panel);

		// Query the user's screen size and make a window half of it
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = kit.getScreenSize();
		
		main_window.setSize(d.width / 2, d.height / 2);
		
		main_window.setLocationRelativeTo(null);
		main_window.setTitle("Tic Tac Toe game");
		main_window.setVisible(true);
		main_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void addButtons()
	{
		int idx = 0;
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				Cell btn = new Cell(i, j, idx++);
				btn.addActionListener(new AbstractAction() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Cell b = (Cell)e.getSource();
						if(tb.move(b.x, b.y))
						{
							b.setText(tb.getCellValue(b.x, b.y));
							b.setBackground(Color.BLACK);
							b.setEnabled(false);
							
							// check if the game has ended
							State gs = tb.getGameState();
							if(gs != State.PROGRESS)
							{
								main_window.setVisible(false);
								main_window.dispose();
								main_window.setEnabled(false);
								GameOverFrame gf = new GameOverFrame(gs);
							}
						}
					}
				});
				
				board_panel.add(btn);
			}
		}
	}
}