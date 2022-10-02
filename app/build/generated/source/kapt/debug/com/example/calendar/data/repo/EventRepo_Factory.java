// Generated by Dagger (https://dagger.dev).
package com.example.calendar.data.repo;

import com.example.calendar.data.local.db.dao.EventDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class EventRepo_Factory implements Factory<EventRepo> {
  private final Provider<EventDao> eventDaoProvider;

  public EventRepo_Factory(Provider<EventDao> eventDaoProvider) {
    this.eventDaoProvider = eventDaoProvider;
  }

  @Override
  public EventRepo get() {
    return newInstance(eventDaoProvider.get());
  }

  public static EventRepo_Factory create(Provider<EventDao> eventDaoProvider) {
    return new EventRepo_Factory(eventDaoProvider);
  }

  public static EventRepo newInstance(EventDao eventDao) {
    return new EventRepo(eventDao);
  }
}
