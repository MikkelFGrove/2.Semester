/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tutorialspoint_3;

/**
 *
 * @author erso Created on 08-02-2010, 09:34:25
 */
public class Producer implements Runnable {
   Q q;
   Producer(Q q) {
      this.q = q;
      new Thread(this, "Producer").start();
   }

   public void run() {
      int i = 0;
      while(true) {
         q.put(i++);
      }
   }
}

