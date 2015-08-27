/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise2;

/**
 *
 * @author jonassimonsen
 */
public class Exercise2 {

    private static class Even {

        private int n = 0;

        public int next() {
            n++;
            n++;
            return n;
        }
    }

    private static class Thread1 extends Thread {
        Even even = new Even();
        int i;

        public Thread1(Even even) {
            this.even = even;
        }

        @Override
        public void run() {
            synchronized (even) {
                for (int j = 0; j < 10000; j++) {
                    i = even.next();
                    if ((i % 2) != 0) {
                        System.out.println(i);
                    }
                }
            }
        }

        private static class Thread2 extends Thread {
            Even even = new Even();
            int i;

            public Thread2(Even even) {
                this.even = even;
            }

            @Override
            public void run() {
                for (int j = 0; j < 10000; j++) {
                    i = even.next();
                    if ((i % 2) != 0) {
                        System.out.println(i);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Even even = new Even();

        Thread1 t1 = new Thread1(even);
        Thread1 t2 = new Thread1(even);

        t1.start();
        t2.start();
    }
}    