package ie.tudublin;

public class Cat extends Animal
{
    private int numLives; 

    public Cat(String name)
    {
        super(name);
        numLives = 9;
        
    }

    public void setNumLives(int numLives)
    {
        this.numLives = numLives;
    }

    public int getNumLives()
    {
        return this.numLives;
    }



    public int kill()
    {
        this.numLives-- ;

        if (this.numLives > 0 )
        {
            System.out.println("ouch");
            return this.numLives;
        
        }
        else
        {
            System.out.println("Dead");
            this.numLives = 0;
            return 0;

        }

    }
}