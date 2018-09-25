package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;

import Game.*;
import org.junit.jupiter.api.Test;

class BoardTests 
{

	private TTCBoard tb;
	
	BoardTests()
	{
		tb = new TTCBoard(0);
	}
	
	@After
	void clearBoard()
	{
		tb.clear();
	}
	
	@Test
	void testMoves() 
	{
		// Some basic moves that should always work
		assertTrue(tb.move(0, 0));
		
		// Should't be able to reassing a cell
		assertFalse(tb.move(0, 0));
	}
	
	@Test
	void testRowWin()
	{
		// Test if by completing a row we win
		tb.move(0, 0);
		tb.move(1, 0);
		tb.move(0, 1);
		tb.move(2, 0);
		tb.move(0, 2);
		
		assertEquals(tb.getGameState(), State.WINNER);
	}
	
	@Test
	void testColWin()
	{
		// Test if by completing a column we win
		tb.move(0, 0);
		tb.move(0, 1);
		tb.move(1, 0);
		tb.move(0, 2);
		tb.move(2, 0);
		
		assertEquals(tb.getGameState(), State.WINNER);
	}

	@Test
	void testFirstDiagWin()
	{
		// Test if by completing the first diagonal we win
		tb.move(0, 0);
		tb.move(1, 0);
		tb.move(1, 1);
		tb.move(2, 0);
		tb.move(2, 2);
		
		assertEquals(tb.getGameState(), State.WINNER);
	}
	
	@Test
	void testSecondDiagWin()
	{
		// Test if by completing the first diagonal we win
		tb.move(0, 2);
		tb.move(0, 0);
		tb.move(1, 1);
		tb.move(0, 1);
		tb.move(2, 0);
		
		assertEquals(tb.getGameState(), State.WINNER);
	}
}
