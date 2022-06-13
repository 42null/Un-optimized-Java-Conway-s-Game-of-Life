import java.util.Scanner;
public class GV {
// https://en.wikipedia.org/wiki/Block_Elements
    // SETTINGS

    // DIMENTIONS (Not including border)
    // public static int worldMapLength = 100; //Default Value
    // public static int worldMapHeight = 65; //Default Value

    public static int worldMapLength = 75;//50; //Default Value
    public static int worldMapHeight = 35;//25; //Default Value

    // ░▒▓
    public static char worldBackground = '░';//'■';
    // public static char layer1Char = '▒';//'☐';
    public static char layer1Char = '▓';//'☐';
    public static char changeMapIndicator = 'c';
    public static char conwayDeathIndicator = 'd';
    public static char conwayBirthIndicator = 'b';

    // public static int worldSeedVar_ = 3;//7699114;
    // public static int worldSeedVar_ = 1846330;
    // public static int worldSeedVar_ = 6068254;
    // public static int worldSeedVar_ = 999999999;
    // public static int worldSeedVar_ = 111111111;
    // public static int worldSeedVar_ = 3987487;
    // public static int worldSeedVar_ = 2;
    // public static int worldSeedVar_ = 7267362;
    // public static int worldSeedVar_ = 1046;//This created viterical lines
    // 200 gives compleatly false's while 201 is a pretty good stretch with slight,y more false on the right side
    public static int worldSeedVar_ = 87838;//Filled
    // public static int worldSeedVar_ = 87838;
    // public static int worldSeedVar_ = 87838;

    public static int worldSeed = Integer.parseInt(f(worldSeedVar_).substring(0,9));//Only takes the first 8 posistions
    public static int worldSeedPartA = Integer.parseInt((f(worldSeedVar_)).substring(0,5));





    public static String GetUserInput(String askLine_){
        Scanner myObj = new Scanner(System.in);//Create a Scanner object
        System.out.print(askLine_);
        String userInput_ = myObj.nextLine();  // Read user input
        System.out.println("");                // Seperator
        return userInput_;
    }

// Methods
    public static String f(int number_){
      return String.format("%09d",number_);
    }

    public static void tSleep(double seconds_){
        try{Thread.sleep(Double.valueOf(seconds_*1000).longValue());}
        catch(InterruptedException ex){
        Thread.currentThread().interrupt();}
    }

    public static void tSleepMil(double miliseconds_){
        try{Thread.sleep(Double.valueOf(miliseconds_).longValue());}
        catch(InterruptedException ex){
        Thread.currentThread().interrupt();}
    }
    
    // public static void getMilisecs(){
    public static double getSecs(){
        return System.currentTimeMillis();///1000;
    }

    public static String releventTimeFormatMilT(double mils_){
        String returnString_ = "Error (nothing changed)";
        if(mils_ < 1000){
            returnString_ = mils_+" milis";
        }else if(mils_ < 60000){
            returnString_ = (mils_/1000)+" sec";
        }else if(mils_ < 3600000){
            returnString_ = (mils_/60000)+" min";
        }else if(mils_ < 86400000){
            returnString_ = (mils_/3600000)+" hours";
        }else{returnString_ = (mils_/86400000)+" days";}
        return returnString_;
    }
}