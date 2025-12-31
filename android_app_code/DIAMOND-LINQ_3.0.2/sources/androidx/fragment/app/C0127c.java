package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.C0125a;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* renamed from: androidx.fragment.app.c  reason: case insensitive filesystem */
final class C0127c implements Parcelable {
    public static final Parcelable.Creator<C0127c> CREATOR = new C0126b();

    /* renamed from: a  reason: collision with root package name */
    final int[] f798a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<String> f799b;
    final int c;
    final int d;
    final String e;
    final int f;
    final int g;
    final CharSequence h;
    final int i;
    final CharSequence j;
    final ArrayList<String> k;
    final ArrayList<String> l;
    final boolean m;

    public C0127c(C0125a aVar) {
        int size = aVar.f795b.size();
        this.f798a = new int[(size * 5)];
        if (aVar.i) {
            this.f799b = new ArrayList<>(size);
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                C0125a.C0025a aVar2 = aVar.f795b.get(i2);
                int i4 = i3 + 1;
                this.f798a[i3] = aVar2.f796a;
                ArrayList<String> arrayList = this.f799b;
                C0132h hVar = aVar2.f797b;
                arrayList.add(hVar != null ? hVar.f : null);
                int[] iArr = this.f798a;
                int i5 = i4 + 1;
                iArr[i4] = aVar2.c;
                int i6 = i5 + 1;
                iArr[i5] = aVar2.d;
                int i7 = i6 + 1;
                iArr[i6] = aVar2.e;
                iArr[i7] = aVar2.f;
                i2++;
                i3 = i7 + 1;
            }
            this.c = aVar.g;
            this.d = aVar.h;
            this.e = aVar.k;
            this.f = aVar.m;
            this.g = aVar.n;
            this.h = aVar.o;
            this.i = aVar.p;
            this.j = aVar.q;
            this.k = aVar.r;
            this.l = aVar.s;
            this.m = aVar.t;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public C0125a a(w wVar) {
        C0125a aVar = new C0125a(wVar);
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f798a.length) {
            C0125a.C0025a aVar2 = new C0125a.C0025a();
            int i4 = i2 + 1;
            aVar2.f796a = this.f798a[i2];
            if (w.c) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i3 + " base fragment #" + this.f798a[i4]);
            }
            String str = this.f799b.get(i3);
            if (str != null) {
                aVar2.f797b = wVar.k.get(str);
            } else {
                aVar2.f797b = null;
            }
            int[] iArr = this.f798a;
            int i5 = i4 + 1;
            aVar2.c = iArr[i4];
            int i6 = i5 + 1;
            aVar2.d = iArr[i5];
            int i7 = i6 + 1;
            aVar2.e = iArr[i6];
            aVar2.f = iArr[i7];
            aVar.c = aVar2.c;
            aVar.d = aVar2.d;
            aVar.e = aVar2.e;
            aVar.f = aVar2.f;
            aVar.a(aVar2);
            i3++;
            i2 = i7 + 1;
        }
        aVar.g = this.c;
        aVar.h = this.d;
        aVar.k = this.e;
        aVar.m = this.f;
        aVar.i = true;
        aVar.n = this.g;
        aVar.o = this.h;
        aVar.p = this.i;
        aVar.q = this.j;
        aVar.r = this.k;
        aVar.s = this.l;
        aVar.t = this.m;
        aVar.a(1);
        return aVar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeIntArray(this.f798a);
        parcel.writeStringList(this.f799b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeString(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        TextUtils.writeToParcel(this.h, parcel, 0);
        parcel.writeInt(this.i);
        TextUtils.writeToParcel(this.j, parcel, 0);
        parcel.writeStringList(this.k);
        parcel.writeStringList(this.l);
        parcel.writeInt(this.m ? 1 : 0);
    }

    public C0127c(Parcel parcel) {
        this.f798a = parcel.createIntArray();
        this.f799b = parcel.createStringArrayList();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readString();
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.h = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.i = parcel.readInt();
        this.j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.k = parcel.createStringArrayList();
        this.l = parcel.createStringArrayList();
        this.m = parcel.readInt() != 0;
    }
}
