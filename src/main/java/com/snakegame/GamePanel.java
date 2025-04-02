package com.snakegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GamePanel handles rendering and game updates.
 * Ensures separation of concerns by keeping game logic encapsulated.
 */
public class GamePanel extends JPanel implements ActionListener {
    private final int TILE_SIZE = 20;
    private final int WIDTH = 600;
    private final int HEIGHT = 600;
    private final int DELAY = 100;
    private Timer timer;
    private Snake snake;

    /**
     * Initializes the game panel.
     * Preconditions: None
     * Postconditions: Game rendering and updates are handled.
     */
    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);

        snake = new Snake(); // Initialize snake logic
        timer = new Timer(DELAY, this);
        timer.start();
    }

    /**
     * Paints the game components.
     * Preconditions: Graphics context must be valid.
     * Postconditions: The snake is drawn on the panel.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        snake.draw(g);
    }

    /**
     * Called at each timer tick to update the game state.
     * Preconditions: None
     * Postconditions: Snake moves and the screen updates.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();
        repaint();
    }
}
