package App;

import java.util.List;

public class Theater {
    private String name;
    private String location;
    private List<Screen> screens;

    public Theater(String name, String location, List<Screen> screens) {
        this.name = name;
        this.location = location;
        this.screens = screens;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public List<Screen> getScreens() {
        return screens;
    }
}
