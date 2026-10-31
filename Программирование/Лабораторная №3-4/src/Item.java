public abstract class Item {
    private String title;

    public Item(String title){
        this.title=title;
    }

    public String getTitle(){
        return title;
    }
    @Override
    public boolean equals(Object o){
        return (o instanceof Item target) && getClass()==o.getClass() && title.equals(target.title);
    }
    @Override
    public int hashCode() {
        return title.hashCode();
    }
    @Override
    public String toString() {
        return "Предмет: " + title;
    }
}
