package com.pkrm.Dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pkrm.jms.Listener;
import com.pkrm.personPojo.JsonToJavaPojo;
import com.pkrm.personPojo.Person;



public class PersonDaoImpl implements PersonDao {
	private static org.apache.log4j.Logger logger = Logger.getLogger(PersonDaoImpl.class);
	private static org.apache.log4j.Logger toFile = Logger.getLogger(PersonDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
	public void addUser(final JsonToJavaPojo user) {
		Person person = user.getPerson();
		String sql = "insert into Person values (?,?,?,?)";
		try {
			int rows = jdbcTemplate.update(sql, new Object[] { person.getUserId(), person.getUserName(),
					person.getFirstName(), person.getLastName() });
			logger.info("inserted");
			
		} catch (NullPointerException e) {
			logger.error("exception");
			toFile.error(e.getMessage());
		}

		String sql2 = "insert into RoleMap values(?,(select role_id from UserRole  where role_name=?))";
		try {
			int[] rows2 = jdbcTemplate.batchUpdate(sql2, new BatchPreparedStatementSetter() {

				public void setValues(PreparedStatement ps, int i) throws SQLException {
					ps.setInt(1, user.getPerson().getUserId());
					ps.setString(2, user.getRoles().get(i));

				}

				public int getBatchSize() {

					return user.getRoles().size();

				}
			});

		} catch (NullPointerException e) {
			logger.error("exception");
			toFile.error(e.getMessage());
		}
	}		
	}


