package com.bg.plzSeatdown.message.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bg.plzSeatdown.common.vo.PageInfo;
import com.bg.plzSeatdown.message.model.vo.Message;

@Repository
public class MessageDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	/**
	 * @param payload
	 * @return
	 * @throws Exception
	 */
	public CharSequence countReceiveNote(String payload) throws Exception{
		return sqlSession.selectOne("messageMapper.countReceiveNote", payload);
	}

	/** 쪽지 리스트 갯수 조회 DAO
	 * @return listCount
	 * @throws Exception
	 */
	 public int getListCount(String nickName) throws Exception{
	        return sqlSession.selectOne("messageMapper.getListCount", nickName);
	    }

	/** 쪽지 리스트 조회 DAO
	 * @param pInf
	 * @return list
	 * @throws Exception
	 */
	    public List<Message> selectList(String nickName, PageInfo pInf) throws Exception{
	        int offset = (pInf.getCurrentPage()-1) * pInf.getLimit();
	        RowBounds rowBounds = new RowBounds(offset, pInf.getLimit());
	        return sqlSession.selectList("messageMapper.selectList", nickName, rowBounds);
	    }


	public int selectNextNo() throws Exception{
		return sqlSession.selectOne("messageMapper.selectNextNo");
	}

	public int insertMessage(Message message) throws Exception{
		return sqlSession.insert("messageMapper.insertMessage", message);
	}

	public int getListCount2(String nickName) {
		return sqlSession.selectOne("messageMapper.getListCount2", nickName);
	}

	public List<Message> selectList2(String nickName, PageInfo pInf) {
		int offset = (pInf.getCurrentPage()-1) * pInf.getLimit();
        RowBounds rowBounds = new RowBounds(offset, pInf.getLimit());
        return sqlSession.selectList("messageMapper.selectList2", nickName, rowBounds);
	}

}
