package domain;

import java.util.Collections;
import java.util.List;

public class LadderRow {

    private static final String CONSECUTIVE_LINE_ERROR = "[ERROR] 사다리의 라인은 같은 깊이에서 연속적으로 존재할 수 없습니다.";

    private final List<Line> lines;

    public LadderRow(final List<Line> lines) {
        validate(lines);
        this.lines = lines;
    }

    private void validate(final List<Line> lines) {
        for (int i = 0; i < lines.size() - 1; i++) {
            isAllExist(lines.get(i), lines.get(i + 1));
        }
    }

    private void isAllExist(Line current, Line next) {
        if (current == Line.EXIST && next == Line.EXIST) {
            throw new IllegalArgumentException(CONSECUTIVE_LINE_ERROR);
        }
    }

    public int getExistingLineIndex(int index) {
        int leftLineIndex = getLeftLineIndex(index);
        int rightLineIndex = getRightLineIndex(index);
        if (lines.get(leftLineIndex) == Line.EXIST) {
            return leftLineIndex;
        }
        if (lines.get(rightLineIndex) == Line.EXIST) {
            return rightLineIndex;
        }
        return -100;
    }

    private int getLeftLineIndex(int index) {
        if (index == 0) {
            return index;
        }
        return index - 1;
    }

    private int getRightLineIndex(int index) {
        if (index == lines.size()) {
            return index - 1;
        }
        return index;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
