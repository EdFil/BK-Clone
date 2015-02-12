package com.eddapps.banditkings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Castle extends Sprite {
	
	Rectangle mRectangle;
	
	public Castle(String texturePath, float scale, CastlePosition castlePosition){
		super(new Texture(Gdx.files.internal(texturePath)));
		mRectangle = new Rectangle();
		setSize(getWidth() * scale, getHeight() * scale);
		setPosition(castlePosition);
	}
	
	public void debugDraw(ShapeRenderer shapeRenderer){
		shapeRenderer.setColor(Color.BLUE);
		shapeRenderer.rect(mRectangle.x, mRectangle.y, mRectangle.width, mRectangle.height);
	}
	
	public boolean overlaps(Rectangle other){
		return mRectangle.overlaps(other);
	}
	
	private void setPosition(CastlePosition castlePosition) {
		if(castlePosition == CastlePosition.LEFT){
			setPosition(0.0f, 0.0f);
		}else if(castlePosition == CastlePosition.RIGHT){
			setPosition(Gdx.graphics.getWidth() - getWidth() * getScaleX(), 0.0f);
		}
		mRectangle.set(getX(), getY(), getWidth(), getHeight());
	}

	public Rectangle getRectangle(){ return mRectangle; }
	
	public enum CastlePosition{
		LEFT, RIGHT;
	};
	
}
