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
	BagDropper mBagDropper;
	
	OrthographicCamera mCamera;
	
	@Override
	public void create () {
		mShapeRenderer = new ShapeRenderer();
		mSpriteBatch = new SpriteBatch();
		mCamera = new OrthographicCamera();
		mCamera.setToOrtho(false, 800, 480);

		mBagDropper = new BagDropper();
		mBluePlayer = new BluePlayer();
		mCastleLeft = new Castle("Castle Blue.png", 0.5f, CastlePosition.LEFT);
		mCastleRight = new Castle("Castle Red.png", 0.5f, CastlePosition.RIGHT);
		
	}

	@Override
	public void render () {
		mCamera.update();
		mBluePlayer.update();
		mBagDropper.update();
				
		if(mCastleLeft.getBoundingRectangle().overlaps(mBluePlayer.getBoundingRectangle())){
			mBluePlayer.setPosition(mCastleLeft.getX() + mCastleLeft.getWidth(), mBluePlayer.getY());
			if(mBluePlayer.isHoldingBag()){
				mCastleLeft.score++;
				mBluePlayer.deleteBag();
			}
		}
		if(mCastleRight.getBoundingRectangle().overlaps(mBluePlayer.getBoundingRectangle())){
			mBluePlayer.setPosition(mCastleRight.getX() - mBluePlayer.getWidth(), mBluePlayer.getY());
		}
		
		if(!mBluePlayer.isHoldingBag()){
			Bag bag = mBagDropper.getOverlappingBag(mBluePlayer);
			if(bag != null){
				mBluePlayer.setBag(bag);
				bag.mBluePlayer = mBluePlayer;
			}
		}
			
		Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
	    mSpriteBatch.setProjectionMatrix(mCamera.combined);
	    mSpriteBatch.begin();
	    
		mCastleLeft.draw(mSpriteBatch);
		mCastleRight.draw(mSpriteBatch);
		mBluePlayer.draw(mSpriteBatch);
		mBagDropper.draw(mSpriteBatch);
		
        mSpriteBatch.end();
        
        mShapeRenderer.setProjectionMatrix(mCamera.combined);
        mShapeRenderer.begin(ShapeType.Line);
        
        mCastleLeft.debugDraw(mShapeRenderer);
        mCastleRight.debugDraw(mShapeRenderer);
        mBluePlayer.debugDraw(mShapeRenderer);
        
        mShapeRenderer.end();
		
	}
}

