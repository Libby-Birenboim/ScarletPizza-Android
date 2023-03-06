package com.example.scarlettpizza;

/**
 * CurrentOrderFragment is the Fragment for the current orders
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
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.scarlettpizza.databinding.FragmentCurrentOrderBinding;
import com.example.scarlettpizza.models.Order;
import com.example.scarlettpizza.models.Pizza;

import java.util.ArrayList;

public class CurrentOrderFragment extends Fragment {

    private FragmentCurrentOrderBinding binding;
    private ArrayList<String> pizzas;
    private ScarletPizzaController scarletPizzaController = ScarletPizzaController.getInstance();

    /**
     * onCreateView creates the view or the current orders
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

        binding = FragmentCurrentOrderBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    /**
     * onViewCreated tells program to show pizzas when the view is created
     * @param view View
     * @param savedInstanceState Bundle
     */
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pizzas = new ArrayList<String>();
        int index=0;
        for (Pizza pizza :  scarletPizzaController.getCurrentOrder().getPizzaList()){
            pizzas.add(pizza.toString());
            index++;
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>
                (getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1,pizzas);

        FillInformation();
        binding.listView1.setAdapter(adapter);
        binding.listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            /**
             * onItemClick tells program what to do when the user clicks items when building pizza
             * @param parent AdapterView
             * @param view View
             * @param position integer
             * @param id long
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                AlertDialog.Builder alertDialog =
                        new AlertDialog.Builder(getActivity());

                alertDialog.setMessage(pizzas.get(position))
                        .setCancelable(true)
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                            /**
                             * onClick method tells program what to do when user clicks
                             * @param dialog DialogInterface
                             * @param which integer
                             */
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                            /**
                             * onClick method tells program what ot do when user clicks certain things in the view
                             * @param dialog DialogInterface
                             * @param which integer
                             */
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Pizza p = scarletPizzaController.getCurrentOrder().getPizzaList().get(position);
                                scarletPizzaController.getCurrentOrder().remove(p);
                                pizzas.remove(position);
                                adapter.notifyDataSetChanged();
                                FillInformation();
                                dialog.dismiss();
                            }
                        });
                alertDialog.create().show();

            }
        });
        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {

            /**
             * onClick method tells program what to do when user clicks something in the view
             * @param view View
             */
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CurrentOrderFragment.this)
                        .navigate(R.id.action_CurrentOrderFragment_to_MPFragment);
            }
        });
        binding.buttonClear.setOnClickListener(new View.OnClickListener() {

            /**
             * onClick method tells program what to do when user clicks
             * @param view View
             */
            @Override
            public void onClick(View view) {
                Order currentOrder = scarletPizzaController.getCurrentOrder();
                if (currentOrder.getPizzaList().size() == 0) {
                    AlertDialog.Builder alertDialog =
                            new AlertDialog.Builder(getActivity());

                    alertDialog.setMessage("Order is already cleared")
                            .setCancelable(true)
                            .setNegativeButton("OK", new DialogInterface.OnClickListener() {

                                /**
                                 * onClick method tells program what to do when user clicks something
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

                    alertDialog.setMessage("Order is already cleared")
                            .setCancelable(true)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                                /**
                                 * onClick method tells program what to do when user clicks certain buttons
                                 *       in the current order view
                                 * @param dialog DialogInterface
                                 * @param which integer
                                 */
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    currentOrder.clearOrder();
                                    pizzas.clear();
                                    adapter.notifyDataSetChanged();
                                    FillInformation();
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.create().show();

                }
            }
        });

        binding.buttonPlaceOrder.setOnClickListener(new View.OnClickListener() {

            /**
             * onClick method tells program what to do when user clicks
             * @param view View
             */
            @Override
            public void onClick(View view) {
                Order currentOrder = scarletPizzaController.getCurrentOrder();
                if (currentOrder.getPizzaList().size() == 0) {
                    AlertDialog.Builder alertDialog =
                            new AlertDialog.Builder(getActivity());

                    alertDialog.setMessage("The are no pizzas in the order")
                            .setCancelable(true)
                            .setNegativeButton("OK", new DialogInterface.OnClickListener() {

                                /**
                                 * onClick method tells program what to do when user clicks certain things
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

                    alertDialog.setMessage("You placed a new Order")
                            .setCancelable(true)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                                /**
                                 * onClick method tells program what to do when user clicks
                                 * @param dialog DialogInterface
                                 * @param which integer
                                 */
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    scarletPizzaController.getStoreOrders().add(currentOrder);
                                    scarletPizzaController.createNewOrder();
                                    dialog.dismiss();

                                }
                            });
                    alertDialog.create().show();
                    NavHostFragment.findNavController(CurrentOrderFragment.this)
                            .navigate(R.id.action_CurrentOrderFragment_to_MPFragment);
                }
            }
        });
    }

    /**
     * FillInformation fills the information about the current order in the view
     */
    public void FillInformation(){
        TextView orderNumber = binding.textOrderNumber;
        TextView salesTotal = binding.textSubTotal;
        TextView salesTax = binding.textSalesTax;
        TextView orderTotal = binding.textOrderTotal;
        Order currentOrder = scarletPizzaController.getCurrentOrder();
        orderNumber.setText(Integer.toString(currentOrder.getOrderNumber()));
        salesTotal.setText(String.format("%.2f",currentOrder.getSalesTotal()));
        orderTotal.setText(String.format("%.2f",currentOrder.getTotal()));
        salesTax.setText(String.format("%.2f",currentOrder.getSalesTax()));

    }

    /**
     * onDestroyView method destroys the current order view
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
