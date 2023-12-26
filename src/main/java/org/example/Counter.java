package org.example;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Counter {
    public static Map<String, Integer> count (String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        Map<String, Integer> words = new HashMap<>();
        while(sc.hasNext()){
            String word = sc.next();
            if(words.containsKey(word)){
                words.put(word, words.get(word)+1);
            }
            else {
                words.put(word, 1);
            }
        }
        return words;
    }
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)    {
        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
