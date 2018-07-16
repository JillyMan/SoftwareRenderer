package com.game.core.math;

public class Triangle {
	public Vector2f v1;
	public Vector2f v2;
	public Vector2f v3;
	public int  color;
	
	public Triangle(Vector2f v1, Vector2f v2, Vector2f v3, int color) {
		super();
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
		this.color = color;
	}	
}
