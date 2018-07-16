package com.game.core;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.game.core.graphics.Renderer;
import com.game.core.input.InputHandler;

public class Game extends Canvas {
	private static final long serialVersionUID = 1L;

	public final static int WIDTH = 800;
	public final static int HEIGHT = 600;
	public final static String TITLE = "Software Renderer";
	private boolean running = false;
	
	private JFrame frame;
	
	private BufferStrategy bs;
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	private Renderer renderer;

	private float x = 100, y = 50;
	private float w = 50, h = 50;
	private float dx = 256.0f, dy = 0.0f;
	private float gx = 0.0f, gy = 98.1f;
	private float speed = 1 << 8; 
	
	public Game() {
		frame = new JFrame();
		renderer = new Renderer(WIDTH, HEIGHT, pixels);
		run();
	}

	public void init() {
		frame.add(this);
		frame.pack();
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocation(100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle(TITLE);
		frame.setVisible(true);
		frame.addKeyListener(new InputHandler());
	}
	
	public void run() {
		init();
		running = true;
		new Thread(()-> {
			long jvmLastTime = System.nanoTime();
			long timer = System.currentTimeMillis();
			double jvmPartTime = 1_000_000_000.0 / 60.0;
			double delta = 0.0;
			int updates = 0;
			int frames = 0;
			while(running) {
				long jvmNowTime = System.nanoTime();
				delta += (jvmNowTime - jvmLastTime);
				jvmLastTime = jvmNowTime;
				
				if(delta > jvmPartTime) {
					update(delta);
					delta = 0.0;
					++updates;
				}
				
				render();
				++frames;
				if(System.currentTimeMillis() - timer > 1000) {
					timer += 1000;
					frame.setTitle(TITLE + " | Fps: " + frames + " | Updates: " + updates);
					updates = frames = 0;					
				}
				
			}
		}).start();
	}
	
	public void render() {
		if(bs == null) {
			createBufferStrategy(3);
		}
		bs = getBufferStrategy();
		renderer.clear();
		renderer.drawRect((int)x, (int)y, (int)(x+w), (int)(y+h));
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}
	
	public void update(double dt) {
		dt /= 1e9;
		
		x += dx*dt;
		y += dy*dt;
		
		dx += gx*dt;
		dy += gy*dt;
		
		
		
		if(x+w > WIDTH) dx*=-1;
		if(x < 0) dx *= -1;
		if(y+h > HEIGHT) dy*=-1;
		if(y < 0) { dy*=-1; }
		
		
/*		if(InputHandler.isKeyPressed(KeyEvent.VK_W)) {
			y -= speed*dt;
		}
		
		if(InputHandler.isKeyPressed(KeyEvent.VK_S)) {
			y += speed*dt;
			
		}
		
		if(InputHandler.isKeyPressed(KeyEvent.VK_A)) {
			x -= speed*dt;
			
		}

		if(InputHandler.isKeyPressed(KeyEvent.VK_D)) {
			x += speed*dt;			
		}
*/
	}
	
	public static void main(String[] args) {
		new Game();
	}	
}