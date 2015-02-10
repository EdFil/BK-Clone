package com.eddapps.banditkings.sprite;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class SpriteManager {

	private SpriteBatch mSpriteBatch;
	private Array<Sprite> mSprites;
	
	public SpriteManager(){
		mSpriteBatch = new SpriteBatch();
		mSprites = new Array<Sprite>();
	}
	
	public void addSprite(Sprite sprite){
		mSprites.add(sprite);
	}
	
	public void removeEntity(Sprite sprite){
		mSprites.removeValue(sprite, false);
	}
	
	public void draw(){
		mSpriteBatch.begin();
		for(Sprite sprite : mSprites)
			sprite.draw(mSpriteBatch);
		mSpriteBatch.end();
	}
	
	public void update(){
//		for(Sprite sprite : mSprites)
//			sprite.
	}
	
}
