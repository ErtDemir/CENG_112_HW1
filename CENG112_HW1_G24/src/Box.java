import java.util.ArrayList;

public class Box {
	ArrayList<Object> items = new ArrayList<Object>();	
	private double limit = 99999999;// It will be needed only in backpack

	public boolean addItem(Object item) {
		if(!checkLimit(item.getWeight())) {
			items.add(item);
			return true;}
		return false;
	}
	public boolean isempty() {
		return this.items.isEmpty();
	}
	public void delItemFirst() {
		items.remove(0);
	}
	public void clear() {
		this.items.removeAll(items);
		}	
	public double getSize() {
		return items.size();
	}
	public double getWeight() {
		double total = 0;
		for(Object item: items) {
			total += item.getWeight();
		}
		return total;
	}
	public double getDays() {
		double day = 0;
		for(Object item: items) {
			day+=item.getGain();
		}
		return day;
	}
	public void setLimit(double limit) {
		this.limit = limit;
	}
	public boolean checkLimit(double weight) {
		if(getWeight()+weight>this.limit) {
			return true;
		}
		return false;
	}
	public Object getItem() {
		return items.get(0);
		
	}
}