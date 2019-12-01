package ee.sda.interfaces;

public class Box {

    private Object item;



    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }


    @Override
    public String toString() {
        return "Box{" +
                "item=" + item +
                '}';
    }
}
