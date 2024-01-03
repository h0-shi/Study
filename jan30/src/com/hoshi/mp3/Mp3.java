package com.hoshi.mp3;

import java.io.File;


import jaco.mp3.player.MP3Player;

public class Mp3 {
	public static void main(String[] args) {
		File file = new File("c:/temp/Our Night.mp3");

		MP3Player mp3Player = new MP3Player(file);
		mp3Player.play();
		try {
			Thread.sleep(254000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
