// Nicholas Harris
// 40111093

/* 2.5.9 Develop a data type that allows you to write a client that can sort a file such as the one
shown below. (You need to create a file with the format of the input to test your program.) */

import java.lang.FileData;
import java.io.*;

public class ClientFile{
    public static void sortByVolume(FileData[] data, int size){
        for(int i = 1; i < size; i++){
            long key = data[i].volume;
            int j = i - 1;
        
            while(j >= 0 && data[j].volume > key){
                data[j+1].volume = data[j].volume;
                j--;
            }
            data[j+1].volume = key;
        }
    }

    public static int inputData(FileData[] data, String file) throws IOException{
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);
        String line = null;
        int count = 0;
        while((line = buffer.readLine())!= null){
            String date = line.split(" ")[0];
            long volume = Long.parseLong(line.split(" ")[1]);
            data[count++] = new FileData(date, volume);
        }
        buffer.close();
        return count;
    }

    public static void outputData(FileData[] data, String file, int size) throws IOException{
        FileWriter writer = new FileWriter(file);
        BufferedWriter buffer = new BufferedWriter(writer);
        for(int i = 0; i < size; i++){
            buffer.write(data[i].toString());
        }
        buffer.close();
    }

    public static void main(String[] args) throws IOException{
        FileData[] storedData = new FileData[50];
        String iFile = "input.txt";
        String oFile = "output.txt";
        int size = inputData(storedData, iFile);
        sortByVolume(storedData, size);
        outputData(storedData, oFile, size);
    }
}