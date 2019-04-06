package ua.oxooocb.fxlib.animations;

import javafx.scene.effect.*;
import javafx.scene.layout.*;
import java.util.*;

public class ApplicationLoadingAnimation {

    //Эффект для анимации.
    private BoxBlur boxBlur;
    //Панель для установки эффекта.
    private final Pane pane;
    //Хлам для настройки анимации.
    private final int wait;
    private final int repeat;
    private final Timer timer;

    /**
     * Конструктор.
     *
     * @param pane Панель.
     * @param wait Время ожидания до старта таймера. (мс)
     * @param repeat Время повтора таймера. (мс)
     */

    public ApplicationLoadingAnimation(Pane pane, int wait, int repeat) {
        this.pane = pane;
        this.boxBlur = new BoxBlur();
        this.wait = wait;
        this.repeat = repeat;
        this.timer = new Timer();
        boxBlur.setHeight(9.11);
        boxBlur.setWidth(9.11);
        boxBlur.setIterations(2);
    }

    /**
     * Запустить анимацию.
     */

    public synchronized void play() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (boxBlur.getHeight() == 9.11) {
                    if (boxBlur.getWidth() == 9.11) {
                        pane.setEffect(boxBlur);
                        boxBlur.setWidth(8.11);
                        boxBlur.setHeight(8.11);
                        return;
                    }
                } if (boxBlur.getHeight() == 8.11) {
                    if (boxBlur.getWidth() == 8.11) {
                        boxBlur.setWidth(7.11);
                        boxBlur.setHeight(7.11);
                        return;
                    }
                } if (boxBlur.getHeight() == 7.11) {
                    if (boxBlur.getWidth() == 7.11) {
                        boxBlur.setWidth(6.11);
                        boxBlur.setHeight(6.11);
                        return;
                    }
                } if (boxBlur.getHeight() == 6.11) {
                    if (boxBlur.getWidth() == 6.11) {
                        boxBlur.setWidth(5.11);
                        boxBlur.setHeight(5.11);
                        return;
                    }
                } if (boxBlur.getHeight() == 5.11) {
                    if (boxBlur.getWidth() == 5.11) {
                        boxBlur.setWidth(4.11);
                        boxBlur.setHeight(4.11);
                        return;
                    }
                } if (boxBlur.getHeight() == 4.11) {
                    if (boxBlur.getWidth() == 4.11) {
                        boxBlur.setWidth(3.11);
                        boxBlur.setHeight(3.11);
                        return;
                    }
                } if (boxBlur.getHeight() == 3.11) {
                    if (boxBlur.getWidth() == 3.11) {
                        boxBlur.setWidth(2.11);
                        boxBlur.setHeight(2.11);
                        return;
                    }
                } if (boxBlur.getHeight() == 2.11) {
                    if (boxBlur.getWidth() == 2.11) {
                        boxBlur.setWidth(1.11);
                        boxBlur.setHeight(1.11);
                        return;
                    }
                } if (boxBlur.getHeight() == 1.11) {
                    if (boxBlur.getWidth() == 1.11) {
                        stop();
                    }
                }
            }
        }, wait, repeat);
    }

    /**
     * Остановить анимацию.
     */

    public void stop() {
        boxBlur = null;
        //Убираем эффекты.
        pane.setEffect(null);
        //Отменяем работу таймера.
        timer.cancel();
    }


}
