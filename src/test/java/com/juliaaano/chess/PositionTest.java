package com.juliaaano.chess;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PositionTest {

    @Test
    public void shouldMoveOneUp() {

        assertEquals(Position.at("a2"), Position.at("a1").move(0, 1));
    }

    @Test
    public void shouldMoveOneDown() {

        assertEquals(Position.at("a1"), Position.at("a2").move(0, -1));
    }

    @Test
    public void shouldMoveToAnyPosition() {

        assertEquals(Position.at("d4"), Position.at("a1").move(3, 3));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void shouldNotMoveToOutsideOfBoundary() {

        Position.at("a1").move(8, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldNotCreateOutsideOfBoundary() {

        Position.at("j1");
    }

    @Test
    public void shouldBeInsideOfBounds() {

        assertTrue(Position.at("a1").isInsideOfBounds(7));
    }

    @Test
    public void shouldNotBeInsideOfBoundsWhenOffsetIsPositive() {

        assertFalse(Position.at("a1").isInsideOfBounds(8));
    }

    @Test
    public void shouldNotBeInsideOfBoundsWhenOffsetIsNegative() {

        assertFalse(Position.at("a1").isInsideOfBounds(-1));
    }

    @Test
    public void shouldBeInsideOfBoundsWhenOffsetIsZero() {

        assertTrue(Position.at("a1").isInsideOfBounds(0));
    }
}
