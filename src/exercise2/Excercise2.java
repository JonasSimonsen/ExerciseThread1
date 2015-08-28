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

//  Forklaring: 
//  Når de to tråde kalder metoden next(), er der sandsynligt for at  den ene når at tælle 
//  1 op, imens den anden læser. Det medfører at de enten overskriver hinanden eller at
//  der opstår et ulige tal.
//
//  Hvor ofte forkommer problemet?
//  Jeg skulle kører loopet 10.000 gange for at få problemet til at opstå, 
//  vi kan derfor konkluderer atså det ikke nødvendigvis er noget der sker hver gang. 

public class Excercise2 {

    public static Even even = new Even();

    public static class Thread1 extends Thread {

        public void run() {
            boolean evenNumber;
            for (int i = 0; i < 100000; i++) {
                int j = even.next();
                if (j % 2 == 0) {
                    evenNumber = true;
                } else {
                    evenNumber = false;
                    System.out.println(evenNumber + " " + j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread1();
        Thread thread2 = new Thread1();

        thread1.start();
        thread2.start();
    }
}