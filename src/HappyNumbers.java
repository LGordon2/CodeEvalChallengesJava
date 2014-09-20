import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lew on 9/19/14.
 */
public class HappyNumbers {
    public static void main(String []args){
        File inputFile = new File(args[0]);
        BufferedReader reader = null;
        String line = null;
        try{
            reader = new BufferedReader(new FileReader(inputFile));
            while((line = reader.readLine())!=null){
                if(isHappyNumber(Integer.valueOf(line))){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }
        }catch(IOException e){
            System.err.println("IO error with file.");
        }finally{
            try{
                reader.close();
            }catch(IOException e){
                System.err.println("Error closing file.");
            }
        }
    }

    public static Boolean isHappyNumber(Integer possibleHappyNumber){
        Set numberSet = new HashSet<Integer>();
        while(!numberSet.contains(possibleHappyNumber)){
            numberSet.add(possibleHappyNumber);
            possibleHappyNumber = calculateNextHappyNumber(possibleHappyNumber).intValue();
            if(possibleHappyNumber.equals(1)){
                return true;
            }
        }
        return false;
    }

    private static Double calculateNextHappyNumber(Integer number){
        if(number < 10){
            return Math.pow(number.doubleValue(), 2.0);
        }

        return Math.pow(number % 10, 2.0) + calculateNextHappyNumber(number / 10);
    }
}
