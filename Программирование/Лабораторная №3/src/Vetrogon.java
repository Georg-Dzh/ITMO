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
        String targetName = "персонажа";
        if (target instanceof AbstractCharacter character) {
            targetName = character.getName();
        }
        try {
            super.useItem(item, target);
            if (item instanceof Pourable) {
                System.out.println("Ветрогон " + getName() + " обливает персонажа " + targetName + " из объекта: " + item.getTitle());
                target.changeMood(Mood.ANGRY);
            }
        } catch (InvalidItemException e) {
            System.out.println("У Ветрогона " + getName() + " не получилось облить персонажа: " + targetName + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Ветрогон " + getName() + " (Мнение: " + getOpinion() + ", Настроение: " + getMood() + ")";
    }
}