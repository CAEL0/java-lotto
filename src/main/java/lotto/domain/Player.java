package lotto.domain;

import java.util.regex.Pattern;

import static lotto.constant.ExceptionConstants.*;
import static lotto.constant.GameConstants.*;

public class Player {

    private void validateNaturalNumber(String purchaseAmount) {
        if (!Pattern.matches(NATURAL_NUMBER_REGEX, purchaseAmount)) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_NATURAL_NUMBER_EXCEPTION.toString());
        }
    }

    private void validateLeadingZero(String purchaseAmount) {
        if (!Pattern.matches(NO_LEADING_ZERO_REGEX, purchaseAmount)) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_WITH_LEADING_ZERO.toString());
        }
    }

    private int parse(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount);
    }
}