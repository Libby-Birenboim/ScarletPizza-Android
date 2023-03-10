// Generated by view binder compiler. Do not edit!
package com.example.scarlettpizza.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.scarlettpizza.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentToppingsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final RecyclerView rcViewMenu;

  private FragmentToppingsBinding(@NonNull ConstraintLayout rootView,
      @NonNull RecyclerView rcViewMenu) {
    this.rootView = rootView;
    this.rcViewMenu = rcViewMenu;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentToppingsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentToppingsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_toppings, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentToppingsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.rcView_menu;
      RecyclerView rcViewMenu = ViewBindings.findChildViewById(rootView, id);
      if (rcViewMenu == null) {
        break missingId;
      }

      return new FragmentToppingsBinding((ConstraintLayout) rootView, rcViewMenu);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
