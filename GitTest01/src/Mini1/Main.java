package Mini1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Mini1.Game;
import Mini1.MiniDAO;
import Mini1.MiniDTO;
import Mini1.MiniRank;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		MiniDAO dao = new MiniDAO();
		
		DungeonBgm DBgm = new DungeonBgm();
		
		Game fst = new Game();
		
		String AAA = "";
		String BBB = "";
		int num = 0;
		fst.aArt();
		while (true) {
			DBgm.logBgm();
			System.out.println();
			System.out.print("1. 로그인 2. 회원가입 3. 게임소개 4. 게임 종료 >> ");
			int menu = sc.nextInt();
			System.out.println();

			if (menu == 1) {
				// 로그인
				try {
					System.out.print("ID 입력 >> ");
					String inputId = sc.next();
					System.out.print("PW 입력 >> ");
					String inputPw = sc.next();

					dao.conn();

					String name = dao.loginUser(inputId, inputPw);
					AAA = inputId;
					BBB = name;
					if (name.equals("")) {
						System.out.println("ID 또는 PW가 일치하지 않습니다.");
					} else {
						System.out.println();
						System.out.println("로그인 성공!");
						System.out.println();
						System.out.println();
						System.out.println("용사 " + name + "님 환영합니다");
						break;
					}

				} catch (Exception e) {

				} finally {
					dao.dbClose();
					num = 1;
				}

			} else if (menu == 2) {
				try {
					// 회원가입
					System.out.print("ID 입력 : ");
					String id = sc.next();
					System.out.print("PW 입력 : ");
					String pw = sc.next();
					System.out.print("닉네임 입력 : ");
					String name = sc.next();

					dao.conn();

					int row = dao.insertUser(id, pw, name);

					if (row > 0) {
						System.out.println("회원가입 성공! :)");
					} else {
						System.out.println("회원가입 실패ㅠㅠ");
					}

				} catch (Exception e) {
				} finally {
					dao.dbClose();
				}
			} else if (menu == 3) {
				dao.explain();
			}

			else if (menu == 4) {
				// 프로그램 종료
				System.out.println("게임이 종료되었습니다.");
				DBgm.bgmOff();
				break;
			}

		}
		if (num == 1) {

			while (true) {
				DBgm.bgmOn();
				System.out.println();
				System.out.print("1. 모험 시작 2. 랭킹보기 3. 몬스터정보 4. 아이템 정보 5. 회원 탈퇴 6. 게임 종료 >> ");
				int menu2 = sc.nextInt();

				if (menu2 == 1) {
					num = 2;
					Random ran = new Random();
					
//					Game fst = new Game();

					int turn = 1;
					int lastScore = 0;

					int lastItem = 0; // 마지막에 보유한 아이템 반환
					boolean alive = true; // 생사여부 반환
					ArrayList<Integer> monsterList = new ArrayList<Integer>(); // 사냥한 몬스터 종류 반환을 위한 Alist

					// 게임 시작
					for (int round = 1; round < 3; round++) {
						// 카드 목록, 장비 초기값 입력
						fst.fstList();

						System.out.println(round + " 라운드 시작");
						System.out.println("- - - - - turn " + turn + " - - - - -");
						fst.print();
						System.out.println();

						// 첫 카드 세 장 뽑기
						fst.drawFst();

						// 정렬상태 확인
//						System.out.print("\nnc 정렬\t: ");
//						fst.ncNow();

						// 게임 이용자에게 현재 카드 출력
						fst.ncPrint(fst.getMid());
						System.out.println();
						fst.goStop(); // temp가 0이 아니면 while문으로 들어감

						// -------------------------------------------------------------------------------------
						// //

						while (fst.getTemp() != 0) {
							turn++;
							System.out.println("\n- - - - - turn " + turn + " - - - - -");
							// 카드 두장 뽑기
							fst.draw(turn);

							// 정렬
							fst.arr();

							// 정렬 상태 확인
//							System.out.print("nc 정렬\t: ");
//							fst.ncNow();

							// 게임 이용자에게 현재 카드 상태 출력
							fst.ncPrint(fst.getMid());

							// 확률적으로 장비를 잃는 코드
							fst.delItem();

							// 5턴이 되면 넘어감
							if (turn != 5) {
								fst.goStop();
							} else {
								break;
							}
						}
						fst.setTemp(0);

						// -------------------------------------------------------------------------------------
						// //
						System.out.println("\n- - - - - 전투 시작 - - - - -");
						// 잡은 몬스터 리스트 반환을 위해 저장
						monsterList = fst.ncLast();

						// 전투 시 보유중이던 아이템 개수 저장
						lastItem = fst.niLength();

						// 현재 카드 출력 (가운데 카드만 공개)
						fst.ncPrint(fst.getMid());
						System.out.println();

						// 장비 선택 버리기
						fst.selItem();

						// 검으로 무찌를 몬스터 선택
						fst.delMonster();

						// 방패, 갑옷 보유 시 3~5 hp 증가
						fst.hpPlus();

						// 현재 카드 이름, 보유 장비 출력
						System.out.print("\n몬스터\t: ");
						fst.ncName();
						System.out.print("현재 장비\t: ");
						fst.niNow();

						// -------------------------------------------------------------------------------------
						// //

						System.out.println("\n\n전투를 시작합니다\n");
						fst.setTemp(0);

						for (int i = 0; i < fst.ncLength(); i++) {
							fst.fight1(i);
							if (fst.ncGet(i) == 1 && fst.getHp() > 0) {
								fst.setTemp(1);
							}
						}
						// 전투 개행
						fst.enter();
						fst.setTemp(1);
						fst.enter();

						for (int i = 0; i < fst.ncLength(); i++) {
							fst.fight2(i);
							if (fst.ncGet(i) == 2 && fst.getHp() > 0) {
								fst.setTemp(1);
							}
						}
						fst.enter();

						for (int i = 0; i < fst.ncLength(); i++) {
							fst.fight3(i);
							if (fst.ncGet(i) == 3 && fst.getHp() > 0) {
								fst.setTemp(1);
							}
						}
						fst.enter();
						
						for (int i = 0; i < fst.ncLength(); i++) {
							fst.fight4(i);
							if (fst.ncGet(i) == 4 && fst.getHp() > 0) {
								fst.setTemp(1);
							}
						}
						fst.enter();

						for (int i = 0; i < fst.ncLength(); i++) {
							fst.fight5(i);
							if (fst.ncGet(i) == 5 && fst.getHp() > 0) {
								fst.setTemp(1);
							}
						}
						fst.enter();

						for (int i = 0; i < fst.ncLength(); i++) {
							fst.fight6(i);
							if (fst.ncGet(i) == 6 && fst.getHp() > 0) {
								fst.setTemp(1);
							}
						}
						fst.enter();

						for (int i = 0; i < fst.ncLength(); i++) {
							fst.fight7(i);
							if (fst.ncGet(i) == 7 && fst.getHp() > 0) {
								fst.setTemp(1);
							}
						}
						fst.enter();

						for (int i = 0; i < fst.ncLength(); i++) {
							fst.fight8(i);
							if (fst.ncGet(i) == 8 && fst.getHp() > 0) {
								fst.setTemp(1);
							}
						}
						fst.enter();

						// -------------------------------------------------------------------------------------
						// //

						if (fst.getHp() > 0) {
							System.out.println("던전을 클리어했습니다 ㅇㅅㅇ");
							System.out.println("- - - - - - - -");
							System.out.print("잡은 몬스터\t: ");
							fst.ncName();
							System.out.print("사용한 장비\t: ");
							fst.niNow();
							System.out.println("");

							fst.score();
							System.out.println();

							fst.getTemp();
							lastScore += fst.getTemp();
							fst.setTemp(0);
							turn = 1;

							if (round == 2) {
								lastScore += fst.getTemp();
								System.out.print("최종 점수 : " + lastScore);
								System.out.println();
								try {
								dao.conn();
								
								int row = dao.insertScore(AAA, BBB, lastScore);
								
								if (row > 0) {
									System.out.println();
									System.out.println("랭킹등록 성공! :)");
									
								} else {
									System.out.println();
									System.out.println("랭킹등록 오류 ㅠ");
								}
								} catch (Exception e) {
									e.printStackTrace();
								} finally {
									dao.dbClose();
								}
			//
							}

						} else {
							fst.setTemp(0); // 0점
							alive = false; // 생사여부 반환을 위해 저장
							turn = 1;
							System.out.println("패배 ㅋㅅㅋ\n");
						}

						fst.setHp(3);
						fst.rcReset();
						fst.riReset();
						fst.ncReset();
						fst.niReset();
						if (round == 1) {
							System.out.println("다음 라운드 >> ");
						}
						sc.nextLine();
					}
				}

				else if (menu2 == 2) {
					System.out.println();
					System.out.println("      <<< 랭킹 보기 >>> ");
					try {
						ArrayList<MiniRank> resultList = dao.userScore();

						System.out.println("순위 \t 아이디 \t 닉네임 \t 점수");

						for (MiniRank d : resultList) {
							System.out.print("  "+d.getRanking() + "\t");
							System.out.print(d.getId() + "\t");
							System.out.print(" "+d.getName() + "\t");
							System.out.print(" "+ d.getScore());
							System.out.println();
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

				} else if (menu2 == 3) {
					System.out.println();
					dao.monsterExplain();
				} else if (menu2 == 4) {
					System.out.println();
					dao.itemExplain();
				} else if (menu2 == 5) {
					System.out.println();
					System.out.print("정말로 삭제하시겠습니까?  [1]예 [2]아니오 ");
					int num1 = sc.nextInt();
					if (num1 == 1) {
						String deleteID = AAA;

						String sql = "DELETE FROM USER_INFO WHERE ID = ?";
						int row = 0;

						try {
							dao.conn();

							dao.deleteScore(deleteID);

							dao.deleteUser(deleteID);

						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							dao.dbClose();
							System.out.println("게임이 종료됩니다.");
							break;
						}
					} else {
						System.out.println("계속 이용해주셔서 감사합니다.");
					}
				} else if (menu2 == 6) {
					System.out.println("게임이 종료되었습니다.");
					DBgm.bgmOff();
					break;
				}

			}

		}

	}
}
