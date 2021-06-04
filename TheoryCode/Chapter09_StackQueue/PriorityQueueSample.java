import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * PriorityQueueSample
 */
public class PriorityQueueSample {

    public static void main(String[] args) {
        PriorityQueue<Student> olderPriQueue = new PriorityQueue<>(new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2) {
                return -Integer.compare(o1.age, o2.age);
            }
        });

        Student s1 = new Student("A1", 1);
        Student s2 = new Student("A1", 2);
        Student s3 = new Student("A1", 3);
        Student s4 = new Student("A1", 4);
        Student s5 = new Student("A1", 5);
        Student s6 = new Student("A1", 6);
  
        olderPriQueue.add(s4);
        olderPriQueue.add(s5);
        olderPriQueue.add(s6);
        olderPriQueue.add(s1);
        olderPriQueue.add(s2);
        olderPriQueue.add(s3);
        s3.age = 9;
        olderPriQueue.remove(s3);
        olderPriQueue.
        olderPriQueue.add(s3);
        while(olderPriQueue.isEmpty() == false){
            System.out.println(olderPriQueue.poll().age);
        }


    }
}