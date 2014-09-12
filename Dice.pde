int totalNumDice, amountOfDice;

void setup()
{
	noLoop();
	size(1200, 900);
}
void draw()
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


void textShow()
{
	fill(200);
	textSize(15);
	textAlign(RIGHT);
	text("added total:"+totalNumDice, 1150, 500);
	text("amountOfDice: "+amountOfDice, 1164, 700);
}

void mousePressed()
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
	void roll()
	{
		numOfDots = (int) ((Math.random()*6) + 1);
		totalNumDice += numOfDots;
	}
	void show()
	{
		fill(255);
		rect(myX, myY, 10,10, 10);
		fill(150);
		if (numOfDots == 1 || numOfDots == 3 || numOfDots == 5)//center dot
		{
			ellipse(myX + 5, myY + 5, 1, 1);
		}
		if (numOfDots > 1 && numOfDots < 7) //diagonal, top right bottom left
		{
			ellipse(myX + 7.5, myY + 2.5, 1, 1);//top right
			ellipse(myX + 2.5, myY + 7.5, 1, 1);//bottom left
		}
		if (numOfDots > 3)//top left bottom right
		{
			ellipse(myX + 2.5, myY + 2.5, 1, 1);
			ellipse(myX + 7.5, myY + 7.5, 1, 1);
		}
		if (numOfDots == 6)
		{
			ellipse(myX + 2.5, myY + 5.0, 1, 1);
			ellipse(myX + 7.5, myY + 5.0, 1, 1);
		}
	}

}
