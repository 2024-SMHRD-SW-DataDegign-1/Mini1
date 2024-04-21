package Mini1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Mini1.MiniDTO;

public class MiniDAO {

	// DAO : Data Access Object (실제 데이터에 접근할 수 있는 객체)
		// DB 에 관련된 기능들을 전부 가지고 있는 클래스 
		Connection conn = null;
		PreparedStatement psmt = null;
		Scanner sc = new Scanner(System.in);
		// 연결
		public void conn() {
		// 리턴값이 필요 없음
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1524:xe";
				String user = "campus_24SW_DD_p1_5";
				String password = "smhrd5";
				
				conn = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		// 닫기
		public void dbClose() {
					try {
						if (psmt != null)
							psmt.close();

						if (conn != null)
							conn.close();

					} catch (SQLException e) {
						e.printStackTrace();
					}

		}
		
		// 회원 가입
		public int insertUser (String id, String pw, String name ) {
			
			String sql = "INSERT INTO USER_INFO VALUES(?, ?, ?)";
			int row = 0;

			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, id);
				psmt.setString(2, pw);
				psmt.setString(3, name);
				
				row = psmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return row;
			
		}
		
		// 로그인 기능
		public String loginUser(String inputId , String inputPw) {
			String sql = "SELECT ID, NICKNAME FROM USER_INFO WHERE ID = ? AND PW = ?";
			ResultSet rs = null;
			// executeQuery 의 자료형
			
			String name = "";
			try {
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, inputId);
				psmt.setString(2, inputPw);
				
				rs = psmt.executeQuery();
				// executeQuery --> 쿼리문을 통해서 테이블에 있는 데이터에 영향을 끼치지 않을 때 사용되어진다.
				// 실행하게 되면 ResultSet 자료형의 rs 는 ID PW NAME AGE 행(컬럼 값)이 된다.
				
//				String name = rs.getString(2);
//				System.out.println("이름 : " + name);
				// ResultSet.next 가 호출되지 않아서 실행되지 않는다. 아이디, 비밀번호가 일치하는지 확인해야한다.
				
				if(rs.next()) {
					// rs.next() : 다음행에 데이터가 있는지 확인하는 기능, 커서 내리기(아이디 비밀번호가 있나요?)
					// executeQuery 쿼리문은 ResultSet 값을 반환하는데 제대로 실행됐다면 if 문으로 들어오게 하자.
					// ResultSet 타입의 rs 가 가지고 있는 기능 중 boolean 형을 if 조건에 넣어준다.
					name = rs.getString(2);
					// rs.getString(2) : 결과 데이터 중 두번째 컬럼에 있는 데이터를 문자열로 받아오겠습니다.
					// AGE가 1번째, NAME이 2번째이므로 몇번째에 있는 데이터를 가져올지 적어준다.
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return name;
			//메소드를 사용하는 공간에서 리턴값 name 을 갖게 하겠다.
			
		}
		
		// 전체 회원 조회 (랭킹조회)
		public ArrayList<MiniRank> userScore() {
			// 사람 한 명의 데이터 DTO를 담고 있는 ArrayList를 리턴할 거야.
			
			String sql = "SELECT *  FROM RANKING WHERE SCORE > 0 ORDER BY SCORE DESC";
			ResultSet rs = null;
			// ResultSet : select 절을 통한 테이블 형식 데이터를 받아 올 수 있는 타입
			
			// 사용자정보 전부 Ex02회원관리로 넘기기
			// ArrayList
			// id, pw, name, age 를 다룰 수 있는 class 생성
			
			MiniRank rank = null;
			
			ArrayList<MiniRank> list = new ArrayList<MiniRank>();
			// dto를 담아줄 ArrayList 생성
			
			try {
//				dao.conn(); --> 같은 클래스이므로 dao 를 불러올 필요없다.
				conn();
				
				psmt = conn.prepareStatement(sql);
				
				rs = psmt.executeQuery();
				
				int ranking = 1;
				while(rs.next()) {
					String id = rs.getString(1);
					String name = rs.getString(2);
					int score = rs.getInt(3);
					// 조회해온 결과(rs)에 담겨있는 데이터를 DTO에 옮겨서 하나로 묶어줌
					rank = new MiniRank(ranking, id, name, score);
					// ArrayList 이용해서 모든 회원 하나로 묶어주기
					list.add(rank);
					ranking++;
					
//					System.out.println("ID : "+id+" PW : "+pw+" NAME : "+name+" AGE : "+age);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				dbClose();
			}
			
//			return dto;
			// 리턴값이 1개라서 덮어져버린다. 1명의 회원정보만 출력된다.
			
			return list;
			
		}
		
		// 회원 정보수정
		public int updateUser (String inputID, String inputName) {
			
			String sql = "UPDATE USER_INFO SET NICKNAME = ? WHERE ID = ?";
			int row = 0;

			try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, inputName);
			psmt.setString(2, inputID);

			row = psmt.executeUpdate();
			
			if (row > 0 ) {
				System.out.println("정보수정 완료");
			} else {
				System.out.println("정보수정 실패");
			}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			return row;
			
		}
		
		// 회원 탈퇴
		public int deleteUser (String deleteID) {
			
			String sql = "DELETE FROM USER_INFO WHERE ID = ?";
			int row = 0;
			
			try {
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, deleteID);
				
				row = psmt.executeUpdate();
				
				if (row > 0 ) {
					System.out.println("회원삭제 완료");
				} else {
					System.out.println("등록된 회원이 아닙니다");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return row;
			
		}
		
		// 랭킹 삭제
		// 회원 정보 삭제
		public int deleteScore (String deleteID) {
			
			String sql = "DELETE FROM RANKING WHERE ID = ?";
			int row = 0;
			
			try {
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, deleteID);
				
				row = psmt.executeUpdate();
				
				if (row > 0 ) {
					System.out.println("랭킹삭제 완료");
				} else {
					System.out.println("랭킹이 등록되어 있지 않습니다.");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return row;
			
		}
		
		// 유저 점수 등록하기
		public int insertScore (String id, String name, int score) {
			
			String sql = "INSERT INTO RANKING VALUES(?, ?, ?)";
			int row = 0;

			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, id);
				psmt.setString(2, name);
				psmt.setInt(3, score);
				
				row = psmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return row;
			
		}
		
		// 설명
		public void explain() {
			
			System.out.println();
			System.out.println("          <<< 세계관 >>>");
			System.out.println();
			System.out.println("시민들의 땅 맨덤(Mandom)은 던전의 몬스터들에게 위협받고 있다.");
			System.out.println("당신은 용사가 되어 이들을 무찔러야 한다.");
			System.out.println("용사가 가져갈 수 있는 아이템은 한정적");
			System.out.println("당신은 던전을 정복하고 승자가 될 수 있을 것인가?");
			System.out.println();
			System.out.println("Press Enter!");
			sc.nextLine();

			System.out.println("<<<<< 게임 방법 >>>>>");
			System.out.println();
			System.out.println("1. 몬스터 3마리를 조우하고 기준 몬스터 정체 공개");
			System.out.println();
			sc.nextLine();
			System.out.println("2. 기준 몬스터를 기준으로 나머지 몬스터는 서열대로 정렬된다");
			System.out.println("  예) 7 , 5, 2 이라면 가운데 5가 기준몬스터가 되고");
			System.out.println("     2, 5, 7 순서대로 놓여지게 된다. 2,7은 공개되지 않는다.");
			System.out.println();
			sc.nextLine();
			System.out.println("3. 던전탐사 / 전투진행 중 액션을 선택한다.");
			System.out.println("   던전탐사 시 몬스터 2마리를 추가로 조우한다.");
			System.out.println("   이때 몬스터에게 아이템을 탈튀당할 수도 있다.");
			System.out.println("   참고) 시작 시 모든 아이템을 가지고 시작한다.");
			System.out.println();
			sc.nextLine();
			System.out.println("4. 전투진행");
			System.out.println("   전투진행 시 그동안 나온 몬스터들과 전투를 진행한다.");
			System.out.println("   유저의 선공으로 시작되며 해당하는 무기가 있으면 몬스터를 일격에 제압한다.");
			System.out.println("   무기가 없다면 몸으로 맞게 되며 몬스터의 전투력()만큼 HP를 잃는다.");
			System.out.println();
			sc.nextLine();
			System.out.println("5. 전투결과");
			System.out.println("   몬스터가 모두 죽으면 VICTORY 승리한다.");
			System.out.println("   점수창에 기록되며 HISTORY 일지에 정보가 입력된다.");
			System.out.println("   유저의 HP 가 모두 소진되면 GAME OVER 패배한다.");
			System.out.println("   패배시 0점 처리된다.");
			System.out.println();
			sc.nextLine();
			
		}
		
		public void monsterExplain() {
			System.out.println("<<<<< 몬스터 정보 >>>>>");
			System.out.println("고블린(1)   : 공격력 1 / 몬스터 수 2");
			System.out.println("해골전사(2)  : 공격력 2 / 몬스터 수 2");
			System.out.println("오크(3)     : 공격력 3 / 몬스터 수 2");
			System.out.println("뱀파이어(4)  : 공격력 4 / 몬스터 수 2");
			System.out.println("골렘(5)     : 공격력 5 / 몬스터 수 2");
			System.out.println("사신(6)     : 공격력 6 / 몬스터 수 1");
			System.out.println("마왕(7)     : 공격력 7 / 몬스터 수 1");
			System.out.println("드래곤(8)    : 공격력 9 / 몬스터 수 1");
		}
		
		public void itemExplain() {
			System.out.println("<<<<< 아이템 정보 >>>>>");
			System.out.println("갑옷 : 용사의 체력을 5만큼 늘려준다.");
			System.out.println("방패 : 용사의 체력을 3만큼 늘려준다.");
			System.out.println("횃불 : 고블린(1), 해골전사(2), 오크(3)을 모두 제거한다.");
			System.out.println("성배 : 해골전사(2), 뱀파이어(4), 사신(6)을 모두 제거한다.");
			System.out.println("창 : 드래곤(8)을 제거한다.");
			System.out.println("검 : 원하는 몬스터 1종류를 모두 제거한다.");
		}
}
