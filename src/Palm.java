// Arv: Klassen ärver namn och höjd från Plant.
// Interface: Klassen implementerar LiquidCalculator.
public class Palm extends Plant implements LiquidCalculator {

    private static final double litersPerMeter  = 0.5;

    public Palm(String name, double height) {
        super(name, height);
    }

    @Override
    public double calculateLiquidAmount() {
        return litersPerMeter * getHeight();
    }

    @Override
    public LiquidType getLiquidType() {

        return LiquidType.tapWater ;
    }
}
