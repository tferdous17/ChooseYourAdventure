package Player;

public class Movement {

    private int stepCount;
    private int x;
    private int y;

    public Movement(int x, int y) {
        this.x = x;
        this.y = y;
        stepCount = 0;
    }

    public int advanceForward() {
        stepCount += 1;
        return y += 2;
    }

    public int advanceLeft() {
        stepCount += 1;
        return x -= 2;
    }

    public int advanceRight() {
        stepCount += 1;
        return x += 2;
    }

    public Movement getPosition() {
        return new Movement(x, y);
    }

    public int getStepCount() {
        return stepCount;
    }

    @Override
    public String toString() {
        return "Step Count: " + getStepCount() + "(" + x + ", " + y + ")";
    }

}
