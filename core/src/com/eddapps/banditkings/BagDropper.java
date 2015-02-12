package com.eddapps.banditkings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class BagDropper {

	private Array<Bag> mBags;
	private float mElapsedTime;
	
	public BagDropper(){
		mBags = new Array<Bag>();
		mElapsedTime = 10.0f;
	}

	public Bag getOverlappingBag(Sprite sprite){
		for(int i = 0; i < mBags.size; i++){
			if(mBags.get(i).getBoundingRectangle().overlaps(sprite.getBoundingRectangle())){
				return mBags.get(i);
			}
		}
		return null;
	}
	
	public void update(){
		mElapsedTime += Gdx.graphics.getDeltaTime();
		if(mElapsedTime > 10.0f){
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
	
}
