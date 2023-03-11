package Data_Structure.HashTable.File_HashTable;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Bai1 {
    private static class Student {
        int id;
        String name;
        Student (int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Student student = (Student) o;

            if (id != student.id) return false;
            return Objects.equals(name, student.name);
        }

        public int hashCode() {
            int result = id;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }
    }

    public static void main(String[] args) {
        Set<Student> myStudent = new HashSet<>();
        Student s1 = new Student(1,"Khánh");
        Student s2 = new Student(2,"An");
        Student s3 = new Student(1,"Khánh");

        myStudent.add(s1);
        myStudent.add(s2);
        myStudent.add(s3);

        for (Student s : myStudent) {
            System.out.println(s);
        }

        System.out.println(s1.hashCode());
        System.out.println(s3.hashCode());
    }
}
