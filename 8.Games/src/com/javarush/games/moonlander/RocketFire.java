package com.javarush.games.moonlander;

import java.util.List;

public class RocketFire extends GameObject {
    private List<int[][]> frames;
    private int frameIndex;
    private boolean isVisible;

  //  public RocketFire(double x, double y, int[][] matrix, List<int[][]> frameList) {
//
  //      this.frames = frameList;
//
  //  }

    public RocketFire(List<int[][]> frameList) {
        super(0, 0, frameList.get(0));
        this.frames = frameList;
        frameIndex = 0;
        isVisible = false;
    }

    // public RocketFire(double x, double y, int[][] matrix, List<int[][]> frames) {
    //     super(x, y, matrix);
    //     this.frames = frames;
    // }
}
