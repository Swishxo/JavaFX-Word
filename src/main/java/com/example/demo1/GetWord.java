package com.example.demo1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class GetWord {

    TreeMap<Integer, String> tree = new TreeMap<>();

    public void jumpStart() throws FileNotFoundException {
        String doc = "C:\\Users\\steph\\IdeaProjects\\Class\\src\\Doc.txt";
        FileInputStream f = file(doc);
        Scanner scan = fileScanned(f);

        //add ArrayList func to Set
        ArrayList wrd = new ArrayList<>(addToList(scan));
        Set<String> set = new HashSet<>(wrd);
        Map<String, Integer> map = new HashMap<>();

        //for-each String in Set put in map
        for(String x: set) {
            map.put(x, 1);//every word in map, mapped to 1
        }

        //checks number of times String appears
        for(Object x: wrd){
            if(map.containsKey(x)) {
                map.put(x.toString(), map.get(x) + 1);
            }
        }

        //sort values from smallest to biggest Number
        HashMap<String, Integer> funcSort = sortByValue((HashMap<String, Integer>) map);

        //Give HashMap to TreeMap, Key == int and String == value
        for(String x: funcSort.keySet()) {
            tree.put(funcSort.get(x), x);
        }

        //get individual type from tree
        //send();


    }

    //display the solution
     TreeMap<Integer, String> send() throws FileNotFoundException {
        jumpStart();
        return tree;
    }

    //pass string to file method
    public static FileInputStream file(String doc) throws FileNotFoundException {
        FileInputStream fin = new FileInputStream(doc);
        return fin;
    }
    //add each line from scan to ArrayList, and return ArrayList
    public static ArrayList<String> addToList(Scanner scan){
        ArrayList<String> wrd = new ArrayList<>();
        while(scan.hasNext()){
            String toLower = scan.next();
            toLower = toLower.toLowerCase();
            String replaced = toLower.replaceAll("[^A-Za-z0-9]", "");
            wrd.add(replaced);
        }
        return wrd;
    }

    //read file input stream, place in scanner, return scanner
    public static Scanner fileScanned(FileInputStream fin){
        Scanner fileInput = new Scanner(fin);
        return fileInput;
    }

    //Sorting function for smallest to biggest #
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm){
        //create a list that takes Map.Entry as params
        List<Map.Entry<String, Integer> > list = new LinkedList<>(hm.entrySet());

        //sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;

    }

}