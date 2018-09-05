package Game;

/*
 * This enumeration will encapsulate different states in which a game of tic
 * tac toe can be in(going on, tie, x wins etc)
 */
public enum State
{
	PROGRESS, TIE, WINNER;
	
	public String winner_value;
	public boolean row_win;
	public boolean col_win;
	public boolean diag_win;
	public int row_idx, col_idx, diag_idx;
	
}
