class Main {
    Timing totalTime_ = new Timing();

    public static void main(String[] args) {
        Timing totalTime_ = new Timing();
        System.out.println("Hello world!"+System.currentTimeMillis());
        // // System.out.println(GV.worldSeed * GV.worldSeed);
        System.out.println(GV.worldSeed);

        WorldGenerator world1 = new WorldGenerator();
        
        System.out.println("\n Semi-Total Program Exucution time of class Main: "+GV.releventTimeFormatMilT(totalTime_.letsEnd()));
        
    }

}