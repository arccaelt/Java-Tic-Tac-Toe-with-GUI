package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Game.*;

public class PlayerChooseFrame 
{
	private JFrame f;
	private int gameMode;
	public PlayerChooseFrame(int gameMode) 
	{
		this.gameMode = gameMode;
		
		f = new JFrame();
		f.setLayout(new BorderLayout());
		
		JLabel lb = new JLabel("Choose your player type");
		lb.setFont(new Font("Arial", Font.PLAIN, 42));
		f.add(lb, BorderLayout.NORTH);
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(1, 2));
		
		JButton xbtn = new JButton("X");
		xbtn.setFont(new Font("Arial", Font.PLAIN, 42));
		xbtn.setPreferredSize(new Dimension(100, 100));
		
		JButton zbtn = new JButton("O");
		zbtn.setFont(new Font("Arial", Font.PLAIN, 42));
		zbtn.setPreferredSize(new Dimension(100, 100));
		
		xbtn.addActionListener(new HandleSelection());
		zbtn.addActionListener(new HandleSelection());
		
		p.add(xbtn);
		p.add(zbtn);
		
		f.add(p, BorderLayout.SOUTH);
		
		f.setVisible(true);
		f.setTitle("Choose your player");
		f.pack();
	}
	
	private class HandleSelection extends AbstractAction
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			f.setVisible(false);
			f.dispose();
			JButton b = (JButton)e.getSource();
			
			TTCBoard tb = new TTCBoard(b.getText().equals("X") ? 1 : 0);
			BoardUI bb = new BoardUI(gameMode, tb);
		}
	}
}
