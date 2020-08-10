package br.com.monteoliva.testegithub.model.gson

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Repos(@SerializedName("total_count")        @Expose var totalCount: Int? = null,
                 @SerializedName("incomplete_results") @Expose var incompleteResults: Boolean? = null,
                 @SerializedName("items")              @Expose var items: MutableList<Item>? = null
) : Parcelable