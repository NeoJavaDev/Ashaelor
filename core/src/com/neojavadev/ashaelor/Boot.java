package com.neojavadev.ashaelor;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class Boot extends Game {

	public static Boot INSTANCE;
	private OrthographicCamera orthographicCamera;
	private int screenWidth, screenHeight;
	protected static ShapeRenderer shapeRenderer;



	public Boot() {
		INSTANCE = this;
	}

	@Override
	public void create() {

		this.screenWidth = Gdx.graphics.getWidth();
		this.screenHeight = Gdx.graphics.getHeight();
		this.orthographicCamera = new OrthographicCamera();
		this.orthographicCamera.setToOrtho(false,screenWidth,screenHeight);
		this.shapeRenderer = new ShapeRenderer();
		setScreen(new GameScreen(orthographicCamera));

	}

	@Override
	public void dispose() {

	}

	public int getScreenWidth() {
		return screenWidth;
	}

	public void setScreenWidth(int screenWidth) {
		this.screenWidth = screenWidth;
	}

	public int getScreenHeight() {
		return screenHeight;
	}

	public void setScreenHeight(int screenHeight) {
		this.screenHeight = screenHeight;
	}
}
