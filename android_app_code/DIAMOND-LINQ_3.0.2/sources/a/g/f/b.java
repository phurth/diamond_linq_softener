package a.g.f;

import a.g.f.f;
import android.content.Context;
import android.graphics.Typeface;
import java.util.concurrent.Callable;

class b implements Callable<f.c> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f147a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f148b;
    final /* synthetic */ int c;
    final /* synthetic */ String d;

    b(Context context, a aVar, int i, String str) {
        this.f147a = context;
        this.f148b = aVar;
        this.c = i;
        this.d = str;
    }

    public f.c call() {
        f.c a2 = f.a(this.f147a, this.f148b, this.c);
        Typeface typeface = a2.f158a;
        if (typeface != null) {
            f.f152a.a(this.d, typeface);
        }
        return a2;
    }
}
