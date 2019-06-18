package vn.hungho.androidhometest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.math.BigDecimal

class Product : Serializable {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("rating_average")
    @Expose
    var ratingAverage: Float? = null

    @SerializedName("price")
    @Expose
    var price: BigDecimal? = null

    @SerializedName("review_count")
    @Expose
    var reviewCount: Int? = null

    @SerializedName("thumbnail_url")
    @Expose
    var thumbnailUrl: String? = null

    @SerializedName("discount_rate")
    @Expose
    var discountRate: Int? = null

    @SerializedName("badges")
    @Expose
    var badges: List<Badge>? = null
}