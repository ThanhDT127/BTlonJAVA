package Main;

import Panel.Sound;

public class Main {
	public static void main(String[] args) {
		new View();
		Sound sound = new Sound();
		sound.soundThread.start();

	}
}
