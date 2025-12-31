package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class j implements Iterable<Intent> {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Intent> f730a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final Context f731b;

    public interface a {
        Intent g();
    }

    private j(Context context) {
        this.f731b = context;
    }

    public static j a(Context context) {
        return new j(context);
    }

    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f730a.iterator();
    }

    public j a(Intent intent) {
        this.f730a.add(intent);
        return this;
    }

    public j a(Activity activity) {
        Intent g = activity instanceof a ? ((a) activity).g() : null;
        if (g == null) {
            g = h.a(activity);
        }
        if (g != null) {
            ComponentName component = g.getComponent();
            if (component == null) {
                component = g.resolveActivity(this.f731b.getPackageManager());
            }
            a(component);
            a(g);
        }
        return this;
    }

    public j a(ComponentName componentName) {
        int size = this.f730a.size();
        try {
            Intent a2 = h.a(this.f731b, componentName);
            while (a2 != null) {
                this.f730a.add(size, a2);
                a2 = h.a(this.f731b, a2.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public void a() {
        a((Bundle) null);
    }

    public void a(Bundle bundle) {
        if (!this.f730a.isEmpty()) {
            ArrayList<Intent> arrayList = this.f730a;
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            if (!a.g.a.a.a(this.f731b, intentArr, bundle)) {
                Intent intent = new Intent(intentArr[intentArr.length - 1]);
                intent.addFlags(268435456);
                this.f731b.startActivity(intent);
                return;
            }
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
}
