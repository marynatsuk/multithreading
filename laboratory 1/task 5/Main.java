package com.company.task_5;

public class Main {
    public static void main(String[] args) {
        // not in order
//        ThreadPrint thread1 = new ThreadPrint("-");
//        ThreadPrint thread2 = new ThreadPrint("|");
//        thread1.start();
//        thread2.start();

        // in order
        OrderPrint order_thread1 = new OrderPrint("-");
        OrderPrint order_thread2 = new OrderPrint("|");
        order_thread1.start();
        order_thread2.start();

    }
}

