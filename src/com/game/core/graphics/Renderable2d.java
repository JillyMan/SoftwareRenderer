package com.game.core.graphics;

import com.game.core.math.Vector2f;
import com.game.core.math.Vector3f;

public abstract class Renderable2d {
	private Vector2f pos;
	private Vector3f color;

	public Renderable2d(Vector2f pos, Vector3f color) {
		this.pos = pos;
		this.color = color;
	}
	
	public Vector2f getPos() {
		return pos;
	}

	public void setPos(Vector2f pos) {
		this.pos = pos;
	}
	
	public Vector3f getColor() {
		return color;
	}
	
	public void setColor(Vector3f color) {
		this.color = color;
	} 		
}
