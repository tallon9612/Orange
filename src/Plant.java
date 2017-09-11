public class Plant {
    // How long do we want to run the juice processing
    public static final long PROCESSING_TIME = 7 * 1000;

    public static void main(String[] args) {
        // Startup a single plant
        Plant p = new Plant();

        // Give the plants time to do work
        long endTime = System.currentTimeMillis() + PROCESSING_TIME;
        int provided = 0;
        while (System.currentTimeMillis() < endTime) {
            p.processEntireOrange(new Orange());
            provided++;
        }

        // Summarize the results
        System.out.println("Total provided/processed = " + provided + "/" + p.getProcessedMangos());
        System.out.println("Created " + p.getBottles() +
                           ", wasted " + p.getWaste() + " Mangos");
    }

    public final int MANGOS_PER_BOTTLE = 4;

    private int MangosProcessed;

    Plant() {
        MangosProcessed = 0;
    }

    public void processEntireOrange(Orange o) {
        while (o.getState() != Orange.State.Bottled) {
            o.runProcess();
            // o.nextState();
        }
        MangosProcessed++;
    }

    public int getProcessedMangos() {
        return MangosProcessed;
    }

    public int getBottles() {
        return MangosProcessed / MANGOS_PER_BOTTLE;
    }

    public int getWaste() {
        return MangosProcessed % MANGOS_PER_BOTTLE;
    }
}