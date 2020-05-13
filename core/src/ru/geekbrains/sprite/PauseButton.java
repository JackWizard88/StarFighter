package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import ru.geekbrains.ScreenController;
import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class PauseButton extends Sprite{

    private ScreenController controller;
    private boolean isActivated = false;

    public PauseButton(Texture texture, ScreenController controller) {
        super(new TextureRegion(texture));
        this.controller = controller;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(worldBounds.getHeight() * 0.1f);
        this.pos.set(worldBounds.getRight() - halfWidth, worldBounds.getTop() - halfHeight);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        if (isMe(touch)) {
            setScale(0.8f);
            isActivated = true;
        }
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        if (isActivated && isMe(touch)) {
            controller.setMenuScreen();
        }
        isActivated = false;
        setScale(1f);
        return false;
    }
}