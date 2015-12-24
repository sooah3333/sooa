package spring.jdbc.view;

import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.jdbc.controller.SelectTeamController;

public class Menu {
	private int number = 0;
	private SelectTeamController selectTeam;
	
	public void setSelectTeam(SelectTeamController selectTeam){
		this.selectTeam = selectTeam;
	}
	
	public void execute(int num){
		switch(num){
			case 1:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			case 2:
				selectTeam.teamList();
				break;
			case 3:
				selectTeam.teamInsert();
				break;
			case 4:
				selectTeam.teamSearch();
				break;
			case 5:
				selectTeam.teamUpdate();
				break;
			case 6:
				selectTeam.teamDelete();
				break;
			default:
				System.out.println("잘못된 값을 입력하셨습니다.");
				break;
		}
	}
	
	public void showMenu(){
		while(true){
			System.out.println("======================");
			System.out.println("1. 프로그램 종료.");
			System.out.println("2. KBO 구단 보기");
			System.out.println("3. KBO 구단 추가");
			System.out.println("4. KBO 구단 검색");
			System.out.println("5. KBO 구단 수정");
			System.out.println("6. KBO 구단 삭제");
			System.out.println("======================");
			System.out.println("번호 입력 후 enter: ");
			
			Scanner keyboard = new Scanner(System.in);
			number = keyboard.nextInt();
			
			execute(number);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context = 
							new ClassPathXmlApplicationContext("applicationcontext.xml");
		
		Menu menu = (Menu)context.getBean("menu");
		menu.showMenu();
		
		context.close();
	}
}





