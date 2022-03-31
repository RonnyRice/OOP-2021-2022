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


    public void mouseClicked()
    {
        
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
        
    
    }
}