package gal.rodrigosambade.multimedia.localhostvideo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView;
    private EditText url;
    private TextView status;

    private final ActivityResultLauncher<String> localNetworkPermission =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), granted -> {
                if (granted) play();
                else status.setText("Sin permiso de red local");
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.videoView);
        url = findViewById(R.id.etUrl);
        status = findViewById(R.id.tvStatus);
        Button play = findViewById(R.id.btnPlay);

        MediaController controller = new MediaController(this);
        controller.setAnchorView(videoView);
        videoView.setMediaController(controller);

        videoView.setOnPreparedListener(mp -> {
            mp.setLooping(true);
            status.setText("Reproduciendo en bucle");
            videoView.start();
        });
        videoView.setOnCompletionListener(mp -> videoView.start());
        videoView.setOnErrorListener((mp, what, extra) -> {
            status.setText("No se pudo reproducir. ¿Está arrancado el servidor?");
            return true;
        });

        play.setOnClickListener(v -> ensurePermissionAndPlay());
    }

    private void ensurePermissionAndPlay() {
        if (Build.VERSION.SDK_INT >= 37 &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_LOCAL_NETWORK)
                        != PackageManager.PERMISSION_GRANTED) {
            localNetworkPermission.launch(Manifest.permission.ACCESS_LOCAL_NETWORK);
        } else {
            play();
        }
    }

    private void play() {
        String text = url.getText().toString().trim();
        if (!LoopUrlValidator.isEmulatorHostUrl(text)) {
            status.setText("Usa una URL http(s) válida; para el ejercicio se espera 10.0.2.2");
            return;
        }
        status.setText("Conectando…");
        videoView.setVideoURI(Uri.parse(text));
        videoView.requestFocus();
        videoView.start();
    }
}
