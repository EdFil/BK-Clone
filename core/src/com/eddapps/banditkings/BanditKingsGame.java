package com.eddapps.banditkings;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class BanditKingsGame extends ApplicationAdapter {
	
	ShapeRenderer mShapeRenderer;
	SpriteBatch mSpriteBatch;
	
	CastleLeft mCastleLeft;
	CastleRight mCastleRight;
	
	OrthographicCamera mCamera;
	
	@Override
	public void create () {
		mShapeRenderer = new ShapeRenderer();
		mSpriteBatch = new SpriteBatch();
		mCamera = new OrthographicCamera();
		mCamera.setToOrtho(false, 800, 480);

		mCastleLeft = new CastleLeft();
		mCastleRight = new CastleRight();
		
	}

	@Override
	public void render () {
		mCamera.update();
				
		Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
	    mSpriteBatch.setProjectionMatrix(mCamera.combined);
	    mSpriteBatch.begin();
	    
		mCastleLeft.draw(mSpriteBatch);
		mCastleRight.draw(mSpriteBatch);
		
        mSpriteBatch.end();
        
        mShapeRenderer.setProjectionMatrix(mCamera.combined);
        mShapeRenderer.begin(ShapeType.Line);
        
        mCastleLeft.debugDraw(mShapeRenderer);
        mCastleRight.debugDraw(mShapeRenderer);
        
        mShapeRenderer.end();
		
	}
}

