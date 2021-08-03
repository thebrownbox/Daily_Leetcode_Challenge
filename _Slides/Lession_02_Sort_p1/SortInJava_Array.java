import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortInJava_Array {

    static class Student implements Comparable {
        int age;
        String name;
        public Student(String name, int age){
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Object other) {
            // so sanh this and other
            Student otherStudent = (Student)other;
            // 0 new this = other
            // 1 ? this > other
            // -1 ? this < other
            if(this.age == otherStudent.age){
                return 0;
            }else if(this.age > otherStudent.age){
                return 1;
            }
            return -1;
        }
    }

    static class SoSanhTheoDoDaiTen implements Comparator<Student>{

        @Override
        public int compare(Student before, Student after) {
            if(before.name.length() == after.name.length()){
                return 0;
            }else if(before.name.length() > after.name.length()){
                return 1;
            }
            return -1;
        }
    }


    public static void main(String[] args) {

        // =================== A. Using Arrays.sort =======================
        // #1. Sort an integer array
        int[] intArray = {3,2,1,0};
        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));

        // #2. Sort an String array
        String[] stringArray = {"1", "00000", "22"};
        Arrays.sort(stringArray);
        System.out.println(Arrays.toString(stringArray));


        // #3. Sort a Student array with interface Comparable
        Student[] students = {new Student("ZZZZZZZ", 20), new Student("AAAA", 10)};
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));


        // #4. Sort a Student array with Comparator
        SoSanhTheoDoDaiTen s = new SoSanhTheoDoDaiTen();
        Arrays.sort(students, s);

        System.out.println(Arrays.toString(students));
    }
}
