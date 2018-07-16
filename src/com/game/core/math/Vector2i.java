package com.game.core.math;

public class Vector2i {
	public int x;
	public int y;
	
	public Vector2i(Vector2i vec) {
		x = vec.x;
		y = vec.y;
	}
	
	public Vector2i() {
		x = y = 0;
	}
	
	public Vector2i(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "X: " + x + " Y: " + y;
	}
	
	public static void swap(Vector2i a, Vector2i b) {
		int tx = b.x;
		int ty = b.y;
		b.x = a.x;
		b.y = a.y;
		a.x = tx;
		a.y = ty;
	}

	public Vector2i add(int scalar) {
		x += scalar;
		y += scalar;
		return new Vector2i(x, y);
	}

	public Vector2i mult(int scalar) {
		x *= scalar;
		y *= scalar;
		return new Vector2i(x, y);
	}

	public Vector2i div(int scalar) {
		x /= scalar;
		y /= scalar;
		return new Vector2i(x, y);
	}

	public Vector2i minus(int scalar) {
		x -= scalar;
		y -= scalar;
		return new Vector2i(x, y);
	}
	
	public Vector2i add(Vector2i v) {
		x += v.x;
		y += v.y;
		return new Vector2i(x, y);
	}
	
	public Vector2i minus(Vector2i v) {
		x -= v.x;
		y -= v.y;
		return new Vector2i(x, y);
	}
	
	public Vector2i mult(Vector2i v) {
		x *= v.x;
		y *= v.y;
		return new Vector2i(x, y);
	}
	
	public Vector2i div(Vector2i v) {
		x /= v.x;
		y /= v.y;
		return new Vector2i(x, y);
	}	
}