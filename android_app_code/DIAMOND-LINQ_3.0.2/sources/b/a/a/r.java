package b.a.a;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

/* compiled from: lambda */
public final /* synthetic */ class r implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ V f1178a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ EditText f1179b;
    private final /* synthetic */ RadioButton c;

    public /* synthetic */ r(V v, EditText editText, RadioButton radioButton) {
        this.f1178a = v;
        this.f1179b = editText;
        this.c = radioButton;
    }

    public final void onClick(View view) {
        this.f1178a.a(this.f1179b, this.c, view);
    }
}
