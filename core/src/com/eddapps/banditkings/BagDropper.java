package com.eddapps.banditkings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

public class BagDropper {

	Array<Bag> mBags;
	private float mElapsedTime;
	
	public BagDropper(){
		mBags = new Array<Bag>();
		mElapsedTime = 0.0f;
	}

	public void update(){
		mElapsedTime += Gdx.graphics.getDeltaTime();
		if(mElapsedTime > 2.0f){
			mElapsedTime = 0.0f;
			mBags.add(new Bag());
		}
		
		for(int i = 0; i < mBags.size; i++){
			mBags.get(i).update();
		}
	}
	
	public void draw(SpriteBatch spriteBatch){
		for(int i = 0; i < mBags.size; i++){
			mBags.get(i).draw(spriteBatch);
		}
	}
	
	
	
	private class Bag extends Sprite{
	
		public Bag(){
			super(new Texture(Gdx.files.internal("bag.png")));
			setPosition(MathUtils.random(200, 600), 400.0f);
			setSize(getWidth() * 0.3f, getHeight() * 0.3f);
		}
		
		public void update(){
			if(getY() <= 0)
				setY(0);
			else
				translateY(-60.0f * Gdx.graphics.getDeltaTime());
		}
		
	}
	
}
