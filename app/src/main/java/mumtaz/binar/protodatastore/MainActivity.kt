package mumtaz.binar.protodatastore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mainviewmodel : UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainviewmodel = ViewModelProvider(this).get(UserViewModel::class.java)
        mainviewmodel.data.observe(this,{
            tv_nama.text = it.name
        })

        btn_save.setOnClickListener {
            val nama = name_et.text.toString()
            mainviewmodel.update(nama)
        }

        btn_clear.setOnClickListener {
            mainviewmodel.delete()
        }
    }
}