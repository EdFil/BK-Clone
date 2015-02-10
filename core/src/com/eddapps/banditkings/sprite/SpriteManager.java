package com.eddapps.banditkings.sprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.utils.Array;

public class SpriteManager {

	private SpriteBatch mSpriteBatch;
	private Array<GameEntity> mSprites;
	
	public SpriteManager(){
		mSpriteBatch = new SpriteBatch();
		mSprites = new Array<GameEntity>();
	}
	
	public void addSprite(GameEntity sprite){
		mSprites.add(sprite);
	}
	
	public void removeEntity(GameEntity sprite){
		mSprites.removeValue(sprite, false);
	}
	
	public void draw(){
		mSpriteBatch.begin();
		for(GameEntity sprite : mSprites)
			sprite.draw(mSpriteBatch);
		mSpriteBatch.end();
	}
	
	public void update(){
		for(GameEntity sprite : mSprites)
			sprite.update();
		//MoveToAction
	}
	
}
