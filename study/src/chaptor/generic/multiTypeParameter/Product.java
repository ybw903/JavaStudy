package chaptor.generic.multiTypeParameter;

public class Product<T,M> {
    private T kind;
    private M Model;

    public T getKind() {
        return kind;
    }

    public void setKind(T kind) {
        this.kind = kind;
    }

    public M getModel() {
        return Model;
    }

    public void setModel(M model) {
        Model = model;
    }
}
