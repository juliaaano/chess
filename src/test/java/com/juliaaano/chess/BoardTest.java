package com.juliaaano.chess;

import org.junit.Test;

import static com.juliaaano.chess.Colour.BLACK;
import static com.juliaaano.chess.Position.at;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoardTest {

    @Test
    public void shouldCreateBoard8x8() {

        Board board = new Board();

        assertTrue(board.getSquareAt(at("f8")).isPresent());
        assertFalse(board.getSquareAt(at("f9")).isPresent());
        assertFalse(board.getSquareAt(at("a9")).isPresent());
    }

    @Test
    public void shouldAddNewPiece() {

        Board board = new Board();

        boolean isAdded = board.add(new Pawn(board, BLACK, at("a2")));

        assertTrue(isAdded);
    }

    @Test
    public void shouldNotAddPieceInPositionWithExistingPiece() {

        Board board = new Board();

        board.add(new Pawn(board, BLACK, at("a2")));

        boolean isAdded = board.add(new Bishop(board, BLACK, at("a2")));

        assertFalse(isAdded);
    }

    @Test
    public void hasPieceAtIsTrue() {

        Board board = new Board();

        board.add(new Pawn(board, BLACK, at("a2")));

        assertTrue(board.hasPieceAt(at("a2")));
    }

    @Test
    public void hasPieceAtIsFalse() {

        Board board = new Board();

        board.add(new Pawn(board, BLACK, at("a2")));

        assertFalse(board.hasPieceAt(at("a3")));
    }
}
