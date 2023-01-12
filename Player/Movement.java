package Player;

public class Movement {

    private int stepCount_X;
    private int stepCount_Y;

    public Movement(int x, int y) {
        this.stepCount_X = x;
        this.stepCount_Y = y;
    }

    public int advanceForward() {
        return stepCount_Y += 2;
    }

    public int advanceLeft() {
        return stepCount_X -= 2;
    }

    public int advanceRight() {
        return stepCount_X += 2;
    }

    public Movement getPosition() {
        return new Movement(stepCount_X, stepCount_Y);
    }

    @Override
    public String toString() {
        return "(" + stepCount_X + ", " + stepCount_Y + ")";
    }

}
