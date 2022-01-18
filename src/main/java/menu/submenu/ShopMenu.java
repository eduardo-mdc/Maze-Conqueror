package menu.submenu;


import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import element.position.Position;
import game.Game;
import menu.Button;
import menu.Menu;
import menu.button.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShopMenu extends Menu {
    private final int xIncr = 10;
    private final int yIncr = 20;


    public ShopMenu(Game game, Screen screen) throws IOException {
        super(game,screen);
        text = "WELCOME TO THE SHOP @ WHERE YOU CAN SPEND YOUR POINS FOR ITEMS!";
        splitText("@",xIncr,yIncr);
        btn = Arrays.asList(
                new CloseShopButton(game,new Position(xIncr+7,yIncr+10))
        );
    }
}

