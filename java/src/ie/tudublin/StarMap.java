package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet {


    ArrayList<Star> stars = new ArrayList<Star>(); //<> pass a generic i.e. Star object

    public float border;

    void drawGrid()
    {

       stroke(255,0,255);
       textAlign(CENTER,CENTER);
       textSize(20);
        for(int i = -5; i <= 5; i ++)
        {
            float x = map(i, -5, 5, border, width - border); // the value of x from -5 to 5 
            stroke(0, 255, 0);
            line(x, border, x, height - border);
            line(border, x, width - border, x);
            fill(255);
            text(i, x, border * 0.5f); // place text halfway the border onthhe 
            text(i, border * 0.5f, x);
        }
    }

    void printStars()
    {
        for(Star s : stars){ // for each objets in the stars list arrays
            System.out.println(s); // print out the contents of array
        }
    }

    void loadStars()
    {
        Table table = loadTable("HabHYG15ly.csv", "header"); // load file as table object and read from headers
        for(TableRow r : table.rows()){ // for each element of the table rows 

            Star s = new Star(r);
            stars.add(s);
    
        }


    }

    public void settings() {
        size(800, 800);
    }

    Star first = null;
    Star second = null;



    public void mouseClicked()
    {
        for(Star s:stars)
        {
            float x = map(s.getxG(), -5, 5, border, width - border);
            float y = map(s.getyG(), -5, 5, border, height - border);

            if (dist(mouseX, mouseY, x, y) < 20)
            {
                if (first == null)
                {
                    first = s;
                    break;
                }
                else if (second == null)
                {
                    second = s;
                    break;
                } 
                else
                {
                    first = s;
                    second = null;
                    break;
                }
            }
        }
    }

    public void setup() {
        colorMode(RGB);
        loadStars();
        printStars();

        border = width * 0.1f;
    }

    public void drawStars()
    {

       
            for(Star s:stars)
            {
                s.render(this);
            }
        


    }

    public void draw() 
    {
        background(0);
        drawGrid();
        drawStars();

        if (first != null)
        {

            float x = map(first.getxG(), -5, 5, border, width - border);
            float y = map(first.getyG(), -5, 5, border, height - border);

            if (second != null)
            {
                float x2 = map(second.getxG(), -5, 5, border, width - border);
                float y2 = map(second.getyG(), -5, 5, border, height - border);

                stroke(255, 255, 0);
                line(x, y, x2, y2);

                float dist = dist(first.getxG(), first.getyG(), first.getzG(), second.getxG(), second.getyG(), second.getzG());

                fill(255);
                textAlign(CENTER, CENTER);
                text("Distance between: " + first.getDisplayName() + " and " + second.getDisplayName() + " is " + dist + " parsecs", width / 2, height - (border * 0.5f));
            }
            else
            {
                stroke(255, 255, 0);
                line(x, y, mouseX, mouseY);
            }
        }
    }
}