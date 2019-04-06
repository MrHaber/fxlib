package ua.oxooocb.fxlib.stage;

import java.util.*;

public class StageWrapper {

    //Мапы
    private static LinkedHashMap<Integer, SimpleStage> stageIntegerHashMap = new LinkedHashMap<>();

    /**
     * Записываем значение в хеш.
     *
     * @param cell Ячейка в хеше.
     */

    public static SimpleStage put(Integer cell) {
        return stageIntegerHashMap.put(cell, new SimpleStage());
    }

    /**
     * Достаем значение с хеша.
     *
     * @param cell Ячейка в хеше.
     * @return Приложение.
     */

    public static SimpleStage get(Integer cell) {
        return stageIntegerHashMap.get(cell);
    }

    /**
     * Установить значение в хеш.
     *
     * @param cell Ячейка в хеше.
     * @param stage Альтернативное приложение.
     */

    public static void set(Integer cell, SimpleStage stage) {
        stageIntegerHashMap.replace(cell, stage);
    }

    /**
     * Удалить приложение из хеша.
     *
     * @param cell Ячейка в хеше.
     */

    public static void remove(Integer cell) {
        stageIntegerHashMap.remove(cell);
    }

    /**
     * @return Размер хеша.
     */

    public static int size() {
        return stageIntegerHashMap.size();
    }

    /**
     * @return Хеш.
     */

    public static LinkedHashMap<Integer, SimpleStage> map() {
        return stageIntegerHashMap;
    }


}
