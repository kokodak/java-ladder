import controller.Controller;
import domain.Ladder;
import domain.Users;
import utils.LadderRowGenerator;
import utils.RandomLadderRowGenerator;

public class Application {
    public static void main(String[] args) {
        LadderRowGenerator ladderRowGenerator = new RandomLadderRowGenerator();

        Ladder ladder = new Ladder(ladderRowGenerator);

        Controller controller = new Controller(ladder);
        controller.run();
    }
}
