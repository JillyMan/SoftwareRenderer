package com.game.core.math;

import com.game.core.math.Vector3f;

public class Sphere {
	private Vector3f center;
	private float radius;
	private Vector3f color;
	private float specular;

	public Sphere(Vector3f center, float radius, float specular, Vector3f color) {
		super();
		this.center = center;
		this.radius = radius;
		this.color = color;
		this.specular = specular;
	}
	
	public float getSpecular() {
		return specular;
	}

	public void setSpecular(float specular) {
		this.specular = specular;
	}
	
	public Vector3f getCenter() {
		return center;
	}
	
	public void setCenter(Vector3f center) {
		this.center = center;
	}
	
	public float getRadius() {
		return radius;
	}
	
	public void setRadius(float radius) {
		this.radius = radius;
	}
	
	public Vector3f getColor() {
		return color;
	}
	 
	public void setColor(Vector3f color) {
		this.color = color;
	}
}
