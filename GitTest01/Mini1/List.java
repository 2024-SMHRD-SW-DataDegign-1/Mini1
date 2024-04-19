package Mini1;

import java.util.ArrayList;

import DungeonBgm.DBgm;

public class List {
	   private ArrayList<Integer> nowCard = new ArrayList<Integer>();

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

	   // - - - - - //
	   
	   private ArrayList<Integer> remainCard = new ArrayList<Integer>();

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

	   // - - - - - //
	   
	   private ArrayList<String> nowItem = new ArrayList<String>();

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

	   // - - - - - //
	   
	   private ArrayList<String> remainItem = new ArrayList<String>();
	
	   public void riAdd(String name) {
	      remainItem.add(name);
	   }

	   public void riAdd(int index, String name) {
	      remainItem.add(index, name);
	   }

	   public void riDel(int num) {
	      remainItem.remove(num);
	   }

	   public int riLength() {
	      return remainItem.size();
	   }

	   public String riGet(int num) {
	      return remainItem.get(num);
	   }
	   
	   
	   
	   
	   
	   
	   
	   

	}

