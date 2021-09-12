package menu;

public interface MenuItem {
    default void execute() {}
    String getDescription();
    boolean isFinalAction();
    default boolean isDelayed() {
        return false;
    }

    static MenuItem create(String description, Runnable execution, boolean isFinalAction, boolean isDelayed) {
        return new MenuItem() {
            @Override
            public void execute() {
                execution.run();
            }

            @Override
            public String getDescription() {
                return description;
            }

            @Override
            public boolean isFinalAction() {
                return isFinalAction;
            }

            @Override
            public boolean isDelayed() {
                return isDelayed;
            }
        };
    }
}
