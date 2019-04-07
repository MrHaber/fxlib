package ua.oxooocb.fxlib.utils;

import javafx.application.*;
import javafx.fxml.*;
import javax.imageio.*;
import java.awt.*;
import java.io.*;
import ua.oxooocb.fxlib.stage.StageBuilder;

public class StageUtils {

    /**
     * Создать приложение с кастомным контроллером.
     *
     * @param fxmlLoader Загрузчик приложения.
     * @param title Титл.
     * @param width Ширина.
     * @param height Высота.
     * @param css CSS.
     * @param icon Иконка.
     * @param runnable Кастомная загрузка контроллера.
     */

    public static void createApplication(FXMLLoader fxmlLoader, String title, double width, double height, String css, InputStream icon, Runnable runnable) {
        //Запускаем от прав платформы.
        Platform.runLater(() -> {
            //Исключение.
            try {
                new StageBuilder().
                        //Создаем приложение.
                                create(fxmlLoader).
                        //Ставим титл.
                                setTitle(title).
                        //Ставим размер.
                                setSize(width, height).
                        //Добавить иконку.
                                addIcon(icon).
                        //Добавить CSS.
                                addCSS(css).
                        //Загружаем стиль.
                                initStyle().
                        //Загружаем контроллер и билдим.
                                loadCustomController(runnable).build();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Создать приложение с кастомным контроллером.
     *
     * @param fxmlLoader Загрузчик приложения.
     * @param title Титл.
     * @param width Ширина.
     * @param height Высота.
     * @param css CSS.
     * @param icon Иконка.
     * @param registerController Зарегистрировать ли контроллер.
     */

    public static void createApplication(FXMLLoader fxmlLoader, String title, double width, double height, String css, InputStream icon, boolean registerController) {
        //Запускаем от прав платформы.
        Platform.runLater(() -> {
            //Исключение.
            try {
                new StageBuilder().
                        //Создаем приложение.
                                create(fxmlLoader).
                        //Ставим титл.
                                setTitle(title).
                        //Ставим размер.
                                setSize(width, height).
                        //Добавить иконку.
                                addIcon(icon).
                        //Добавить CSS.
                                addCSS(css).
                        //Загружаем стиль.
                                initStyle().
                        //Загружаем контроллер и билдим.
                                registerController(registerController).build();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Добавить иконку в трей.
     *
     * @param next Ячейка в хеше.
     * @param string Текст иконки.
     * @param image InputStream иконки.
     * @param action Действие при нажатии.
     */

    public static void addIconToTray(int next, String string, InputStream image, Runnable action) {
        //Исключение.
        try {
            //Отменяем выход при помощи hide.
            Platform.setImplicitExit(false);
            //Инициализация классов.
            SystemTray systemTray = SystemTray.getSystemTray();
            PopupMenu popup = new PopupMenu();
            MenuItem close = new MenuItem("Закрыть");
            //Добавляем ивент. (Если нажимают на "Закрыть" то выходим из приложения)
            close.addActionListener(e -> Platform.runLater(action::run));
            //Добавляем итемы к слушателю.
            popup.add(close);
            //Конструируем иконку.
            TrayIcon icon = new TrayIcon(ImageIO.read(image), string, popup);
            //Добавляем иконку в трей.
            systemTray.add(icon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
