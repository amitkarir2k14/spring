package app.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import app.pojos.Spitter;
import app.repository.SpitterRepository;

@Repository
public class SpitterRepositoryImpl implements SpitterRepository {

	@Autowired
	private JdbcOperations jdbcOperations;

	private String insertSQL = "INSERT INTO AMIT.SPITTER (FIRSTNAME, "
			+ "LASTNAME, USERNAME, PASSWORD, EMAIL, REGISTERDATE )VALUES (?,?,?,?,?,?)";

	private String queryByUsername = "SELECT * FROM AMIT.SPITTER WHERE USERNAME=?";

	@Override
	public void save(Spitter spitter) {

		jdbcOperations.update(insertSQL, spitter.getFirstName(), spitter.getLastName(), spitter.getUsername(),
				spitter.getPassword(), spitter.getEmail(), new Date());
	}

	@Override
	public Spitter getByUsername(String username) {
		return jdbcOperations.queryForObject(queryByUsername, this::mapSpitter, username);
	}

	private Spitter mapSpitter(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return new Spitter(rs.getLong("id"), rs.getString("firstName"), rs.getString("lastName"),
				rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getDate("registerDate"));
	}

}
