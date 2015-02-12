package com.eddapps.banditkings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;

public class Bag extends Sprite{
	
	BluePlayer mBluePlayer;
	
		
	public Bag(){
		super(new Texture(Gdx.files.internal("bag.png")));
		setPosition(MathUtils.random(200, 600), 400.0f);
		setSize(getWidth() * 0.3f, getHeight() * 0.3f);
	}
	
	public void update(){
		if(mBluePlayer == null){
			if(getY() <= 0)
				setY(0);
			else
				translateY(-60.0f * Gdx.graphics.getDeltaTime());
		}else{
			setPosition(mBluePlayer.getX() + mBluePlayer.getWidth()/2 - getWidth()/2, mBluePlayer.getY() + mBluePlayer.getHeight());
		}
	}
	
}
