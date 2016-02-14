package org.nygenome.fcriscuolo.javaslang.dev;

/**
 * Created by fcriscuolo on 12/30/15.
 */
public class TestClass {
    public static int sum(int first, int second) {
        if (first >= 0 && second >= 0) {
            return first + second;
        } else {
            throw new IllegalArgumentException("Only positive integers are allowed");
        }
    }
}
