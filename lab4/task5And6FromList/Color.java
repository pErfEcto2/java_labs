package lab4.task5And6FromList;


/*
Private конструктор enum - это важная языковая гарантия, которая:
    Сохраняет концепцию фиксированного набора значений
    Обеспечивает безопасность типов
    Предотвращает несанкционированное создание экземпляров
        (Все возможные значения enum определяются строго внутри самого enum на этапе компиляции.
         Никакой внешний код не может:
            Создать новый экземпляр enum через new
            Добавить новое значение в перечисление в runtime)
    Позволяет компилятору оптимизировать работу с enum
 */

public enum Color {
    RED("#FF0000", "RED"),
    GREEN("#00FF00", "GREEN");

    private final String hexCode;
    private final String name;

    Color(String hexCode, String name) {
        this.hexCode = hexCode;
        this.name = name;
    }

    public String getHexCode() { return hexCode; }
    public String getName() { return name; }
}
