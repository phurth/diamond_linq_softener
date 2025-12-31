package me.relex.circleindicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.snackbar.Snackbar$SnackbarLayout;
import java.util.List;

public class SnackbarBehavior extends CoordinatorLayout.b<a> {
    public SnackbarBehavior() {
    }

    public SnackbarBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean a(CoordinatorLayout coordinatorLayout, a aVar, View view) {
        return view instanceof Snackbar$SnackbarLayout;
    }

    public boolean b(CoordinatorLayout coordinatorLayout, a aVar, View view) {
        aVar.setTranslationY(a(coordinatorLayout, aVar));
        return true;
    }

    private float a(CoordinatorLayout coordinatorLayout, a aVar) {
        List<View> b2 = coordinatorLayout.b((View) aVar);
        int size = b2.size();
        float f = 0.0f;
        for (int i = 0; i < size; i++) {
            View view = b2.get(i);
            if ((view instanceof Snackbar$SnackbarLayout) && coordinatorLayout.a((View) aVar, view)) {
                f = Math.min(f, view.getTranslationY() - ((float) view.getHeight()));
            }
        }
        return f;
    }
}
