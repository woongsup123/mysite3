package com.bigdata2017.mysite.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bigdata2017.mysite.vo.BoardVo;

@Repository
public class BoardDao {
	@Autowired
	private SqlSession sqlSession;
	
	public int delete( BoardVo vo ) {
		int count = sqlSession.delete("board.delete", vo);
		return count;
	}
}
