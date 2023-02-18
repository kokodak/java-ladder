package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import utils.LadderRowGenerator;

public class Ladder {

    private final List<LadderRow> ladderRows = new ArrayList<>();
    private final LadderRowGenerator ladderRowGenerator;

    public Ladder(final LadderRowGenerator ladderRowGenerator) {
        this.ladderRowGenerator = ladderRowGenerator;
    }

    public void create(final int ladderHeight, final int userCount) {
        for (int i = 0; i < ladderHeight; i++) {
            LadderRow line = ladderRowGenerator.generate(userCount);
            ladderRows.add(line);
        }
    }

    public List<LadderRow> getLadderRows() {
        return Collections.unmodifiableList(ladderRows);
    }
}
