package com.snakegame;

import javax.swing.*;

/**
 * Entry point for the Snake Game.
 * Responsible for UI setup only.
 * Ensures separation of concerns by keeping logic outside.
 */
public class SnakeGame extends JFrame {

    /**
     * Initializes the game UI.
     * Preconditions: None
     * Postconditions: A game window is created and displayed.
     */
    public SnakeGame() {
        initUI();
    }

    /**
     * Sets up the UI properties.
     * Ensures that the game panel is attached and displayed properly.
     */
    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }
    private void initUI() {
        setTitle("Snake Game");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        GamePanel gamePanel = new GamePanel();
        add(gamePanel);

        setVisible(true);
    }

    /**
     * Starts the game in the Swing event dispatch thread.
     * Ensures thread safety for UI operations.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(SnakeGame::new);
    }
}
