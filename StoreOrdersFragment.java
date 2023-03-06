package com.example.scarlettpizza;

/**
 * StoreOrdersFragment is the fragment for the store orders activity
 * @author Selin Altiparmak, Libby Birenboim
 */

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;


import com.example.scarlettpizza.databinding.FragmentStoreOrdersBinding;
import com.example.scarlettpizza.models.BbqChicken;
import com.example.scarlettpizza.models.BuildYourOwn;
import com.example.scarlettpizza.models.Deluxe;
import com.example.scarlettpizza.models.Meatzza;
import com.example.scarlettpizza.models.Order;
import com.example.scarlettpizza.models.Pizza;
import com.example.scarlettpizza.models.Size;

import java.util.ArrayList;

public class StoreOrdersFragment extends Fragment {

    private FragmentStoreOrdersBinding binding;
    private ScarletPizzaController scarletPizzaController = ScarletPizzaController.getInstance();
    private ArrayList<String> pizzas;
    private ArrayList<String> order_numbers;
    private int orderId;
    private ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapter_orders;

    /**
     * onCreateView method creates the view for this fragment for store orders
     * @param inflater LayoutInflater
     * @param container ViewGroup
     * @param savedInstanceState Bundle
     * @return View
     */
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentStoreOrdersBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    /**
     * onViewCreates method tells program what to do once view has been created
     * @param view View
     * @param savedInstanceState Bundle
     */
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        order_numbers = new ArrayList<String>();
        for (Order order: scarletPizzaController.getStoreOrders().getOrderList()) {
            order_numbers.add(String.valueOf(order.getOrderNumber()));
        }

        Spinner spinner_orders = binding.spinner;
        adapter_orders = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, order_numbers);
        adapter_orders.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner_orders.setAdapter(adapter_orders);
        spinner_orders.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            /**
             * onItemSelected method tells program what to do when user selects certain items
             *      within the store orders view
             * @param adapterView AdapterView
             * @param view View
             * @param i integer
             * @param l long
             */
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = adapterView.getSelectedItem().toString();
                orderId = Integer.parseInt(selectedItem);
                pizzas = new ArrayList<String>();
                for (Pizza pizza :  scarletPizzaController.getStoreOrders().getOrder(Integer.parseInt(selectedItem)).getPizzaList()){
                    pizzas.add(pizza.toString());
                }
                adapter=new ArrayAdapter<String>
                        (getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1,pizzas);

                binding.textOrderTotal.setText( String.valueOf(scarletPizzaController.getStoreOrders().getOrder(Integer.parseInt(selectedItem)).getTotal()));
                binding.listView1.setAdapter(adapter);

            }

            /**
             * onNothingSelected method tells program what to do if user doesn't select any item
             * @param adapterView AdapterView
             */
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        binding.button.setOnClickListener(new View.OnClickListener() {

            /**
             * onClick method tells program what to do when user clicks something int the view
             * @param view View
             */
            @Override
            public void onClick(View view) {

                if (orderId ==-1 ) {
                    AlertDialog.Builder alertDialog =
                            new AlertDialog.Builder(getActivity());

                    alertDialog.setMessage("There is no order to cancel")
                            .setCancelable(true)
                            .setNegativeButton("OK", new DialogInterface.OnClickListener() {

                                /**
                                 * onClick method tells progrma what to do when user clicks something
                                 * @param dialog DialogInterface
                                 * @param which integer
                                 */
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.create().show();
                } else {
                    AlertDialog.Builder alertDialog =
                            new AlertDialog.Builder(getActivity());

                    alertDialog.setMessage("Order is canceled")
                            .setCancelable(true)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                                /**
                                 * onClick method tells program what to do when user clicks something
                                 * @param dialog DialogInterface
                                 * @param which integer
                                 */
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    Order order = scarletPizzaController.getStoreOrders().getOrder(orderId );
                                    scarletPizzaController.getStoreOrders().remove(order);
                                    order_numbers.remove(String.valueOf(orderId));
                                    adapter_orders.notifyDataSetChanged();
                                    orderId = -1;
                                    binding.textOrderTotal.setText("");
                                    pizzas.clear();
                                    adapter.notifyDataSetChanged();
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.create().show();
                }
            }
        });
    }

    /**
     * onDestroyView method destroys the view fragment for store orders when user is done
     *      with this activity
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
