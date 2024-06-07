package dk.sdu.pa2.task1;

public class Library implements Runnable{


    private int availableBooks;

    public Library() {
        availableBooks = 3;
    }

    public int getAvailableBooks() {
        return availableBooks;
    }

    public void borrowBook(int books) {
        availableBooks--;
    }

    public void returnBook(int books) {
        throw new UnsupportedOperationException("Implement this!");
    }

    @Override
    public void run() {

    }
}


