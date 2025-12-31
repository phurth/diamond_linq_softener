package no.nordicsemi.android.log.localprovider;

import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LogTransaction {
    private final boolean mBatch;
    private final Map<String, SQLiteDatabase> mDatabaseTagMap = new HashMap();
    private final List<SQLiteDatabase> mDatabasesForTransaction = new ArrayList();
    private boolean mIsDirty = false;
    private boolean mYieldFailed;

    LogTransaction(boolean z) {
        this.mBatch = z;
    }

    private boolean hasDbInTransaction(String str) {
        return this.mDatabaseTagMap.containsKey(str);
    }

    /* access modifiers changed from: package-private */
    public void finish(boolean z) {
        if (!this.mBatch || z) {
            for (SQLiteDatabase next : this.mDatabasesForTransaction) {
                if (!this.mYieldFailed || next.isDbLockedByCurrentThread()) {
                    next.endTransaction();
                }
            }
            this.mDatabasesForTransaction.clear();
            this.mDatabaseTagMap.clear();
            this.mIsDirty = false;
        }
    }

    /* access modifiers changed from: package-private */
    public SQLiteDatabase getDbForTag(String str) {
        return this.mDatabaseTagMap.get(str);
    }

    /* access modifiers changed from: package-private */
    public boolean isBatch() {
        return this.mBatch;
    }

    /* access modifiers changed from: package-private */
    public boolean isDirty() {
        return this.mIsDirty;
    }

    /* access modifiers changed from: package-private */
    public void markDirty() {
        this.mIsDirty = true;
    }

    /* access modifiers changed from: package-private */
    public void markSuccessful(boolean z) {
        if (!this.mBatch || z) {
            for (SQLiteDatabase transactionSuccessful : this.mDatabasesForTransaction) {
                transactionSuccessful.setTransactionSuccessful();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void markYieldFailed() {
        this.mYieldFailed = true;
    }

    public SQLiteDatabase removeDbForTag(String str) {
        SQLiteDatabase sQLiteDatabase = this.mDatabaseTagMap.get(str);
        this.mDatabaseTagMap.remove(str);
        this.mDatabasesForTransaction.remove(sQLiteDatabase);
        return sQLiteDatabase;
    }

    /* access modifiers changed from: package-private */
    public void startTransactionForDb(SQLiteDatabase sQLiteDatabase, String str) {
        if (!hasDbInTransaction(str)) {
            this.mDatabasesForTransaction.add(0, sQLiteDatabase);
            this.mDatabaseTagMap.put(str, sQLiteDatabase);
            sQLiteDatabase.beginTransaction();
        }
    }
}
