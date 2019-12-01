package ee.sda.interfaces;

public class GenericBoxForTwoItems <T, S> {

    private T firstItem;
    private S secondItem;

    public T getFirstItem() {
        return firstItem;
    }

    public void setFirstItem(T firstItem) {
        this.firstItem = firstItem;
    }

    public S getSecondItem() {
        return secondItem;
    }

    public void setSecondItem(S secondItem) {
        this.secondItem = secondItem;
    }
}
