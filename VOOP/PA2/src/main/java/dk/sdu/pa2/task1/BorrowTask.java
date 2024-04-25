package dk.sdu.pa2.task1;

public class BorrowTask implements Runnable {
    private Library library;
    private int books;

    public BorrowTask(Library library, int books) {
        this.library = library;
        this.books = books;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Implement this!");
    }
}