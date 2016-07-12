package com.juliaaano.chess;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

class Position {

    private static final List<Character> files = asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h');

    private final int file;

    private final int rank;

    private Position(final char file, final int rank) {

        if (!files.contains(file))
            throw new IndexOutOfBoundsException();

        this.file = files.indexOf(file) + 1;
        this.rank = rank;
    }

    public static Position at(final char file, final int rank) {

        return new Position(file, rank);
    }

    public static Position at(final String position) {

        return at(position.charAt(0), Integer.valueOf(position.substring(1)));
    }

    static Iterable<Character> files() {

        return Collections.unmodifiableCollection(files);
    }

    Position move(final int offsetColumn, final int offsetRow) {

        return new Position(files.get(file - 1 + offsetColumn), rank + offsetRow);
    }

    int rank() {

        return rank;
    }

    boolean isInsideOfBounds(final int offsetColumn) {

        return file + offsetColumn > 0 && file + offsetColumn <= files.size();
    }

    @Override
    public boolean equals(final Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof Position)) return false;

        final Position position = (Position) obj;

        return file == position.file && rank == position.rank;
    }

    @Override
    public int hashCode() {

        return Objects.hash(file, rank);
    }

    @Override
    public String toString() {

        return files.get(file - 1) + "" + rank;
    }
}
