import java.util.Scanner;
import java.util.Arrays;
// import java.util.*; 
import java.util.ArrayList;

class WorldGenerator{
    static int worldMapLength = GV.worldMapLength;
    static int worldMapHeight = GV.worldMapHeight;

    // public char[][] worldMap = new char[worldMapHeight+2][worldMapLength+2];//+2 for border
    public char[][] worldMapDefault = generateLayer((new char[worldMapHeight+2][worldMapLength+2]),GV.layer1Char);//+2 for border

    // public char[][] worldMap = worldMapDefault;
    public boolean[][] worldMap = new boolean[worldMapHeight+2][worldMapLength+2];
    public char[][] worldMap_OLD = new char[worldMapHeight+2][worldMapLength+2];
    public char[][] conwayMap = new char[worldMapHeight+2][worldMapLength+2];//+2 for border
    public char[][] layer1b = generateLayer((new char[worldMapHeight+2][worldMapLength+2]),'-');//+2 for border

    public WorldGenerator() {
        System.out.println("[D]: WorldGenerator started...");
        System.out.println("[D]: Seed is       '"+GV.worldSeedVar_+"'");
        System.out.println("[D]: Used seed is  '"+GV.worldSeed+"'");
        System.out.println("[D]: Background  '"+GV.worldBackground+"'");


        // System.out.println(GV.getSecs()+"");
        // conwayD_NEW(worldMap,100, 0.5, true);
        // conwayD_OLD_Na(1000,-1,false);
        // printWorld(DisplayModifications.changeBorder(conwayD_OLD_Na(1001,-1,false),'∎'),true);
        // DisplayModifications.typeABlinkerCheck(conwayD_OLD_Na(1001,-1,false));
        
        System.out.println("vvvvvvvvvvv");
        char[][] testCharArr = {{'A','B','C'},{'a','b','c'},{'α','β','γ'}};
        printWorld(testCharArr,true);
        System.out.println("^^^^^^^^^^^");

        try {
            // conwayMap = WorldMapThing.generateThing();//worldMapDefault;
            // conwayMap = generateLayer((new char[worldMapHeight+2][worldMapLength+2]),'░');
            // printWorld(conwayMap,true);
            int d = Integer.parseInt((GV.GetUserInput("Enter a number to display or just enter to run a speed & check test, entering twice will start conways game of life if you have selected a seed: ")));
            conwayMap = generateLayer(conwayMap,'░');
            conwayMap = generateLayer1(conwayMap,d);//34287
            printWorld(conwayMap,true);

        } catch (NumberFormatException nfe) {

        int counter = 0;
        long shortistTime = 1000000;
        int shortistTimeK = -1;
        ArrayList<Integer> foundArray = new ArrayList<Integer>();
        Timing individualTime_ = new Timing();
        for(int k=2; k < 100/*1000*/ && false; k++){
            individualTime_.letsStart();
            // Per seed
            conwayMap = generateLayer1(worldMapDefault,k);
            for(int i = 1; i < conwayMap.length-1; i++){//Inner Box Only
                for(int j = 1; j < conwayMap[0].length-1; j++){//Inner Box Only
                if(conwayMap[i][j]=='▓'){
                    // System.out.println("Something");
                    counter++;
                    if(counter == 15-1){
                        System.out.println("I found something with seed "+k+"!");foundArray.add(k);
                        i=10000000;
                        j=10000000;
                        // System.exit(0);
                    }
                }else /*if(conwayMap[i][j]=='░')*/{counter=0;}
            }
            }
            counter=0;
            if(individualTime_.letsEnd() < shortistTime){
                shortistTime = individualTime_.letsEnd();
                shortistTimeK = k;
            }
            System.out.println("K: "+k+" Took "+GV.releventTimeFormatMilT(individualTime_.letsEnd())+"");
        }
        System.out.println("Shortest time took "+shortistTime+" for seed "+shortistTimeK);
        System.out.println("foundArray = "+foundArray);
        
        }//End of catch


        //@@@conwayMap = WorldMapThing.generateThing();
        //char[][] conwayMap1 = generateLayer(conwayMap,'░');g
        // conwayMap1 = generateLayer1(conwayMap,42);
//        conwayD_OLD_Na(conwayMap,75/*1001*/,0.25,false);
//        generateLayer1(conwayMap,d);
//        conwayD_OLD_Na(conwayMap,3000/*1001*/,0.06,false);
        conwayD_OLD_Na(conwayMap,3000/*1001*/,0.11,false);

        // conwayMap = consodolate(conwayMap,'░',false);
        printWorld(conwayMap,false);
    }

    // public static char[][] conwayD_NEW(boolean worldMap_[][],int runs_,double secondsToWait_,boolean pausePlace_){
    //     // RIGHT NOW WILL MAKE ALL CHANGES
    //     boolean[][] newMapB_ = new boolean[worldMap_.length-1][worldMap_[0].length-1];
    //     char[][] newMapS_ = new char[worldMap_.length-1][worldMap_[0].length-1];
    //     newMapS_ = generateLayer1(newMapS_);
    //     newMapS_ = DisplayModifications.changeBorder(newMapS_,'░');
    //     // Arrays.fill(newMapB_, false);
    //     // Arrays.stream(newMapB_).forEach(a -> Arrays.fill(a, false));
    //     // printWorld(newMapS_,true);
    //     worldMap_ = DisplayModifications.changeBorder(generateLayer1(newMapB_),false);
    //     newMapB_ = worldMap_;
    //     // worldMap_ = WorldMapThing.convertToBoolean(WorldMapThing.generateThing());
    //     // newMapS_ = (WorldMapThing.generateThing());
    //     worldMap_ = WorldMapThing.convertToBoolean(newMapS_);
    //     // newMapB_ = worldMap_;
    //     int tmpVal = 0;
    //     // Arrays.stream(newMapS_).forEach(a -> Arrays.fill(a, '░'));;
    //     for(int k = runs_; k > 0; k--){
    //         System.out.println(">>>>>" + worldMap_[0][0]);
    //         for(int i = 1; i < worldMap_.length-1; i++){//Inner Box Only
    //             for(int j = 1; j < worldMap_[0].length-1; j++){//Inner Box Only
    //                 //  -i+//Check for death and birth
    //                 //- XXX
    //                 //j XOX
    //                 //+ XXX
    //                 if(worldMap_[i-1][j-1]==true){tmpVal++;}
    //                 // if(worldMap_[i-1][j-1]){tmpVal++;}
    //                 if(worldMap_[i][j-1]==true){tmpVal++;}
    //                 if(worldMap_[i+1][j-1]==true){tmpVal++;}
    //                 //END Row 1
    //                 if(worldMap_[i-1][j]==true){tmpVal++;}
    //                 if(worldMap_[i+1][j]==true){tmpVal++;}
    //                 //END Row 2
    //                 if(worldMap_[i-1][j+1]==true){tmpVal++;}
    //                 if(worldMap_[i][j+1]==true){tmpVal++;}
    //                 if(worldMap_[i+1][j+1]==true){tmpVal++;}
    //                 // if(1!=0){System.out.println("tmpVal = " + tmpVal);}
    //                 //END Row 3
    //                 // if(worldMap_[i][j] && (tmpVal < 2 || tmpVal > 3)){//Cell Dies (underpopulation)//Cell Dies (overpopulation)
    //                 if(worldMap_[i][j] && tmpVal < 2){//Cell Dies (underpopulation)//Cell Dies (overpopulation)
    //                 // System.out.println("TESTTTT");
    //                     newMapB_[i][j] = false;
    //                     newMapS_[i][j] = '░';
    //                 }else if(worldMap_[i][j] && tmpVal > 3){////Cell Dies (underpopulation)//Cell Dies (overpopulation)
    //                     newMapB_[i][j] = false;
    //                     newMapS_[i][j] = '░';
    //                 }else if(tmpVal==3 && !worldMap_[i][j]){//Cell is born by haveing 3 adjacent cells
    //                     newMapB_[1][j] = true;
    //                     newMapS_[1][j] = '▓';
    //                 }else{
    //                     // System.out.println("DEBUGGING");
    //                     // newMapB_[i-1][j-1] = false;
    //                     // newMapS_[i-1][j-1] = '░';
    //                 }
    //                 // if(newMapB_[i-1][j-1]){
    //                 //     newMapS_[i-1][j-1] = '▓';
    //                 // }else if(newMapB_[i-1][j-1] == false){
    //                 //     newMapS_[i-1][j-1] = '░';
    //                 // }else{
    //                 //     newMapS_[i-1][j-1] = '!';
    //                 // }

    //                 tmpVal=0;//Right now only goes if changed
    //             }
    //             // if(k==97){worldMap_[5][5]=true;}
    //             // if(k==97){worldMap_[5][6]=true;}
    //             // if(k==97){worldMap_[6][5]=true;}
    //             // if(k==97){worldMap_[6][6]=true;}
    //         }
    //         GV.tSleep(secondsToWait_);
    //         if(pausePlace_){
    //             Scanner myScanner_ = new Scanner(System.in);
    //             myScanner_.nextLine();}
    //         DisplayModifications.clearScreen();
    //         worldMap_ = newMapB_;
    //         WorldGenerator.printWorld(newMapS_,true);
    //         // newMapB_ = new boolean[worldMap_.length-1][worldMap_[0].length-1];
    //         // Arrays.stream(newMapB_).forEach(a -> Arrays.fill(a, false));;
    //         // Arrays.stream(newMapS_).forEach(a -> Arrays.fill(a, '░'));;
    //         System.out.println("k =" + k);
    //         // worldMap_[5][5]=true;
    //         // System.out.println(newMapB_[5][5]+"");
    //     }
    //     return newMapS_;
    // }

    public char[][] conwayD_OLD_Na(char[][] layer1, int runs_, double waitTime_, boolean pausePlace_){
        layer1 = DisplayModifications.changeBorder(layer1,GV.worldBackground);
        Timing localTimer_ = new Timing();
        printWorld(layer1,true);
        double tmpDouble_ = 0;
        Scanner myScanner2_ = new Scanner(System.in);
        myScanner2_.nextLine();
        for(int k = 0; k < runs_; k++){
            // /* layer1b = consodolate(layer1,GV.layer1Char,4,true);//GV.layer1Char);
            layer1b = conwayD_OLD(layer1,GV.layer1Char,GV.changeMapIndicator);//GV.layer1Char);
            // System.out.println("layer1b is...");
            // printWorld(layer1b,true);
            worldMap_OLD = applyMap(layer1,layer1b,GV.conwayDeathIndicator,'░');
            worldMap_OLD = applyMap(worldMap_OLD,layer1b,GV.conwayBirthIndicator,'▓');
            if(pausePlace_){
                Scanner myScanner_ = new Scanner(System.in);
                myScanner_.nextLine();
            }else if(waitTime_ > 0){
                tmpDouble_ = waitTime_*(k+1)*1000-localTimer_.letsEnd();
                if(tmpDouble_ > 0){GV.tSleepMil(tmpDouble_);}
            }
            DisplayModifications.clearScreen();
            if(waitTime_ != -1){printWorld(worldMap_OLD,true);//For conaway true workes better.
            System.out.println("(k:"+k+") Applyed map with layer1b");
            }
        }
        DisplayModifications.clearScreen();
        printWorld(worldMap_OLD,true);
        System.out.println("(k:"+runs_+") Applyed map with layer1b");
        System.out.println("Semi-total elapsed time : "+GV.releventTimeFormatMilT(localTimer_.letsEnd()));

        printWorld(DisplayModifications.addColor(worldMap_OLD,DisplayModifications.charToColor),true);
        return worldMap_OLD;
    }

    public static char[][] conwayD_OLD(char worldMap_[][], char checkAgninst_, char deathDisplay_){
        // RIGHT NOW WILL MAKE ALL CHANGES
        char[][] changeMap_ = new char[worldMap_.length][worldMap_[0].length];
        //Run though generateLayer?
        int tmpVal = 0;
        for(int i = 1; i < worldMap_.length-1; i++){//Inner Box Only
            for(int j = 1; j < worldMap_[0].length-1; j++){//Inner Box Only
                //  -i+//Check for death and birth
                //- XXX
                //j XOX
                //+ XXX
                if(worldMap_[i-1][j-1] == checkAgninst_){tmpVal++;}
                if(worldMap_[i][j-1] == checkAgninst_){tmpVal++;}
                if(worldMap_[i+1][j-1] == checkAgninst_){tmpVal++;}
                //END Row 1
                if(worldMap_[i-1][j] == checkAgninst_){tmpVal++;}
                if(worldMap_[i+1][j] == checkAgninst_){tmpVal++;}
                //END Row 2
                if(worldMap_[i-1][j+1] == checkAgninst_){tmpVal++;}
                if(worldMap_[i][j+1] == checkAgninst_){tmpVal++;}
                if(worldMap_[i+1][j+1] == checkAgninst_){tmpVal++;}
                //END Row 3
                if(tmpVal < 2 && worldMap_[i][j]==checkAgninst_){//Cell Dies (underpopulation)
                    changeMap_[i-1][j-1] = GV.conwayDeathIndicator;
                }else if(tmpVal > 3 && worldMap_[i][j]==checkAgninst_){//Cell Dies (overpopulation)
                    changeMap_[i-1][j-1] = GV.conwayDeathIndicator;
                }else if(tmpVal==3 && worldMap_[i][j]!=checkAgninst_){//Cell is born by haveing 3 adjacent cells
                    changeMap_[i-1][j-1] = GV.conwayBirthIndicator;
                }
                tmpVal=0;//Right now only goes if changed
            }
        }
        return changeMap_;
    }

    // private static char[][] changeSpace

    private static char[][] generateLayer1(char layerMap_[][],int seed2_){
        int tmpVal = 0;
        int lastDigit_ = 0;
        int seed_ = 0;
        for(int i = 0; i < layerMap_.length; i++){
            for(int j = 0; j < layerMap_[0].length; j++){
                seed_ = ProcidualRandom.generatePusudoRandom(i*(lastDigit_)+j,true,seed2_);
                lastDigit_ = getLastDigit(seed_);
                for(int k = 0; k < (seed_+"").length(); k++){
                    tmpVal += Character.getNumericValue((seed_+"").charAt(k));
                }
                if ( (tmpVal & 1) == 1 ) {//If odd
                // if ( (tmpVal+"").charAt(1) == '3' ) {//If odd
                    layerMap_[i][j] = GV.layer1Char;
                } else {
                    layerMap_[i][j] = GV.worldBackground;
                }
                tmpVal=0;
            }
        }
        return layerMap_;
    }

    private static boolean[][] generateLayer1(boolean layerMap_[][]){
        int tmpVal = 0;
        int seed_ = 0;
        int lastDigit_ = 0;
        for(int i = 0; i < layerMap_.length; i++){
            for(int j = 0; j < layerMap_[0].length; j++){
                seed_ = ProcidualRandom.generatePusudoRandom(i*(lastDigit_)+j,true,seed_);
                lastDigit_ = getLastDigit(seed_);
                for(int k = 0; k < (seed_+"").length(); k++){
                    tmpVal += Character.getNumericValue((seed_+"").charAt(k));
                }
                if ( (tmpVal & 1) == 1 ) {//If odd
                // if ( (tmpVal+"").charAt(1) == '3' ) {//If odd
                    layerMap_[i][j] = true;
                } else {
                    layerMap_[i][j] = false;
                }
                tmpVal=0;
            }
        }
        return layerMap_;
    }

    public static char[][] applyMap(char base_[][],char layer_[][],char putKey_, char withKey_){
        boolean adder_ = true;
        if(base_.length == layer_.length){
            // boolean adder_ = false;}else{boolean adder_ = true;}
        adder_ = false;}

        for(int i = 0; i < layer_.length; i++){//Inner Box Only
            if(adder_ && i==0){i=1;}
            for(int j = 0; j < layer_[0].length; j++){//Inner Box Only
                if(adder_ && i==0){i=1;}
                if(layer_[i][j] == putKey_){
                    if(adder_){
                        base_[i][j] = withKey_;
                    }else{
                        base_[i+1][j+1] = withKey_;
                    }
                }

            }
        }
        return base_;
    }

    private static char[][] consodolate(char worldMap_[][],char checkAgninst_, int requiredTouchingSpaces_,boolean containing_){
        char[][] changeMap_ = new char[worldMap_.length][worldMap_[0].length];//+2 for border
        //Run though generateLayer?
        int tmpVal = 0;
        for(int i = 1; i < worldMap_.length-1; i++){//Inner Box Only
            for(int j = 1; j < worldMap_[0].length-1; j++){//Inner Box Only
                if(worldMap_[i][j] == checkAgninst_ || !(containing_)){
                    // DETERMINE OF REQUIRE A POSITIVE SPACE
                    if(worldMap_[i-1][j] == checkAgninst_){
                        tmpVal++;
                    }
                    if(worldMap_[i][j-1] == checkAgninst_){
                        tmpVal++;
                    }
                    if(worldMap_[i][j+1] == checkAgninst_){
                        tmpVal++;
                    }
                    if(worldMap_[i+1][j] == checkAgninst_){
                        tmpVal++;
                    }
                    if(tmpVal >= requiredTouchingSpaces_){
                        changeMap_[i-1][j-1] = GV.changeMapIndicator;
                    }else{
                        changeMap_[i-1][j-1] = '-';
                    }
                }
                tmpVal=0;
            }
        }

        return changeMap_;
    }

    public static int getPart(int input_, int places_, boolean takeFirst_){
        if((input_+"").length() <= places_){
            input_ *= GV.worldSeedPartA;
        }
        return Integer.parseInt((input_+"").substring(0, places_ - 1));
    }

    private static char[][] generateLayer(char worldMap_[][], char background_){
        for(int i = 0; i < worldMapHeight+1; i++){//Backwords for non-recaulacting? -Optimize?
            for(int j = 0; j < worldMapLength+1; j++){
                worldMap_[i][j] = background_;
            }
        }
        return worldMap_;
    }

    public static void printWorld(char worldMap_[][], boolean lineByLine_){
        int height_ = worldMap_.length;
        int width_ = worldMap_[0].length;
        String tmpStrHor_ = "";
        String tmpStrVir_ = "";
        for(int i = 0; i < height_; i++){
            for(int j = 0; j < width_; j++){
                tmpStrHor_ += worldMap_[i][j];
            }
            if(lineByLine_){ System.out.println(tmpStrHor_);
            }else{tmpStrVir_ = ""+ new StringBuilder().append(tmpStrVir_).append("\n");}//tmpStrVir_ += tmpStrHor_+"\n";}
            
            tmpStrHor_ = "";
        }
        if(!lineByLine_){
            tmpStrVir_ = tmpStrVir_.substring(0,tmpStrVir_.length()-2);//For removal of last \n
            System.out.print(tmpStrVir_);}
    }

    public static void printWorld(String worldMap_[][], boolean lineByLine_){
        int height_ = worldMap_.length;
        int width_ = worldMap_[0].length;
        String tmpStrHor_ = "";
        String tmpStrVir_ = "";
        for(int i = 0; i < height_; i++){
            for(int j = 0; j < width_; j++){
                tmpStrHor_ += worldMap_[i][j];
            }
            if(lineByLine_){ System.out.println(tmpStrHor_);
            }else{ tmpStrVir_ += tmpStrHor_+"\n";}
            tmpStrHor_ = "";
        }
        if(!lineByLine_){
            tmpStrVir_ = tmpStrVir_.substring(0,tmpStrVir_.length()-2);//For removal of last \n
            System.out.println(tmpStrVir_);}
    }

    public static int getLastDigit(int input_){
        return Character.getNumericValue((input_+"").charAt((input_+"").length()-1));
    }
}