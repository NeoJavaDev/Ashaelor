package com.neojavadev.ashaelor.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;

public abstract class GameEntity {

    protected float x, y, velX, velY, speed;
    protected float width, height;
    protected Body body;

    protected String name;
    protected int level;

    public GameEntity(float width, float height, String name, int level, Body body) {
        this.x = body.getPosition().x;
        this.y = body.getPosition().y;
        this.width = width;
        this.height = height;
        this.body = body;
        this.name = name;
        this.level = level;
        this.velX = 0;
        this.velY = 0;
        this.speed = 0;
    }

    public abstract void update();

    public abstract void render(SpriteBatch spriteBatch);

    public Body getBody() {
        return body;
    }
}
