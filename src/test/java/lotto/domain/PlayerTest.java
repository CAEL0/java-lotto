package lotto.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.constant.ExceptionConstants.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest extends NsTest {

    @DisplayName("구입금액이 자연수가 아니면 예외가 발생한다.")
    @Test
    void ThrowExceptionIfPurchaseAmountIsNotNaturalNumber() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(NOT_NATURAL_NUMBER_EXCEPTION.toString());
        });
    }

    @DisplayName("구입금액이 0으로 시작하면 예외가 발생한다.")
    @Test
    void ThrowExceptionIfPurchaseAmountWithLeadingZero() {
        assertSimpleTest(() -> {
            runException("01000");
            assertThat(output()).contains(LEADING_ZERO_EXCEPTION.toString());
        });
    }

    @DisplayName("구입금액이 로또 가격으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void ThrowExceptionIfPurchaseAmountIndivisible() {
        assertSimpleTest(() -> {
            runException("1500");
            assertThat(output()).contains(PURCHASE_AMOUNT_INDIVISIBILITY_EXCEPTION.toString());
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
