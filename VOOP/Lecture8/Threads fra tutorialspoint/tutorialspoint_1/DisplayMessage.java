/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tutorialspoint_1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erso Created on 04-02-2010, 11:39:33
 */
// File Name : DisplayMessage.java
// Create a thread to implement Runnable
public class DisplayMessage implements Runnable
{
   private String message;
   public DisplayMessage(String message)
   {
      this.message = message;
   }
   public void run()
   {
      while(true)
      {
            try {
                System.out.println(message);
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(DisplayMessage.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
   }
}

