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

    public Child getChildByName(String childName) {
        return children.stream()
                .filter(c -> c.getName().equalsIgnoreCase(childName))
                .findFirst()
                .orElse(null);
    }

    public boolean hasChildWithName(String childName) {
        return children.stream().anyMatch(child -> child.getName().equals(childName));
    }
}
