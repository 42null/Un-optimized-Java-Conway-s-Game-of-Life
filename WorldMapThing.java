public class WorldMapThing{
    static public char[][] worldMap = generateThing();

    static public char[][] generateThing(){
        String[] localString_ = {
        // "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░",
        // "░░░░░░░░░░░░░░░░░░░░░░▓▓▓░▓░░░░░░░░░░░░░░░░░░░░░░░░░",
        // "░░░░░░░░░░░░░░░░░░░░░░▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░░",
        // "░░░░░░░░░░░░░░░░░░░░░░░░░▓▓░░░░░░░░░░░░░░░░░░░░░░░░░",
        // "░░░░░░░░░░░░░░░░░░░░░░░▓▓░▓░░░░░░░░░░░░░░░░░░░░░░░░░",
        // "░░░░░░░░░░░░░░░░░░░░░░▓░▓░▓░░░░░░░░░░░░░░░░░░░░░░░░░",
        "▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░",
        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░",
        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░",
        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░",
        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░",
        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░▓░░░░░░░░░░░░░░░░░░░░░░░",
        "░░░░░░░░░░░░░░░░░░░░░░░░░░▓░▓░░░░░░░░░░░░░░░░░░░░░░░",
        "░░░░░░░░░░░░░░░░▓▓░░░░░░▓▓░░░░░░░░░░░░▓▓░░░░░░░░░░░░",
        "░░░░░░░░░░░░░░░▓░░░▓░░░░▓▓░░░░░░░░░░░░▓▓░░░░░░░░░░░░",
        "░░░░▓▓░░░░░░░░▓░░░░░▓░░░▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░",
        "░░░░▓▓░░░░░░░░▓░░░▓░▓▓░░░░▓░▓░░░░░░░░░░░░░░░░░░░░░░░",
        "░░░░░░░░░░░░░░▓░░░░░▓░░░░░░░▓░░░░░░░░░░░░░░░░░░░░░░░",
        "░░░░░░░░░░░░░░░▓░░░▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░",
        "░░░░░░░░░░░░░░░░▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░",
        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░",
        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░",
        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░",
        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░",
        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░",
        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░",
        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░",
        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░",
        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░",
        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░",
        "░▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▓▓░",
        "░▓▓░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░▓▓░",
        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░"
        };
        char[][] returnThis_ = new char[27][52];
        for(int i=0; i < 27/*.length-1*/; i++){
            for(int j=0; j < localString_[0].length(); j++){
                returnThis_[i][j] = localString_[i].charAt(j);
            }
        }
        return returnThis_;
    }

    static public boolean[][] convertToBoolean(char[][] charArray_){
        boolean[][] returnThis_ = new boolean[charArray_.length][charArray_[0].length];
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 51; j++){
                if(charArray_[i][j] == '░'){
                    returnThis_[i][j] = false;
                }else if(charArray_[i][j] == '▓'){
                    returnThis_[i][j] = true;
                }
            }
        }
        return returnThis_;
    }
}