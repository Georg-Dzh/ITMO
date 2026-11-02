import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Mood moodGulkin;
        Mood moodKondrashkin;
        Mood moodKozlov;
        if (Math.random()<0.5){
            moodGulkin=Mood.ANGRY;
        } else {
            moodGulkin=Mood.CALM;
        }
        if (Math.random()<0.5){
            moodKondrashkin=Mood.ANGRY;
        } else {
            moodKondrashkin=Mood.CALM;
        }
        if (Math.random()<0.5){
            moodKozlov=Mood.ANGRY;
        } else {
            moodKozlov=Mood.CALM;
        }
        Policeman kozlov = new Policeman("Козлов", Opinion.MILITIA, moodKozlov);
        Journalist kondrashkin = new Journalist("Кондрашкин", Opinion.SOCIETY, moodKondrashkin);
        Journalist gulkin = new Journalist("Гулькин", Opinion.NEUTRAL, moodGulkin);
        Vetrogon vertoprah = new Vetrogon("Вертопрах", Opinion.SOCIETY, Mood.CALM);

        ArrayList<AbstractCharacter> list = new ArrayList<>();
        list.add(kozlov);
        list.add(kondrashkin);
        list.add(gulkin);
        list.add(vertoprah);

        Newspaper paper = new Newspaper("Коротышкины Вести");
        WaterBucket bucket = new WaterBucket("Ведро с водой");
        WaterBucket brokenBucket = new WaterBucket("Сломанное ведро");

        System.out.println("\nПЕРСОНАЖИ\n");
        for (AbstractCharacter p : list) {
            System.out.println(p);
        }

        System.out.println("\nЗАПУСК СЦЕНАРИЯ\n");
        for (AbstractCharacter p : list) {
            try {
                p.performDuty();
            } catch (MoodException e) {
                System.out.println("Внимание: " + p.getName() + " не смог выполнить долг, так как он " + e.getMessage());
            }
            if (p instanceof Journalist journalist) {
                if (journalist.getMood() == Mood.CALM) {
                    try {
                        journalist.writeArticle(paper, "беспорядок на улицах", "Нам нужен тотальный контроль над ветрогонами!");
                    } catch (Exception e) {
                        System.out.println("Ошибка при публикации: " + e.getMessage());
                    }
                }
            }
            else if (p instanceof Vetrogon vetrogon) {
                Journalist targetJournalist;
                if (Math.random() < 0.5){
                    targetJournalist=kondrashkin;
                } else {
                    targetJournalist=gulkin;
                }
                if (Math.random() < 0.5) {
                    vetrogon.useItem(bucket, targetJournalist);
                } else {
                    try {
                        vetrogon.useItem(brokenBucket, targetJournalist);
                    } catch (InvalidItemException e) {
                        System.out.println("У Ветрогона " + vetrogon.getName() + " НЕ получилось облить " + targetJournalist.getName() + ", причина: " + e.getMessage());
                    }
                }
            }
        }
    }
}
