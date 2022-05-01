package DBService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import DTO.Student;

public class StudentService {
	
	
	public void addStudent(Student student) {
        DBConnection db = new DBConnection();
		String sql = String.format("insert into student values (null, '%s', %d, %d, %d, %d)"
				, student.getName()
				, student.getClassRoom()
				, student.getKorean()
				, student.getMath()
				, student.getEnglish());
        db.insert(sql);
    }
	
	public ArrayList<Student> getAll(int classRoom) {
		DBConnection db = new DBConnection();
        ArrayList<HashMap<String, Object>> list = db.selectAll("select * from student where classroom = " + classRoom);
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
        	HashMap<String, Object> map = list.get(0);
        	Student student = new Student((int)map.get("classroom")
        			, (String)map.get("name")
        			, (int)map.get("korean")
        			, (int)map.get("math")
        			, (int)map.get("english"));
        	student.setNo((int)map.get("no"));
        	students.add(student);
        }
        return students;
    }
	
	
	public Student getOne(int classRoom, String name) {
        DBConnection db = new DBConnection();
        HashMap<String, Object> map = db.selectOne("select * from student where name = '" + name + "' and classroom = " + classRoom);
        if (map.size() > 0) {
        	Student student = new Student((int)map.get("classroom")
        			, (String)map.get("name")
        			, (int)map.get("korean")
        			, (int)map.get("math")
        			, (int)map.get("english"));
        	student.setNo((int)map.get("no"));
        	return student;
        } else {
        	return null;
        }
    }
	
}
