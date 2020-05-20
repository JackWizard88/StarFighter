package ru.geekbrains.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.awt.DisplayMode;

import ru.geekbrains.StarFighter;
import ru.geekbrains.screen.GameScreen;
import ru.geekbrains.screen.MenuScreen;

public class ScreenController {

    private TextureAtlas atlas;
    private final StarFighter game;
    private final MenuScreen menuScreen;
    private static GameScreen gameScreen;

    private static ScreenController instance;

    private ScreenController(StarFighter starFighter) {
        Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
        this.atlas = new TextureAtlas("textures/atlas.atlas");
        this.menuScreen = new MenuScreen(atlas, this);
        this.game = starFighter;
        game.setScreen(menuScreen);
    }

    public static ScreenController getInstance(StarFighter starFighter) {
        if (instance == null) {
            instance = new ScreenController(starFighter);
        }
        return instance;
    }

    public static GameScreen getGameScreen() {
        return gameScreen;
    }

    public void setNewGameScreen() {
        gameScreen = GameScreen.getGameScreen(atlas, this);
        menuScreen.getMenuButtonController().setGameExists(true);
        setGameScreen();
    }

    public void setGameScreen() {
        game.setScreen(gameScreen);
    }

    public void setMenuScreen() {
        game.setScreen(menuScreen);
    }

}