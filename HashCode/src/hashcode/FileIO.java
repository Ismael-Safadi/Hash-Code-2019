package hashcode;

import java.io.*;
import java.util.*;

public class FileIO {
    
    static int noOfVertical = 0;
    static SlideV slideV = null;
    
    public static String inputFiles[] = {
        "a_example.txt",
        "b_lovely_landscapes.txt",
        "c_memorable_moments.txt",
        "d_pet_pictures.txt",
        "e_shiny_selfies.txt"
    };
    
    public static String outputFiles[] = {
        "a_example.txt",
        "b_lovely_landscapes.txt",
        "c_memorable_moments.txt",
        "d_pet_pictures.txt",
        "e_shiny_selfies.txt"
    };
    
    private static ArrayList<Photo> photos = new ArrayList<Photo>();
    
    public static void readFile(int index) throws Exception
    {
        // Remove Output File To Add
        File outputFile = new File("output/"+outputFiles[index]);
        outputFile.delete();
        
        // Input Data 
        File file = new File("input/"+inputFiles[index]);
        DataInputStream input = new DataInputStream(new FileInputStream(file));
           
        String line = input.readLine();
        // First Line Processing
        int N = Integer.parseInt(line);
        
        line = input.readLine();
        while(line != null)
        {
            // Objects Processing

            String[] photoData = line.split(" ");
            
            Photo photo = new Photo();

                
            
            int M = Integer.parseInt(photoData[1]);
            for(int i=0;i<M;i++)
            {
                photo.tags.add(photoData[i+2]);
            }
            
            SlideH slide = null;
            if(photoData[0].equals("V"))
            {
                photo.orientation=false;
                FileIO.noOfVertical = (FileIO.noOfVertical + 1)%2;
                
                if(FileIO.noOfVertical == 1)
                {
                    FileIO.slideV = new SlideV(new HashSet(photo.tags));
                    FileIO.slideV.photos[0] = photo;
                } else {
                    FileIO.slideV.union(new HashSet(photo.tags));
                    FileIO.slideV.photos[1] = photo;
                    Slideshow.slides.add(FileIO.slideV);
                }
                
            } else {
                slide = new SlideH(new HashSet(photo.tags));
                slide.photo = photo;
                Slideshow.slides.add(slide);
            }
            
            line = input.readLine();
        }
        
        input.close();
    }
    
    public static void writeLine(int index,String line) throws Exception
    {
        File file = new File("output/"+outputFiles[index]);
        FileWriter fr = new FileWriter(file, true);
        fr.write(line+"\n");
        fr.close();
    }
}
