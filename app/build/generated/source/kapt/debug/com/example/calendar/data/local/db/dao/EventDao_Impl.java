package com.example.calendar.data.local.db.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.calendar.data.local.db.entity.EventEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class EventDao_Impl implements EventDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EventEntity> __insertionAdapterOfEventEntity;

  private final EntityDeletionOrUpdateAdapter<EventEntity> __deletionAdapterOfEventEntity;

  public EventDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEventEntity = new EntityInsertionAdapter<EventEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `EventTable` (`event_name`,`event_month`,`event_start_time`,`event_end_time`,`event_diff_time`,`event_timestamp`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EventEntity value) {
        if (value.getEventName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getEventName());
        }
        stmt.bindLong(2, value.getEventMonth());
        stmt.bindLong(3, value.getEventStartTimestamp());
        stmt.bindLong(4, value.getEventEndTimestamp());
        stmt.bindLong(5, value.getEventDiffTimestamp());
        stmt.bindLong(6, value.getEventTimeStamp());
      }
    };
    this.__deletionAdapterOfEventEntity = new EntityDeletionOrUpdateAdapter<EventEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `EventTable` WHERE `event_timestamp` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EventEntity value) {
        stmt.bindLong(1, value.getEventTimeStamp());
      }
    };
  }

  @Override
  public Object upsertEvent(final EventEntity[] event,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfEventEntity.insert(event);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object delete(final EventEntity event, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfEventEntity.handle(event);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Flow<EventEntity> getAllEventMonth() {
    final String _sql = "SELECT * FROM EventTable ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"EventTable"}, new Callable<EventEntity>() {
      @Override
      public EventEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfEventName = CursorUtil.getColumnIndexOrThrow(_cursor, "event_name");
          final int _cursorIndexOfEventMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "event_month");
          final int _cursorIndexOfEventStartTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "event_start_time");
          final int _cursorIndexOfEventEndTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "event_end_time");
          final int _cursorIndexOfEventDiffTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "event_diff_time");
          final int _cursorIndexOfEventTimeStamp = CursorUtil.getColumnIndexOrThrow(_cursor, "event_timestamp");
          final EventEntity _result;
          if(_cursor.moveToFirst()) {
            final String _tmpEventName;
            if (_cursor.isNull(_cursorIndexOfEventName)) {
              _tmpEventName = null;
            } else {
              _tmpEventName = _cursor.getString(_cursorIndexOfEventName);
            }
            final int _tmpEventMonth;
            _tmpEventMonth = _cursor.getInt(_cursorIndexOfEventMonth);
            final long _tmpEventStartTimestamp;
            _tmpEventStartTimestamp = _cursor.getLong(_cursorIndexOfEventStartTimestamp);
            final long _tmpEventEndTimestamp;
            _tmpEventEndTimestamp = _cursor.getLong(_cursorIndexOfEventEndTimestamp);
            final long _tmpEventDiffTimestamp;
            _tmpEventDiffTimestamp = _cursor.getLong(_cursorIndexOfEventDiffTimestamp);
            final long _tmpEventTimeStamp;
            _tmpEventTimeStamp = _cursor.getLong(_cursorIndexOfEventTimeStamp);
            _result = new EventEntity(_tmpEventName,_tmpEventMonth,_tmpEventStartTimestamp,_tmpEventEndTimestamp,_tmpEventDiffTimestamp,_tmpEventTimeStamp);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<EventEntity>> getAllEventByMonth(final int month) {
    final String _sql = "SELECT * FROM EventTable WHERE event_month =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, month);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"EventTable"}, new Callable<List<EventEntity>>() {
      @Override
      public List<EventEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfEventName = CursorUtil.getColumnIndexOrThrow(_cursor, "event_name");
          final int _cursorIndexOfEventMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "event_month");
          final int _cursorIndexOfEventStartTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "event_start_time");
          final int _cursorIndexOfEventEndTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "event_end_time");
          final int _cursorIndexOfEventDiffTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "event_diff_time");
          final int _cursorIndexOfEventTimeStamp = CursorUtil.getColumnIndexOrThrow(_cursor, "event_timestamp");
          final List<EventEntity> _result = new ArrayList<EventEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EventEntity _item;
            final String _tmpEventName;
            if (_cursor.isNull(_cursorIndexOfEventName)) {
              _tmpEventName = null;
            } else {
              _tmpEventName = _cursor.getString(_cursorIndexOfEventName);
            }
            final int _tmpEventMonth;
            _tmpEventMonth = _cursor.getInt(_cursorIndexOfEventMonth);
            final long _tmpEventStartTimestamp;
            _tmpEventStartTimestamp = _cursor.getLong(_cursorIndexOfEventStartTimestamp);
            final long _tmpEventEndTimestamp;
            _tmpEventEndTimestamp = _cursor.getLong(_cursorIndexOfEventEndTimestamp);
            final long _tmpEventDiffTimestamp;
            _tmpEventDiffTimestamp = _cursor.getLong(_cursorIndexOfEventDiffTimestamp);
            final long _tmpEventTimeStamp;
            _tmpEventTimeStamp = _cursor.getLong(_cursorIndexOfEventTimeStamp);
            _item = new EventEntity(_tmpEventName,_tmpEventMonth,_tmpEventStartTimestamp,_tmpEventEndTimestamp,_tmpEventDiffTimestamp,_tmpEventTimeStamp);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
