package com.eddapps.banditkings.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class GameEntity extends Sprite {

	public GameEntity(Texture texture){
		super(texture);
	}
	
	public abstract void update();
	
}
