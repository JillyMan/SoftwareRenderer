package com.game.core.math;

public class Vector3f {
	public float x;
	public float y;
	public float z;

	public Vector3f (Vector3f v) {
		super();
		this.x = v.x;
		this.y = v.y;
		this.z = v.z;
	}	
	
	public Vector3f(float x, float y, float z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}	

	public String toString() {
		return("X: " + x + "\nY: " + y + "\nZ: " + z);
	}
	
	public boolean equeals(Vector3f obj) {
		boolean result = false;
		if(x == obj.x && obj.y == y && obj.z == z) {
			result = true;
		}
		return result;
	}
	
	public static void swap(Vector3f a, Vector3f b) {
		float tx = b.x;
		float ty = b.y;
		float tz = b.z;
		b.x = a.x;
		b.y = a.y;
		b.z = a.z;
		a.x = tx;
		a.y = ty;
		a.z = tz;
	}

	public static Vector3f crossProduct(Vector3f v1, Vector3f v2) {
		float i = v1.y*v2.z - v1.z*v2.y;
		float j = v1.z*v2.x - v1.x*v2.z;
		float k = v1.x*v2.y - v1.y*v2.x;

		Vector3f normals = new Vector3f(i, j, k);
		return normals;
	}
	
	public static float dotProduct(Vector3f v1, Vector3f v2) {
		float scalar = v1.x*v2.x + v1.y*v2.y + v1.z*v2.z;
		return scalar;
	}
	
	public Vector3f intvert() {
		return new Vector3f(-x, -y, -z);
	}
	
	public Vector3f normalize() {
		float len = length();
		return new Vector3f(x/len, y/len, z/len);
	}
	
	public float length() {
		return (float)Math.sqrt(x*x + y*y + z*z);
	}

	public Vector3f mult(float s) {
		return new Vector3f (x*s, y*s, z*s);
	}

	
	public Vector3f add(Vector3f  v) {
		return new Vector3f (x + v.x, y + v.y, z + v.z);
	}
	
	public Vector3f minus(Vector3f v) {
		return new Vector3f (x - v.x, y - v.y, z - v.z);
	}
	
	public Vector3f mult(Vector3f v) {
		return new Vector3f (x * v.x, y * v.y, z * v.z);
	}
	
	public Vector3f div(Vector3f  v) {
		return new Vector3f (x / v.x, y / v.y, z / v.z);
	}		
}