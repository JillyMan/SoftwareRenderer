package com.game.core.graphics;

import java.util.ArrayList;
import java.util.List;

public abstract class Renderer {
	private int CLEAR_COLOR = 0x000000;
	protected int width, height;
	private int[] pixels;
	//TODO: hmm maybe add array vertecies??
	public Renderer(int width, int height, int[] pixels) {
		this.width = width;
		this.height = height;
		this.pixels = pixels;
	}
	
	public void setBackColor(int color) {
		CLEAR_COLOR = color;			
	}
	
	public void clear() {
		for(int i = 0; i < width*height; ++i) {
			pixels[i] = CLEAR_COLOR; 
		}
	}
	
	public abstract void submit();
	public abstract void flush();	
}
