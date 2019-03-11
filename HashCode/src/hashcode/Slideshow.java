package hashcode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Slideshow {
    
    static int index=4;
    
    public static ArrayList<Slide> slides = new ArrayList<Slide>();
    public static ArrayList<Slide> sortedSlides = new ArrayList<Slide>();
    
    public static void main(String[] args) throws Exception {
        
        for(int i = 0;i<5;i++)
        {
            index = i;
            FileIO.readFile(index);

            while(slides.size() > 0){

                Slide slide = slides.get(0);

                int minimum = 0;
                Slide similar = null;
                for(Slide slide2: slides)
                {
                    int min = slide.interestingWith(slide2);
                    if(min >= minimum)
                    {
                        minimum = min;
                        similar = slide2;
                    }
                }

                sortedSlides.add(slide);

                if(similar != null)
                {  
                    slides.remove(similar);
                    try{
                        slides.set(0, similar);
                    }catch(Exception e)
                    {
                        break;
                    }

                }

            }

            printInFile(); 
        }
    }
    
    public static void printInFile() throws Exception
    {
        File file = new File("output/"+FileIO.outputFiles[index]);
        FileWriter fr = new FileWriter(file, true);
        fr.write(sortedSlides.size()+"\n");
        
        for(Slide slide:sortedSlides)
        {
            fr.write(slide.toString());
            fr.write("\r\n");
        }
        fr.close();
    }
    
}
