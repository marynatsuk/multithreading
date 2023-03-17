package com.company.task_5;

public class OrderPrint extends Thread {
    private final String symbol;
    public OrderPrint(String symbol) {this.symbol = symbol;}
    private static final Object lock = new Object();
    public void run() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                synchronized (lock) {
                    lock.notify();
                    System.out.print(this.symbol);
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.exit(0);
    }

}
