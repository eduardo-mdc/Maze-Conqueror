package handler;

import game.GameInterface;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LeaderboardHandler {
    private GameInterface game;
    private Integer heroNumber;
    private Map<Integer,Integer> scoreMap;
    private final String filepath = "data/leaderboard.txt";
    public LeaderboardHandler(GameInterface game){
        this.game = game;
        scoreMap = new HashMap<>();
    }

    public void read(){
        try {
            boolean flag = true;
            File file = new File(filepath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                if(flag){
                    heroNumber = Integer.parseInt(data)+1;
                    game.setHeroID(heroNumber);
                    flag = false;
                }
                else{
                    splitAndInsert(data);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

    public void write(){
        try {
            FileWriter writer = new FileWriter(filepath);
            writer.write(this.toString());
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
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
        if (heroNumber == null) result = result.concat(getHighestKey());
        else result = result.concat(heroNumber.toString()+"\n");
        for (Map.Entry<Integer, Integer> pair : scoreMap.entrySet()) {
            result = result.concat("hero");
            result = result.concat(pair.getKey().toString());
            result = result.concat("-");
            result = result.concat(pair.getValue().toString());
            result = result.concat("\n");
        }
        return result;
    }

    private String getHighestKey(){
        int max = 0;
        for (Map.Entry<Integer, Integer> pair : scoreMap.entrySet()) {
            if(max < pair.getKey()) max = pair.getKey();
        }
        return Integer.toString(max)+1;
    }

}
