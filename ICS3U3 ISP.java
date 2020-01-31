/*
Ronald You
Ms Krasteva
January 10th, 2020
The program will allow you to book a theatre seat for a specific theater, movie and date. The program will present three different types of seat, regular, wheelchair, and deluxe which
the user may choose from. In total there are 600 seats, 20 rows and 30 seats per row. Once the user has used the 'w','a','s','d' keys to select their seat, the user will be asked for 
their name and credit card information which are will be saved in a text file.
Seating prices are determined by location and the luxuriousness of the seat. Regular seats closest to the stage are more expensive than regular seats farther from the stage. In addition
deluxe seats are the most expensive due to their luxuriousness. 
Further instructions are available in the menu to help navigate.
*/
import java.awt.*;
import hsa.*;
import javax.swing.JOptionPane;
import java.io.*;


public class Theatre{


    /*
	Name                       Type         Description
	-------------------------|---------- |----------------------------------- 
	c                        |  Console  |  used to create console objects
	menuDecision             |  char     |  stores the decision the user inputs to maneuver screen from the method mainMenu
	seatTypeDecision         |  char     |  stores the decision the user inputs to maneuver screen from the method seatTypeSelection
	back                     |  char     |  stores the decision the user inputs to move back a screen from the methods regularSeatSelection, wheelchairSeatSelection, deluxeSeatSelection
	thankDecision            |  char     |  stores the decision the user inputs to either exit the program or go back to main menu from the method thankYou
	seatChoice               |  String   |  stores the seat the user chooses
	dateChoice               |  String   |  stores the date the user chooses
	movieChoice              |  String   |  stores the movie the user wants to watch
	theatreChoice            |  String   |  stores the theatre the user wants to watch the movie at
	numberofSeatsPurchased   |  int      |  stores the number of seats that have been purchased intotal
	background               |  Color    |  stores rgb of the background colour  
	lightGrey                |  Color    |  stores rgb of colour used in the method splashScreen
	lineGrey                 |  Color    |  stores rgb of colour used in the method splashScreen
	darkGrey                 |  Color    |  stores rgb of colour used in the method splashScreen
	yellowRings              |  Color    |  stores rgb of colour used to create the iconic cineplex logo
	outlineBlue              |  Color    |  stores rgb of colour used to highlight the current selected seat
	wheelBlue                |  Color    |  stores rgb of colour used to show wheelchair seats
    */
    
    
    Console c = new Console(33,112,"Seat Booking");
    char menuDecision;
    char seatTypeDecision;
    char back;
    char thankDecision;
    String seatChoice;
    String dateChoice;
    String movieChoice;
    String theatreChoice;
    int numberOfSeatsPurchased = 0;
    
    //colours
    Color background = new Color(8,76,139);
    Color lightGrey = new Color(197, 194, 189);
    Color lineGrey = new Color(76,73,66);
    Color darkGrey = new Color(121,119,111);
    Color yellowRings = new Color(225,150,23);
    Color outlineBlue = new Color(0,191,255);
    Color wheelBlue = new Color(0,191,255);
    
    
    
    /*
    
    title()
    
    Variables Used:
	 - background --> used to set colour of the background whenever title() is called
    
    Actions:
	 - method clears the previous screen when called and outputs a standard background and title
	 
    Returns:
	 - N/A
    
    Local Variable List
	 - N/A
    */
    public void title(){
	c.clear();//clears previous screen
	c.setColor(background);//colour
	c.fillRect(0,0,900,660);//rectangle to cover background
	c.setFont(new Font("Sans Serif",Font.BOLD,75));//setting font
	c.setColor(Color.WHITE);
	c.drawString("Cineplexe", 262,80);
    }
    

    
    /*
    
    splashScreen()
    
    Variables Used:
	 - lightGrey --> used to set colour of the background
	 - darkGrey --> used to fill arc which rotates clockwise 
	 - lineGrey --> used to draw lines to split splashscreen into 4 quadrants
    
    Actions:
	 - method runs a short animation which flows directly into the program
	 
    Returns:
	 - N/A
    
    Local Variable List
	 - N/A
    */
    public void splashScreen(){
	c.setColor(lightGrey);//grey background colour
	c.fillRect(0,0,900,660);//rectangle to cover background

	//Animation for '5'
	//Animates clockwise motion using an arc that slowly fills the screen
	for(int i=0;i>=-360;i--){
	    c.setColor(darkGrey);
	    c.fillArc(-157,-270,1200,1200,90,i);
	    c.setColor(lineGrey);
	    
	    //horizontal line (extra lines for thickness)
	    c.drawLine(0,331,900,331);
	    c.drawLine(0,330,900,330);
	    c.drawLine(0,329,900,329);
	    
	    //vertical line (extra lines for thickness)
	    c.drawLine(440,0,440,660);
	    c.drawLine(441,0,441,660);
	    c.drawLine(442,0,442,660);
	    
	    //displaying the countdown number
	    c.setColor(Color.BLACK);
	    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,300));
	    c.drawString("5",358,428);
	    
	    try{
	       Thread.sleep(3);//'slows down' the animation
	    }
	    catch(Exception e){}//catches any unexpected errors
	}
	c.setColor(lightGrey);
	c.fillRect(0,0,900,660);//redrawing background
	

	
	//Animation for '4'
	for(int i=0;i>=-360;i--){
	    c.setColor(darkGrey);
	    c.fillArc(-157,-270,1200,1200,90,i);
	    c.setColor(lineGrey);
	    //horizontal line (extra lines for thickness)
	    c.drawLine(0,331,900,331);
	    c.drawLine(0,330,900,330);
	    c.drawLine(0,329,900,329);
	    //vertical line (extra lines for thickness)
	    c.drawLine(440,0,440,660);
	    c.drawLine(441,0,441,660);
	    c.drawLine(442,0,442,660);
       
	    c.setColor(Color.BLACK);
	    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,300));

	    c.drawString("4",358,428);
	    
	    try{
	       Thread.sleep(3);
	    }
	    catch(Exception e){}
	}
	
	
	//Animation for '3'
	c.setColor(lightGrey);
	c.fillRect(0,0,900,660);
	for(int i=0;i>=-360;i--){
	    c.setColor(darkGrey);
	    c.fillArc(-157,-270,1200,1200,90,i);
	    c.setColor(lineGrey);
	    //horizontal line (extra lines for thickness)
	    c.drawLine(0,331,900,331);
	    c.drawLine(0,330,900,330);
	    c.drawLine(0,329,900,329);
	    //vertical line (extra lines for thickness)
	    c.drawLine(440,0,440,660);
	    c.drawLine(441,0,441,660);
	    c.drawLine(442,0,442,660);
       
	    c.setColor(Color.BLACK);
	    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,300));

	    c.drawString("3",358,428);
	    
	    try{
	       Thread.sleep(3);
	    }
	    catch(Exception e){}
	}
	
	
	//Animation for '2'
	c.setColor(lightGrey);
	c.fillRect(0,0,900,660);
	for(int i=0;i>=-360;i--){
	    c.setColor(darkGrey);
	    c.fillArc(-157,-270,1200,1200,90,i);
	    c.setColor(lineGrey);
	    //horizontal line (extra lines for thickness)
	    c.drawLine(0,331,900,331);
	    c.drawLine(0,330,900,330);
	    c.drawLine(0,329,900,329);
	    //vertical line (extra lines for thickness)
	    c.drawLine(440,0,440,660);
	    c.drawLine(441,0,441,660);
	    c.drawLine(442,0,442,660);
       
	    c.setColor(Color.BLACK);
	    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,300));

	    c.drawString("2",358,428);

	    
	    try{
	       Thread.sleep(3);
	    }
	    catch(Exception e){}
	}
	
	
	//Animation for '1'
	c.setColor(lightGrey);
	c.fillRect(0,0,900,660);
	for(int i=0;i>=-360;i--){
	    c.setColor(darkGrey);
	    c.fillArc(-157,-270,1200,1200,90,i);
	    c.setColor(lineGrey);
	    //horizontal line (extra lines for thickness)
	    c.drawLine(0,331,900,331);
	    c.drawLine(0,330,900,330);
	    c.drawLine(0,329,900,329);
	    //vertical line (extra lines for thickness)
	    c.drawLine(440,0,440,660);
	    c.drawLine(441,0,441,660);
	    c.drawLine(442,0,442,660);
       
	    c.setColor(Color.BLACK);
	    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,300));
	    
	    c.drawString("1",345,428);
	    
	    try{
	       Thread.sleep(3);
	    }
	    catch(Exception e){}
	}
	try{
	Thread.sleep(400);
	}
	catch(Exception e){}
	
	
    }
    
    
    /*
    
    mainMenu()
    
    Variables Used:
	 - menuDecision --> gets user input which determines the next screen
    
    Actions:
	 - method gives the user 3 options to either continue to book a seat, read instructions, or exit the program
	 
    Returns:
	 - N/A
    
    Local Variable List
	 - N/A
    */
    public void mainMenu(){
	title();//calling title to erase previous screen and set up background
	
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,35));//setting font
	c.drawString("Press: ",102,170);
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,25));
	c.drawString("1. To book a seat", 160,215);
	c.drawString("2. For help (instructions)", 160,260);
	c.drawString("3. To exit ", 160,305);
	
	//logo
	c.setColor(yellowRings);
	c.fillOval(145,396,600,180);
	
	c.setColor(background);
	c.fillOval(185,410,514,158);
	
	c.setColor(yellowRings);
	c.fillOval(227,420,425,142);
	
	c.setColor(background);
	c.fillOval(260,433,358,120);
	
	c.setColor(yellowRings);
	c.fillOval(285,446,304,100);
	
	c.setColor(background);
	c.fillOval(306,457,260,80);
	
	int xpoints[] = {404,472,418,458};
	int ypoints[] = {396,396,576,576};
	int npoints = 4;
	c.fillPolygon(xpoints,ypoints,npoints); 
	
	//getting user input
	menuDecision = c.getChar();
    }
    
    
    /*
    
    instructions()
    
    Variables Used:
	 - background --> colour of the background
    
    Actions:
	 - method displays simple instructions to help the user
	 
    Returns:
	 - N/A
    
    Local Variable List
	 - N/A
    */
    public void instructions(){
	c.clear();
	c.setColor(background);
	c.fillRect(0,0,900,660);
	
	//displaying text
	c.setColor(Color.WHITE);
	c.setFont(new Font("Sans Serif",Font.BOLD,70));
	c.drawString("Help / Instructions", 147,80);

	c.setFont(new Font("Sans Serif",Font.PLAIN,20));
	c.drawString(" - When selecting a movie theatre or movie press enter to autofill the search bar with the first",30,150); 
	c.drawString("predicted search result. ", 50,178);
	c.drawString(" - After selecting your movie theatre or movie, press enter to comfirm and continue",30,225);
	c.drawString(" - When selecting the your seat location, use 'w','a','s','d' to maneuver",30,275);
	
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
	c.drawString("Press any key to return",350,600);
	
	//getting input to return the the main menu
	c.getChar();
	
    }
    
    
    /*
    
    movieTheatreSelection()
    
    Variables Used:
	 - background --> colour of the background
	 - yellowRings --> adds extra colour to the screen
    
    Actions:
	 - method asks user for the movie theatre they would like, the movie the user wants to watch, and the date
	 - method will use getChar() to take the input the user is typing, the input is then outputted using drawString
	 
    Returns:
	 - N/A
    
    Local Variable List:
	Name                       Type         Description
	-------------------------|---------- |----------------------------------- 
	theatreInput             |  char     |  stores the input the user types when taking input for the theatre
	secInput                 |  char     |  stores the second input (input the user types after the user presses enter), this is done to check for the next step
	dateInput                |  char     |  stores the input the user types when taking input for the date
	dateSecInput             |  char     |  stores the second input (input the user types after the user presses enter), this is done to check for the next step
	movieInput               |  char     |  stores the input the user types when taking input for the movie
	movieSecInput            |  char     |  stores the second input (input the user types after the user presses enter), this is done to check for the next step
	theatre                  |  String   |  stores the theatre the user types by compinbining theatreInput
	chosenTheatre            |  String   |  stores the theatre the user WANTS to choose
	theatreCheck             |  String   |  checks that the chosenTheatre is valid
	movie                    |  String   |  stores the movie the user types by compinbining movieInput
	chosenMovie              |  String   |  stores the movie the user WANTS to choose
	movieCheck               |  String   |  checks that the chosenMovie is valid
	date                     |  String   |  stores the date the user types by compinbining dateInput
	dd                       |  int      |  stores the date 
	mm                       |  int      |  stores the month
	yyyy                     |  int      |  stores the year
	theatreMatch             |  boolean  |  allows code to continue if theatre is valid
	movieMatch               |  boolean  |  allows code to continue if movie is valid
	dateMatch                |  boolean  |  allows code the continue if date is valid
    */
    public void movieTheatreSelection(){
	char theatreInput;
	char secInput;
	char dateInput;
	char dateSecInput;
	char movieInput;
	char movieSecInput;
	
	String theatre = "";
	String chosenTheatre = "";
	String theatreCheck = "";
	String movie = "";
	String chosenMovie = "";
	String movieCheck = "";
	String date = "";
	
	int dd;
	int mm;
	int yyyy;
	
	boolean theatreMatch = false;
	boolean movieMatch = false;
	boolean dateMatch = false;
	
	title(); 
	
	//search bar
	c.setColor(Color.WHITE);
	c.fillRect(333,123,370,43);
	
	//setting font and displaying text
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,26));
	c.drawString("Please Select a Theatre: ",35,155);
	
	c.setColor(Color.BLACK);
	c.setFont(new Font("Sans Serif",Font.PLAIN,15));
	c.drawString("Search by Theatre", 450,150);

	c.setColor(yellowRings);
	c.fillRect(752,0,35,380);
	c.fillRect(818,220,35,550);
	
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
	
	//takes input until user press enter to confirm and move on to movies
	while(true){
	    theatreInput = c.getChar();//taking the character the user is typing
	    
	    //rectangle erases the autofill search bar
	    c.setColor(background);
	    c.fillRect(300,167,425,300);

	    if(theatreInput == '\n'){//if user presses enter
		if(theatre.length()==0){//if there is no input, the user cannot continue onto movies
		    continue;
		}
		
		//validates input
		if(!(chosenTheatre.equals(""))){
		    c.setColor(Color.WHITE);
		    c.fillRect(333,123,370,43);
		    c.setColor(Color.BLACK);
		    theatre = chosenTheatre;
		    c.drawString(theatre,339,150);
		    chosenTheatre = "";
		    
		    //checking theatre string is valid
		    try{
			BufferedReader input = new BufferedReader(new FileReader("theatreList.txt"));
			for(int i=0;i<48;i++){
			    theatreCheck = input.readLine();
			    if(theatre.equalsIgnoreCase(theatreCheck)){
				theatreMatch = true;
				break; 
			    }
			    else{
				theatreMatch = false;
			    }
			}
		    }
		    catch(IOException e){}
		    
		    //if theatre input is invalid theatreMatch is false
		    if(theatreMatch == true){
			secInput = c.getChar();
			if(secInput == '\n'){//second input is used after enter is pressed to autofill the search bar to allow the user to move onto searching for a movie
			    theatreChoice = theatre;
			    break;
			}
			else{
			    theatreInput = secInput;
			}
			
		    }
		    
		}
		else{
		    continue;
		}
	    }
	    
	    //if the user presses enter and the input is valied, the user can continue onto the next search bar (for the movie)
	    if(theatreInput == '\n' && theatreMatch == true){
		break;
	    }
	    
	    //if the input is backspace and there is nothing to erase, continue
	    if(theatre.length()==0 && theatreInput == 8){
		continue;
	    }
	    
	    //if the input is backspace the string theatre (variable that holds the entire string) will be reduced by a a length of 1 using substring
	    else if(theatreInput == 8 && theatre.length()>=1){
		theatre = theatre.substring(0,theatre.length()-1);//reducing length
		c.setColor(Color.WHITE);
		c.fillRect(333,123,370,43);
		c.setColor(Color.BLACK);
		c.drawString(theatre,339,150);
		
		//searches through text file theatreList to check if any names are the same to autofill the search bar
		try{
		    boolean check = false;
		    int rectCount = 0;
		    String theatreName = "";
		    BufferedReader input = new BufferedReader(new FileReader("theatreList.txt"));
		    //reads input for the number of lines in the file
		    for(int i=0;i<48;i++){
			theatreName = input.readLine();
			if(theatre.length()>0){
			    if(theatre.length()<=theatreName.length()){
				if(theatre.equalsIgnoreCase(theatreName.substring(0,theatre.length()))){
				    if(rectCount == 0){
					chosenTheatre = theatreName;
				    }
				    
				    //displays the autofill
				    rectCount++;
				    c.setColor(Color.WHITE);
				    c.fillRect(333,(123+(43*rectCount)),370,43);//drawing the white rects 
				    c.setColor(Color.BLACK);
				    c.drawString(theatreName,339,(150+(43*rectCount)));
				    check = true;
				}
				
			    }
			}
		    }
		    if(check == false){
			chosenTheatre = "";
		    }
		}
		catch(IOException e){}//catches any error from reading from a text file
	    }
	    else if(theatre.length()>=24){//set limit on the maximum the user can type (24 characters)
		continue;
	    }
	    else{
		//if the input is a space an underscore is outputted so the user knows where they are typing since there is no cursor
		if(theatreInput == 32){
		    theatre += "_";
		    c.setColor(Color.WHITE);
		    c.fillRect(333,123,370,43);
		    c.setColor(Color.BLACK);
		    c.drawString(theatre,339,150);//drawing the string theatre
		}
		
		//all letters and other characters are simply outputted
		else{
		    theatre += theatreInput;
		    c.setColor(Color.WHITE);
		    c.fillRect(333,123,370,43);
		    c.setColor(Color.BLACK);
		    c.drawString(theatre,339,150);
		}
		
		//searches through text file theatreList to check if any names are the same to autofill the search bar
		try{
		    boolean check = false;
		    int rectCount = 0;
		    String theatreName = "";
		    BufferedReader input = new BufferedReader(new FileReader("theatreList.txt"));
		    for(int i=0;i<48;i++){
			theatreName = input.readLine();
			if(theatre.length()<=theatreName.length()){ 
			    if(theatre.equalsIgnoreCase(theatreName.substring(0,theatre.length()))){
				if(rectCount == 0){
				    chosenTheatre = theatreName;
				}
				rectCount++;
				c.setColor(Color.WHITE);
				c.fillRect(333,(123+(43*rectCount)),370,43);
				c.setColor(Color.BLACK);
				c.drawString(theatreName,339,(150+(43*rectCount)));
				check = true;
			    }
			   
			}
		    }
		    if(check == false){
			chosenTheatre = "";
		    }
		}
		catch(IOException e){}
	    }
	    
	    //determines if the string the user typed is a valid movie theatre
	    try{
		BufferedReader input = new BufferedReader(new FileReader("theatreList.txt"));
		for(int i=0;i<48;i++){
		     theatreCheck = input.readLine();
		     if(theatre.equalsIgnoreCase(theatreCheck)){
			theatreMatch = true;
			break; 
		     }
		     else{
			theatreMatch = false;
		     }
		}
	    }
	    catch(IOException e){}
	    

	}
	
	//EXTRA INFO
	//block of code above is equal to block of code below with different variable names

	//movie selection search bar
	c.setColor(Color.WHITE);
	c.fillRect(333,223,370,43);
	
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,26));
	c.drawString("Please Select a Movie: ",35,255);
	
	c.setFont(new Font("Sans serif",Font.PLAIN,20));
	c.drawString("*Press '=' to see a list of movies now playing",35,430);
	
	c.setColor(Color.BLACK);
	c.setFont(new Font("Sans Serif",Font.PLAIN,15));
	c.drawString("Seach by Movie", 454,250);
	
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
	
	while(true){
	    movieInput = c.getChar();
	    c.setColor(background);
	    c.fillRect(300,267,425,150);
	    
	    //if input is '=' a list of movies is printed
	    if(movieInput == 61){
		title();
		c.setColor(Color.WHITE);
		c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,30));
		c.drawString("Now Playing",340,145);
		c.setFont(new Font("Sans Serif",Font.PLAIN,20));
		//left column
		c.drawString("A_Quiet_Place_2",160,200);
		c.drawString("Bad_Boys_for_Life",160,230);
		c.drawString("Black_Widow",160,260);
		c.drawString("Cats",160,290);
		c.drawString("Dolittle",160,320);
		c.drawString("Ford_V_Ferrari",160,350);
		c.drawString("Frozen_2",160,380);
		c.drawString("Gretel_&_Hansen",160,410);
		c.drawString("Joker",160,440);
		c.drawString("Jumanji_2",160,470);
		c.drawString("Jungle_Cruise",160,500);
		c.drawString("Little_Women",160,530);
		
		//right column
		c.drawString("Midway",530,200);
		c.drawString("Minions:_Rise_of_Gru",530,230);
		c.drawString("Mulan",530,260);
		c.drawString("No_Time_To_Die",530,290);
		c.drawString("Onward",530,320);
		c.drawString("Rise_of_Skywalker",530,350);
		c.drawString("Sonic_The_Hedgehog",530,380);
		c.drawString("Spies_in_Disguise",530,410);
		c.drawString("The_Turning",530,440);
		c.drawString("Venom_2",530,470);
		c.drawString("Wonder_Women_2",530,500);
		c.drawString("Weathering_With_You",530,530);
		
		c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,25));
		c.drawString("Press any key to return",280,600);
		c.getChar();
		
		//when any character is pressed, the screen changes back to the previous input screen
		title();
		c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,26));
		c.drawString("Please Select a Theatre: ",35,155);
		c.setColor(Color.WHITE);
		c.fillRect(333,123,370,43);
		c.setColor(Color.BLACK);
		c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
		c.drawString(theatre,339,150);
	    
		c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,26));
		c.setColor(Color.WHITE);
		c.drawString("Please Select a Movie: ",35,255);
		c.fillRect(333,223,370,43);
		c.setFont(new Font("Sans serif",Font.PLAIN,20));
		c.drawString("*Press '=' to see a list of movies now playing",35,430);
		c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
		c.setColor(Color.BLACK);
		c.drawString(movie,339,250);
		continue;
	    }
	    
	    if(movieInput == '\n'){
		if(movie.length()==0){
		    continue;
		}
		if(!(chosenMovie.equals(""))){
		    c.setColor(Color.WHITE);
		    c.fillRect(333,223,370,43);
		    c.setColor(Color.BLACK);
		    movie = chosenMovie;
		    c.drawString(movie,339,250);
		    chosenMovie = "";
		    try{
			BufferedReader input2 = new BufferedReader(new FileReader("movieList.txt"));
			for(int i=0;i<24;i++){
			    movieCheck = input2.readLine();
			    if(movie.equalsIgnoreCase(movieCheck)){
				movieMatch = true;
				break; 
			    }
			    else{
				movieMatch = false;
			    }
			}
		    }
		    catch(IOException e){}
		    if(movieMatch == true){
			movieSecInput = c.getChar();
			if(movieSecInput == '\n'){
			    movieChoice = movie;
			    break;
			}
			else if(movieSecInput == 61){
			    title();
			    c.setColor(Color.WHITE);
			    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,30));
			    c.drawString("Now Playing",340,145);
			    c.setFont(new Font("Sans Serif",Font.PLAIN,20));
			    //left column
			    c.drawString("A_Quiet_Place_2",160,200);
			    c.drawString("Bad_Boys_for_Life",160,230);
			    c.drawString("Black_Widow",160,260);
			    c.drawString("Cats",160,290);
			    c.drawString("Dolittle",160,320);
			    c.drawString("Ford_V_Ferrari",160,350);
			    c.drawString("Frozen_2",160,380);
			    c.drawString("Gretel_&_Hansen",160,410);
			    c.drawString("Joker",160,440);
			    c.drawString("Jumanji_2",160,470);
			    c.drawString("Jungle_Cruise",160,500);
			    c.drawString("Little_Women",160,530);
		
			    //right column
			    c.drawString("Midway",530,200);
			    c.drawString("Minions:_Rise_of_Gru",530,230);
			    c.drawString("Mulan",530,260);
			    c.drawString("No_Time_To_Die",530,290);
			    c.drawString("Onward",530,320);
			    c.drawString("Rise_of_Skywalker",530,350);
			    c.drawString("Sonic_The_Hedgehog",530,380);
			    c.drawString("Spies_in_Disguise",530,410);
			    c.drawString("The_Turning",530,440);
			    c.drawString("Venom_2",530,470);
			    c.drawString("Wonder_Women_2",530,500);
			    c.drawString("Weathering_With_You",530,530);
		
			    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,25));
			    c.drawString("Press any key to return",280,600);
			    c.getChar();
			    title();
			    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,26));
			    c.drawString("Please Select a Theatre: ",35,155);
			    c.setColor(Color.WHITE);
			    c.fillRect(333,123,370,43);
			    c.setColor(Color.BLACK);
			    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
			    c.drawString(theatre,339,150);
	    
			    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,26));
			    c.setColor(Color.WHITE);
			    c.drawString("Please Select a Movie: ",35,255);
			    c.fillRect(333,223,370,43);
			    c.setFont(new Font("Sans serif",Font.PLAIN,20));
			    c.drawString("*Press '=' to see a list of movies now playing",35,430);
			    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
			    c.setColor(Color.BLACK);
			    c.drawString(movie,339,250);
			    continue;
			}
			else{
			    movieInput = movieSecInput;
			}
			
		    }
		    
		}
		else{
		    continue;
		}
	    }
	    if(movieInput == '\n' && movieMatch == true){
		break;
	    }
	    
	    if(movie.length()==0 && movieInput == 8){
		continue;
	    }
	    
	    
	    else if(movieInput == 8 && movie.length()>=1){
		movie = movie.substring(0,movie.length()-1);
		c.setColor(Color.WHITE);
		c.fillRect(333,223,370,43);
		c.setColor(Color.BLACK);
		c.drawString(movie,339,250);
		try{
		    boolean check = false; 
		    int rectCountMovie = 0;
		    String movieName = "";
		    BufferedReader input2 = new BufferedReader(new FileReader("movieList.txt"));
		    for(int i=0;i<24;i++){
			movieName = input2.readLine();
			if(movie.length()>0){
			    if(movie.length()<=movieName.length()){
				if(movie.equalsIgnoreCase(movieName.substring(0,movie.length()))){
				    if(rectCountMovie == 0){
					chosenMovie = movieName;
				    }
				    rectCountMovie++;
				    c.setColor(Color.WHITE);
				    c.fillRect(333,(223+(43*rectCountMovie)),370,43);
				    c.setColor(Color.BLACK);
				    c.drawString(movieName,339,(250+(43*rectCountMovie)));
				    check = true;  
				}
				
			    }
			}
		    }
		    if(check == false){ 
			chosenMovie = "";
		    }
		}
		catch(IOException e){}
	    }
	    else if(movie.length()>=24){
		continue;
	    }
	    else{
		if(movieInput == 32){
		    movie += "_";
		    c.setColor(Color.WHITE);
		    c.fillRect(333,223,370,43);
		    c.setColor(Color.BLACK);
		    c.drawString(movie,339,250);
		}
		else{
		    movie += movieInput;
		    c.setColor(Color.WHITE);
		    c.fillRect(333,223,370,43);
		    c.setColor(Color.BLACK);
		    c.drawString(movie,339,250);
		}
		try{
		    boolean check = false; 
		    int rectCountMovie = 0;
		    String movieName = "";
		    BufferedReader input2 = new BufferedReader(new FileReader("movieList.txt"));
		    for(int i=0;i<24;i++){
			movieName = input2.readLine();
			if(movie.length()<=movieName.length()){ 
			    if(movie.equalsIgnoreCase(movieName.substring(0,movie.length()))){
				if(rectCountMovie == 0){
				    chosenMovie = movieName;
				}
				rectCountMovie++;
				c.setColor(Color.WHITE);
				c.fillRect(333,(223+(43*rectCountMovie)),370,43);
				c.setColor(Color.BLACK);
				c.drawString(movieName,339,(250+(43*rectCountMovie)));
				check = true;
			    }
			   
			}
		    }
		    if(check == false){
			chosenMovie = "";
		    }
		}
		catch(IOException e){}
	    }
	    
	    try{
		BufferedReader input2 = new BufferedReader(new FileReader("moveList.txt"));
		for(int i=0;i<24;i++){
		     movieCheck = input2.readLine();
		     if(movie.equalsIgnoreCase(movieCheck)){
			movieMatch = true;
			break; 
		     }
		     else{
			movieMatch = false;
		     }
		}
	    }
	    catch(IOException e){}
	    
	}
	

	//date search bar
	c.setColor(background);
	c.fillRect(30,400,400,75);
	
	c.setColor(Color.WHITE);
	c.fillRect(333,323,370,43);
	
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,26));
	c.drawString("Please Select a Date: ",35,355);
	
	c.setFont(new Font("Sans serif",Font.PLAIN,20));
	c.drawString("*Showtimes are available from Monday to Thursday",35,430);
	c.drawString("*Seats can only be booked for January 2020",35,480);
	c.drawString("*There are screenings of each movie everyday",35,530);
	
	c.setColor(Color.BLACK);
	c.setFont(new Font("Sans Serif",Font.PLAIN,15));
	c.drawString("DD/MM/YYYY", 454,350);
	
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
	
	//takes input until user presses enter and input is valid
	while(true){
	    dateInput = c.getChar();
	    if(dateInput == '\n'){
	    
		//errortrapping
		if(date.length()==0){
		    continue;
		}
		else{
			//using the dd/mm/yyyy format the length can only be 10
			if(date.length()!=10){
			    dateMatch  = false;
			    JOptionPane.showMessageDialog(null,"Your date is invalid, please use the format DD/MM/YYYY","Error",JOptionPane.ERROR_MESSAGE);
			    continue;
			}
			
			//there must be backslashes
			if(date.charAt(2) != '/' || date.charAt(5) != '/' ){
			    dateMatch  = false;
			    JOptionPane.showMessageDialog(null,"Your date is invalid, please use the format DD/MM/YYYY","Error",JOptionPane.ERROR_MESSAGE);
			    continue;
			}
			
			//casting string to ints to errortrap
			try{
			    int monthDays = 0;
			    dd = Integer.parseInt(date.substring(0,2));
			    mm = Integer.parseInt(date.substring(3,5));
			    yyyy = Integer.parseInt(date.substring(6));
			    
			    //errortraps for fridays
			    if(dd == 3 || dd == 10 || dd == 17 || dd == 24 || dd == 31){
				dateMatch = false;
				JOptionPane.showMessageDialog(null,"Showtimes are Monday through Thursday, January " + dd + " is a Friday","Error",JOptionPane.ERROR_MESSAGE);
				continue;
			    }
			    
			    //errortraps for saturdays
			    else if(dd == 4 || dd == 11 || dd == 18 || dd == 25){
				dateMatch = false;
				JOptionPane.showMessageDialog(null,"Showtimes are Monday through Thursday, January " + dd + " is a Saturday","Error",JOptionPane.ERROR_MESSAGE);
				continue;
			    }
			    
			    //errortraps for sundays
			    else if(dd == 5 || dd == 12 || dd == 19 || dd == 26){
				dateMatch = false;
				JOptionPane.showMessageDialog(null,"Showtimes are Monday through Thursday, January " + dd + " is a Sunday","Error",JOptionPane.ERROR_MESSAGE);
				continue;
			    }
			    
			    //january only has 31 days
			    if(dd>31){
				dateMatch = false;
				throw new Exception ();
			    }
			    else{
				dateMatch = true;
			    }
			    try{
				if(mm!=1){//seat booking is only available for January
				    dateMatch = false;
				    throw new Exception ();
				}
				else{
				    dateMatch = true;
				}
				try{
				    if(yyyy != 2020){//booking only available for 2020
					dateMatch = false;
					throw new Exception ();
				    }
				    else{
					dateMatch = true;
				    }
				}
				catch(Exception e){
				    JOptionPane.showMessageDialog(null,"You can only book seats a year in advance for 2020","Error",JOptionPane.ERROR_MESSAGE);//error messages
				}
			    }
			    catch(Exception e){
				JOptionPane.showMessageDialog(null,"The seat bookings are only available for January 2020","Error",JOptionPane.ERROR_MESSAGE);
			    }
			}
			catch(NumberFormatException e){
			    JOptionPane.showMessageDialog(null,"Your date is invalid, please use the format DD/MM/YYYY","Error",JOptionPane.ERROR_MESSAGE);
			}
			catch(Exception e){
			    JOptionPane.showMessageDialog(null,"There are a maximum of 31 days in January","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(dateMatch == true){
		    dateChoice = date;
		    break;                        
		}
		else{
		    continue;
		}
	    }
	    if(dateInput == '\n' && dateMatch == true){
		break;
	    }
	    
	    if(date.length()==0 && dateInput == 8){
		continue;
	    }
	    
	    
	    else if(dateInput == 8 && date.length()>=1){
		date = date.substring(0,date.length()-1);
		c.setColor(Color.WHITE);
		c.fillRect(333,323,370,43);
		c.setColor(Color.BLACK);
		c.drawString(date,339,350);
		
	    }
	    else if(date.length()>=24){
		continue;
	    }
	    else{
		if(dateInput == 32){
		    date += "_";
		    c.setColor(Color.WHITE);
		    c.fillRect(333,323,370,43);
		    c.setColor(Color.BLACK);
		    c.drawString(date,339,350);
		}
		else{
		    date += dateInput;
		    c.setColor(Color.WHITE);
		    c.fillRect(333,323,370,43);
		    c.setColor(Color.BLACK);
		    c.drawString(date,339,350);
		}
	       
	    }
	    
	    
	    
	}
	
	
    }
    
    /*
    
    seat()
    
    Variables Used:
	 - background --> colour of the background
    
    Actions:
	 - a return method that draws the seat graphic when selecting a seat
	 
    Returns:
	 - a graphic
    
    Local Variable List:
	 - N/A
    */
    private void seat(int x, int y,Color col){
	c.setColor(col);
	c.fillRoundRect(x,y,17,22,5,5);
	c.setColor(background);
	c.fillRect(x,y+12,17,4);
    }
    
    /*
    
    seatTypeSelection()
    
    Variables Used:
	 - background --> colour of the background
	 - yellowRings --> adds extra colour to the screen
    
    Actions:
	 - method asks user for the type of seat they would like to sit in
	 - there is the option of regular, wheelchair, or deluxe
	 - pressing M or m allows a map of the seating arrangement to be shown
	 
    Returns:
	 - N/A
    
    Local Variable List:
	Name                       Type         Description
	-------------------------|----------|----------------------------------- 
	lineNums                 |  int     |  stores the number of lines in the file
	numericLocation          |  int     |  stores the numberic portion of the seat location
	alphaLocation            |  char    |  stores the alphabetic portion of the seat location
	reserved                 |  String  |  stores the reserved seats
	seatLocation             |  String  |  stores the seat location
	checkFile                |  File    |  stores the file name
	
    */
    public void seatTypeSelection(){
	int lineNums = 0;
	int numericLocation;
	char alphaLocation;
	String reserved = "";
	String seatLocation = "";
	File checkFile = new File(theatreChoice + " " + movieChoice + " " + dateChoice.substring(0,2) + dateChoice.substring(3,5) + dateChoice.substring(6) + ".txt");
    
	title();
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,30));
	c.drawString("Please select a type of seat: ",50,170);
	
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,27));
	c.drawString("To see a map of all the seats press M or m",50,460);
	
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,25));
	c.drawString("1. For a Regular seat (average price: $15)",180,233);
	c.drawString("2. For a Wheelchair seat (average price: $15)",180,293);
	c.drawString("3. For a Deluxe seat (average price: $30)",180,353);
	
	c.setColor(yellowRings);
	c.fillRect(752,0,35,380);
	c.fillRect(818,220,35,550);
	
	//continously gets input until user enters vaild input
	while(true){
	    seatTypeDecision = c.getChar();
	    
	    if(seatTypeDecision == '1' || seatTypeDecision == '2' || seatTypeDecision == '3'){
		break;
	    }
	   
	    else if(seatTypeDecision == 'M' || seatTypeDecision == 'm'){
		c.clear();
		c.setColor(background);
		c.fillRect(0,0,900,660);
		c.setColor(Color.WHITE);
		c.fillRect(260,3,500,65);
		c.setColor(Color.BLACK);
		c.setFont(new Font("Sans Serif",Font.BOLD,30));
		c.drawString("STAGE/SCREEN",390,40);
		//regular seats
		for(int x=140;x<890;x+=25){
		    for(int y=100;y<559;y+=27){
			seat(x,y,Color.GREEN);
		   }
		}
		//deluxe seats
		c.setColor(Color.ORANGE);
		for(int xd = 140;xd<890;xd+=25){
		    for(int yd=559;yd<640;yd+=27){
			seat(xd,yd,Color.ORANGE);
		    }
		}
		//wheelchair seats
		seat(265,100,wheelBlue);
		seat(340,100,wheelBlue);
		seat(415,100,wheelBlue);
		seat(490,100,wheelBlue);
		seat(565,100,wheelBlue);
		seat(640,100,wheelBlue);
		seat(715,100,wheelBlue);
		seat(790,100,wheelBlue);
		
		//if the file exists read from it
		if(checkFile.exists()){
		    //counts the number of lines in the file
		    try{
			BufferedReader lineInput = new BufferedReader(new FileReader(theatreChoice + " " + movieChoice + " " + dateChoice.substring(0,2) + dateChoice.substring(3,5) + dateChoice.substring(6) + ".txt"));
			String checkingLength = "";
		
			while(checkingLength!=null){
			    checkingLength = lineInput.readLine();
			    lineNums ++;
			}
		    }
		    catch (IOException e) {}
		    try{
			//gets the reserved seat location
			BufferedReader locationInput = new BufferedReader(new FileReader(theatreChoice + " " + movieChoice + " " + dateChoice.substring(0,2) + dateChoice.substring(3,5) + dateChoice.substring(6) + ".txt"));
			for(int i=0;i<lineNums/4;i++){
			    seatLocation = locationInput.readLine();
			    if(seatLocation.length()==2){
				alphaLocation = seatLocation.charAt(0);
				numericLocation = Integer.parseInt(seatLocation.substring(1));
			    }
			    else{
				alphaLocation = seatLocation.charAt(0);
				numericLocation = Integer.parseInt(seatLocation.substring(1));
			    }
			    seat(140+((numericLocation-1)*25),100+((alphaLocation - 65)*27),Color.RED);//outputs a read seat if the seat is reserved
			    reserved += seatLocation;
			    locationInput.readLine();
			    locationInput.readLine();
			    locationInput.readLine();
			}
		    }
		    catch (IOException e) {}
		}
		
		//legend
		c.setColor(Color.RED);
		c.fillRect(10,120,20,20);
		
		c.setColor(wheelBlue);
		c.fillRect(10,170,20,20);
		
		c.setColor(Color.GREEN);
		c.fillRect(10,220,20,20);
		
		c.setColor(Color.ORANGE);
		c.fillRect(10,270,20,20);
		
		c.setColor(Color.WHITE);
		c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,18));
		c.drawString("Press any key",12,595);
		c.drawString("to return",27,615);
		
		c.setFont(new Font("Sans Serif",Font.PLAIN,18));
		c.drawString("Resevered",36,136);
		c.drawString("Wheelchair",36,186);
		c.drawString("Regular",36,236);
		c.drawString("Deluxe",36,286);
		
		c.getChar();
		
		title();
		c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,30));
		c.drawString("Please select a type of seat: ",50,170);
		
		c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,27));
		c.drawString("To see a map of all the seats press M or m",50,460);
		
		c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,25));
		c.drawString("1. For a Regular seat (average price: $15)",180,233);
		c.drawString("2. For a Wheelchair seat (average price: $15)",180,293);
		c.drawString("3. For a Deluxe seat (average price: $30)",180,353);
		
		//extra colour and for contrast
		c.setColor(yellowRings);
		c.fillRect(752,0,35,380);
		c.fillRect(818,220,35,550);
		continue;
		
		
	    }
	    else{
		continue;
	    }
	}
    }
    
    /*
    
    seatOutline()
    
    Variables Used:
	 - N/A
    
    Actions:
	 - a return method that draws the outline of a seat to show it is selected
	 
    Returns:
	 - a graphic
    
    Local Variable List:
	 - N/A
    */
    private void seatOutline(int x, int y,Color col){
	c.setColor(col);
	//multiple are drawn for thickness
	c.drawRoundRect(x,y,18,23,10,10);
	c.drawRoundRect(x-1,y-1,20,25,10,10);
	c.drawRoundRect(x-2,y-2,22,27,10,10);
    }
    
    
    
    /*
    NOTE:
	 - Body of code is same as code for wheelchairSeatSelection and deluxeSeatSelection with different variable names
    
    regularSeatSelection()
    
    Variables Used:
	 - background --> colour of the background
    
    Actions:
	 - method asks user to move around with wasd to select a seat
	 
    Returns:
	 - N/A
    
    Local Variable List:
	Name                       Type         Description
	-------------------------|----------|----------------------------------- 
	x                        |  int     |  stores the x location of seat outline
	y                        |  int     |  stores the y location of seat outline
	px                       |  int     |  stores the previous position of the x location
	py                       |  int     |  stores the previous position of the y location
	number                   |  int     |  stores the numberic location of the seat selected which is outputted to the user
	lineNums                 |  int     |  stores the number of lines in a file
	numericLocation          |  int     |  stores the numberic location of the reserved seat
	startTwoDigit            |  int     |  starting point of substring for reservedTwoDigit
	endTwoDigit              |  int     |  ending point of substring for reservedTwoDigit
	startThreeDigit          |  int     |  starting point of substring for reservedThreeDigit
	endThreeDigit            |  int     |  ending point of substring for reservedThreeDigit
	regInput                 |  char    |  stores the regular seat selection input
	alphaLocation            |  char    |  stores the alphabetic location of the reserved seat
	alpha                    |  char    |  stores the alphabetic location of the seat selected which is outputted to the user
	coordinate               |  String  |  stores the coordinate of the selected seat
	precoordinate            |  String  |  stores the coordinate of the previous selected seat
	reservedTwoDigit         |  String  |  stores the reserved seat when the length is only two 
	reservedThreeDigit       |  String  |  stores the reserved seat when the length is three
	seatLocation             |  String  |  stores the seatLocation when checking for previous reservations
	checkFile                |  File    |  stores the file name
	
    */
    public void regularSeatSelection(){
    
	
	int px = 10;
	int py = 84;
	int number = 1;
	int lineNums = 0;
	int numericLocation;
	int startTwoDigit = 0;
	int endTwoDigit = 2;
	int startThreeDigit = 0;
	int endThreeDigit = 3;
	
	boolean reservedCheck = true;
	
	char regInput;
	char alphaLocation;
	char alpha = 65;
	
	String coordinate = "";
	String precoordinate = "A1";
	String reservedTwoDigit = "";
	String reservedThreeDigit = "";
	String seatLocation = "";
	
	File checkFile = new File(theatreChoice + " " + movieChoice + " " + dateChoice.substring(0,2) + dateChoice.substring(3,5) + dateChoice.substring(6) + ".txt");
	
	c.clear();
	c.setColor(background);
	c.fillRect(0,0,900,660);
	
	c.setColor(Color.WHITE);
	c.fillRect(125,3,500,65);
	
	c.setColor(Color.BLACK);
	c.setFont(new Font("Sans Serif",Font.BOLD,30));
	c.drawString("STAGE/SCREEN",259,40);
	
	//outputting the seats 
	for(int x=11;x<761;x+=25){
	    for(int y=85;y<544;y+=27){
		seat(x,y,Color.GREEN);
	    }
	}
	
	//checking reserved seats
	if(checkFile.exists()){
	    try{
		BufferedReader lineInput = new BufferedReader(new FileReader(theatreChoice + " " + movieChoice + " " + dateChoice.substring(0,2) + dateChoice.substring(3,5) + dateChoice.substring(6) + ".txt"));
		String checkingLength = "";
		
		while(checkingLength!=null){
		    checkingLength = lineInput.readLine();
		    lineNums ++;
		}
	    }
	    catch (IOException e) {}
	    try{ 
		BufferedReader locationInput = new BufferedReader(new FileReader(theatreChoice + " " + movieChoice + " " + dateChoice.substring(0,2) + dateChoice.substring(3,5) + dateChoice.substring(6) + ".txt"));
		for(int i=0;i<lineNums/4;i++){
		    seatLocation = locationInput.readLine();
		    if(seatLocation.length()==2){
			alphaLocation = seatLocation.charAt(0);
			numericLocation = Integer.parseInt(seatLocation.substring(1));
			if(alphaLocation >=65 && alphaLocation <82){
			    seat(11+((numericLocation-1)*25),85+((alphaLocation - 65)*27),Color.RED);
			    reservedTwoDigit += seatLocation;
			}
		    }
		    else{
			alphaLocation = seatLocation.charAt(0);
			numericLocation = Integer.parseInt(seatLocation.substring(1));
			if(alphaLocation >=65 && alphaLocation <82){
			    seat(11+((numericLocation-1)*25),85+((alphaLocation - 65)*27),Color.RED);
			    reservedThreeDigit += seatLocation;
			}
		    }
		    
		    locationInput.readLine();
		    locationInput.readLine();
		    locationInput.readLine();
		}
	    }
	    catch (IOException e) {}
	}
	
	//gray seats
	seat(136,85,Color.GRAY);
	seat(211,85,Color.GRAY);
	seat(286,85,Color.GRAY);
	seat(361,85,Color.GRAY);
	seat(436,85,Color.GRAY);
	seat(511,85,Color.GRAY);
	seat(586,85,Color.GRAY);
	seat(661,85,Color.GRAY);
	
	//legend
	c.setColor(Color.GREEN);
	c.fillRect(775,150,20,20);
	c.setColor(Color.RED);
	c.fillRect(775,100,20,20);
	
	//instructions at bottom of screen
	c.setColor(Color.WHITE);
	c.setFont(new Font("Sans Serif",Font.PLAIN,15));
	c.drawString("Reserved",802,115);
	c.drawString("Regular",802,165);
	
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,15));
	c.drawString("To go back press B or b", 10,640);
	
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,18));
	c.drawString("Press enter to confirm and continue", 590,633);
	
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
	c.drawString("The selected seat is : ",60,580);
	c.drawString("The price is:  $25 CAD",470,580);
	
	seatOutline(10,84,outlineBlue);//seat outline
	
	int x=10;
	int y=84;
	c.setColor(Color.WHITE);
	coordinate+=alpha;
	coordinate+=number;
	c.drawString(coordinate,260,581);
	
	//takes user input for wasd to movie around
	while(true){
	    back = '.';
	    px = x;
	    py = y;
	    regInput = c.getChar();
	    coordinate="";
	    
	    if(regInput == 'a' || regInput == 'A'){
		x-=25;//changing x position
		if(x<10){//setting boundary
		    c.setColor(background);//erasing previous text
		    c.fillRect(260,550,50,50);
		    x+=25;
		    c.setColor(Color.WHITE);
		    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
		    c.drawString(precoordinate,260,581);//outputting the selected seat position at the bottom of the screen
		    continue;
		}
		
		//displays the seat price depending on the location
		else{
		    c.setColor(background);
		    c.fillRect(260,550,50,50);
		    number-=1;
		    coordinate+=alpha;
		    coordinate+=number;
		    if(coordinate.equals("A6") || coordinate.equals("A9") || coordinate.equals("A12") || coordinate.equals("A15") || coordinate.equals("A18") || coordinate.equals("A21") || coordinate.equals("A24") || coordinate.equals("A27")){
			c.setColor(background);
			c.fillRect(585,540,90,70);
			c.setColor(Color.WHITE);
			c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
			c.drawString("$15 CAD",590,580);
		    }
		    else if(alpha<=68){
			c.setColor(background);
			c.fillRect(585,540,90,70);
			c.setColor(Color.WHITE);
			c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
			c.drawString("$25 CAD",590,580);
		    }
		    else if(alpha>68 && alpha <=77){
			c.setColor(background);
			c.fillRect(585,540,90,70);
			c.setColor(Color.WHITE);
			c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
			c.drawString("$15 CAD",590,580);
		    }
		    c.setColor(Color.WHITE);
		    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
		    c.drawString(coordinate,260,581);
		    seatOutline(px,py,background);
		    seatOutline(x,y,outlineBlue);
		    precoordinate = coordinate;
		}
		
	    }
	    else if(regInput == 'd' || regInput == 'D'){
		x+=25;
		if(x>736){
		    c.setColor(background);
		    c.fillRect(260,550,50,50);
		    x-=25;
		    c.setColor(Color.WHITE);
		    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
		    c.drawString(precoordinate,260,581);
		    continue;
		}
		else{
		    c.setColor(background);
		    c.fillRect(260,550,50,50);
		    number+=1;
		    coordinate+=alpha;
		    coordinate+=number;
		    if(coordinate.equals("A6") || coordinate.equals("A9") || coordinate.equals("A12") || coordinate.equals("A15") || coordinate.equals("A18") || coordinate.equals("A21") || coordinate.equals("A24") || coordinate.equals("A27")){
			c.setColor(background);
			c.fillRect(585,540,90,70);
			c.setColor(Color.WHITE);
			c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
			c.drawString("$15 CAD",590,580);
		    }
		    else if(alpha<=68){
			c.setColor(background);
			c.fillRect(585,540,90,70);
			c.setColor(Color.WHITE);
			c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
			c.drawString("$25 CAD",590,580);
		    }
		    else if(alpha>68 && alpha <=77){
			c.setColor(background);
			c.fillRect(585,540,90,70);
			c.setColor(Color.WHITE);
			c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
			c.drawString("$15 CAD",590,580);
		    }
		    c.setColor(Color.WHITE);
		    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
		    c.drawString(coordinate,260,581);
		    seatOutline(px,py,background);
		    seatOutline(x,y,outlineBlue);
		    precoordinate = coordinate;
		}
	    }
	    else if(regInput == 'w' || regInput == 'W'){
		y-=27;
		if(y<84){
		    c.setColor(background);
		    c.fillRect(260,550,50,50);
		    y+=27;
		    c.setColor(Color.WHITE);
		    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
		    c.drawString(precoordinate,260,581);
		    continue;
		}
		else{
		    c.setColor(background);
		    c.fillRect(260,550,50,50);
		    alpha-=1;
		    coordinate+=alpha;
		    coordinate+=number;
		    if(coordinate.equals("A6") || coordinate.equals("A9") || coordinate.equals("A12") || coordinate.equals("A15") || coordinate.equals("A18") || coordinate.equals("A21") || coordinate.equals("A24") || coordinate.equals("A27")){
			c.setColor(background);
			c.fillRect(585,540,90,70);
			c.setColor(Color.WHITE);
			c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
			c.drawString("$15 CAD",590,580);
		    }
		    else if(alpha<=68){
			c.setColor(background);
			c.fillRect(585,540,90,70);
			c.setColor(Color.WHITE);
			c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
			c.drawString("$25 CAD",590,580);
		    }
		    else if(alpha>68 && alpha <=77){
			c.setColor(background);
			c.fillRect(585,540,90,70);
			c.setColor(Color.WHITE);
			c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
			c.drawString("$15 CAD",590,580);
		    }
		    c.setColor(Color.WHITE);
		    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
		    c.drawString(coordinate,260,581);
		    seatOutline(px,py,background);
		    seatOutline(x,y,outlineBlue);
		    precoordinate = coordinate;
		}
	    }
	    else if(regInput == 's' || regInput == 'S'){
		y+=27;
		if(y>517){
		    c.setColor(background);
		    c.fillRect(260,550,50,50);
		    y-=27;
		    c.setColor(Color.WHITE);
		    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
		    c.drawString(precoordinate,260,581);
		    continue;
		}
		else{
		    c.setColor(background);
		    c.fillRect(260,550,50,50);
		    alpha+=1;
		    coordinate+=alpha;
		    coordinate+=number;
		    if(coordinate.equals("A6") || coordinate.equals("A9") || coordinate.equals("A12") || coordinate.equals("A15") || coordinate.equals("A18") || coordinate.equals("A21") || coordinate.equals("A24") || coordinate.equals("A27")){
			c.setColor(background);
			c.fillRect(585,540,90,70);
			c.setColor(Color.WHITE);
			c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
			c.drawString("$15 CAD",590,580);
		    }
		    else if(alpha<=68){
			c.setColor(background);
			c.fillRect(585,540,90,70);
			c.setColor(Color.WHITE);
			c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
			c.drawString("$25 CAD",590,580);
		    }
		    else if(alpha>68 && alpha <=77){
			c.setColor(background);
			c.fillRect(585,540,90,70);
			c.setColor(Color.WHITE);
			c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
			c.drawString("$15 CAD",590,580);
		    }
		    else if(alpha >77){
			c.setColor(background);
			c.fillRect(585,540,90,70);
			c.setColor(Color.WHITE);
			c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
			c.drawString("$10 CAD",590,580);
		    }
		    c.setColor(Color.WHITE);
		    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
		    c.drawString(coordinate,260,581);
		    seatOutline(px,py,background);
		    seatOutline(x,y,outlineBlue);
		    precoordinate = coordinate;
		}
	    }
	    
	    //if input is B or b user goes back to the previous screen
	    else if(regInput == 'B' || regInput == 'b'){
		back = regInput;
		break;
	    }
	    
	    //if input is enter, we check if the seat has already been reserved
	    else if(regInput == '\n'){
		//checking reserved list
		startTwoDigit = 0;
		endTwoDigit = 2;
		startThreeDigit = 0;
		endThreeDigit = 3;
		for(int j=0;j<reservedTwoDigit.length()/2;j++){
		    if(reservedTwoDigit.length()<=endTwoDigit){
			if(precoordinate.equals(reservedTwoDigit.substring(startTwoDigit,endTwoDigit))){
			    JOptionPane.showMessageDialog(null,"This seat has already been reserved, please choose another seat","Error",JOptionPane.ERROR_MESSAGE);
				reservedCheck = false;
				break;
			}
			startTwoDigit+=2;
			endTwoDigit+=2;
		    }
		    else{
			break;
		    }
		}
		for(int j=0;j<reservedThreeDigit.length()/3;j++){
		    if(reservedThreeDigit.length()<=endThreeDigit){
			if(precoordinate.equals(reservedThreeDigit.substring(startThreeDigit,endThreeDigit))){
			    JOptionPane.showMessageDialog(null,"This seat has already been reserved, please choose another seat","Error",JOptionPane.ERROR_MESSAGE);
			    reservedCheck = false;
			    break;
			}
			startThreeDigit+=3;
			endTwoDigit+=3;
		    }
		    else{
			break;
		    }
		}
		if(precoordinate.equals("A6") || precoordinate.equals("A9") || precoordinate.equals("A12") || precoordinate.equals("A15") || precoordinate.equals("A18") || precoordinate.equals("A21") || precoordinate.equals("A24") || precoordinate.equals("A27")){
		    JOptionPane.showMessageDialog(null,"The selected seat is reserved for wheelchair users, to book a wheelchair seat please go back to the previous screen and select '2' for wheelchair ","Error",JOptionPane.ERROR_MESSAGE);
		    continue;
		}
		else if(reservedCheck == false){
		    continue;
		}
		else{
		    seatChoice = precoordinate;
		    break;
		}
	    }
	    else{
		c.setColor(Color.WHITE);
		c.drawString(precoordinate,260,581);
		continue;
	    }
	    
	}
	
    }
    
    
    /*
    
    wheelchairSeatSelection()
    
    Variables Used:
	 - background --> colour of the background
    
    Actions:
	 - method asks user to move around with wasd to select a seat
	 
    Returns:
	 - N/A
    
    Local Variable List:
	Name                       Type         Description
	-------------------------|----------|----------------------------------- 
	x                        |  int     |  stores the x location of seat outline
	y                        |  int     |  stores the y location of seat outline
	px                       |  int     |  stores the previous position of the x location
	py                       |  int     |  stores the previous position of the y location
	number                   |  int     |  stores the numberic location of the seat selected which is outputted to the user
	lineNums                 |  int     |  stores the number of lines in a file
	numericLocation          |  int     |  stores the numberic location of the reserved seat
	startTwoDigit            |  int     |  starting point of substring for reservedTwoDigit
	endTwoDigit              |  int     |  ending point of substring for reservedTwoDigit
	startThreeDigit          |  int     |  starting point of substring for reservedThreeDigit
	endThreeDigit            |  int     |  ending point of substring for reservedThreeDigit
	wheelInput               |  char    |  stores the wheelchair seat selection input
	alphaLocation            |  char    |  stores the alphabetic location of the reserved seat
	alpha                    |  char    |  stores the alphabetic location of the seat selected which is outputted to the user
	coordinate               |  String  |  stores the coordinate of the selected seat
	precoordinate            |  String  |  stores the coordinate of the previous selected seat
	reservedTwoDigit         |  String  |  stores the reserved seat when the length is only two 
	reservedThreeDigit       |  String  |  stores the reserved seat when the length is three
	seatLocation             |  String  |  stores the seatLocation when checking for previous reservations
	checkFile                |  File    |  stores the file name
	
    */
    public void wheelchairSeatSelection(){
	int px = 72;
	int py = 99;
	int number = 1;
	int lineNums = 0;
	int numericLocation;
	int startTwoDigit = 0;
	int endTwoDigit = 2;
	int startThreeDigit = 0;
	int endThreeDigit = 3;
	
	boolean reservedCheck = true;
	
	char wheelInput;
	char alpha = 65;
	char alphaLocation;
	
	String coordinate = "",precoordinate = "A1";
	String reservedTwoDigit = "";
	String reservedThreeDigit = "";
	String seatLocation = "";
	
	File checkFile = new File(theatreChoice + " " + movieChoice + " " + dateChoice.substring(0,2) + dateChoice.substring(3,5) + dateChoice.substring(6) + ".txt");
	
	
	c.clear();
	c.setColor(background);
	c.fillRect(0,0,900,660);
	c.setColor(Color.WHITE);
	c.fillRect(193,3,500,65);
	c.setColor(Color.BLACK);
	c.setFont(new Font("Sans Serif",Font.BOLD,30));
	c.drawString("STAGE/SCREEN",325,44);
	for(int x=73;x<823;x+=25){
	    for(int y=100;y<218;y+=27){
		seat(x,y,Color.GRAY);
	    }
	}
	
	//wheelchair seats
	seat(198,100,wheelBlue);
	seat(273,100,wheelBlue);
	seat(348,100,wheelBlue);
	seat(423,100,wheelBlue);
	seat(498,100,wheelBlue);
	seat(573,100,wheelBlue);
	seat(648,100,wheelBlue);
	seat(723,100,wheelBlue);
	
	
	//if file exists check if any seats have been reserved
	if(checkFile.exists()){
	    try{
		BufferedReader lineInput = new BufferedReader(new FileReader(theatreChoice + " " + movieChoice + " " + dateChoice.substring(0,2) + dateChoice.substring(3,5) + dateChoice.substring(6) + ".txt"));
		String checkingLength = "";
		
		while(checkingLength!=null){
		    checkingLength = lineInput.readLine();
		    lineNums ++;
		}
	    }
	    catch (IOException e) {}
	    try{
		BufferedReader locationInput = new BufferedReader(new FileReader(theatreChoice + " " + movieChoice + " " + dateChoice.substring(0,2) + dateChoice.substring(3,5) + dateChoice.substring(6) + ".txt"));
		for(int i=0;i<lineNums/4;i++){
		    seatLocation = locationInput.readLine();
		    if(seatLocation.length()==2){
			alphaLocation = seatLocation.charAt(0);
			numericLocation = Integer.parseInt(seatLocation.substring(1));
			if(alphaLocation == 'A'){
			    seat(73+((numericLocation-1)*25),100,Color.RED);
			    reservedTwoDigit += seatLocation;
			}
		    }
		    else{
			alphaLocation = seatLocation.charAt(0);
			numericLocation = Integer.parseInt(seatLocation.substring(1));
			if(alphaLocation == 'A'){
			    seat(73+((numericLocation-1)*25),100,Color.RED);
			    reservedThreeDigit += seatLocation;
			}
		    }
		    locationInput.readLine();
		    locationInput.readLine();
		    locationInput.readLine();
		}
	    }
	    catch (IOException e) {}
	}

	
	c.setColor(wheelBlue);
	c.fillRect(475,260,20,20);
	c.setColor(Color.RED);
	c.fillRect(300,260,20,20);
	c.setColor(Color.WHITE);
	c.setFont(new Font("Sans Serif",Font.PLAIN,15));
	c.drawString("Reserved",330,275);
	c.drawString("Wheelchair",505,275);
	
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,15));
	c.drawString("To go back press B or b", 10,640);
	
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,18));
	c.drawString("Press enter to confirm and continue", 590,633);
	
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
	c.drawString("The selected seat is:  A1 ",160,370);
	c.drawString("The price is:  $25 CAD",520,370);

	seatOutline(72,99,outlineBlue);//outline of selected seat
	int x=72;
	int y=99;
	c.setColor(Color.WHITE);
	coordinate+=alpha;
	coordinate+=number;
	
	
	//taking input for wasd
	while(true){
	    back = '.';
	    px = x;
	    py = y;
	    wheelInput = c.getChar();
	    coordinate="";
	    if(wheelInput == 'a' || wheelInput == 'A'){
		x-=25;
		if(x<72){
		    c.setColor(background);
		    c.fillRect(355,350,75,50);
		    x+=25;
		    c.setColor(Color.WHITE);
		    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
		    c.drawString(precoordinate,355,370);
		    continue;
		}
		else{
		    c.setColor(background);
		    c.fillRect(355,350,75,50);
		    number-=1;
		    coordinate+=alpha;
		    coordinate+=number;
		    if(coordinate.equals("A6") || coordinate.equals("A9") || coordinate.equals("A12") || coordinate.equals("A15") || coordinate.equals("A18") || coordinate.equals("A21") || coordinate.equals("A24") || coordinate.equals("A27")){
			c.setColor(background);
			c.fillRect(635,350,90,70);
			c.setColor(Color.WHITE);
			c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
			c.drawString("$15 CAD",640,370);
		    }
		    else if(alpha<=68){
			c.setColor(background);
			c.fillRect(635,350,90,70);
			c.setColor(Color.WHITE);
			c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
			c.drawString("$25 CAD",640,370);
		    }
		    else if(alpha>68 && alpha <=77){
			c.setColor(background);
			c.fillRect(635,350,90,70);
			c.setColor(Color.WHITE);
			c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
			c.drawString("$15 CAD",640,370);
		    }
		    c.setColor(Color.WHITE);
		    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
		    c.drawString(coordinate,355,370);
		    seatOutline(px,py,background);
		    seatOutline(x,y,outlineBlue);
		    precoordinate = coordinate;
		}
		
	    }
	    else if(wheelInput == 'd' || wheelInput == 'D'){
		x+=25;
		if(x>811){
		    c.setColor(background);
		    c.fillRect(355,350,75,50);
		    x-=25;
		    c.setColor(Color.WHITE);
		    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
		    c.drawString(precoordinate,355,370);
		    continue;
		}
		else{
		    c.setColor(background);
		    c.fillRect(355,350,75,50);
		    number+=1;
		    coordinate+=alpha;
		    coordinate+=number;
		    if(coordinate.equals("A6") || coordinate.equals("A9") || coordinate.equals("A12") || coordinate.equals("A15") || coordinate.equals("A18") || coordinate.equals("A21") || coordinate.equals("A24") || coordinate.equals("A27")){
			c.setColor(background);
			c.fillRect(635,350,90,70);
			c.setColor(Color.WHITE);
			c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
			c.drawString("$15 CAD",640,370);
		    }
		    else if(alpha<=68){
			c.setColor(background);
			c.fillRect(635,350,90,70);
			c.setColor(Color.WHITE);
			c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
			c.drawString("$25 CAD",640,370);
		    }
		    else if(alpha>68 && alpha <=77){
			c.setColor(background);
			c.fillRect(635,350,90,70);
			c.setColor(Color.WHITE);
			c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
			c.drawString("$15 CAD",640,370);
		    }
		    c.setColor(Color.WHITE);
		    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
		    c.drawString(coordinate,355,370);
		    seatOutline(px,py,background);
		    seatOutline(x,y,outlineBlue);
		    precoordinate = coordinate;
		}
	    }
	    else if(wheelInput == 'w' || wheelInput == 'W'){
		y-=27;
		if(y<84){
		    c.setColor(background);
		    c.fillRect(355,350,75,50);
		    y+=27;
		    c.setColor(Color.WHITE);
		    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
		    c.drawString(precoordinate,355,370);
		    continue;
		}
		else{
		    c.setColor(background);
		    c.fillRect(355,350,75,50);
		    alpha-=1;
		    coordinate+=alpha;
		    coordinate+=number;
		    if(coordinate.equals("A6") || coordinate.equals("A9") || coordinate.equals("A12") || coordinate.equals("A15") || coordinate.equals("A18") || coordinate.equals("A21") || coordinate.equals("A24") || coordinate.equals("A27")){
			c.setColor(background);
			c.fillRect(635,350,90,70);
			c.setColor(Color.WHITE);
			c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
			c.drawString("$15 CAD",640,370);
		    }
		    else if(alpha<=68){
			c.setColor(background);
			c.fillRect(635,350,90,70);
			c.setColor(Color.WHITE);
			c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
			c.drawString("$25 CAD",640,370);
		    }
		    else if(alpha>68 && alpha <=77){
			c.setColor(background);
			c.fillRect(635,350,90,70);
			c.setColor(Color.WHITE);
			c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
			c.drawString("$15 CAD",640,370);
		    }
		    c.setColor(Color.WHITE);
		    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
		    c.drawString(coordinate,355,370);
		    seatOutline(px,py,background);
		    seatOutline(x,y,outlineBlue);
		    precoordinate = coordinate;
		}
	    }
	    else if(wheelInput == 's' || wheelInput == 'S'){
		y+=27;
		if(y>208){
		    c.setColor(background);
		    c.fillRect(355,350,75,50);
		    y-=27;
		    c.setColor(Color.WHITE);
		    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
		    c.drawString(precoordinate,355,370);
		    continue;
		}
		else{
		    c.setColor(background);
		    c.fillRect(355,350,75,50);
		    alpha+=1;
		    coordinate+=alpha;
		    coordinate+=number;
		    if(coordinate.equals("A6") || coordinate.equals("A9") || coordinate.equals("A12") || coordinate.equals("A15") || coordinate.equals("A18") || coordinate.equals("A21") || coordinate.equals("A24") || coordinate.equals("A27")){
			c.setColor(background);
			c.fillRect(635,350,90,70);
			c.setColor(Color.WHITE);
			c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
			c.drawString("$15 CAD",640,370);
		    }
		    else if(alpha>68 && alpha <=77){
			c.setColor(background);
			c.fillRect(635,350,90,70);
			c.setColor(Color.WHITE);
			c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
			c.drawString("$15 CAD",640,370);
		    }
		    c.setColor(Color.WHITE);
		    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
		    c.drawString(coordinate,355,370);
		    seatOutline(px,py,background);
		    seatOutline(x,y,outlineBlue);
		    precoordinate = coordinate;
		}
	    }
	    else if(wheelInput == 'B' || wheelInput == 'b'){
		back = wheelInput;
		break;
	    }
	    else if(wheelInput == '\n'){
		startTwoDigit = 0;
		endTwoDigit = 2;
		startThreeDigit = 0;
		endThreeDigit = 3;
		for(int j=0;j<reservedTwoDigit.length()/2;j++){
		    if(reservedTwoDigit.length()<=endTwoDigit){
			if(precoordinate.equals(reservedTwoDigit.substring(startTwoDigit,endTwoDigit))){
			    JOptionPane.showMessageDialog(null,"This seat has already been reserved, please choose another seat","Error",JOptionPane.ERROR_MESSAGE);
				reservedCheck = false;
				break;
			}
			startTwoDigit+=2;
			endTwoDigit+=2;
		    }
		    else{
			break;
		    }
		}
		for(int j=0;j<reservedThreeDigit.length()/3;j++){
		    if(reservedThreeDigit.length()<=endThreeDigit){
			if(precoordinate.equals(reservedThreeDigit.substring(startThreeDigit,endThreeDigit))){
			    JOptionPane.showMessageDialog(null,"This seat has already been reserved, please choose another seat","Error",JOptionPane.ERROR_MESSAGE);
			    reservedCheck = false;
			    break;
			}
			startThreeDigit+=3;
			endTwoDigit+=3;
		    }
		    else{
			break;
		    }
		}
		if(!precoordinate.equals("A6") && !precoordinate.equals("A9") && !precoordinate.equals("A12") && !precoordinate.equals("A15") && !precoordinate.equals("A18") && !precoordinate.equals("A21") && !precoordinate.equals("A24") && !precoordinate.equals("A27")){
		    JOptionPane.showMessageDialog(null,"The selected seat is a regular seat, to book a regular seat please go back to the previous screen and select '1' for regular ","Error",JOptionPane.ERROR_MESSAGE);
		    continue;
		}
		else if(reservedCheck == false){
		    continue;
		}
		else{
		    seatChoice = precoordinate;
		    break;
		}
	    }
	    else{
		c.setColor(Color.WHITE);
		c.drawString(precoordinate,310,370);
		continue;
	    }
	    
	}
	
	
    }
    /*
    
    deluxeSeatSelection()
    
    Variables Used:
	 - background --> colour of the background
    
    Actions:
	 - method asks user to move around with wasd to select a seat
	 
    Returns:
	 - N/A
    
    Local Variable List:
	Name                       Type         Description
	-------------------------|----------|----------------------------------- 
	x                        |  int     |  stores the x location of seat outline
	y                        |  int     |  stores the y location of seat outline
	px                       |  int     |  stores the previous position of the x location
	py                       |  int     |  stores the previous position of the y location
	number                   |  int     |  stores the numberic location of the seat selected which is outputted to the user
	lineNums                 |  int     |  stores the number of lines in a file
	numericLocation          |  int     |  stores the numberic location of the reserved seat
	startTwoDigit            |  int     |  starting point of substring for reservedTwoDigit
	endTwoDigit              |  int     |  ending point of substring for reservedTwoDigit
	startThreeDigit          |  int     |  starting point of substring for reservedThreeDigit
	endThreeDigit            |  int     |  ending point of substring for reservedThreeDigit
	delInput                 |  char    |  stores the deluxe seat selection input
	alphaLocation            |  char    |  stores the alphabetic location of the reserved seat
	alpha                    |  char    |  stores the alphabetic location of the seat selected which is outputted to the user
	coordinate               |  String  |  stores the coordinate of the selected seat
	precoordinate            |  String  |  stores the coordinate of the previous selected seat
	reservedTwoDigit         |  String  |  stores the reserved seat when the length is only two 
	reservedThreeDigit       |  String  |  stores the reserved seat when the length is three
	seatLocation             |  String  |  stores the seatLocation when checking for previous reservations
	checkFile                |  File    |  stores the file name
	
    */
    public void deluxeSeatSelection(){
    
	int px = 72;
	int py = 99;
	int number = 1;
	int lineNums = 0;
	int numericLocation;
	int startTwoDigit = 0;
	int endTwoDigit = 2;
	int startThreeDigit = 0;
	int endThreeDigit = 3;
	
	boolean reservedCheck = true;
	
	char delInput;
	char alpha = 65;
	char alphaLocation;
	
	String coordinate = "",precoordinate = "A1";
	String reservedTwoDigit = "";
	String reservedThreeDigit = "";
	String seatLocation = "";
    
	File checkFile = new File(theatreChoice + " " + movieChoice + " " + dateChoice.substring(0,2) + dateChoice.substring(3,5) + dateChoice.substring(6) + ".txt");
	
	c.clear();
	c.setColor(background);
	c.fillRect(0,0,900,660);
	c.setColor(Color.WHITE);
	c.fillRect(193,3,500,65);
	c.setColor(Color.BLACK);
	
	c.setColor(Color.ORANGE);
	c.fillRect(475,370,20,20);
	c.setColor(Color.RED);
	c.fillRect(300,370,20,20);
	c.setColor(Color.BLACK);
	
	c.setFont(new Font("Sans Serif",Font.BOLD,30));
	c.drawString("STAGE/SCREEN",325,44);
	
	c.setColor(Color.WHITE);
	c.setFont(new Font("Sans Serif",Font.PLAIN,15));
	c.drawString("Reserved",330,385);
	c.drawString("Deluxe",505,385);
	
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,15));
	c.drawString("To go back press B or b", 10,640);
	
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,18));
	c.drawString("Press enter to confirm and continue", 590,633);
	
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
	c.drawString("The selected seat is:  R1 ",160,480);
	c.drawString("The price is:  $30 CAD",520,480);
	
	seatOutline(72,269,outlineBlue);
	
	for(int x=73;x<823;x+=25){
	    for(int y=90;y<127;y+=27){
		seat(x,y,Color.GRAY);
	    }
	}
	c.setColor(Color.GRAY);
	c.fillRect(440,150,5,100);
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,18));
	c.drawString("15 rows",460,200);
	
	//deluxe seat
	for(int x=73;x<823;x+=25){
	    for(int y=270;y<326;y+=27){
		seat(x,y,Color.ORANGE);
	    }
	}
	if(checkFile.exists()){
	    try{
		BufferedReader lineInput = new BufferedReader(new FileReader(theatreChoice + " " + movieChoice + " " + dateChoice.substring(0,2) + dateChoice.substring(3,5) + dateChoice.substring(6) + ".txt"));
		String checkingLength = "";
		
		while(checkingLength!=null){
		    checkingLength = lineInput.readLine();
		    lineNums ++;
		}
	    }
	    catch (IOException e) {}
	    try{
		BufferedReader locationInput = new BufferedReader(new FileReader(theatreChoice + " " + movieChoice + " " + dateChoice.substring(0,2) + dateChoice.substring(3,5) + dateChoice.substring(6) + ".txt"));
		for(int i=0;i<lineNums/4;i++){
		    seatLocation = locationInput.readLine();
		    if(seatLocation.length()==2){
			alphaLocation = seatLocation.charAt(0);
			numericLocation = Integer.parseInt(seatLocation.substring(1));
			if(alphaLocation >=82){
			    seat(73+((numericLocation-1)*25),270+((alphaLocation-82)*27) ,Color.RED);
			    reservedTwoDigit += seatLocation;
			}
		    }
		    else{
			alphaLocation = seatLocation.charAt(0);
			numericLocation = Integer.parseInt(seatLocation.substring(1));
			if(alphaLocation >=82){
			    seat(73+((numericLocation-1)*25),270+((alphaLocation-82)*27) ,Color.RED);
			    reservedThreeDigit += seatLocation;
			}
		    }
		    locationInput.readLine();
		    locationInput.readLine();
		    locationInput.readLine();
		}
	    }
	    catch (IOException e) {}
	}
	
	int x=72,y=269;
	c.setColor(Color.WHITE);
	coordinate+=alpha;
	coordinate+=number;
	while(true){
	    back = '.';
	    px = x;
	    py = y;
	    delInput = c.getChar();
	    coordinate="";
	    if(delInput == 'a' || delInput == 'A'){
		x-=25;
		if(x<72){
		    c.setColor(background);
		    c.fillRect(355,460,75,50);
		    x+=25;
		    c.setColor(Color.WHITE);
		    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
		    c.drawString(precoordinate,355,480);
		    continue;
		}
		else{
		    c.setColor(background);
		    c.fillRect(355,460,75,50);
		    number-=1;
		    coordinate+=alpha;
		    coordinate+=number;
		    c.setColor(Color.WHITE);
		    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
		    c.drawString(coordinate,355,480);
		    seatOutline(px,py,background);
		    seatOutline(x,y,outlineBlue);
		    precoordinate = coordinate;
		}
		
	    }
	    else if(delInput == 'd' || delInput == 'D'){
		x+=25;
		if(x>811){
		    c.setColor(background);
		    c.fillRect(355,460,75,50);
		    x-=25;
		    c.setColor(Color.WHITE);
		    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
		    c.drawString(precoordinate,355,480);
		    continue;
		}
		else{
		    c.setColor(background);
		    c.fillRect(355,460,75,50);
		    number+=1;
		    coordinate+=alpha;
		    coordinate+=number;
		    c.setColor(Color.WHITE);
		    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
		    c.drawString(coordinate,355,480);
		    seatOutline(px,py,background);
		    seatOutline(x,y,outlineBlue);
		    precoordinate = coordinate;
		}
	    }
	    else if(delInput == 'w' || delInput == 'W'){
		y-=27;
		if(y<269){
		    c.setColor(background);
		    c.fillRect(355,460,75,50);
		    y+=27;
		    c.setColor(Color.WHITE);
		    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
		    c.drawString(precoordinate,355,480);
		    continue;
		}
		else{
		    c.setColor(background);
		    c.fillRect(355,460,75,50);
		    alpha-=1;
		    coordinate+=alpha;
		    coordinate+=number;
		    c.setColor(Color.WHITE);
		    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
		    c.drawString(coordinate,355,480);
		    seatOutline(px,py,background);
		    seatOutline(x,y,outlineBlue);
		    precoordinate = coordinate;
		}
	    }
	    else if(delInput == 's' || delInput == 'S'){
		y+=27;
		if(y>346){
		    c.setColor(background);
		    c.fillRect(355,460,75,50);
		    y-=27;
		    c.setColor(Color.WHITE);
		    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
		    c.drawString(precoordinate,355,480);
		    continue;
		}
		else{
		    c.setColor(background);
		    c.fillRect(355,460,75,50);
		    alpha+=1;
		    coordinate+=alpha;
		    coordinate+=number;
		    c.setColor(Color.WHITE);
		    c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,20));
		    c.drawString(coordinate,355,480);
		    seatOutline(px,py,background);
		    seatOutline(x,y,outlineBlue);
		    precoordinate = coordinate;
		}
	    }
	    else if(delInput == 'B' || delInput == 'b'){
		back = delInput;
		break;
	    }
	    else if(delInput == '\n'){
		startTwoDigit = 0;
		endTwoDigit = 2;
		startThreeDigit = 0;
		endThreeDigit = 3;
		for(int j=0;j<reservedTwoDigit.length()/2;j++){
		    if(reservedTwoDigit.length()<=endTwoDigit){
			if(precoordinate.equals(reservedTwoDigit.substring(startTwoDigit,endTwoDigit))){
			    JOptionPane.showMessageDialog(null,"This seat has already been reserved, please choose another seat","Error",JOptionPane.ERROR_MESSAGE);
				reservedCheck = false;
				break;
			}
			startTwoDigit+=2;
			endTwoDigit+=2;
		    }
		    else{
			break;
		    }
		}
		for(int j=0;j<reservedThreeDigit.length()/3;j++){
		    if(reservedThreeDigit.length()<=endThreeDigit){
			if(precoordinate.equals(reservedThreeDigit.substring(startThreeDigit,endThreeDigit))){
			    JOptionPane.showMessageDialog(null,"This seat has already been reserved, please choose another seat","Error",JOptionPane.ERROR_MESSAGE);
			    reservedCheck = false;
			    break;
			}
			startThreeDigit+=3;
			endTwoDigit+=3;
		    }
		    else{
			break;
		    }
		}
		if(reservedCheck == false){
		    continue;
		}
		else{
		    seatChoice = precoordinate;
		    break;
		}
	    }
	    else{
		c.setColor(Color.WHITE);
		c.drawString(precoordinate,355,480);
		continue;
	    }
	    
	}
    }
    
    
    /*
    
    payment()
    
    Variables Used:
	 - background --> colour of the background
	 - seatChoice --> holds the seat location the user wants to reserve
    
    Actions:
	 - method asks user for credit card information to 'pay' for the seat ticket
	 
    Returns:
	 - N/A
    
    Local Variable List:
	Name                       Type         Description
	-------------------------|----------|----------------------------------- 
	alphaChar                |  char    |  stores the alpha character of seat choice
	lastNameInput            |  char    |  stores the input for the last name
	firstNameInput           |  char    |  stores the input for the first name
	ccnInput                 |  char    |  stores the input for the first ccn
	cvvInput                 |  char    |  stores the input for the cvv
	firstName                |  String  |  stores the first name using firstNameInput
	lastName                 |  String  |  stores the last name using lastNameInput
	ccn                      |  String  |  stores the ccn using ccnInput
	cvv                      |  String  |  stores the cvv using cvvInput
	
    */

    public void payment(){
	char alphaChar = seatChoice.charAt(0);
	char lastNameInput;
	char firstNameInput;
	char ccnInput;
	char cvvInput;
	
	String firstName = "";
	String lastName = "";
	String ccn = "";
	String cvv = "";
	
	c.clear();
	c.setColor(background);
	c.fillRect(0,0,900,660);
	c.setFont(new Font("Sans Serif",Font.BOLD,75));
	c.setColor(Color.WHITE);
	c.drawString("Payment", 278,80);
	c.setFont(new Font("Sans Serif",Font.PLAIN,26));
	c.drawString(seatChoice,212,140);
	c.drawString(dateChoice,570,140);
	
	//displaying price depending on seat location
	if(seatChoice.equals("A6") || seatChoice.equals("A9") || seatChoice.equals("A12") || seatChoice.equals("A15") || seatChoice.equals("A18") || seatChoice.equals("A21") || seatChoice.equals("A24") || seatChoice.equals("A27")){
	    c.drawString("WHEELCHAIR",212,200);
	    c.drawString("$15 CAD", 180,260);
	}
	
	else if(alphaChar<=68){
	    c.drawString("REGULAR",212,200);
	    c.drawString("$25 CAD",180,260);
	}
	else if(alphaChar>68 && alphaChar<=77){
	    c.drawString("REGULAR",212,200);
	    c.drawString("$15 CAD",180,260);
	}
	else if(alphaChar>77 && alphaChar<=81){
	    c.drawString("REGULAR",212,200);
	    c.drawString("$10 CAD",180,260);
	}
	else if(alphaChar>81){
	    c.drawString("DELUXE",212,200);
	    c.drawString("$30 CAD",180,260);
	}
	
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,26));
	
	
	c.drawString("Booked Seat: ",50,140);
	c.drawString("Date: ",500,140);
	c.drawString("Type of Seat: ",50,200);
	c.drawString("Total Cost: ",50,260);
	c.drawString("First Name: ",50,373);
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,18));
	c.drawString("Press enter to confirm and continue", 590,633);
	c.fillRect(200,345,400,40);        
	c.setFont(new Font("Sans Serif",Font.PLAIN,30));
	c.drawString("Needed Information",50,327);
	
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,26));
	//input for first name
	while(true){
	    firstNameInput = c.getChar();
	    if(firstNameInput == '\n'){
		if(firstName.length()==0){
		    continue;
		}
		else{
		    break;
		}
	    }
	    
	    if(firstName.length()==07 && firstNameInput == 8){
		continue;
	    }
	    
	    
	    else if(firstNameInput == 8 && firstName.length()>=1){
		firstName = firstName.substring(0,firstName.length()-1);
		c.setColor(Color.WHITE);
		c.fillRect(200,345,400,40);
		c.setColor(Color.BLACK);
		c.drawString(firstName,210,375);
	    }
	    else if(firstName.length()>=18){
		continue;
	    }
	    else{
		if(firstNameInput == 32){
		    firstName += "_";
		    c.setColor(Color.WHITE);
		    c.fillRect(200,345,400,40);
		    c.setColor(Color.BLACK);
		    c.drawString(firstName,210,375);
		}
		else{
		    firstName += firstNameInput;
		    c.setColor(Color.WHITE);
		    c.fillRect(200,345,400,40);
		    c.setColor(Color.BLACK);
		    c.drawString(firstName,210,375);
		}
	    }

	}
	
	c.setColor(Color.WHITE);
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,26));
	c.drawString("Last Name: ",50,452);
	c.fillRect(200,422,400,40);
	
	//input for last name
	while(true){
	    lastNameInput = c.getChar();
	    if(lastNameInput == '\n'){
		if(lastName.length()==0){
		    continue;
		}
		else{
		    break;
		}
	    }
	    
	    if(lastName.length()==0 && lastNameInput == 8){
		continue;
	    }
	    
	    
	    else if(lastNameInput == 8 && lastName.length()>=1){
		lastName = lastName.substring(0,lastName.length()-1);
		c.setColor(Color.WHITE);
		c.fillRect(200,422,400,40);
		c.setColor(Color.BLACK);
		c.drawString(lastName,210,453);
	    }
	    else if(lastName.length()>=18){
		continue;
	    }
	    else{
		if(lastNameInput == 32){
		    lastName += "_";
		    c.setColor(Color.WHITE);
		    c.fillRect(200,422,400,40);
		    c.setColor(Color.BLACK);
		    c.drawString(lastName,210,453);
		}
		else{
		    lastName += lastNameInput;
		    c.setColor(Color.WHITE);
		    c.fillRect(200,422,400,40);
		    c.setColor(Color.BLACK);
		    c.drawString(lastName,210,453);
		}
	    }

	}
	
	c.setColor(Color.WHITE);
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,26));
	c.drawString("Credit Card Number:",50,530);
	c.fillRect(305,501,460,40);
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,26));
	
	//credit card number input
	while(true){
	    ccnInput = c.getChar();
	    if(ccnInput == '\n'){
		if(ccn.length()==0){
		    continue;
		}
		else{
		    //ccn can only be 16 digits long
		    try{
			Long.parseLong(ccn);
			if(ccn.length()!=16){
			    throw new Exception ();
			}
			else{
			    break;
			}
			
		    }
		    catch(Exception e){
			JOptionPane.showMessageDialog(null,"Your credit card number must be consist of 16 integers (numbers)","Error",JOptionPane.ERROR_MESSAGE);
			continue;
		    }
		    
		}
	    }
	    
	    if(ccn.length()==0 && ccnInput == 8){
		continue;
	    }
	    
	    
	    else if(ccnInput == 8 && ccn.length()>=1){
		ccn = ccn.substring(0,ccn.length()-1);
		c.setColor(Color.WHITE);
		c.fillRect(305,501,460,40);
		c.setColor(Color.BLACK);
		c.drawString(ccn,315,530);
	    }
	    else if(ccn.length()>=16){
		continue;
	    }
	    else{
		if(ccnInput == 32){
		    ccn += "_";
		    c.setColor(Color.WHITE);
		    c.fillRect(305,501,460,40);
		    c.setColor(Color.BLACK);
		    c.drawString(ccn,315,530);
		}
		else{
		    ccn += ccnInput;
		    c.setColor(Color.WHITE);
		    c.fillRect(305,501,460,40);
		    c.setColor(Color.BLACK);
		    c.drawString(ccn,315,530);
		}
	    }

	}
	c.setColor(Color.WHITE);
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,26));
	c.drawString("C V V :",50,600);
	
	c.fillRect(150,571,65,40);
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,18));
	c.drawString("(3 digit security number on back of credit card)",50,636);
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,26));
	
	//cvv number input
	while(true){
	    cvvInput = c.getChar();
	    if(cvvInput == '\n'){
		if(cvv.length()==0){
		    continue;
		}
		else{
		    try{
			Integer.parseInt(cvv);
			if(cvv.length()!=3){
			    throw new Exception ();
			}
			else{
			    break;
			}
		    }
		    catch(Exception e){
			JOptionPane.showMessageDialog(null,"The CVV is a 3 digit number","Error",JOptionPane.ERROR_MESSAGE);
			continue;
		    }
		}
	    }
	    
	    if(cvv.length()==0 && cvvInput == 8){
		continue;
	    }
	    
	    
	    else if(cvvInput == 8 && cvv.length()>=1){
		cvv = cvv.substring(0,cvv.length()-1);
		c.setColor(Color.WHITE);
		c.fillRect(150,571,65,40);
		c.setColor(Color.BLACK);
		c.drawString(cvv,160,601);
	    }
	    else if(cvv.length()>=3){
		continue;
	    }
	    else{
		if(cvvInput == 32){
		    cvv += "_";
		    c.setColor(Color.WHITE);
		    c.fillRect(150,571,65,40);
		    c.setColor(Color.BLACK);
		    c.drawString(cvv,160,601);
		}
		else{
		    cvv += cvvInput;
		    c.setColor(Color.WHITE);
		    c.fillRect(150,571,65,40);
		    c.setColor(Color.BLACK);
		    c.drawString(cvv,160,601);
		}
	    }

	}
	
	//storing last name of user, seat location, ccn, and cvv
	PrintWriter output;
	String fileName = theatreChoice + " " + movieChoice + " " + dateChoice.substring(0,2) + dateChoice.substring(3,5) + dateChoice.substring(6) + ".txt";
	try{
	    output=new PrintWriter(new FileWriter(fileName,true)); 
	    output.println(seatChoice); 
	    output.print("Last Name: ");
	    output.println(lastName);  
	    output.print("CCN: ");
	    output.println(ccn);
	    output.print("CVV: ");
	    output.println(cvv);
	    output.close(); 
	}
	catch(IOException e) {} 
	
	//increasing the number of seats purchased
	String seatPurchasedInput = "";
	try{
	    BufferedReader input = new BufferedReader(new FileReader("totalNumberOfSeatsPurchased.txt"));
	    seatPurchasedInput = input.readLine();
	    numberOfSeatsPurchased  = Integer.parseInt(seatPurchasedInput);
	    numberOfSeatsPurchased ++;
	}
	catch (IOException e){}

	try{
	    PrintWriter outputSeatsPurchased = new PrintWriter(new FileWriter("totalNumberOfSeatsPurchased.txt"));
	    outputSeatsPurchased.println(numberOfSeatsPurchased);
	    outputSeatsPurchased.close();
	}
	catch(IOException e){}
	
    }
    /*
    
    thankYou()
    
    Variables Used:
	 - background --> colour of the background
	 - thankDecision --> holds the decision the user inputs (A or a to book another seat, E or e to exit)
    
    Actions:
	 - method displays a thank you message
    Returns:
	 - N/A
    
    Local Variable List:
	 - N/A
	
    */
    public void thankYou(){
	c.clear();
	c.setColor(background);
	c.fillRect(0,0,900,660);
	c.setFont(new Font("Sans Serif",Font.BOLD,75));
	c.setColor(Color.WHITE);
	c.drawString("Thank YOU", 237,125);
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,30));
	c.drawString("Thank you for booking your ticket with Cineplexe.",130,230);
	c.drawString("We hope you have a great day and enjoy the show.",118,265);
	
	c.setFont(new Font("Sans Serif",Font.PLAIN,20));
	c.drawString("To exit press E or e",100,500);
	c.drawString("To book another ticket press A or a",500,500);
	
	//asking input
	while(true){
	    //code only continues if valid input is pressed
	    thankDecision = c.getChar();
	    if(thankDecision == 'A' || thankDecision == 'a'){
		break;
	    }
	    else if(thankDecision == 'E' || thankDecision == 'e'){
		break;
	    }
	}
    }
  
    
    /*
    
    goodBye()
    
    Variables Used:
	 - background --> colour of the background
	 - thankDecision --> holds the decision the user inputs (A or a to book another seat, E or e to exit)
    
    Actions:
	 - method displays a good bye messages and exits program
    Returns:
	 - N/A
    
    Local Variable List:
	 - N/A
	
    */
    public void goodBye(){
	title();
	c.setFont(new Font("Sans Serif",Font.PLAIN,30));
	c.drawString("Thank you for using Cineplexe.com", 210,160);
	
	c.setFont(new Font("Sans Serif",Font.LAYOUT_LEFT_TO_RIGHT,40));
	c.drawString("Showtimes are Monday - Thursday at 12 PM",56,280);
	 
	c.setFont(new Font("Sans Serif",Font.PLAIN,18));
	c.drawString("Powered by Java", 370,400);
	
	c.setFont(new Font("Sans Serif",Font.PLAIN,24));
	c.drawString("Press any key to continue",302,500);
	
	c.setFont(new Font("Sans Serif",Font.PLAIN,16));
	c.drawString("Created by: Ronald",720,630);
	
	c.getChar();
	System.exit(0);//exits program
    }
    //Calls all the methods and controls the order of flow
    public static void main(String[]args){
    Theatre d = new Theatre();
	
	d.splashScreen();
	while(true){
	    d.mainMenu();
	    if(d.menuDecision == '1'){
		d.movieTheatreSelection();
		while(true){
		    d.seatTypeSelection();
		    if(d.seatTypeDecision == '1'){
			d.regularSeatSelection();
			if(d.back == 'B' || d.back == 'b'){
			    continue;
			}
			else{
			    break;
			}
		    }
		    else if(d.seatTypeDecision == '2'){
			d.wheelchairSeatSelection();
			if(d.back == 'B' || d.back == 'b'){
			    continue;
			}
			else{
			    break;
			}
		    }
		    else if(d.seatTypeDecision == '3'){
			d.deluxeSeatSelection();
			if(d.back == 'B' || d.back == 'b'){
			    continue;
			}
			else{
			    break;
			}
		    }
		}
		d.payment();
		d.thankYou();
		if(d.thankDecision == 'A' || d.thankDecision == 'a'){
		    continue;
		}
		else if(d.thankDecision == 'E' || d.thankDecision == 'e'){
		    break;
		}
	    }
	    else if(d.menuDecision == '2'){
		d.instructions();
		continue;
	    }
	    else if(d.menuDecision == '3'){
		break;
	    }
       }
       d.goodBye();
       
       //d.instructions();
    }
}



