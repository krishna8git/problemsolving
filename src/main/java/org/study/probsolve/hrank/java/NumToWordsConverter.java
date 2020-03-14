package org.study.probsolve.hrank.java;

public class NumToWordsConverter {

    private final long num;
    private final StringBuilder result;

    private static final int ONE_CRORE = 100_00_000;
    private static final int ONE_LAKH = 100_000;

    private final String[] ones = new String[]{
            "", "One ", "Two ", "Three ", "Four ", "Five ",
            "Six ", "Seven ", "Eight ", "Nine ", "Ten ",
            "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ",
            "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "
    };

    private final String[] tens = new String[]{
            "", "", "Twenty ", "Thirty ", "Fourty ", "Fifty ",
            "Sixty ", "Seventy ", "Eighty ", "Ninety "
    };

    public NumToWordsConverter(long num) {
        this.result = new StringBuilder();
        this.num = num;
    }

    public void convertToWords() {
        convertToWords(num);
    }

    private void convertToWords(long n) {
        numToWord(n / ONE_CRORE, "Crore ");
        n = n % ONE_CRORE;

        numToWord(n / ONE_LAKH, "Lakh ");
        n = n % ONE_LAKH;

        numToWord(n / 1000, "Thousand ");
        n = n % 1000;

        numToWord(n / 100, "Hundred ");
        if (n > 100 && n % 100 > 0) {
            result.append("and ");
        }

        numToWord(n % 100, "");
    }

    private void numToWord(long n, String word) {
        if (n > 99) {
            convertToWords(n);
        } else if (n > 19) {
            result.append(tens[(int) n / 10]);
            result.append(ones[(int) n % 10]);
        } else {
            result.append(ones[(int) n]);
        }
        if (n != 0) {
            result.append(word);
        }
    }

    public String getResult() {
        return result.toString();
    }

    public static void main(String[] args) {
        NumToWordsConverter converter = new NumToWordsConverter(7464);
        converter.convertToWords();
        System.out.println(7464 + ": " + converter.getResult());
        assertEquals(converter.getResult(), "Seven Thousand Four Hundred and Sixty Four ");

        converter = new NumToWordsConverter(57464);
        converter.convertToWords();
        System.out.println(7464 + ": " + converter.getResult());
        assertEquals(converter.getResult(), "Fifty Seven Thousand Four Hundred and Sixty Four ");

        converter = new NumToWordsConverter(657464);
        converter.convertToWords();
        System.out.println(657464 + ": " + converter.getResult());
        assertEquals(converter.getResult(), "Six Lakh Fifty Seven Thousand Four Hundred and Sixty Four ");

        converter = new NumToWordsConverter(7657464);
        converter.convertToWords();
        System.out.println(7657464 + ": " + converter.getResult());
        assertEquals(converter.getResult(), "Seventy Six Lakh Fifty Seven Thousand Four Hundred and Sixty Four ");

        converter = new NumToWordsConverter(87657464);
        converter.convertToWords();
        System.out.println(87657464 + ": " + converter.getResult());
        assertEquals(converter.getResult(), "Eight Crore Seventy Six Lakh Fifty Seven Thousand Four Hundred and Sixty Four ");

        converter = new NumToWordsConverter(387657464);
        converter.convertToWords();
        System.out.println(387657464 + ": " + converter.getResult());
        assertEquals(converter.getResult(), "Thirty Eight Crore Seventy Six Lakh Fifty Seven Thousand Four Hundred and Sixty Four ");

        converter = new NumToWordsConverter(4387657464L);
        converter.convertToWords();
        System.out.println(4387657464L + ": " + converter.getResult());
        assertEquals(converter.getResult(), "Four Hundred and Thirty Eight Crore Seventy Six Lakh Fifty Seven Thousand Four Hundred and Sixty Four ");

        converter = new NumToWordsConverter(54387657464L);
        converter.convertToWords();
        System.out.println(54387657464L + ": " + converter.getResult());
        assertEquals(converter.getResult(), "Five Thousand Four Hundred and Thirty Eight Crore Seventy Six Lakh Fifty Seven Thousand Four Hundred and Sixty Four ");

        converter = new NumToWordsConverter(454387657464L);
        converter.convertToWords();
        System.out.println(454387657464L + ": " + converter.getResult());
        assertEquals(converter.getResult(),
                "Fourty Five Thousand Four Hundred and Thirty Eight Crore Seventy Six Lakh Fifty Seven Thousand Four Hundred and Sixty Four ");

        converter = new NumToWordsConverter(4454387657464L);
        converter.convertToWords();
        System.out.println(4454387657464L + ": " + converter.getResult());
        assertEquals(converter.getResult(),
                "Four Lakh Fourty Five Thousand Four Hundred and Thirty Eight Crore Seventy Six Lakh Fifty Seven Thousand Four Hundred and Sixty Four ");
        converter = new NumToWordsConverter(54454387657464L);
        converter.convertToWords();
        System.out.println(54454387657464L + ": " + converter.getResult());
        assertEquals(converter.getResult(),
                "Fifty Four Lakh Fourty Five Thousand Four Hundred and Thirty Eight Crore Seventy Six Lakh Fifty Seven Thousand Four Hundred and Sixty Four ");

        converter = new NumToWordsConverter(554454387657464L);
        converter.convertToWords();
        System.out.println(554454387657464L + ": " + converter.getResult());
        assertEquals(converter.getResult(),
                "Five Crore Fifty Four Lakh Fourty Five Thousand Four Hundred and Thirty Eight Crore Seventy Six Lakh Fifty Seven Thousand Four Hundred and Sixty Four ");

    }

    private static void assertEquals(String expected, String actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError("Miss Match: Expected [" + expected + "], Actual: [" + actual + "]");
        }
    }

}
