package Mini_1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);

		Class fst = new Class();

		String[] cardListTemp = { "고블린", "고블린", "해골전사", "해골전사", "오크", "오크", "뱀파이어", "뱀파이어", "골렘", "골렘", "사신", "마왕",
				"드레곤" };

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
//				System.out.println(fst.goGet());
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

}
