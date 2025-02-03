import java.util.ArrayList;
import java.util.List;

public class Parent extends Member{
    private List<Child> children;

    Parent(String name) {
        super(name, false);
        this.children = new ArrayList<>();
    }

    public void addChild(String childName) {
        this.children.add(new Child(childName));
    }
}
