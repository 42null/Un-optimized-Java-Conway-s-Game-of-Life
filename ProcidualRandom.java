public class ProcidualRandom{

    private static int seed = GV.worldSeed;

    public void ProcidualRandom(){
    }

    public static int generatePusudoRandom(int numberOfIterations_, boolean noNeg_, int seedM_){

        int seed_ = Math.abs(seedM_);
        String seedStr_ = seedM_+"";//Seed not seed_ at this time

        for(int i = 0; i < numberOfIterations_; i++){
            // seed_ = seed_ * seed_;
            seed_ = seedM_ * seed_;
            seedStr_ = seed_+"";
            if(seed_ >= 100000000){//At least 9 digets long
                seedStr_ = seedStr_.substring(2,6);
                seed_ = Integer.parseInt(seedStr_);
            }else{
                seed_ *= seedM_;
            }
            //  % GV.worldSeedPartA;
        }
        // To make shure it never returns will less then 9 digets

        // seedStr_ = seedStr_+"65778951";//Added random.org additions to keep from problem with returing 0
        seedStr_ = String.format("%08d", Integer.parseInt(seedStr_));
        // System.out.println(seedStr_);

        seed_ = Integer.parseInt(seedStr_);

        if(noNeg_){
            seed_ = Math.abs(seed_);
        }
        return seed_;
    }

// public static int generatePusudoRandom(int numberOfIterations_, boolean noNeg_, int seedM_){

//         int seed_ = Math.abs(seed);
//         String seedStr_ = seed+"";//Seed not seed_ at this time

//         for(int i = 0; i < numberOfIterations_; i++){
//             // seed_ = seed_ * seed_;
//             seed_ = seed * seed;
//             seedStr_ = seed_+"";
//             if(seed_ >= 100000000){//At least 9 digets long
//                 seedStr_ = seedStr_.substring(2,6);
//                 seed_ = Integer.parseInt(seedStr_);
//             }else{
//                 seed_ *= seed;
//             }
//             //  % GV.worldSeedPartA;
//         }
//         // To make shure it never returns will less then 9 digets

//         // seedStr_ = seedStr_+"65778951";//Added random.org additions to keep from problem with returing 0
//         seedStr_ = String.format("%08d", Integer.parseInt(seedStr_));
//         // System.out.println(seedStr_);

//         seed_ = Integer.parseInt(seedStr_);

//         if(noNeg_){
//             seed_ = Math.abs(seed_);
//         }
//         return seed_;
//     }
}