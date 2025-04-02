package com.snakegame;

import java.awt.*;
import java.util.LinkedList;


/**
 * Represent the snake entity in game
 * Responsible for movement of snake and state management
 */

public class Snake {

    private final int TILE_SIZE = 20;
    private LinkedList<Point> body;
    private final SnakeGame.Direction direction;

    /**
     * Initializes the snake at the center of the board.
     * Preconditions: None
     * Post conditions: The snake starts with an initial size of 3 segments.
     */
    public Snake() {
        body = new LinkedList<>();
        body.add(new Point(10, 10));
        body.add(new Point(9, 10));
        body.add(new Point(8, 10));
        direction = SnakeGame.Direction.RIGHT;
    }

    /**
     * Define the movement of the Snake     *
     * should move in the direction
     * Should avoid going out of the boundary
     */
public void move(GameEngine engine){
    Point head =body.getFirst();
    if(engine.isGameOver()){
        return;
    }
    Point newHead=switch (direction) {
        case UP -> new Point(head.x, head.y - 1);
        case DOWN -> new Point(head.x, head.y + 1);
        case LEFT -> new Point(head.x - 1, head.y);
        case RIGHT -> new Point(head.x + 1, head.y);
    };
   engine.checkCollision(this);
    body.addFirst(newHead);
    body.removeLast();
}
    /**
     * Draws the snake on the panel.
     * Preconditions: Graphics context must be valid.
     * Post-conditions: The snake is rendered correctly.
     */
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        for (Point p : body) {
            g.fillRect(p.x * TILE_SIZE, p.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }
    }

    public Point getHead() {
        return body.getFirst();
    }

    public LinkedList<Point> getBody() {
        return body;
    }
}
