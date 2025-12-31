package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ToggleButton;

public class O extends ToggleButton {

    /* renamed from: a  reason: collision with root package name */
    private final L f543a;

    public O(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842827);
    }

    public O(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f543a = new L(this);
        this.f543a.a(attributeSet, i);
    }
}
