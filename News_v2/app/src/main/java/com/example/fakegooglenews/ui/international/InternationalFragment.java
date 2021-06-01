package com.example.fakegooglenews.ui.international;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.fakegooglenews.databinding.FragmentInternationalBinding;

public class InternationalFragment extends Fragment {

    private InternationalViewModel internationalViewModel;
    private FragmentInternationalBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        internationalViewModel =
                new ViewModelProvider(this).get(InternationalViewModel.class);

        binding = FragmentInternationalBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final WebView wvInternational = binding.wvInternational;
        wvInternational.setWebViewClient(new WebViewClient());
        wvInternational.getSettings().setJavaScriptEnabled(true);

        internationalViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                wvInternational.loadUrl(s);
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