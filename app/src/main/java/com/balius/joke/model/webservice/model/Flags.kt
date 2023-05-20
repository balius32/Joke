package com.balius.joke.model.webservice.model

import com.google.gson.annotations.SerializedName

data class Flags(

    @SerializedName("nsfw"      ) var nsfw      : Boolean? = null,
    @SerializedName("religious" ) var religious : Boolean? = null,
    @SerializedName("political" ) var political : Boolean? = null,
    @SerializedName("racist"    ) var racist    : Boolean? = null,
    @SerializedName("sexist"    ) var sexist    : Boolean? = null,
    @SerializedName("explicit"  ) var explicit  : Boolean? = null
)
