package hashcode;

import java.util.*;

public class Slide {
    public Set tags = new HashSet();
    public Slide(Set tags)
    {
        this.tags = tags;
    }
    
    public int interestingWith(Slide slide)
    {
            Set intersectionSet = new HashSet(this.tags);
            intersectionSet.retainAll(slide.tags);
            int intersection = intersectionSet.size();
            int no1 = this.tags.size() - intersection;
            int no2 = slide.tags.size() - intersection;

            return Math.min(no1, Math.min(no2, intersection));
    }
}

class SlideV extends Slide {
    public Photo[] photos = new Photo[2];
    
    public SlideV(Set tags)
    {
        super(tags);
    }
    
    public void union(Set tags)
    {
        this.tags.addAll(tags);
    }
    
    public String toString()
    {
        return photos[0].id+" "+photos[1].id;
    }
}

class SlideH extends Slide {
    public Photo photo;
    
    public SlideH(Set tags)
    {
        super(tags);
    }
    
    public String toString()
    {
        return String.valueOf(photo.id);
    }
}