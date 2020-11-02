import java.util.Scanner;

public class Meal {

	public Meal() {

	}
	
	private String name;
	private String category;
	private String description;
	private double price;
	private int calories;

	public Meal(String category, String name, String description, int calories, double price) {
		super();
		this.category = category;
		this.name = name;
		this.description = description;
		this.calories = calories;
		this.price = price;
		
	}

	
		
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	@Override
	public String toString() {
		return "Meal [  name=" + name + ", category=" + category + ", description="
				+ description + ", price=" + price + ", calories=" + calories + "]";
	}

	
	}


