package ee.sda.interfaces;

public class GenericBoxForTwoItems <T, S> extends GenericBox<T> {


    private S secondItem;


    public S getSecondItem() {
        return secondItem;
    }

    public void setSecondItem(S secondItem) {
        this.secondItem = secondItem;
    }
}
