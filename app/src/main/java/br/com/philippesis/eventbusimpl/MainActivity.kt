package br.com.philippesis.eventbusimpl

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.com.philippesis.eventbusimpl.event.StatusEvent
import br.com.philippesis.eventbusimpl.service.Status
import br.com.philippesis.eventbusimpl.util.Utils
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Registra o bus de evento
        EventBus.getDefault().register(this)
        Log.i("MainActivity", "${Utils.getDataTime()} - Registro do evento.")
        Status().checkStatus()
    }

    override fun onDestroy() {
        super.onDestroy()
        // Cancela o registro no bus de evento
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: StatusEvent) {
        // Recebeu o evento.
        Log.i("MainActivity", "${Utils.getDataTime()} - Recebeu evento.")
    }

}
