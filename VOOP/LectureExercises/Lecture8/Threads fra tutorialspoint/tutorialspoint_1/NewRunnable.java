/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tutorialspoint_1;

/**
 *
 * @author erso Created on 01-02-2010, 14:31:31
 */
public class NewRunnable implements Runnable {
   private Thread t;

   public NewRunnable() {
      // Create a new, second thread
      t = new Thread(this, "Demo Thread");
      t.setDaemon(false);
      System.out.println("Child thread: " + t);
      t.start(); // Start the thread
   }

   // This is the entry point for the second thread.
   public void run() {
      try {
          t.setName("Oskar");
         for(int i = 5; i > 0; i--) {
            System.out.println("Child Thread: " +t+" "+ i);
            // Let the thread sleep for a while.
            Thread.sleep(500);
         }
     } catch (InterruptedException e) {
         System.out.println("Child interrupted.");
     }
     System.out.println("Exiting child thread.");
   }

   public static void main(String args[]) {
      new NewRunnable(); // create a new thread
      try {
         for(int i = 5; i > 0; i--) {
           System.out.println("Main Thread: " + i);
           Thread.sleep(1000);
         }
      } catch (InterruptedException e) {
         System.out.println("Main thread interrupted.");
      }
      System.out.println("Main thread exiting.");
   }
}

