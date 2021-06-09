package com.jibug.learning.algorithm.offer;

/**
 */
public class LastRemaining_62 {

    public int lastRemaining(int n, int m) {
        int p = 0;
        for (int i = 2; i <= n ; i++) {
            p = (p + m) % i;
        }
        return p;
    }

    public int lastRemaining_1(int n, int m) {
        return f(n, m);
    }

    public int f(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = f(n - 1, m);
        return (m + x) % n;
    }


}
