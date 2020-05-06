package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.ScreenController;
import ru.geekbrains.base.BaseScreen;
import ru.geekbrains.math.Rect;
import ru.geekbrains.sprite.Background;
import ru.geekbrains.sprite.PauseButton;
import ru.geekbrains.sprite.Player;

public class GameScreen extends BaseScreen {

    private Texture bg;
    private Texture buttonPause;
    private Texture playerTexture;
    private Background background;
    private Player player;
    private PauseButton pauseButton;


    public GameScreen(ScreenController controller) {
        super(controller);
        bg = new Texture("textures/backgroundGame.jpg");
        playerTexture = new Texture("textures/playerSpaceship.png");
        buttonPause = new Texture("textures/buttonPause.png");
        background = new Background(bg);
        player = new Player(playerTexture);
        pauseButton = new PauseButton(buttonPause);
    }

    @Override
    public void show() {
        super.show();
        player.setDestination(player.pos);
    }

    @Override
    public void resize(Rect worldBounds) {
        background.resize(worldBounds);
        player.resize(worldBounds);
        pauseButton.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        background.draw(batch);
        player.draw(batch);
        pauseButton.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        buttonPause.dispose();
        playerTexture.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        if (pauseButton.isMe(touch)) {
            pauseButton.touchDown(touch, pointer, button);
        } else {
            player.setDestination(touch);
        }
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        if (pauseButton.isMe(touch)) {
            controller.setMenuScreen();
        }
        pauseButton.setScale(1f);
        return false;
    }

    @Override
    public boolean touchDragged(Vector2 touch, int pointer) {
        return false;
    }
}
