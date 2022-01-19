package game;

import game.GameInterface;

import java.io.*;
import java.util.*;

public class Leaderboard {
    private GameInterface game;
    private Integer heroNumber;
    private TreeMap<Integer,Integer> scoreMap;
    private Map<Integer,Integer> sortedMap;
    private final String filepath = "data/leaderboard.txt";
    public Leaderboard(GameInterface game){
        this.game = game;
        scoreMap = new TreeMap<>();
    }

    public static <K, V extends Comparable<V> > Map<K, V>
    valueSort(final Map<K, V> map)
    {
        // Static Method with return type Map and
        // extending comparator class which compares values
        // associated with two keys
        Comparator<K> valueComparator = new Comparator<K>() {

            // return comparison results of values of
            // two keys
            public int compare(K k1, K k2)
            {
                int comp = map.get(k1).compareTo(
                        map.get(k2));
                if (comp == 0)
                    return 1;
                else
                    return -comp;
            }

        };

        // SortedMap created using the comparator
        Map<K, V> sorted = new TreeMap<K, V>(valueComparator);

        sorted.putAll(map);

        return sorted;
    }


    public void read(){
        try {
            File file = new File(filepath);
            if(file.exists()) {
                Scanner scanner = new Scanner(file);
                String data = null;
                while (scanner.hasNextLine()) {
                    data = scanner.nextLine();
                    splitAndInsert(data);
                }
                scanner.close();
                if (data != null) {
                    heroNumber = scoreMap.lastKey() + 1;
                    game.setHeroID(heroNumber);
                    sortedMap = valueSort(scoreMap);
                }
                else
                    initializeWithEmptyFile("File is Empty");
            }
            else
                initializeWithEmptyFile("File Not Found");
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
            e.printStackTrace();
        }
    }

    private void initializeWithEmptyFile(String error){
        System.out.println(error);
        heroNumber = 1;
        game.setHeroID(heroNumber);
        sortedMap = new TreeMap<>();
    }

    public void write(){
        try {
            File file = new File(filepath);
            if (file.createNewFile())
                System.out.println("File created: " + file.getName());
            FileWriter writer = new FileWriter(file);
            writer.write(this.toString());
            writer.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void put(Integer score){
        if(scoreMap.containsKey(heroNumber)) scoreMap.replace(heroNumber,score);
        else scoreMap.put(heroNumber,score);
        sortedMap = valueSort(scoreMap);
    }

    private void splitAndInsert(String data){
        String[] result = data.split("-");
        Integer heroID = Integer.valueOf(result[0].substring(4));
        Integer heroScore = Integer.valueOf(result[1]);
        scoreMap.put(heroID,heroScore);
    }


    @Override
    public String toString(){
        String result = "";
        for (Map.Entry<Integer, Integer> pair : sortedMap.entrySet()) {
            result = result.concat("hero");
            result = result.concat(pair.getKey().toString());
            result = result.concat("-");
            result = result.concat(pair.getValue().toString());
            result = result.concat("\n");
        }
        return result;
    }

}
