package Mini_1;

import java.util.Random;
import java.util.Scanner;

public class N1_Play extends List {
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	
	nowCard nc = new nowCard();
	remainCard rc = new remainCard();	
	
	nowItem ni = new nowItem();
	remainItem ri = new remainItem();
	
	String selItem="";

	int count=0;
	int temp = 0;			// 임시 저장 공간
	int turn = 1;			// 턴 카운트

	int[] tempNum = new int[3];	// 임시 숫자 저장
	int mid = 0; // 가운데 카드 저장
	String midName = ""; // 가운데 카드 이름

	
	
	public void print() {
		System.out.print("첫 카드 세 장을 뽑습니다.");
	}
	
	// 중복 없이 카드 두장 뽑는 메소드
	public void draw(int abcde) {
		if(abcde==2) {
			count=10;
		}else if (abcde==3) {
			count=8;
		}else if (abcde==4) {
			count=6;
		}
		
		System.out.println("\n카드를 두 장 뽑습니다.");
		for (int i=0; i < 2; i++) {
			tempNum[i] = ran.nextInt(count);
			// 카드 두장 뽑기 ( 3, 4에 )
		}
		for (int i = 1; i < 2; i++) {
			if (tempNum[0] == tempNum[1]) {
				tempNum[0] = ran.nextInt(count);
				i = 0;
			}
			// 중복 확인
		}
		
		// 뽑은, 남은 카드에 저장
		
		for (int i = 0; i < 2; i++) {
			nc.add(tempNum[i]);
			rc.del(tempNum[i]);
			// 현재 카드 리스트에 추가
			// 남은 카드 리스트에서 삭제
		}
	}
	
	// 정렬
	public void arr() {
		temp = 0;
		for (int i = 0; i < nc.length() - 1; i++) {
			for (int j = i + 1; j < nc.length(); j++) {
				if (nc.get(i)>nc.get(j)) {
					nc.add(nc.get(i));
					nc.del(i);
					j=i;
				}
			}
		}	
	}	
	
	// 현재 카드 출력
	public void ncNow() {
		for(int i=0;i<nc.length();i++) {
			System.out.print(nc.get(i) + "  ");
		}
		System.out.println();
	}
	
	// 현재 장비 출력
	public void niNow() {
		System.out.print("현재 장비\t: ");
		for(int i=0;i<ni.length();i++) {
			System.out.print(ni.get(i) + "  ");
		}
	}
	
	// 버릴 장비
	public void selItem() {
		
		System.out.print("\n버릴 장비 선택 : ");
		selItem=sc.next();
		
		for(int i=0;i<ni.length();i++) {
			if(ni.get(i).equals(selItem)) {
				ni.del(i);
			}
		}
	}
	
	// 장비 버리는 메소드(확률)
	public void delItem() {
		if(ran.nextInt(2)==1) {
			System.out.println("\n장비를 잃습니다");
			// 현재 장비 출력
			niNow();
			// 장비 버리기
			selItem();
		}
	}
	
	// 게임 이용자에게 현재 카드 출력
	public void ncPrint() {
		System.out.print("현재 카드\t: ");
		for(int i=0;i<nc.length();i++) {
			if(nc.get(i)==mid) {
				if(i!=nc.length()&&nc.get(i)==nc.get(i+1)) {
					System.out.print("0  ");
				}else {
					System.out.print(nc.get(i)+"  ");
				}
			}else
				System.out.print("0  ");
		}
		System.out.println();
	}
	
	
	
	
	// 게임 실행
	public void tempNum() {
		rc.add(1);
		rc.add(1);
		rc.add(2);
		rc.add(2);
		rc.add(3);
		rc.add(3);
		rc.add(4);
		rc.add(4);
		rc.add(5);
		rc.add(5);
		rc.add(6);
		rc.add(7);
		rc.add(9);

		ni.add("횃불");
		ni.add("성배");
		ni.add("창");
		ni.add("검");
		ni.add("갑옷");
		ni.add("방패");
		
		System.out.println("- - - - - turn "+turn+" - - - - -");
		print();
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
			nc.add(tempNum[i]); // 카드 저장
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
		mid = cardListNum[tempNum[1]];	//가운데 카드 저장
		
		// 뽑은 카드는 카드 리스트에서 삭제
		
		for (int i = 0; i < nc.length(); i++) {
			rc.get(tempNum[i]); // 남은 카드 목록에서 제거
		}
		
		// 현재 카드 확인
//		System.out.print("\nnc\t: ");
//		ncNow();
		
		
		// 정렬
		arr();
		
		// 정렬상태 확인
		System.out.print("\nnc 정렬\t: ");
		ncNow();
		
		mid = nc.get(1);
		midName = cardListName[tempNum[1]];
		
		ncPrint();
		
		
		
		
		
		
		
		
		System.out.print("\n종료 0\t진행 1 >> ");
		int go=sc.nextInt();
		while(go == 1 && turn!=4) {
			turn++;
			System.out.println("\n- - - - - turn "+turn+" - - - - -");
			
			// 카드 두장 뽑기
			draw(turn);
			// 현재 카드 확인
//			System.out.print("nc	: ");
//			ncNow();
			
			// 정렬
			arr();
			// 정렬 상태 확인
			System.out.print("nc 정렬\t: ");
			ncNow();
			
			// 게임 이용자에게 현재 카드 상태 출력
			ncPrint();
			
			// 확률적으로 장비를 잃는 코드
			delItem();
			
			// 5턴이 되면 넘어감
			if(turn!=4) {
				System.out.print("\n종료 0\t진행 1 >> ");
				go=sc.nextInt();
			}else {
				System.out.println("\t싸움 시작");
				go=0;
			}
		}
		
		
		
		
		
	
	
	}

}
