package com.juliaaano.chess;

import java.util.HashSet;
import java.util.Set;

public class Knight extends Piece {

    Knight(Board board, Colour colour, Position position) {
        super(board, colour, position);
    }

    @Override
    Set<Position> moves() {

        return new HashSet<>();
    }
}
