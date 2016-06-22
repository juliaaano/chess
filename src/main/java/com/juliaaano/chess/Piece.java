package com.juliaaano.chess;

import java.util.Set;

abstract class Piece {

    final Board board;

    final Position position;

    private final Colour colour;

    Piece(final Board board,
          final Colour colour,
          final Position position) {

        this.board = board;
        this.colour = colour;
        this.position = position;
    }

    abstract Set<Position> moves();

    String print() {

        final String piece = colour + " " + this.getClass().getSimpleName() + " on " + position + ":";

        return piece + " " + moves();
    }

    Position position() {

        return position;
    }

    boolean isEnemy(final Piece piece) {

        return this.colour != piece.colour;
    }
}
