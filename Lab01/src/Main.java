import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Arrays;
import java.io.FileWriter;

public class Main {
        

    //for specific undefined amounts of chars
    public static HashMap<Character,Integer> countChars(String text, char[] chars){

        HashMap<Character, Integer> count = new HashMap<Character, Integer>();


        //Initialization of Hashmap with Char Values from String[] chars
        for (char aChar : chars) {
            count.put(aChar, 0);
        }
        char[] charText = text.toCharArray();


        //Searching for specific chars in text
        for(char c : charText){
            if(count.containsKey(c)){
                count.put(c, count.get(c)+1);
            }
        }

        //Printing the char count
        //for(Map.Entry entry : count.entrySet()){
        //    System.out.println(entry.getKey() + " " + entry.getValue());
        //}
        return count;
    }

    //all lower case
    public static String normalize(String text){

        char[] crt = text.toCharArray();

        for(int i=0;i< crt.length;i++){
            if(crt[i] >= 'A' && crt[i]<='Z'){
                crt[i] = (char)((int)crt[i]+32);
            }
        }
        text = new String(crt);
        return text;
    }

    
    public static String nextCharacter(String text){

        char[] crt = text.replaceAll(" ","").toCharArray();
        text ="";
        //For Showcase
        for(char c : crt){
            System.out.print("'"+c+"'");
            text += "'"+c+"'";

        }

        return text;
    }
    //create file with overwrite and size
    public static void createFile(String text, String name) throws IOException {

            try{
                File ort = new File("C:\\Users\\Batu\\Desktop\\"+name+".txt");
                FileWriter writeText = new FileWriter(ort.getPath());
                if(ort.createNewFile()){
                    writeText.write(text);
                    writeText.close();
                    System.out.println("File created: "+ort.getName()+" "+ort.getPath());

                }else{
                    Path path = Paths.get("C:\\Users\\Batu\\Desktop\\"+name+".txt");
                    double sOLD = Files.size(path);

                    //Securitymanager nachschauen
                    ort.delete();
                    ort.createNewFile();
                    writeText.write(text);
                    writeText.close();
                    double sNEW = Files.size(path);
                    System.out.println("Existing File overwritten");
                    System.out.println("Path: "+ort.getPath());
                    System.out.println("Name: "+ort.getName());
                    System.out.println("File size: "+sNEW +" Bytes");

                }
            } catch (Exception e){
                System.out.println("Err");
                e.printStackTrace();

            }

    }

    
    public static String countFrequency(File file) throws IOException{
        Path path = Paths.get(file.getPath());
        String text = "";
        String gtext ="";
        char[] chars = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        try {
            text = Files.readString(path);
            ;

            for (Map.Entry<Character,Integer> entry : countChars(normalize(text),chars).entrySet()){
                gtext += ""+ entry.getKey()+" "+entry.getValue()+"\n";
            }


           // createFile(text,"frequency");


        } catch (Exception e){
            System.out.println("Err: File or Path might be incorrect");
            e.printStackTrace();
        }
        return gtext;
    }

    
    public static String highestChar(HashMap<Character,Integer> con){
        int max = Collections.max(con.values());
        for(Map.Entry<Character,Integer> entry : con.entrySet()){
            if(entry.getValue()==max){
                return entry.getKey()+" : "+entry.getValue();
            }
        }
        return "Not working";
    }
   
    public static HashMap<Character,String> histogram(HashMap<Character,Integer> con){
        HashMap<Character,String> ret = new HashMap<Character,String>();

        for(Map.Entry<Character,Integer> entry : con.entrySet()){
            String count ="";
            for(int i =0; i< entry.getValue();i++) {

                count += "*";
            }

            ret.put(entry.getKey(), count);
        }


        return ret;


    }

    //Misc
    public static String hashtoString(HashMap<Character, ?> con){

        String text = "";

        try {

            for (Map.Entry<Character,?> entry : con.entrySet()){
                text += ""+ entry.getKey()+" "+entry.getValue()+"\n";
            }


            // createFile(text,"frequency");


        } catch (Exception e){
            System.out.println("Err: File or Path might be incorrect");
            e.printStackTrace();
        }
        return text;
    }

    public static String readFromFile(File file){
        String text ="";
        Path path = Paths.get(file.getPath());
        try{
            text = Files.readString(path);
        }catch (Exception e){
            System.out.println("Err: Path or File incorrect");
            e.printStackTrace();
        }
        return text;
    }
}
