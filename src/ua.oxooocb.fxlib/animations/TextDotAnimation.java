package ua.oxooocb.fxlib.animations;

import javafx.scene.text.*;
import java.util.*;

public class TextDotAnimation {

    //Текст для анимации.
    private Text text;
    //Первоначальный текст.
    private final String string;
    //Хлам для настройки анимации.
    private final int wait;
    private final int repeat;
    private final Timer timer;

    /**
     * Конструктор.
     *
     * @param text Текст.
     * @param wait Время ожидания до старта таймера. (мс)
     * @param repeat Время повтора таймера. (мс)
     */

    public TextDotAnimation(Text text, int wait, int repeat) {
        this.text = text;
        this.string = text.getText();
        this.wait = wait;
        this.repeat = repeat;
        this.timer = new Timer();
    }

    /**
     * Запустить анимацию.
     */

    public synchronized void play() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (text.getText().endsWith("...")) {
                    text.setText(string);
                    return;
                }
                text.setText(text.getText() + ".");
            }
        }, wait, repeat);
    }

    /**
     * Остановить анимацию.
     */

    public void stop() {
        //Ставим первоначальный текст.
        text.setText(string);
        //Отменяем работу таймера.
        timer.cancel();
    }


}
