package Minip;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Minip.Game;
import Minip.MiniRank;
import Minip.Game;
import Minip.MiniDAO;
import Minip.MiniDTO;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		MiniDAO dao = new MiniDAO();

		String AAA = "";
		int num = 0;
		while (true) {
			System.out.print("1. 로그인 2. 회원가입 3. 게임소개 4. 게임 종료 ");
			int menu = sc.nextInt();

			if (menu == 1) {
				// 로그인
				try {
					System.out.print("로그인할 ID입력 >> ");
					String inputId = sc.next();
					System.out.print("로그인할 PW입력 >> ");
					String inputPw = sc.next();

					dao.conn();

					String name = dao.loginUser(inputId, inputPw);
					AAA = inputId;
					if (name.equals("")) {
						System.out.println("로그인 실패");
					} else {
						System.out.println("로그인 성공");
						System.out.println(name + "님 환영합니다");
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
				System.out.println();
				System.out.println("          <<< 세계관 >>>");
				System.out.println();
				System.out.println("시민들의 땅 맨덤(Mandom)은 던전의 몬스터들에게 위협받고 있다.");
				System.out.println("당신은 용사가 되어 이들을 무찔러야 한다.");
				System.out.println("용사가 가져갈 수 있는 아이템은 한정적");
				System.out.println("당신은 던전을 정복하고 승자가 될 수 있을 것인가?");
				System.out.println();
				sc.nextLine();
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

			else if (menu == 4) {
				// 프로그램 종료
				System.out.println("게임이 종료되었습니다.");
				break;
			}

		}
		if (num == 1) {

			while (true) {
				System.out.print("1. 모험 시작 2. 랭킹보기 3. 몬스터정보 4. 아이템 정보 5. 회원 탈퇴 6. 게임 종료 ");
				int menu2 = sc.nextInt();

				if (menu2 == 1) {
					num = 2;
					// 게임실행코드
					Random ran = new Random();

					Game fst = new Game();

					String[] cardListTemp = { "고블린", "고블린", "해골전사", "해골전사", "오크", "오크", "뱀파이어", "뱀파이어", "골렘", "골렘",
							"사신", "마왕", "드레곤" };

					int temp = 0; // 임시 저장 공간
					int turn = 1;
					int lastScore = 0;
					int[] tempNum = new int[3]; // 임시 숫자 저장
					int mid = 0; // 가운데 카드 저장
					String midName = ""; // 가운데 카드 이름

					ArrayList<Integer> monsterList = new ArrayList<Integer>(); // 사냥한 몬스터 종류 반환을 위한 Alist
					int lastItem = 0; // 마지막에 보유한 아이템 반환
					boolean alive = true; // 생사여부 반환

					fst.aArt();
					for (int round = 1; round < 3; round++) {
						fst.rcAdd(1);
						fst.rcAdd(1);
						fst.rcAdd(2);
						fst.rcAdd(2);
						fst.rcAdd(3);
						fst.rcAdd(3);
						fst.rcAdd(4);
						fst.rcAdd(4);
						fst.rcAdd(5);
						fst.rcAdd(5);
						fst.rcAdd(6);
						fst.rcAdd(7);
						fst.rcAdd(8);

						fst.niAdd("횃불");
						fst.niAdd("성배");
						fst.niAdd("창");
						fst.niAdd("검");
						fst.niAdd("갑옷");
						fst.niAdd("방패");

						System.out.println("- - - - - turn " + turn + " - - - - -");
						fst.print();
						// 카드 세장 뽑기 ( 0, 1, 2번에 )
						for (int i = 0; i < 3; i++) {
							tempNum[i] = ran.nextInt(13);
						}

						// 중복 번호 삭제
						for (int i = 1; i < 3; i++) {
							for (int j = 0; j < i; j++) {
								if (tempNum[i] == tempNum[j]) {
									tempNum[i] = ran.nextInt(13);
									j = -1;
								}
							}
						}

						// 뽑은 카드 정보 저장
						for (int i = 0; i < 3; i++) {
							fst.ncAdd(fst.rcGet(tempNum[i])); // 카드 저장
						}

						// 정렬
						for (int i = 0; i < 2; i++) {
							for (int j = i + 1; j < 3; j++) {
								if (tempNum[i] > tempNum[j]) {
									temp = tempNum[i];
									tempNum[i] = tempNum[j];
									tempNum[j] = temp;
								}
							}
						}

						mid = fst.ncGet(1); // 가운데 카드 저장

						// 뽑은 카드는 카드 리스트에서 삭제
						for (int i = fst.ncLength() - 1; i >= 0; i--) {
							fst.rcDel(tempNum[i]); // 남은 카드 목록에서 제거
						}

						fst.arr();

						// 정렬상태 확인
						System.out.print("\nnc 정렬\t: ");
						fst.ncNow();

						mid = fst.ncGet(1);
						midName = cardListTemp[tempNum[1]];

						// 게임 이용자에게 현재 카드 출력
						fst.ncPrint(mid);

						// ----------------------------------------------------------------- //

						System.out.println();
						fst.goStop();

						while (fst.goGet() != 0) {
							turn++;
							System.out.println("\n- - - - - turn " + turn + " - - - - -");

							// 카드 두장 뽑기
							fst.draw(turn);

							// 정렬
							fst.arr();
							// 정렬 상태 확인
							System.out.print("nc 정렬\t: ");
							fst.ncNow();

							// 게임 이용자에게 현재 카드 상태 출력
							fst.ncPrint(mid);

							// 확률적으로 장비를 잃는 코드
							fst.delItem();

							// 5턴이 되면 넘어감
							if (turn != 5) {
								fst.goStop();
//						System.out.println(fst.goGet());
							} else {
								break;
							}
						}

						// - -------------------------------------------------------- //

						System.out.println("\n- - - - - 전투 시작 - - - - -");

						// 잡은 몬스터 리스트 반환을 위해 저장
						monsterList = fst.nowCard;

						// 전투 시 보유중이던 아이템 개수 저장
						lastItem = fst.niLength();

						// 현재 카드 출력 (가운데 카드만 공개)
						fst.ncPrint(mid);

						// 검으로 무찌를 몬스터 선택
						fst.delMonster();
						System.out.println();

						// 방패, 갑옷 보유 시 3~5 hp 증가
						fst.hpPlus();
						System.out.println();

						// 현재 카드 이름, 보유 장비 출력
						System.out.print("몬스터\t: ");
						fst.ncName();
						System.out.print("현재 장비\t: ");
						fst.niNow();

						System.out.println("\n\n전투를 시작합니다\n");

						temp = 100;
						for (int i = 0; i < fst.ncLength(); i++) {
							fst.fight1(i);
							fst.fight2(i);
							fst.fight3(i);
							fst.fight4(i);
							fst.fight5(i);
							fst.fight6(i);
							fst.fight7(i);
							fst.fight8(i);
						}

						// - - - - - - - - - - - - - - -- - - - - - - -- -- - - -- -- - -- - //

						if (fst.getHp() > 0) {
							System.out.println("던전을 클리어했습니다!");
							System.out.println("- - - - - - - -");
							System.out.print("잡은 몬스터\t: ");
							fst.ncName();
							System.out.print("사용한 장비\t: ");
							fst.niNow();
							System.out.println("");

							fst.score();
							System.out.println();

							if (round == 1) {
								fst.getScore();
								lastScore += fst.getScore();
								fst.setScore(0);
								turn = 1;
							} else {
								lastScore += fst.getScore();
								System.out.print("최종 점수 : " + lastScore);

							}

						} else {
							fst.setScore(0); // 0점
							alive = false; // 생사여부 반환을 위해 저장
							turn = 1;
							System.out.println("체력이 0 이하가 되어 패배합니다...\n");
						}

						for (int i = fst.rcLength() - 1; i >= 0; i--) {
							fst.rcDel(i);
						}
						for (int i = fst.riLength() - 1; i >= 0; i--) {
							fst.riDel(i);
						}
						for (int i = fst.ncLength() - 1; i >= 0; i--) {
							fst.ncDel(i);
						}
						for (int i = fst.niLength() - 1; i >= 0; i--) {
							fst.niDel(i);
						}
					}
				}

				else if (menu2 == 2) {
					System.out.println("      <<< 랭킹 보기 >>> ");
					try {
						ArrayList<MiniRank> resultList = dao.userScore();

						System.out.println("아이디 \t 닉네임 \t 점수");

						for (MiniRank d : resultList) {
							System.out.print(d.getId() + "\t");
							System.out.print(d.getName() + "\t");
							System.out.print(d.getScore());
							System.out.println();
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

				} else if (menu2 == 3) {
					System.out.println("<<<<< 몬스터 정보 >>>>>");
					System.out.println("고블린(1)   : 공격력 1 / 몬스터 수 2");
					System.out.println("해골전사(2)  : 공격력 2 / 몬스터 수 2");
					System.out.println("오크(3)     : 공격력 3 / 몬스터 수 2");
					System.out.println("뱀파이어(4)  : 공격력 4 / 몬스터 수 2");
					System.out.println("골렘(5)     : 공격력 5 / 몬스터 수 2");
					System.out.println("사신(6)     : 공격력 6 / 몬스터 수 1");
					System.out.println("마왕(7)     : 공격력 7 / 몬스터 수 1");
					System.out.println("드래곤(8)    : 공격력 9 / 몬스터 수 1");
				} else if (menu2 == 4) {
					System.out.println("<<<<< 아이템 정보 >>>>>");
					System.out.println("갑옷 : 용사의 체력을 5만큼 늘려준다.");
					System.out.println("방패 : 용사의 체력을 3만큼 늘려준다.");
					System.out.println("횃불 : 고블린(1), 해골전사(2), 오크(3)을 모두 제거한다.");
					System.out.println("성배 : 해골전사(2), 뱀파이어(4), 사신(6)을 모두 제거한다.");
					System.out.println("창 : 드래곤(8)을 제거한다.");
					System.out.println("검 : 원하는 몬스터 1종류를 모두 제거한다.");
				} else if (menu2 == 5) {
					System.out.print("정말로 삭제하시겠습니까?  [1]예 [2]아니오 ");
					int num1 = sc.nextInt();
					if (num1 == 1) {
						String deleteID = AAA;

						String sql = "DELETE FROM USER_INFO WHERE ID = ?";
						int row = 0;

						try {
							dao.conn();

							dao.deleteUser(deleteID);

						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							dao.dbClose();
						}
					} else {
						System.out.println("계속 이용해주셔서 감사합니다.");
					}
				} else if (menu2 == 6) {
					System.out.println("게임이 종료되었습니다.");
					break;
				}

			}

		}

	}

}
