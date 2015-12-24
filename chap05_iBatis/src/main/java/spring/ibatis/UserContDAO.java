package spring.ibatis;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import spring.ibatis.dto.User;

public class UserContDAO {

	private static SqlMapClient sqlMapper;
	

	static {
		try {
			Reader reader = Resources.getResourceAsReader("dbInfo/SqlMapConfig.xml");
			sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		} catch (IOException e) {
			// Fail fast.
			throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserContDAO ucd = new UserContDAO();
		ucd.start();
	}

	public void start() {
		Scanner keyboard = new Scanner(System.in);

		while (true) {
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
				try {
					List<User> list = null;
					list = sqlMapper.queryForList("selectAll");
					
					for(User user : list){
						System.out.println("사용자 ID : "+user.getUserId()+"\t"+
													  "사용자 비번 : "+user.getUserPw()+"\t"+
													  "사용자 이름 : "+user.getUserName());
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				User user = null;
				System.out.println("검색 할 아이디를 입력하세요. ");
				
				keyboard.nextLine();
				String id = keyboard.nextLine();
				try {
					user = (User)sqlMapper.queryForObject("selectUser", id);
					
					if(user == null){
						System.out.println("검색된 아이디가 없습니다.");
					}else{
						System.out.println("사용자 ID : "+user.getUserId()+"\t"+
								  "사용자 비번 : "+user.getUserPw()+"\t"+
								  "사용자 이름 : "+user.getUserName());
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			case 4:
				System.out.println("신규 유저 추가");
				keyboard.nextLine();
				
				User newUser = new User();
				System.out.println("아이디를 입력하세요.");
				String newId = keyboard.nextLine();
				newUser.setUserId(newId);
				
				System.out.println("비밀번호를 입력하세요.");
				String newPw = keyboard.nextLine();
				newUser.setUserPw(newPw);
				
				System.out.println("이름를 입력하세요.");
				String newName = keyboard.nextLine();
				newUser.setUserName(newName);
				
				try {
					sqlMapper.insert("insertUser", newUser);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("입력에 실패하였습니다.");
				}
				break;
			case 5:
				System.out.println("변경할 유저 아이디 입력: ");
				keyboard.nextLine();
				
				String updateId = keyboard.nextLine();
				
				try {
					User updateUser = new User();
					updateUser = (User)sqlMapper.queryForObject("selectUser", updateId);
					
					if(updateUser == null){
						System.out.println("아이디가 존재하지 않습니다.");
					}else{
						System.out.println("이름 입력 : ");
						updateUser.setUserName(keyboard.nextLine());
						
						System.out.println("비밀번호 입력 : ");
						updateUser.setUserPw(keyboard.nextLine());
						
						sqlMapper.update("updateUser", updateUser);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 6:
				System.out.println("삭제할 유저 아이디 입력: ");
				keyboard.nextLine();
				
				String deleteId = keyboard.nextLine();
				
				try {
					User deleteUser = new User();
					deleteUser = (User)sqlMapper.queryForObject("selectUser", deleteId);
					
					if(deleteUser == null){
						System.out.println("아이디가 존재하지 않습니다.");
					}else{
						sqlMapper.delete("deleteUser", deleteId);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 메뉴를 확인해주세요.");
				break;
			}
		}
	}
}
