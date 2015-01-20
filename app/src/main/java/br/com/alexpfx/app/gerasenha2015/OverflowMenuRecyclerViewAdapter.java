package br.com.alexpfx.app.gerasenha2015;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.alexandrealessi.gerasenha2015.R;

/**
 * Created by alexandre on 11/01/15.
 */
public class OverflowMenuRecyclerViewAdapter extends RecyclerView.Adapter<OverflowMenuRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<ViewModel> modelItemList;
    private OnItemClick onItemClickCallback;

    public OverflowMenuRecyclerViewAdapter(Context context, List<ViewModel> modelItemList, OnItemClick onItemClickCallback) {
        this.context = context;
        this.modelItemList = modelItemList;
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.overflow_menu_item, parent, false);
        final ViewHolder vh = new ViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClick(modelItemList.get(vh.getPosition()));
            }
        });
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ViewModel item = modelItemList.get(position);
        holder.tvTitulo.setText(item.getSenhaMenuItem().getTitle());
        holder.tvSubtitulo.setText(item.getSenhaMenuItem().getSubTitle());
        holder.image.setImageResource(item.getSenhaMenuItem().getItemIconImgSrc());
    }

    @Override
    public int getItemCount() {
        return modelItemList.size();
    }

    public static interface OnItemClick {
        void onItemClick(ViewModel viewModel);
    }

    public static class ViewModel {
        private SenhaMenuItem senhaMenuItem;

        private ViewModel(SenhaMenuItem senhaMenuItem) {
            this.senhaMenuItem = senhaMenuItem;
        }

        public SenhaMenuItem getSenhaMenuItem() {
            return senhaMenuItem;
        }

        public static ViewModel createNew (SenhaMenuItem senhaMenuItem){
            return new ViewModel(senhaMenuItem);
        }

        public void addTo(List<ViewModel> lista) {
            lista.add(this);
        }
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        private Context context;
        private ImageView image;
        private TextView tvTitulo;
        private TextView tvSubtitulo;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitulo = (TextView) itemView.findViewById(R.id.titulo_text_view);
            tvSubtitulo = (TextView) itemView.findViewById(R.id.subtitulo_text_view);
            image = (ImageView) itemView.findViewById(R.id.password_type_imageview);
        }
    }
}
