package Panel;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound implements Runnable {
	//them
	public Clip clip;
	public URL soundURL[]= new URL[30];
	public Thread soundThread = new Thread(this);
	
	
	public Sound( ) {
		soundURL[0] = getClass().getResource("/sound/soundtrackwa.wav");
		soundURL[1] = getClass().getResource("/sound/animalSound3.wav");
		soundURL[2] = getClass().getResource("/sound/selection.wav");
		soundURL[3] = getClass().getResource("/sound/enterwa.wav");
		soundURL[4] = getClass().getResource("/sound/colection.wav");
		soundURL[5] = getClass().getResource("/sound/seed.wav");
		soundURL[6] = getClass().getResource("/sound/pig.wav");
		soundURL[7] = getClass().getResource("/sound/cow.wav");
		soundURL[8] = getClass().getResource("/sound/chicken.wav");	
	}
	
	

	public void setFile(int i) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
		} catch (Exception e) {

		}
	}
	public void play() {
		clip.start();
	}
	public void loop() {
		clip.loop(clip.LOOP_CONTINUOUSLY);
	}
	public void soundstop() {
		clip.stop();
	}

	// them
	public void soundTrack() {
		this.playMusic(0);
		this.playMusic(1);
	}
	public void playMusic(int i) {
		this.setFile(i);
		this.play();
		this.loop();
	}
	public void stopMusic() {
		this.soundstop();
	}
	public void playSE(int i) {
		this.setFile(i);
		this.play();
		
	}
	// them
	@Override
	public void run() {
		long i = System.currentTimeMillis();
		if( System.currentTimeMillis() - i <= 50000) {
			soundTrack();
		}
		else i = System.currentTimeMillis();
	}
}
