package com.juliaaano.chess;

public enum Colour {

    BLACK("B"), WHITE("W");

    private final String abbreviation;

    Colour(final String abbreviation) {

        this.abbreviation = abbreviation;
    }

    public static Colour of(final String abbreviation) {

        for (final Colour colour : values()) {
            if (colour.abbreviation.equals(abbreviation))
                return colour;
        }

        throw new IllegalArgumentException();
    }
}
