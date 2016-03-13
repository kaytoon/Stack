# Stack
On this project i create a program that can take text orders in a specific format and

construct a custom burger with all ingredients in the proper order.

my program implements the MyStack class as a linked structure​that function

according to the following interface:

● MyStack <Type> () ­ a constructor that initializes an empty MyStack.

● boolean isEmpty() ­ returns true if the MyStack is empty.

● void push(Type item) ­ this method adds the item to the top of the MyStack .

● Type pop() ­ this method removes and returns the item on the top of the MyStack .

● Student peek() ­ this method returns the item on the top of the MyStack but does not

alter the MyStack .

● int size() ­ this method returns the number of items in the MyStack.

● String toString() ­ this method converts the contents of the MyStack to a String for

display.


My program will implement the Burger class using only the MyStack class that must function

according to the following interface:

● Burger (boolean theWorks) ­ a constructor that initializes a Burger with only a bun and

patty if theWorks is false and a Baron Burger if theWorks is true.

● void changePatties(String pattyType) ­ this method changes all patties in the Burger to

the pattyType.

● void addPatty() ­ this method adds one patty to the Burger up to the maximum of 3.

● void removePatty() ­ this method removes one patty from the Burger down to the

minimum of 1.

● void addCategory(String type) ­ this method adds all items of the type to the Burger in

the proper locations.

● void removeCategory(String type) ­ this method removes all items of the type from the

Burger.

● void addIngredient(String type) ­ this method adds the ingredient type to the Burger in

the proper location.

● void removeIngredient(String type) ­ this method removes the ingredient type from the

Burger.

● String toString() ­ this method converts the Burger to a String for display.

The Burger class does not use any List type in Java or arrays. It only use the MyStack

class to store ingredients​. 

Finally, my program also provide a Main class that is used to read in the input file and test

and run the Burger class.

● void main(String[] args) ­ static main method used to run the program and test the

program elements.

● void parseLine(String line) ­ parses a line of input from the file and outputs the burger.

● void testMyStack() ­ test method for MyStack.

● void testBurger() ­ test method for Burger.
