package com.example.probe.service;

import org.springframework.stereotype.Service;
import com.example.probe.model.*;

@Service
public class ProbeService {
    private Point position = new Point(0, 0);
    private Direction direction = Direction.N;
    private final Grid grid = new Grid(5, 5);

    public void executeCommands(String commands) {
        for (char cmd : commands.toCharArray()) {
            switch (cmd) {
                case 'L':
                    direction = direction.turnLeft();
                    break;
                case 'R':
                    direction = direction.turnRight();
                    break;
                case 'F':
                    moveForward();
                    break;
                default:
            }
        }
    }

    private void moveForward() {
        Point newPosition = null;
        switch (direction) {
            case N:
                newPosition = new Point(position.getX(), position.getY() + 1);
                break;
            case E:
                newPosition = new Point(position.getX() + 1, position.getY());
                break;
            case S:
                newPosition = new Point(position.getX(), position.getY() - 1);
                break;
            case W:
                newPosition = new Point(position.getX() - 1, position.getY());
                break;
            default:
                newPosition = position;
        }
        if (grid.isInside(newPosition)) {
            position = newPosition;
        }
    }

    public String getState() {
        return position.getX() + " " + position.getY() + " " + direction;
    }
}
