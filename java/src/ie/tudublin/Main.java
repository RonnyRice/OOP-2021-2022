package ie.tudublin;



public class Main
{
    public static void helloProcessing()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new HelloProcessing());
    }

    public static void bugZap()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new BugZap());
    }

    public static void loops()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Loops());
    }

    public static void arrays()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Arrays());
    }

<<<<<<< HEAD
=======

>>>>>>> ff7514b8f67f00bde7e93f06a65899fbfe0de1bc
    public static void audio1()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Audio1());
    }

<<<<<<< HEAD

=======
>>>>>>> ff7514b8f67f00bde7e93f06a65899fbfe0de1bc
    public void cat()
    {
        System.out.println("Hello world");

        Animal misty = new Animal("Misty");
        Animal lucy = new Animal("Lucy");

        lucy = misty;
        misty.setName("Tara");

        System.out.println(misty);
        System.out.println(lucy);

        Cat ginger = new Cat("Ginger");


    }
    public static void main(String[] args)
    {
        audio1();

        // Tara Misty
        // Tara Tara
        
    }
}