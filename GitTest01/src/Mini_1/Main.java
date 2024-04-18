package Mini_1;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean exi = false;
		
		
		String[] cardListTemp =
			{ "고블린", "고블린", "해골전사", "해골전사", "오크", "오크",
					"뱀파이어", "뱀파이어", "골렘", "골렘", "사신", "마왕", "드레곤" };
		
		
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
		
		Class fst = new Class();
		
		int hp=3;				// 체력
		int count=0;
		int temp = 0;			// 임시 저장 공간
		int turn = 1;
		int[] tempNum = new int[3];	// 임시 숫자 저장
		int mid = 0; // 가운데 카드 저장
		String midName = ""; // 가운데 카드 이름
		
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
		fst.rcAdd(9);

		fst.niAdd("횃불");
		fst.niAdd("성배");
		fst.niAdd("창");
		fst.niAdd("검");
		fst.niAdd("갑옷");
		fst.niAdd("방패");
		
		
		fst.aArt();
		
		System.out.println("- - - - - turn "+turn+" - - - - -");
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
		
		mid = fst.ncGet(1);	//가운데 카드 저장
		
		// 뽑은 카드는 카드 리스트에서 삭제
		for (int i = fst.ncLength()-1; i >= 0; i--) {
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
		
		System.out.print("\n종료 0\t진행 1 >> ");
		int go=sc.nextInt();
		while(go == 1 && turn!=4) {
			turn++;
			System.out.println("\n- - - - - turn "+turn+" - - - - -");
			
			// 카드 두장 뽑기
			fst.draw(turn);
			// 현재 카드 확인
//			System.out.print("nc	: ");
//			ncNow();
			
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
			if(turn!=4) {
				System.out.print("\n종료 0\t진행 1 >> ");
				go=sc.nextInt();
			}else {
				go=0;
			}
		}
		
		
		// - -------------------------------------------------------- //
		
		
		System.out.println("\n싸움 시작");
		
		// 현재 카드 이름, 보유 장비 출력
		System.out.print("몬스터\t: ");
		fst.ncName();
		System.out.print("현재 장비\t: ");
		fst.niNow();
		System.out.println();
		System.out.println();
		
		// 방패, 갑옷 보유 시 3~5 hp 증가
		fst.hpPlus();
		System.out.println("\n\n전투를 시작합니다\n");
		
		temp = 100;
		
//		while(fst.getHp()>0&&temp==100) {
//			fst.fight1(1);
//			System.out.println();
//			fst.fight2(2);
//			System.out.println();
//			fst.fight3(3);
//			System.out.println();
//			fst.fight4(4);
//			System.out.println();
//			fst.fight5(5);
//			System.out.println();
//			fst.fight6(6);
//			System.out.println();
//			fst.fight7(7);
//			System.out.println();
//			fst.fight8(8);
//			System.out.println();
//			temp=0;
//		}
		
		for(int i=0;i<fst.ncLength();i++) {
			fst.fight1(i);
			fst.fight2(i);
			
			
		}
		
		
		
		
		
		
		
		if(fst.getHp()>0) {
			System.out.println("던전을 클리어했습니다!");
			System.out.println("- - - - - - - -");
			fst.ncName();
			fst.niNow();
			System.out.println("");
			
		}else{
			System.out.println("체력이 0 이하가 되어 패배합니다...");
			
		}
		
		
		
		
		
		
		
		
		
		
		System.out.println();
		
		
		
	}
	
}
