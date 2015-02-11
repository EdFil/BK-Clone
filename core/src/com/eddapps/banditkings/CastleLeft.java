package com.eddapps.banditkings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class CastleLeft extends Sprite {
	
	public CastleLeft(){
		super(new Texture(Gdx.files.internal("Castle Blue.png")));
		setPosition(0.0f, 0.0f);
	}
	
	public void debugDraw(ShapeRenderer shapeRenderer){
		System.out.println(getOriginX() + " " + getOriginY());
		shapeRenderer.setColor(Color.BLUE);
		shapeRenderer.rect(getX(), getY(), getWidth(), getHeight());
	}
	
}

