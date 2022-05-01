package DTO;
public class Teacher {

    private String id;
    private String name;
    private String password;
    private int classRoom;

    public Teacher(String id, String name, String password, int classRoom) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.classRoom = classRoom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(int classRoom) {
        this.classRoom = classRoom;
    }
}
