package spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import spring.jdbc.dto.Team;

public class TeamDAOImpl implements TeamDAO{
	private JdbcTemplate jdbcTemplate = null;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	/*@Override
	public List<Team> getTeamList() {
		// TODO Auto-generated method stub
		String sql = "select * from team order by team_id asc";
		
		RowMapper<Team> rowMapper = new TeamRowMapper();
		return jdbcTemplate.query(sql, rowMapper);
	}
	
	class TeamRowMapper implements RowMapper{

		@Override
		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			Team team = new Team();
			team.setId(rs.getInt("team_id"));
			team.setName(rs.getString("team_name"));
			return team;
		}
		
	}*/

	@Override
	public List<Team> getTeamList() {
		// TODO Auto-generated method stub
		String sql = "select * from team order by team_id asc";
		
		return jdbcTemplate.query(sql, new RowMapper<Team>(){

			@Override
			public Team mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				Team team = new Team();
				team.setId(rs.getInt("team_id"));
				team.setName(rs.getString("team_name"));
				return team;
			}
		});
	}

	@Override
	public int teamInsert(Team team) {
		// TODO Auto-generated method stub
		String sql = "insert into team values(?, ?)";
		
		return jdbcTemplate.update(sql, team.getId(), team.getName());
	}

	@Override
	public Team teamSearch(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from team where team_id=?";
		
		return jdbcTemplate.queryForObject(sql, new RowMapper<Team>(){

			@Override
			public Team mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub
				Team team = new Team();
				team.setId(rs.getInt("team_id"));
				team.setName(rs.getString("team_name"));
				return team;
			}
		}, id);
	}

	@Override
	public int Update(Team team) {
		// TODO Auto-generated method stub
		String sql = "update team set team_name=? where team_id=?";
		
		return jdbcTemplate.update(sql, team.getName(), team.getId());
	}

	@Override
	public int Delete(int id) {
		// TODO Auto-generated method stub
		String sql = "delete team where team_id=?";
		
		return jdbcTemplate.update(sql, id);
	}

}
