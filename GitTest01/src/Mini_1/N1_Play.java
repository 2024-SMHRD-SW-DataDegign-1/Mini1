package Mini_1;

import java.util.Random;
import java.util.Scanner;

public class N1_Play extends List {
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	

	int[] remainCard = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 9 }; // 남은 카드
	int[] card = new int[50]; // 현재 카드
	
	int[] remainItem = { 0, 1, 2, 3, 4, 5 };	// 남은 아이템
	int[] item = { 0, 1, 2, 3, 4, 5 };	// 현재 아이템
	String delItem="";

	int temp = 0;
	int turn = 1;
	int abcde=3;

	int[] tempNum = new int[13]; // 임시 순서 저장
	String[] cardTemp = new String[3]; // 뽑은 카드 이름 저장
	int lengthCard = 3; // tempCard 길이
	int lengthItem = 6; // tempItem 길이
	int mid = 0; // 가운데 카드 저장

	public void print() {
		System.out.println("첫 카드 세 장을 뽑습니다.");
	}
	
	
	
	
	// 중복 없이 카드 두장 뽑는 메소드
	public void draw(int abcde) {	// 3, 5, 7 ...
		System.out.println("\n카드를 두 장 뽑습니다.");
		for (int i=abcde; i < abcde+2; i++) {
			tempNum[i] = ran.nextInt(13);
			// 카드 두장 뽑기 ( 3, 4에 )
		}
		for (int i = abcde; i < abcde+2; i++) {
			if (tempNum[3] == tempNum[4]) {
				tempNum[3] = ran.nextInt(13);
				i = abcde;
			}
//			System.out.println(tempNum[3] + "\t" + tempNum[4]);
			// 중복 확인

			if (remainCard[tempNum[i]] == 0) {
				tempNum[i] = ran.nextInt(13);
				i = abcde-1;
			}
		}
		
		// 뽑은, 남은 카드에 저장
			for (int i = abcde; i < abcde+2; i++) {
				card[i] = remainCard[tempNum[i]];
				// 뽑은 카드 추가
				remainCard[tempNum[i]] = 0;
				// 남은 카드 리스트에서 삭제
			}
	}
	
	
	// 정렬
	public void arr() {
		// 현재 카드 정렬
		temp = 0;
		for (int i = 0; i < lengthCard - 1; i++) {
			for (int j = i + 1; j < lengthCard; j++) {
				if (card[i] > card[j]) {
					temp = card[i];
					card[i] = card[j];
					card[j] = temp;
				}
			}
		}
	}
	
	
	// 정렬상태 출력
	public void arrayNow() {
		System.out.print("현재 카드\t: ");
		for (int i = 0; i < lengthCard; i++) {
			if (card[i] == mid) {
				if(card[i]!=card[i+1]) {
					System.out.print(card[i] + "  ");
				}else if(i!=lengthCard) {
					System.out.print("0  ");
				}
			} else {
				System.out.print("0  ");
			}
		}
	}
	
	// 현재 장비 출력
	public void itemNow() {
		// 현재 장비 출력
		System.out.print("\n현재 아이템\t: ");
		for(int i=0;i<lengthItem;i++) {
			if(item[i]!=100) {
				System.out.print(itemListName[item[i]]+"  ");
			}
		}	
	}
	
	// 버릴 장비
	public void delItem() {
		
		System.out.print("\n버릴 장비 선택 : ");
		delItem=sc.next();
		
		for(int i=0;i<item.length;i++) {
			if(itemListName[i].equals(delItem)) {
				item[i]=100;
			}
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

	public void tempNum() {
		System.out.println("- - - - - turn "+turn+" - - - - -");
		print();
		// 카드 세장 뽑기 ( 0, 1, 2번에 )
		for (int i = 0; i < lengthCard; i++) {
			tempNum[i] = ran.nextInt(13);
		}

		// 중복 번호 삭제
		for (int i = 1; i < lengthCard; i++) {
			for (int j = 0; j < i; j++) {
				if (tempNum[i] == tempNum[j]) {
					tempNum[i] = ran.nextInt(13);
					j = -1;
				}
			}
		}

		// 뽑은 카드 정보 저장
		for (int i = 0; i < lengthCard; i++) {
//			System.out.print(tempNum[i] + "\t"); // 카드 번호 확인
//			System.out.print(remainCard[tempNum[i]] + "\t"); // 카드 숫자 확인
//			System.out.print(cardListName[tempNum[i]] + "\n"); // 카드 이름 확인
			cardTemp[i] = cardListName[tempNum[i]]; // 카드 이름 저장
		}
		
		// 정렬
		for (int i = 0; i < lengthCard - 1; i++) {
			for (int j = i + 1; j < lengthCard; j++) {
				if (tempNum[i] > tempNum[j]) {
					temp = tempNum[i];
					tempNum[i] = tempNum[j];
					tempNum[j] = temp;
				}
			}
		}
		mid = cardListNum[tempNum[1]];	//가운데 카드 저장
		
		// 뽑은 카드는 카드 리스트에서 삭제
		for (int i = 0; i < lengthCard; i++) {
			card[i] = remainCard[tempNum[i]]; // 카드 목록에 추가
			remainCard[tempNum[i]] = 0; // 남은 카드 목록에서 제거
		}
		
		for (int i=0;i<lengthCard-1;i++) {
			for (int j=0+1;j<lengthCard;j++) {
				if (card[i] > card[j]) {
					temp = card[i];
					card[i] = card[j];
					card[j] = temp;
				}
			}	
		}
		
		
		
		
//		System.out.println("추가된 카드 : " + Arrays.toString(card)); // 추가됐는지 확인
//		System.out.println("삭제된 카드 : " + Arrays.toString(remainCard)); // 삭제됐는지 확인

//		System.out.println("mid : " + mid);
//		System.out.println("가운데 카드는 " + cardListNum[tempNum[1]] + "\t" + cardListName[tempNum[1]] + "입니다.");
		// 카드 정렬 상태 출력
		System.out.print("\n현재 카드\t: 0  "+card[1]+"  0");

		// 현재 장비 출력
		System.out.print("\n현재 아이템\t: ");
		for(int i=0;i<lengthItem;i++) {
			System.out.print(itemListName[item[i]]+"  ");
		}
		
		
		
		
		
		
		
		
		System.out.print("\n\n종료 0\t진행 1 >> ");
		int go=sc.nextInt();
		while(go == 1 && turn!=4) {
			turn++;
			System.out.println("\n- - - - - turn "+turn+" - - - - -");
			
			
			draw(abcde);
			abcde+=2;
			
//			System.out.println("현재 카드\t: " + Arrays.toString(card)); // 추가됐는지 확인
//			System.out.println("삭제된 카드\t: " + Arrays.toString(remainCard)); // 삭제됐는지 확인

			lengthCard += 2;
			// 현재 카드 정렬
			arr();
			System.out.println();
			
			// 카드 정렬 상태 출력
			arrayNow();
			
			// 현재 장비 출력
			itemNow();
			// 버릴 장비 선택
			delItem();
			// 현재 장비 출력
			itemNow();
			
			
			System.out.print("\n\n종료 0\t진행 1 >> ");
			go=sc.nextInt();
			
		}
		
		
			
			
			
			
			
			
			

//			// 뽑은 번호의 카드
//			for (int i = 0; i < lengthCard; i++) {
//				System.out.print(tempNum[i] + "\t"); // 카드 번호 확인
//				System.out.print(cardList[tempNum[i]] + "\n"); // 카드 이름 확인
////				cardTemp[i] = cardList[tempNum[i]];
//			}
//			


	}

}
