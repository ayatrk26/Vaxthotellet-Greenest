// Arv: Klassen ärver namn och höjd från Plant.
// Interface: Klassen implementerar LiquidCalculator.
public class CarnivorousPlant extends Plant implements LiquidCalculator {

    private static final double baseLiquidAmount = 0.1;
    private static final double liquidPerMeter = 0.2;

    public CarnivorousPlant(String name, double height) {

        super(name, height);
    }

    @Override
    public double calculateLiquidAmount() {

        return baseLiquidAmount + (liquidPerMeter * getHeight());
    }

    @Override
    public LiquidType getLiquidType() {

        return LiquidType.proteinDrink;
    }
}
