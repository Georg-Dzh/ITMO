public class Vetrogon extends AbstractCharacter {
    public Vetrogon(String name, Opinion opinion, Mood mood) {
        super(name, opinion, mood);
    }

    @Override
    public void performDuty(ConsolePrinter printer) {
        printer.print(new Printable() {
            @Override
            public String getPrintText() {
                return "Ветрогон " + getName() + " устраивает беспорядок на улице.";
            }
        });
    }

    @Override
    public void useItem(AbstractItem item, Emotionable target) {
        ConsolePrinter printer = new ConsolePrinter();
        final String targetName;
        if (target instanceof AbstractCharacter character) {
            targetName = character.getName();
        } else {
            targetName = "персонажа";
        }
        try {
            super.useItem(item, target);
            if (item instanceof Pourable) {
                printer.print(new Printable() {
                    @Override
                    public String getPrintText() {
                        return "Ветрогон " + getName() + " обливает " + targetName + " из объекта: " + item.getTitle();
                    }
                });

                ((Pourable) item).pour();
                target.changeMood(Mood.ANGRY);
            }
        } catch (InvalidItemException e) {
            printer.print(new Printable() {
                @Override
                public String getPrintText() {
                    return "У Ветрогона " + getName() + " не получилось облить " + targetName + ": " + e.getMessage();
                }
            });
        }
    }

    @Override
    public String toString() {
        return "Ветрогон " + getName() + " (Мнение: " + getOpinion() + ", Настроение: " + getMood() + ")";
    }
}