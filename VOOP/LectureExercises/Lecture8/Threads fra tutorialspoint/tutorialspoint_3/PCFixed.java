/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tutorialspoint_3;

/**
 *
 * @author erso Created on 08-02-2010, 09:35:50
 */
public class PCFixed {
   public static void main(String args[]) {
      Q q = new Q();
      new Producer(q);
      new Consumer(q);
      System.out.println("Press Control-C to stop.");
   }
}
