package UI;

import java.awt.Font;

import javax.swing.*;

public class Cell extends JButton
{
	// Each cell must know it's index as well as it's coords on the board
	public int idx;
	public int x;
	public int y;
	
	private int font_size = 42;
	private String font_name = "Arial";
	private int font_style = Font.PLAIN;
	
	Cell(int x, int y, int idx)
	{
		super();
		this.idx = idx;
		this.x = x;
		this.y = y;
		setFont(new Font(font_name, font_style, font_size));
	}
	Cell(String text)
	{
		super(text);
		setFont(new Font(font_name, font_style, font_size));
	}
}
