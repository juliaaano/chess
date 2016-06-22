package com.juliaaano.chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.juliaaano.chess.Position.at;
import static java.lang.String.format;

public class Game {

    private static final Board board = new Board();

    public static void main(String... args) throws IOException {

        System.out.println("\n> FindValidMoves\n");

        enterPieces();

        System.out.println("Will only print valid moves for Pawns...\n");

        board.allMoves().forEach(System.out::println);
    }

    private static void enterPieces() throws IOException {

        System.out.print("Enter the number of pieces: ");

        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        final Integer numberOfPieces = Integer.valueOf(in.readLine());

        int i = 0;
        while (i < numberOfPieces) {

            System.out.print("Enter colour (W/B): ");
            final String colour = in.readLine().toUpperCase();

            System.out.print("Enter type (B/N/P): ");
            final String type = in.readLine().toUpperCase();

            System.out.print("Enter position: ");
            final String position = in.readLine().toLowerCase();

            board.add(newPiece(colour, type, position));

            System.out.println("\n");

            i++;
        }
    }

    private static Piece newPiece(final String colour, final String type, final String position) {

        switch (type) {

            case "B":
                return new Bishop(board, Colour.of(colour), at(position));
            case "N":
                return new Knight(board, Colour.of(colour), at(position));
            case "P":
                return new Pawn(board, Colour.of(colour), at(position));
        }

        throw new IllegalArgumentException(format("Invalid piece type %s.", type));
    }
}
