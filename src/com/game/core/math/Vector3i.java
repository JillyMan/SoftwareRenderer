package com.game.core.math;

public class Vector3i {
	public int x;
	public int y;
	public int z;

	public Vector3i (Vector3i v) {
		super();
		this.x = v.x;
		this.y = v.y;
		this.z = v.z;
	}	
	
	public Vector3i(int f, int g, int h) {
		super();
		this.x = f;
		this.y = g;
		this.z = h;
	}	

	public String toString() {
		return("X: " + x + "\nY: " + y + "\nZ: " + z);
	}
	
	public static void swap(Vector3i a, Vector3i b) {
		int tx = b.x;
		int ty = b.y;
		int tz = b.z;
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
	
	public static float dot(Vector3i v1, Vector3i v2) {
		float scalar = v1.x*v2.x + v1.y*v2.y + v1.z*v2.z;
		return scalar;
	}
	
	public Vector3i normalize() {
		float len = length();
		return new Vector3i((int)(x/len), (int)(y/len), (int)(z/len));
	}
	
	public float length() {
		return (float)Math.sqrt(x*x + y*y + z*z);
	}
	
	public Vector3i add(int s) {
		return new Vector3i (x + s, y + s, z + s);
	}
	
	public Vector3i minus(int s) {
		return new Vector3i (x - s, y - s, z - s);
	}
	
	public Vector3i mult(int s) {
		return new Vector3i (x * s, y * s, z * s);
	}
	
	public Vector3i div(int s) {
		return new Vector3i (x / s, y / s, z / s);
	}		
	
	public Vector3i add(Vector3i v) {
		return new Vector3i (x + v.x, y + v.y, z + v.z);
	}
	
	public Vector3i minus(Vector3i v) {
		return new Vector3i (x - v.x, y - v.y, z - v.z);
	}
	
	public Vector3i mult(Vector3i  v) {
		return new Vector3i (x * v.x, y * v.y, z * v.z);
	}
	
	public Vector3i div(Vector3i  v) {
		return new Vector3i (x / v.x, y / v.y, z / v.z);
	}		
}