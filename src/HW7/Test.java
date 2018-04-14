package HW7;

public class Test {
    public static void main(String[] args) {

        //Создать класс Зачетная Книжка с внутренним классом, с помощью объек-
        //тов которого можно хранить информацию о сессиях, зачетах, экзаменах.
        Zachetka ychenik1 = new Zachetka(1111, "Механический факультет",
                "Michael Jordan");
        String exam[] = {"Высшая математика", "ТАУ"};
        int evaluation[] = {-1, 5};
        ychenik1.setExams(exam, evaluation);
        System.out.println(ychenik1);
    }

}
