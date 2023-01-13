import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    //3.6
    @Test
    void countLetters() {
      var count = new Main();
      char[] chars = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : chars){
            map.put(c,0);
        }
      try {
          File file = new File("C:\\Users\\Batu\\Desktop\\text.txt");
          Main.countFrequency(file);
          String testText = "";
          FileReader fileReader = new FileReader(file);
          BufferedReader bufferedReader = new BufferedReader(fileReader);

          int c =0;
          while ((c=bufferedReader.read()) !=-1){

              char charAtPos = (char)c;

                  if(map.containsKey(charAtPos)){
                      map.put(charAtPos,map.get(charAtPos)+1);
                  }

          }
          for (Map.Entry<Character,Integer> entry:map.entrySet()){
              testText += ""+ entry.getKey()+" "+entry.getValue()+"\n";
          }
          assertEquals(testText,count.countFrequency(file));
      } catch (IOException e) {
          e.printStackTrace();
      }


    }

    @Test
    void countChars(){

    }
}