package Mini1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import DungeonBgm.DBgm;
import DungeonBgm.DungeonBgm;
import javazoom.jl.player.MP3Player;

public class Game extends List {
	   Scanner sc = new Scanner(System.in);
	   Random ran = new Random();

	   private int mid = 0;   // 가운데 카드 저장
	   private int temp = 0; // 임시 저장 공간
	   private String tempString = "";   // String 임시 저장 공간
	   private boolean tempBool = false;   // boolean 임시 저장 공간
	   private int[] tempArray = new int[3]; // 임시 숫자 저장
	   
	   private int hp = 3;
	   
	  

	public int getHp() {
	      return hp;
	   }
	   public void setHp(int hp) {
	      this.hp = hp;
	   }
	   
	   public int getMid() {
	      return mid;
	   }

	   public int getTemp() {
	      return temp;
	   }
	   public void setTemp(int temp) {
	      this.temp = temp;
	   }


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

	   // 카드 목록, 현재 장비 초기값 추가
	   public void fstList() {
	      rcAdd(1);
	      rcAdd(1);
	      rcAdd(2);
	      rcAdd(2);
	      rcAdd(3);
	      rcAdd(3);
	      rcAdd(4);
	      rcAdd(4);
	      rcAdd(5);
	      rcAdd(5);
	      rcAdd(6);
	      rcAdd(7);
	      rcAdd(8);

	      niAdd("횃불");
	      niAdd("성배");
	      niAdd("창");
	      niAdd("검");
	      niAdd("갑옷");
	      niAdd("방패");
	   }

	   // 첫 카드 세장 중복 없이 뽑는 메소드
	   public void drawFst() {
	      // 카드 세장 뽑기
	      for (int i = 0; i < 3; i++) {
	         tempArray[i] = ran.nextInt(13);
	      }
	      // 중복 번호 삭제
	      for (int i = 1; i < 3; i++) {
	         for (int j = 0; j < i; j++) {
	            if (tempArray[i] == tempArray[j]) {
	               tempArray[i] = ran.nextInt(13);
	               j = -1;
	            }
	         }
	      }
	      // 뽑은 카드 정보 저장
	      for (int i = 0; i < 3; i++) {
	         ncAdd(rcGet(tempArray[i])); // 카드 저장
	      }
	      // 정렬
	      for (int i = 0; i < 2; i++) {
	         for (int j = i + 1; j < 3; j++) {
	            if (tempArray[i] > tempArray[j]) {
	               temp = tempArray[i];
	               tempArray[i] = tempArray[j];
	               tempArray[j] = temp;
	            }
	         }
	      }
	      // 뽑은 카드는 카드 리스트에서 삭제
	      for (int i = ncLength() - 1; i >= 0; i--) {
	         rcDel(tempArray[i]); // 남은 카드 목록에서 제거
	      }
	      // 정렬
	      arr();
	      mid = ncGet(1); // 가운데 카드 저장
	      
	      
	      
	      
	      
	      
	   }
	   
	   // 진행, 종료
	   public void goStop() {
	      System.out.print("종료 0\t진행 1 >> ");
	      temp = sc.nextInt();
	      if (temp != 0 && temp != 1) {
	         while (temp != 0 && temp != 1) {
	            System.out.print("0이나 1을 입력해주세요 >> ");
	            temp = sc.nextInt();
	         }
	      }
	   }

	   // 중복 없이 카드 두장 뽑는 메소드
	   public void draw(int abcde) {
	      if (abcde == 2) {
	         temp = 10;
	      } else if (abcde == 3) {
	         temp = 8;
	      } else if (abcde == 4) {
	         temp = 6;
	      } else if (abcde == 5) {
	         temp = 4;
	      }

	      System.out.println("\n카드를 두 장 뽑습니다.");
	      for (int i = 0; i < 2; i++) {
	         tempArray[i] = ran.nextInt(temp);
	         // 카드 두장 뽑기
	      }
	      for (int i = 1; i < 2; i++) {
	         if (tempArray[0] == tempArray[1]) {
	            tempArray[0] = ran.nextInt(temp);
	            i = 0;
	         }
	         // 중복 확인
	      }

	      // 더 큰 값을 tempArray[0]에 넣어줌
	      if (tempArray[0] < tempArray[1]) {
	         temp = tempArray[0];
	         tempArray[0] = tempArray[1];
	         tempArray[1] = temp;
	      }

	      // 뽑은, 남은 카드에 저장
	      for (int i = 0; i < 2; i++) {
	         ncAdd(rcGet(tempArray[i]));
	         rcDel(tempArray[i]);
	         // 현재 카드 리스트에 추가
	         // 남은 카드 리스트에서 삭제
	      }
	      temp=0;
	   }

	   // 정렬
	   public void arr() {
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

	   // 장비 설명
	   public void itemInfo() {
	      System.out.println(" 횃불\t: 1.고블린 2.해골전사 3.오크 처치");
	      System.out.println(" 성배\t: 2.해골전사 4.뱀파이어 6.사신 처치");
	      System.out.println(" 창\t: 9.드래곤 처치");
	      System.out.println(" 검\t: 시작 전 원하는 몬스터 처치");
	      System.out.println(" 갑옷,방패\t: 체력 3 ~ 5 만큼 추가");
	   }
	   
	   // 버릴 장비
	   public void delItem0() {
	      System.out.print("\n버릴 장비\t: ");
	      tempString = sc.next();
	      do {
	         if (!(tempString.equals("횃불") || tempString.equals("성배") || tempString.equals("창") || tempString.equals("검")
	               || tempString.equals("갑옷") || tempString.equals("방패"))) {
	            System.out.print("없는 장비잆니다. 다시 선택해 주세요 : ");
	            tempString = sc.next();
	            tempBool = true;
	         } else if (riLength() == 0) {
	            tempBool = false;
	         } else if (riLength() != 0) {
	            for (int i = 0; i < riLength(); i++) {
	               if (tempString.equals(riGet(i))) {
	                  System.out.print("없는 장비잆니다. 다시 선택해 주세요 : ");
	                  tempString = sc.next();
	                  i = -1;
	               }
	               tempBool = false;
	            }
	         }
	      } while (tempBool == true);

	      for (int i = 0; i < niLength(); i++) {
	         if (niGet(i).equals(tempString)) {
	            riAdd(niGet(i));
	            niDel(i);
	         }
	      }
	   }

	   // 장비 버리는 메소드(확률)
	   public void delItem() {
	      if (ran.nextInt(2) == 1) {
	         System.out.println("\n장비를 잃습니다");
	         // 장비 설명 출력
	         itemInfo();
	         System.out.println();
	         // 현재 장비 출력
	         System.out.print("현재 장비\t: ");
	         niNow();
	         // 장비 버리기
	         delItem0();
	      }
	   }
	   
	   // 장비 선택 삭제
	   public void selItem() {
	      System.out.println("보유한 장비가 적을 수록 점수 획득에 유리합니다.");
	      System.out.println("6개 : 점수 1배\t3개 : 점수 4배");
	      System.out.println("5개 : 점수 2배\t2개 : 점수 5배");
	      System.out.println("4개 : 점수 3배\t1개 : 점수 6배");
	      System.out.print("현재 장비\t : ");
	      niNow();
	      System.out.print("\n\n그냥 진행한다 : 0\t장비를 버린다 : 1 >> ");
	      temp = sc.nextInt();
	      if (temp != 0 && temp != 1) {
	         while (temp != 0 && temp != 1) {
	            System.out.print("0이나 1을 입력해주세요 >> ");
	            temp = sc.nextInt();
	         }
	      }
	      if(temp==1) {
	         System.out.print("버릴 아이템 수를 입력해주세요 >> ");
	         temp = sc.nextInt();
	         while (temp<=0||temp>niLength()) {
	            System.out.print("버릴 수 있는 아이템 수에서 입력해주세요 >> ");
	            temp=sc.nextInt();
	         }
	         System.out.println();
	         ncPrint(mid);
	         // 장비 설명 출력
	         itemInfo();
	         for(int i=0;i<temp;i++) {
	            System.out.print("현재 장비\t: ");
	            niNow();
	            System.out.println();
	            delItem0();
	         }
	      }
	      temp=0;
	      System.out.println();
	   }
	      
	   // 게임 이용자에게 현재 카드 출력
	   public void ncPrint(int mid) {
	      if (mid == 1) {
	         tempString=("1.고블린  ");
	      } else if (mid == 2) {
	         tempString=("2.해골전사  ");
	      } else if (mid == 3) {
	         tempString=("3.오크  ");
	      } else if (mid == 4) {
	         tempString=("4.뱀파이어 ");
	      } else if (mid == 5) {
	         tempString=("5.골렘  ");
	      } else if (mid == 6) {
	         tempString=("6.사신  ");
	      } else if (mid == 7) {
	         tempString=("7.마왕  ");
	      } else if (mid == 8) {
	         tempString=("9.드래곤  ");
	      }
	      System.out.print("현재 카드\t: ");
	      for (int i = 0; i < ncLength(); i++) {
	         if (ncGet(i) == mid) {
	            if (i != ncLength() - 1 && ncGet(i) == ncGet(i + 1)) {
	               System.out.print("?  ");
	            } else {
	               System.out.print(tempString);
	            }
	         } else
	            System.out.print("?  ");
	      }
	      tempString="";
	      System.out.println();
	   }

	   // 현재 카드(이름으로) 출력
	   public void ncName() {
	      for (int i = 0; i < ncLength(); i++) {
	         if (ncGet(i) == 1) {
	            System.out.print("1. 고블린  ");
	         } else if (ncGet(i) == 2) {
	            System.out.print("2. 해골전사  ");
	         } else if (ncGet(i) == 3) {
	            System.out.print("3. 오크  ");
	         } else if (ncGet(i) == 4) {
	            System.out.print("4. 뱀파이어  ");
	         } else if (ncGet(i) == 5) {
	            System.out.print("5. 골렘  ");
	         } else if (ncGet(i) == 6) {
	            System.out.print("6. 사신  ");
	         } else if (ncGet(i) == 7) {
	            System.out.print("7.마왕  ");
	         } else if (ncGet(i) == 8) {
	            System.out.print("9.드래곤  ");
	         }
	      }
	      System.out.println();
	   }
	   
	   // 용사의 검으로 없앨 몬스터 선택
	   public void delMonster() {
	      for (int i = 0; i < niLength(); i++) {
	         if (niGet(i).equals("검")) {
	            System.out.print("용사의 검이 있습니다. 무찌를 몬스터를 정해주세요 : ");
	            tempString = sc.next();
	            while (!tempString.equals("고블린") && !tempString.equals("해골전사") && !tempString.equals("오크") && !tempString.equals("뱀파이어")
	                  && !tempString.equals("골렘") && !tempString.equals("사신") && !tempString.equals("마왕")
	                  && !tempString.equals("드래곤")) {
	               System.out.print("존재하지 않는 몬스터입니다. 다시 선택해 주세요 : ");
	               tempString = sc.next();
	            }
	            if (tempString.equals("고블린")) {
	               temp = 1;
	            } else if (tempString.equals("해골전사")) {
	               temp = 2;
	            } else if (tempString.equals("오크")) {
	               temp = 3;
	            } else if (tempString.equals("뱀파이어")) {
	               temp = 4;
	            } else if (tempString.equals("골렘")) {
	               temp = 5;
	            } else if (tempString.equals("사신")) {
	               temp = 6;
	            } else if (tempString.equals("마왕")) {
	               temp = 7;
	            } else if (tempString.equals("드래곤")) {
	               temp = 8;
	            }
	            for (int j = ncLength() - 1; j >= 0; j--) {
	               if (ncGet(j) == temp) {
	                  ncDel(j);

	               }
	            }
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
	      System.out.println("현재 체력 : " + hp);
	      return hp;
	   }
	   
	   
	   // 전투 메소드
	   public void fight(int num, int i, String temName, String monName) {
	      if (getHp() > 0) {
	         if (ncGet(num) == i) {
	            for (int j = 0; j < niLength(); j++) {
	               if (niGet(j).equals(temName)) {
	                  tempBool = true;
	               }
	               if (tempBool == true) {
	                  System.out.println(temName + "(으)로 "+monName+"을(를) 무찌릅니다");
	                  break;
	               } else if (tempBool == false && j == niLength() - 1) {
	                  if(i!=8) {
	                     System.out.println(monName+"에게 체력이 "+i+" 닳습니다");
	                     setHp(getHp() - i);
	                  }else {
	                     System.out.println(monName+"에게 체력이 "+i+1+" 닳습니다");
	                     setHp(getHp() - (i+1));
	                  }
	               }
	            }
	            tempBool = false;
	            System.out.println("현재 체력 : " + getHp());
	         }
	      }
	   }
	   
	   // 전투 메소드 2
	   public void fight(int num, int i, String monName) {
	      if (getHp() > 0) {
	         if (ncGet(num) == i) {
	            System.out.println(monName+"에게 체력이 5 닳습니다");
	            setHp(getHp() - i);
	            System.out.println("현재 체력 : " + getHp());
	            System.out.println();
	         }
	      }
	   }
	   
	   // 전투 - 고블린
	   public void fight1(int num) {
	      fight(num, 1, "횃불", "고블린");
	   }

	   // 전투 - 해골전사
	   public void fight2(int num) {
	      boolean tempBool1 = false;
	      boolean tempBool2 = false;
	      if (getHp() > 0) {
	         if (ncGet(num) == 2) {
	            for (int j = 0; j < niLength(); j++) {
	               if (niGet(j).equals("횃불")) {
	                  tempBool = true;
	               }
	               if (tempBool == true) {
	                  System.out.println("횃불(으)로 해골전사을(를) 무찌릅니다");
	                  break;
	               }
	            }
	            for (int j = 0; j < niLength(); j++) {
	               if (!niGet(j).equals("횃불") && niGet(j).equals("성배") && tempBool != true) {
	                  tempBool1 = true;
	               }
	               if (tempBool1 == true) {
	                  System.out.println("성배(으)로 해골전사을(를) 무찌릅니다");
	                  break;
	               }
	            }
	            for (int j = 0; j < niLength(); j++) {
	               if (!niGet(j).equals("횃불") && !niGet(j).equals("성배") && tempBool != true && tempBool1 != true
	                     && j == niLength() - 1) {
	                  tempBool2 = true;
	               }
	               if (tempBool2 == true) {
	                  System.out.println("해골전사에게 체력이 2 닳습니다");
	                  setHp(getHp() - 2);
	                  break;
	               }
	            }
	            tempBool = false;
	            tempBool1 = false;
	            tempBool2 = false;

	            System.out.println("현재 체력 : " + getHp());
	            System.out.println();
	         }
	      }
	   }

	   // 전투 - 오크
	   public void fight3(int num) {
	      fight(num, 3, "횃불", "오크");
	   }

	   // 전투 - 뱀파이어
	   public void fight4(int num) {
	      fight(num, 4, "성배", "뱀파이어");
	   }

	   // 전투 - 골렘
	   public void fight5(int num) {
	      fight(num, 5, "골렘");
	   }

	   // 전투 - 사신
	   public void fight6(int num) {
	      fight(num, 6, "성배", "사신");
	   }

	   // 전투 - 마왕
	   public void fight7(int num) {
	      fight(num, 7, "마왕");
	   }

	   // 전투 - 드래곤
	   public void fight8(int num) {
	      fight(num, 8, "창", "드래곤");
	   }

	   // 점수계산
	   public void score() {
	      temp=0;
	      for (int i = 0; i < ncLength(); i++) {
	         if (ncGet(i) == 1) {
	            temp += 1;
	         }
	         if (ncGet(i) == 2) {
	            temp += 2;
	         }
	         if (ncGet(i) == 3) {
	            temp += 3;
	         }
	         if (ncGet(i) == 4) {
	            temp += 4;
	         }
	         if (ncGet(i) == 5) {
	            temp += 5;
	         }
	         if (ncGet(i) == 6) {
	            temp += 6;
	         }
	         if (ncGet(i) == 7) {
	            temp += 7;
	         }
	         if (ncGet(i) == 8) {
	            temp += 9;
	         }
	      }
	      temp *= (7 - niLength());
	      System.out.println("획득 점수 : " + temp);
	      temp=0;
	   }

	   // 초기화 - 카드목록
	   public void rcReset(){
	      for (int i = rcLength() - 1; i >= 0; i--) {
	         rcDel(i);
	      }
	   }
	   
	   // 초기화 - 버린장비
	   public void riReset(){
	      for (int i = riLength() - 1; i >= 0; i--) {
	         riDel(i);
	      }
	   }
	   
	   // 초기화 - 현재카드
	   public void ncReset(){
	      for (int i = ncLength() - 1; i >= 0; i--) {
	         ncDel(i);
	      }
	   }
	   
	   // 초기화 - 현재장비
	   public void niReset(){
	      for (int i = niLength() - 1; i >= 0; i--) {
	         niDel(i);
	      }
	   }
	   
	   

	
	
	
}
//	String[] cardList = { "고블린", "해골전사", "오크", "뱀파이어", "골렘", "사신", "마왕", "드래곤" };
//
//	String[] cardListName = { "고블린", "고블린", "해골전사", "해골전사", "오크", "오크", "뱀파이어", "뱀파이어", "골렘", "골렘", "사신", "마왕", "드래곤" };
//
//	boolean exi = false;
//
//	private int score = 0;
//
//	public int getScore() {
//		return score;
//	}
//
//	public void setScore(int score) {
//		this.score = score;
//	}
//
//	private int hp = 3;
//
//	public int getHp() {
//		return hp;
//	}
//
//	public void setHp(int hp) {
//		this.hp = hp;
//	}
//
//	Scanner sc = new Scanner(System.in);
//	Random ran = new Random();
//
//	String select = "";
//
//	ArrayList<Integer> nowCard = new ArrayList<Integer>();
//
//	public void ncAdd(int num) {
//		nowCard.add(num);
//	}
//
//	public void ncAdd(int index, int num) {
//		nowCard.add(index, null);
//	}
//
//	public void ncDel(int num) {
//		nowCard.remove(num);
//	}
//
//	public int ncLength() {
//		return nowCard.size();
//	}
//
//	public int ncGet(int num) {
//		return nowCard.get(num);
//	}
//
//	public ArrayList<Integer> ncLast() {
//		return nowCard;
//	}
//
//	ArrayList<Integer> remainCard = new ArrayList<Integer>();
//
//	public void rcAdd(int num) {
//		remainCard.add(num);
//	}
//
//	public void rcAdd(int index, int num) {
//		remainCard.add(index, null);
//	}
//
//	public void rcDel(int num) {
//		remainCard.remove(num);
//	}
//
//	public int rcLength() {
//		return remainCard.size();
//	}
//
//	public int rcGet(int num) {
//		return remainCard.get(num);
//	}
//
//	ArrayList<String> nowItem = new ArrayList<String>();
//
//	public void niAdd(String name) {
//		nowItem.add(name);
//	}
//
//	public void niAdd(int index, String name) {
//		nowItem.add(index, name);
//	}
//
//	public void niDel(int num) {
//		nowItem.remove(num);
//	}
//
//	public int niLength() {
//		return nowItem.size();
//	}
//
//	public String niGet(int num) {
//		return nowItem.get(num);
//	}
//
//	ArrayList<String> remainItem = new ArrayList<String>();
//
//	public void riAdd(String name) {
//		remainItem.add(name);
//	}
//
//	public void riAdd(int index, String name) {
//		remainItem.add(index, name);
//	}
//
//	public void riDel(int num) {
//		remainItem.remove(num);
//	}
//
//	public int riLength() {
//		return remainItem.size();
//	}
//
//	public String riGet(int num) {
//		return remainItem.get(num);
//	}
//
//	private int go = 100; // 진행, 종료 선택여부 판단
//
//	public int goGet() {
//		return go;
//	}
//
//	int count = 0;
//	int temp = 0; // 임시 저장 공간
//
//	int[] tempNum = new int[3]; // 임시 숫자 저장
//	String midName = ""; // 가운데 카드 이름
//
//	// ASCII Art
//	public void aArt() {
//		System.out.println(
//				" .----------------.  .----------------.  .-----------------. .----------------.  .----------------.  .----------------.  .-----------------.\r\n"
//						+ "| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |\r\n"
//						+ "| |  ________    | || | _____  _____ | || | ____  _____  | || |    ______    | || |  _________   | || |     ____     | || | ____  _____  | |\r\n"
//						+ "| | |_   ___ `.  | || ||_   _||_   _|| || ||_   \\|_   _| | || |  .' ___  |   | || | |_   ___  |  | || |   .'    `.   | || ||_   \\|_   _| | |\r\n"
//						+ "| |   | |   `. \\ | || |  | |    | |  | || |  |   \\ | |   | || | / .'   \\_|   | || |   | |_  \\_|  | || |  /  .--.  \\  | || |  |   \\ | |   | |\r\n"
//						+ "| |   | |    | | | || |  | '    ' |  | || |  | |\\ \\| |   | || | | |    ____  | || |   |  _|  _   | || |  | |    | |  | || |  | |\\ \\| |   | |\r\n"
//						+ "| |  _| |___.' / | || |   \\ `--' /   | || | _| |_\\   |_  | || | \\ `.___]  _| | || |  _| |___/ |  | || |  \\  `--'  /  | || | _| |_\\   |_  | |\r\n"
//						+ "| | |________.'  | || |    `.__.'    | || ||_____|\\____| | || |  `._____.'   | || | |_________|  | || |   `.____.'   | || ||_____|\\____| | |\r\n"
//						+ "| |              | || |              | || |              | || |              | || |              | || |              | || |              | |\r\n"
//						+ "| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |\r\n"
//						+ " .----------------.  .----------------.  '----------------'  '----------------'  '----------------'  '----------------'  '----------------' \r\n"
//						+ "| .--------------. || .--------------. |                                                                                                    \r\n"
//						+ "| |     ____     | || |  _________   | |                                                                                                    \r\n"
//						+ "| |   .'    `.   | || | |_   ___  |  | |                                                                                                    \r\n"
//						+ "| |  /  .--.  \\  | || |   | |_  \\_|  | |                                                                                                    \r\n"
//						+ "| |  | |    | |  | || |   |  _|      | |                                                                                                    \r\n"
//						+ "| |  \\  `--'  /  | || |  _| |_       | |                                                                                                    \r\n"
//						+ "| |   `.____.'   | || | |_____|      | |                                                                                                    \r\n"
//						+ "| |              | || |              | |                                                                                                    \r\n"
//						+ "| '--------------' || '--------------' |                                                                                                    \r\n"
//						+ " .----------------.  .----------------.  .-----------------. .----------------.  .----------------.  .----------------.                     \r\n"
//						+ "| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |                    \r\n"
//						+ "| | ____    ____ | || |      __      | || | ____  _____  | || |  ________    | || |     ____     | || | ____    ____ | |                    \r\n"
//						+ "| ||_   \\  /   _|| || |     /  \\     | || ||_   \\|_   _| | || | |_   ___ `.  | || |   .'    `.   | || ||_   \\  /   _|| |                    \r\n"
//						+ "| |  |   \\/   |  | || |    / /\\ \\    | || |  |   \\ | |   | || |   | |   `. \\ | || |  /  .--.  \\  | || |  |   \\/   |  | |                    \r\n"
//						+ "| |  | |\\  /| |  | || |   / ____ \\   | || |  | |\\ \\| |   | || |   | |    | | | || |  | |    | |  | || |  | |\\  /| |  | |                    \r\n"
//						+ "| | _| |_\\/_| |_ | || | _/ /    \\ \\_ | || | _| |_\\   |_  | || |  _| |___.' / | || |  \\  `--'  /  | || | _| |_\\/_| |_ | |                    \r\n"
//						+ "| ||_____||_____|| || ||____|  |____|| || ||_____|\\____| | || | |________.'  | || |   `.____.'   | || ||_____||_____|| |                    \r\n"
//						+ "| |              | || |              | || |              | || |              | || |              | || |              | |                    \r\n"
//						+ "| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |                    \r\n"
//						+ " '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'         ");
//		System.out.println();
//		System.out.println(
//				" .----------------.  .----------------.  .----------------.  .----------------.   .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------. \r\n"
//						+ "| .--------------. || .--------------. || .--------------. || .--------------. | | .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |\r\n"
//						+ "| |    ______    | || |      __      | || | ____    ____ | || |  _________   | | | |    _______   | || |  _________   | || |  _______     | || |      __      | || |  _________   | || |              | |\r\n"
//						+ "| |  .' ___  |   | || |     /  \\     | || ||_   \\  /   _|| || | |_   ___  |  | | | |   /  ___  |  | || | |  _   _  |  | || | |_   __ \\    | || |     /  \\     | || | |  _   _  |  | || |      _       | |\r\n"
//						+ "| | / .'   \\_|   | || |    / /\\ \\    | || |  |   \\/   |  | || |   | |_  \\_|  | | | |  |  (__ \\_|  | || | |_/ | | \\_|  | || |   | |__) |   | || |    / /\\ \\    | || | |_/ | | \\_|  | || |     | |      | |\r\n"
//						+ "| | | |    ____  | || |   / ____ \\   | || |  | |\\  /| |  | || |   |  _|  _   | | | |   '.___`-.   | || |     | |      | || |   |  __ /    | || |   / ____ \\   | || |     | |      | || |     | |      | |\r\n"
//						+ "| | \\ `.___]  _| | || | _/ /    \\ \\_ | || | _| |_\\/_| |_ | || |  _| |___/ |  | | | |  |`\\____) |  | || |    _| |_     | || |  _| |  \\ \\_  | || | _/ /    \\ \\_ | || |    _| |_     | || |     | |      | |\r\n"
//						+ "| |  `._____.'   | || ||____|  |____|| || ||_____||_____|| || | |_________|  | | | |  |_______.'  | || |   |_____|    | || | |____| |___| | || ||____|  |____|| || |   |_____|    | || |     |_|      | |\r\n"
//						+ "| |              | || |              | || |              | || |              | | | |              | || |              | || |              | || |              | || |              | || |     (_)      | |\r\n"
//						+ "| '--------------' || '--------------' || '--------------' || '--------------' | | '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |\r\n"
//						+ " '----------------'  '----------------'  '----------------'  '----------------'   '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------' \r\n"
//						+ "\r\n" + "\r\n" + "");
//
//	}
//
//	public void print() {
//		System.out.print("첫 카드 세 장을 뽑습니다.");
//	}
//
//	// 진행, 종료
//	public void goStop() {
//		System.out.print("종료 0\t진행 1 >> ");
//		go = sc.nextInt();
//		if (go != 0 && go != 1) {
//			while (go != 0 && go != 1) {
//				System.out.print("0이나 1을 입력해주세요 >> ");
//				go = sc.nextInt();
//			}
//		}
//	}
//
//	// 중복 없이 카드 두장 뽑는 메소드
//	public void draw(int abcde) {
//		if (abcde == 2) {
//			count = 10;
//		} else if (abcde == 3) {
//			count = 8;
//		} else if (abcde == 4) {
//			count = 6;
//		} else if (abcde == 5) {
//			count = 4;
//		}
//
//		System.out.println("\n카드를 두 장 뽑습니다.");
//		for (int i = 0; i < 2; i++) {
//			tempNum[i] = ran.nextInt(count);
//			// 카드 두장 뽑기
//		}
//		for (int i = 1; i < 2; i++) {
//			if (tempNum[0] == tempNum[1]) {
//				tempNum[0] = ran.nextInt(count);
//				i = 0;
//			}
//			// 중복 확인
//		}
//
//		// 더 큰 값을 tempNum[0]에 넣어줌
//		if (tempNum[0] < tempNum[1]) {
//			temp = tempNum[0];
//			tempNum[0] = tempNum[1];
//			tempNum[1] = temp;
//		}
//
//		// 뽑은, 남은 카드에 저장
//		for (int i = 0; i < 2; i++) {
//			ncAdd(rcGet(tempNum[i]));
//			rcDel(tempNum[i]);
//			// 현재 카드 리스트에 추가
//			// 남은 카드 리스트에서 삭제
//		}
//	}
//
//	// 정렬
//	public void arr() {
//		temp = 0;
//		for (int i = 0; i < ncLength() - 1; i++) {
//			for (int j = i + 1; j < ncLength(); j++) {
//				if (ncGet(i) > ncGet(j)) {
//					ncAdd(ncGet(i));
//					ncDel(i);
//					j = i;
//				}
//			}
//		}
//	}
//
//	// 현재 카드 출력
//	public void ncNow() {
//		for (int i = 0; i < ncLength(); i++) {
//			System.out.print(ncGet(i) + "  ");
//		}
//		System.out.println();
//	}
//
//	// 현재 장비 출력
//	public void niNow() {
//		for (int i = 0; i < niLength(); i++) {
//			System.out.print(niGet(i) + "  ");
//		}
//	}
//
//	// 버릴 장비
//	public void select() {
//
//		System.out.print("\n버릴 장비\t: ");
//		select = sc.next();
////		System.out.println(!(select.equals("횃불")||select.equals("성배")||select.equals("창")
////					||select.equals("검")||select.equals("갑옷")||select.equals("방패")));
//		do {
//			if (!(select.equals("횃불") || select.equals("성배") || select.equals("창") || select.equals("검")
//					|| select.equals("갑옷") || select.equals("방패"))) {
//				System.out.print("없는 장비잆니다. 다시 선택해 주세요 : ");
//				select = sc.next();
//				exi = true;
//			} else if (riLength() == 0) {
//				exi = false;
//			} else if (riLength() != 0) {
//				for (int i = 0; i < riLength(); i++) {
//					if (select.equals(riGet(i))) {
//						System.out.print("없는 장비잆니다. 다시 선택해 주세요 : ");
//						select = sc.next();
//						i = -1;
//					}
//					exi = false;
//				}
//			}
//		} while (exi == true);
//
//		for (int i = 0; i < niLength(); i++) {
//			if (niGet(i).equals(select)) {
//				riAdd(niGet(i));
//				niDel(i);
//			}
//		}
//	}
//
//	// 장비 버리는 메소드(확률)
//	public void delItem() {
//		if (ran.nextInt(2) == 1) {
//			System.out.println("\n장비를 잃습니다");
//			// 현재 장비 출력
//			System.out.print("현재 장비\t: ");
//			niNow();
//			// 장비 버리기
//			select();
//		}
//	}
//
//	// 게임 이용자에게 현재 카드 출력
//	public void ncPrint(int mid) {
//		System.out.print("현재 카드\t: ");
//		for (int i = 0; i < ncLength(); i++) {
//			if (ncGet(i) == mid) {
//				if (i != ncLength() - 1 && ncGet(i) == ncGet(i + 1)) {
//					System.out.print("0  ");
//				} else {
//					System.out.print(ncGet(i) + "  ");
//				}
//			} else
//				System.out.print("0  ");
//		}
//		System.out.println();
//	}
//
//	// 현재 카드(이름으로) 출력
//	public void ncName() {
//		for (int i = 0; i < ncLength(); i++) {
//			if (ncGet(i) == 1) {
//				System.out.print("1." + cardList[0] + "  ");
//			} else if (ncGet(i) == 2) {
//				System.out.print("2." + cardList[1] + "  ");
//			} else if (ncGet(i) == 3) {
//				System.out.print("3." + cardList[2] + "  ");
//			} else if (ncGet(i) == 4) {
//				System.out.print("4." + cardList[3] + "  ");
//			} else if (ncGet(i) == 5) {
//				System.out.print("5." + cardList[4] + "  ");
//			} else if (ncGet(i) == 6) {
//				System.out.print("6." + cardList[5] + "  ");
//			} else if (ncGet(i) == 7) {
//				System.out.print("7." + cardList[6] + "  ");
//			} else if (ncGet(i) == 8) {
//				System.out.print("9." + cardList[7] + "  ");
//			}
//		}
//		System.out.println();
//	}
//
//	// 갑옷, 방패 효과
//	public int hpPlus() {
//		for (int i = 0; i < niLength(); i++) {
//			if (niGet(i).equals("갑옷")) {
//				temp = ran.nextInt(3) + 3;
//				setHp(getHp() + temp);
//				System.out.println("갑옷 효과로 체력이 " + temp + " 오릅니다.");
//			}
//			if (niGet(i).equals("방패")) {
//				temp = ran.nextInt(3) + 3;
//				setHp(getHp() + temp);
//				System.out.println("방패 효과로 체력이 " + temp + " 오릅니다.");
//			}
//		}
//		System.out.print("현재 체력 : " + hp);
//		return hp;
//	}
//
//	// 검으로 잡을 몬스터 선택
//	// 용사의 검으로 없앨 몬스터 선택
//	public void delMonster() {
//		for (int i = 0; i < niLength(); i++) {
//			if (niGet(i).equals("검")) {
//				System.out.println("용사의 검이 있습니다. 무찌를 몬스터를 정해주세요 : ");
//				System.out.println(" '고블린, 해골전사, 오크, 뱀파이어, 골렘, 사신, 마왕, 드래곤' ");
//				select = sc.next();
//				while (!select.equals("고블린") && !select.equals("해골전사") && !select.equals("오크") && !select.equals("뱀파이어")
//						&& !select.equals("골렘") && !select.equals("사신") && !select.equals("마왕")
//						&& !select.equals("드래곤")) {
//					System.out.print("존재하지 않는 몬스터입니다. 다시 선택해 주세요 : ");
//					select = sc.next();
//				}
//				if (select.equals("고블린")) {
//					temp = 1;
//				} else if (select.equals("해골전사")) {
//					temp = 2;
//				} else if (select.equals("오크")) {
//					temp = 3;
//				} else if (select.equals("뱀파이어")) {
//					temp = 4;
//				} else if (select.equals("골렘")) {
//					temp = 5;
//				} else if (select.equals("사신")) {
//					temp = 6;
//				} else if (select.equals("마왕")) {
//					temp = 7;
//				} else if (select.equals("드래곤")) {
//					temp = 8;
//				}
//				for (int j = ncLength() - 1; j >= 0; j--) {
//					if (ncGet(j) == temp) {
//						ncDel(j);
//
//					}
//				}
//			}
//		}
//	}
//
//	// 전투 - 고블린
//	public void fight1(int num) {
//		if (getHp() > 0) {
//			if (ncGet(num) == 1) {
//				for (int j = 0; j < niLength(); j++) {
//					if (niGet(j).equals("횃불")) {
//						exi = true;
//					}
//					if (exi == true) {
//						System.out.println("횃불로 고블린을 무찌릅니다");
//						break;
//					} else if (exi == false && j == niLength() - 1) {
//						System.out.println("고블린에게 체력이 1 닳습니다");
//						setHp(getHp() - 1);
//					}
//				}
//				exi = false;
//				System.out.println("현재 체력 : " + getHp());
//				System.out.println();
//			}
//		}
//
//	}
//
//	// 전투 - 해골전사
//	public void fight2(int num) {
//		boolean exi1 = false;
//		boolean exi2 = false;
//		if (getHp() > 0) {
//			if (ncGet(num) == 2) {
//				for (int j = 0; j < niLength(); j++) {
//					if (niGet(j).equals("횃불")) {
//						exi = true;
//					}
//					if (exi == true) {
//						System.out.println("횃불로 해골전사를 무찌릅니다");
//						break;
//					}
//				}
//				for (int j = 0; j < niLength(); j++) {
//					if (!niGet(j).equals("횃불") && niGet(j).equals("성배") && exi != true) {
//						exi1 = true;
//					}
//					if (exi1 == true) {
//						System.out.println("성배로 해골전사를 무찌릅니다");
//						break;
//					}
//				}
//				for (int j = 0; j < niLength(); j++) {
//					if (!niGet(j).equals("횃불") && !niGet(j).equals("성배") && exi != true && exi1 != true
//							&& j == niLength() - 1) {
//						exi2 = true;
//					}
//					if (exi2 == true) {
//						System.out.println("해골전사에게 체력이 2 닳습니다");
//						setHp(getHp() - 2);
//						break;
//					}
//				}
//				exi = false;
//				exi1 = false;
//				exi2 = false;
//
//				System.out.println("현재 체력 : " + getHp());
//				System.out.println();
//			}
//		}
//	}
//
//	// 전투 - 오크
//	public void fight3(int num) {
//		if (getHp() > 0) {
//			if (ncGet(num) == 3) {
//				for (int j = 0; j < niLength(); j++) {
//					if (niGet(j).equals("횃불")) {
//						exi = true;
//					}
//					if (exi == true) {
//						System.out.println("횃불로 오크를 무찌릅니다");
//						break;
//					} else if (exi == false && j == niLength() - 1) {
//						System.out.println("오크에게 체력이 3 닳습니다");
//						setHp(getHp() - 3);
//					}
//				}
//				exi = false;
//				System.out.println("현재 체력 : " + getHp());
//				System.out.println();
//			}
//		}
//	}
//
//	// 전투 - 뱀파이어
//	public void fight4(int num) {
//		if (getHp() > 0) {
//			if (ncGet(num) == 4) {
//				for (int j = 0; j < niLength(); j++) {
//					if (niGet(j).equals("성배")) {
//						exi = true;
//					}
//					if (exi == true) {
//						System.out.println("성배로 뱀파이어를 무찌릅니다");
//						break;
//					} else if (exi == false && j == niLength() - 1) {
//						System.out.println("뱀파이어에게 체력이 4 닳습니다");
//						setHp(getHp() - 4);
//					}
//				}
//				exi = false;
//				System.out.println("현재 체력 : " + getHp());
//				System.out.println();
//			}
//		}
//	}
//
//	// 전투 - 골렘
//	public void fight5(int num) {
//		if (getHp() > 0) {
//			if (ncGet(num) == 5) {
//				System.out.println("골렘에게 체력이 5 닳습니다");
//				setHp(getHp() - 5);
//				System.out.println("현재 체력 : " + getHp());
//				System.out.println();
//			}
//		}
//	}
//
//	// 전투 - 사신
//	public void fight6(int num) {
//		if (getHp() > 0) {
//			if (ncGet(num) == 6) {
//				for (int j = 0; j < niLength(); j++) {
//					if (niGet(j).equals("성배")) {
//						exi = true;
//					}
//					if (exi == true) {
//						System.out.println("성배로 사신을 무찌릅니다");
//						break;
//					} else if (exi == false && j == niLength() - 1) {
//						System.out.println("사신에게 체력이 6 닳습니다");
//						setHp(getHp() - 6);
//					}
//				}
//				exi = false;
//				System.out.println("현재 체력 : " + getHp());
//				System.out.println();
//			}
//		}
//	}
//
//	// 전투 - 마왕
//	public void fight7(int num) {
//		if (getHp() > 0) {
//			if (ncGet(num) == 7) {
//				System.out.println("마왕에게 체력이 7 닳습니다");
//				setHp(getHp() - 7);
//				System.out.println("현재 체력 : " + getHp());
//				System.out.println();
//			}
//		}
//	}
//
//	// 전투 - 드래곤
//	public void fight8(int num) {
//		if (getHp() > 0) {
//			if (ncGet(num) == 8) {
//				for (int j = 0; j < niLength(); j++) {
//					if (niGet(j).equals("창")) {
//						exi = true;
//					}
//					if (exi == true) {
//						System.out.println("창으로 드래곤을 무찌릅니다");
//						break;
//					} else if (exi == false && j == niLength() - 1) {
//						System.out.println("드래곤에게 체력이 9 닳습니다");
//						setHp(getHp() - 9);
//					}
//				}
//				exi = false;
//				System.out.println("현재 체력 : " + getHp());
//				System.out.println();
//			}
//		}
//	}
//
//	// 점수계산
//	public void score() {
//		for (int i = 0; i < ncLength(); i++) {
//			if (ncGet(i) == 1) {
//				score += 1;
//			}
//			if (ncGet(i) == 2) {
//				score += 2;
//			}
//			if (ncGet(i) == 3) {
//				score += 3;
//			}
//			if (ncGet(i) == 4) {
//				score += 4;
//			}
//			if (ncGet(i) == 5) {
//				score += 5;
//			}
//			if (ncGet(i) == 6) {
//				score += 6;
//			}
//			if (ncGet(i) == 7) {
//				score += 7;
//			}
//			if (ncGet(i) == 8) {
//				score += 9;
//			}
//		}
//		score *= (7 - niLength());
//		System.out.println("획득 점수 : " + score);
//	}
//
//}
