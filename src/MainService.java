
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import DTO.Student;
import DTO.Teacher;
import DBService.StudentService;
import DBService.TeacherService;

public class MainService {

    public static void register() {
        while (true) {
            System.out.println("---------------------회원가입---------------------");
            Scanner sc = new Scanner(System.in);
            try {
                System.out.print("ID : ");
                String id = sc.next();
                System.out.print("Password : ");
                String pw = sc.next();
                System.out.print("이름 : ");
                String name = sc.next();
                System.out.print("반 : ");
                int classRoom = sc.nextInt();

                Teacher teacher = new Teacher(id, name, pw, classRoom);
                TeacherService teacherService = TeacherService.getInstance();
                if (!teacherService.register(teacher)) { //회원가입에 실패했을 경우
                    throw new IllegalArgumentException("[ERROR] 이미 존재하는 아이디 입니다.");
                } else {
                    System.out.println("[INFO] 회원가입이 완료되었습니다.");
                }
            } catch (InputMismatchException e) { //잘못된 값을 입력했을 경우
                System.out.println("[ERROR] 잘못된 입력값입니다.");
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
    }

    public static Teacher login() {
        while (true) {
            System.out.println("---------------------로그인---------------------");
            Scanner sc = new Scanner(System.in);

            System.out.print("아이디 : ");
            String id = sc.next();

            System.out.print("비밀번호 : ");
            String pw = sc.next();

            TeacherService teacherService = TeacherService.getInstance();
            Teacher teacher = teacherService.login(id, pw);
            if (teacher != null) { //로그인 성공
                return teacher;
            } else { //로그인 실패
                System.out.println("[INFO] 로그인에 실패하였습니다.");
            }
        }
    }

    public static void addStudent() {
        StudentService studentService = new StudentService();

        System.out.println("-------------------학생 추가--------------------");
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("이름 : ");
            String name = sc.next();

            System.out.print("반 : ");
            int classRoom = sc.nextInt();

            System.out.print("국어 점수 : ");
            int korean = sc.nextInt();

            System.out.print("수학 점수 : ");
            int math = sc.nextInt();

            System.out.print("영어 점수 : ");
            int english = sc.nextInt();

            Student student = new Student(classRoom, name, korean, math, english);
            studentService.addStudent(student);
        } catch (InputMismatchException e) {
            System.out.println("[ERROR] 잘못된 입력값입니다.");
        }
    }

    public static void getAllStudents(int classRoom) {
        StudentService studentService = new StudentService();
        ArrayList<Student> studentList = studentService.getAll(classRoom);

        System.out.println("이름\t\t국어\t수학\t영어");
        for(Student student : studentList) {
            System.out.println(student.getNo() + "." + student.getName() + "\t" + student.getKorean() + "\t" + student.getMath() + "\t" + student.getEnglish());
        }
    }

    public static void getOneStudent(int classRoom) {
        Scanner sc = new Scanner(System.in);
        StudentService studentService = new StudentService();

        System.out.print("검색할 학생 이름 : ");
        String name = sc.next();
        Student student = studentService.getOne(classRoom, name);

        if (student == null) {
            System.out.println("[INFO] 정보가 존재하지 않습니다.");
        } else {
            System.out.println("이름\t\t국어\t수학\t영어");
            System.out.println(student.getNo() + "." + student.getName() + "\t" + student.getKorean() + "\t" + student.getMath() + "\t" + student.getEnglish());
        }
    }

}
