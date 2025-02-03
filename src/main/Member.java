public class Member {
    private String name;
    private boolean isAdmin;

    Member(String name) {
        this.name = name;
    }

    Member(String name, boolean isAdmin) {
        this.name = name;
        this.isAdmin = isAdmin;
    }

    public boolean getIsAdmin() {
        return this.isAdmin;
    }

    public String getName() {
        return this.name;
    }
}