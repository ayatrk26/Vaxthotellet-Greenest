
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {

    private static final String title = "Växthotellet Greenest";
    private static final String startMessage = "Växthotellet Greenest startar!";

    private static final String plantPrompt = "Vilken växt ska få vätska?\n"
            + "Tillgängliga växter: " +
            "\nIgge " +
            "\nLaura " +
            "\nMeatloaf" +
            "\n Olof";

    private static final String notFoundMessage= "Växten hittades inte. Försök igen.";

    private static final String emptyMessage = "Du måste skriva namnet på en växt.";

    private static final String unsupportedPlantMessage="Växten kan inte beräkna sitt vätskebehov.";

    private static final String resultLabel  = "Växt: ";
    private static final String liquidLabel= "\nVätska: ";
    private static final String amountLabel= "\nMängd: ";
    private static final String dailyLabel = " liter per dag";

    private static final String againMessage = "Vill du välja en annan växt?";

    private static final double IggeHight  = 0.20;
    private static final double LauraHIGHT = 5.0;
    private static final double MeatloafHight = 0.7;
    private static final double OlofHight = 1.0;

    private static final String IggeName = "Igge";
    private static final String LauraName = "Laura";
    private static final String MeatloafName = "Meatloaf";
    private static final String OlofName = "Olof";

    public static void main(String[] args) {

        System.out.println(startMessage);

        ArrayList<Plant> plants = new ArrayList<>();

        plants.add(new Cactus(IggeName ,IggeHight ));
        plants.add(new Palm(LauraName ,LauraHIGHT ));
        plants.add(new CarnivorousPlant(MeatloafName , MeatloafHight));
        plants.add(new Palm(OlofName ,OlofHight));

        boolean continueProgram = true;

        while (continueProgram) {

            String plantName = JOptionPane.showInputDialog(null,plantPrompt,title, JOptionPane.QUESTION_MESSAGE);

            if (plantName == null) {
                break;
            }

            plantName = plantName.trim();

            if (plantName.isEmpty()) {
                JOptionPane.showMessageDialog(null, emptyMessage,title, JOptionPane.WARNING_MESSAGE);
                continue;
            }

            Plant selectedPlant = null;

            for (Plant plant : plants) {
                if (plant.getName().equalsIgnoreCase(plantName)) {
                    selectedPlant = plant;
                    break;
                }
            }

            if (selectedPlant == null) {

                JOptionPane.showMessageDialog(null,notFoundMessage,title, JOptionPane.WARNING_MESSAGE);

            } else if (selectedPlant instanceof LiquidCalculator) {

                LiquidCalculator calculator =
                        (LiquidCalculator) selectedPlant;

                // Polymorfism: rätt metod anropas beroende på växtens klass.
                String result = resultLabel
                        + selectedPlant.getName()
                        + liquidLabel
                        + calculator.getLiquidType()
                        + amountLabel
                        + calculator.calculateLiquidAmount()
                        + dailyLabel ;

                JOptionPane.showMessageDialog(
                        null, result, title ,
                        JOptionPane.INFORMATION_MESSAGE
                );

            } else {

                JOptionPane.showMessageDialog(
                        null, unsupportedPlantMessage, title, JOptionPane.WARNING_MESSAGE);
            }

            int choice = JOptionPane.showConfirmDialog(null, againMessage, title, JOptionPane.YES_NO_OPTION);

            continueProgram = choice == JOptionPane.YES_OPTION;
        }
    }
}