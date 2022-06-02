
public class Object {
	

	private String name;
	private String category;
	private double weight;
	private double gain;
	
	public Object(String name,String category,double weight,double gain) {
		this.name = name;
		this.category = category;
		this.weight = weight;
		this.gain = gain;
	}

	public String getName() {
		return this.name;
	}

	public String getCategory() {
		return this.category;
	}

	public double getWeight() {
		return this.weight;
	}

	public double getGain() {
		return this.gain;
	}

	public double getValue() {
		return this.gain/this.weight;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setGain(double gain) {
		this.gain = gain;
	}
}
