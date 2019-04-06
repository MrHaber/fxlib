package ua.oxooocb.fxlib.controller;

import java.util.*;

public class ControllerWrapper {

    //Мапа.
    private static LinkedHashMap<Integer, ControllerQueue> controllerIntegerHashMap = new LinkedHashMap<>();

    /**
     * Записываем значение в хеш.
     *
     * @param cell Ячейка в хеше.
     * @param controller Контроллер.
     * @return Контроллер.
     */

    public static ControllerQueue put(Integer cell, ControllerQueue controller) {
        return controllerIntegerHashMap.put(cell, controller);
    }

    /**
     * Достаем значение с хеша.
     *
     * @param cell Ячейка в хеше.
     * @return Контроллер.
     */

    public static ControllerQueue get(Integer cell) {
        return controllerIntegerHashMap.get(cell);
    }

    /**
     * Установить значение в хеш.
     *
     * @param cell Ячейка в хеше.
     * @param controller Альтернатива контроллера.
     */

    public static void set(Integer cell, ControllerQueue controller) {
        controllerIntegerHashMap.replace(cell, controller);
    }

    /**
     * Удалить значение с хеша.
     *
     * @param cell Ячейка в хеше.
     */

    public static void remove(Integer cell) {
        controllerIntegerHashMap.remove(cell);
    }

    /**
     * @return Размер хеша.
     */

    public static int size() {
        return controllerIntegerHashMap.size();
    }

    /**
     * @return Хеш.
     */

    public static LinkedHashMap<Integer, ControllerQueue> map() {
        return controllerIntegerHashMap;
    }

}
