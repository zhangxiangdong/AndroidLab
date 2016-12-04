package me.zhang.workbench.memory;

import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.BindView;
import me.zhang.workbench.R;

public class MemoryManagement extends AppCompatActivity {

    @BindView(R.id.heapSizeText)
    TextView mHeapSizeText;

    @BindView(R.id.largeHeapSizeText)
    TextView mLargeHeapSizeText;

    @BindView(R.id.recycledImage)
    ImageView mRecycledImage;

    Bitmap mBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_management);

        if (mBitmap == null) {
            mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.large_bitmap);
        }

        ButterKnife.bind(this);

        ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        mHeapSizeText.setText(getString(R.string.heap_size, manager.getMemoryClass()));

        mLargeHeapSizeText.setText(getString(R.string.large_heap_size, manager.getLargeMemoryClass()));
        mRecycledImage.setImageBitmap(mBitmap);
    }
}
