package com.eddapps.banditkings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class CastleRight extends Sprite {
	
	public CastleRight(){
		super(new Texture(Gdx.files.internal("Castle Red.png")));
		float mOriginX = Gdx.graphics.getWidth() - getWidth();
		float mOriginY = 0;
		setPosition(mOriginX, mOriginY);
	}
	
	public void debugDraw(ShapeRenderer shapeRenderer){
		shapeRenderer.setColor(Color.RED);
		shapeRenderer.rect(getOriginX(), getOriginY(), getWidth(), getHeight());
	}
	
}

