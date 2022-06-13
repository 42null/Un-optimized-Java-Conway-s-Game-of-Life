import java.util.Scanner;
class DisplayModifications{
    static int worldMapLength = GV.worldMapLength;
    static int worldMapHeight = GV.worldMapHeight;

    // public char[][] worldMap = WorldGenerator.worldMapDefault;
    public char[][] layer1 = new char[worldMapHeight+2][worldMapLength+2];//+2 for border

// Colors Credit https://repl.it/@Dipspiggy/Colorsjava
    public static String[][] charToColor = {
        // \u001B[0m RESET
        {"X","\u001B[31mX\u001B[0m"}//RED
        ,{"░","\u001B[35m░\u001B[0m"}//PURPLE
        ,{"▒","\u001B[34m▒\u001B[0m"}//BLUE
        ,{"▓","\u001B[36m▓\u001B[0m"}//
        ,{"█","\u001B[32m█\u001B[0m"}
        // ,{"",""}
        // ,{"",""}
        };

    // LOOKUPTABLE

    public static String[][] addColor(char inputMap_[][], String charToColor_[][]) {
        String[][] stringyMap_ = toAStringArray(inputMap_);
        for(int i=0; i < inputMap_.length; i++){
            for(int j=0; j < inputMap_[0].length; j++){
                for(int h=0; h < charToColor_.length; h++){
                    if(inputMap_[i][j] == (charToColor_[h][0]).charAt(0)){//Change back to before i like orignal?
                        stringyMap_[i][j] = charToColor[h][1];//Change so it only goes on collored?
                    }
                }
            }
        }
        return stringyMap_;
    }

    public static char[][] typeABlinkerCheck(char inputMap_[][]){//This code is very unefficent
        char[][] returnMap = inputMap_;
        for(int i=2; i < inputMap_.length; i++){
            for(int j=1; j < inputMap_[0].length; j++){
                if(inputMap_[i][j] == '▓'){
                    // Diangnal test
                    if(inputMap_[i-2][j]=='▓'&&inputMap_[i-1][j]=='▓'&&inputMap_[i+1][j]!='▓'&&inputMap_[i+2][j]!='▓'){inputMap_[i][j]='X';}
                }
            }
        }
        return returnMap;
    }


    public static String[][] toAStringArray(char charArray_[][]){
        String[][] stringyMap_ = new String[charArray_.length][charArray_[0].length];//+2 for border

        for(int i=0; i < charArray_.length; i++){
            for(int j=0; j < charArray_[0].length; j++){
                stringyMap_[i][j] = (charArray_[i][j]+"");
            }
        }
        return stringyMap_;
    }

    public static char[][] changeBorder(char worldMap_[][], char replacement_){
        for(int i = 0; i < worldMap_[0].length; i++){
            worldMap_[0][i] = replacement_;}
        for(int i = 0; i < worldMap_[0].length; i++){
            worldMap_[worldMap_.length-1][i] = replacement_;}
        for(int i = 1; i < worldMap_.length; i++){
            worldMap_[i][0] = replacement_;}
        for(int i = 1; i < worldMap_.length; i++){
            worldMap_[i][worldMap_[0].length-1] = replacement_;}
        return worldMap_;
    }

    public static boolean[][] changeBorder(boolean worldMap_[][], boolean replacement_){
        for(int i = 0; i < worldMap_[0].length; i++){
            worldMap_[0][i] = replacement_;}
        for(int i = 0; i < worldMap_[0].length; i++){
            worldMap_[worldMap_.length-1][i] = replacement_;}
        for(int i = 1; i < worldMap_.length; i++){
            worldMap_[i][0] = replacement_;}
        for(int i = 1; i < worldMap_.length; i++){
            worldMap_[i][worldMap_[0].length-1] = replacement_;}
        return worldMap_;
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
}