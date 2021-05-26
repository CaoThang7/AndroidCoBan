package com.example.assignmentgd1_gdandroid_ps12545_lycaothang.TabFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.assignmentgd1_gdandroid_ps12545_lycaothang.R;

public class Tab_Loaithu extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tab_loai_thu,container,false);
        return view;
    }
}
