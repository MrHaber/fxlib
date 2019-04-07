package ua.oxooocb.fxlib.stage;

import javafx.application.Platform;
import javafx.fxml.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.paint.*;
import javafx.stage.*;
import java.io.*;
import ua.oxooocb.fxlib.controller.ControllerQueue;
import ua.oxooocb.fxlib.controller.ControllerWrapper;

public class StageBuilder {

    private final Rectangle2D screen;
    private final StageBuilder stageBuilder;
    private Parent parent;
    private SimpleStage stage;
    private ControllerQueue controller;

    /**
     * Конструктор.
     */

    public StageBuilder() {
        this.screen = Screen.getPrimary().getVisualBounds();
        this.stageBuilder = this;
    }

    /**
     * Конструктор.
     *
     * @param stage Приложение
     */

    public StageBuilder(SimpleStage stage) {
        this.screen = Screen.getPrimary().getVisualBounds();
        this.stageBuilder = this;
        this.stage = stage;
    }

    /**
     * Загрузить текстуру сцены.
     *
     * @throws Exception Исключение.
     */

    public StageBuilder create(FXMLLoader fxmlLoader) throws Exception {
        //Загружаем текстуру.
        this.parent = fxmlLoader.load();
        //Инициализируем контроллер.
        this.controller = fxmlLoader.getController();
        //Добавляем приложение.
        StageWrapper.put(controller.getCell());
        //Добавляем контроллер.
        ControllerWrapper.put(controller.getCell(), controller);
        //Ставим приложение.
        this.stage = StageWrapper.get(controller.getCell());
        //Ставим сцену.
        stage.setScene(new Scene(parent));
        //Ставим контроллер.
        stage.setController(controller);
        return stageBuilder;
    }

    /**
     * Установить размер приложения.
     *
     * @param width Ширина.
     * @param height Высота.
     */

    public StageBuilder setSize(double width, double height) {
        //Ставим указаный размер.
        stage.setWidth(width);
        stage.setHeight(height);
        //Возвращаем builder.
        return stageBuilder;
    }

    /**
     * Убрать верхнюю панель с приложения.
     */

    public StageBuilder initStyle() {
        //Ставим прозрачный фон.
        stage.getScene().setFill(Color.TRANSPARENT);
        //Убираем кнопки [Свернуть,Развернуть,Закрыть].
        stage.initStyle(StageStyle.TRANSPARENT);
        //Возвращаем builder.
        return stageBuilder;
    }

    public StageBuilder setTitle(String title) {
        stage.setTitle(title);
        return stageBuilder;
    }

    /**
     * Загрузить кастомный контроллер.
     *
     * @param runnable Методы.
     */

    public synchronized StageBuilder loadCustomController(Runnable runnable) {
        //Загружаем контроллер и выполняем методы.
        runnable.run();
        return stageBuilder;
    }


    /**
     * Получить список CSS.
     *
     * @return List.
     */

    public StageBuilder addCSS(String path) {
        //Возвращаем css с ячейки.
        stage.getScene().getStylesheets().add(path);
        return stageBuilder;
    }


    /**
     * Зарегистрировать контроллер.
     */

    public StageBuilder registerController(boolean register) throws Exception {
        if (register) {
            //Регистрируем контроллер.
            controller.register();
            //Ставим что контроллер используется.
            stage.setController(controller);
        }
        return stageBuilder;
    }


    /**
     * Добавить иконку в приложение.
     *
     * @param image InputStream иконки.
     */

    public StageBuilder addIcon(InputStream image) {
        //Добавляем изображение в HashMap.
        stage.getIcons().add(new Image(image));
        return stageBuilder;
    }

    /**
     * Собрать приложение.
     */

    public void build() {
        stage.setX((screen.getWidth() - stage.getWidth()) / 2);
        stage.setY((screen.getHeight() - stage.getHeight()) / 2);
        Platform.runLater(() -> {
            stage.show();
            stage.requestFocus();
        });
    }


}
