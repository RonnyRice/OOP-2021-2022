package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet
{


	int mode = 0;
	int myScreenX = 500;
	int myScreenY = 500;

	public void settings()
	{
		size(myScreenX, myScreenY);
	}
	
	public void setup() {

		colorMode(HSB);
		background(0);
		
	}

	public void keyPressed()
	{
		if (key >= '0' && key <='9')
		{
			mode = key - '0';
		}
		println(mode);
	}

	public void mode0( int thisScreenX, int thisScreenY)
	{

		int tenth = thisScreenX/10;
		int myColor = 0;

		for( int counter = 0; counter < thisScreenX; counter += tenth )
		{
			myColor += 15;
			fill(myColor, 360, 360);
			noStroke();
			rect(counter, 0, tenth, thisScreenY);
			
		}

	}

	public void mode1(int thisScreenX, int thisScreenY)
	{
		int tenth = thisScreenX/10;
		int myColor = 0;

		for( int counter = 0; counter < thisScreenX; counter += tenth )
		{
			myColor += 15;
			fill(myColor, 360, 360);
			noStroke();
			rect(counter, counter, tenth, tenth);

		}

	}
	public void mode2( int thisScreenX, int thisScreenY)
	{
		int tenth = thisScreenX/10;
		int myColor = 0;
		
		
		for( int counter = 0; counter < thisScreenX; counter += tenth )
		{
			myColor += 15;
			fill(myColor, 360, 360);
			noStroke();
			rect(counter, counter, tenth, tenth);

			fill(myColor, 360, 360);
			rect(counter, thisScreenY - (counter + tenth), tenth, tenth);

		}
		
		
			rect(0, thisScreenY - 50, tenth, tenth);
		


	}
	public void mode3( int thisScreenX, int thisScreenY)
	{
		float tenth = thisScreenX/10;
		float myMidpoint = thisScreenX/2;
		
		int myColor = 0;


		for( int counter = 0; counter < thisScreenX; counter += tenth )
		{
		
			myColor += 15;
			fill(myColor, 360, 360);
			noStroke();
			ellipse(myMidpoint, myMidpoint, (thisScreenX - counter), (thisScreenY - counter));

			
		}
		

	}

	public void mode4( int thisScreenX, int thisScreenY)
	{
		float tenth = thisScreenX/10;
		int myColor = 0;

		for( int counterI = 0; counterI < thisScreenX; counterI += tenth )
		{
			for( int counterJ = 0; counterJ < thisScreenX; counterJ += tenth )
			{
		
			myColor += 1;
			fill(myColor, 360, 360);
			noStroke();
			ellipse(counterI + 25, counterJ + 25, tenth, tenth);

			}
		}

	}

	public void mode5(int thisScreenX, int thisScreenY)
	{
		float eleventh = (thisScreenX-50) /11 ;
		int index = -5;
		
		for( float counter = 0; counter < eleventh * 11 ;counter += eleventh )
		{
			
		
		
			stroke(60);
			line(50, 50 + counter, thisScreenX - 50, 50 + counter);
			textAlign(RIGHT);
			text(index, 25, 50 + counter);
			stroke(60);
			line(50 + counter, 50, 50 + counter , thisScreenY - 50);
			textAlign(BOTTOM);
			text(index, 50 + counter, 25);
			index++;

		
		}
	}
	public void mode6(int thisScreenX, int thisScreenY)
	{
		
		int mySquare = thisScreenX/20;
		int myX = 0;
		int myY = 0;
		int counter = 0;


		for( int counterI = 0; counterI < 20; counterI++ )
		{

			for( int counterJ = 0; counterJ < 20; counterJ++)
		{
			myX = mySquare * counterI;
			myY = mySquare * counterJ;

			if ( (counter) % 2 == 0 )
			{
				
				fill(150, 360, 360);
			}

			else
			{
				fill(180, 360, 360);
			}
			
			rect(myX, myY, mySquare, mySquare);

			counter++;
			
		}
		counter++;

		}

	}
	public void mode7(int thisScreenX, int thisScreenY)
	{
		float myMidpoint = thisScreenX/2;
		float lineCount = 5;
		float myAngle = 360/ lineCount;
		float myAngleRadians= (myAngle * 3.14f)/180;
		
		
		for( float counter = 0; counter < lineCount; counter++)
		{

			stroke(60);
			line(myMidpoint, myMidpoint,  myMidpoint + (cos( myAngleRadians * counter) * 50), myMidpoint +  (sin( myAngleRadians * counter) * 50));
			
		}

		
		
		
	}
	public void mode8(int thisScreenY, int thisScreenX)
	{
		int tenth = thisScreenX/10;

		for( int counterI = 0; counterI < 20; counterI++ )
		{

			for( int counterJ = 0; counterJ < 20; counterJ++)
		{
			int myX = tenth * counterI;
			int myY = tenth * counterJ;

			if ( (myX + myY) % 2 == 0 )
			{
				
				fill(60, 360, 360);
			}

			else
			{
				fill(90, 360, 360);
			}

			
			rect(myX, myY, tenth, tenth);
			
		}

		}

	}
	public void mode9()
	{

	}

	
	public void draw()
	{
		
		switch(mode)	
		{
			case 0:

				//mode0( myScreenX, myScreenY);
				break;
			case 1:

				mode1(myScreenX, myScreenY);
				break;

			case 2:

				mode2(myScreenX, myScreenY);
				break;
			case 3:
				mode3(myScreenX, myScreenY);
				break;

			case 4:
				mode4(myScreenX,myScreenY);
				break;
			case 5:
				mode5(myScreenX, myScreenY);
				break;

			case 6:
				mode6(myScreenX, myScreenY);
				break;
			case 7:
				mode7(myScreenX, myScreenY);
				break;

			case 8:

				mode8(myScreenY, myScreenX);
				break;
			case 9:
				break;

			


		}
	}
}
