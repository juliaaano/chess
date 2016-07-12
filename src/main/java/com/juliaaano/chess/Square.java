package com.juliaaano.chess;

import java.util.Optional;

public class Square {

    private Piece piece;

    Optional<Piece> piece() {

        return Optional.ofNullable(piece);
    }

    boolean hasPiece() {

        return piece != null;
    }

    boolean set(final Piece piece) {

        this.piece = piece;
        return true;
    }
}
