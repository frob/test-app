package com.example.app;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * @author Frank Anderson
 *
 */
public class Rectangle {
  private FloatBuffer vertexBuffer;	// buffer holding the vertices
  private float[] vertices;

  public Rectangle(float width, float height) {
    this.vertices = new float[12];
    this.vertices[0] = -1 * (width/2);   // Bottom Left
    this.vertices[1] = -1 * (height/2);
    this.vertices[2] = 0.0f;
    this.vertices[3] = -1 * (width/2);   // Top Left
    this.vertices[4] = height/2;
    this.vertices[5] = 0.0f;
    this.vertices[6] = width/2;   // Bottom right
    this.vertices[7] = -1 * (height/2);
    this.vertices[8] = 0.0f;
    this.vertices[9] = width/2;   // Top right
    this.vertices[10] = height/2;
    this.vertices[11] = 0.0f;

    // a float has 4 bytes so we allocate for each coordinate 4 bytes
    ByteBuffer vertexByteBuffer = ByteBuffer.allocateDirect(vertices.length * 4);
    vertexByteBuffer.order(ByteOrder.nativeOrder());

    // allocates the memory from the byte buffer
    vertexBuffer = vertexByteBuffer.asFloatBuffer();

    // fill the vertexBuffer with the vertices
    vertexBuffer.put(vertices);

    // set the cursor position to the beginning of the buffer
    vertexBuffer.position(0);

  }


  /** The draw method for the triangle with the GL context */
  public void draw(GL10 gl) {

    gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
    // set the colour for the background
//		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);

    // to show the color (paint the screen) we need to clear the color buffer
//		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

    // set the colour for the triangle
    gl.glColor4f(1.0f, 1.0f, 1.0f, 0.5f);

    // Point to our vertex buffer
    gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);

    // Draw the vertices as triangle strip
    gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, vertices.length / 3);

    //Disable the client state before leaving
    gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
  }
}
