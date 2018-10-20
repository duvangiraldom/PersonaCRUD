package crud.co.com.clientecrud.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import crud.co.com.clientecrud.R;

public class CustomAdapter extends BaseAdapter {

    private List<ItemLista> listaItems;
    private Context context;
    private LayoutInflater inflater;

    public CustomAdapter(Context context, List<ItemLista> listaItems) {
        this.listaItems = listaItems;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    class ViewHolder{
        ImageView imageView;
        TextView txtId;
        TextView txtNombre;
        TextView txtApellido;
    }

    @Override
    public int getCount() {
        return listaItems.size();
    }

    @Override
    public ItemLista getItem(int position) {
        return listaItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_lista, null);
            holder.imageView = convertView.findViewById(R.id.imageView);
            holder.txtId = convertView.findViewById(R.id.txtId);
            holder.txtNombre = convertView.findViewById(R.id.txtNombre);
            holder.txtApellido = convertView.findViewById(R.id.txtApellido);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.imageView.setImageResource(listaItems.get(position).getIdImage());
        holder.txtId.setText(listaItems.get(position).getId());
        holder.txtNombre.setText(listaItems.get(position).getNombre());
        holder.txtApellido.setText(listaItems.get(position).getApellido());
        return convertView;

    }
}