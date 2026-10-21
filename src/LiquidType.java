public enum LiquidType {

    tapWater ("Kranvatten"),
    mineralWater ("Mineralvatten"),
    proteinDrink ("Proteindryck");

    private final String displayName;

    LiquidType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}