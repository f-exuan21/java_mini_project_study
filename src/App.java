import java.util.Scanner;

import DTO.Teacher;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Teacher teacher = null;

        while (true) {
            System.out.println("-----------------성적 조회 프로그램-----------------");

            if (teacher == null) {
                System.out.println("1) 회원가입     2)로그인     3)종료");

                int input = sc.nextInt();

                if (input == 1) { //회원가입
                    MainService.register();
                } else if (input == 2) { //로그인
                    teacher = MainService.login();
                } else if (input == 3) { //종료
                    System.out.println("[INFO] 시스템을 종료합니다.");
                    System.exit(0);
                } else { //잘못된 입력
                    System.out.println("[ERROR] 잘못된 입력입니다.");
                }
            } else {
                System.out.println("1) 학생 점수 등록     2) 모든 학생 점수 출력     3) 특정 학생 점수 출력     4) 종료");

                int input = sc.nextInt();

                if (input == 1) {
                    MainService.addStudent();
                } else if (input == 2) {
                    MainService.getAllStudents(teacher.getClassRoom());
                } else if (input == 3) {
                    MainService.getOneStudent(teacher.getClassRoom());
                } else if (input == 4) {
                    System.out.println("[INFO] 시스템을 종료합니다.");
                    System.exit(0);
                } else {
                    System.out.println("[ERROR] 잘못된 입력입니다.");
                }
            }
        }
    }
}
