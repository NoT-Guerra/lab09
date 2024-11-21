package it.unibo.mvc;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 *
 */
public final class SimpleController implements Controller {

    private final List<String> stringHistory = new LinkedList<>();
    private String nextString;

    @Override
    public void  setNextString(final String nextString) {
        this.nextString= Objects.requireNonNull(nextString);
    }

    @Override
    public String getNextString() {
        return this.nextString;
    }

    @Override
    public List<String> getPrintedString() {
        return null;
    }

    @Override
    public void printCurrentString() {
        if (this.nextString == null) {
            throw new IllegalStateException("There is no string set");
        }
        stringHistory.add(this.nextString);
        System.out.println(this.nextString); // NOPMD
    }

    public List<String> getStringHistory() {
        return stringHistory;
    }
}
