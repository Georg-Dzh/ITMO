public abstract class AbstractItem {
    private final String title;

    public AbstractItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        AbstractItem target = (AbstractItem) o;
        return title.equals(target.title);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(title);
    }

    @Override
    public String toString() {
        return "Предмет: " + title;
    }
}
