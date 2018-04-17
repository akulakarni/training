package com.pkrm.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;

import com.pkrm.personPojo.JsonToJava;
import com.pkrm.personPojo.JsonToJavaPojo;
import com.pkrm.personPojo.Person;
import com.pkrm.personPojo.RolePojo;
import com.pkrm.sql.PersonSql;

public class PersonDaoImpl implements PersonDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void addUser(final JsonToJavaPojo userobject) {

		Person person = userobject.getPerson();
		String sql = "insert into Person values (?,?,?,?)";
		try {
			int rows = jdbcTemplate.update(sql, new Object[] { person.getUserId(), person.getUserName(),
					person.getFirstName(), person.getLastName() });
			System.out.println("inserted");
		} catch (NullPointerException e) {
			System.out.println("exception");
			e.printStackTrace();
		}

		String sql2 = "insert into RoleMap values(?,(select role_id from UserRole  where role_name=?))";
		try {
			int[] rows2 = jdbcTemplate.batchUpdate(sql2, new BatchPreparedStatementSetter() {

				public void setValues(PreparedStatement ps, int i) throws SQLException {
					ps.setInt(1, userobject.getPerson().getUserId());
					ps.setString(2, userobject.getRoles().get(i));

				}

				public int getBatchSize() {

					return userobject.getRoles().size();

				}
			});

		} catch (NullPointerException e) {
			System.out.println("exception");
			e.printStackTrace();
		}
	}
}

