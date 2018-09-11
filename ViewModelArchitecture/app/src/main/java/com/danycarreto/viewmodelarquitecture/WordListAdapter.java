package com.danycarreto.viewmodelarquitecture;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.danycarreto.viewmodelarquitecture.database.Word;

import java.util.List;

/**
 * Created by eluniversal on 11/09/18.
 */

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {


  class WordViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;

    public WordViewHolder(View itemView) {
      super(itemView);
      textView = itemView.findViewById(R.id.textView);
    }
  }

  private LayoutInflater layoutInflater;
  private List<Word> words;

  public WordListAdapter(Context context) {
    layoutInflater = LayoutInflater.from(context);
  }

  @NonNull
  @Override
  public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    View item = layoutInflater.inflate(R.layout.recyclerview_item, parent, false);

    return new WordViewHolder(item);
  }

  @Override
  public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
    if (words != null) {
      Word current = words.get(position);
      holder.textView.setText(current.getWord());
    } else {
      holder.textView.setText("No Word");
    }
  }

  void setWords(List<Word> words) {
    this.words = words;
    notifyDataSetChanged();
  }

  @Override
  public int getItemCount() {
    if (words != null) {
      return words.size();
    }
    return 0;
  }


}
