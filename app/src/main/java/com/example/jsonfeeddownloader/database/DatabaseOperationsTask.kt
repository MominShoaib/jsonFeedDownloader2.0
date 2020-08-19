package com.example.jsonfeeddownloader.database

import android.os.AsyncTask
import com.example.jsonfeeddownloader.activities.DatabaseOperations
import com.example.jsonfeeddownloader.listeners.DataBaseListener


class DatabaseOperationsTask(
    private val operation: () -> Any,
    private val operationType: DatabaseOperations,
    private val listener: DataBaseListener
) : AsyncTask<Void, Void, Any?>() {

    override fun doInBackground(vararg args: Void?): Any? {
        return operation.invoke()
    }

    override fun onPostExecute(result: Any?) {
        if (operationType == DatabaseOperations.READ) {
            if (result != null) {
                listener.onOperationSuccess(result)
            } else {
                listener.onOperationFailed()
            }
        }
    }
}