// Nicholas Harris
// 40111093

/* 2.5.9 Develop a data type that allows you to write a client that can sort a file such as the one
shown below. (You need to create a file with the format of the input to test your program.) */

class FileData {
    String date;
    long volume;

    FileData(String d, long v){
        this.date = d;
        this.volume = v;
    }

    public void setDate(String d){
        this.date = d;
    }

    public void setVolume(long v){
        this.volume = v;
    }

    public String getDate(){
        return date;
    }

    public long getVolume(){
        return volume;
    }

    public String toString(){
        return date + " " + volume + "\n";
    }

    public int compareTo(FileData other){
        return this.volume - other.volume;
    }
}