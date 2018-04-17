package com.example.sathya.receivedata2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.app.PendingIntent.getActivity;

/**
 * Created by Sathya on 12-12-2017.
 */

public class fetchData extends AsyncTask<Void,Void,Void> {
    String data="";
    String dataParsed="";
    String singleParsed="";
    String sv="";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
       sv=MainActivity.reg.getText().toString().trim();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://github.com/meghnalohani/jsonserver/blob/master/db.json");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";

            //String sv=MainActivity.reg.getText().toString();

            int flag = 0;
           while(line!=null)
            {line=bufferedReader.readLine();
                data=data+line;}
            JSONArray JA=new JSONArray(data);

            for(int i=0;i<JA.length();i++) {
                //jsonObject.getAsJsonObject("data").getAsJsonObject().get("data2").getAsJsonObject("value").getAsString();
                {
                    JSONObject JO = (JSONObject) JA.get(i);
                    String rno = JO.getString("reg");


                    if (sv.equalsIgnoreCase(rno))
                    {

                            //JO.getAsJsonObject("data").getAsJsonObject().get("data2").getAsJsonObject("value").getAsString();
                            singleParsed = "Reg No:" + JO.get("reg") + "\n" +
                                    "Name:" + JO.get("name") + "\n" +
                                    "Branch:" + JO.get("branch") + "\n";


                            dataParsed = dataParsed + singleParsed + "\n";
                            flag = 1;
                            break;
                        }


                    }
                    if (flag == 0)
                        dataParsed = "Invalid Registration Number";
                }



    } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


        @Override
    protected void onPostExecute(Void aVoid) {


        MainActivity.data.setText(this.dataParsed);


    }








        }
