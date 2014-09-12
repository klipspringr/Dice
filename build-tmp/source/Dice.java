import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {

int totalNumDice, amountOfDice, redColor, greenColor, blueColor;

public void setup()
{
	noLoop();
	size(1200, 900);
}
public void draw()
{
	background(100);
	for(int startY = 0; startY <= 900; startY +=10)
	{
		for(int startX = 0; startX <= 1000; startX +=10)
		{
		Die bob = new Die(startX, startY);
		bob.roll();
    	bob.show();

    	amountOfDice ++;    	
		}
	}
	textShow();
}


public void textShow()
{
	fill(200);
	textSize(15);
	textAlign(RIGHT);
	text("added total:"+totalNumDice, 1150, 500);
	text("amountOfDice: "+amountOfDice, 1164, 700);
}

public void mousePressed()
{
	totalNumDice = 0;
	amountOfDice = 0;
	redraw();
}

class Die //models one single dice cube
{
	int numOfDots;
	int myX;
	int myY;
	Die(int x, int y) //constructor
	{
		myX = x;
		myY = y;
	}
	public void roll()
	{
		numOfDots = (int) ((Math.random()*6) + 1);
		totalNumDice += numOfDots;
	}
	public void show()
	{
		// fill(255);
		rect(myX, myY, 10,10, 10);
		redColor = (int)(Math.random()*256);
		greenColor = (int)(Math.random()*256);
		blueColor = (int)(Math.random()*256);
		fill(redColor, greenColor, blueColor);
		if (numOfDots == 1 || numOfDots == 3 || numOfDots == 5)//center dot
		{
			ellipse(myX + 5, myY + 5, 1, 1);
		}
		if (numOfDots > 1 && numOfDots < 7) //diagonal, top right bottom left
		{
			ellipse(myX + 7.5f, myY + 2.5f, 1, 1);//top right
			ellipse(myX + 2.5f, myY + 7.5f, 1, 1);//bottom left
		}
		if (numOfDots > 3)//top left bottom right
		{
			ellipse(myX + 2.5f, myY + 2.5f, 1, 1);
			ellipse(myX + 7.5f, myY + 7.5f, 1, 1);
		}
		if (numOfDots == 6)
		{
			ellipse(myX + 2.5f, myY + 5.0f, 1, 1);
			ellipse(myX + 7.5f, myY + 5.0f, 1, 1);
		}
	}

}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
