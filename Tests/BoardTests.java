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
		assertTrue(tb.move(0, 0));
		assertFalse(tb.move(0, 0));
	}
}
