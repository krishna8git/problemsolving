package org.study.probsolve.primes;

import java.util.Arrays;

/**
 * 1) In general Sieve of Sundaram, produces primes smaller than
 * (2*x + 2) for a number given number x. Since we want primes
 * smaller than n, we reduce n-2 to half. We call it nNew.
 * nNew = (n-2)/2;
 * For example, if n = 102, then nNew = 50.
 * <p>
 * 2) Create an array marked[n] that is going
 * to be used to separate numbers of the form i+j+2ij from
 * others where  1 <= i <= j
 * <p>
 * 3) Initialize all entries of marked[] as false.
 * <p>
 * 4) // Mark all numbers of the form i + j + 2ij as true
 * // where 1 <= i <= j
 * Loop for i=1 to nNew
 * a) j = i;
 * b) Loop While (i + j + 2*i*j)  2, then print 2 as first prime.
 * <p>
 * 6) Remaining primes are of the form 2i + 1 where i is
 * index of NOT marked numbers. So print 2i + 1 for all i
 * such that marked[i] is false.
 */
public class SieveOfSundaram {
    public void generatePrimes(int n) {
        // In general Sieve of Sundaram, produces
        // primes smaller than (2*x + 2) for a number
        // given number x. Since we want primes
        // smaller than n, we reduce n to half
        int newN = (n - 2) / 2;

        boolean[] primes = new boolean[newN + 1];

        // Main logic of Sundaram. Mark all numbers of the
        // form i + j + 2ij as true where 1 <= i <= j
        for (int i = 1; i <= newN; i++) {
            for (int j = i; (i + j + 2 * i * j) <= newN; j++) {
                primes[i + j + 2 * i * j] = true;
            }
        }
        if (n > 2) {
            System.out.print("2 ");
        }

        for (int i = 1; i <= newN; i++) {
            if (primes[i] == false) {
                System.out.print((2 * i + 1) + " ");
            }
        }
    }

    public static void main(String[] args) {
        new SieveOfSundaram().generatePrimes(20);
    }
}
