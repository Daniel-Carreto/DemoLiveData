package com.danycarreto.viewmodelarquitecture.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

/**
 * Created by eluniversal on 11/09/18.
 */
@Database(entities = {Word.class}, version = 1)
public abstract class WordRoomDatabase extends RoomDatabase {

  public abstract WordDao wordDao();

  private static WordRoomDatabase INSTANCE;

  public static WordRoomDatabase getDatabase(final Context context) {
    if (INSTANCE == null) {
      synchronized (WordRoomDatabase.class) {
        if (INSTANCE == null) {
          INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
              WordRoomDatabase.class, "word_database")
              .addCallback(callback)
              .build();
        }
      }
    }
    return INSTANCE;
  }


  private static RoomDatabase.Callback callback = new RoomDatabase.Callback(){

    @Override
    public void onOpen(@NonNull SupportSQLiteDatabase db) {
      super.onOpen(db);
      new PopulateDBAsync(INSTANCE).execute();
    }
  };



  private static class PopulateDBAsync extends AsyncTask<Void, Void, Void>{

    private WordDao wordDao;

    PopulateDBAsync(WordRoomDatabase wordRoomDatabase){
      this.wordDao = wordRoomDatabase.wordDao();
    }


    @Override
    protected Void doInBackground(Void... voids) {
      wordDao.deleteAll();
      Word word = new Word("Hello");
      wordDao.insert(word);
      word = new Word("World");
      wordDao.insert(word);
      return null;
    }
  }
}
