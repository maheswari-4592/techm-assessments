import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    // Add a new student to the collection
    public void addStudent(Student student) {
        students.add(student);
    }

    // Returns a list of all students
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    // Returns a student by their id, or null if not found
    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    // Updates the name and age of the student with the specified id
    public boolean updateStudent(int id, String name, int age) {
        Student student = getStudentById(id);
        if (student != null) {
            student.setName(name);
            student.setAge(age);
            return true;
        }
        return false;
    }

    //  Removes the student with the specified id from the collection
    public boolean deleteStudent(int id) {
        Student student = getStudentById(id);
        if (student != null) {
            students.remove(student);
            return true;
        }
        return false;
    }

    // Main method for testing the CRUD functionalities
    public static void main(String[] args) {
        StudentManager s = new StudentManager();

        // Adding students
        s.addStudent(new Student(1, "Maheswari", 20));
        s.addStudent(new Student(2, "Teja", 22));
        s.addStudent(new Student(3, "Pooja", 19));

        // Displaying all students
        System.out.println("All Students:");
        for (Student student : s.getAllStudents()) {
            System.out.println(student);
        }

        // Getting a student by id
        System.out.println("\nStudent with ID 2:");
        System.out.println(s.getStudentById(2));

        // Updating a student
        System.out.println("\nUpdating Student with ID 1:");
        s.updateStudent(1, "priya ", 21);
        System.out.println(s.getStudentById(1));

        // Deleting a student
        System.out.println("\nDeleting Student with ID 3:");
        s.deleteStudent(3);
        
        System.out.println("\nList of All Students :");
        for (Student student : s.getAllStudents()) {
            System.out.println(student);
        }
    }
}
