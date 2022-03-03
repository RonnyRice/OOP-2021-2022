package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;
import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet
{
    Minim minim;
    AudioPlayer ap; //get playet 
    AudioInput ai; // get input
    AudioBuffer ab; // get buffer

    float y;
    float smoothedY;
    float lerpedA = 0;
    int mode;
    
  

    public void setup()
    {
        minim =  new Minim(this);
        ai = minim.getLineIn(Minim.MONO, width, 44100, 16 ); 
        /* whe you want to monitor the active input of the computer.
        the sammple buffer is the size of the screen,
        sample rate is 44100 and 
        audio bit depth is 16 
        
        */
        ab = ai.mix; // audio buffer
        colorMode(HSB);

        y = height/2;
        smoothedY = y;
    }

    public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		println(mode);
	}

    public void settings()
    {
        size(1024, 1000, P3D);
        //fullScreen(P3D, SPAN);
    }

   

    public void draw()
    {
        //background(0);
        float halfH = height / 2;
        float average = 0;
        float sum = 0;
        for(int i = 0; i < ab.size(); i++)
        {
            //float c = map(ab.get(i), -1, 1, 0, 255);
            float c = map(i, 0 , ab.size(), 0, 255);
            stroke(c,255,255);
           // line(i, halfH, i, halfH + ab.get(i) * halfH);
             /* reading values from buffer and multiplying it by height.
             the default value will the buffer would be -1 to 1
            */

            sum += abs(ab.get(i));
        }

        smoothedAmplitude = lerp(smoothedAmplitude, average, 0.1f);
        
        float cx = width / 2;
        float cy = height / 2;

        switch (mode) {
			case 0:
                background(0);
                for(int i = 0 ; i < ab.size() ; i ++)
                {
                    //float c = map(ab.get(i), -1, 1, 0, 255);
                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    float f = lerpedBuffer[i] * halfH * 4.0f;
                    line(i, halfH + f, i, halfH - f);                    
                }
                break;
        case 1:
            background(0);
            for(int i = 0 ; i < ab.size() ; i ++)
            {
                //float c = map(ab.get(i), -1, 1, 0, 255);
                float c = map(i, 0, ab.size(), 0, 255);
                stroke(c, 255, 255);
                float f = lerpedBuffer[i] * halfH * 4.0f;
                line(i, halfH + f, halfH - f, i);                    
            }
            break;
        case 2:
            {
                    float c = map(smoothedAmplitude, 0, 0.5f, 0, 255);
                    background(0, 0, 0, 10);
                    stroke(c, 255, 255);	
                    float radius = map(smoothedAmplitude, 0, 0.1f, 50, 300);		
                    int points = (int)map(mouseX, 0, 255, 3, 10);
                    int sides = points * 2;
                    float px = cx;
                    float py = cy - radius; 
                    for(int i = 0 ; i <= sides ; i ++)
                    {
                        float r = (i % 2 == 0) ? radius : radius / 2; 
                        // float r = radius;
                        float theta = map(i, 0, sides, 0, TWO_PI);
                        float x = cx + sin(theta) * r;
                        float y = cy - cos(theta) * r;
                        
                        //circle(x, y, 20);
                        line(px, py, x, y);
                        px = x;
                        py = y;
                    }
            }
        case 3:
            background(0);
            strokeWeight(2);
            noFill();
            float r = map(smoothedAmplitude, 0, 0.5f, 100, 2000);
            float c = map(smoothedAmplitude, 0, 0.5f, 0, 255);
            stroke(c, 255, 255);
            circle(cx, cy, r);
        case 4:
            background(0);
            
        }
        


        
        // Other examples we made in the class
        /*
        stroke(255);
        fill(100,255,255);
        lerpedA = lerp(lerpedA, average, 0.1f);
        circle(width / 2 ,halfH, average * 100);


        circle(100, y, 50);
        y = random(-10, 10); 
        smoothedY = lerp(smoothedY, y, 0.1f);
        circle(100, smoothedY, 50);
        */
    }
    
}
