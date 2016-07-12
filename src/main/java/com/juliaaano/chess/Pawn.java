package com.juliaaano.chess;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.juliaaano.chess.Colour.BLACK;
import static com.juliaaano.chess.Colour.WHITE;

class Pawn extends Piece {

    private final int oneMove;

    private final boolean initialPosition;

    Pawn(final Board board, final Colour colour, final Position position) {

        super(board, colour, position);

        if (position.rank() == 1 || position.rank() == 8)
            throw new IllegalArgumentException("Pawns may not be placed on the first or last ranks.");

        oneMove = colour == WHITE ? 1 : -1;

        initialPosition = colour == WHITE && position.rank() == 2 || colour == BLACK && position.rank() == 7;
    }

    @Override
    Set<Position> moves() {

        final Set<Position> positions = new HashSet<>();

        positions.addAll(forward());
        positions.addAll(diagonals());

        return positions;
    }

    private Set<Position> forward() {

        final Set<Position> positions = new HashSet<>();

        final Position oneForward = position.move(0, oneMove);
        board.getSquareAt(oneForward).ifPresent(square -> {

            if (!square.hasPiece())
                positions.add(oneForward);
        });

        if (initialPosition && !board.hasPieceAt(oneForward)) {

            final Position twoForward = oneForward.move(0, oneMove);
            board.getSquareAt(twoForward).ifPresent(square -> {

                if (!square.hasPiece())
                    positions.add(twoForward);
            });
        }

        return positions;
    }

    private Set<Position> diagonals() {

        final Set<Position> positions = new HashSet<>();

        if (position.isInsideOfBounds(oneMove)) {

            final Position diagonalRight = position.move(oneMove, oneMove);

            if (this.hasEnemyAt(diagonalRight))
                positions.add(diagonalRight);
        }

        if (position.isInsideOfBounds(oneMove * -1)) {

            final Position diagonalLeft = position.move(oneMove * -1, oneMove);

            if (this.hasEnemyAt(diagonalLeft))
                positions.add(diagonalLeft);
        }

        return positions;
    }

    private boolean hasEnemyAt(final Position position) {

        final Optional<Square> square = board.getSquareAt(position);

        return square.isPresent()
                && square.get().hasPiece()
                && square.get().piece().get().isEnemy(this);
    }

}
