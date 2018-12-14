package io.mverse.client.infusionsoft.infrastructure

import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.Serializer
import kotlinx.serialization.context.SimpleModule
import kotlinx.serialization.enumMembers
import kotlinx.serialization.internal.StringDescriptor
import kotlinx.serialization.json.JSON
import kotlinx.serialization.withName
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.ISO_DATE_TIME
import java.time.format.DateTimeFormatterBuilder
import kotlin.reflect.KClass

/**
 * Additional serializers can be added to this instance to control the serialization of api calls
 */
val json = JSON(strictMode = false).apply {
  install(SimpleModule(OffsetDateTime::class, OffsetDateTimeSerializer))
  install(SimpleModule(LocalDateTime::class, LocalDateTimeSerializer))
}

var flexibleISOParser = DateTimeFormatterBuilder()
    // date/time
    .append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
    // offset (hh:mm - "+00:00" when it's zero)
    .optionalStart().appendOffset("+HH:MM", "+00:00").optionalEnd()
    // offset (hhmm - "+0000" when it's zero)
    .optionalStart().appendOffset("+HHMM", "+0000").optionalEnd()
    // offset (hh - "Z" when it's zero)
    .optionalStart().appendOffset("+HH", "Z").optionalEnd()
    // create formatter
    .toFormatter()

@Serializer(forClass = LocalDateTime::class)
object LocalDateTimeSerializer : KSerializer<LocalDateTime> {
  override val descriptor: SerialDescriptor = StringDescriptor.withName("LocalDateTime")

  override fun deserialize(input: Decoder): LocalDateTime {
    return LocalDateTime.parse(input.decodeString(), flexibleISOParser)
  }

  override fun serialize(output: Encoder, obj: LocalDateTime) {
    output.encodeString(obj.format(ISO_DATE_TIME))
  }
}

@Serializer(forClass = OffsetDateTime::class)
object OffsetDateTimeSerializer : KSerializer<OffsetDateTime> {
  override val descriptor: SerialDescriptor = StringDescriptor.withName("OffsetDateTime")

  override fun deserialize(input: Decoder): OffsetDateTime {
    return OffsetDateTime.parse(input.decodeString(), flexibleISOParser)
  }

  override fun serialize(output: Encoder, obj: OffsetDateTime) {
    output.encodeString(obj.format(ISO_DATE_TIME))
  }
}

open class EnumStringSerializer<E:Enum<E>>(val type: KClass<E>): KSerializer<E> {
  override val descriptor: SerialDescriptor = StringDescriptor.withName("EnumString")

  override fun deserialize(input: Decoder): E {
    val enumValue = input.decodeString()
    val enumValueLower = enumValue.toLowerCase()
    return type.enumMembers()
        .firstOrNull { it.name.toLowerCase() == enumValueLower || it.toString().toLowerCase() == enumValueLower }
        ?: throw IllegalStateException("No enum value $enumValue for ${type.qualifiedName}")
  }

  override fun serialize(output: Encoder, obj: E) {
    output.encodeString(obj.toString())
  }
}

@Serializer(forClass = Unit::class)
object UnitSerializer:KSerializer<Unit> {
  override fun deserialize(input: Decoder) {
    //Do nothing
  }

  override fun serialize(output: Encoder, obj: Unit) {
    //Do nothing
  }
}
