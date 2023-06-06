package com.neojavadev.ashaelor.tools;

import com.badlogic.gdx.physics.box2d.*;

import static com.neojavadev.ashaelor.tools.Constants.PPM;

public class BodyHelperService {

    public static Body createBody(float x, float y, float width, float height, boolean isStatic, World world) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = isStatic ? BodyDef.BodyType.StaticBody : BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x / PPM, y / PPM);
        bodyDef.fixedRotation = true;
        Body body = world.createBody(bodyDef);

        PolygonShape polygonShape = new PolygonShape();
        polygonShape.setAsBox(width / 2 / PPM, height / 2 / PPM);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = polygonShape;
        body.createFixture(fixtureDef);
        polygonShape.dispose();
        return body;
    }
}
