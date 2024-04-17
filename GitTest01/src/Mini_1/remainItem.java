package Mini_1;

import java.util.ArrayList;

public class remainItem {
	ArrayList<Integer> remainItem= new ArrayList<Integer>();
	
	public void add(int num) {
		remainItem.add(num);
	}
	
	public void add(int index, int num) {
		remainItem.add(index, null);
	}

	public void del(int num) {
		remainItem.remove(num);
	}
	
	public int length() {
		return remainItem.size();
	}

	public int get(int num) {
		return remainItem.get(num);
	}
	
	

	
	

}
