package com.eddapps.banditkings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Castle extends Sprite {
	
	int score = 0;
	BitmapFont mScoreFont;
	
	public Castle(String texturePath, float scale, CastlePosition castlePosition){
		super(new Texture(Gdx.files.internal(texturePath)));
		mScoreFont = new BitmapFont(Gdx.files.internal("arial.fnt"));
		mScoreFont.setColor(Color.BLACK);
		mScoreFont.setScale(0.7f);
		setSize(getWidth() * scale, getHeight() * scale);
		setPosition(castlePosition);
	}
	
	public void draw(SpriteBatch spriteBatch){
		super.draw(spriteBatch);
		mScoreFont.draw(spriteBatch, String.valueOf(score), getX() + getWidth()/2, getY() + getHeight() + mScoreFont.getCapHeight());
	}
	
	public void debugDraw(ShapeRenderer shapeRenderer){
		shapeRenderer.setColor(Color.BLUE);
		shapeRenderer.rect(getBoundingRectangle().x, getBoundingRectangle().y, getBoundingRectangle().width, getBoundingRectangle().height);
	}
	
	private void setPosition(CastlePosition castlePosition) {
		if(castlePosition == CastlePosition.LEFT){
			setPosition(0.0f, 0.0f);
		}else if(castlePosition == CastlePosition.RIGHT){
			setPosition(Gdx.graphics.getWidth() - getWidth() * getScaleX(), 0.0f);
		}
		//getBoundingRectangle().set(getX(), getY(), getWidth(), getHeight());
	}

	public Rectangle getRectangle(){ return getBoundingRectangle(); }
	
	public enum CastlePosition{
		LEFT, RIGHT;
	};
	
}
