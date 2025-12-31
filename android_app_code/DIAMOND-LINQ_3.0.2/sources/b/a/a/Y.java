package b.a.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public final class Y {
    public static boolean a(Context context, String str, byte[] bArr) {
        return a(context, str, bArr, false);
    }

    public static byte[] b(Context context, String str) {
        boolean z;
        File file;
        if (a()) {
            file = e(context, str);
            z = file.exists();
        } else {
            file = null;
            z = false;
        }
        if (!z) {
            file = d(context, str);
        }
        if (!file.exists()) {
            return null;
        }
        int length = (int) file.length();
        byte[] bArr = new byte[length];
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            bufferedInputStream.read(bArr, 0, length);
            bufferedInputStream.close();
        } catch (IOException unused) {
        }
        return bArr;
    }

    public static void c(Context context, String str) {
        a(context, str, "text/csv");
    }

    private static File d(Context context, String str) {
        File file = new File(context.getFilesDir(), context.getString(Fa.app_name));
        if (!file.isDirectory() && !file.mkdirs()) {
            Log.e("CsFile", "Directory not created");
        }
        return new File(file, str);
    }

    private static File e(Context context, String str) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), context.getString(Fa.app_name));
        if (!file.isDirectory() && !file.mkdirs()) {
            Log.e("CsFile", "Directory not created");
        }
        return new File(file, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x004a A[SYNTHETIC, Splitter:B:34:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0055 A[SYNTHETIC, Splitter:B:40:0x0055] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r3, java.lang.String r4, byte[] r5, boolean r6) {
        /*
            r0 = 0
            r1 = 0
            boolean r2 = b()     // Catch:{ IOException -> 0x0044 }
            if (r2 == 0) goto L_0x000f
            if (r6 != 0) goto L_0x000f
            java.io.File r3 = e(r3, r4)     // Catch:{ IOException -> 0x0044 }
            goto L_0x0013
        L_0x000f:
            java.io.File r3 = d(r3, r4)     // Catch:{ IOException -> 0x0044 }
        L_0x0013:
            boolean r4 = r3.exists()     // Catch:{ IOException -> 0x0044 }
            if (r4 != 0) goto L_0x0024
            boolean r4 = r3.createNewFile()     // Catch:{ IOException -> 0x0020 }
            if (r4 != 0) goto L_0x0024
            return r0
        L_0x0020:
            r4 = move-exception
            r4.printStackTrace()     // Catch:{ IOException -> 0x0044 }
        L_0x0024:
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0044 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0044 }
            r4.write(r5)     // Catch:{ IOException -> 0x003f, all -> 0x003c }
            r4.flush()     // Catch:{ IOException -> 0x003f, all -> 0x003c }
            r4.close()     // Catch:{ IOException -> 0x003f, all -> 0x003c }
            r3 = 1
            r4.close()     // Catch:{ IOException -> 0x0037 }
            goto L_0x003b
        L_0x0037:
            r4 = move-exception
            r4.printStackTrace()
        L_0x003b:
            return r3
        L_0x003c:
            r3 = move-exception
            r1 = r4
            goto L_0x0053
        L_0x003f:
            r3 = move-exception
            r1 = r4
            goto L_0x0045
        L_0x0042:
            r3 = move-exception
            goto L_0x0053
        L_0x0044:
            r3 = move-exception
        L_0x0045:
            r3.printStackTrace()     // Catch:{ all -> 0x0042 }
            if (r1 == 0) goto L_0x0052
            r1.close()     // Catch:{ IOException -> 0x004e }
            goto L_0x0052
        L_0x004e:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0052:
            return r0
        L_0x0053:
            if (r1 == 0) goto L_0x005d
            r1.close()     // Catch:{ IOException -> 0x0059 }
            goto L_0x005d
        L_0x0059:
            r4 = move-exception
            r4.printStackTrace()
        L_0x005d:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.a.Y.a(android.content.Context, java.lang.String, byte[], boolean):boolean");
    }

    private static boolean b() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static boolean a(Context context, String str) {
        boolean z;
        File file;
        if (a()) {
            file = e(context, str);
            z = file.exists();
        } else {
            z = false;
            file = null;
        }
        if (!z) {
            file = d(context, str);
        }
        return file.exists();
    }

    public static void a(Context context, String str, String str2) {
        boolean z;
        File file;
        if (a()) {
            file = e(context, str);
            z = file.exists();
        } else {
            z = false;
            file = null;
        }
        if (!z) {
            file = d(context, str);
        }
        if (file.exists()) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
            intent.setType(str2);
            context.startActivity(intent);
        }
    }

    private static boolean a() {
        String externalStorageState = Environment.getExternalStorageState();
        return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
    }
}
