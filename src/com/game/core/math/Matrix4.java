package com.game.core.math;
import com.game.core.math.Vector3f;

public class Matrix4 {
    private final int MAX_SIZE = 16;
	public double[] elements;

    public Matrix4() {
    
    	elements = new double[MAX_SIZE];
    	for(int i = 0; i < 16; ++i) {
    		elements[i] = 0.0;
    	}   	
    }
    
    public static Matrix4 identity(double diogonal) {
    	
    	Matrix4 identity = new Matrix4();
    	
    	identity.elements[0 + 0 * 4] = diogonal;
    	identity.elements[1 + 1 * 4] = diogonal;
    	identity.elements[2 + 2 * 4] = diogonal;
    	identity.elements[3 + 3 * 4] = diogonal;
    	return identity;
    }
    
    public static Matrix4 translation(Vector3f translate) {
    	
    	Matrix4 result = identity(1.0);
    	
    	result.elements[0 + 3 * 4] = translate.x;
    	result.elements[1 + 3 * 4] = translate.y;
    	result.elements[2 + 3 * 4] = translate.z;

    	return result;
    }
    
    public static Matrix4 rotation(float angle, Vector3f axis) {
    	Matrix4 result = identity(1.0f);

		double r = Math.toRadians(angle);
		double c = Math.cos(r);
		double s = Math.sin(r);
		double omc = 1.0f - c;

		double x = axis.x;
		double y = axis.y;
		double z = axis.z;

		result.elements[0 + 0 * 4] = x * omc + c;
		result.elements[1 + 0 * 4] = y * x * omc + z * s;
		result.elements[2 + 0 * 4] = x * z * omc - y * s;

		result.elements[0 + 1 * 4] = x * y * omc  - z  * s;
		result.elements[1 + 1 * 4] = y * omc + c;
		result.elements[2 + 1 * 4] = y * z * omc + x * s;

		result.elements[0 + 2 * 4] = x * z * omc + y * s;
		result.elements[1 + 2 * 4] = y * z * omc - x * s;
		result.elements[2 + 2 * 4] = z * omc + c;

		return result;
    }
    
    public static Matrix4 scale(Vector3f scale) {
    	Matrix4 result = identity(1.0);
    	
    	result.elements[0 + 0 * 4] = scale.x;
    	result.elements[1 + 1 * 4] = scale.y;
    	result.elements[2 + 2 * 4] = scale.z;
    	
    	return result;
    }

    public static Matrix4 ortho(double left, double right, double botton, double top, double near, double far) {
		Matrix4 ortho = new Matrix4();
		ortho.elements[0 + 0 * 4] = 2.0f / (right - left);
		ortho.elements[1 + 1 * 4] = 2.0f / (top - botton);
		ortho.elements[2 + 2 * 4] = 2.0f / (near - far);
		ortho.elements[0 + 3 * 4] = (left + right) / (left - right);
		ortho.elements[1 + 3 * 4] = (botton + top) / (botton - top);
		ortho.elements[2 + 3 * 4] = (far + near) / (far - near);
		ortho.elements[3 + 3 * 4] = 1;
		return ortho;
    }
    
    public static Matrix4 perspective(double fov, double aspectRatio, double near, double far) {
    	Matrix4 perspective = identity(1.0f);
    	double p = 1.0f / Math.tan(Math.toRadians(0.5 * fov));
    	double a = p / aspectRatio;

    	double b = (near + far) / (near - far);
    	double c = (2.0f * near * far) / (near - far);

		perspective.elements[0 + 0 * 4] = a;
		perspective.elements[1 + 1 * 4] = p;
		perspective.elements[2 + 2 * 4] = b;
		perspective.elements[3 + 2 * 4] = -1.0f;
		perspective.elements[2 + 3 * 4] = c;

		return perspective;
    }
    
    public Matrix4 multiply(Matrix4 other) {
    	for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				double  sum = 0.0;
				for (int e = 0; e < 4; e++) {
					sum += elements[j + e * 4] * other.elements[e + i * 4];
				}
				elements[j + i * 4] = sum;
			}
		}
		return this;
    }
}