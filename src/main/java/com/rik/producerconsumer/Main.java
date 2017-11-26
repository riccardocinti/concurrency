package com.rik.producerconsumer;

public class Main {

    public static void main(String[] args){
        Q queue = new Q();

        new Producer(queue);
        new Consumer(queue);

    }
}
