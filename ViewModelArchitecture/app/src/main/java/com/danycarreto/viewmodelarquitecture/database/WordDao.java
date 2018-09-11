package com.danycarreto.viewmodelarquitecture.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.danycarreto.viewmodelarquitecture.database.Word;

import java.util.List;

/**
 * Created by eluniversal on 11/09/18.
 */
@Dao
public interface WordDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insert(Word word);

  @Query("DELETE FROM word_table")
  void deleteAll();

  @Query("SELECT * FROM word_table ORDER BY word ASC")
  LiveData<List<Word>> getAllWords();
}
