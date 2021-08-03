package Lesson03_Sorting_Solved;

public class Student implements Comparable<Student>{
    // To make code simple, here we make all properties public... (Do not do like this in real life!)
    public String fullName;
    public int age;
    public int GPA;

    public Student(String fullName, int age, int GPA) {
        this.fullName = fullName;
        this.age = age;
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' + "\t" +
                ", age = " + age + " , \t GPA = " + GPA + "}";
    }

    @Override
    public int compareTo(Student other) {
        return this.getName().compareTo(other.getName());
    }

    public String getName(){
        String[] names = this.fullName.split(" ");
        if(names.length <= 1)
            return this.fullName;
        else
            return names[names.length-1];
    }
}
