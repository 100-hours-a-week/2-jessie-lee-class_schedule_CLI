import java.util.List;

public class Parent extends Member{
    private List<Child> children;

    Parent(String name) {
        super(name, false);
    }

    public void addChildren(String name) {
        this.children.add(new Child(name));
    }
}
