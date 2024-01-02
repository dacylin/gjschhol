package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.studentDao;
import model.student;

public class studentDaoImpl implements studentDao {

	public static void main(String[] args) {
		//student s=new student("teacher",78,90);//新增
		//new studentDaoImpl().add(s);//新增
		
		
		
		//System.out.println(new studentDaoImpl().queryAll1());
		
		List<student> l=new studentDaoImpl().queryAll2();
		int sum=0;
		for(student o:l)
		{
			System.out.println("id"+o.getId()+
					"name"+o.getName()+
					"chi"+o.getChi()+
					"eng"+o.getEng()+"總"+(o.getChi()+o.getEng()));
			
			sum=sum+o.getChi()+o.getEng();
		}
		
		System.out.println("總"+sum);

	}

	@Override
	public void add(student s) {//新增 17 18
		Connection conn=DbConnection.getDb();
		String SQL="insert into student(name,chi,eng) values(?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1,s.getName());//對印 23的問號
			ps.setInt(2, s.getChi()); //對印 23的問號
			ps.setInt(3, s.getEng()); //對印 23的問號
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	@Override
	public String queryAll1() {//查詢s 22
		Connection conn=DbConnection.getDb();
		String SQL="select * from student";
		String show="";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				show=show+"id:"+rs.getInt("id")+
						"\t名:"+rs.getString("name")+
						"\t國文:"+rs.getInt("chi")+
						"\t英文:"+rs.getInt("eng")+"\n";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return show;
	}

	@Override
	public List<student> queryAll2() {//查詢L 24
		Connection conn=DbConnection.getDb();
		String SQL="select * from student";
		List<student> l=new ArrayList();
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) 
			{
				student s=new student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setChi(rs.getInt("chi"));
				s.setEng(rs.getInt("eng"));
				
				l.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return l;
	}

}
