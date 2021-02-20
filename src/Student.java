import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Student implements Runnable{

    private int id;
    private Book [] books;
    List <Integer> booksList;

    public Student(int id, Book[] books) {
        this.id = id;
        this.books = books;
        this.booksList = new ArrayList<>();
    }

    @Override
    public void run() {
            for (int i = 0; i < Constants.NUMBER_OF_BOOK; i++ ) {

                try {
                    books[i].read(this);
                    booksList.add(books[i].getId());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }

    public List<Integer> getBooksList() {
        return booksList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }
}
