package com.example.piotr.rankingszachowy;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Piotr on 01.04.2017.
 */

public class CurrentTournamentsFragment extends Fragment {


    TabHost host;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_currenttournaments, container, false);


        host = (TabHost) view.findViewById(R.id.tabHost);
        host.setup();

        TabHost.TabSpec spec = host.newTabSpec(view.getResources().getString(R.string.open_tournaments_tab));
        spec.setContent(R.id.tab_open);
        spec.setIndicator(view.getResources().getString(R.string.open_tournaments_tab));
        host.addTab(spec);

        spec = host.newTabSpec(view.getResources().getString(R.string.closed_tournaments_tab));
        spec.setContent(R.id.tab_closed);
        spec.setIndicator(view.getResources().getString(R.string.closed_tournaments_tab));
        host.addTab(spec);

        spec = host.newTabSpec(view.getResources().getString(R.string.finished_tournaments_tab));
        spec.setContent(R.id.tab_finished);
        spec.setIndicator(view.getResources().getString(R.string.finished_tournaments_tab));
        host.addTab(spec);

        CreateTables(view);

        Button btnCreateTournament = (Button) view.findViewById(R.id.btnCreateTournament);
        btnCreateTournament.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                AddTournamentFragment addTournamentsFragment = new AddTournamentFragment();

                transaction.replace(R.id.fragmentContainer, addTournamentsFragment);
                transaction.addToBackStack(null);

                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction.commit();
            }
        });

        return view;
    }

    private void CreateTables(View view){

        TableLayout tblOpen = (TableLayout) view.findViewById(R.id.tblOpenTournaments);
        TableLayout tblClosed = (TableLayout) view.findViewById(R.id.tblClosedTournaments);
        TableLayout tblFinished = (TableLayout) view.findViewById(R.id.tblFinishedTournaments);

        //Setting up Open Tournaments Rows
        TableRow tbrHeader = new TableRow(getActivity());

        TextView tv = new TextView(getActivity());
        tv.setText(view.getResources().getString(R.string.tournamentHeader_fragment));
        tv.setBackgroundColor(Color.LTGRAY);
        tbrHeader.addView(tv);

        tv = new TextView(getActivity());
        tv.setText(view.getResources().getString(R.string.playersInvitedHeader_tab));
        tv.setBackgroundColor(Color.LTGRAY);
        tbrHeader.addView(tv);

        tv = new TextView(getActivity());
        tv.setText(view.getResources().getString(R.string.startDateHeader_tab));
        tv.setBackgroundColor(Color.LTGRAY);
        tbrHeader.addView(tv);

        tblOpen.addView(tbrHeader);
        tblOpen.setStretchAllColumns(true);

        //Setting up Closed Tournaments Rows
        tbrHeader = new TableRow(getActivity());

        tv = new TextView(getActivity());
        tv.setText(view.getResources().getString(R.string.tournamentHeader_fragment));
        tv.setBackgroundColor(Color.LTGRAY);
        tbrHeader.addView(tv);

        tv = new TextView(getActivity());
        tv.setText(view.getResources().getString(R.string.playersInvitedHeader_tab));
        tv.setBackgroundColor(Color.LTGRAY);
        tbrHeader.addView(tv);

        tv = new TextView(getActivity());
        tv.setText(view.getResources().getString(R.string.startDateHeader_tab));
        tv.setBackgroundColor(Color.LTGRAY);
        tbrHeader.addView(tv);

        tblClosed.addView(tbrHeader);
        tblClosed.setStretchAllColumns(true);

        //Setting up Finished Tournaments Rows
        tbrHeader = new TableRow(getActivity());

        tv = new TextView(getActivity());
        tv.setText(view.getResources().getString(R.string.tournamentHeader_fragment));
        tv.setBackgroundColor(Color.LTGRAY);
        tbrHeader.addView(tv);

        tv = new TextView(getActivity());
        tv.setText(view.getResources().getString(R.string.winnerHeader_tab));
        tv.setBackgroundColor(Color.LTGRAY);
        tbrHeader.addView(tv);

        tv = new TextView(getActivity());
        tv.setText(view.getResources().getString(R.string.startDateHeader_tab));
        tv.setBackgroundColor(Color.LTGRAY);
        tbrHeader.addView(tv);

        tv = new TextView(getActivity());
        tv.setText(view.getResources().getString(R.string.tournamentEndedHeader_tab));
        tv.setBackgroundColor(Color.LTGRAY);
        tbrHeader.addView(tv);

        tblFinished.addView(tbrHeader);
        tblFinished.setStretchAllColumns(true);

        AddContent(tblOpen, tblFinished);
    }

    //Used for filling tables with crap
    private void AddContent(TableLayout table, TableLayout table2){

        TableRow row;
        TextView tv;
        Random rng = new Random();

        for (int i = 0; i < 15; i++) {
            row = new TableRow(getActivity());

            tv = new TextView(getActivity());
            tv.setText("Row " + i + ": " + rng.nextInt(300));
            row.addView(tv);
            tv = new TextView(getActivity());
            tv.setText("Row " + i + ": " + rng.nextInt(300));
            row.addView(tv);
            tv = new TextView(getActivity());
            tv.setText("Row " + i + ": " + rng.nextInt(300));
            row.addView(tv);

            table.addView(row);


            row = new TableRow(getActivity());
            tv = new TextView(getActivity());
            tv.setText("Row " + i + ": " + rng.nextInt(300));
            row.addView(tv);
            tv = new TextView(getActivity());
            tv.setText("Row " + i + ": " + rng.nextInt(300));
            row.addView(tv);
            tv = new TextView(getActivity());
            tv.setText("Row " + i + ": " + rng.nextInt(300));
            row.addView(tv);
            tv = new TextView(getActivity());
            tv.setText("Row " + i + ": " + rng.nextInt(300));
            row.addView(tv);

            table2.addView(row);
        }
    }
}
