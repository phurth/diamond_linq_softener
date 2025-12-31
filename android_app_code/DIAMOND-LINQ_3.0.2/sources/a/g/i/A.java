package a.g.i;

import a.g.b;
import android.os.Build;
import android.view.ViewGroup;

public final class A {
    public static boolean a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 21) {
            return viewGroup.isTransitionGroup();
        }
        Boolean bool = (Boolean) viewGroup.getTag(b.tag_transition_group);
        return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && y.s(viewGroup) == null) ? false : true;
    }
}
