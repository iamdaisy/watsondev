package com.n1books.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

@Repository("ibatis")
public class Text2SpeechDAOibatis implements Text2SpeechDAO {
	
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate; //spring bean으로 주입됨

	
	@Override
	public void insertText2Speech(Text2SpeechVO vo) {
		sqlMapClientTemplate.insert("tts.insertText2Speech", vo);

	}

	@Override
	public List<Text2SpeechVO> getText2SpeechList() throws Exception {
		return sqlMapClientTemplate.queryForList("tts.getText2SpeechList"); //여러건
	}

	@Override
	public int deleteText2Speech(int no) throws Exception {
		return sqlMapClientTemplate.delete("tts.deleteText2Speech", no);
	}
	
	

	
	
	
	
	/* 
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertText2Speech(Text2SpeechVO vo) {
		Object[] args = new Object[] {
				vo.getStatement(),
				vo.getLang()
		};
		
		jdbcTemplate.update("insert into tbl_text2speech(statement, lang)values(?,?)", args);
		
	}

	@Override
	public List<Text2SpeechVO> getText2SpeechList() throws Exception {
		RowMapper<Text2SpeechVO> rowMapper = new RowMapper<Text2SpeechVO>() {

			@Override
			public Text2SpeechVO mapRow(ResultSet rs, int rownum) throws SQLException {
				Text2SpeechVO vo = new Text2SpeechVO();
				vo.setNo(rs.getInt("no"));
				vo.setStatement(rs.getString("statement"));
				vo.setLang(rs.getString("lang"));
				return vo;
			}
			
		};
		
		return jdbcTemplate.query(
				"select no, statement, lang from tbl_text2speech " + 
				"order by no desc", rowMapper);
	}
	*/
	
}
