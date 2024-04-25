package BinaryIO;

import java.io.*;

public class BinaryInputDemo {
    public static void main(String[] args) {
        String fileName = "numbers.dat";
        int anInteger;
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName)))
        {
            System.out.println("Reading the non-negative integers in the file:" + fileName);
            System.out.println("in the file " + fileName);

           while ((anInteger=inputStream.readInt()) >= 0) {
                System.out.println(anInteger);
            }
           // You can also use available() method in the loop.
            /*while(inputStream.available()>0)
            {
                anInteger=inputStream.readInt();
                System.out.println(anInteger);
            }*/
            System.out.println("End of reading from file.");
        } catch(FileNotFoundException e) {
            System.out.println("Problem opening the file " + fileName);
        } catch(EOFException e) {
            System.out.println("Problem reading the file " + fileName);
            System.out.println("Reached end of the file.");
        } catch(IOException e) {
            System.out.println("Problem reading the file " + fileName);
        }
    }
}

