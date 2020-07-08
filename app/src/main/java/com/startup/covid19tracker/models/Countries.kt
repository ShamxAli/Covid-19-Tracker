import com.google.gson.annotations.SerializedName


data class Countries(

    @SerializedName("country") val country: String,
    @SerializedName("cases") val cases: Int,
    @SerializedName("countryInfo") val countryInfo: CountryInfo
)