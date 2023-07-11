import java.util.Iterator;

public class ToShareIterator implements Iterator<Product> {
    private Iterator<Product> iterator;

    public ToShareIterator(ToShare toShare) {
        this.iterator = toShare.products.values().iterator();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public Product next() {
        return iterator.next();
    }

    public void remove() {
        iterator.remove();
    }
}
