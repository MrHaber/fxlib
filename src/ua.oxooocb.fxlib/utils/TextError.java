package ua.oxooocb.fxlib.utils;

import com.jfoenix.controls.*;
import javafx.application.*;
import javafx.scene.paint.*;

public class TextError {

    private final JFXTextField jfxTextField;
    private final Paint focus;
    private final Paint unfocus;
    private final Paint transparent;
    private final boolean autoRemove;
    private Paint error;
    private boolean show;

    /**
     * Конструктор.
     *
     * @param jfxTextField Текстовое поле.
     * @param autoRemove Автоудаление ошибки.
     */

    public TextError(JFXTextField jfxTextField, boolean autoRemove) {
        this.jfxTextField = jfxTextField;
        this.focus = jfxTextField.getFocusColor();
        this.unfocus = jfxTextField.getUnFocusColor();
        this.error = Color.valueOf("#b71c1c");
        this.transparent = Color.valueOf("transparent");
        this.autoRemove = autoRemove;
    }

    /**
     * Показать ошибку.
     */

    public void show() {
        //Ставим цвета, регистрируем ивент.
        Platform.runLater(() -> {
            jfxTextField.setFocusColor(error);
            if (jfxTextField.getUnFocusColor() != transparent) {
                jfxTextField.setUnFocusColor(transparent);
            }
            jfxTextField.requestFocus();
            show = true;
            if (autoRemove) {
                jfxTextField.setOnKeyReleased(keyEvent -> undo());
            }
        });
    }

    /**
     * Убрать ошибку.
     */

    public void undo() {
        //Ставим цвета назад.
        jfxTextField.setFocusColor(focus);
        jfxTextField.setUnFocusColor(unfocus);
        show = false;
    }

    /**
     * Возвращает значение true если ошибка уже показана.
     */

    public boolean isShow() {
        return show;
    }

    /**
     * Установить цвет ошибки.
     *
     * @param paint Цвет.
     */

    public void setErrorColor(Paint paint) {
        this.error = paint;
    }

    /**
     * Получить цвет ошибки.
     *
     * @return Цвет.
     */

    public Paint getErrorColor() {
        return error;
    }

}
