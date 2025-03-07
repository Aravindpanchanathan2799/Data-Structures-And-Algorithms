/**
 *  Module A11 Fixed capacity bags
 *  Task 1: Basic Implementation
 */
package ds.bag;

import java.util.Date;

/**
 * Testing Class for Various Types of Bags
 * @author Mayuri Jadhav
 */
public class TestBags {
	
	public static void test1FixedCapacityBag() {
		System.out.println("Create an empty bag of strings with capacity 5");
		FixedCapacityBag<String> bag = new FixedCapacityBag<>(5);		
		System.out.println("Bag: "+bag.toString());
		System.out.println("Bag is singleton: "+bag.isSingleton());
		System.out.println("Add the item: book");
		bag.add("book");
		System.out.println("Bag is singleton: "+bag.isSingleton());
		System.out.println("Bag: "+bag.toString());
		System.out.println("Add the items: bag, computer, phone, key");
		bag.add("bag");
		bag.add("computer");
		bag.add("phone");
		bag.add("key");
		System.out.println("Bag is singleton: "+bag.isSingleton());
		System.out.println("Bag: "+bag.toString());
		System.out.println("How many items start with b?");
		int count=0;
		for (String item: bag) {
			if (item.charAt(0)=='b') count++;
		}
		System.out.println("There are "+count+" items that start with b.");
	}
	public static void test2FixedCapacityBag() {
		System.out.println("Create an empty bag of integers with capacity 7");
		FixedCapacityBag<Integer> bag = new FixedCapacityBag<>(7);		
		System.out.println("Bag: "+bag.toString());
		//System.out.println("Bag is singleton: "+bag.isSingleton());
		//System.out.println("Is the Bag Empty or Not(True/False):" + bag.isEmpty());
		
		System.out.println("Add the item: 54");
		bag.add(54);
		//System.out.println("Bag is singleton: "+bag.isSingleton());
		//System.out.println("Is the Bag Empty or Not(True/False):" + bag.isEmpty());
		System.out.println("Bag: "+bag.toString());
		System.out.println("Add the items: 92, 24, 68, 31, 79, 82");
		bag.add(92);
		bag.add(24);
		bag.add(68);
		bag.add(31);
		//System.out.println("Bag is singleton: "+bag.isSingleton());
		bag.add(79);
		bag.add(82);
		//System.out.println("Size of the Bag:" + bag.size());
		System.out.println("Bag: "+bag.toString());
		
		//System.out.println("Size of the Bag:" + bag.size());
		
	}
	public static void test3FixedCapacityBag() {
		System.out.println("Create an empty bag of doubles with capacity 4");
		FixedCapacityBag<Double> bag = new FixedCapacityBag<>(4);		
		System.out.println("Bag: "+bag.toString());
		System.out.println("Bag is singleton: "+bag.isSingleton());
		
		System.out.println("Add the item: 1.67");
		bag.add(1.67);	
		System.out.println("Bag: "+bag.toString());
		System.out.println("Bag is singleton: "+bag.isSingleton());
		
		System.out.println("Add the items: 2.92, 4.34, 8.48");
		bag.add(2.92);
		bag.add(4.34);
		bag.add(8.48);
		System.out.println("Bag: "+bag.toString());
		System.out.println("Bag is singleton: "+bag.isSingleton());
		
	}
	public static void test4FixedCapacityBag() {
		System.out.println("Create an empty bag of longs with capacity 4");
		FixedCapacityBag<Long> bag = new FixedCapacityBag<>(4);		
		System.out.println("Bag: "+bag.toString());
		
		System.out.println("Add the item: 1*10^10");
		bag.add(1*10000000000L);
		System.out.println("Bag: "+bag.toString());
		System.out.println("Bag is singleton: "+bag.isSingleton());
		
		System.out.println("Add the items: 2*10^10, 4*10^10, 8*10^10");
		bag.add(2*10000000000L);
		bag.add(4*10000000000L);
		bag.add(8*10000000000L);
		System.out.println("Bag: "+bag.toString());
		System.out.println("Bag is singleton: "+bag.isSingleton());
	}
	
	public static void testFixedCapacityBagOfStrings(String name1, String name2, String name3, String name4, String name5) {
		System.out.println("Create an empty bag of strings with capacity 5");
		FixedCapacityBag<String> bag = new FixedCapacityBag<>(5);		
		System.out.println("Bag: "+bag.toString());
		System.out.println("Bag is singleton: "+bag.isSingleton());
		System.out.println("Add the item: "+name1);
		bag.add(name1);
		System.out.println("Bag: "+bag.toString());
		System.out.println("Bag is singleton: "+bag.isSingleton());
		System.out.println("Add the items: "+name2+", "+name3+", "+name4+", "+name5);
		bag.add(name2);
		bag.add(name3);
		bag.add(name4);
		bag.add(name5);
		System.out.println("Bag: "+bag.toString());
		System.out.println("Bag is singleton: "+bag.isSingleton());
		System.out.println("How many items start with b?");
		int count=0;
		// We can use this form of for because Bag is iterable.
		for (String item: bag) {
			if (item.charAt(0)=='b') count++;
		}
		System.out.println("There are "+count+" items that start with b.");
	}

	public static void test1DynamicCapacityBag() {
		System.out.println("Create an empty bag of strings with the initial capacity of 2");
		DynamicCapacityBag<String> bag = new DynamicCapacityBag<>(2);
		System.out.println("Bag: "+bag.toString());
		// --> T2c. Modify the test bag class to check if the bag is a singleton, when created
		System.out.println("Bag is singleton: "+bag.isSingleton());
		System.out.println("Add the item: book");
		bag.add("book");
		System.out.println("Bag: "+bag.toString());
		// --> T2c. Modify the test bag class to check if the bag is a singleton, after adding the first element
		System.out.println("Bag is singleton: "+bag.isSingleton());
		System.out.println("Add the items: bag, computer, phone, key");
		bag.add("bag");
		bag.add("computer");
		bag.add("phone");
		bag.add("key");
		System.out.println("Bag: "+bag.toString());
		// --> T2c. Modify the test bag class to check if the bag is a singleton, after adding the next 4 elements
		System.out.println("Bag is singleton: "+bag.isSingleton());
		System.out.println("How many items start with b?");
		int count=0;
		// We can use this form of for because Bag is iterable.
		for (String item: bag) {
			if (item.charAt(0)=='b') count++;
		}
		System.out.println("There are "+count+" items that start with b.");
	}

	public static void testDynamicCapacityBagOfStrings(String name1, String name2, String name3, String name4, String name5) {
		System.out.println("Create an empty bag of strings with initial capacity 2");
		DynamicCapacityBag<String> bag = new DynamicCapacityBag<>(2);
		System.out.println("Bag: "+bag.toString());
		System.out.println("Bag is singleton: "+bag.isSingleton());
		System.out.println("Add the item: "+name1);
		bag.add(name1);
		System.out.println("Bag: "+bag.toString());
		System.out.println("Bag is singleton: "+bag.isSingleton());
		System.out.println("Add the items: "+name2+", "+name3+", "+name4+", "+name5);
		bag.add(name2);
		bag.add(name3);
		bag.add(name4);
		bag.add(name5);
		System.out.println("Bag: "+bag.toString());
		System.out.println("Bag is singleton: "+bag.isSingleton());
		System.out.println("How many items start with b?");
		int count=0;
		// We can use this form of for because Bag is iterable.
		for (String item: bag) {
			if (item.charAt(0)=='b') count++;
		}
		System.out.println("There are "+count+" items that start with b.");
	}


	public static <Item> void testIsEmpty(Bag<Item> bag, Item[] items) {
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("Initial Bag: "+bag.toString());
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("Bag is emtpy: "+bag.isEmpty());
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("Max Frequency of the Bag: " + maxFreq(bag));
		System.out.println("-------------------------------------------------------------------------");
		for (int i=0; i<items.length; i++) {
			System.out.println("Add item: "+items[i]);
			bag.add(items[i]);
			System.out.println("Bag: "+bag.toString());
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("Bag is emtpy: "+bag.isEmpty());
			System.out.println("-------------------------------------------------------------------------");
			//System.out.println("Max Frequency of the Bag: " + maxFreq(bag));
			//System.out.println("-------------------------------------------------------------------------");
		}
	}

	public static <Item> void testIsSingleton(Bag<Item> bag, Item[] items) {
		System.out.println("Initial Bag: "+bag.toString());
		System.out.println("Bag is singleton: "+bag.isSingleton());
		for (int i=0; i<items.length; i++) {
			System.out.println("Add item: "+items[i]);
			bag.add(items[i]);
			System.out.println("Bag: "+bag.toString());
			System.out.println("Bag is singleton: "+bag.isSingleton());
		}

	}

	public static void testBag() {
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("Create an empty bag of strings with the initial capacity of 2");
		System.out.println("-------------------------------------------------------------------------");
		DynamicCapacityBag<String> bag = new DynamicCapacityBag<>(2);
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("Bag: "+bag.toString());
		System.out.println("-------------------------------------------------------------------------");
		// --> T2c. Modify the test bag class to check if the bag is a singleton, when created
		System.out.println("Bag is singleton: "+bag.isSingleton());
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("Add the item: book");
		System.out.println("-------------------------------------------------------------------------");
		bag.add("book");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("Bag: "+bag.toString());
		System.out.println("-------------------------------------------------------------------------");
		// --> T2c. Modify the test bag class to check if the bag is a singleton, after adding the first element
		System.out.println("Bag is singleton: "+bag.isSingleton());
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("Add the items: bag, computer, phone, key");
		System.out.println("-------------------------------------------------------------------------");
		bag.add("bag");
		bag.add("computer");
		bag.add("phone");
		bag.add("key");
		System.out.println("Bag: "+bag.toString());
		System.out.println("-------------------------------------------------------------------------");

		try {
			System.out.println("Add the sixth element: moeny");
			System.out.println("-------------------------------------------------------------------------");
			bag.add("money");
			System.out.println("-------------------------------------------------------------------------");
		} catch (Exception e) {
			System.out.println("Error trying to add a sixth element" + e);
			System.out.println("-------------------------------------------------------------------------");
		}
		System.out.println("Bag is singleton: "+bag.isSingleton());
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("How many items start with b?");
		System.out.println("-------------------------------------------------------------------------");
		int count=0;
		// We can use this form of for because Bag is iterable.
		for (String item: bag) {
			if (item.charAt(0)=='b') count++;
		}
		System.out.println("There are "+count+" items that start with b.");
		System.out.println("-------------------------------------------------------------------------");
	}
	
	public static <Item> void testAdd(Bag<Item> bag, Item[] items) {
		System.out.println("Initial Bag: "+bag.toString());
		for (int i=0; i<items.length; i++) {
			System.out.println("Add item: "+items[i]);
			bag.add(items[i]);
			System.out.println("Bag: "+bag.toString());
		}
	}
	
	public static <Item> int maxFreq(Bag<Item> bag) {
		if(bag == null|| bag.isEmpty())
		{
			return 0;
		}
		int maxFrequency = 0;
		for(Item item: bag) {
		int currentFrequency = 0;
			for(Item element: bag) {
				if(element.equals(item)) {
					currentFrequency++;	
				}
			}
			if(currentFrequency>maxFrequency) {
				maxFrequency=currentFrequency;
			}
		}
		return maxFrequency;
		
	}
	
	
	public static <Item> void testMaxFreq(Bag<Item> bag, Item[] items) {
		System.out.println("Initial Bag: "+bag.toString());
		System.out.println("Max Freq: "+bag.maxFreq());
		for (int i=0; i<items.length; i++) {
			System.out.println("Add item: "+items[i]);
			bag.add(items[i]);
			System.out.println("Bag: "+bag.toString());
			System.out.println("Max Freq: "+bag.maxFreq());
		}
	}

	public static void main(String[] args) {
		System.out.println("Linked List Bags- Task 2a - adapted by Mayuri Jadhav");
		Date date = new Date();
		System.out.println("Executed on: "+date.toString());
		//String[] items = {"apple", "bannana", "orange", "mango", "strawberry"};
		//FixedCapacityBag<String> fcb = new FixedCapacityBag<>(5);
		//testIsEmpty(fcb,items);
		//Double[] items2 = {3.2, 1.7, 2.3, 6.4, 7.5};
		//DynamicCapacityBag<Double> dcb = new DynamicCapacityBag<>(2);
		//testIsSingleton(dcb,items2);
		//String[] items = {"apple", "bannana", "orange", "mango", "strawberry"};
		//LinkedListBag<String> llb = new LinkedListBag<>();
		//testAdd(llb,items);
		
		Integer[] items2 = {10, 22, 31, 42, 22, 33, 42, 33, 42, 42, 44};
		FixedCapacityBag<Integer> fcb = new FixedCapacityBag<>(11);
		testMaxFreq(fcb, items2);
		DynamicCapacityBag<Integer> dcb = new DynamicCapacityBag<>(2);
		testMaxFreq(dcb, items2);
		LinkedListBag<Integer> llb = new LinkedListBag<>();
		testMaxFreq(llb, items2);	
		//testDynamicCapacityBagOfStrings("apple","oranges","mango","banana","pineapple");
	}

}
