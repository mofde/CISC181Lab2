package cisc181.lab_2;
public class TreasureBox {
    public static double PTS_PER_GOLD_COIN = 15.0;
    public static double PTS_PER_SILVER_COIN = 7.5;
    private int numGoldCoins;
    private int numSilverCoins;
    private double totalPoints;
    public TreasureBox(int numGoldCoins, int numSilverCoins) {
        this.numGoldCoins = numGoldCoins;
        this.numSilverCoins = numSilverCoins;
        this.updateTotalPoints();
    }
    public TreasureBox() {
        this(0, 0);
    }
    private void updateTotalPoints() {
        this.totalPoints = (PTS_PER_GOLD_COIN * numGoldCoins) + (PTS_PER_SILVER_COIN * numSilverCoins);
    }
    public double getTotalPoints() {
        return totalPoints;
    }
    public int getNumGoldCoins() {
        return numGoldCoins;
    }
    public int getNumSilverCoins() {
        return numSilverCoins;
    }
    public void collectCoins(int numGoldCoins, int numSilverCoins) {
        this.numGoldCoins = this.numGoldCoins + numGoldCoins;
        this.numSilverCoins = this.numSilverCoins + numSilverCoins;
        this.totalPoints = (PTS_PER_GOLD_COIN * this.numGoldCoins) + (PTS_PER_SILVER_COIN * this.numSilverCoins);
    }
    public boolean removeGoldCoins(int numGoldCoins) {
        if (numGoldCoins > this.numGoldCoins) {
            return false;
        }
        else {
            this.numGoldCoins = this.numGoldCoins - numGoldCoins;
            this.totalPoints = (PTS_PER_GOLD_COIN * this.numGoldCoins) + (PTS_PER_SILVER_COIN * this.numSilverCoins);
            return true;
        }
    }
    public void removeSilverCoins(int numSilverCoins) {
        this.numSilverCoins = this.numSilverCoins - numSilverCoins;
        this.totalPoints = (PTS_PER_GOLD_COIN * this.numGoldCoins) + (PTS_PER_SILVER_COIN * this.numSilverCoins);
    }
    public boolean tradeSilverCoins() {
        if (this.numSilverCoins <= 0) {
            return false;
        }
        else {
            int numGoldCoins = this.numSilverCoins;
            this.numSilverCoins = 0;
            this.numGoldCoins = this.numGoldCoins + numGoldCoins;
            this.totalPoints = (PTS_PER_GOLD_COIN * this.numGoldCoins) + (PTS_PER_SILVER_COIN * this.numSilverCoins);
            return true;
        }
    }
    public static boolean balanceBoxes(TreasureBox testBox1, TreasureBox testBox2) {
        int numGoldCoins1;
        numGoldCoins1 = testBox1.getNumGoldCoins();
        int numGoldCoins2;
        numGoldCoins2 = testBox2.getNumGoldCoins();
        int numSilverCoins1 = testBox1.getNumSilverCoins();
        int numSilverCoins2 = testBox2.getNumSilverCoins();
        double totalPoints1 = testBox1.getTotalPoints();
        double totalPoints2 = testBox2.getTotalPoints();
        if (numGoldCoins1 != numGoldCoins2) {
            int temp = numGoldCoins1;
            numGoldCoins1 = numGoldCoins2;
            numGoldCoins2 = temp;
            return true;
        }
        else {
            return false;
        }
    }
}
