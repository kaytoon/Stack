package view;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Mian {
	static ArrayList<String> array;
	public int myPattyCount;
	public String myPattyType;
	public String myOmissions;
	public String myExceptions;
	static Burger newBurger;

	public static void main(String[] args) throws IOException {
		//testMyStack();
		//testBurger();
		FileReader file = new FileReader("customer.txt");
		BufferedReader reader = new BufferedReader(file);
		String line = reader.readLine();
		//Burger burger = new Burger(true);
		while(line !=null) {
			parseLine(line);
			line = reader.readLine();
			System.out.println(newBurger.toString());
		}
		reader.close();
	}
	public static void parseLine(String line){
		boolean work = false;
		String[] newLine = line.split(" ");
		array = new ArrayList<String> ();
		for(int i=0; i<newLine.length;i++){
			array.add(newLine[i]);
		}
		if(line.contains("Baron Burger")) {
			array.remove("Baron");

			//baronBurger(array);
			work = true;
		}

		newBurger = new Burger(work);


		if (array.size()>1){
			String firstIndex = array.get(0);
			String secondIndex = array.get(1);
			baronBurger(array);
			putPatty(firstIndex,secondIndex);






		}

	}
	private static void baronBurger(ArrayList<String> line) {
		array.remove("Burger");
		int size = line.size();
		if(size >1 && line.get(1).equals("no")){
			int index = 0;
			array.remove("with");
			array.remove("no");
			if(array.contains("but")){
				index =  array.indexOf("but");
				array.remove("but");
			}
			else{
				index = array.size();
			}
			for(int i = 0; i < index;i++){
				String j = array.get(0);
				newBurger.removeCategory(j);
				array.remove(0);
			}

			if(!array.isEmpty()){
				for(int i = 0; i<=array.size();i++){
					newBurger.addIngredient(array.get(0));
					array.remove(0);
				}
			}
		}
		else if(array.size()>1 &&!line.get(1).equals("no")){
			array.remove("with");
			int index = 0;
			if(array.contains("but")){
				index =  array.indexOf("but");
				array.remove("but");
			}
			else{
				index = array.size();
			}
			for(int i = 0; i < index;i++){
				if(array.get(0).equals("Cheese")||array.get(0).equals("Sauce")
						||array.get(0).equals("Veggies")){

					String k = array.get(0);
					newBurger.addCategory(k);
					array.remove(0);
				}
				else {
					String k = array.get(0);
					newBurger.addIngredient(k);
					array.remove(0);
				}
			}
			if(!array.isEmpty()){
				int size2 = array.size();
				for(int i = 0; i < size2;i++)
					newBurger.removeIngredient(array.get(0));
				array.remove(0);
			}

		}
	}
	private static void putPatty(String burgerCount, String burgerType) {

		switch (burgerCount){
		case "Double": 
			newBurger.addPatty();
			array.remove("Double");

			break;
		case "Triple":
			newBurger.addPatty();
			newBurger.addPatty();
			array.remove("Triple");
			break;

		default:
			break;
		}
		array.remove("Burger");
		switch (burgerType){
		case "Chicken": 
			newBurger.changePatties("Chicken");
			array.remove("Chicken");
			break;
		case "Veggie":
			newBurger.changePatties("Veggie");
			array.remove("Veggie");
			break;

		default:
			break;
		}

	}
	

	private static void testMyStack(){
		MyStack<String> stack = new MyStack<String>();
		stack.push("Bun");
		stack.push("lettece");
		stack.push("patty");
		stack.push("cheese");
		stack.push("patty");
		stack.push("Bun");

		System.out.println(stack.toString());
		stack.pop();
		System.out.println(stack.toString());

	}
	static void testBurger(){
		Burger burger = new Burger(true);
		System.out.println(burger.toString());
		burger.addPatty();
		burger.addPatty();
		System.out.println(burger.toString());
		//burger.changePatties("Chicken");
		//System.out.println("Before patty is removed");

		burger.removePatty();
		//burger.removePatty();
		System.out.println(burger.toString());
	}

}
