package exercise;

import java.util.HashSet;
import java.util.Set;

public class ColorBag {

    private Set<String> colors = new HashSet<>();

    public void addColor(String color)
    {
        colors.add(color);
    }

    public void removeColor(String color)
    {

        colors.remove(color);
    }

    public boolean isBagEmpty()
    {

        return colors.isEmpty();
    }

    public boolean containsColor(String color)
    {

        return colors.contains(color);
    }

    public int size()
    {
        return colors.size();
    }
}
