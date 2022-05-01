package DBService;

import java.util.HashMap;

import DTO.Teacher;

public class TeacherService {
	
	private static final TeacherService teacherService = new TeacherService();

    private TeacherService() {}

    public static TeacherService getInstance() {
        return teacherService;
    }
    
	//회원가입
    public boolean register(Teacher teacher) {
    	
    	DBConnection db = new DBConnection();
    	HashMap<String, Object> map = db.selectOne("select * from teacher where id = '" + teacher.getId() + "'");
    	if (map.size() != 0) {
    		return false;
    	} else {
    		String sql = String.format("insert into teacher values ('%s', '%s', '%s', '%d')", 
    				teacher.getId(),
    				teacher.getPassword(),
    				teacher.getName(),
    				teacher.getClassRoom());
    		if (db.insert(sql) > 0)
    			return true;
    		else
    			return false;
    	}
    }
    
    //로그인
    public Teacher login(String id, String password) {
        
    	DBConnection db = new DBConnection();
    	HashMap<String, Object> map = db.selectOne("select * from teacher where id = '" + id + "' and password = '" + password + "'");
    	if (map == null) {
    		return null;
    	} else {
    		Teacher teacher = new Teacher(
    				(String)map.get("id"),
    				(String)map.get("name"),
    				(String)map.get("password"),
    				(int)map.get("classroom")
    		);
    		return teacher;
    	}
    }

	
}
