import java.io.*;

/**
 * Created by lew on 9/19/14.
 */
public class RightmostChar {
    public static void main(String [] args){
        File inputFile = new File(args[0]);
        BufferedReader reader = null;
        try {
            String line, letter, inputWord;
            String [] input;
            reader = new BufferedReader(new FileReader(inputFile));
            while((line = reader.readLine()) != null){
                input = line.split(",");
                inputWord = input[0];
                letter = input[1];
                System.out.println(inputWord.lastIndexOf(letter));
            }
        }catch(FileNotFoundException e){
            System.err.println("File not found!");
        }catch(IOException e){
            System.err.println("IO error.");
        }finally{
            if(reader != null)
                try {
                    reader.close();
                }catch(IOException e){
                    System.err.println("Error closing file.");
                }
        }
    }
}
