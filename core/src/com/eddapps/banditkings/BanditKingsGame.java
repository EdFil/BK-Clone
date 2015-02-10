package com.eddapps.banditkings;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class BanditKingsGame extends ApplicationAdapter {
	
	SpriteBatch mSpriteBatch;
	
	Texture mBackground;
	Texture mCastleLeft;
	TextureRegion mCastleRight;
	
	OrthographicCamera mCamera;
	
	@Override
	public void create () {
		mSpriteBatch = new SpriteBatch();
		mCamera = new OrthographicCamera();
		mCamera.setToOrtho(false, 800, 480);
		
		mBackground = new Texture(Gdx.files.internal("background.png"));
		mCastleLeft = new Texture(Gdx.files.internal("castle.png"));
		mCastleRight = new TextureRegion(mCastleLeft);
		mCastleRight.flip(true, false);
	}

	@Override
	public void render () {
		mCamera.update();
				
		Gdx.gl.glClearColor(0.0f, 0.0f, 0.5f, 1.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
	    mSpriteBatch.setProjectionMatrix(mCamera.combined);
	    mSpriteBatch.begin();
		mSpriteBatch.draw(mBackground, 0, 0);
		mSpriteBatch.draw(mCastleLeft, 0-mCastleLeft.getWidth()/2, 0);
		mSpriteBatch.draw(mCastleRight, Gdx.graphics.getWidth()-mCastleLeft.getWidth()/2, 0);
        mSpriteBatch.end();
		
	}
}

