package com.example.app;

import android.opengl.GLES20;

/**
 * Created by Frank on 3/30/14.
 */
public class Gl20Renderer extends GlRenderer {
  @Override
  public void onCreate(int width, int height, boolean contextLost) {
    GLES20.glClearColor(0f, 0f, 0f, 1f);
  }

  @Override
  public void onDrawFrame(boolean firstDraw) {
    GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BITS);
  }
}
