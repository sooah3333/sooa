package spring.jdbc.dao;

import java.util.List;

import spring.jdbc.dto.Team;

public interface TeamDAO {
	List<Team> getTeamList();
	int teamInsert(Team team);
	Team teamSearch(int id);
	int Update(Team team);
	int Delete(int id);
}
