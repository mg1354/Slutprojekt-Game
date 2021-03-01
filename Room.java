package game;

import java.io.Serializable;
import java.util.Arrays;

public class Room implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	int number;
	String description;
	Object[] appliance = new Object[3];

	Room(String name, int number, String description, Object a, Object b, Object c) {
		this.name = name;
		this.number = number;
		this.description = description;
		appliance[0] = a;
		appliance[1] = b;
		appliance[2] = c;

	}

	public String toString() {
		return  " Here is the " + this.name + ".\n  " + this.description + "\n  objects: "
				+ Arrays.toString(appliance);
	}
	
	public String getPlace() {
		return this.name;
	}

	
}
