package Minip;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
	String[] cardList = { "고블린", "해골전사", "오크", "뱀파이어", "골렘", "사신", "마왕", "드래곤" };

	String[] cardListName = { "고블린", "고블린", "해골전사", "해골전사", "오크", "오크", "뱀파이어", "뱀파이어", "골렘", "골렘", "사신", "마왕", "드래곤" };

	boolean exi = false;

	private int score = 0;

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	private int hp = 3;

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	Scanner sc = new Scanner(System.in);
	Random ran = new Random();

	String select = "";

	ArrayList<Integer> nowCard = new ArrayList<Integer>();

	public void ncAdd(int num) {
		nowCard.add(num);
	}

	public void ncAdd(int index, int num) {
		nowCard.add(index, null);
	}

	public void ncDel(int num) {
		nowCard.remove(num);
	}

	public int ncLength() {
		return nowCard.size();
	}

	public int ncGet(int num) {
		return nowCard.get(num);
	}

	public ArrayList<Integer> ncLast() {
		return nowCard;
	}

	ArrayList<Integer> remainCard = new ArrayList<Integer>();

	public void rcAdd(int num) {
		remainCard.add(num);
	}

	public void rcAdd(int index, int num) {
		remainCard.add(index, null);
	}

	public void rcDel(int num) {
		remainCard.remove(num);
	}

	public int rcLength() {
		return remainCard.size();
	}

	public int rcGet(int num) {
		return remainCard.get(num);
	}

	ArrayList<String> nowItem = new ArrayList<String>();

	public void niAdd(String name) {
		nowItem.add(name);
	}

	public void niAdd(int index, String name) {
		nowItem.add(index, name);
	}

	public void niDel(int num) {
		nowItem.remove(num);
	}

	public int niLength() {
		return nowItem.size();
	}

	public String niGet(int num) {
		return nowItem.get(num);
	}

	ArrayList<String> remainItem = new ArrayList<String>();

	public void riAdd(String name) {
		remainItem.add(name);
	}

	public void riAdd(int index, String name) {
		remainItem.add(index, name);
	}

	public void riDel(int num) {
		remainItem.remove(num);
	}

	public int riLength() {
		return remainItem.size();
	}

	public String riGet(int num) {
		return remainItem.get(num);
	}

	private int go = 100; // 진행, 종료 선택여부 판단

	public int goGet() {
		return go;
	}

	int count = 0;
	int temp = 0; // 임시 저장 공간

	int[] tempNum = new int[3]; // 임시 숫자 저장
	String midName = ""; // 가운데 카드 이름

	// ASCII Art
	public void aArt() {
		System.out.println(
				" .----------------.  .----------------.  .-----------------. .----------------.  .----------------.  .----------------.  .-----------------.\r\n"
						+ "| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |\r\n"
						+ "| |  ________    | || | _____  _____ | || | ____  _____  | || |    ______    | || |  _________   | || |     ____     | || | ____  _____  | |\r\n"
						+ "| | |_   ___ `.  | || ||_   _||_   _|| || ||_   \\|_   _| | || |  .' ___  |   | || | |_   ___  |  | || |   .'    `.   | || ||_   \\|_   _| | |\r\n"
						+ "| |   | |   `. \\ | || |  | |    | |  | || |  |   \\ | |   | || | / .'   \\_|   | || |   | |_  \\_|  | || |  /  .--.  \\  | || |  |   \\ | |   | |\r\n"
						+ "| |   | |    | | | || |  | '    ' |  | || |  | |\\ \\| |   | || | | |    ____  | || |   |  _|  _   | || |  | |    | |  | || |  | |\\ \\| |   | |\r\n"
						+ "| |  _| |___.' / | || |   \\ `--' /   | || | _| |_\\   |_  | || | \\ `.___]  _| | || |  _| |___/ |  | || |  \\  `--'  /  | || | _| |_\\   |_  | |\r\n"
						+ "| | |________.'  | || |    `.__.'    | || ||_____|\\____| | || |  `._____.'   | || | |_________|  | || |   `.____.'   | || ||_____|\\____| | |\r\n"
						+ "| |              | || |              | || |              | || |              | || |              | || |              | || |              | |\r\n"
						+ "| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |\r\n"
						+ " .----------------.  .----------------.  '----------------'  '----------------'  '----------------'  '----------------'  '----------------' \r\n"
						+ "| .--------------. || .--------------. |                                                                                                    \r\n"
						+ "| |     ____     | || |  _________   | |                                                                                                    \r\n"
						+ "| |   .'    `.   | || | |_   ___  |  | |                                                                                                    \r\n"
						+ "| |  /  .--.  \\  | || |   | |_  \\_|  | |                                                                                                    \r\n"
						+ "| |  | |    | |  | || |   |  _|      | |                                                                                                    \r\n"
						+ "| |  \\  `--'  /  | || |  _| |_       | |                                                                                                    \r\n"
						+ "| |   `.____.'   | || | |_____|      | |                                                                                                    \r\n"
						+ "| |              | || |              | |                                                                                                    \r\n"
						+ "| '--------------' || '--------------' |                                                                                                    \r\n"
						+ " .----------------.  .----------------.  .-----------------. .----------------.  .----------------.  .----------------.                     \r\n"
						+ "| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |                    \r\n"
						+ "| | ____    ____ | || |      __      | || | ____  _____  | || |  ________    | || |     ____     | || | ____    ____ | |                    \r\n"
						+ "| ||_   \\  /   _|| || |     /  \\     | || ||_   \\|_   _| | || | |_   ___ `.  | || |   .'    `.   | || ||_   \\  /   _|| |                    \r\n"
						+ "| |  |   \\/   |  | || |    / /\\ \\    | || |  |   \\ | |   | || |   | |   `. \\ | || |  /  .--.  \\  | || |  |   \\/   |  | |                    \r\n"
						+ "| |  | |\\  /| |  | || |   / ____ \\   | || |  | |\\ \\| |   | || |   | |    | | | || |  | |    | |  | || |  | |\\  /| |  | |                    \r\n"
						+ "| | _| |_\\/_| |_ | || | _/ /    \\ \\_ | || | _| |_\\   |_  | || |  _| |___.' / | || |  \\  `--'  /  | || | _| |_\\/_| |_ | |                    \r\n"
						+ "| ||_____||_____|| || ||____|  |____|| || ||_____|\\____| | || | |________.'  | || |   `.____.'   | || ||_____||_____|| |                    \r\n"
						+ "| |              | || |              | || |              | || |              | || |              | || |              | |                    \r\n"
						+ "| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |                    \r\n"
						+ " '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'         ");
		System.out.println();
		System.out.println(
				" .----------------.  .----------------.  .----------------.  .----------------.   .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------. \r\n"
						+ "| .--------------. || .--------------. || .--------------. || .--------------. | | .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |\r\n"
						+ "| |    ______    | || |      __      | || | ____    ____ | || |  _________   | | | |    _______   | || |  _________   | || |  _______     | || |      __      | || |  _________   | || |              | |\r\n"
						+ "| |  .' ___  |   | || |     /  \\     | || ||_   \\  /   _|| || | |_   ___  |  | | | |   /  ___  |  | || | |  _   _  |  | || | |_   __ \\    | || |     /  \\     | || | |  _   _  |  | || |      _       | |\r\n"
						+ "| | / .'   \\_|   | || |    / /\\ \\    | || |  |   \\/   |  | || |   | |_  \\_|  | | | |  |  (__ \\_|  | || | |_/ | | \\_|  | || |   | |__) |   | || |    / /\\ \\    | || | |_/ | | \\_|  | || |     | |      | |\r\n"
						+ "| | | |    ____  | || |   / ____ \\   | || |  | |\\  /| |  | || |   |  _|  _   | | | |   '.___`-.   | || |     | |      | || |   |  __ /    | || |   / ____ \\   | || |     | |      | || |     | |      | |\r\n"
						+ "| | \\ `.___]  _| | || | _/ /    \\ \\_ | || | _| |_\\/_| |_ | || |  _| |___/ |  | | | |  |`\\____) |  | || |    _| |_     | || |  _| |  \\ \\_  | || | _/ /    \\ \\_ | || |    _| |_     | || |     | |      | |\r\n"
						+ "| |  `._____.'   | || ||____|  |____|| || ||_____||_____|| || | |_________|  | | | |  |_______.'  | || |   |_____|    | || | |____| |___| | || ||____|  |____|| || |   |_____|    | || |     |_|      | |\r\n"
						+ "| |              | || |              | || |              | || |              | | | |              | || |              | || |              | || |              | || |              | || |     (_)      | |\r\n"
						+ "| '--------------' || '--------------' || '--------------' || '--------------' | | '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |\r\n"
						+ " '----------------'  '----------------'  '----------------'  '----------------'   '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------' \r\n"
						+ "\r\n" + "\r\n" + "");

	}

	public void print() {
		System.out.print("첫 카드 세 장을 뽑습니다.");
	}

	// 진행, 종료
	public void goStop() {
		System.out.print("종료 0\t진행 1 >> ");
		go = sc.nextInt();
		if (go != 0 && go != 1) {
			while (go != 0 && go != 1) {
				System.out.print("0이나 1을 입력해주세요 >> ");
				go = sc.nextInt();
			}
		}
	}

	// 중복 없이 카드 두장 뽑는 메소드
	public void draw(int abcde) {
		if (abcde == 2) {
			count = 10;
		} else if (abcde == 3) {
			count = 8;
		} else if (abcde == 4) {
			count = 6;
		} else if (abcde == 5) {
			count = 4;
		}

		System.out.println("\n카드를 두 장 뽑습니다.");
		for (int i = 0; i < 2; i++) {
			tempNum[i] = ran.nextInt(count);
			// 카드 두장 뽑기
		}
		for (int i = 1; i < 2; i++) {
			if (tempNum[0] == tempNum[1]) {
				tempNum[0] = ran.nextInt(count);
				i = 0;
			}
			// 중복 확인
		}

		// 더 큰 값을 tempNum[0]에 넣어줌
		if (tempNum[0] < tempNum[1]) {
			temp = tempNum[0];
			tempNum[0] = tempNum[1];
			tempNum[1] = temp;
		}

		// 뽑은, 남은 카드에 저장
		for (int i = 0; i < 2; i++) {
			ncAdd(rcGet(tempNum[i]));
			rcDel(tempNum[i]);
			// 현재 카드 리스트에 추가
			// 남은 카드 리스트에서 삭제
		}
	}

	// 정렬
	public void arr() {
		temp = 0;
		for (int i = 0; i < ncLength() - 1; i++) {
			for (int j = i + 1; j < ncLength(); j++) {
				if (ncGet(i) > ncGet(j)) {
					ncAdd(ncGet(i));
					ncDel(i);
					j = i;
				}
			}
		}
	}

	// 현재 카드 출력
	public void ncNow() {
		for (int i = 0; i < ncLength(); i++) {
			System.out.print(ncGet(i) + "  ");
		}
		System.out.println();
	}

	// 현재 장비 출력
	public void niNow() {
		for (int i = 0; i < niLength(); i++) {
			System.out.print(niGet(i) + "  ");
		}
	}

	// 버릴 장비
	public void select() {

		System.out.print("\n버릴 장비\t: ");
		select = sc.next();
//		System.out.println(!(select.equals("횃불")||select.equals("성배")||select.equals("창")
//					||select.equals("검")||select.equals("갑옷")||select.equals("방패")));
		do {
			if (!(select.equals("횃불") || select.equals("성배") || select.equals("창") || select.equals("검")
					|| select.equals("갑옷") || select.equals("방패"))) {
				System.out.print("없는 장비잆니다. 다시 선택해 주세요 : ");
				select = sc.next();
				exi = true;
			} else if (riLength() == 0) {
				exi = false;
			} else if (riLength() != 0) {
				for (int i = 0; i < riLength(); i++) {
					if (select.equals(riGet(i))) {
						System.out.print("없는 장비잆니다. 다시 선택해 주세요 : ");
						select = sc.next();
						i = -1;
					}
					exi = false;
				}
			}
		} while (exi == true);

		for (int i = 0; i < niLength(); i++) {
			if (niGet(i).equals(select)) {
				riAdd(niGet(i));
				niDel(i);
			}
		}
	}

	// 장비 버리는 메소드(확률)
	public void delItem() {
		if (ran.nextInt(2) == 1) {
			System.out.println("\n장비를 잃습니다");
			// 현재 장비 출력
			System.out.print("현재 장비\t: ");
			niNow();
			// 장비 버리기
			select();
		}
	}

	// 게임 이용자에게 현재 카드 출력
	public void ncPrint(int mid) {
		System.out.print("현재 카드\t: ");
		for (int i = 0; i < ncLength(); i++) {
			if (ncGet(i) == mid) {
				if (i != ncLength() - 1 && ncGet(i) == ncGet(i + 1)) {
					System.out.print("0  ");
				} else {
					System.out.print(ncGet(i) + "  ");
				}
			} else
				System.out.print("0  ");
		}
		System.out.println();
	}

	// 현재 카드(이름으로) 출력
	public void ncName() {
		for (int i = 0; i < ncLength(); i++) {
			if (ncGet(i) == 1) {
				System.out.print("1." + cardList[0] + "  ");
			} else if (ncGet(i) == 2) {
				System.out.print("2." + cardList[1] + "  ");
			} else if (ncGet(i) == 3) {
				System.out.print("3." + cardList[2] + "  ");
			} else if (ncGet(i) == 4) {
				System.out.print("4." + cardList[3] + "  ");
			} else if (ncGet(i) == 5) {
				System.out.print("5." + cardList[4] + "  ");
			} else if (ncGet(i) == 6) {
				System.out.print("6." + cardList[5] + "  ");
			} else if (ncGet(i) == 7) {
				System.out.print("7." + cardList[6] + "  ");
			} else if (ncGet(i) == 8) {
				System.out.print("9." + cardList[7] + "  ");
			}
		}
		System.out.println();
	}

	// 갑옷, 방패 효과
	public int hpPlus() {
		for (int i = 0; i < niLength(); i++) {
			if (niGet(i).equals("갑옷")) {
				temp = ran.nextInt(3) + 3;
				setHp(getHp() + temp);
				System.out.println("갑옷 효과로 체력이 " + temp + " 오릅니다.");
			}
			if (niGet(i).equals("방패")) {
				temp = ran.nextInt(3) + 3;
				setHp(getHp() + temp);
				System.out.println("방패 효과로 체력이 " + temp + " 오릅니다.");
			}
		}
		System.out.print("현재 체력 : " + hp);
		return hp;
	}

	// 검으로 잡을 몬스터 선택
	// 용사의 검으로 없앨 몬스터 선택
	public void delMonster() {
		for (int i = 0; i < niLength(); i++) {
			if (niGet(i).equals("검")) {
				System.out.print("용사의 검이 있습니다. 무찌를 몬스터를 정해주세요 : ");
				select = sc.next();
				while (!select.equals("고블린") && !select.equals("해골전사") && !select.equals("오크") && !select.equals("뱀파이어")
						&& !select.equals("골렘") && !select.equals("사신") && !select.equals("마왕")
						&& !select.equals("드래곤")) {
					System.out.print("존재하지 않는 몬스터입니다. 다시 선택해 주세요 : ");
					select = sc.next();
				}
				if (select.equals("고블린")) {
					temp = 1;
				} else if (select.equals("해골전사")) {
					temp = 2;
				} else if (select.equals("오크")) {
					temp = 3;
				} else if (select.equals("뱀파이어")) {
					temp = 4;
				} else if (select.equals("골렘")) {
					temp = 5;
				} else if (select.equals("사신")) {
					temp = 6;
				} else if (select.equals("마왕")) {
					temp = 7;
				} else if (select.equals("드래곤")) {
					temp = 8;
				}
				for (int j = ncLength() - 1; j >= 0; j--) {
					if (ncGet(j) == temp) {
						ncDel(j);

					}
				}
			}
		}
	}

	// 전투 - 고블린
	public void fight1(int num) {
		if (getHp() > 0) {
			if (ncGet(num) == 1) {
				for (int j = 0; j < niLength(); j++) {
					if (niGet(j).equals("횃불")) {
						exi = true;
					}
					if (exi == true) {
						System.out.println("횃불로 고블린을 무찌릅니다");
						break;
					} else if (exi == false && j == niLength() - 1) {
						System.out.println("고블린에게 체력이 1 닳습니다");
						setHp(getHp() - 1);
					}
				}
				exi = false;
				System.out.println("현재 체력 : " + getHp());
				System.out.println();
			}
		}

	}

	// 전투 - 해골전사
	public void fight2(int num) {
		boolean exi1 = false;
		boolean exi2 = false;
		if (getHp() > 0) {
			if (ncGet(num) == 2) {
				for (int j = 0; j < niLength(); j++) {
					if (niGet(j).equals("횃불")) {
						exi = true;
					}
					if (exi == true) {
						System.out.println("횃불로 해골전사를 무찌릅니다");
						break;
					}
				}
				for (int j = 0; j < niLength(); j++) {
					if (!niGet(j).equals("횃불") && niGet(j).equals("성배") && exi != true) {
						exi1 = true;
					}
					if (exi1 == true) {
						System.out.println("성배로 해골전사를 무찌릅니다");
						break;
					}
				}
				for (int j = 0; j < niLength(); j++) {
					if (!niGet(j).equals("횃불") && !niGet(j).equals("성배") && exi != true && exi1 != true
							&& j == niLength() - 1) {
						exi2 = true;
					}
					if (exi2 == true) {
						System.out.println("해골전사에게 체력이 2 닳습니다");
						setHp(getHp() - 2);
						break;
					}
				}
				exi = false;
				exi1 = false;
				exi2 = false;

				System.out.println("현재 체력 : " + getHp());
				System.out.println();
			}
		}
	}

	// 전투 - 오크
	public void fight3(int num) {
		if (getHp() > 0) {
			if (ncGet(num) == 3) {
				for (int j = 0; j < niLength(); j++) {
					if (niGet(j).equals("횃불")) {
						exi = true;
					}
					if (exi == true) {
						System.out.println("횃불로 오크를 무찌릅니다");
						break;
					} else if (exi == false && j == niLength() - 1) {
						System.out.println("오크에게 체력이 3 닳습니다");
						setHp(getHp() - 3);
					}
				}
				exi = false;
				System.out.println("현재 체력 : " + getHp());
				System.out.println();
			}
		}
	}

	// 전투 - 뱀파이어
	public void fight4(int num) {
		if (getHp() > 0) {
			if (ncGet(num) == 4) {
				for (int j = 0; j < niLength(); j++) {
					if (niGet(j).equals("성배")) {
						exi = true;
					}
					if (exi == true) {
						System.out.println("성배로 뱀파이어를 무찌릅니다");
						break;
					} else if (exi == false && j == niLength() - 1) {
						System.out.println("뱀파이어에게 체력이 4 닳습니다");
						setHp(getHp() - 4);
					}
				}
				exi = false;
				System.out.println("현재 체력 : " + getHp());
				System.out.println();
			}
		}
	}

	// 전투 - 골렘
	public void fight5(int num) {
		if (getHp() > 0) {
			if (ncGet(num) == 5) {
				System.out.println("골렘에게 체력이 5 닳습니다");
				setHp(getHp() - 5);
				System.out.println("현재 체력 : " + getHp());
				System.out.println();
			}
		}
	}

	// 전투 - 사신
	public void fight6(int num) {
		if (getHp() > 0) {
			if (ncGet(num) == 6) {
				for (int j = 0; j < niLength(); j++) {
					if (niGet(j).equals("성배")) {
						exi = true;
					}
					if (exi == true) {
						System.out.println("성배로 사신을 무찌릅니다");
						break;
					} else if (exi == false && j == niLength() - 1) {
						System.out.println("사신에게 체력이 6 닳습니다");
						setHp(getHp() - 6);
					}
				}
				exi = false;
				System.out.println("현재 체력 : " + getHp());
				System.out.println();
			}
		}
	}

	// 전투 - 마왕
	public void fight7(int num) {
		if (getHp() > 0) {
			if (ncGet(num) == 7) {
				System.out.println("마왕에게 체력이 7 닳습니다");
				setHp(getHp() - 7);
				System.out.println("현재 체력 : " + getHp());
				System.out.println();
			}
		}
	}

	// 전투 - 드래곤
	public void fight8(int num) {
		if (getHp() > 0) {
			if (ncGet(num) == 8) {
				for (int j = 0; j < niLength(); j++) {
					if (niGet(j).equals("창")) {
						exi = true;
					}
					if (exi == true) {
						System.out.println("창으로 드래곤을 무찌릅니다");
						break;
					} else if (exi == false && j == niLength() - 1) {
						System.out.println("드래곤에게 체력이 9 닳습니다");
						setHp(getHp() - 9);
					}
				}
				exi = false;
				System.out.println("현재 체력 : " + getHp());
				System.out.println();
			}
		}
	}

	// 점수계산
	public void score() {
		for (int i = 0; i < ncLength(); i++) {
			if (ncGet(i) == 1) {
				score += 1;
			}
			if (ncGet(i) == 2) {
				score += 2;
			}
			if (ncGet(i) == 3) {
				score += 3;
			}
			if (ncGet(i) == 4) {
				score += 4;
			}
			if (ncGet(i) == 5) {
				score += 5;
			}
			if (ncGet(i) == 6) {
				score += 6;
			}
			if (ncGet(i) == 7) {
				score += 7;
			}
			if (ncGet(i) == 8) {
				score += 9;
			}
		}
		score *= (7 - niLength());
		System.out.println("획득 점수 : " + score);
	}

}
