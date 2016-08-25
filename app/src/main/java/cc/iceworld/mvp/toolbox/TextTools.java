package cc.iceworld.mvp.toolbox;

/**
 * Created by cxx on 16-7-21.
 * xx.ch@outlook.com
 */
public class TextTools {

    public static boolean isEmpty(CharSequence text) {
        return text == null || text.length() == 0;
    }

    private TextTools() {
        throw new AssertionError("no instance");
    }
}
