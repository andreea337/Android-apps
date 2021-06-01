package com.example.fakegooglenews.ui.taiwan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.fakegooglenews.databinding.FragmentTaiwanBinding;

public class TaiwanFragment extends Fragment {

    private TaiwanViewModel taiwanViewModel;
    private FragmentTaiwanBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        taiwanViewModel =
                new ViewModelProvider(this).get(TaiwanViewModel.class);

        binding = FragmentTaiwanBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final WebView wvTaiwan = binding.wvTaiwan;
        wvTaiwan.setWebViewClient(new WebViewClient());
        wvTaiwan.getSettings().setJavaScriptEnabled(true);
        taiwanViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                wvTaiwan.loadUrl(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}