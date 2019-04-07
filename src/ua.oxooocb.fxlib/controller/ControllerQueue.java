package ua.oxooocb.fxlib.controller;

import ua.oxooocb.fxlib.stage.StageExecutor;

public abstract class ControllerQueue extends StageExecutor {

    //Основа основ.

    //Ячейка в хеше.
    private int queue;

    /**
     * Конструктор.
     *
     * @param cell Ячейка в хеше.
     **/

    public ControllerQueue(int cell) {
        //Устанавливаем параметр для StageExecutor.
        super(cell);
        //Указываем ячейку.
        queue = cell;
    }

    /**
     * Главный метод. Служит для регистрации методов: ивенты, анимации, прочее.
     */

    public abstract void register();

    /**
     * @return Ячейка контроллера/приложения в хеше.
     */

    public int getCell() {
        return queue;
    }

}
