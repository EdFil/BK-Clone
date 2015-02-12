package com.eddapps.banditkings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class BluePlayer extends Sprite {
	
	private static final float SPEED = 500.0f;
	private boolean isGoingLeft = true;
	private Bag mBag;
	
	public BluePlayer(){
		super(new Texture(Gdx.files.internal("badlogic.jpg")));
		setSize(100.0f, 100.0f);
		setPosition(Gdx.graphics.getWidth()/2, 0);
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
	}
	
	public void debugDraw(ShapeRenderer shapeRenderer){
		shapeRenderer.setColor(Color.BLUE);
		shapeRenderer.rect(getBoundingRectangle().x, getBoundingRectangle().y, getBoundingRectangle().width, getBoundingRectangle().height);
	}

	public void setBag(Bag bag) {
		mBag = bag;
	}

	public boolean isHoldingBag() {
		return mBag != null;
	}

	public void deleteBag() {
		if(isHoldingBag()){
			mBag.setPosition(-100.0f, -100.0f);
			mBag.mBluePlayer = null;
			mBag = null;
		}
	}
	
}
