package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static utils.constants.ErrorMessages.NUMBER_FORMAT;
import static utils.constants.GameRules.MAX_NAME_LENGTH;

public class StringParser {

    public static final String SPLIT_DELIMITER = ",";
    public static final int SPLIT_LIMIT = -1;

    public static List<String> splitByDelimiter(final String input) {
        return Arrays.stream(input.split(SPLIT_DELIMITER, SPLIT_LIMIT))
                .map(name -> name.replace(" ", ""))
                .collect(Collectors.toUnmodifiableList());
    }

    public static int parseToInteger(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NUMBER_FORMAT.getMessage(), exception);
        }
    }

    public static String insertBlank(final String input) {
        return String.format("%" + MAX_NAME_LENGTH.getValue() + "s", input);
    }
}
