package u05oop.tasks.cave.treasure;

import java.util.Random;

public enum TreasureName {
    GOLDEN,
    FORGOTTEN,
    MAGIC,
    EPIC,
    MYSTICAL,
    CURSED,
    LEGENDARY,
    SACRED,
    HEAVEN;

    private static final TreasureName[] TREASURE_NAMES = values();
    private static final int SIZE = TreasureName.values().length;
    private static final Random RANDOM = new Random();

    public static TreasureName getRandomName() {
        return TREASURE_NAMES[RANDOM.nextInt(SIZE)];
    }
}
