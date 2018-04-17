package com.pkrm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.pkrm.personPojo.Person;

@Component
public class PersonDaoImpl implements PersonDao {
	private static org.apache.log4j.Logger logger = Logger.getLogger(PersonDaoImpl.class);
	private static org.apache.log4j.Logger toFile = Logger.getLogger(PersonDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Person addUser(Person person) {
		Person user = new Person();
		String sql = "insert into Person values (?,?,?,?)";

		int rows = jdbcTemplate.update(sql,
				new Object[] { person.getUserId(), person.getUserName(), person.getFirstName(), person.getLastName() });
		logger.info("inserted");

		String sql2 = "insert into RoleMap values(?,(select role_id from UserRole  where role_name=?))";

		int rows2 = jdbcTemplate.update(sql2, new Object[] { person.getUserId(), person.getRole() });
		return user;

	}

	public Person editUser(Person person) {
		final String sql = "update person set user_name=?,first_name=?,last_name=? where user_id=?";
		jdbcTemplate.update(sql,
				new Object[] { person.getUserName(), person.getFirstName(), person.getLastName(), person.getUserId() });
		logger.info("updated record for userId:" + person.getUserId());
		return null;

	}

	public Person deleteuser(int userId) {
		String sql = "delete from person where user_id=?";
		jdbcTemplate.update(sql, new Object[] { userId });
		logger.info("deleted person with userId=" + userId);
		return null;

	}

	public List<Person> getUsers() {
		final String sql = "select p.user_id,p.user_name,p.first_name,p.last_name,r.role_name from person p,userrole r,rolemap m where p.user_id=m.user_id and m.role_id=r.role_id";
		final List<Person> persons = jdbcTemplate.query(sql, new RowMapper<Person>() {

			public Person mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				final Person person = new Person();
				person.setUserId(resultSet.getInt("user_id"));
				person.setUserName(resultSet.getString("user_name"));
				person.setFirstName(resultSet.getString("first_name"));
				person.setLastName(resultSet.getString("last_name"));
				person.setRole(resultSet.getString("role_name"));
				return person;
			}

		});
		return persons;

	}

	public Person getUser(int userId) {
		// final String sql="select * from person where user_id="+userId;
		final String sql = "select p.user_id,p.user_name,p.first_name,p.last_name,r.role_name from person p LEFT JOIN rolemap m on m.user_id=p.user_id LEFT JOIN userrole r on  r.role_id=m.role_id where p.user_id="+userId;
				
		return jdbcTemplate.queryForObject(sql, new RowMapper<Person>() {
			public Person mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {
				final Person person = new Person();
				person.setUserId(resultSet.getInt("user_id"));
				person.setUserName(resultSet.getString("user_name"));
				person.setFirstName(resultSet.getString("first_name"));
				person.setLastName(resultSet.getString("last_name"));
				person.setRole(resultSet.getString("role_name"));
				return person;
			}
		});

	}

}
