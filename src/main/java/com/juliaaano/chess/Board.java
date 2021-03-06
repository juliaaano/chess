package com.juliaaano.chess;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static com.juliaaano.chess.Position.at;
import static java.util.stream.Collectors.toSet;

class Board {

    private final Map<Position, Square> squares;

    Board() {

        squares = new HashMap<>();

        for (int row = 1; row <= 8; row++) {

            for (final char file : Position.files()) {

                squares.put(at(file, row), new Square());
            }
        }
    }

    boolean add(final Piece piece) {

        return !hasPieceAt(piece.position())
                && squares.get(piece.position()).set(piece);
    }

    Optional<Square> getSquareAt(final Position position) {

        return Optional.ofNullable(squares.get(position));
    }

    boolean hasPieceAt(final Position position) {

        final Square square = squares.get(position);

        return square != null && square.hasPiece();
    }

    Set<String> allMoves() {

        return squares.values().stream()
                .filter(Square::hasPiece)
                .map(Square::piece)
                .map(piece -> piece.get().print())
                .collect(toSet());
    }
}
