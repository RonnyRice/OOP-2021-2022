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
    
    public void settings()
    {
        size(1024, 500);
    }

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


    public void draw(){

        switch (mode) {

            case 1:
            {
                
            }
            case 2:
            {
                
            }
            case 3:
            {

            }                
                break;
        
            default:
                break;
        }

        background(0); // set backroun to 0
        stroke(255); // color of border to white.
        float halfH = height / 2; // set line to  half of height
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

        average = sum / (float) ab.size();

        stroke(255);
        fill(100,255,255);
        lerpedA = lerp(lerpedA, average, 0.1f);
        circle(width / 2 ,halfH, average * 100);


        circle(100, y, 50);
        y = random(-10, 10); 
        smoothedY = lerp(smoothedY, y, 0.1f);
        circle(100, smoothedY, 50);

    }
    
}
