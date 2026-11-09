import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
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

        ConsolePrinter printer = new ConsolePrinter();
        Newspaper paper = new Newspaper("Коротышкины Вести");
        WaterBucket bucket = new WaterBucket("Ведро с водой");
        WaterBucket brokenBucket = new WaterBucket("Сломанное ведро");

        Policeman kozlov = new Policeman("Козлов", Opinion.MILITIA, moodKozlov);
        Journalist kondrashkin = new Journalist("Кондрашкин", Opinion.SOCIETY, moodKondrashkin, paper);
        Journalist gulkin = new Journalist("Гулькин", Opinion.NEUTRAL, moodGulkin, paper);
        Vetrogon vertoprah = new Vetrogon("Вертопрах", Opinion.SOCIETY, Mood.CALM);

        ArrayList<AbstractCharacter> list = new ArrayList<>();
        list.add(kozlov);
        list.add(kondrashkin);
        list.add(gulkin);
        list.add(vertoprah);


        printer.print(new Printable() {
            @Override
            public String getPrintText() {
                return "\nПЕРСОНАЖИ\n";
            }
        });

        for (AbstractCharacter p : list) {
            printer.print(p);
        }

        printer.print(new Printable() {
            @Override
            public String getPrintText() {
                return "\nЗАПУСК СЦЕНАРИЯ";
            }
        });

        for (AbstractCharacter p : list) {
            System.out.println();

            try {
                p.performDuty(printer);
            } catch (MoodException e) {
                printer.print(new Printable() {
                    @Override
                    public String getPrintText() {
                        return "Внимание: " + p.getName() + " не смог выполнить долг. " + e.getMessage();
                    }
                });
            }
        }

        printer.print(new Printable() {
            @Override
            public String getPrintText() {
                return "\nВЗАИМОДЕЙСТВИЕ С ПРЕДМЕТАМИ\n";
            }
        });

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
            randomBucket = brokenBucket;
        }
        vertoprah.useItem(randomBucket, randomJournalist);
    }
}