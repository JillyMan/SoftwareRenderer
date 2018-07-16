package com.core.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

	public static final int MAX_KEY = 256;
	private static boolean[] keys = new boolean[MAX_KEY];
	
	public static boolean isKeyPressed(int keyCode) {
		boolean result = false;
		if(keyCode < MAX_KEY) {
			result = keys[keyCode];
		}
		return result;
	}
	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {		
	}	
}
