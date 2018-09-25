package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Game.TTCBoard;

public class StartFrame 
{
	public StartFrame()
	{
		JFrame f = new JFrame();
		f.setLayout(new GridLayout(3, 1));
		
		// add the Logo
		// The logo will be a JLabel with an image on it
		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon("C:\\Users\\arco\\workspace2\\TicTacToe\\src\\res\\logo.png"));
		
		// we will also create a JPanel(a feature-less window container) in which
		// we will put different widgets/components that users needs to use before
		// starting a game. Stuff like:
		//     a. choose between pvp and pvc
		//     b. choose between x and o
		
		// Use custom fonts
		Font fdata = new Font("Arial", Font.PLAIN, 20);
		
		JPanel data = new JPanel();
		data.setLayout(new GridLayout(2, 3));
		
		JLabel gamemode_label = new JLabel("Choose game mode: ");
		JRadioButton gamemode_r1 = new JRadioButton("pvp");
		JRadioButton gamemode_r2 = new JRadioButton("pvc");
		
		JLabel playertype_label = new JLabel("Choose your type: ");
		JRadioButton playertype_r1 = new JRadioButton("X");
		JRadioButton playertype_r2 = new JRadioButton("O");
		
		ButtonGroup g1 = new ButtonGroup();
		g1.add(gamemode_r1);
		g1.add(gamemode_r2);
		
		ButtonGroup g2 = new ButtonGroup();
		g2.add(playertype_r1);
		g2.add(playertype_r2);

		// before adding them use the custom font
		gamemode_label.setFont(fdata);
		gamemode_r1.setFont(fdata);
		gamemode_r2.setFont(fdata);
		playertype_label.setFont(fdata);
		playertype_r1.setFont(fdata);
		playertype_r2.setFont(fdata);
		
		// add the components to the panel
		data.add(gamemode_label);
		data.add(gamemode_r1);
		data.add(gamemode_r2);
		data.add(playertype_label);
		data.add(playertype_r1);
		data.add(playertype_r2);
		
		// We will also need a play button
		JPanel play_panel = new JPanel();
		JButton play = new JButton("Play");
		
		// here we are allocating memory for a Dimension object on the memory
		// and we don't keep the reference that's return by the new operator, instead
		// we just pass it to the setPreferredSize method
		play.setPreferredSize(new Dimension(120, 50));
		
		// Here we are creating an anonymous class(a class which has no name)
		// which implements the ActionListener interface and override the
		// method that will be called when this push button is pressed.
		// Also, after defining such a class on the fly we are allocating memory on the heap
		// for an object of this class and return a reference(the memory location where is stored)
		// that will be added as a listener for Action events for this push button
		// Also, an anonymous inner class has access to every field and method of the enclosing class
		play.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// when the button is pressed start the game window
				// but first, coleect the necessary data
				BoardUI b = new BoardUI(gamemode_r1.isSelected() ? 1 : 2, new TTCBoard(playertype_r1.isSelected() ? 1 : 0));
				f.setVisible(false);
				f.dispose();
			}
		});
		play_panel.add(play);
		
		// style the components
//		data.setBackground(Color.BLACK);
//		for(int i = 0, n = data.getComponentCount(); i < n; i++)
//		{
//			data.getComponent(i).setBackground(Color.black);
//			data.getComponent(i).setForeground(Color.white);
//		}
//		
		// add the components to the JFrame container
		f.add(logo);
		f.add(data);
		f.add(play_panel);
		
		f.setResizable(false);
		f.pack();
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("Tic tac toe start up screen");
	}
}