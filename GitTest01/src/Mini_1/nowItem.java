package Mini_1;

import java.util.ArrayList;

public class nowItem {
	ArrayList<String> nowItem= new ArrayList<String>();
	
	public void add(String name) {
		nowItem.add(name);
	}
	
	public void add(int index, String name) {
		nowItem.add(index, name);
	}

	public void del(int num) {
		nowItem.remove(num);
	}
	
	public int length() {
		return nowItem.size();
	}

	public String get(int num) {
		return nowItem.get(num);
	}
	
	

	
	

}
