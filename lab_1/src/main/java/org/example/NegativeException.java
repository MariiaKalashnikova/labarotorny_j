package org.example;

public class NegativeException extends Exception {
    private int[] neg;
    public NegativeException(String message, int[] negative) {
        super(message);
        this.neg = negative.clone();
    }

    public int[] negativearr() {
        return neg.clone();
    }
}
