package zodiac;

/**
 * @author Zackery Lavalais
 * This program will calculate your zodiac sign and then tell you a bunch of things about it.
 */
import java.io.BufferedReader;  
import java.io.InputStreamReader;  
import java.io.IOException;  
import java.util.*;  
import java.text.DateFormat; 

public class Zodiac 
{

    int day = 0;
    int month = 0;
    int year = 0;
    int startDate;
    Calendar cal = Calendar.getInstance(); 
    Scanner scan = new Scanner(System.in);
    
    private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    public void getBirthday(int month, int day, int year)
    {
        System.out.println(df.format(cal.getTime()));
        while(true)
        {
            System.out.print("Enter the year of your birth: \n"); 
            //Gets the year.
            year = scan.nextInt();
            int age = 2018 - year;
            int y = year;
            while(true)
            {
                System.out.print("Enter the month of your birth (Keep in mind that it must be between January(1) and December(12): \n"); 
                month = scan.nextInt();
                if(validMonth(--month))
                {
                    //Checks the validity of the month.
                    break;
                }
            }
              while (true)
              {
                  System.out.print("Enter the day of your birth: \n");
                  day = scan.nextInt();
                  if(validDay(day,month,year)) 
                  {
                    //Checks the validity of the date.
                    break;
                  }
              }
              cal.set(Calendar.YEAR, year);
              cal.set(Calendar.MONTH, month);
              cal.set(Calendar.DATE, day);
              //Sets the calendar for the dates entered above
             
            for(int i = 0 ; i < startDates.length ; ++i)  
            {
                startDates[i].set(GregorianCalendar.YEAR, year); 
            }
            
            for (int i = 0; i < startDates.length; i++) 
            {
                if(cal.after(startDates[i]) && cal.before(startDates[(i+1) % startDates.length]))
                {
                    System.out.println("\n");
                    System.out.println(df.format(cal.getTime()) + " is in the sign of " + signs[i] + ".\n");
                    // Prints the vanilla sign.
                    System.out.println("Your sign in the Chinese zodiac is that of the " + chineseZodiac[y%12] + ".\n");
                    // Prints the sign in the Chinese zodiac.
                    System.out.println(signs[i] + " has the birthstone(s) : " + Birthstones[i+1] + ".\n");
                    // Prints the birthstone of the preceding sign.
                    System.out.println(signs[i] + " has the symbol of " + Symbols[i] + ".\n");
                    // Prints the symbol of the preceding sign.
                    // (i.e. Lion, Crab, Scorpion)
                    System.out.println(signs[i] + " has the best color of " + Color[i] + ".\n");
                    // Prints the "best" color of the sign.
                    System.out.println(signs[i] + " is ruled by " + Sign_Ruler[i] + ".\n");
                    // Prints the ruler of the sign.
                    // (i.e. Venus, Sun, Moon, Mercury)
                    System.out.println("The strengths of your sign include : " + Sign_Strengths[i] + ".\n");
                    // Prints the strengths of the sign.
                    System.out.println("The weaknesses of your sign include : " + Sign_Weaknesses[i] + ".\n");
                    // Prints the weakness of the sign.
                    System.out.println("You share zodiac signs with the following people : " + Celebrities[i] + ".\n");
                    // Prints various well-known people with the same sign as the birthday input.
                    System.out.println("You are "+age+" years old!\n");
                    if(age <= 20)
                    {
                        System.out.println("Welcome to adulthood. Bills and responsibility await!\n");
                    }
                    else if(age <= 30 && age > 20)
                    {
                        System.out.println("All your adolescent life has lead up to this!\n");
                    }
                    else if(age <= 40 && age > 30)
                    {
                        System.out.println("Just take life a day at a time!\n");
                    }
                    break;
                }
            }
            System.out.println("Would you like to try another date(Enter Yes or No)?\n");
            // Asks the user to enter a new date.
            if(!yes())
            {
                break;
            }
        }
    }
    
    private static boolean validMonth(int month) {  
    if(month >= 0 && month <= 11)  
    {
      return true;  
    }
    else  
    {
      System.out.println("The month value must be from 1 to 12. Try again.");  
    }
    return false;  
    }
    
    private static boolean validDay(int day, int month, int year)
    {
        // Checks to see if the date that the user entered is, in fact, valid.
        if(day > 30 && (month == 3 || month == 5|| month == 8|| month == 10))
        {
            System.out.println("The day must be less than 31 when the month is "+Month_Names[month]+". Please enter another value.");
            return false;
        }
        /*
            For the date to be valid it must meet the following criteria:
            1. Between 1 and 31. 
            2. Less than 31 when the month only has 30 days. (April, June, September, November)
            3. Less than 29 when the month is February and NOT a leap year.
            4. Less than 30 when the month is February and IS a leap year.
        */
        
           if(day > 28 && month == 1 && !calendar.isLeapYear(year)) 
           {  
            System.out.println(year + " isn't a leap year. The day must be less than 29. Please enter another value.");  
            return false;  
    }  
           return true;
    }
    
    private final static String[] signs = 
    {
        "Aquarius", 
        "Pisces", 
        "Aries", 
        "Taurus", 
        "Gemini", 
        "Cancer", 
        "Leo", 
        "Virgo", 
        "Libra",
        "Scorpio", 
        "Saggitarius",
        "Capricorn"
    };
            // A string of the zodiac signs.
    
    private boolean yes()
    {
        String string = null; 
        while(true)
        {
            try
            {
                string = in.readLine().trim();
            }
            catch(IOException e)
            {
                System.out.println("Your input is invalid. Please try again." + e.getMessage());
            }
            
            if(string.equals("Yes"))
            {
                return true;
            }
            else if(string.equals("No"))
            {
                break;
            }
            else 
            {
                System.out.print("Your input is invalid. Please enter ");
                System.out.print("\"Yes\"");
                System.out.print(" or ");
                System.out.print("\"No\"");
            }
        }
        return false;
    }
    
    private final static GregorianCalendar[] startDates = 
    {  
           new GregorianCalendar(2018,  0, 20),    
           // Aquarius start date  
           new GregorianCalendar(2018,  1, 19),    
           // Pisces start date  
           new GregorianCalendar(2018,  2, 21),   
           // Aries start date  
           new GregorianCalendar(2018,  3, 20),    
           // Taurus start date  
           new GregorianCalendar(2018,  4, 21),    
           // Gemini start date  
           new GregorianCalendar(2018,  5, 21),    
           // Cancer start date  
           new GregorianCalendar(2018,  6, 23),   
           // Leo start date  
           new GregorianCalendar(2018,  7, 23),    
           // Virgo start date  
           new GregorianCalendar(2018,  8, 23),    
           // Libra start date  
           new GregorianCalendar(2018,  9, 23),   
           // Scorpio start date  
           new GregorianCalendar(2018, 10, 22),    
           // Sagittarius start date  
           new GregorianCalendar(2018, 11, 22),    
           // Capricorn start date  
    };  
    //Names for the Zodiac signs and the start dates for each.
    
  private final static GregorianCalendar calendar = new GregorianCalendar();  
    
  private final static DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);  
  
  private static final String[] Month_Names = 
    {
      "January", "February", 
      "March", "April",
      "May"   , "June",    
      "July",    "August",
      "September",  "October",  
      "November",  "December"
    };
  // A string of the months.
  
  private static final String[] Birthstones = 
    {
    "Garnet",  "Amethyst",  
      "Aquamarine,   Bloodstone",
    "Diamond", "Emerald",   
    "Pearl,   Moonstone,   Alexandrite",
    "Ruby",  "Peridot",    
    "Sapphire", "Opal,   Tourmaline",  
    "Topaz,     Citrine",
    "Tanzanite,  Turquoise,  Tanzanite"
    };
  // Based on the 2013 United States version of the list of birthstones.
  // Also, some months have more than one birthstone. I've added them all to the list.
    
  private static final String[] Symbols = 
  {
      "Water Carrier", "Fish", 
      "Ram", "Bull",
      "Twins", "Crab", 
      "Lion", "Virgin Maiden",
      "Scales", "Scorpion", 
      "Archer", "Goat"
  };
  // The corresponding symbols behind the zodiac signs. 
  // (e.g. Cancer is a crab, Scorpio is a scorpion)
  
  private static final String[] Color = 
  {
      "Bronze", "White", 
      "Red", "Pink", 
      "Yellow", "Green", 
      "Red,  Gold,  Yellow",
      "Grey", "Brown", "Purple, "
       + " Black", "Light Blue",
      "Brown,  Black,  Dark Green"
  };
  // The best colors for each of the signs.
  
  private static final String[] Sign_Ruler = 
  {
      "Uranus", 
      "Neptune", 
      "Mars", 
      "Venus",
      "Mercury", 
      "Moon", 
      "Sun", 
      "Mercury",
      "Venus", 
      "Pluto,  Mars", 
      "Jupiter", 
      "Saturn"
  };
  // The rulers of the zodiac as believed by the Romans.
  // Some of the signs have the same rulers. Again, I've compensated for this.
  
  private static final String[] Sign_Strengths =
  {
      "original, tolerant, ideal, calm, friendly, "
          + "charitable, independent, smart, practical",
      "conscious, aesthetic, platonic, dedicated, "
          + "kind, with good temper",
      "hopeful, active, energetic, honest, "
          + "versatile, brave, adventurous, passionate, "
          + "generous, cheerful, argumentative, curious",
      "romantic, decisive, logical, diligent, "
          + "ardent, patient, talented in art, "
          + "perseverant, benevolent",
      "multifarious, perspicacious, smart, cheerful, "
          + "quick-witted, clement, charming",
          "strong sixth sense, subjective, gentle, "
          + "swift, imaginative, careful, dedicated, "
          + "perseverant, kind, caring",
      "proud, charitable, reflective, loyal and enthusiastic",
      "helping, elegant, perfectionist, modest, "
          + "practical, clearheaded",
      "idealistic, equitable, just, strong social skills, "
          + "aesthetic, charming, artistic, beautiful, "
          + "kind-hearted",
      "mysterious, rational, intelligent, independent, "
          + "intuitive, dedicated, insightful, charming, sensible",
      "insightful, superior, rational, brave, "
          + "beautiful, lively, lovely, optimistic",
      "excellent, intelligent, practical, reliable, "
          + "perseverant, generous, optimistic, cute, persistent"
  };
  // The "best qualities" of the signs as believed by most astrologists. 
  // The sign of Aquarius is supposedly original, tolerant, ideal, calm, etc.
  
  private static final String[] Sign_Weaknesses = 
  {
      "changeful, disobedient, liberalistic, hasty, rebel",
      "recessive, sentimental, indecisive, unrealistic",
      "impulsive, naive, self-willed, belligerent, impatient",
      "prejudiced, dependent, stubborn",
      "fickle, gossipy, amphibian",
      "greedy, possessive, sensitive, prim",
      "arrogant, vainglorious, indulgent, wasteful, willful,"
          + " and self-complacent",
      "picky, nosey, tortuous, confining",
      "hesitant, narcissistic, lazy, perfunctory, freewheeling",
      "suspicious, fanatical, complicated, possessive, arrogant, "
          + "self-willed, extreme",
      "forgetful, careless, rash",
      "stubborn, lonely, and suspicious"
  };
  // The "worst qualities" of the signs as believed by most astrologists. 
  // The sign of Aquarius is supposedly changeful, disobedient, liberalistic, etc.
  
  public static final String[] Celebrities =
  {
    "Abraham Lincoln, Francis Bacon, Thomas Edison,"
          + " Agyness Deyn, Paris Hilton",
    "George Washington, Zhou Enlai, "
          + "Albert Einstein, Justin Bieber",
    "Hans Christian Andersen, Jackie Chan, Mariah Carey,"
          + " Marlon Brando, Dennis Quaid",
    "Karl Marx, William Shakespeare, Leonardo da Vinci,"
          + " David Beckham, Al Pacino",
    "John F. Kennedy, Queen Victoria",
    "Alexander the Great, Julius Caesar, David Rockefeller, "
          + "Raul Gonzalez, Pablo Picasso",
    "Napoleon Bonaparte, Deng Xiaoping, Alexander Dumas, "
          + "Jennifer Lopez, Whitney Houston, Sarah Brightman",
    "Warren Buffett, Kobe Bryant, Michael Jackson, "
          + "Rebecca De Mornay, Richard Gere",
    "Oscar Wilde, Hillary Duff, Italo Calvino, "
          + "Elena Dement Eva, Evander Hoilrield",
    "Bill Gates, Marie Curie, Hillary Clinton, Julia Roberts",
    "Charles de Gaulle, Mark Twain, Beethoven, "
          + "Taylor Swift, Britney Spears",
    "Mao Zedong, Stalin, Issac Newton, "
          + "Martin Luther King, Nicholas Cage"
  };
  // These are various celebrities that share the various signs.
  // Julius Caesar and Alexander the Great are both cancers.
  
  public static final String[] chineseZodiac =
  {
      "Monkey",
      "Rooster",
      "Dog",
      "Pig",
      "Rat",
      "Ox",
      "Tiger",
      "Rabbit",
      "Dragon",
      "Snake",
      "Horse",
      "Sheep"	    
  };
  // These are the objects of the Chinese Zodiac
  
    public static void main(String[] args) 
    {
           Zodiac z = new Zodiac();
           z.getBirthday(7,16,1995);
    }
    
}
// This is one part of my project, but it's done. I'm making it a two-parter because this one is not nearly long enough, but it works. The other part will be some kind of text based adventure game.