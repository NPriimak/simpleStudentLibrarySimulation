import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) throws InterruptedException {

        Student [] students = null;
        Book [] books = null;
        ExecutorService executorService = Executors.newFixedThreadPool(Constants.NUMBER_OF_STUDENTS);

        books = new Book[Constants.NUMBER_OF_BOOK];
        students = new Student[Constants.NUMBER_OF_STUDENTS];

        for (int i = 0; i <Constants.NUMBER_OF_BOOK; i++){
            books[i] = new Book(i);
        }

        for (int i = 0; i < Constants.NUMBER_OF_STUDENTS; i++){
            students[i] = new Student(i, books);
        }

        try{
            for (Student student : students){
                executorService.execute(student);
            }
            executorService.shutdown();

        } finally {
            while(!executorService.isTerminated()){
                Thread.sleep(1000);
            }

            for(Student student : students){
                System.out.println(student.getBooksList().toString());
            }
        }




    }
}
