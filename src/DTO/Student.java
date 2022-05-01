package DTO;
public class Student {

    private int no;
    private int classRoom;
    private String name;
    private int korean;
    private int math;
    private int english;

    public Student(int classRoom, String name, int korean, int math, int english) {
        this.classRoom = classRoom;
        this.name = name;
        this.korean = korean;
        this.math = math;
        this.english = english;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(int classRoom) {
        this.classRoom = classRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKorean() {
        return korean;
    }

    public void setKorean(int korean) {
        this.korean = korean;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }
}
