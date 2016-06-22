package com.juliaaano.chess;

import java.util.HashSet;
import java.util.Set;

public class Bishop extends Piece {

    Bishop(Board board, Colour colour, Position position) {
        super(board, colour, position);
    }

    @Override
    Set<Position> moves() {

        return new HashSet<>();
    }
}
