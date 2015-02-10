package com.eddapps.banditkings;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.eddapps.banditkings.sprite.SpriteManager;

public class BanditKingsGame extends ApplicationAdapter {
	
	SpriteManager mManager;
	
	@Override
	public void create () {
		mManager = new SpriteManager();
		
		Sprite sprite1 = new Sprite(new Texture("badlogic.jpg"));
		Sprite sprite2 = new Sprite(new Texture("badlogic.jpg"));
		sprite2.setPosition(50,  50);
		
		mManager.addSprite(sprite1);
		mManager.addSprite(sprite2);
	}

	@Override
	public void render () {
		
		mManager.update();
		
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		mManager.draw();
		
	}
}
