package com.delug3.rickandmorty.episode.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.delug3.rickandmorty.R;
import com.delug3.rickandmorty.episode.model.Episodes;

import java.util.ArrayList;
import java.util.List;

public class EpisodesListAdapter extends RecyclerView.Adapter<EpisodesListAdapter.ViewHolder> {

    private List<Episodes> episodesList;

    public EpisodesListAdapter(List<Episodes> episodesList) {
        this.episodesList = episodesList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.episodes_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Episodes e = episodesList.get(position);
        holder.tvEpisode.setText(e.getEpisode());
        holder.tvEpisodeName.setText(e.getName());
        holder.tvEpisodeAirDate.setText(e.getAirDate());
    }

    @Override
    public int getItemCount() {
        return episodesList.size();
    }

    public void addEpisodesList(ArrayList<Episodes> episodesList) {
        this.episodesList = episodesList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvEpisode;
        private final TextView tvEpisodeName;
        private final TextView tvEpisodeAirDate;

        public ViewHolder(View itemView) {
            super(itemView);
            tvEpisode = (TextView) itemView.findViewById(R.id.tv_Episode);
            tvEpisodeName = (TextView) itemView.findViewById(R.id.tvEpisodeName);
            tvEpisodeAirDate = (TextView) itemView.findViewById(R.id.tvEpisodeAirDate);
        }
    }
}


