package org.youorghere;


 
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
//import javax.media.opengl.GLCapabilities;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;


class ThirdGLEventListener implements GLEventListener {
/**
 * Interface to the GLU library.
 */
private GLU glu;

/**
 * Take care of initialization here.
 */
public void init(GLAutoDrawable gld) {
    GL gl = gld.getGL();
    glu = new GLU();

    gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    gl.glViewport(0,0,640,480);
    gl.glMatrixMode(GL.GL_PROJECTION);
    gl.glLoadIdentity();
    glu.gluOrtho2D(0,640,0,480);
}

/**
 * Take care of drawing here.
 */
public void display(GLAutoDrawable drawable) {
    GL gl = drawable.getGL();

    gl.glClear(GL.GL_COLOR_BUFFER_BIT);
    /*
     * put your code here
     */
    //drawLine(gl, 0, 0, 100, 100);
    gl.glColor3f(1.0f, 0.0f, 0.0f );
    
 dda(gl,200,200,250,250);
 dda(gl,250,250,320,250);
 dda(gl,320,250,370,200);
 dda(gl,370,200,320,150);
 dda(gl,320,150,250,150);
 dda(gl,250,150,200,200);

}

public void reshape(GLAutoDrawable drawable, int x, int y, int width,
        int height) {
}

public void displayChanged(GLAutoDrawable drawable,
        boolean modeChanged, boolean deviceChanged) {
}

private void dda(GL gl,int x1,int y1,int x2,int y2) {
   
   int length;
   if (Math.abs(x2-x1)>=Math.abs(y2-y1)){
    length=Math.abs(x2-x1);
}
   else{
       length=Math.abs(y2-y1);
           }
   double dx,dy;
   dx=(x2-x1)/length;
   dy=(y2-y1)/length;
   
   double x,y;
   x=x1;
   y=y1;
   
   for(int i=1;i<=length;i++){
       gl.glBegin(GL.GL_POINTS);
       gl.glColor3f(0.0f,1.0f,0.0f);
       if(i%2==0){
       gl.glVertex2d(x,y);
       }
       x=x+dx;
       y=y+dy;
      
   }
   gl.glEnd();
}
public void dispose(GLAutoDrawable arg0)
{
    
}
}
public class Prac_2a
{
public static void main(String args[])
{
    //getting the capabilities object of GL2 profile
    //final GLProfile profile=GLProfile.get(GLProfile.GL);
    GLCapabilities capabilities=new GLCapabilities();
    // The canvas
    final GLCanvas glcanvas=new GLCanvas(capabilities);
    ThirdGLEventListener b=new ThirdGLEventListener();
    glcanvas.addGLEventListener(b);
    glcanvas.setSize(400, 400);
    //creating frame
    final JFrame frame=new JFrame("Basic frame");
    //adding canvas to frame
    frame.add(glcanvas);
    frame.setSize(640,480);
    frame.setVisible(true);
}
}

