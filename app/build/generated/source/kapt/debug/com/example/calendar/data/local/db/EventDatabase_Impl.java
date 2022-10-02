package com.example.calendar.data.local.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.example.calendar.data.local.db.dao.EventDao;
import com.example.calendar.data.local.db.dao.EventDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class EventDatabase_Impl extends EventDatabase {
  private volatile EventDao _eventDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `EventTable` (`event_name` TEXT NOT NULL, `event_date` TEXT NOT NULL, `event_start_time` TEXT NOT NULL, `event_end_time` TEXT NOT NULL, `event_duration` TEXT NOT NULL, `event_timestamp` TEXT NOT NULL, PRIMARY KEY(`event_timestamp`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '24601035c15146c54b414473faee6386')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `EventTable`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsEventTable = new HashMap<String, TableInfo.Column>(6);
        _columnsEventTable.put("event_name", new TableInfo.Column("event_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEventTable.put("event_date", new TableInfo.Column("event_date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEventTable.put("event_start_time", new TableInfo.Column("event_start_time", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEventTable.put("event_end_time", new TableInfo.Column("event_end_time", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEventTable.put("event_duration", new TableInfo.Column("event_duration", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEventTable.put("event_timestamp", new TableInfo.Column("event_timestamp", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEventTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEventTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEventTable = new TableInfo("EventTable", _columnsEventTable, _foreignKeysEventTable, _indicesEventTable);
        final TableInfo _existingEventTable = TableInfo.read(_db, "EventTable");
        if (! _infoEventTable.equals(_existingEventTable)) {
          return new RoomOpenHelper.ValidationResult(false, "EventTable(com.example.calendar.data.local.db.entity.EventEntity).\n"
                  + " Expected:\n" + _infoEventTable + "\n"
                  + " Found:\n" + _existingEventTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "24601035c15146c54b414473faee6386", "fec06fcb1afedf820bf4ac92bdfabca9");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "EventTable");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `EventTable`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(EventDao.class, EventDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public EventDao getEventDao() {
    if (_eventDao != null) {
      return _eventDao;
    } else {
      synchronized(this) {
        if(_eventDao == null) {
          _eventDao = new EventDao_Impl(this);
        }
        return _eventDao;
      }
    }
  }
}
