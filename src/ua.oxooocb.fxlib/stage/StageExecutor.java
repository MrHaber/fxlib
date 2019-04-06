package ua.oxooocb.fxlib.stage;

import javafx.application.*;

public class StageExecutor {

    private final SimpleStage stage;

    public StageExecutor(int cell) {
        stage = getStage(cell);
    }

    /**
     * Закрыть текущее приложение и открыть новое.
     *
     * @param open Ячейка в хеше. (Открыть)
     */

    public void closeCurrent(int open) {
        Platform.runLater(() -> {
            //Исключение.
            try {
                //Закрываем приложение.
                stage.close();
                //Ожидаем 500мс
                Thread.sleep(500);
                //Показываем приложение.
                getStage(open).show();
                //Отправляем запрос чтобы вывести приложение поверх других окон.
                getStage(open).requestFocus();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Закрыть текущее приложение.
     */

    public void close() {
        Platform.runLater(stage::close);
    }

    /**
     * Показывается ли приложение.
     *
     * @return true/false.
     */

    public boolean isShowing() {
        return stage.isShowing();
    }

    /**
     * Показать приложение.
     */

    public void show(int next) {
        Platform.runLater(() -> {
            //Показываем приложение.
            getStage(next).show();
            //Выводим поверх других окон.
            getStage(next).requestFocus();
        });
    }

    /**
     * Вывести приложение поверх других окон.
     */

    public void updateHover() {
        stage.requestFocus();
    }

    /**
     * Выйти.
     */

    public void exit() {
        //Выйти с кодом 0.
        System.exit(0);
    }

    /**
     * Получить приложение.
     *
     * @param cell Ячейка в хеше.
     * @return Приложение.
     */

    private SimpleStage getStage(int cell) {
        return StageWrapper.get(cell);
    }

}
