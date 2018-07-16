package com.game.core.graphics;

import com.game.core.math.Vector3f;

public class Vertex {
	Vector3f position;
	Vector3f color;
	
	public Vertex() {}
	public Vertex(Vector3f pos, Vector3f col) {
		this.position = pos;
		this.color = col;
	}
	
	public void setColor(Vector3f col) {
		this.color = col;
	}
	
	public Vector3f getColor() {
		return color;
	}
	
	public void setPosiotion(Vector3f pos) {
		this.position = pos;
	}

	public Vector3f getPosition() {
		return position;
	}
}
