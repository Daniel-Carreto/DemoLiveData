package com.danycarreto.viewmodelarquitecture.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by eluniversal on 11/09/18.
 */
@Entity(tableName = "word_table")
public class Word {

  @PrimaryKey(autoGenerate = true)
  private int id;


  @ColumnInfo(name = "word")
  @NonNull
  private String word;

  public Word(String word) {
    this.word = word;
  }

  public String getWord() {
    return word;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
