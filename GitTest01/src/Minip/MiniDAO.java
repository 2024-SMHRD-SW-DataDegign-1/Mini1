package Minip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Minip.MiniDTO;

public class MiniDAO {

	// DAO : Data Access Object (실제 데이터에 접근할 수 있는 객체)
		// DB 에 관련된 기능들을 전부 가지고 있는 클래스 
		Connection conn = null;
		PreparedStatement psmt = null;
		
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
			
			String sql = "SELECT *  FROM RANKING ORDER BY SCORE DESC";
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
				// executeQuery --> 쿼리문을 통해서 테이블에 있는 데이터에 영향을 끼치지 않을 때 사용되어진다.
				// 실행하게 되면 ResultSet 자료형의 rs 는 ID PW NAME AGE 행이 된다.
				
				while(rs.next()) {
					String id = rs.getString(1);
					String name = rs.getString(2);
					int score = rs.getInt(3);
					// 조회해온 결과(rs)에 담겨있는 데이터를 DTO에 옮겨서 하나로 묶어줌
					rank = new MiniRank(id, name, score);
					
					// ArrayList 이용해서 모든 회원 하나로 묶어주기
					list.add(rank);
					
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
		
		// 회원 정보 삭제
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
					System.out.println("회원삭제 실패");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return row;
			
		}
		
}
