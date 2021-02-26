package helpers;

public interface Transformer<T> {
    <E> T transformTo(E type);
}
