package br.com.alexpfx.app.gerasenha2015;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
        holder.tvTitulo.setText(item.itemTitle);
        holder.tvSubtitulo.setText(item.itemSubTitle);
        holder.image.setImageResource(item.itemIconImgSrc);
    }

    @Override
    public int getItemCount() {
        return modelItemList.size();
    }

    public static interface OnItemClick{
        void onItemClick (ViewModel viewModel);
    }

    public static class ViewModel {
        private final int itemIconImgSrc;
        private final String itemTitle;
        private final String itemSubTitle;
        private Class<? extends Fragment> fragment;
        private ColorTriade colorTriade;

        private ViewModel(int itemIconImgSrc, String itemTitle, String itemSubTitle) {
            this.itemIconImgSrc = itemIconImgSrc;
            this.itemTitle = itemTitle;
            this.itemSubTitle = itemSubTitle;
        }

        private ViewModel(int itemIconImgSrc, String itemTitle, String itemSubTitle, @Nullable ColorTriade colorTriade) {
            this(itemIconImgSrc, itemTitle, itemSubTitle);
            this.colorTriade = colorTriade;
        }


        public static ViewModel createNew(int srcImage, String titulo, String subTitulo) {
            return new ViewModel(srcImage, titulo, subTitulo);
        }

        public static ViewModel createNew(int srcImage, String titulo, String subTitulo, @Nullable ColorTriade colorTriade) {
            return new ViewModel(srcImage, titulo, subTitulo, colorTriade);
        }

        public void addTo(List<ViewModel> list) {
            if (list != null) {
                list.add(this);
            }
        }

        public int getItemIconImgSrc() {
            return itemIconImgSrc;
        }

        public String getItemTitle() {
            return itemTitle;
        }

        public String getItemSubTitle() {
            return itemSubTitle;
        }

        public Class<? extends Fragment> getFragment() {
            return fragment;
        }

        public ColorTriade getColorTriade() {
            return colorTriade;
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
