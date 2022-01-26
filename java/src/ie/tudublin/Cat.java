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

    public int kill()
    {
        
        this.setNumLives(this.numLives);

        if (this.numLives > 0 )
        {
            System.out.println("ouch");
            return this.numLives = this.numLives - 1;
        
        }

        else
        {
            System.out.println("Dead");
            return 0;

        }

    }
}