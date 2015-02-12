package com.eddapps.banditkings;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.eddapps.banditkings.Castle.CastlePosition;

public class BanditKingsGame extends ApplicationAdapter {
	
	ShapeRenderer mShapeRenderer;
	SpriteBatch mSpriteBatch;
	
	Castle mCastleLeft;
	Castle mCastleRight;
	BluePlayer mBluePlayer;
	
	OrthographicCamera mCamera;
	
	@Override
	public void create () {
		mShapeRenderer = new ShapeRenderer();
		mSpriteBatch = new SpriteBatch();
		mCamera = new OrthographicCamera();
		mCamera.setToOrtho(false, 800, 480);

		mBluePlayer = new BluePlayer();
		mCastleLeft = new Castle("Castle Blue.png", 0.5f, CastlePosition.LEFT);
		mCastleRight = new Castle("Castle Red.png", 0.5f, CastlePosition.RIGHT);
		
	}

	@Override
	public void render () {
		mCamera.update();
		mBluePlayer.update();
				
		if(mCastleLeft.overlaps(mBluePlayer.getRectangle())){
			mBluePlayer.setPosition(mCastleLeft.getX() + mCastleLeft.getWidth(), mBluePlayer.getY());
		}
		if(mCastleRight.overlaps(mBluePlayer.getRectangle())){
			mBluePlayer.setPosition(mCastleRight.getX() - mBluePlayer.getWidth(), mBluePlayer.getY());
		}
		
		Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
	    mSpriteBatch.setProjectionMatrix(mCamera.combined);
	    mSpriteBatch.begin();
	    
		mCastleLeft.draw(mSpriteBatch);
		mCastleRight.draw(mSpriteBatch);
		mBluePlayer.draw(mSpriteBatch);
		
        mSpriteBatch.end();
        
        mShapeRenderer.setProjectionMatrix(mCamera.combined);
        mShapeRenderer.begin(ShapeType.Line);
        
        mCastleLeft.debugDraw(mShapeRenderer);
        mCastleRight.debugDraw(mShapeRenderer);
        
        mShapeRenderer.end();
		
	}
}

