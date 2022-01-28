package deprecated;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class used for multithreaded input without stopping the flow of the game. Deprecated due to the availability of the lanterna.poll() function
 */
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
