package com.example.nowor_000.fragmentdinamico;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, BlankFragment.OnFragmentInteractionListener {

    Button botonAñade, botonBorra;

    LinearLayout linearFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonAñade = (Button)findViewById(R.id.buttonAñade);
        botonBorra = (Button)findViewById(R.id.buttonBorra);
        botonAñade.setOnClickListener(this);
        botonBorra.setOnClickListener(this);

        linearFragment=(LinearLayout) findViewById(R.id.layout_fragments);


    }



    @Override
    public void onClick(View v) {

        BlankFragment fragment=null;

        //administrador de fragmentos
        android.app.FragmentManager fragmentManager = getFragmentManager();


        //administrador de transacciones
        android.app.FragmentTransaction transaction = fragmentManager.beginTransaction();


        if(v.getId()==R.id.buttonAñade){

            //creamos un fragment y lo añadimos a la transaccion
            fragment = new BlankFragment();

            transaction.add(R.id.layout_fragments, fragment,"fragDinamico").commit();


        }else if(v.getId()==R.id.buttonBorra){

/**
 *          if(null!=fragment)
 transaction.remove(fragment).commit();

 */

            linearFragment.removeAllViews();

            Toast.makeText(getApplicationContext(), "Ahora ya no eres nada jaja", Toast.LENGTH_SHORT).show();

        }


    }




    /**
     * EN CASOD DE NO IMPLEMENTAR OnFragmentInteractionListener. Nos dara el siguiente Error:
     * java.lang.ClassCastException: com.example.nowor_000.fragmentdinamico.MainActivity@1b401699 must implement OnFragmentInteractionListener
     * @param uri
     */
    @Override
    public void onFragmentInteraction(Uri uri) {

    }






}

