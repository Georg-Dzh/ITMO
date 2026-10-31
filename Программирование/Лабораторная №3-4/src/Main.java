import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Mood moodGulkin;
        Mood moodKonndashkin;
        if (Math.random()<0.5){
            moodGulkin=Mood.ANGRY;
        } else {
            moodGulkin=Mood.CALM;
        }
        if (Math.random()<0.5){
            moodKonndashkin=Mood.ANGRY;
        } else {
            moodKonndashkin=Mood.CALM;
        }

        Policeman kozlov = new Policeman("Козлов", Opinion.MILITIA, Mood.CALM);
        Journalist kondrashkin = new Journalist("Кондрашкин", Opinion.SOCIETY, moodKonndashkin);
        Journalist gulkin = new Journalist("Гулькин", Opinion.NEUTRAL, moodGulkin);
        Vetrogon vertoprah = new Vetrogon("Вертопрах", Opinion.SOCIETY, Mood.CALM);

        ArrayList<Personage> list = new ArrayList<>();
        list.add(kozlov);
        list.add(kondrashkin);
        list.add(gulkin);
        list.add(vertoprah);

        Item bucket = new WaterBucket("Ведро с водой");
        Item paper = new Newspaper("Коротышкины Вести");
        Item brokenBucket = new WaterBucket("Сломанное ведро");
        Article sampleArticle = new Article("О порядка на улицах", "Нам нужен тотальный контроль над ветрогонами!", "Редакция");

        System.out.println("\nПЕРСОНАЖИ\n");
        for (Personage p : list) {
            System.out.println(p);
        }
        System.out.println("\nЧТО ДЕЛАЮТ СЕГОДНЯ\n");
        for (Personage p : list) {
            // 1. Каждый пытается выполнить свой долг
            try {
                p.performDuty();
            } catch (MoodException e) {
                System.out.println("Внимание: " + p.getName() + " не смог выполнить долг (" + e.getMessage() + ")");
            }

            // 2. Проверяем специфическое поведение персонажей
            if (p instanceof Journalist journalist) {
                try {
                    if (journalist.getMood() == Mood.CALM) {
                        journalist.writeArticle(paper, sampleArticle);
                    } else {
                        System.out.println(p.getName() + " отказывается делать статью");
                    }
                } catch (Exception e) {
                    System.out.println("Ошибка при публикации: " + e.getMessage());
                }
            }
            else if (p instanceof Vetrogon vetrogon) {
                // Выбираем случайную цель для обливания
                Journalist targetjournalist;
                if (Math.random() < 0.5) {
                    targetjournalist = kondrashkin;
                } else {
                    targetjournalist = gulkin;
                }

                // Выбираем случайное ведро
                if (Math.random() < 0.5) {
                    vetrogon.useItem(bucket, targetjournalist);
                } else {
                    try {
                        vetrogon.useItem(brokenBucket, targetjournalist);
                    } catch (InvalidItemException e) {
                        System.out.println("У Ветрогона " + p.getName() + " НЕ получилось облить " + targetjournalist.getName() + ", так как " + e.getMessage());
                    }
                }
            }

            System.out.println();
        }
    }
}
