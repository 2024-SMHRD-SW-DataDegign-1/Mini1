package Mini_1;

import java.util.ArrayList;

public class nowCard {
	ArrayList<Integer> nowCard= new ArrayList<Integer>();
	
	public void add(int num) {
		nowCard.add(num);
	}
	
	public void add(int index, int num) {
		nowCard.add(index, null);
	}

	public void del(int num) {
		nowCard.remove(num);
	}
	
	public int length() {
		return nowCard.size();
	}

	public int get(int num) {
		return nowCard.get(num);
	}
	
	public ArrayList<Integer> last() {
		return nowCard;
	}

	
	

}
