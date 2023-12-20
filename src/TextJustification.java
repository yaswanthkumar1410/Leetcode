import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//INCOMPLETE
public class TextJustification {
    public static List<String> fullJustify(String[] words, int maxWidth) {
       List<String> result=new ArrayList<>();
        int capacity=maxWidth;
        int numberOfSpaces=maxWidth;
        List<String> temp=new ArrayList<>();
       for(int i=0;i<words.length;i++){
           if(capacity>words[i].length()){

               if(i==words.length-1){
                   numberOfSpaces-=words[i].length();

                   result.add(leftJustified(words[i],numberOfSpaces));
               }
               temp.add(words[i]);
               capacity-=words[i].length()+1;
               numberOfSpaces-=words[i].length();
           }
           else{
               result.add(justify(temp, numberOfSpaces));
               temp.clear();
               i--;
               capacity=maxWidth;
               numberOfSpaces=maxWidth;
           }
       }
        return result;
    }
    public static String justify(List<String> words, int remaining){
        String line="";
        int spacings= words.size()-1;
        if(words.size()==1)
            spacings=1;
        int spaces=remaining/spacings;
        int leftSpace=remaining%spacings;
        for(String s: words) {
            if(leftSpace==-1){
                line=line+s+spaces(spaces);
            }
            else {
                line=s+spaces(spaces+leftSpace);
                leftSpace=-1;
            }
        }
        System.out.println(line);
        return line.trim();
    }
    public static String spaces(int space){
        String spaces="";
        for(int i=0;i<space;i++){
            spaces+=" ";
        }
        return spaces;
    }
    public static  String leftJustified(String words, int remaining){
        String line=words+spaces(remaining);
        System.out.println(line);
        return line;
    }
    public static void main(String[] args){
        List<String> justified=fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."},16);
        System.out.println(justified);
    }
}
