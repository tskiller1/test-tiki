package vn.hungho.androidhometest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Badge : Serializable {
    @SerializedName("code")
    @Expose
    var code: String? = null

    @SerializedName("text")
    @Expose
    var text: String? = null

    @SerializedName("option")
    @Expose
    var option: String? = null
}