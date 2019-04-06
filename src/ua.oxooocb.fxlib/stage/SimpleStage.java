package ua.oxooocb.fxlib.stage;

import javafx.stage.*;
import ua.oxooocb.fxlib.controller.ControllerQueue;

public class SimpleStage extends Stage {

    private ControllerQueue controller;

    /**
     * Зарегистрирован ли на приложение контроллер.
     *
     * @return true/false.
     */

    public boolean hasController() {
        return controller != null;
    }

    /**
     * Есть ли у приложения CSS.
     *
     * @return true/false.
     */

    public boolean hasCSS() {
        return getScene().getStylesheets().isEmpty();
    }

    /**
     * Есть ли иконка у приложения.
     *
     * @return true/false.
     */

    public boolean hasIcon() {
        return getIcons().isEmpty();
    }

    /**
     * Установить контроллер.
     *
     * @param controller Контроллер.
     */

    public void setController(ControllerQueue controller) {
        this.controller = controller;
    }

    /**
     * Получить контроллер.
     *
     * @return Контроллер.
     */

    public ControllerQueue getController() {
        return controller;
    }


}
