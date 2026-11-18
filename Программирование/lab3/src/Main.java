import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        class Message implements Printable {
            private final String text;

            Message(String text) {
                this.text = text;
            }

            @Override
            public String getPrintText() {
                return text;
            }
        }

        Mood moodGulkin;
        if (Math.random() < 0.5) {
            moodGulkin = Mood.ANGRY;
        } else {
            moodGulkin = Mood.CALM;
        }
        Mood moodKondrashkin;
        if (Math.random() < 0.5) {
            moodKondrashkin = Mood.ANGRY;
        } else {
            moodKondrashkin = Mood.CALM;
        }
        Mood moodKozlov;
        if (Math.random() < 0.5) {
            moodKozlov = Mood.ANGRY;
        } else {
            moodKozlov = Mood.CALM;
        }

        Printer printer = new ConsolePrinter();
        Newspaper paper = new Newspaper("Коротышкины Вести");
        WaterBucket bucket = new WaterBucket("Ведро с водой", printer);

        Policeman kozlov = new Policeman("Козлов", Opinion.MILITIA, moodKozlov, printer);
        Journalist kondrashkin = new Journalist("Кондрашкин", Opinion.SOCIETY, moodKondrashkin, printer, paper);
        Journalist gulkin = new Journalist("Гулькин", Opinion.NEUTRAL, moodGulkin, printer, paper);
        Vetrogon vertoprah = new Vetrogon("Вертопрах", Opinion.SOCIETY, Mood.CALM, printer);

        ArrayList<AbstractCharacter> list = new ArrayList<>();
        list.add(kozlov);
        list.add(kondrashkin);
        list.add(gulkin);
        list.add(vertoprah);

        printer.print(new Message("\nПЕРСОНАЖИ\n"));
        for (AbstractCharacter p : list) {
            printer.print(p);
        }

        printer.print(new Message("\nЗАПУСК СЦЕНАРИЯ"));
        for (AbstractCharacter p : list) {
            printer.print(new Message(""));
            try {
                p.performDuty();
            } catch (MoodException e) {
                printer.print(new Message("Внимание: " + p.getName() + " не смог выполнить долг. " + e.getMessage()));
            }
        }

        printer.print(new Message("\nВЗАИМОДЕЙСТВИЕ С ПРЕДМЕТАМИ\n"));
        Journalist randomJournalist;
        if (Math.random() < 0.5) {
            randomJournalist = kondrashkin;
        } else {
            randomJournalist = gulkin;
        }

        WaterBucket randomBucket;
        if (Math.random() < 0.5) {
            randomBucket = bucket;
        } else {
            randomBucket = null;
        }
        vertoprah.useItem(randomBucket, randomJournalist);
    }
}