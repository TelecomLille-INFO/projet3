/**
 * 
 */
package jeux;

import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.Image;

/**
 * @author nicolaspicart, jeancastel
 *
 */

public class WindowsGame extends BasicGame {

	private GameContainer container;
	private TiledMap map;
	private float x = 284, y = 276;
	private int direction = 0;
	private boolean moving = false;
	private Animation[] animations = new Animation[8];
	SpriteSheet spriteSheet;
	static Link link;

	public static void main(String[] args) throws SlickException {
		link = new Link("castwab.ddns.net", 2015);
		AppGameContainer container = new AppGameContainer(new WindowsGame(), 600, 600, false);
		container.start();
		
	}

	public WindowsGame() {
		super("Zelfa");
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		g.translate(container.getWidth() / 2 - (int) this.x, container.getHeight() / 2 - (int) this.y);
		this.map.render(0, 0);
		g.setColor(Color.black);
		g.fillOval(x, y+35, 32, 16);
		Player player = new Player();
		Animation[] animations = player.CreateAnimation(new Image("resources/characters/char2.png"), 32, 48, 4);;
		g.drawAnimation(animations[direction + (moving ? 4 : 0)], x, y);
		
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		this.container = container;
		this.map = new TiledMap("resources/map/map.tmx");
	}


	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		if (this.moving) {
	        switch (this.direction) {
	            case 0: this.y -= .1f * delta; break;
	            case 1: this.x -= .1f * delta; break;
	            case 2: this.y += .1f * delta; break;
	            case 3: this.x += .1f * delta; break;
	        }
	    }
	}

	@Override
	public void keyReleased(int key, char c) {
		this.moving = false;

	}
	@Override
	public void keyPressed(int key, char c) {
	    switch (key) {
	        case Input.KEY_UP:    this.direction = 0; this.moving = true; break;
	        case Input.KEY_LEFT:  this.direction = 1; this.moving = true; break;
	        case Input.KEY_DOWN:  this.direction = 2; this.moving = true; break;
	        case Input.KEY_RIGHT: this.direction = 3; this.moving = true; break;
	    }
	}
	
	public String getXY(){
		String varx = Float.toString(x);
		String vary = Float.toString(y);
		return varx+'/'+vary;
	}

}
