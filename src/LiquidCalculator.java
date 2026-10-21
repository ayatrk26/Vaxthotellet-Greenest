
// Interface: Definierar vilka metoder som växtklasserna
// måste implementera för att beräkna vätskemängd och vätsketyp.
public interface LiquidCalculator {

    double calculateLiquidAmount();

    LiquidType getLiquidType();

}

