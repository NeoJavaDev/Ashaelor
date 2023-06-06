package com.neojavadev.ashaelor.entities.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.neojavadev.ashaelor.entities.GameEntity;

import static com.neojavadev.ashaelor.tools.Constants.PPM;

public class Player extends GameEntity {


    public Player(float width, float height, String name, int level, Body body) {
        super(width, height, name, level, body);
        this.speed = 4f;
        this.name = "Saya";
        this.level = 20;
    }

    @Override
    public void update() {
        x = body.getPosition().x * PPM;
        y = body.getPosition().y * PPM;

    }

    @Override
    public void render(SpriteBatch spriteBatch) {

    }
}
