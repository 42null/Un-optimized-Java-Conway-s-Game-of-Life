class Timing{
    public long startingTime = System.currentTimeMillis();
    public long endingTime = -1;
    public long elapsedTime = -1;

    // public void Timing(){
    // }

    public void setStart(long replacement_){
        startingTime = replacement_;
    }

    public void letsStart(){
        startingTime = System.currentTimeMillis();
    }

    public long getStart(){
        return startingTime;
    }

    public long getEnd(){
        return endingTime;
    }
    
    public long getElapsed(){
        return elapsedTime;
    }

    public long letsEnd(){
        endingTime = System.currentTimeMillis();
        elapsedTime = endingTime - startingTime;
        return elapsedTime;
    }
}