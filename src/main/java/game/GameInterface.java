package game;

import java.io.IOException;

public interface GameInterface {

    void setInitialize(boolean value);

    void setState(int newState);

    void getTerminal(int newState);

    int getscreenH();

    int getscreenW();

    void quit(int status) throws IOException;

    void run();

    void newGame();
}
