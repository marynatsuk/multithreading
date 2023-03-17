package com.company.task_5;

public class ThreadPrint extends Thread {
    private final String symbol;

    public ThreadPrint(String symbol) {
        this.symbol = symbol;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                System.out.print(this.symbol);
            }
            System.out.println();
        }
    }
}
