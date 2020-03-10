package br.com.philippesis.eventbusimpl.service

import android.util.Log
import br.com.philippesis.eventbusimpl.event.StatusEvent
import br.com.philippesis.eventbusimpl.util.Utils
import org.greenrobot.eventbus.EventBus

class Status {

    fun checkStatus() {

        Log.i("Status", "${Utils.getDataTime()} - CheckStatus")
        Thread.sleep(2000)
        // Dispara evento
        EventBus.getDefault().post(StatusEvent())
    }

}