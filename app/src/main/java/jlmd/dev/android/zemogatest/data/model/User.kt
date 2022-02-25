package jlmd.dev.android.zemogatest.data.model

import com.google.gson.JsonObject

data class User(var id: Int,
                var name: String,
                var email: String,
                var address: JsonObject,
                var phone: String,
                var website: String)