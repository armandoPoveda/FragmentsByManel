package mviel.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class Fragment1 extends Fragment {
    private RelativeLayout layoutF1;
    private FragmentManager fm;
    private FragmentTransaction ft;

    public Fragment1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        layoutF1 = (RelativeLayout) v.findViewById(R.id.layoutF1);

                layoutF1.setOnClickListener(new View.OnClickListener() {
                    @Override

          public void onClick(View v) {

                                fm = getFragmentManager();
                                ft = fm.beginTransaction();
                                if(!((MainActivity)getActivity()).estaFragment2EnActivity()) {


                                    Toast.makeText(getActivity(), "Mostrando Fragment 2", Toast.LENGTH_SHORT).show();
                                   ft.add(R.id.canto_superior_dret, Fragment2.newInstance("", ""));

                                   ft.addToBackStack("");

                                   ft.commit();
                               }

                       if(((MainActivity)getActivity()).estaFragment3EnActivity()){
                            Toast.makeText(getActivity(), "No pudes ocultar el Fragment 2 ya que tendrás que ocultar primero el 3", Toast.LENGTH_SHORT).show();
                        }
                     else if(((MainActivity)getActivity()).estaFragment2EnActivity()) {
                          Toast.makeText(getActivity(), "Eliminando Fragment 2 con un click", Toast.LENGTH_SHORT).show();
                           ft.remove(getActivity().getFragmentManager().findFragmentById(R.id.canto_superior_dret));
                            fm.popBackStack();
                       }

                    }
        });
        layoutF1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                fm = getFragmentManager();
                ft = fm.beginTransaction();
                if (((MainActivity) getActivity()).estaFragment3EnActivity()) {
                    Toast.makeText(getActivity(), "Eliminando Fragments 2 y 3 con click largo", Toast.LENGTH_SHORT).show();
                    ft.remove(getActivity().getFragmentManager().findFragmentById(R.id.canto_superior_dret));
                    ft.remove(getActivity().getFragmentManager().findFragmentById(R.id.canto_inferior_dret));
              fm.popBackStack();
                    fm.popBackStack();
                } else if (!((MainActivity) getActivity()).estaFragment3EnActivity() && ((MainActivity) getActivity()).estaFragment2EnActivity()) {
                    Toast.makeText(getActivity(), "Eliminando Fragment 2 con click largo", Toast.LENGTH_SHORT).show();
                    ft.remove(getActivity().getFragmentManager().findFragmentById(R.id.canto_superior_dret));
                    fm.popBackStack();
                } else {
                    Toast.makeText(getActivity(), "No se puede eliminar ningún Fragment", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
                return v;
            }
        }
