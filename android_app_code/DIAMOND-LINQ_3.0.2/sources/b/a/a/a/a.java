package b.a.a.a;

import android.content.DialogInterface;
import android.view.Window;
import androidx.fragment.app.C0134j;

/* compiled from: lambda */
public final /* synthetic */ class a implements DialogInterface.OnShowListener {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ c f1063a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Window f1064b;
    private final /* synthetic */ C0134j c;

    public /* synthetic */ a(c cVar, Window window, C0134j jVar) {
        this.f1063a = cVar;
        this.f1064b = window;
        this.c = jVar;
    }

    public final void onShow(DialogInterface dialogInterface) {
        this.f1063a.a(this.f1064b, this.c, dialogInterface);
    }
}
