package ua.oxooocb.fxlib.controller;

import ua.oxooocb.fxlib.stage.SimpleStage;
import ua.oxooocb.fxlib.stage.StageExecutor;
import ua.oxooocb.fxlib.stage.StageWrapper;

public abstract class ControllerQueue extends StageExecutor {

    //Основа основ.

    //Ячейка в хеше.
    private static int queue;

    /**
     * Конструктор.
     *
     * @param call Ячейка в хеше.
     **/

    public ControllerQueue(int call) {
        //Устанавливаем параметр для StageExecutor.
        super(call);
        //Указываем ячейку.
        queue = call;
        //Добавляем приложение.
        StageWrapper.put(call);
        //Добавляем контроллер.
        ControllerWrapper.put(call, this);
    }

    /**
     * Конструктор.
     *
     * @param call Ячейка в хеше.
     * @param stage Добавлить ли в хеш приложение.
     * @deprecated Рекомендуется использовать конструктор ControllerQueue(int call) так как система сама все регистрирует.
     */

    public ControllerQueue(int call, boolean stage) {
        //Устанавливаем параметр для StageExecutor.
        super(call);
        //Указываем ячейку.
        queue = call;
        //Если параметр stage будет указан true, то.
        if (stage) {
            //Добавляем приложение.
            StageWrapper.put(call);
        }
        //Добавляем контроллер.
        ControllerWrapper.put(call, this);
    }

    /**
     * Конструктор.
     *
     * @param call Ячейка в хеше.
     * @param stage Добавлить ли в хеш приложение.
     * @param controller Добавлять ли контроллер в приложение.
     * @deprecated Не рекомендуется использовать так как StageBuilder будет выдавать NullPointer при попытке регистрации.
     */

    public ControllerQueue(int call, boolean stage, boolean controller) {
        //Устанавливаем параметр для StageExecutor.
        super(call);
        //Указываем ячейку.
        queue = call;
        //Если параметр stage будет указан true, то.
        if (stage) {
            //Добавляем приложение.
            StageWrapper.put(call);
        }
        //Если параметр controller будет указан true, то.
        if (controller) {
            //Добавляем контроллер.
            ControllerWrapper.put(call, this);
        }
    }

    /**
     * Главный метод. Служит для регистрации методов: ивенты, анимации, прочее.
     */

    public abstract void register();

    /**
     * @return Ячейка контроллера/приложения в хеше.
     */

    public static int getCall() {
        return queue;
    }

    /**
     * @return Контроллер из хеша.
     */

    public static ControllerQueue getController() {
        return ControllerWrapper.get(queue);
    }

    /**
     * @return Приложение из хеща.
     */

    public static SimpleStage getStage() {
        return StageWrapper.get(queue);
    }

}
