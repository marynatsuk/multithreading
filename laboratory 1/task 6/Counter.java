package com.company.task_6;

public class Counter {
    private int value = 0;
    private final Object lock = new Object();

    public void ns_increment() {
        value++;
    }

    public void ns_decrement() {
        value--;
    }
    public synchronized void increment() {
        value++;
    }

    public synchronized void decrement() {
        value--;
    }

    public void incSyncBlock() {
        synchronized (lock) {
            value++;
        }
    }
    public void decSyncBlock() {
        synchronized (lock) {
            value--;
        }
    }

    public synchronized int getValue() {
        return value;
    }
    public void badInc() {
        value++;
    }
    public void badDec() {
        value--;
    }
}
