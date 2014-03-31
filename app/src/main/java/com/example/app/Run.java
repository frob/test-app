package com.example.app;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Run extends Activity {

  /** The OpenGL view */
  private GLSurfaceView glSurfaceView;
  private GLSurfaceView casper;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    requestWindowFeature(Window.FEATURE_NO_TITLE);
    // making it full screen
    getWindow().setFlags(
        WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);

    if(hasGLES20()) {
      glSurfaceView = new GLSurfaceView(this);
      glSurfaceView.setEGLContextClientVersion(2);
      glSurfaceView.setPreserveEGLContextOnPause(true);
      glSurfaceView.setRenderer(new Gl20Renderer());
    }
    else {
      // Tell them to buy new phone. 2.3 is the IE of Android
    }
  }

  /**
   * Remember to resume the glSurface
   */
  @Override
  protected void onResume() {
    super.onResume();
    casper.onResume();
  }

  /**
   * Also pause the glSurface
   */
  @Override
  protected void onPause() {
    super.onPause();
    casper.onPause();
  }

  /**
   * Check for support for OpenGLES2.0
   * @return boolean
   */
  private boolean hasGLES20() {
    ActivityManager am = (ActivityManager)
        getSystemService(Context.ACTIVITY_SERVICE);
    ConfigurationInfo info = am.getDeviceConfigurationInfo();
    return info.reqGlEsVersion >= 0x20000;
  }

}