package com.ervin.bangundatarbangunruang.ui.detailbangun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ervin.bangundatarbangunruang.R;
import com.ervin.bangundatarbangunruang.data.Bangun;
import com.ervin.bangundatarbangunruang.data.BangunDatar;
import com.ervin.bangundatarbangunruang.data.BangunRuang;
import com.ervin.bangundatarbangunruang.ui.Helper;
import com.ervin.bangundatarbangunruang.ui.InputDynamicUtil;
import com.google.android.material.textfield.TextInputLayout;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class DetailBangunActivity extends AppCompatActivity {

    TextView tvRumus, tvKeterangn, tvHasilLuas, tvHasilKeliling, tvHasilVolume;
    LinearLayout llInput, llLuas, llKeliling, llVolume;
    DetailViewModel detailViewModel;
    ImageView ivDetail;
    Bangun bangun;
    DecimalFormat myFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_bangun);
        tvRumus = findViewById(R.id.tv_rumus_detail);
        tvKeterangn = findViewById(R.id.tv_keterangan_detail);
        tvHasilLuas = findViewById(R.id.tv_hasil_luas_detail);
        tvHasilKeliling = findViewById(R.id.tv_hasil_keliling_detail);
        tvHasilVolume = findViewById(R.id.tv_hasil_volume_detail);
        ivDetail = findViewById(R.id.iv_gambar_detail);
        llInput = findViewById(R.id.ll_input_detail);
        llKeliling = findViewById(R.id.ll_keliling);
        llLuas = findViewById(R.id.ll_luas);
        llVolume = findViewById(R.id.ll_volume);
        myFormatter = new DecimalFormat("#.##");
        detailViewModel = ViewModelProviders.of(this).get(DetailViewModel.class);
        bangun = getIntent().getParcelableExtra("bangun");
        String path = "@drawable/" + bangun.getBnagunPic();
        Glide.with(this)
                .load(this.getResources().getIdentifier(path, null, getPackageName()))
                .into(ivDetail);

        checkRumus(bangun.getBangunName());

    }

    void checkRumus(String bangun) {
        switch (bangun) {
            //bangun Datar
            case "Persegi":
                datar();
                persegi();
                break;
            case "Persegi Panjang":
                datar();
                persegiPanjang();
                break;
            case "Layang - Layang":
                datar();
                layangLayang();
                break;
            case "Belah Ketupat":
                datar();
                belahKetupat();
                break;
            case "Segitiga":
                datar();
                segitiga();
                break;
            case "Lingkaran":
                datar();
                lingkaran();
                break;
            case "Jajar Genjang":
                datar();
                jajargenjang();
                break;
            case "Trapesium":
                datar();
                trapesium();
                break;
                //bangun ruang
            case "Kubus":
                ruang();
                kubus();
                break;
            case "Balok":
                ruang();
                balok();
                break;
            case "Kerucut":
                ruang();
                kerucut();
                break;
            case "Bola":
                ruang();
                bola();
                break;
            case "Limas":
                ruang();
                limas();
                break;
            case "Prisma":
                ruang();
                prisma();
                break;
            case "Tabung":
                ruang();
                tabung();
                break;
        }
    }

    public void persegiPanjang() {
        tvRumus.setText(getString(R.string.rumus_persegipanjang));
        InputDynamicUtil.dynamicInput(this, llInput, 2, new String[]{"Masukan P", "Masukan L"}, new InputDynamicUtil.SetCallback() {
            @Override
            public void handlerInput(ArrayList<EditText> etList) {
                double p = Helper.parseDoubleOrNull(etList.get(0).getText().toString());
                double l = Helper.parseDoubleOrNull(etList.get(1).getText().toString());

                BangunDatar persegiPanjang = detailViewModel.persegiPanjang(p, l);

                tvHasilKeliling.setText(myFormatter.format(persegiPanjang.getKeliling()));
                tvHasilLuas.setText(myFormatter.format(persegiPanjang.getLuas()));
            }
        });
    }

    public void persegi() {
        tvRumus.setText(getString(R.string.rumus_persegi));
        InputDynamicUtil.dynamicInput(this, llInput, 1, new String[]{"Masukan S"}, new InputDynamicUtil.SetCallback() {
            @Override
            public void handlerInput(ArrayList<EditText> etList) {
                double s = Helper.parseDoubleOrNull(etList.get(0).getText().toString());

                BangunDatar persegi = detailViewModel.persegi(s);

                tvHasilKeliling.setText(myFormatter.format(persegi.getKeliling()));
                tvHasilLuas.setText(myFormatter.format(persegi.getLuas()));
            }
        });
    }

    public void layangLayang() {
        tvRumus.setText(getString(R.string.rumus_layang_layang));
        InputDynamicUtil.dynamicInput(this, llInput, 4, new String[]{"Masukan a", "Masukan b", "Masukan d1", "Masukan d2"}, new InputDynamicUtil.SetCallback() {
            @Override
            public void handlerInput(ArrayList<EditText> etList) {
                double a = Helper.parseDoubleOrNull(etList.get(0).getText().toString());
                double b = Helper.parseDoubleOrNull(etList.get(1).getText().toString());
                double d1 = Helper.parseDoubleOrNull(etList.get(2).getText().toString());
                double d2 = Helper.parseDoubleOrNull(etList.get(3).getText().toString());

                BangunDatar layangLayang = detailViewModel.layangLayang(d1, d2, a, b);

                tvHasilKeliling.setText(myFormatter.format(layangLayang.getKeliling()));
                tvHasilLuas.setText(myFormatter.format(layangLayang.getLuas()));
            }
        });
    }

    public void belahKetupat() {
        tvRumus.setText(getString(R.string.rumus_belah_ketupat));
        InputDynamicUtil.dynamicInput(this, llInput, 3, new String[]{"Masukan S", "Masukan d1", "Masukan d2"}, new InputDynamicUtil.SetCallback() {
            @Override
            public void handlerInput(ArrayList<EditText> etList) {
                double s = Helper.parseDoubleOrNull(etList.get(0).getText().toString());
                double d1 = Helper.parseDoubleOrNull(etList.get(1).getText().toString());
                double d2 = Helper.parseDoubleOrNull(etList.get(2).getText().toString());

                BangunDatar belahKetupat = detailViewModel.belahKetupat(s, d1, d2);

                tvHasilKeliling.setText(myFormatter.format(belahKetupat.getKeliling()));
                tvHasilLuas.setText(myFormatter.format(belahKetupat.getLuas()));
            }
        });
    }

    public void segitiga() {
        tvRumus.setText(getString(R.string.rumus_segitiga));
        InputDynamicUtil.dynamicInput(this, llInput, 4, new String[]{"Masukan a", "Masukan b", "Masukan c", "Masukan t"}, new InputDynamicUtil.SetCallback() {
            @Override
            public void handlerInput(ArrayList<EditText> etList) {
                double a = Helper.parseDoubleOrNull(etList.get(0).getText().toString());
                double b = Helper.parseDoubleOrNull(etList.get(1).getText().toString());
                double c = Helper.parseDoubleOrNull(etList.get(2).getText().toString());
                double t = Helper.parseDoubleOrNull(etList.get(3).getText().toString());

                BangunDatar segitiga = detailViewModel.segitiga(a, b, c, t);

                tvHasilKeliling.setText(myFormatter.format(segitiga.getKeliling()));
                tvHasilLuas.setText(myFormatter.format(segitiga.getLuas()));
            }
        });
    }

    public void lingkaran() {
        tvRumus.setText(getString(R.string.rumus_lingkaran));
        InputDynamicUtil.dynamicInput(this, llInput, 1, new String[]{"Masukan r"}, new InputDynamicUtil.SetCallback() {
            @Override
            public void handlerInput(ArrayList<EditText> etList) {
                double r = Helper.parseDoubleOrNull(etList.get(0).getText().toString());

                BangunDatar lingkaran = detailViewModel.lingkaran(r);

                tvHasilKeliling.setText(myFormatter.format(lingkaran.getKeliling()));
                tvHasilLuas.setText(myFormatter.format(lingkaran.getLuas()));
            }
        });
    }

    public void jajargenjang() {
        tvRumus.setText(getString(R.string.rumus_jajargenjang));
        InputDynamicUtil.dynamicInput(this, llInput, 3, new String[]{"Masukan a", "Masukan b", "Masukan t"}, new InputDynamicUtil.SetCallback() {
            @Override
            public void handlerInput(ArrayList<EditText> etList) {
                double a = Helper.parseDoubleOrNull(etList.get(0).getText().toString());
                double b = Helper.parseDoubleOrNull(etList.get(1).getText().toString());
                double t = Helper.parseDoubleOrNull(etList.get(2).getText().toString());

                BangunDatar jajargenjang = detailViewModel.jajargenjang(a, b, t);

                tvHasilKeliling.setText(myFormatter.format(jajargenjang.getKeliling()));
                tvHasilLuas.setText(myFormatter.format(jajargenjang.getLuas()));
            }
        });
    }

    public void trapesium() {
        tvRumus.setText(getString(R.string.rumus_trapesium));
        InputDynamicUtil.dynamicInput(this, llInput, 4, new String[]{"Masukan a", "Masukan b", "Masukan c", "Masukan t"}, new InputDynamicUtil.SetCallback() {
            @Override
            public void handlerInput(ArrayList<EditText> etList) {
                double a = Helper.parseDoubleOrNull(etList.get(0).getText().toString());
                double b = Helper.parseDoubleOrNull(etList.get(1).getText().toString());
                double c = Helper.parseDoubleOrNull(etList.get(2).getText().toString());
                double t = Helper.parseDoubleOrNull(etList.get(3).getText().toString());

                BangunDatar trapesium = detailViewModel.trapesium(a, b, c, t);

                tvHasilKeliling.setText(myFormatter.format(trapesium.getKeliling()));
                tvHasilLuas.setText(myFormatter.format(trapesium.getLuas()));
            }
        });
    }

    public void balok() {
        tvRumus.setText(getText(R.string.rumus_balok));
        InputDynamicUtil.dynamicInput(this, llInput, 3, new String[]{"Masukan p", "Masukan l", "Masukan t"}, new InputDynamicUtil.SetCallback() {
            @Override
            public void handlerInput(ArrayList<EditText> etList) {
                double p = Helper.parseDoubleOrNull(etList.get(0).getText().toString());
                double l = Helper.parseDoubleOrNull(etList.get(1).getText().toString());
                double t = Helper.parseDoubleOrNull(etList.get(2).getText().toString());

                BangunRuang balok = detailViewModel.balok(p,l,t);

                tvHasilVolume.setText(myFormatter.format(balok.getVolume()));
                tvHasilLuas.setText(myFormatter.format(balok.getLuas()));
            }
        });
    }

    public void kubus() {
        tvRumus.setText(getText(R.string.rumus_kubus));
        InputDynamicUtil.dynamicInput(this, llInput, 1, new String[]{"Masukan s"}, new InputDynamicUtil.SetCallback() {
            @Override
            public void handlerInput(ArrayList<EditText> etList) {
                double s = Helper.parseDoubleOrNull(etList.get(0).getText().toString());

                BangunRuang kubus = detailViewModel.kubus(s);

                tvHasilVolume.setText(myFormatter.format(kubus.getVolume()));
                tvHasilLuas.setText(myFormatter.format(kubus.getLuas()));
            }
        });
    }

    public void kerucut() {
        tvRumus.setText(getText(R.string.rumus_kerucut));
        InputDynamicUtil.dynamicInput(this, llInput, 3, new String[]{"Masukan s", "Masukan r", "Masukan t"}, new InputDynamicUtil.SetCallback() {
            @Override
            public void handlerInput(ArrayList<EditText> etList) {
                double s = Helper.parseDoubleOrNull(etList.get(0).getText().toString());
                double r = Helper.parseDoubleOrNull(etList.get(1).getText().toString());
                double t = Helper.parseDoubleOrNull(etList.get(2).getText().toString());

                BangunRuang kerucut = detailViewModel.kerucut(s,r,t);

                tvHasilVolume.setText(myFormatter.format(kerucut.getVolume()));
                tvHasilLuas.setText(myFormatter.format(kerucut.getLuas()));
            }
        });
    }

    public void bola() {
        tvRumus.setText(getText(R.string.rumus_bola));
        InputDynamicUtil.dynamicInput(this, llInput, 1, new String[]{"Masukan r"}, new InputDynamicUtil.SetCallback() {
            @Override
            public void handlerInput(ArrayList<EditText> etList) {
                double r = Helper.parseDoubleOrNull(etList.get(0).getText().toString());

                BangunRuang bola = detailViewModel.bola(r);

                tvHasilVolume.setText(myFormatter.format(bola.getVolume()));
                tvHasilLuas.setText(myFormatter.format(bola.getLuas()));
            }
        });
    }

    public void limas() {
        tvRumus.setText(getText(R.string.rumus_limas));
        InputDynamicUtil.dynamicInput(this, llInput, 2, new String[]{"Masukan s", "Masukan t"}, new InputDynamicUtil.SetCallback() {
            @Override
            public void handlerInput(ArrayList<EditText> etList) {
                double s = Helper.parseDoubleOrNull(etList.get(0).getText().toString());
                double t = Helper.parseDoubleOrNull(etList.get(1).getText().toString());

                BangunRuang limas = detailViewModel.limas(s,t);

                tvHasilVolume.setText(myFormatter.format(limas.getVolume()));
                tvHasilLuas.setText(myFormatter.format(limas.getLuas()));
            }
        });
    }

    public void prisma() {
        tvRumus.setText(getText(R.string.rumus_prisma));
        InputDynamicUtil.dynamicInput(this, llInput, 4, new String[]{"Masukan a", "Masukan b", "Masukan c", "Masukan t"}, new InputDynamicUtil.SetCallback() {
            @Override
            public void handlerInput(ArrayList<EditText> etList) {
                double a = Helper.parseDoubleOrNull(etList.get(0).getText().toString());
                double b = Helper.parseDoubleOrNull(etList.get(1).getText().toString());
                double c = Helper.parseDoubleOrNull(etList.get(2).getText().toString());
                double t = Helper.parseDoubleOrNull(etList.get(3).getText().toString());

                BangunRuang prisma = detailViewModel.prisma(a,b,c,t);

                tvHasilVolume.setText(myFormatter.format(prisma.getVolume()));
                tvHasilLuas.setText(myFormatter.format(prisma.getLuas()));
            }
        });
    }

    public void tabung() {
        tvRumus.setText(getText(R.string.rumus_tabung));
        InputDynamicUtil.dynamicInput(this, llInput, 2, new String[]{"Masukan r", "Masukan t"}, new InputDynamicUtil.SetCallback() {
            @Override
            public void handlerInput(ArrayList<EditText> etList) {
                double r = Helper.parseDoubleOrNull(etList.get(0).getText().toString());
                double t = Helper.parseDoubleOrNull(etList.get(1).getText().toString());

                BangunRuang tabung = detailViewModel.tabung(r,t);

                tvHasilVolume.setText(myFormatter.format(tabung.getVolume()));
                tvHasilLuas.setText(myFormatter.format(tabung.getLuas()));
            }
        });
    }

    void ruang() {
        llVolume.setVisibility(View.VISIBLE);
        llLuas.setVisibility(View.VISIBLE);
    }

    void datar() {
        llKeliling.setVisibility(View.VISIBLE);
        llLuas.setVisibility(View.VISIBLE);
    }
}
