package Mini_1;

import java.util.ArrayList;

public class remainCard {
	ArrayList<Integer> remainCard= new ArrayList<Integer>();
	
	public void add(int num) {
		remainCard.add(num);
	}
	
	public void add(int index, int num) {
		remainCard.add(index, null);
	}

	public void del(int num) {
		remainCard.remove(num);
	}
	
	public int length() {
		return remainCard.size();
	}

	public int get(int num) {
		return remainCard.get(num);
	}
	
	

	
	

}
