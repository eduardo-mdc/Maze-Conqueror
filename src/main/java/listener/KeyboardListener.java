package listener;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class KeyboardListener extends Thread{
    private KeyStroke key;
    private Queue<KeyStroke> input;
    private Screen screen;
    double frameTime;
    public KeyboardListener(double frameTime, Screen screen){
        this.frameTime = frameTime;
        this.screen = screen;
        this.input = new LinkedList<>();
    }

    public KeyStroke getInput(){
        if(input.size() == 0) return null;
        return input.remove();
    }

    @Override
    public void run(){
        while (true){
            try {
                key = screen.readInput();
                if(key != null) input.add(key);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
