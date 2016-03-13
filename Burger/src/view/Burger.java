package view;

public class Burger {
	private MyStack<String> node;
	private MyStack<String> burger;
	private MyStack<String> baronBurger;
	private MyStack<String> recipe;
	MyStack<String> myBurger;
	MyStack<String> patty;

	boolean work;
	public Burger (boolean theWorks){
		work = theWorks;
		baronBurger = new MyStack<String>();
		burger = new MyStack<String>();
		recipe = new MyStack<String>();
		recipe.push("Bun");
		recipe.push("Ketchup");
		recipe.push("Mustard");
		recipe.push("Mushrooms");
		recipe.push("Patty");
		recipe.push("Cheddar");
		recipe.push("Mozzarella");
		recipe.push("Pepperjack");
		recipe.push("Onions");
		recipe.push("Tomato");
		recipe.push("Lettuce");
		recipe.push("Baron-Sauce");
		recipe.push("Mayonnaise");
		recipe.push("Bun");
		recipe.push("Pickle");
		//System.out.println(recipe.toString());
		//StringBuilder builder = new StringBuilder();
		if(theWorks){

			baronBurger.push("Bun");
			baronBurger.push("Ketchup");
			baronBurger.push("Mustard");
			baronBurger.push("Mushrooms");
			baronBurger.push("Beef");
			baronBurger.push("Cheddar");
			baronBurger.push("Mozzarella");
			baronBurger.push("Pepperjack");
			baronBurger.push("Onions");
			baronBurger.push("Tomato");
			baronBurger.push("Lettuce");
			baronBurger.push("Baron-Sauce");
			baronBurger.push("Mayonnaise");
			baronBurger.push("Bun");
			baronBurger.push("Pickle");
			patty = baronBurger;
		}
		else if(!theWorks){
			work = theWorks;
			burger.push("Bun");
			burger.push("Beef");
			burger.push("Bun");
			patty = burger;
		}

	}
	public void changePatties(String pattyType){
		int size = patty.size();
		MyStack<String> newStack = new MyStack<String>();
		while(size !=0){

			String newPatty = patty.pop();
			if(newPatty.equals("Beef")){
				newPatty = pattyType;
				
			}
			newStack.push(newPatty);
			size--;
		}
		flip(newStack);

	}
	private void flip(MyStack<String> theBurger) {

		int size2 = theBurger.size();
		while(size2 > 0) {
			String str = theBurger.pop();
			patty.push(str);
			size2--;
		}
	}
	public void addPatty(){
		MyStack<String> myNewBurger = new MyStack<String>();
		boolean added = true;
		int size = patty.size();
			for(int i = 0; i< size;i++){
				String food = patty.pop();

				if (food.equals("Pepperjack") || 
						food.equals("Mozzarella")||
						food.equals("Cheddar")||food.equals("Beef")) {
					if(added) {
						myNewBurger.push("Beef");
						added = false;
					}

				}
				myNewBurger.push(food);
		}
		
		flip(myNewBurger);
	}
	public void removePatty(){
		MyStack<String> newStack = new MyStack<String>();
		int size = patty.size();
		boolean remove = true;
		int number = 0;
		while(size >= 0){

			String food = patty.pop();
			newStack.push(food);
			if(food.equals("Chicken") || 
					food.equals("Beef")||
					food.equals("Veggies")) {
				number++;

			}
			if (food.equals("Chicken") || 
					food.equals("Beef")||
					food.equals("Veggies")) {

				if(remove && number > 1){
					newStack.pop();
					remove = false;
					size--;
				}
				size--;

			}
			size--;
		}
		flip(newStack);		

	}
	public void addCategory(String type){
		
		switch(type){
		case "Sauce":
			addIngredient("Ketchup");
			addIngredient("Mustard");
			addIngredient("Baron-Sauce");
			addIngredient("Mayonnaise");
			break;
		case "Cheese":
			addIngredient("Cheddar");	
			addIngredient("Mozzarella");
			addIngredient("Pepperjack");
			break;
		case "Veggies":
			addIngredient("Mushrooms");
			addIngredient("Onions");
			addIngredient("Tomato");
			addIngredient("Lettuce");
			addIngredient("Pickle");
			break;
		default:
			break;
		}
	}
	public void removeCategory(String type){
		switch(type){
		case "Sauce":
			removeIngredient("Ketchup");
			removeIngredient("Mustard");
			removeIngredient("Baron-Sauce");
			removeIngredient("Mayonnaise");
			break;
		case "Cheese":
			removeIngredient("Cheddar");	
			removeIngredient("Mozzarella");
			removeIngredient("Pepperjack");
			break;
		case "Veggies":
			removeIngredient("Mushrooms");
			removeIngredient("Onions");
			removeIngredient("Tomato");
			removeIngredient("Lettuce");
			removeIngredient("Pickle");
			break;
		default:
			break;
		}
		
	}
	public void addIngredient(String type){
		MyStack<String> newStack2 = new MyStack<String>();
		MyStack<String> newStack = new MyStack<String>();
		int size = recipe.size();
		while(size>0){
			String recpoped = recipe.pop();
			newStack2.push(recpoped);
			String peek = patty.peek();
			if(recpoped.equals(peek)||recpoped.equals(type)){
				if(recpoped.equals(peek)){
					String poped = patty.pop();
					newStack.push(poped);
				}
				else if(recpoped.equals(type)){
					newStack.push(type);
				}
			}
			size--;
		}
		while(newStack2.size()!=0){
			recipe.push(newStack2.pop());
		}
		while(patty.size()>0){
			newStack.push(patty.pop());
		}
		flip(newStack);
	}
	public void removeIngredient(String type){
		int size = patty.size();
		MyStack<String> newStack = new MyStack<String>();
		while(size>0){
			String pop = patty.pop();
			newStack.push(pop);
			if(pop.equals(type)){
				newStack.pop();
			}
			size--;
		}
		while(patty.size()>0){
			newStack.push(patty.pop());
		}
		flip(newStack);
	}
	public String toString(){
		
		return patty.toString();
	}
}