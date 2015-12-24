package spring.jdbc.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import spring.jdbc.dao.TeamDAO;
import spring.jdbc.dto.Team;

public class SelectTeamController {
	private BufferedReader keyboard = null;
	private TeamDAO teamDAO = null;
	private int id = 0;
	private String name = null;
	private boolean check = false;
	
	public SelectTeamController(){
		keyboard = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void setTeamDAO(TeamDAO teamDAO){
		this.teamDAO = teamDAO;
	}
	
	public void teamList(){
		List<Team> list = teamDAO.getTeamList();
		
		System.out.println("*******************************");
		System.out.println("ID              구단명");
		System.out.println("------------------------------------------");
		
		for(Team team : list){
			System.out.printf("%d              %s\n", team.getId(), team.getName());
		}
		
		System.out.println("*******************************");
	}
	
	public void teamInsert(){
		
		try {
			System.out.print("추가할 팀의 id(반드시 숫자)를 입력하세요: ");
			id = Integer.parseInt(keyboard.readLine());
			
			System.out.print("추가할 팀의 구단명을 입력하세요: ");
			name = keyboard.readLine();
			
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Team> list = teamDAO.getTeamList();
		
		Team team = new Team();
		for(int i=0; i < list.size(); i++){
			team = list.get(i);
			if(team.getId() == id || team.getName().equals(name)){
				check = true;
			}
		}
		
		if(check == true){
			System.out.println("이미 존재하는 id 혹은 구단명입니다.");
			return;
		}
		
		team.setId(id);
		team.setName(name);
		
		int retValue = teamDAO.teamInsert(team);
		if(retValue == 1){
			teamList();
		}else{
			System.out.println("구단 추가에 실패하였습니다.");
		}
	}
	
	public void teamSearch(){
		System.out.println("검색할 id를 입력하세요. : ");
		
		try {
			id = Integer.parseInt((keyboard.readLine()));
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Team team = teamDAO.teamSearch(id);
		
		System.out.println("=====================");
		System.out.println("ID          구단명");
		System.out.printf("%d          %s\n", team.getId(), team.getName());
		System.out.println("=====================");
	}
	
	public void teamUpdate(){
		try {
			System.out.print("수정할 팀의 id(반드시 숫자)를 입력하세요: ");
			id = Integer.parseInt(keyboard.readLine());
			
			System.out.print("수정할 팀의 구단명을 입력하세요: ");
			name = keyboard.readLine();
			
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Team> list = teamDAO.getTeamList();
		
		Team team = new Team();
		for(int i=0; i < list.size(); i++){
			team = list.get(i);
			if(team.getId() == id){
				check = true;
			}
		}
		
		if(check == false){
			System.out.println("존재하지 않는 id 혹은 구단명입니다.");
			return;
		}
		
		team.setId(id);
		team.setName(name);
		
		int retValue = teamDAO.Update(team);
		
		if(retValue == 1){
			teamList();
		}else{
			System.out.println("구단 수정에 실패하였습니다.");
		}
	}
	
	public void teamDelete(){
		try {
			System.out.print("삭제할 팀의 id(반드시 숫자)를 입력하세요: ");
			id = Integer.parseInt(keyboard.readLine());
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Team> list = teamDAO.getTeamList();
		
		Team team = new Team();
		for(int i=0; i < list.size(); i++){
			team = list.get(i);
			if(team.getId() == id){
				check = true;
			}
		}
		
		if(check == false){
			System.out.println("존재하지 않는 id 혹은 구단명입니다.");
			return;
		}
		
		int retValue = teamDAO.Delete(id);
		
		if(retValue == 1){
			teamList();
		}else{
			System.out.println("구단 삭제에 실패하였습니다.");
		}
	}
}





