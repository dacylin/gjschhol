package dao;

import java.util.List;

import model.student;

public interface studentDao {//介面定義抽象方法
		//create
		void add(student s);
		
		//read
		String queryAll1();
		List<student> queryAll2();
		
		
		//update
		
		
		//delete
}
