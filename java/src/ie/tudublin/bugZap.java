package ie.tudublin;

import processing.core.PApplet;

public class bugZap extends PApplet
{
    float playerX, playerY, playerWidth;
    float x1, y1, x2, y2;
	float x1dir, x2dir, y1dir, y2dir;
	float score = 0;

    int maxW = 500, maxH = 500;

    float bugX, bugY, bugWidth = 30, playerSpeed = 4, halfbugWidth = bugWidth/ 2;

    void resetBug(){
        bugX = random(bugWidth/2 ,width - (bugWidth/ 2) );
        bugY = 50;
    }

    void reset() {
		resetBug();
		playerX = width / 2;
		playerY = height - 50;
	}

	public void settings()
	{
		size(maxW, maxH);
	}

	public void setup() {
		colorMode(HSB);
		background(0);

        playerX = 250;
        playerY = 470;
        playerWidth = 30;

		x1 = random(0, width);
		x2 = random(0, width);
		y1 = random(0, height);
		y2 = random(0, height);

		float range = 5;

		x1dir = random(-range, range);
		x2dir = random(-range, range);
		y1dir = random(-range, range);
		y2dir = random(-range, range);

		smooth();
		
	}


    void drawPlayer(float x , float y, float w)
    {
    
        circle(x,y, w);
    }

    void drawBug(float x, float y, float w)
    {

    }
    public void keyPressed()
    {
        if (( keyCode ==  LEFT ) && (playerX > 0))
        {
        
            playerX -= playerSpeed;

        }
        
        if( keyCode == RIGHT && (playerX  < maxW))
        {
            playerY += playerSpeed;

        }

        if (keyCode == ' '){
            float halfw = bugWidth/2;
            if (playerX > bugX - halfw && playerX < bugX + halfw)
            {
                line(playerX, playerY, playerX, bugY );
                score++;
                resetBug();

            }
        }
    }

    public void moveBug() {
        bugY++;
        bugX += random(-20,20);
    }

	
	public void draw()
	{	
        background(0);
        strokeWeight(2);
		drawPlayer(this.playerX, this.playerY, this.playerWidth);
        drawBug(bugX, bugY, bugWidth);

        if( frameCount % 20 == 0){

        }

	}


}
