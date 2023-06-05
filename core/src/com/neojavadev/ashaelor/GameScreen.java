package com.neojavadev.ashaelor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.ScreenUtils;

import static com.neojavadev.ashaelor.tools.Constants.PPM;

public class GameScreen extends ScreenAdapter {

    private OrthographicCamera orthographicCamera;
    private SpriteBatch spriteBatch;
    private Box2DDebugRenderer box2DDebugRenderer;
    private World world;



    public GameScreen(OrthographicCamera orthographicCamera) {
        this.orthographicCamera = orthographicCamera;
        this.world = new World(new Vector2(0,0),false);
        this.box2DDebugRenderer = new Box2DDebugRenderer();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        spriteBatch.begin();

        // render all the object


        spriteBatch.end();
        box2DDebugRenderer.render(world,orthographicCamera.combined.scl(PPM));
    }

    private void update() {
        world.step(1/60f,6,2); // UPDATE MOVEMENT

        spriteBatch.setProjectionMatrix(orthographicCamera.combined);

        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    private void cameraUpdate() {
        orthographicCamera.position.set(new Vector3(0,0,0));
        cameraUpdate();
    }

}
