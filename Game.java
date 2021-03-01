package game;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Game {

//	public Game() {
	public static void main(String[] args) {
		Object plate = new Object("plate", false);
		Object comb = new Object("comb", false);
		Object chair = new Object("chair", true);
		Object phone = new Object("phone", false);
		Object lamp = new Object("lamp", true);
		Object mirror = new Object("mirror", false);
		Object TV = new Object("TV", true);
		Object tissue = new Object("tissue", false);
		Object soap = new Object("soap", false);
		Object shampoo = new Object("shampoo", true);
		Object[] obj = { plate, comb, chair, phone, lamp, mirror, TV, tissue, soap, shampoo };

		Room kitchen = new Room("kitchen", 0, "beautifull and bright", plate, chair, lamp);
		Room livingroom = new Room("livingroom", 1, "big and spacious", TV, plate, phone);
		Room bedroom = new Room("bedroom", 2, "small and cozy", mirror, lamp, comb);
		Room bathroom = new Room("bathroom", 3, "small and warm", tissue, soap, shampoo);
		Room[] room = { kitchen, livingroom, bedroom, bathroom };

		FileInputStream fi;
		Person personFromFile = null;
		try {
			fi = new FileInputStream(new File("person.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			personFromFile = (Person) oi.readObject();
		} catch (FileNotFoundException e2) {
			
			e2.printStackTrace();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		}

		Player playerFromFile = null;
		try {
			fi = new FileInputStream(new File("player.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			playerFromFile = (Player) oi.readObject();
		} catch (FileNotFoundException e2) {

			e2.printStackTrace();
		} catch (IOException e1) {

			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {

			e1.printStackTrace();
		}

//		System.out.println("Person from file: " + personFromFile);
//		System.out.println("Player from file: " + playerFromFile);
		Person pe = personFromFile != null ? personFromFile : new Person(" Alex", livingroom, lamp, room);

		final Player pl = playerFromFile != null ? playerFromFile : new Player(" Mat", kitchen, lamp, chair, shampoo);
		final Gui gui = new Gui();

		new Thread(() -> {
			while (true) {
				pe.walk();
				
			}
		}).start();

		new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {

					e1.printStackTrace();
				}
//				System.out.println("updating");
				gui.getShowPerson().setText(pe.toString());
				Gui.showRoom.setText(pl.location.toString());
				Gui.showplayer.setText(pl.toString());
			}
		}).start();

		Gui.showRoom.setText(pl.location.toString());
		Gui.showplayer.setText(pl.toString());
		gui.getShowPerson().setText(pe.toString());

		ActionListener inputListener = e -> {
			String command;
			command = Gui.input.getText();

			for (int i = 0; i < 4; i++) {

				if (command.trim().equals(room[i].name)) {

					pl.location = room[i];

				}
			}

			for (int k = 0; k < 10; k++) {

				if (command.equals(obj[k].name)) {

//					System.out.println(obj[k].name);

					Object x = obj[k];
//					System.out.println(k);
					pl.addObject(x);
					pl.toString();
//					System.out.println(pl.toString());
					Gui.showRoom.setText(pl.location.toString());
					Gui.showplayer.setText(pl.toString());

				}

			}

		};

		Gui.button.addActionListener(inputListener);
		Gui.save.addActionListener(e -> {
			FileOutputStream f, fPerson;
			try {
				f = new FileOutputStream(new File("player.txt"));
				ObjectOutputStream o = new ObjectOutputStream(f);

				o.writeObject(pl);
				o.close();

				fPerson = new FileOutputStream(new File("person.txt"));
				ObjectOutputStream oPerson = new ObjectOutputStream(fPerson);

				oPerson.writeObject(pe);
				oPerson.close();

			} catch (FileNotFoundException e1) {
				
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}

		});

	}

}
