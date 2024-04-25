package SerializableIO;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class SerializableDemoAppend implements Serializable {

    private int x;
    private String str;
    private boolean b;

    public SerializableDemoAppend(int x, String str) {
        this.x = x;
        this.str = str;
    }

    @Override
    public String toString() {
        return "SerializableDemo{" + "x=" + x + ", str=" + str + '}';
    }

       public static void main(String[] args) {
        // TODO code application logic here
        List<SerializableDemoAppend> list = new LinkedList<>();
        list.add(new SerializableDemoAppend(0, "aaa"));
        list.add(new SerializableDemoAppend(1, "bbb"));
        list.add(new SerializableDemoAppend(2, "ccc"));

        File file = new File("Serial.obj");

        if (file.exists()) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, true)) {
                @Override
                protected void writeStreamHeader() throws IOException {
                    reset();
                }
            }) {

                oos.writeObject(list);
            }
            catch (FileNotFoundException ex) {
                System.out.println(ex);
            }
            catch (IOException ex) {
                System.out.println(ex);
            }
        } else try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, true))) {
            oos.writeObject(list);

        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        System.out.println("List written to file\n");

        List<SerializableDemoAppend> l = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Serial.obj"))) {

            try {
                while (true) {
                    l = (List<SerializableDemoAppend>) ois.readObject();
                    System.out.println("List read: \n" + l);

                }

            } catch (EOFException eof) {
                System.out.println("No more to read!");
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }


    }

}
