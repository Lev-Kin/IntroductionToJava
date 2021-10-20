package u06finish.tasks.library.entitys;

public enum PersonAccess {
    ADMIN("admin"), USER("user");

    private String name;

    PersonAccess(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
