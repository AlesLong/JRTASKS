package com.javarush.games.racer;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.*;

public class RacerGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;

    public void initialize() {
        showGrid(false);
        setScreenSize(WIDTH,HEIGHT);
    }


}
