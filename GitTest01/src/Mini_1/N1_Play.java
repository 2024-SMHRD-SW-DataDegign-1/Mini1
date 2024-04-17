package Mini_1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class N1_Play extends List {
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	
	String selItem="";
	
ArrayList<Integer> nowCard= new ArrayList<Integer>();
	
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
	
ArrayList<String> nowItem= new ArrayList<String>();
	
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
	
ArrayList<Integer> remainCard= new ArrayList<Integer>();
	
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

ArrayList<Integer> remainItem= new ArrayList<Integer>();
	
	public void riAdd(int num) {
		remainItem.add(num);
	}
	
	public void riAdd(int index, int num) {
		remainItem.add(index, null);
	}

	public void riDel(int num) {
		remainItem.remove(num);
	}
	
	public int riLength() {
		return remainItem.size();
	}

	public int riGet(int num) {
		return remainItem.get(num);
	}
	
	
	
	
	int count=0;
	int temp = 0;			// 임시 저장 공간
	int turn = 1;			// 턴 카운트

	int[] tempNum = new int[3];	// 임시 숫자 저장
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
			ncAdd(tempNum[i]);
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
				if (ncGet(i)>ncGet(j)) {
					ncAdd(ncGet(i));
					ncDel(i);
					j=i;
				}
			}
		}	
	}	
	
	// 현재 카드 출력
	public void ncNow() {
		for(int i=0;i<ncLength();i++) {
			System.out.print(ncGet(i) + "  ");
		}
		System.out.println();
	}
	
	// 현재 장비 출력
	public void niNow() {
		System.out.print("현재 장비\t: ");
		for(int i=0;i<niLength();i++) {
			System.out.print(niGet(i) + "  ");
		}
	}
	
	// 버릴 장비
	public void selItem() {
		
		System.out.print("\n버릴 장비 선택 : ");
		selItem=sc.next();
		
		for(int i=0;i<niLength();i++) {
			if(niGet(i).equals(selItem)) {
				niDel(i);
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
	public void ncPrint(int mid) {
		System.out.print("현재 카드\t: ");
		for(int i=0;i<ncLength();i++) {
			if(ncGet(i)==mid) {
				if(i!=ncLength()&&ncGet(i)==ncGet(i+1)) {
					System.out.print("0  ");
				}else {
					System.out.print(ncGet(i)+"  ");
				}
			}else
				System.out.print("0  ");
		}
		System.out.println();
	}
	
	
	
}
