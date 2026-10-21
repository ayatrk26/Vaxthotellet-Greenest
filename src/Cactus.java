// Arv: Klassen ärver namn och höjd från Plant.
// Interface: Klassen implementerar LiquidCalculator.
public class Cactus extends Plant implements LiquidCalculator {

    private static final double dailyLiquidAmount = 0.02;

    public Cactus(String name, double height) {
        super(name, height);
    }

    @Override
    public double calculateLiquidAmount() {
        return dailyLiquidAmount;
    }

    @Override
    public LiquidType getLiquidType() {
        return LiquidType.mineralWater;
    }
}

