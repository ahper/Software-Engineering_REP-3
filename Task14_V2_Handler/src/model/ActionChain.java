package model;

import java.util.Random;

public class ActionChain {
    public enum StateEnum {SUCCESS, LOSS, CHANCE}

    public static int getRandomEnumValue() {
        Random random = new Random();
        int randomIndex = random.nextInt(StateEnum.class.getEnumConstants().length);
        return StateEnum.class.getEnumConstants()[randomIndex].ordinal();
    }
}
