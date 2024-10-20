package com.paranid5.star_wars_travel.domain.utils

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.serialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@OptIn(ExperimentalSerializationApi::class)
@Serializer(forClass = ImmutableList::class)
class ImmutableListSerializer(
    private val serializer: KSerializer<String?>,
) : KSerializer<ImmutableList<String?>> {

    private class PersistentListDescriptor :
        SerialDescriptor by serialDescriptor<List<String?>>() {
        @ExperimentalSerializationApi
        override val serialName: String = "kotlinx.serialization.immutable.persistentList"
    }

    override val descriptor: SerialDescriptor = PersistentListDescriptor()

    override fun serialize(encoder: Encoder, value: ImmutableList<String?>): Unit =
        ListSerializer(serializer).serialize(encoder, value)

    override fun deserialize(decoder: Decoder): ImmutableList<String?> =
        ListSerializer(serializer).deserialize(decoder).toImmutableList()
}
