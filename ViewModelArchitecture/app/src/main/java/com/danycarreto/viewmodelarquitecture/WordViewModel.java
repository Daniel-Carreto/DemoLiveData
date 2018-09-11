package com.danycarreto.viewmodelarquitecture;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.danycarreto.viewmodelarquitecture.database.Word;

import java.util.List;

/**
 * Created by eluniversal on 11/09/18.
 */

public class WordViewModel extends AndroidViewModel {


  private WordRepository wordRepository;
  private LiveData<List<Word>> wordsList;

  public WordViewModel(Application application){
    super(application);
    this.wordRepository = new WordRepository(application);
    this.wordsList = wordRepository.getAllWords();
  }


  LiveData<List<Word>> getAllWords(){
    return wordsList;
  }


  public void insert(Word word){
    wordRepository.insert(word);
  }



}
