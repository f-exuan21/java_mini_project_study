import java.util.ArrayList;

public class TeacherService {

    private static final ArrayList<Teacher> teacherList = new ArrayList<>();
    private static final TeacherService teacherService = new TeacherService();

    private TeacherService() {}

    public static TeacherService getInstance() {
        return teacherService;
    }

    //회원가입
    public boolean register(Teacher teacher) {

        for (Teacher t : teacherList) {
            if (t.getId().equals(teacher.getId())) {
                return false;
            }
        }
        teacherList.add(teacher);

        return true;
    }

    //로그인
    public Teacher login(String id, String password) {
        for (Teacher teacher : teacherList) {
            if (teacher.getId().equals(id)) {
                if (teacher.getPassword().equals(password))
                    return teacher;
                else
                    return null;
            }
        }
        return null;
    }

}
