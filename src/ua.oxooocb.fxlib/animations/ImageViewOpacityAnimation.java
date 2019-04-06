package ua.oxooocb.fxlib.animations;

import javafx.scene.image.*;
import java.util.*;

public class ImageViewOpacityAnimation {

    //Для изображения.
    private final ImageView image;
    private final double opacity;
    //Хлам для настройки анимации.
    private final int wait;
    private final int repeat;
    private final Timer timer;

    /**
     * Конструктор.
     *
     * @param image Изображение.
     * @param wait Время ожидания до старта таймера. (мс)
     * @param repeat Время повтора таймера. (мс)
     */

    public ImageViewOpacityAnimation(ImageView image, int wait, int repeat) {
        this.image = image;
        this.opacity = image.getOpacity();
        this.wait = wait;
        this.repeat = repeat;
        this.timer = new Timer();
    }

    /**
     * Запустить анимацию.
     */

    public synchronized ImageViewOpacityAnimation play() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (double i = 2.0; i > opacity; i--) {
                    image.setOpacity(i);
                }
            }
        }, wait, repeat);
        return this;
    }

    /**
     * Остановить анимацию.
     */

    public void stop() {
        //Устанавливаем стандартный параметр для imageOpacity.
        image.setOpacity(opacity);
        //Отменяем работу таймера.
        timer.cancel();
    }

}
