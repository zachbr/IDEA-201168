package io.zachbr.unsafetest;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class Main {
    private static final Unsafe UNSAFE;
    static {
        Unsafe unsafe;
        try {
            Class c = Class.forName("sun.misc.Unsafe");
            Field f = c.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
        } catch (ClassNotFoundException | NoSuchFieldException | SecurityException e) {
            unsafe = null;
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
        UNSAFE = unsafe;
    }


    public static void main(String[] args) {
        System.out.println("Unsafe Supported: " + isUnsafeSupported());
    }

    public static boolean isUnsafeSupported() {
        return UNSAFE != null;
    }
}
