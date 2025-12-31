package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.b;

public class IconCompatParcelizer {
    public static IconCompat read(b bVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f733b = bVar.a(iconCompat.f733b, 1);
        iconCompat.d = bVar.a(iconCompat.d, 2);
        iconCompat.e = bVar.a(iconCompat.e, 3);
        iconCompat.f = bVar.a(iconCompat.f, 4);
        iconCompat.g = bVar.a(iconCompat.g, 5);
        iconCompat.h = (ColorStateList) bVar.a(iconCompat.h, 6);
        iconCompat.j = bVar.a(iconCompat.j, 7);
        iconCompat.c();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, b bVar) {
        bVar.a(true, true);
        iconCompat.a(bVar.c());
        int i = iconCompat.f733b;
        if (-1 != i) {
            bVar.b(i, 1);
        }
        byte[] bArr = iconCompat.d;
        if (bArr != null) {
            bVar.b(bArr, 2);
        }
        Parcelable parcelable = iconCompat.e;
        if (parcelable != null) {
            bVar.b(parcelable, 3);
        }
        int i2 = iconCompat.f;
        if (i2 != 0) {
            bVar.b(i2, 4);
        }
        int i3 = iconCompat.g;
        if (i3 != 0) {
            bVar.b(i3, 5);
        }
        ColorStateList colorStateList = iconCompat.h;
        if (colorStateList != null) {
            bVar.b((Parcelable) colorStateList, 6);
        }
        String str = iconCompat.j;
        if (str != null) {
            bVar.b(str, 7);
        }
    }
}
