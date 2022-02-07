package org.github.snambi;

import java.util.Arrays;

/**
 *
 * <ul>
 *     <li>Y: Yellow </li>
 *     <li>R: Red </li>
 *     <li>G: Green </li>
 *     <li>O: Orange </li>
 *     <li>B: Blue </li>
 *     <li>W: White </li>
 * </ul>
 */
public enum Color {
    Y("YELLOW"),
    R("RED"),
    G("GREEN"),
    O("ORANGE"),
    B("BLUE"),
    W("WHITE");

    private String color;

    Color(final String value) {
        if(Arrays.stream(Color.values()).anyMatch(c -> c.equals(value.toUpperCase())) ) {
            this.color = value;
        }else{
            throw new IllegalArgumentException( value + " is not a valid color");
        }
    }

    Color(final char color){

    }
}
