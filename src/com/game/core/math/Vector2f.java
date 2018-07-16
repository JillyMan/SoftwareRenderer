package com.game.core.math;

public class Vector2f {
	public float x;
	public float y;
	
	public Vector2f(Vector2f vec) {
		x = vec.x;
		y = vec.y;
	}
	
	public Vector2f() {
		x = y = 0;
	}
	
	public Vector2f normalize() {
		float len = length();
		return new Vector2f(x/len, y/len);
	}
	
	public float length() {
		return (float)Math.sqrt(x*x + y*y);
	}
	
	public static void swap(Vector2f a, Vector2f b) {
		float tx = b.x;
		float ty = b.y;
		b.x = a.x;
		b.y = a.y;
		a.x = tx;
		a.y = ty;
	}

	public Vector2f(float x, float y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Vector2f add(float scalar) {
		x += scalar;
		y += scalar;
		return this;
	}

	public Vector2f mult(float scalar) {
		x *= scalar;
		y *= scalar;
		return this;
	}

	public Vector2f div(float scalar) {
		x /= scalar;
		y /= scalar;
		return this;
	}

	public Vector2f minus(float scalar) {
		x -= scalar;
		y -= scalar;
		return this;
	}
	
	public Vector2f add(Vector2f v) {
		x += v.x;
		y += v.y;
		return this;
	}
	
	public Vector2f minus(Vector2f v) {
		x -= v.x;
		y -= v.y;
		return this;
	}
	
	public Vector2f mult(Vector2f v) {
		x *= v.x;
		y *= v.y;
		return this;
	}
	
	public Vector2f div(Vector2f v) {
		x /= v.x;
		y /= v.y;
		return this;
	}	
}