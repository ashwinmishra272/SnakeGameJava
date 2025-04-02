package com.snakegame;

import java.awt.*;

public class GameEngine {

    private final int WIDTH = 30;
    private final int HEIGHT = 30;
    private boolean gameOver = false;

    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * Checks if the snake has collided with the wall or itself.
     * If a collision occurs, the game ends.
     * <p>
     * Precondition: The snake must exist.
     * Post-condition: If a collision is detected, gameOver is set to true.
     */
    public void checkCollision(Snake snake) {
        Point head = snake.getHead();

        // ✅ Wall Collision Check
        if (head.x < 0 || head.x >= WIDTH || head.y < 0 || head.y >= HEIGHT) {
            gameOver = true;
            return;
        }

        // ✅ Self-Collision Check
        for (int i = 1; i < snake.getBody().size(); i++) {
            if (head.equals(snake.getBody().get(i))) {
                gameOver = true;
                return;
            }
        }
    }
}
