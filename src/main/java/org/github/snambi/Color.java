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
        this.color =value;
    }

    public static boolean isValid(char color){
        //System.out.println(String.valueOf(Color.values()));
        for( Color c: Color.values()){
            if( c.name().equals(String.valueOf(color)) ){
                return true;
            }
        }
        return false;
    }

    public static Color get(char input){
        Color result = null;

        for( Color c: Color.values()){
            if( c.name().equals(String.valueOf(input)) ){
                result = c;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return  this.name();
    }
}
