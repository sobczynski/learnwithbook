package pl.xaos.learngwithbook;

import android.app.ListActivity;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
//import android.R;
//change 1
//commit 2
//commit 3
//commit 4
//external change
public class MainActivity extends ListActivity {

    private static final String[] items = {"acece", "bcdc", "bd", "ccdcwdc", "dcrcee", "ecerccc", "feee",
            "acece", "bcdc", "bd", "ccdcwdc", "dcrcee", "ecerccc", "feee"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new IconicAdapter());
        //setContentView(R.layout.activity_main);


    }

    class IconicAdapter extends ArrayAdapter<String> {
        IconicAdapter() {
            super(MainActivity.this, R.layout.row, R.id.label, items);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View row = super.getView(position, convertView, parent);
            ViewHolder holder = (ViewHolder) row.getTag();

            if (holder == null) {
                holder = new ViewHolder(row);
                row.setTag(holder);
            }


            if (items[position].length() < 5) {
                holder.icon.setImageResource(android.R.drawable.star_on);

            } else {

                holder.icon.setImageResource(android.R.drawable.star_off);

            }

            TextView size = holder.size;
            size.setText(items[position].length()+"");
            return row;
        }
    }

    class ViewHolder {
        ImageView icon = null;
        TextView size = null;

        ViewHolder(View row) {
            this.icon = (ImageView) row.findViewById(R.id.image);
            this.size = (TextView) row.findViewById(R.id.size);
        }

    }

}
