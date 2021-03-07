package com.github.grigorevp.library

import android.content.Context
import androidx.startup.Initializer
import com.github.grigorevp.library.NativeDefaults

class NativeDefaultsInitializer: Initializer<NativeDefaults> {

    override fun create(context: Context): NativeDefaults {
        NativeDefaults.setContext(context)
        return NativeDefaults()
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }

}