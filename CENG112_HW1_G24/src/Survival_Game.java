import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Survival_Game {
	
	public static void sort(ArrayList<Object> alist) {
		for(int i = 0; i<alist.size();i++) { // I implemented a sorting algorithm
			double max_val = alist.get(i).getValue();
			Object max_obj = alist.get(i);
			int max_index = i;
			for(int j = i;j<alist.size();j++) {
				if(max_val < alist.get(j).getValue()) {
					max_val = alist.get(j).getValue();
					max_obj = alist.get(j);
					max_index = j;}}
			Object temp_object = alist.get(i);
			alist.set(i, max_obj);
			alist.set(max_index, temp_object);}
	}
	
	public static void main(String[] args) throws IOException {
		Box first_aid = new Box();
		Box clothing = new Box();
		Box food_drink = new Box();
		Box tools = new Box();
		Box backpack = new Box();
		Scanner scan = new Scanner(System.in);
		File file = new File("items.txt");
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((line = br.readLine()) != null) {
				String[] my_line = line.split(",");
				String name = my_line[0],category = my_line[1];
				double weight = Double.valueOf(my_line[2]);
				double gain = Double.valueOf(my_line[3]);
				Object this_object = new Object(name,category,weight,gain);
				switch(Integer.valueOf(category)) {
				case 0:
					clothing.addItem(this_object);
					break;
				case 1:
					food_drink.addItem(this_object);
					break;
				case 2:
					first_aid.addItem(this_object);
					break;
				case 3:
					tools.addItem(this_object);
					break;
				}
			}
			
			sort(clothing.items);
			sort(food_drink.items);
			sort(first_aid.items);
			sort(tools.items);			
			
			// Initial interface 
			System.out.println("Welcome to Survival Game!");
			System.out.println("********************************************");
			System.out.println("Clothing      " +clothing.getSize()+"items   |    "+clothing.getWeight()+"kg");
			System.out.println("Food & Drink  "+food_drink.getSize()+"items    |    "+food_drink.getWeight()+"kg");
			System.out.println("First Aid     "+first_aid.getSize()+"items    |    "+first_aid.getWeight()+"kg");
			System.out.println("Tool          "+tools.getSize()+"items    |    "+tools.getWeight()+"kg");
			System.out.println("********************************************");
			int option = 5;
			while (true) {
				
				if (!backpack.isempty()){
					backpack.clear();
				} 
				System.out.println("Select Difficulty:");
				System.out.println("[0] Pilgrim [1] Voyager [2] Stalker [3] Interloper [9] Exit");
				option = scan.nextInt();
				if (option == 0) {backpack.setLimit(9);}
                else if (option == 1) {backpack.setLimit(7);}
                else if (option == 2) {backpack.setLimit(5);}
                else if (option == 3) {backpack.setLimit(3);}
                else if (option == 9) {break;}
				
				
				
				while (!(clothing.isempty() && food_drink.isempty() && first_aid.isempty() && tools.isempty() )) {
					
					if (clothing.getSize() >= food_drink.getSize() && clothing.getSize() >= first_aid.getSize() && clothing.getSize() >= tools.getSize()){
						if(!backpack.addItem(clothing.getItem())) {
							break;
						}
						else {
							clothing.delItemFirst();
						}
					}
					else if (food_drink.getSize() >= first_aid.getSize() && food_drink.getSize() >= tools.getSize() && food_drink.getSize() > clothing.getSize()) {
						if(!backpack.addItem(food_drink.getItem())) {
							break;
						}		
						else {
							food_drink.delItemFirst();
						}
					}
					else if (first_aid.getSize() >= tools.getSize() && first_aid.getSize() > clothing.getSize() && first_aid.getSize() > food_drink.getSize()) {
						if(!backpack.addItem(first_aid.getItem())) {
							break;
						}
						else {
							first_aid.delItemFirst();
						}
					}
					else if (tools.getSize() > clothing.getSize() && tools.getSize() > first_aid.getSize() &&  tools.getSize() > food_drink.getSize()) {
						if(!backpack.addItem(tools.getItem())) {
							break;
						}
						else {
							tools.delItemFirst();
						}	
					}
				}
				System.out.println("********************************************");
				System.out.println("Clothing      " +clothing.getSize()+"items    |    "+clothing.getWeight()+"kg");
				System.out.println("Food & Drink  "+food_drink.getSize()+"items    |    "+food_drink.getWeight()+"kg");
				System.out.println("First Aid     "+first_aid.getSize()+"items    |    "+first_aid.getWeight()+"kg");
				System.out.println("Tool          "+tools.getSize()+"items    |    "+tools.getWeight()+"kg");
				System.out.println("Backpack      "+backpack.getSize()+"items   |    "+backpack.getWeight()+"kg");
				System.out.println("Lifespan      "+backpack.getDays()+"days");
				System.out.println("********************************************");	
				if (clothing.isempty() && food_drink.isempty() && first_aid.isempty() && tools.isempty()) {
					break;
				}
			}
			if (!(option == 9)) {
				System.out.println("No items left in the boxes.");
			}
			else {
				System.out.println("You exit the game.");
			}
		}
	}
		
}













