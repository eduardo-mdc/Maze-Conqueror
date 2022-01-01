package menu;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.ActionListDialogBuilder;
import com.googlecode.lanterna.screen.Screen;
import game.Game;

import java.io.IOException;

public class Menu implements MenuInterface {
    final private String backgroundcolor = "#000000";
    private Screen screen;
    public Menu(Screen screen, int type ) throws IOException {
        this.screen = screen;
        screen.clear();
        draw(type);
    }
    public void draw(int type) throws IOException {
        TextGraphics textgraphics = screen.newTextGraphics();
        textgraphics.setBackgroundColor(TextColor.Factory.fromString(backgroundcolor));
        textgraphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(200, 200), ' ');
        final WindowBasedTextGUI textGUI = new MultiWindowTextGUI(screen);
        switch (type) {
            case 1:
                new ActionListDialogBuilder()
                        .setCanCancel(false)
                        .setTitle("Game menu")
                        .setDescription("                                                                                                                       ")
                        .addAction("Start Game", new Runnable() {
                            @Override
                            public void run() {
                                Game.setState(1);
                            }
                        })
                        .addAction("Instructions", new Runnable() {
                            @Override
                            public void run() {
                                Game.setState(2);
                            }
                        })
                        .addAction("Exit", new Runnable() {
                            @Override
                            public void run() {
                                Game.setState(3);
                            }
                        })
                        .build()
                        .showDialog(textGUI);
                break;
            case 2:
                new ActionListDialogBuilder()
                        .setCanCancel(false)
                        .setTitle("Pause menu")
                        .setDescription("                                                                                                                       ")
                        .addAction("Resume Game", new Runnable() {
                            @Override
                            public void run() {
                                Game.setState(1);
                            }
                        })
                        .addAction("Restart", new Runnable() {
                            @Override
                            public void run() {
                                Game.setState(4);
                            }
                        })
                        .addAction("Exit", new Runnable() {
                            @Override
                            public void run() {
                                Game.setState(3);
                            }
                        })
                        .build()
                        .showDialog(textGUI);
                break;
            case 3:
                screen.startScreen();
                Panel panel = new Panel();
                panel.setLayoutManager(new LinearLayout(Direction.VERTICAL));
                panel.setPosition(new TerminalPosition(50,50));

                final TextBox linha1 = new TextBox(new TerminalSize(30,5),"Instrucoes para o jogo \nVai do ponto a para o ponto B").addTo(panel);

                linha1.setReadOnly(true);
                linha1.setEnabled(false);

                Button button = new Button("Back", new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Game.setState(1);
                            Menu menu = new Menu(screen,1);
                            //TODO Error making all buttons go to intructions
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("MAKE ME GO BACKK!!!");
                    }
                });

                button.addTo(panel);
                panel.addComponent(new EmptySpace(new TerminalSize(0, 0)));
                BasicWindow window = new BasicWindow();
                window.setComponent(panel);

                // Create gui and start gui
                MultiWindowTextGUI gui1 = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
                gui1.addWindowAndWait(window);
                break;
        }
        }
    }

