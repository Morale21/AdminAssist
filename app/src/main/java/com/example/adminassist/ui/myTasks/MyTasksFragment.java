package com.example.adminassist.ui.myTasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.adminassist.databinding.FragmentMyTasksBinding;

public class MyTasksFragment extends Fragment {

    private FragmentMyTasksBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MyTasksViewModel myTasksViewModel =
                new ViewModelProvider(this).get(MyTasksViewModel.class);

        binding = FragmentMyTasksBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}