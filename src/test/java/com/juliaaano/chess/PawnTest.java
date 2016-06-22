package com.juliaaano.chess;

import org.junit.Test;

import java.util.Set;

import static com.juliaaano.chess.Colour.BLACK;
import static com.juliaaano.chess.Colour.WHITE;
import static com.juliaaano.chess.Position.at;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PawnTest {

    private Board board = new Board();

    @Test
    public void shouldHaveOneMoveUpInNormalPosition() {

        Pawn white = new Pawn(board, WHITE, at("d3"));

        board.add(white);

        Set<Position> moves = white.moves();

        assertEquals(1, moves.size());
        assertTrue(moves.contains(at("d4")));
    }

    @Test
    public void shouldHaveTwoMovesUpInInitialPosition() {

        Pawn white = new Pawn(board, WHITE, at("e2"));

        board.add(white);

        Set<Position> moves = white.moves();

        assertEquals(2, moves.size());
        assertTrue(moves.contains(at("e3")));
        assertTrue(moves.contains(at("e4")));
    }

    @Test
    public void shouldHaveOneMoveDownInNormalPosition() {

        Pawn black = new Pawn(board, BLACK, at("b6"));

        board.add(black);

        Set<Position> moves = black.moves();

        assertEquals(1, moves.size());
        assertTrue(moves.contains(at("b5")));
    }

    @Test
    public void shouldHaveTwoMovesDownInInitialPosition() {

        Pawn black = new Pawn(board, BLACK, at("a7"));

        board.add(black);

        Set<Position> moves = black.moves();

        assertEquals(2, moves.size());
        assertTrue(moves.contains(at("a6")));
        assertTrue(moves.contains(at("a5")));
    }

    @Test
    public void shouldHaveMoveDownToFirstRank() {

        Pawn black = new Pawn(board, BLACK, at("f2"));

        board.add(black);

        Set<Position> moves = black.moves();

        assertEquals(1, moves.size());
        assertTrue(moves.contains(at("f1")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotPositionOnLastRank() {

        new Pawn(board, BLACK, at("c8"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotPositionOnFirstRank() {

        new Pawn(board, BLACK, at("e1"));
    }

    @Test
    public void shouldHaveOneMoveUpToEnemyPiece() {

        board.add(new Pawn(board, BLACK, at("f4")));

        Pawn white = new Pawn(board, WHITE, at("g3"));

        board.add(white);

        Set<Position> moves = white.moves();

        assertEquals(2, moves.size());
        assertTrue(moves.contains(at("f4")));
        assertTrue(moves.contains(at("g4")));
    }

    @Test
    public void shouldHaveOneMoveDownToEnemyPiece() {

        board.add(new Pawn(board, WHITE, at("g3")));

        Pawn black = new Pawn(board, BLACK, at("h4"));

        board.add(black);

        Set<Position> moves = black.moves();

        assertEquals(2, moves.size());
        assertTrue(moves.contains(at("h3")));
        assertTrue(moves.contains(at("g3")));
    }

    @Test
    public void shouldIgnoreMoveToFriendPiece() {

        board.add(new Pawn(board, WHITE, at("b5")));

        Pawn white = new Pawn(board, WHITE, at("c4"));

        board.add(white);

        Set<Position> moves = white.moves();

        assertEquals(1, moves.size());
        assertTrue(moves.contains(at("c5")));
    }

    @Test
    public void shouldNotHaveMoveInInitialPositionWhenPieceIsInFront() {

        board.add(new Pawn(board, WHITE, at("b3")));
        Pawn white = new Pawn(board, WHITE, at("b2"));

        board.add(white);

        Set<Position> moves = white.moves();

        assertEquals(0, moves.size());
    }
}
