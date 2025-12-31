package a.g.i.a;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

public final class a extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    private final int f208a;

    /* renamed from: b  reason: collision with root package name */
    private final c f209b;
    private final int c;

    public a(int i, c cVar, int i2) {
        this.f208a = i;
        this.f209b = cVar;
        this.c = i2;
    }

    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f208a);
        this.f209b.a(this.c, bundle);
    }
}
