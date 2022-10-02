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
        return "INSERT OR REPLACE INTO `EventTable` (`event_name`,`event_date`,`event_start_time`,`event_end_time`,`event_duration`,`event_timestamp`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EventEntity value) {
        if (value.getEventName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getEventName());
        }
        if (value.getEventMonth() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getEventMonth());
        }
        if (value.getEventStartTime() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEventStartTime());
        }
        if (value.getEventEndTime() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getEventEndTime());
        }
        if (value.getEventDuration() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getEventDuration());
        }
        if (value.getEventTimeStamp() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getEventTimeStamp());
        }
      }
    };
    this.__deletionAdapterOfEventEntity = new EntityDeletionOrUpdateAdapter<EventEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `EventTable` WHERE `event_timestamp` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EventEntity value) {
        if (value.getEventTimeStamp() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getEventTimeStamp());
        }
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
  public Object delete(final EventEntity soul, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfEventEntity.handle(soul);
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
          final int _cursorIndexOfEventMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "event_date");
          final int _cursorIndexOfEventStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "event_start_time");
          final int _cursorIndexOfEventEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "event_end_time");
          final int _cursorIndexOfEventDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "event_duration");
          final int _cursorIndexOfEventTimeStamp = CursorUtil.getColumnIndexOrThrow(_cursor, "event_timestamp");
          final EventEntity _result;
          if(_cursor.moveToFirst()) {
            final String _tmpEventName;
            if (_cursor.isNull(_cursorIndexOfEventName)) {
              _tmpEventName = null;
            } else {
              _tmpEventName = _cursor.getString(_cursorIndexOfEventName);
            }
            final String _tmpEventMonth;
            if (_cursor.isNull(_cursorIndexOfEventMonth)) {
              _tmpEventMonth = null;
            } else {
              _tmpEventMonth = _cursor.getString(_cursorIndexOfEventMonth);
            }
            final String _tmpEventStartTime;
            if (_cursor.isNull(_cursorIndexOfEventStartTime)) {
              _tmpEventStartTime = null;
            } else {
              _tmpEventStartTime = _cursor.getString(_cursorIndexOfEventStartTime);
            }
            final String _tmpEventEndTime;
            if (_cursor.isNull(_cursorIndexOfEventEndTime)) {
              _tmpEventEndTime = null;
            } else {
              _tmpEventEndTime = _cursor.getString(_cursorIndexOfEventEndTime);
            }
            final String _tmpEventDuration;
            if (_cursor.isNull(_cursorIndexOfEventDuration)) {
              _tmpEventDuration = null;
            } else {
              _tmpEventDuration = _cursor.getString(_cursorIndexOfEventDuration);
            }
            final String _tmpEventTimeStamp;
            if (_cursor.isNull(_cursorIndexOfEventTimeStamp)) {
              _tmpEventTimeStamp = null;
            } else {
              _tmpEventTimeStamp = _cursor.getString(_cursorIndexOfEventTimeStamp);
            }
            _result = new EventEntity(_tmpEventName,_tmpEventMonth,_tmpEventStartTime,_tmpEventEndTime,_tmpEventDuration,_tmpEventTimeStamp);
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
  public Flow<List<EventEntity>> getAllEventByMonth(final String month) {
    final String _sql = "SELECT * FROM EventTable WHERE event_date =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (month == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, month);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[]{"EventTable"}, new Callable<List<EventEntity>>() {
      @Override
      public List<EventEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfEventName = CursorUtil.getColumnIndexOrThrow(_cursor, "event_name");
          final int _cursorIndexOfEventMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "event_date");
          final int _cursorIndexOfEventStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "event_start_time");
          final int _cursorIndexOfEventEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "event_end_time");
          final int _cursorIndexOfEventDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "event_duration");
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
            final String _tmpEventMonth;
            if (_cursor.isNull(_cursorIndexOfEventMonth)) {
              _tmpEventMonth = null;
            } else {
              _tmpEventMonth = _cursor.getString(_cursorIndexOfEventMonth);
            }
            final String _tmpEventStartTime;
            if (_cursor.isNull(_cursorIndexOfEventStartTime)) {
              _tmpEventStartTime = null;
            } else {
              _tmpEventStartTime = _cursor.getString(_cursorIndexOfEventStartTime);
            }
            final String _tmpEventEndTime;
            if (_cursor.isNull(_cursorIndexOfEventEndTime)) {
              _tmpEventEndTime = null;
            } else {
              _tmpEventEndTime = _cursor.getString(_cursorIndexOfEventEndTime);
            }
            final String _tmpEventDuration;
            if (_cursor.isNull(_cursorIndexOfEventDuration)) {
              _tmpEventDuration = null;
            } else {
              _tmpEventDuration = _cursor.getString(_cursorIndexOfEventDuration);
            }
            final String _tmpEventTimeStamp;
            if (_cursor.isNull(_cursorIndexOfEventTimeStamp)) {
              _tmpEventTimeStamp = null;
            } else {
              _tmpEventTimeStamp = _cursor.getString(_cursorIndexOfEventTimeStamp);
            }
            _item = new EventEntity(_tmpEventName,_tmpEventMonth,_tmpEventStartTime,_tmpEventEndTime,_tmpEventDuration,_tmpEventTimeStamp);
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
