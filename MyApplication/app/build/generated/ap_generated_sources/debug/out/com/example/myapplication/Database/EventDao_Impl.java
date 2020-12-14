package com.example.myapplication.Database;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class EventDao_Impl implements EventDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EntityClass> __insertionAdapterOfEntityClass;

  private final EntityDeletionOrUpdateAdapter<EntityClass> __deletionAdapterOfEntityClass;

  public EventDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEntityClass = new EntityInsertionAdapter<EntityClass>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `myTable` (`id`,`eventname`,`eventdate`,`eventtime`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EntityClass value) {
        stmt.bindLong(1, value.id);
        if (value.getEventname() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getEventname());
        }
        if (value.getEventdate() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEventdate());
        }
        if (value.getEventtime() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getEventtime());
        }
      }
    };
    this.__deletionAdapterOfEntityClass = new EntityDeletionOrUpdateAdapter<EntityClass>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `myTable` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EntityClass value) {
        stmt.bindLong(1, value.id);
      }
    };
  }

  @Override
  public void insertAll(final EntityClass entityClass) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEntityClass.insert(entityClass);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final EntityClass entityClass) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfEntityClass.handle(entityClass);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<EntityClass> getAllData() {
    final String _sql = "SELECT * FROM myTable";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfEventname = CursorUtil.getColumnIndexOrThrow(_cursor, "eventname");
      final int _cursorIndexOfEventdate = CursorUtil.getColumnIndexOrThrow(_cursor, "eventdate");
      final int _cursorIndexOfEventtime = CursorUtil.getColumnIndexOrThrow(_cursor, "eventtime");
      final List<EntityClass> _result = new ArrayList<EntityClass>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EntityClass _item;
        _item = new EntityClass();
        _item.id = _cursor.getInt(_cursorIndexOfId);
        final String _tmpEventname;
        _tmpEventname = _cursor.getString(_cursorIndexOfEventname);
        _item.setEventname(_tmpEventname);
        final String _tmpEventdate;
        _tmpEventdate = _cursor.getString(_cursorIndexOfEventdate);
        _item.setEventdate(_tmpEventdate);
        final String _tmpEventtime;
        _tmpEventtime = _cursor.getString(_cursorIndexOfEventtime);
        _item.setEventtime(_tmpEventtime);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
