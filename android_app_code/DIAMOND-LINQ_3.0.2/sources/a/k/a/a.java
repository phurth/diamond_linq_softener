package a.k.a;

import androidx.lifecycle.E;
import androidx.lifecycle.l;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class a {
    public static <T extends l & E> a a(T t) {
        return new b(t, ((E) t).c());
    }

    public abstract void a();

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);
}
