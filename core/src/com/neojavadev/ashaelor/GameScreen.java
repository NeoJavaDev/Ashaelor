package com.neojavadev.ashaelor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.ScreenUtils;
import com.neojavadev.ashaelor.tools.TileMapHelper;

import static com.neojavadev.ashaelor.tools.Constants.PPM;

public class GameScreen extends ScreenAdapter {

    private OrthographicCamera orthographicCamera;
    private SpriteBatch spriteBatch;
    private Box2DDebugRenderer box2DDebugRenderer;
    private World world;

    private boolean drawGrid = true;

    private OrthogonalTiledMapRenderer orthogonalTiledMapRenderer;
    private TileMapHelper tileMapHelper;



    public GameScreen(OrthographicCamera orthographicCamera) {
        this.orthographicCamera = orthographicCamera;
        this.orthographicCamera.position.set(new Vector3(0,0,0));
        this.spriteBatch = new SpriteBatch();
        this.world = new World(new Vector2(0,0),false);
        this.box2DDebugRenderer = new Box2DDebugRenderer();

        this.tileMapHelper = new TileMapHelper();
        this.orthogonalTiledMapRenderer = tileMapHelper.setupMap();
    }

    @Override
    public void render(float delta) {
        Boot.shapeRenderer.setProjectionMatrix(orthographicCamera.combined);
        this.update();

        ScreenUtils.clear(0, 0, 0, 1);

        drawGrid();

        // render the map
        orthogonalTiledMapRenderer.render();

        spriteBatch.begin();

        // render all the object

        spriteBatch.end();
        box2DDebugRenderer.render(world,orthographicCamera.combined.scl(PPM));
    }

    private void update() {
        world.step(1/60f,6,2); // UPDATE MOVEMENT
        cameraUpdate();
        spriteBatch.setProjectionMatrix(orthographicCamera.combined);
        orthogonalTiledMapRenderer.setView(orthographicCamera);
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    private void cameraUpdate() {
        Vector3 position = orthographicCamera.position;
        orthographicCamera.position.set(position);
        orthographicCamera.update();
    }

    private void drawGrid() {
        Boot.shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        Boot.shapeRenderer.setColor(10.0f,10.0f,10.0f,0f);
        int worldWidth = Boot.INSTANCE.getScreenWidth();
        int worldHeight = Boot.INSTANCE.getScreenHeight();
        for(int i = -worldWidth; i < worldHeight; i += 2) {
            Boot.shapeRenderer.line(i, -worldWidth,i, worldHeight);
        }
        for(int y = -worldHeight; y < worldHeight; y += 2) {
            Boot.shapeRenderer.line(-worldHeight, y, worldHeight, y);
        }
        Boot.shapeRenderer.end();
    }

}
