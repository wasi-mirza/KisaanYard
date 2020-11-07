package general;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.os.AsyncTask;
import android.os.Environment;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.android.kisaanyard.R;

public class ImageDownloader extends AsyncTask<String, String, String> {

    private Context context;
    private ProgressDialog pDialog;
    String image_url;
    URL ImageUrl;
    String myFileUrl1;
    Bitmap bmImg = null;

    public ImageDownloader(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub

        super.onPreExecute();

        pDialog = new ProgressDialog(context);
        pDialog.setMessage("Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

    }

    @Override
    protected String doInBackground(String... args) {
        // TODO Auto-generated method stub

        InputStream is = null;

        try {
            ImageUrl = new URL(args[0]);
            image_url= args[0];
            // myFileUrl1 = args[0];

            HttpURLConnection conn = (HttpURLConnection) ImageUrl
                    .openConnection();
            conn.setDoInput(true);
            conn.connect();
            is = conn.getInputStream();

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Config.RGB_565;
            bmImg = BitmapFactory.decodeStream(is, null, options);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            String path = ImageUrl.getPath();
            String idStr = path.substring(path.lastIndexOf('/') + 1);
            File filepath = Environment.getExternalStorageDirectory();
            File dir = new File(filepath.getAbsolutePath()
                    + "/One App Guru/");
            dir.mkdirs();
            String fileName = idStr;
            File file = new File(dir, fileName);
            FileOutputStream fos = new FileOutputStream(file);
            bmImg.compress(CompressFormat.JPEG, 75, fos);
            fos.flush();
            fos.close();

            File imageFile = file;
            MediaScannerConnection.scanFile(context,
                    new String[] { imageFile.getPath() },
                    new String[] { "image/jpeg" }, null);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e) {
                }
            }
        }

        return null;
    }

    @Override
    protected void onPostExecute(String args) {
        // TODO Auto-generated method stub

        if (bmImg == null) {

            Toast.makeText(context, "Image still loading...",
                    Toast.LENGTH_SHORT).show();

            pDialog.dismiss();

        }

        else {

            if (pDialog!=null) {
                if (pDialog.isShowing()) {
                    pDialog.dismiss();
                }
            }
            AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(context);

// Setting Dialog Title
            alertDialog2.setTitle("Image Downloaded");

// Setting Dialog Message
            alertDialog2.setMessage("Image Saved To Device");

// Setting Icon to Dialog
            alertDialog2.setIcon(R.drawable.ic_attach_file_black_24dp);

// Setting Positive "Yes" Btn
            alertDialog2.setPositiveButton("View Attachment",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Write your code here to execute after dialog

                            Intent intent = new Intent(context,ImageViewSingleActivity.class);
                            intent.putExtra("image", image_url);
                            context.startActivity(intent);
                        }
                    });
// Setting Negative "NO" Btn
            alertDialog2.setNegativeButton("NO",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Write your code here to execute after dialog
                            //Toast.makeText(context,"You clicked on NO", Toast.LENGTH_SHORT).show();
                            dialog.cancel();
                        }
                    });

// Showing Alert Dialog
            alertDialog2.show();
            //Toast.makeText(context, "Image Successfully Saved",Toast.LENGTH_SHORT).show();

        }
    }

}