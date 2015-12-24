package spring.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import spring.mybatis.dto.Account;

public class AccountContDAO {
	static SqlSession session = null;
	Scanner keyboard = null;
	Account account = new Account();
	String id = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String resource = "dbInfo/MyBatisConfig.xml";
		InputStream inputStream = null;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		session = sqlSessionFactory.openSession();
		
		AccountContDAO acc = new AccountContDAO();
		acc.start();
	}
	
	public void start() {
		keyboard = new Scanner(System.in);
		
		while(true){
			System.out.println("========================");
			System.out.println("1. 프로그램 종료.");
			System.out.println("2. 모든 유저 출력.");
			System.out.println("3. 특정 유저 출력.");
			System.out.println("4. 유저 추가.");
			System.out.println("5. 유저 수정.");
			System.out.println("6. 유저 삭제.");
			System.out.println("========================");
			System.out.println("메뉴를 선택하세요. : ");

			int num = keyboard.nextInt();

			switch (num) {
			case 1:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			case 2:
				List<Account> list = null;
				list = session.selectList("selectAll");
				
				for(Account account : list){
					System.out.println("사용자 ID : "+account.getId()+"\t"+
												  "사용자 비번 : "+account.getPwd()+"\t"+
												  "사용자 이름 : "+account.getName());
				}
				break;
			case 3:
				System.out.println("검색 할 아이디를 입력하세요. ");
				keyboard.nextLine();
				
				id = keyboard.nextLine();
				account = (Account)session.selectOne("selectUser", id);
				
				if(account == null){
					System.out.println("검색된 아이디가 없습니다.");
				}else{
					System.out.println("사용자 ID : "+account.getId()+"\t"+
							  "사용자 비번 : "+account.getPwd()+"\t"+
							  "사용자 이름 : "+account.getName());
				}
				break;
			case 4:
				System.out.println("신규 유저 추가");
				keyboard.nextLine();
				
				System.out.println("아이디를 입력하세요.");
				account.setId(keyboard.nextLine());
				
				System.out.println("비밀번호를 입력하세요.");
				account.setPwd(keyboard.nextLine());
				
				System.out.println("이름를 입력하세요.");
				account.setName(keyboard.nextLine());
				
				session.insert("insertUser", account);
				session.commit();
				break;
			case 5:
				System.out.println("변경할 유저 아이디 입력: ");
				keyboard.nextLine();
				
				id = keyboard.nextLine();
				
				account = (Account)session.selectOne("selectUser", id);
				
				if(account == null){
					System.out.println("아이디가 존재하지 않습니다.");
				}else{
					System.out.println("이름 입력 : ");
					account.setName(keyboard.nextLine());
					
					System.out.println("비밀번호 입력 : ");
					account.setPwd(keyboard.nextLine());
					
					session.update("updateUser", account);
					session.commit();
				}
				break;
			case 6:
				System.out.println("삭제할 유저 아이디 입력: ");
				keyboard.nextLine();
				
				id = keyboard.nextLine();
				
				account = (Account)session.selectOne("selectUser", id);
				
				if(account == null){
					System.out.println("아이디가 존재하지 않습니다.");
				}else{
					session.delete("deleteUser", id);
					session.commit();
				}
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 메뉴를 확인해주세요.");
				break;
			}
		}
	}
}





