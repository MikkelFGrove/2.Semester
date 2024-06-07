/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tutorialspoint_1;

/**
 *
 * @author erso Created on 04-02-2010, 11:12:42
 */
public class NewThread extends Thread {
   private NewThread() {
      // Create a new, second thread
      super("Demo Thread");
      System.out.println("Child thread: " + this);
      start(); // Start the thread
   }

   // This is the entry point for the second thread.
   public void run() {
      try {
         for(int i = 5; i > 0; i--) {
            System.out.println("Child Thread: " + i);
			// Let the thread sleep for a while.
            Thread.sleep(500);
         }
      } catch (InterruptedException e) {
         System.out.println("Child interrupted.");
      }
      System.out.println("Exiting child thread.");
   }

   public static void main(String args[]) {
      new NewThread(); // create a new thread
      System.out.println("Main Thread: " + Thread.currentThread());
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

