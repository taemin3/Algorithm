import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static final long MOD = 1_000_000_007L;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long [] anw = fib(n);
        System.out.println(anw[0]);
        
    }

    public static long[] fib(long n) {
        if (n == 0) return new long[]{0,1};

        long [] half = fib(n/2);
        long a = half[0];
        long b = half[1];

        long twoB = ((2 * b)% MOD - a + MOD) % MOD;
        long c = (a * twoB) % MOD;
        long d = ((a * a) % MOD + (b * b) % MOD) % MOD;
        if (n % 2 == 0) return new long[]{c,d};
        else return new long[]{d, (c+d)%MOD};
        
    }
}