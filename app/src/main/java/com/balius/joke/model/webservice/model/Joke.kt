package com.balius.joke.model.webservice.model

import com.balius.joke.model.webservice.model.Flags
import com.google.gson.annotations.SerializedName

data class Joke(
    @SerializedName("error"    ) var error    : Boolean? = null,
    @SerializedName("category" ) var category : String?  = null,
    @SerializedName("type"     ) var type     : String?  = null,
    @SerializedName("joke"     ) var joke     : String?  = null,
    @SerializedName("flags"    ) var flags    : Flags?   = Flags(),
    @SerializedName("id"       ) var id       : Int?     = null,
    @SerializedName("safe"     ) var safe     : Boolean? = null,
    @SerializedName("lang"     ) var lang     : String?  = null

)
