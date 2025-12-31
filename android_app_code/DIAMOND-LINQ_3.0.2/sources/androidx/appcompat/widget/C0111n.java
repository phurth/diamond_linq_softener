package androidx.appcompat.widget;

import a.a.a.a.a;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import android.widget.TextView;
import androidx.core.widget.j;

/* renamed from: androidx.appcompat.widget.n  reason: case insensitive filesystem */
public class C0111n extends CheckedTextView {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f623a = {16843016};

    /* renamed from: b  reason: collision with root package name */
    private final L f624b;

    public C0111n(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        L l = this.f624b;
        if (l != null) {
            l.a();
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        r.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(a.b(getContext(), i));
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(j.a((TextView) this, callback));
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        L l = this.f624b;
        if (l != null) {
            l.a(context, i);
        }
    }

    public C0111n(Context context, AttributeSet attributeSet, int i) {
        super(wa.a(context), attributeSet, i);
        this.f624b = new L(this);
        this.f624b.a(attributeSet, i);
        this.f624b.a();
        za a2 = za.a(getContext(), attributeSet, f623a, i, 0);
        setCheckMarkDrawable(a2.b(0));
        a2.a();
    }
}
