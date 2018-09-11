package com.danycarreto.viewmodelarquitecture;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.danycarreto.viewmodelarquitecture.database.Word;
import com.danycarreto.viewmodelarquitecture.database.WordRoomDatabase;
import com.danycarreto.viewmodelarquitecture.database.WordDao;

import java.util.List;

/**
 * Created by eluniversal on 11/09/18.
 */

public class WordRepository {

  private WordDao mWordDao;
  private LiveData<List<Word>> mAllWords;


  public WordRepository(Application application) {
    WordRoomDatabase db =  WordRoomDatabase.getDatabase(application);
    this.mWordDao = db.wordDao();
    this.mAllWords = mWordDao.getAllWords();
  }

  LiveData<List<Word>> getAllWords(){
    return mAllWords;
  }

  public void insert(Word word){
    new insertAsyncTask(mWordDao).execute(word);
  }

  private static class insertAsyncTask extends AsyncTask<Word, Void, Void>{

    private WordDao wordDao;

    public insertAsyncTask(WordDao wordDao) {
      this.wordDao = wordDao;
    }

    @Override
    protected Void doInBackground(Word... words) {
      wordDao.insert(words[0]);
      return null;
    }
  }


}
