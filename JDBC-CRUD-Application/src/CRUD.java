import java.util.List;

public class CRUD {

    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();

        // Test adding a student
        Students student1 = new Students(1, "maheswari", 20);
        Students student2 = new Students(2, "mahi", 22);

        studentDAO.addStudent(student1);
        studentDAO.addStudent(student2);

        // Test retrieving all students
        List<Students> allStudents = studentDAO.getAllStudents();
        System.out.println("All Students:");
        for (Students student : allStudents) {
            System.out.println(student);
        }

        // Test retrieving a student by ID
        int studentId = 2;
        Students studentById = studentDAO.getStudentById(studentId);
        System.out.println("\nStudent with ID " + studentId + ":");
        System.out.println(studentById);

        // Test updating a student
        studentById.setName("Alice Smith");
        studentById.setAge(21);
        studentDAO.updateStudent(studentById);
        System.out.println("\nUpdating Student with ID " + studentId + ":");
        System.out.println(studentById);

        // Test deleting a student
        int studentToDeleteId = 1;
        studentDAO.deleteStudent(studentToDeleteId);
        System.out.println("\nDeleting Student with ID " + studentToDeleteId + ":");

        // Check all students after deletion
        allStudents = studentDAO.getAllStudents();
        System.out.println("\nAll Students after deletion:");
        for (Students student : allStudents) {
            System.out.println(student);
        }
    }
}
