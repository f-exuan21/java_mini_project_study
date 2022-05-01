import java.util.ArrayList;

public class StudentService {

    private static final ArrayList<Student> studentList = new ArrayList<>();
    private static int size = 0;

    public void addStudent(Student student) {
        student.setNo(++size);
        studentList.add(student);
    }

    public ArrayList<Student> getAll(int classRoom) {
        ArrayList<Student> students = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getClassRoom() == classRoom)
                students.add(student);
        }
        return students;
    }

    public Student getOne(int classRoom, String name) {
        for (Student student : studentList) {
            if (student.getClassRoom() == classRoom && student.getName().equals(name))
                return student;
        }
        return null;
    }

}
