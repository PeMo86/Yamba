package co.edu.udea.cmovil.gr2.yamba;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.thenewcircle.yamba.client.YambaClient;

import java.nio.charset.MalformedInputException;

/**
 * Created by CarlosAlberto on 16/09/2015.
 */
public class PostTask extends AsyncTask<String ,Void,String> {
    private static final String TAG=StatusActivity.class.getSimpleName();
    private ProgressDialog progress;


    private Context nombre;
    public PostTask(String TAG,Context nombre){
        this.nombre=nombre;
        progress=new ProgressDialog(nombre);
    }

    @Override
    protected void onPreExecute(){
    }

    @Override
    protected String doInBackground(String... params){

        try{
            YambaClient cloud = new YambaClient("student","password");
            cloud.postStatus(params[0]);
            Log.d(TAG, "Succesfully posted to the cloud"+params[0]);
            return "Successfully posted";

        }
        catch (Exception e){


            Log.e(TAG,"Failed to post to the cloud",e);
            e.printStackTrace();
            return "Failed to post";}

    }

@Override
    protected  void onPostExecute(String result){
    progress.dismiss();
    if (this!=null && result!=null)
        Toast.makeText(nombre,result,Toast.LENGTH_LONG).show();


}


}
