package no.nordicsemi.android.log;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import java.util.ArrayList;
import java.util.List;
import no.nordicsemi.android.log.LogContract;

public class Logger {
    public static final int MARK_CLEAR = 0;
    public static final int MARK_FLAG_BLUE = 5;
    public static final int MARK_FLAG_RED = 6;
    public static final int MARK_FLAG_YELLOW = 4;
    public static final int MARK_STAR_BLUE = 2;
    public static final int MARK_STAR_RED = 3;
    public static final int MARK_STAR_YELLOW = 1;
    private static final int SESSION_ID = 100;
    private static final int SESSION_ID_LOG = 101;
    private static final int SESSION_KEY_NUMBER = 102;
    private static final int SESSION_KEY_NUMBER_LOG = 103;
    private static final UriMatcher mUriMatcher = new UriMatcher(-1);
    private static final ContentValues values = new ContentValues();

    static {
        UriMatcher uriMatcher = mUriMatcher;
        uriMatcher.addURI("no.nordicsemi.android.log", "session/#", 100);
        uriMatcher.addURI("no.nordicsemi.android.log", "session/#/log", 101);
        uriMatcher.addURI("no.nordicsemi.android.log", "session/key/*/#", 102);
        uriMatcher.addURI("no.nordicsemi.android.log", "session/key/*/#/log", 103);
    }

    public static void a(ILogSession iLogSession, String str) {
        log(iLogSession, 10, str);
    }

    public static void d(ILogSession iLogSession, String str) {
        log(iLogSession, 0, str);
    }

    public static void e(ILogSession iLogSession, String str) {
        log(iLogSession, 20, str);
    }

    public static void i(ILogSession iLogSession, String str) {
        log(iLogSession, 5, str);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:4|5|6|7|8|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x002e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void log(no.nordicsemi.android.log.ILogSession r3, int r4, java.lang.String r5) {
        /*
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            android.content.ContentValues r0 = values
            monitor-enter(r0)
            android.content.ContentValues r1 = values     // Catch:{ all -> 0x0030 }
            r1.clear()     // Catch:{ all -> 0x0030 }
            android.content.ContentValues r1 = values     // Catch:{ all -> 0x0030 }
            java.lang.String r2 = "level"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0030 }
            r1.put(r2, r4)     // Catch:{ all -> 0x0030 }
            android.content.ContentValues r4 = values     // Catch:{ all -> 0x0030 }
            java.lang.String r1 = "data"
            r4.put(r1, r5)     // Catch:{ all -> 0x0030 }
            android.content.Context r4 = r3.getContext()     // Catch:{ Exception -> 0x002e }
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ Exception -> 0x002e }
            android.net.Uri r3 = r3.getSessionEntriesUri()     // Catch:{ Exception -> 0x002e }
            android.content.ContentValues r5 = values     // Catch:{ Exception -> 0x002e }
            r4.insert(r3, r5)     // Catch:{ Exception -> 0x002e }
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x0030:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.log.Logger.log(no.nordicsemi.android.log.ILogSession, int, java.lang.String):void");
    }

    public static ContentValues logEntry(ILogSession iLogSession, int i, String str) {
        if (iLogSession == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(LogContract.LogColumns.TIME, Long.valueOf(System.currentTimeMillis()));
        contentValues.put(LogContract.LogColumns.LEVEL, Integer.valueOf(i));
        contentValues.put(LogContract.LogColumns.DATA, str);
        return contentValues;
    }

    public static LogSession newSession(Context context, String str, String str2) {
        return newSession(context, (String) null, str, str2);
    }

    public static ILogSession openSession(Context context, Uri uri) {
        if (uri == null) {
            return null;
        }
        switch (mUriMatcher.match(uri)) {
            case 100:
            case 102:
                return new LogSession(context, uri);
            case 101:
            case 103:
                Uri.Builder buildUpon = LogContract.Session.CONTENT_URI.buildUpon();
                List<String> pathSegments = uri.getPathSegments();
                for (int i = 1; i < pathSegments.size() - 1; i++) {
                    buildUpon.appendEncodedPath(pathSegments.get(i));
                }
                return new LogSession(context, buildUpon.build());
            default:
                return new LocalLogSession(context, uri);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:4|5|6|7|8|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0024 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void setSessionDescription(no.nordicsemi.android.log.LogSession r3, java.lang.String r4) {
        /*
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            android.content.ContentValues r0 = values
            monitor-enter(r0)
            android.content.ContentValues r1 = values     // Catch:{ all -> 0x0026 }
            r1.clear()     // Catch:{ all -> 0x0026 }
            android.content.ContentValues r1 = values     // Catch:{ all -> 0x0026 }
            java.lang.String r2 = "description"
            r1.put(r2, r4)     // Catch:{ all -> 0x0026 }
            android.content.Context r4 = r3.getContext()     // Catch:{ Exception -> 0x0024 }
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ Exception -> 0x0024 }
            android.net.Uri r3 = r3.getSessionUri()     // Catch:{ Exception -> 0x0024 }
            android.content.ContentValues r1 = values     // Catch:{ Exception -> 0x0024 }
            r2 = 0
            r4.update(r3, r1, r2, r2)     // Catch:{ Exception -> 0x0024 }
        L_0x0024:
            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
            return
        L_0x0026:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0026 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.log.Logger.setSessionDescription(no.nordicsemi.android.log.LogSession, java.lang.String):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:4|5|6|7|8|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0028 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void setSessionMark(no.nordicsemi.android.log.LogSession r3, int r4) {
        /*
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            android.content.ContentValues r0 = values
            monitor-enter(r0)
            android.content.ContentValues r1 = values     // Catch:{ all -> 0x002a }
            r1.clear()     // Catch:{ all -> 0x002a }
            android.content.ContentValues r1 = values     // Catch:{ all -> 0x002a }
            java.lang.String r2 = "mark"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x002a }
            r1.put(r2, r4)     // Catch:{ all -> 0x002a }
            android.content.Context r4 = r3.getContext()     // Catch:{ Exception -> 0x0028 }
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ Exception -> 0x0028 }
            android.net.Uri r3 = r3.getSessionUri()     // Catch:{ Exception -> 0x0028 }
            android.content.ContentValues r1 = values     // Catch:{ Exception -> 0x0028 }
            r2 = 0
            r4.update(r3, r1, r2, r2)     // Catch:{ Exception -> 0x0028 }
        L_0x0028:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x002a:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.log.Logger.setSessionMark(no.nordicsemi.android.log.LogSession, int):void");
    }

    public static void v(ILogSession iLogSession, String str) {
        log(iLogSession, 1, str);
    }

    public static void w(ILogSession iLogSession, String str) {
        log(iLogSession, 15, str);
    }

    public static void a(ILogSession iLogSession, int i, Object... objArr) {
        log(iLogSession, 10, i, objArr);
    }

    public static void d(ILogSession iLogSession, int i, Object... objArr) {
        log(iLogSession, 0, i, objArr);
    }

    public static void e(ILogSession iLogSession, int i, Object... objArr) {
        log(iLogSession, 20, i, objArr);
    }

    public static void i(ILogSession iLogSession, int i, Object... objArr) {
        log(iLogSession, 5, i, objArr);
    }

    public static LogSession newSession(Context context, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(LogContract.Application.CONTENT_URI);
        String charSequence = context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
        if (str != null) {
            newInsert.withValue("application", charSequence + " " + str);
        } else {
            newInsert.withValue("application", charSequence);
        }
        arrayList.add(newInsert.build());
        arrayList.add(ContentProviderOperation.newInsert(LogContract.Session.CONTENT_URI.buildUpon().appendEncodedPath("key").appendEncodedPath(str2).build()).withValueBackReference(LogContract.SessionColumns.APPLICATION_ID, 0).withValue(LogContract.SessionColumns.NAME, str3).build());
        try {
            return new LogSession(context, context.getContentResolver().applyBatch("no.nordicsemi.android.log", arrayList)[1].uri);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void v(ILogSession iLogSession, int i, Object... objArr) {
        log(iLogSession, 1, i, objArr);
    }

    public static void w(ILogSession iLogSession, int i, Object... objArr) {
        log(iLogSession, 15, i, objArr);
    }

    public static ContentValues logEntry(ILogSession iLogSession, int i, int i2, Object... objArr) {
        if (iLogSession == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(LogContract.LogColumns.TIME, Long.valueOf(System.currentTimeMillis()));
        contentValues.put(LogContract.LogColumns.LEVEL, Integer.valueOf(i));
        contentValues.put(LogContract.LogColumns.DATA, iLogSession.getContext().getString(i2, objArr));
        return contentValues;
    }

    public static void log(ILogSession iLogSession, int i, int i2, Object... objArr) {
        if (iLogSession != null) {
            values.clear();
            values.put(LogContract.LogColumns.LEVEL, Integer.valueOf(i));
            values.put(LogContract.LogColumns.DATA, iLogSession.getContext().getString(i2, objArr));
            try {
                iLogSession.getContext().getContentResolver().insert(iLogSession.getSessionEntriesUri(), values);
            } catch (Exception unused) {
            }
        }
    }

    public static void log(ILogSession iLogSession, ContentValues[] contentValuesArr) {
        if (iLogSession != null && contentValuesArr != null && contentValuesArr.length != 0) {
            try {
                iLogSession.getContext().getContentResolver().bulkInsert(iLogSession.getSessionEntriesUri(), contentValuesArr);
            } catch (Exception unused) {
            }
        }
    }

    public static void log(ILogSession iLogSession, List<ContentValues> list) {
        if (iLogSession != null && list != null && !list.isEmpty()) {
            try {
                iLogSession.getContext().getContentResolver().bulkInsert(iLogSession.getSessionEntriesUri(), (ContentValues[]) list.toArray(new ContentValues[0]));
            } catch (Exception unused) {
            }
        }
    }
}
