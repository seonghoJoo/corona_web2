package org.corona.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.corona.util.SqlSessionUtil;
import org.corona.vo.Case;
import org.corona.vo.PageVO;

public class CaseDAO {

	public static int insert(Case cases) {
		SqlSession session = null;
		
		try {
			session = SqlSessionUtil.getSession();
			return session.insert("cases.insert",cases);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}//try~catch~finally end
		
		return -1;
	}// insert() end
	
	public static int selectTotal(){
		SqlSession session = null;
		
		try {
			session = SqlSessionUtil.getSession();
			return session.selectOne("cases.selectTotal");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}//try~catch~finally end
		
		return -1;
	}//selectTotal()
	
	public static List<Case> selectList(PageVO pageVO) {
		SqlSession session = null;
		
		try {
			session = SqlSessionUtil.getSession();
			return session.selectList("cases.selectList",pageVO);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}//try~catch~finally end
		
		return null;
	}//selectList();
}
