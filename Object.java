package game;

import java.io.Serializable;

public class Object implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
    boolean moveable;
	
	
	Object(String Name , boolean Moveable){
		
		name = Name;
		moveable = Moveable;
		
	}
	
	public String toString() {
	
		return name ;
	}

}
