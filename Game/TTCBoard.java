package Game;

import java.util.Arrays;

// TTCBoard = Tic Tac Toe Board
/*
 * The board keep track of the internal memory represantation of the board.
 * Also, it knows how is the current player and provides sanity checks when a move is
 * performed
 */
public class TTCBoard 
{
	private int board[][];
	private int empty_cell = -1;
	private int current_player;
	private int empty_cells_count = 3 * 3;
	
	public TTCBoard(int start_player)
	{
		board = new int[3][3];
		clear();
		current_player = start_player;
	}
	
	public void clear()
	{
		// fill the board with empty cells
		for(int i = 0; i < board.length; i++)
		{
			Arrays.fill(board[i], empty_cell);
		}
	}
	
	public String getCellValue(int x, int y)
	{
		return (board[x][y] == 1) ? "X" : "O";
	}
	
	private boolean isValidMove(int x, int y)
	{
		if(board[x][y] != empty_cell)
			return false;
		return x >= 0 && x <= 2 && y >= 0 && y <= 2;
	}
	
	private int checkLines()
	{
		for(int i = 0; i < board.length; i++)
		{
			if(board[i][0] != empty_cell)
			{
				boolean is_row_complete = true;
				for(int j = 1; j < board.length && is_row_complete; j++)
				{
					if(board[i][j] == empty_cell || board[i][j] != board[i][j - 1])
					{
						is_row_complete = false;
					}
				}
				
				if(is_row_complete)
					return i;
			}
		}
		return -1;
	}
	
	private int checkColumns()
	{
		for(int i = 0; i < board.length; i++)
		{
			if(board[0][i] != empty_cell)
			{
				boolean is_col_complete = true;
				for(int j = 1; j < board.length && is_col_complete; j++)
				{
					if(board[j][i] == empty_cell || board[j][i] != board[j - 1][i])
						is_col_complete = false;
				}
				
				if(is_col_complete)
				{
					return i;
				}
			}
		}
		return -1;
	}
	
	private int checkDiagonals()
	{
		if(board[0][0] != empty_cell)
		{
			for(int i = 1; i < board.length; i++)
			{
				if(board[i][i] == empty_cell || board[i][i] != board[i - 1][i - 1])
					return 0;
			}
			return 1;
		}
		
		if(board[0][board.length - 1] != empty_cell)
		{
			for(int i = 1, j = board.length - 2; i < board.length; i++, j--)
			{
				if(board[i][j] == empty_cell || board[i][j] != board[i - 1][j + 1])
					return 0;
			}
			return 2;
		}
		return 0;
	}
	
	public State getGameState()
	{
		int cl = checkLines();
		if(cl != -1)
		{
			State winner_data = State.WINNER;
			winner_data.row_win = true;
			winner_data.row_idx = cl;
			winner_data.winner_value = getCellValue(cl, 0);
			return winner_data;
		}
		else
		{
			int cc = checkColumns();
			if(cc != -1)
			{
				State winner_data = State.WINNER;
				winner_data.col_win = true;
				winner_data.col_idx = cc;
				winner_data.winner_value = getCellValue(0, cc);
				return winner_data;
			}
			else
			{
				int cd = checkDiagonals();
				if(cd != 0)
				{
					State winner_data = State.WINNER;
					winner_data.diag_win = true;
					winner_data.diag_idx = cd;
					winner_data.winner_value = getCellValue(0, (cd == 1) ? 0 : board.length - 1);
					return winner_data;
				}
			}
		}
		if(empty_cells_count == 0)
			return State.TIE;
		return State.PROGRESS;
	}
	
	public boolean move(int x, int y)
	{
		if(isValidMove(x, y))
		{
			empty_cells_count--;
			board[x][y] = current_player;
			current_player = (current_player == 0) ? 1 : 0;
			return true;
		}
		return false;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for(int row[] : board)
		{
			for(int x : row)
			{
				sb.append(x + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
