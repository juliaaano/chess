package com.juliaaano.chess;

import java.util.Optional;

public class Square {

    private Piece piece;

    Optional<Piece> piece() {

        return Optional.ofNullable(piece);
    }

    public boolean set(final Piece piece) {

        this.piece = piece;
        return true;
    }
}
