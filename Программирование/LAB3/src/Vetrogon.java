public class Vetrogon extends AbstractCharacter {
    public Vetrogon(String name, Opinion opinion, Mood mood) {
        super(name, opinion, mood);
    }

    @Override
    public void performDuty() {
        System.out.println("Ветрогон " + getName() + " устраивает беспорядок на улице.");
    }

    @Override
    public void useItem(AbstractItem item, Emotionable target) {
        try {
            super.useItem(item, target);
            if (item instanceof Pourable pourableItem) {
                String targetName = "персонажа";
                if (target instanceof AbstractCharacter character) {
                    targetName = character.getName();
                }
                System.out.println("Ветрогон " + getName() + " обливает персонажа " + targetName + " из объекта: " + item.getTitle());
                target.changeMood(Mood.ANGRY);
            }
        } catch (InvalidItemException e) {
            String targetName = "персонажа";
            if (target instanceof AbstractCharacter character) {
                targetName = character.getName();
            }
            System.out.println("У Ветрогона " + getName() + " НЕ получилось облить " + targetName + ", причина: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Ветрогон " + getName() + " (Мнение: " + getOpinion() + ", Настроение: " + getMood() + ")";
    }
}
