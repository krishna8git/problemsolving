package org.study.probsolve.primes;

public class SieveOfEratothenes {

    public void generatePrimes(int n) {
        boolean[] primes = new boolean[n + 1];
        primes[0] = primes[1] = true;
        // Main logic of Sundaram. Mark all numbers of the
        // form i + j + 2ij as true where 1 <= i <= j
        for (int i = 2; i <= n; i++) {
            if (primes[i] == false) {
                for (int j = i * 2; j <= n; j += i) {
                    primes[j] = true;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (primes[i] == false) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        new SieveOfEratothenes().generatePrimes(100);
    }
}
