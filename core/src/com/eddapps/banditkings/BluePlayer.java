package com.eddapps.banditkings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class BluePlayer extends Sprite {
	
	private static final float SPEED = 500.0f;
	private Rectangle mRectangle;
	private boolean isGoingLeft = true;
	
	public BluePlayer(){
		super(new Texture(Gdx.files.internal("badlogic.jpg")));
		setSize(100.0f, 100.0f);
		setPosition(Gdx.graphics.getWidth()/2, 0);
		mRectangle = new Rectangle(getX(), getY(), getWidth(), getHeight());
	}
	
	public void update(){
		if(Gdx.input.isKeyPressed(Input.Keys.A)){
			if(!isGoingLeft){ 
				flip(true, false);
				isGoingLeft = true;
			}
			this.translateX(-SPEED * Gdx.graphics.getDeltaTime());
		}else if(Gdx.input.isKeyPressed(Input.Keys.D)){
			if(isGoingLeft){ 
				flip(true, false);
				isGoingLeft = false;
			}
			this.translateX(SPEED * Gdx.graphics.getDeltaTime());
		}
		mRectangle.set(getX(), getY(), getWidth(), getHeight());
	}
	
	public Rectangle getRectangle(){ return mRectangle; }
	
}
