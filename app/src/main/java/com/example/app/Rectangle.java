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

  public Rectangle(
      float p1a, float p1b, float p1c,   // Bottom Left
      float p2a, float p2b, float p2c,   // Top Left
      float p3a, float p3b, float p3c,   // Bottom right
      float p4a, float p4b, float p4c) { // Top right
    this.vertices = new float[12];
    this.vertices[0] = p1a;
    this.vertices[1] = p1b;
    this.vertices[2] = p1c;
    this.vertices[3] = p2a;
    this.vertices[4] = p2b;
    this.vertices[5] = p2c;
    this.vertices[6] = p3a;
    this.vertices[7] = p3b;
    this.vertices[8] = p3c;
    this.vertices[9] = p4a;
    this.vertices[10] = p4b;
    this.vertices[11] = p4c;

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
