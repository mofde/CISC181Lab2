package cisc181.lab_2;
public class KangarooPiece {
    private String symbol;
    private boolean hidden;
    private int numJumps;
    private int numKicks;
    public KangarooPiece(String symbol, boolean hidden, int numJumps, int numKicks) {
        this.symbol = symbol;
        this.hidden = hidden;
        this.numJumps = numJumps;
        this.numKicks = numKicks;
    }
    public KangarooPiece() {
        this("Kanga", true, 0, 0);
    }
    public String getSymbol() {
        return symbol;
    }
    public boolean isHidden() {
        return hidden;
    }
    public int getNumJumps() {
        return numJumps;
    }
    public int getNumKicks() {
        return numKicks;
    }
    public int jumped() {
        this.numJumps = this.numJumps + 1;
        return this.numJumps;
    }
    public int changeKicks(int numKicks) {
        this.numKicks = this.numKicks + numKicks;
        if (this.numKicks < 0) {
            return this.numKicks = 0;
        }
        else {
            return this.numKicks;
        }
    }
    public KangarooPiece offSpring(String symbol) {
        KangarooPiece copy = new KangarooPiece(this.symbol + symbol, this.hidden, this.numJumps, this.numKicks);
        return copy;
    }
}