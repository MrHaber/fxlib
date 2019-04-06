package ua.oxooocb.fxlib.controller;

public class ControllerManager {

    /**
     * Зарегистрировать с помощью синхронизации все контроллеры которые есть в хеше в многопоточном режиме.
     */

    public synchronized static void registerControllers() {
        //Если число i меньше чем размер controllerIntegerHashMap тогда добавляем 1.
        for (int i = 0; i < ControllerWrapper.size(); i++) {
            //Регистрируем контроллеры. (Число из цикла это номер текущего контроллера для регистрации)
            try {
                ControllerWrapper.get(i).register();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Зарегистрировать с помощью синхронизации контроллеры которые находятся от начала числа и до его конца.
     *
     * @param start Начало ячейки.
     * @param end Конец ячейки.
     */

    public static synchronized void registerControllers(int start, int end) {
        //Если число 'поиска' меньше чем число окончания тогда добавляем 1.
        for (int i = start; i < end; i++) {
            //Регистрируем контроллеры. (Число из цикла это номер текущего контроллера для регистрации)
            try {
                ControllerWrapper.get(i).register();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Зарегистрировать с помощью синхронизации контроллер.
     *
     * @param num Ячейка в хеше.
     */

    public static synchronized void registerController(Integer num) {
        //Регистрируем контроллер. (Число из цикла это номер текущего контроллера для регистрации)
        try {
            ControllerWrapper.get(num).register();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Удалить контроллеры из хеша с помощью синхронизации.
     */

    public static void deleteControllers() {
        //Если число i меньше чем размер controllerIntegerHashMap тогда добавляем 1.
        for (int i = 0; i < ControllerWrapper.size(); i++) {
            //Указываем на ячейку и удаляем её.
            ControllerWrapper.remove(i);
        }
    }

    /**
     * Удалить с помощью синхронизации контроллеры которые находятся от начала числа и до его конца.
     *
     * @param start Начало ячейки.
     * @param end Конец ячейки.
     */

    public static void deleteControllers(int start, int end) {
        //Если число 'поиска' меньше чем число окончания тогда добавляем 1.
        for (int i = start; i < end; i++) {
            //Указываем на ячейку и удаляем её.
            ControllerWrapper.remove(i);
        }
    }

    /**
     * Удалить контроллер из хеша.
     *
     * @param num Ячейка в хеше.
     */

    public static void deleteController(Integer num) {
        //Указываем на ячейку и удаляем её.
        ControllerWrapper.remove(num);
    }


}
