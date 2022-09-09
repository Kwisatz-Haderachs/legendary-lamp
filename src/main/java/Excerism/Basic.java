package Excerism;

import javax.lang.model.element.Element;

public class Basic {

    class ResistorColor {
        enum Color {
            BLACK("black", 0),
            BROWN("brown", 1),
            RED ("red", 2),
            ORANGE ("orange", 3),
            YELLOW ("yellow", 4),
            GREEN("green", 5),
            BLUE("blue", 6),
            VIOLET ("violet", 7),
            GREY ("grey", 8),
            WHITE ("white", 9);

            public final String color;
            public final int num;
            Color(String color, int i) {
                this.color = color;
                this.num = i;
            }

            public String getColor(int i) {

                return color;
            }
        }
        int colorCode(String color) {
            for (Color c: Color.values()) {
                if(color.equals(c.color)){
                    return c.num;
                }
            }
            return 0;
        }

        String[] colors() {
            String[] colors = new String[10];
            int i = 0;
            for (Color c: Color.values()) {
                colors[i] = c.color;
                i++;
            }
            return colors;
        }
    }
}
