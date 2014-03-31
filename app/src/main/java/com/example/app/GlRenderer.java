package com.example.app;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.nfc.Tag;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.opengl.GLSurfaceView.Renderer;
import android.util.Log;

/**
 * @author Frank Anderson
 *
 */
public abstract class GlRenderer implements Renderer {
  private boolean mFirstDraw;
  private boolean mSurfaceCreated;
  private int mWidth;
  private int mHeight;
  private long mLastTime;
  private int mFPS;
//  private Rectangle ball;
//  private Rectangle paddle1;
//  private Rectangle paddle2;

  /** Constructor to set the handed over context */
  public GlRenderer() {
    mFirstDraw = true;
    mSurfaceCreated = false;
    mWidth = -1;
    mHeight = -1;
    mLastTime = System.currentTimeMillis();
    mFPS = 0;
//    this.ball = new Rectangle(0.5f, 0.5f);
//    this.paddle1 = new Rectangle(1.25f, 0.25f);
//    this.paddle2 = new Rectangle(1.25f, 0.25f);
  }

  @Override
  public void onSurfaceCreated(GL10 ie, EGLConfig config) {
    Log.i("message", "Surface Created");
    mSurfaceCreated = true;
    mWidth = -1;
    mHeight = -1;
  }

  @Override
  public void onSurfaceChanged(GL10 ie, int width, int height) {
    if(!mSurfaceCreated && width == mWidth && height == mHeight) {
      Log.i("message", "Surface changed but already handled");
      return;
    }
    mWidth = width;
    mHeight = height;

    onCreate(mWidth, mHeight, mSurfaceCreated);
    mSurfaceCreated = false;
//    if(height == 0) { 						//Prevent A Divide By Zero By
//      height = 1; 						//Making Height Equal One
//    }
//
//    gl.glViewport(0, 0, width, height); 	//Reset The Current Viewport
//    gl.glMatrixMode(GL10.GL_PROJECTION); 	//Select The Projection Matrix
//    gl.glLoadIdentity(); 					//Reset The Projection Matrix
//
//    //Calculate The Aspect Ratio Of The Window
//    GLU.gluPerspective(gl, 45.0f, (float)width / (float)height, 0.1f, 100.0f);
//
//    gl.glMatrixMode(GL10.GL_MODELVIEW); 	//Select The Modelview Matrix
//    gl.glLoadIdentity(); 					//Reset The Modelview Matrix
  }
  @Override
  public void onDrawFrame(GL10 gl) {
    onDrawFrame(mFirstDraw);
    if(mFirstDraw) {
      mFirstDraw = false;
    }
//    // clear Screen and Depth Buffer
//    GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);
//
//    // Reset the Modelview Matrix
//    gl.glLoadIdentity();
//
//    // Drawing
//    gl.glTranslatef(0.0f, 0.0f, -5.0f);		// move 5 units INTO the screen
//    // is the same as moving the camera 5 units away
//		gl.glScalef(0.5f, 0.5f, 0.5f);			// scale the square to 50%
//    // otherwise it will be too large
//    ball.draw(gl);						// Draw the square
//    paddle1.draw(gl);						// Draw the square
//    paddle2.draw(gl);						// Draw the square
  }


  public abstract void onCreate(int width, int height, boolean contextLost);
  public abstract void onDrawFrame(boolean firstDraw);
}
