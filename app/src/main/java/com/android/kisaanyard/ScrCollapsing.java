package com.android.kisaanyard;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.kisaanyard.Adapter.HomeAdapter;
import com.android.kisaanyard.Model.HomeModel;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;

public class ScrCollapsing extends AppCompatActivity {


    private PieChart pieChartTM, pieChartKM, pieChartFarmer, pieChartAuction, pieChartTrade, pieChartStock,pieNew,pieNeww,pieChartAuctionnew,pieChartTradenew;
    ArrayList pieEntries;
    PieData pieData;
    PieDataSet pieDataSet;
    ArrayList<Entry> NoOfEmp = new ArrayList<>();
    private RecyclerView recyclerView;
    private HomeAdapter adapter;
    private ImageView iv_imgaenew, iv_imgae;
    private ArrayList<HomeModel> list;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing);
        //initToolbarUi();
//        Toolbar toolbar = findViewById(R.id.toolbar);
        AppBarLayout appBarLayout = findViewById(R.id.app_bar);

        Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar1);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        final CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingToolbar);


        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                if (scrollRange == -1){
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0){
                    collapsingToolbarLayout.setTitle("KissanYard");
                    isShow = false;
                }else{
                    collapsingToolbarLayout.setTitle("");
                    isShow = true;
                }
            }
        });



        iv_imgae = findViewById(R.id.iv_maize);

        list = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerview);


        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.HORIZONTAL);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new HomeAdapter(this);
        recyclerView.setAdapter(adapter);

        list.add(new HomeModel(1,"Channa"));
        list.add(new HomeModel(1,"Maize"));
        list.add(new HomeModel(1,"Masoor"));
        list.add(new HomeModel(1,"Onion"));
        adapter.setList(list);

        adapter.notifyDataSetChanged();

        pieChartTM = findViewById(R.id.pieChartTM);
        pieChartKM = findViewById(R.id.pieChartKM);
        pieChartFarmer = findViewById(R.id.pieChartFarmer);
        pieChartAuction = findViewById(R.id.pieChartAuction);
        pieChartTrade = findViewById(R.id.pieChartTrade);
        pieChartStock = findViewById(R.id.pieChartStock);
        pieNew=findViewById(R.id.pieNew);
        pieNeww=findViewById(R.id.pieNeww);
        pieChartTradenew=findViewById(R.id.pieChartTradenew);
        pieChartAuctionnew=findViewById(R.id.pieChartAuctionnew);
        drawTmChart();
        drawKMChart();
        drawFarmerChart();
        drawAuctionChart();
        drawTradeChart();
        drawStock();
        drawA();
        drawB();
        drawC();
        drawD();


        pieChartStock.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });


        pieChartKM.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });

        pieChartTM.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });

        pieChartAuction.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });

        pieChartAuction.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });

        pieChartFarmer.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });




    }

    public void drawTmChart() {
     /*   NoOfEmp = new ArrayList<>();
        NoOfEmp.add(new Entry(945f, 0));
        PieDataSet dataSet = new PieDataSet(NoOfEmp, "");
        ArrayList<String> year = new ArrayList<>();
        year.add("");
        PieData data = new PieData( dataSet);
        data.setValueTypeface(tf);
        data.setValueTextSize(14f);
        pieChartTM.setData(data);
        dataSet.setColors(ColorTemplate.LIBERTY_COLORS);
        pieChartTM.animateXY(3000, 3000);
       // pieChartTM.setDescription("");
        pieChartTM.setCenterText("TM");
       // pieChartTM.setCenterTextColor(getResources().getColor(R.color.b));
        pieChartTM.getLegend().setEnabled(false);
        pieChartTM.setCenterTextTypeface(tf);
      //  pieChartTM.setOnChartValueSelectedListener(this);*/
        pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(2f, "Kissan"));
        pieEntries.add(new PieEntry(4f, "Taluka"));
       /* pieEntries.add(new PieEntry(6f, "kkk"));
        pieEntries.add(new PieEntry(8f, "lll"));
*/
        pieDataSet = new PieDataSet(pieEntries, "");
        pieData = new PieData(pieDataSet);
        pieChartStock.setData(pieData);
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieDataSet.setSliceSpace(2f);
        pieDataSet.setValueTextColor(Color.WHITE);
        pieDataSet.setValueTextSize(10f);
        pieDataSet.setSliceSpace(5f);
        pieChartStock.setDescription(null);
        pieChartStock.getLegend().setEnabled(false);

        pieChartStock.setCenterText("Stock" );

        pieChartStock.animateXY(1000, 1000);



    }

    public void drawKMChart() {
      /*  NoOfEmp = new ArrayList<>();
        NoOfEmp.add(new Entry(500f, 0));
        PieDataSet dataSet = new PieDataSet(NoOfEmp, "");
        ArrayList<String> year = new ArrayList<>();
        year.add("");
        PieData data = new PieData( dataSet);
        data.setValueTypeface(tf);
        data.setValueTextSize(14f);
        pieChartKM.setData(data);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieChartKM.animateXY(3000, 3000);
      //  pieChartKM.setDescription("");
        pieChartKM.setCenterText("KM");
        //pieChartKM.setCenterTextColor(getResources().getColor(R.color.txtColor));
        pieChartKM.getLegend().setEnabled(false);
        pieChartKM.setCenterTextTypeface(tf);
       // pieChartKM.setOnChartValueSelectedListener(this);*/
        pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(2f, "KM"));
        pieEntries.add(new PieEntry(4f, "DM"));
        pieEntries.add(new PieEntry(6f, "TM"));
        pieEntries.add(new PieEntry(8f, "Approve"));
        pieEntries.add(new PieEntry(7f, "Pending"));
     //   pieEntries.add(new PieEntry(3f, "f"));
        pieDataSet = new PieDataSet(pieEntries, "");
        pieData = new PieData(pieDataSet);
        pieChartKM.setData(pieData);
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieDataSet.setSliceSpace(2f);
        pieDataSet.setValueTextColor(Color.WHITE);
        pieDataSet.setValueTextSize(10f);
        pieDataSet.setSliceSpace(5f);
        pieChartKM.setDescription(null);
        pieChartKM.getLegend().setEnabled(false);
        pieChartKM.setCenterText("Kisan Mitra" );
        pieChartKM.animateXY(1000, 1000);

    }

    public void drawFarmerChart() {
        /*NoOfEmp = new ArrayList<>();
        NoOfEmp.add(new Entry(400f, 0));
        PieDataSet dataSet = new PieDataSet(NoOfEmp, "");
        ArrayList<String> year = new ArrayList<>();
        year.add("");
        PieData data = new PieData( dataSet);
        data.setValueTypeface(tf);
        data.setValueTextSize(14f);
        pieChartFarmer.setData(data);
        dataSet.setColors(ColorTemplate.PASTEL_COLORS);
        pieChartFarmer.animateXY(3000, 3000);
      //  pieChartFarmer.setDescription("");
        pieChartFarmer.setCenterText("Farmer");
     //   pieChartFarmer.setCenterTextColor(getResources().getColor(R.color.txtColor));
        pieChartFarmer.getLegend().setEnabled(false);
        pieChartFarmer.setCenterTextTypeface(tf);
       // pieChartFarmer.setOnChartValueSelectedListener(this);*/

        pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(2f, "Farmer"));
        pieEntries.add(new PieEntry(4f, "TM"));

        pieDataSet = new PieDataSet(pieEntries, "");
        pieData = new PieData(pieDataSet);
        pieChartTM.setData(pieData);
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieDataSet.setSliceSpace(2f);
        pieDataSet.setValueTextColor(Color.WHITE);
        pieDataSet.setValueTextSize(9f);
        pieDataSet.setSliceSpace(5f);
        pieChartTM.setDescription(null);
        pieChartTM.getLegend().setEnabled(false);
        pieChartTM.setCenterText("Taluka Mitra" );
        pieChartTM.animateXY(1000, 1000);

    }

    public void drawAuctionChart() {
      /*  NoOfEmp = new ArrayList<>();
        NoOfEmp.add(new Entry(400f, 0));
        NoOfEmp.add(new Entry(300f, 0));
        PieDataSet dataSet = new PieDataSet(NoOfEmp, "");
        ArrayList<String> year = new ArrayList<>();
        year.add("Sell");
        year.add("Buy");
        PieData data = new PieData( dataSet);
        data.setValueTypeface(tf);
        data.setValueTextSize(14f);
        pieChartAuction.setData(data);
        dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        pieChartAuction.animateXY(3000, 3000);
   //     pieChartAuction.setDescription("");
        pieChartAuction.setCenterText("Auction");
     //   pieChartAuction.setCenterTextColor(getResources().getColor(R.color.txtColor));
        pieChartAuction.getLegend().setEnabled(false);
        pieChartAuction.setCenterTextTypeface(tf);
     //   pieChartAuction.setOnChartValueSelectedListener(this);*/

        pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(2f, "Approve"));
        pieEntries.add(new PieEntry(4f, "Pending"));
        pieEntries.add(new PieEntry(6f, "Assign"));

        pieDataSet = new PieDataSet(pieEntries, "");
        pieData = new PieData(pieDataSet);
        pieChartFarmer.setData(pieData);
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieDataSet.setSliceSpace(2f);
        pieDataSet.setValueTextColor(Color.WHITE);
        pieDataSet.setValueTextSize(10f);
        pieDataSet.setSliceSpace(5f);
        pieChartFarmer.setDescription(null);
        pieChartFarmer.getLegend().setEnabled(false);
        pieChartFarmer.setCenterText("Farmer" );
        pieChartFarmer.animateXY(1000, 1000);

    }

    public void drawTradeChart() {
       /* NoOfEmp = new ArrayList<>();
        NoOfEmp.add(new Entry(250f, 0));
        NoOfEmp.add(new Entry(350f, 0));
        PieDataSet dataSet = new PieDataSet(NoOfEmp, "");
        ArrayList<String> year = new ArrayList<>();
        year.add("Sell");
        year.add("Buy");
        PieData data = new PieData( dataSet);
        data.setValueTypeface(tf);
        data.setValueTextSize(14f);
        pieChartTrade.setData(data);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieChartTrade.animateXY(3000, 3000);
     //   pieChartTrade.setDescription("");
        pieChartTrade.setCenterText("Trade");
        //pieChartTrade.setCenterTextColor(getResources().getColor(R.color.txtColor));
        pieChartTrade.getLegend().setEnabled(false);
        pieChartTrade.setCenterTextTypeface(tf);
       // pieChartTrade.setOnChartValueSelectedListener(this);*/


        pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(2f, "Assigned"));
        pieEntries.add(new PieEntry(4f, "Pending"));
     //   pieEntries.add(new PieEntry(6f, "uu"));
    //    pieEntries.add(new PieEntry(8f, "bb"));
      //  pieEntries.add(new PieEntry(7f, "hhh"));
        //pieEntries.add(new PieEntry(3f, "ooo"));
        pieDataSet = new PieDataSet(pieEntries, "");
        pieData = new PieData(pieDataSet);
        pieChartAuction.setData(pieData);
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieDataSet.setSliceSpace(2f);
        pieDataSet.setValueTextColor(Color.WHITE);
        pieDataSet.setValueTextSize(10f);
        pieDataSet.setSliceSpace(5f);
        pieChartAuction.setDescription(null);
        pieChartAuction.getLegend().setEnabled(false);
        pieChartAuction.setCenterText("Auction" );
        pieChartAuction.animateXY(1000, 1000);

    }

    public void drawStock() {
        pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(2f, "KM"));
        pieEntries.add(new PieEntry(4f, "TM"));
        pieEntries.add(new PieEntry(6f, "DM"));
        pieEntries.add(new PieEntry(8f, "Farmer"));

        pieDataSet = new PieDataSet(pieEntries, "");
        pieData = new PieData(pieDataSet);

        pieChartTrade.setData(pieData);
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieDataSet.setSliceSpace(2f);
        pieDataSet.setValueTextColor(Color.WHITE);
        pieDataSet.setValueTextSize(10f);
        pieDataSet.setSliceSpace(5f);
        pieChartTrade.setDescription(null);
        pieChartTrade.setCenterText("" );
        pieChartTrade.setCenterTextSize(14f);
        pieChartTrade.getLegend().setEnabled(false);
        pieChartTrade.animateXY(1000, 1000);
        pieChartTrade.setCenterText("Hello" );

    }




    public void drawA() {
        pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(2f, "ss"));
        pieEntries.add(new PieEntry(4f, "jjjj"));
        pieEntries.add(new PieEntry(6f, "iii"));
        pieEntries.add(new PieEntry(8f, "kkk"));

        pieDataSet = new PieDataSet(pieEntries, "");
        pieData = new PieData(pieDataSet);

        pieNew.setData(pieData);
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieDataSet.setSliceSpace(2f);
        pieDataSet.setValueTextColor(Color.WHITE);
        pieDataSet.setValueTextSize(10f);
        pieDataSet.setSliceSpace(5f);
        pieNew.setDescription(null);
        pieNew.setCenterText("" );
        pieNew.setCenterTextSize(14f);
        pieNew.getLegend().setEnabled(false);
        pieNew.animateXY(1000, 1000);
        pieNew.setCenterText("Hello" );

    }


    public void drawB() {
        pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(2f, "Taluka"));
        pieEntries.add(new PieEntry(4f, "Kisan"));
        pieEntries.add(new PieEntry(6f, "District"));
      //  pieEntries.add(new PieEntry(8f, "kkk"));

        pieDataSet = new PieDataSet(pieEntries, "");
        pieData = new PieData(pieDataSet);

        pieNeww.setData(pieData);
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieDataSet.setSliceSpace(2f);
        pieDataSet.setValueTextColor(Color.WHITE);
        pieDataSet.setValueTextSize(10f);
        pieDataSet.setSliceSpace(5f);
        pieNeww.setDescription(null);
        pieNeww.setCenterText("" );
        pieNeww.setCenterTextSize(14f);
        pieNeww.getLegend().setEnabled(false);
        pieNeww.animateXY(1000, 1000);
        pieNeww.setCenterText("Hello" );

    }


    public void drawC() {
        pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(2f, "ss"));
        pieEntries.add(new PieEntry(4f, "jjjj"));
        pieEntries.add(new PieEntry(6f, "iii"));
        pieEntries.add(new PieEntry(8f, "kkk"));

        pieDataSet = new PieDataSet(pieEntries, "");
        pieData = new PieData(pieDataSet);

        pieChartTradenew.setData(pieData);
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieDataSet.setSliceSpace(2f);
        pieDataSet.setValueTextColor(Color.WHITE);
        pieDataSet.setValueTextSize(10f);
        pieDataSet.setSliceSpace(5f);
        pieChartTradenew.setDescription(null);
        pieChartTradenew.setCenterText("" );
        pieChartTradenew.setCenterTextSize(14f);
        pieChartTradenew.getLegend().setEnabled(false);
        pieChartTradenew.animateXY(1000, 1000);
        pieChartTradenew.setCenterText("Hello" );

    }


    public void drawD() {
        pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(2f, "ss"));
        pieEntries.add(new PieEntry(4f, "jjjj"));
        pieEntries.add(new PieEntry(6f, "iii"));
        pieEntries.add(new PieEntry(8f, "kkk"));

        pieDataSet = new PieDataSet(pieEntries, "");
        pieData = new PieData(pieDataSet);

        pieChartAuctionnew.setData(pieData);
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieDataSet.setSliceSpace(2f);
        pieDataSet.setValueTextColor(Color.WHITE);
        pieDataSet.setValueTextSize(10f);
        pieDataSet.setSliceSpace(5f);
        pieChartAuctionnew.setDescription(null);
        pieChartAuctionnew.setCenterText("" );
        pieChartAuctionnew.setCenterTextSize(14f);
        pieChartAuctionnew.getLegend().setEnabled(false);
        pieChartAuctionnew.animateXY(1000, 1000);
        pieChartAuctionnew.setCenterText("Hello" );

    }


    /*private void initToolbarUi() {

        androidx.appcompat.widget.Toolbar toolbar = (Toolbar) findViewById(R.id.def_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("HomeScreen");//getResources().getString(R.string.register)
    }*/
}
