/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;

/**
 *
 * @author jonassimonsen
 */
public class Exercise1 {

    public static volatile boolean stop = false;

    private static class Thread1 extends Thread {

        @Override
        public void run() {
            long sum = 0;
            for (int i = 0; i <= 1000000000; i++) {
                sum = sum + i;
            }
            System.out.println("Sum = " + sum);
        }
    }

    private static class Thread2 extends Thread {

        public void run() {
            try {
                for (int i = 1; i <= 5; i++) {
                    System.out.println(i);
                    sleep(2000);
                }

            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }

    private static class Thread3 extends Thread {

        @Override
        public void run() {
            int i = 10;
            while (stop == false) {
                System.out.println(i);
                i++;

                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    System.err.println(e);
                }
            }
        }

        /**
         * @param args the command line arguments
         * @throws java.lang.InterruptedException
         */
        public static void main(String[] args) throws InterruptedException {
            Thread1 t1 = new Thread1();
            Thread2 t2 = new Thread2();
            Thread3 t3 = new Thread3();
            t1.start();
            t2.start();
            t3.start();
            Thread.sleep(10000);
            stop = true;
        }
    }
}