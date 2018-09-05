package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameModeFrame 
{
	private JPanel panel;
	private JFrame f;
	private Font ft = new Font("Arial", Font.PLAIN, 42);
	
	public GameModeFrame() 
	{
		f = new JFrame();
		
		JLabel title = new JLabel("Choose gameplay mode");
		title.setFont(ft);
		
		f.setLayout(new BorderLayout());
		f.add(title, BorderLayout.NORTH);

		panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		
		addGameModes();
		f.add(panel);
		
		f.setLocationRelativeTo(null);
		f.setTitle("Choose your player");
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
	}
	
	private void addGameModes()
	{
		JButton pvp = new JButton("Player vs player");
		pvp.setPreferredSize(new Dimension(500, 500));
		pvp.setFont(ft);
		pvp.addActionListener(new HandleSelection());
		
		panel.add(pvp);

		JButton pvc = new JButton("Player vs computer");
		pvc.setPreferredSize(new Dimension(500, 500));
		pvc.addActionListener(new HandleSelection());
		pvc.setFont(ft);
		
		panel.add(pvc);
	}

	private class HandleSelection extends AbstractAction
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			f.setVisible(false);
			f.dispose();
			
			JButton b = (JButton)e.getSource();
			
			PlayerChooseFrame pf = new PlayerChooseFrame(b.getText().equals("Player vs player") ? 1 : 2);
		}
	}
}
