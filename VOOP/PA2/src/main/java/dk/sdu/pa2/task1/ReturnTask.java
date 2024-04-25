package dk.sdu.pa2.task1;

public class ReturnTask implements Runnable {
    private Library library;
    private int books;

    public ReturnTask(Library library, int books) {
        this.library = library;
        this.books = books;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Implement this!");
    }
}