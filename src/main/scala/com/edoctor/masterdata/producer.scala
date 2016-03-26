package com.edoctor.masterdata
import java.util.Collections
import java.util.Date
import java.util.Properties
import java.util.Random

import org.apache.kafka.clients.producer._

object Producer {
  def main(args: Array[String]): Unit = {
    val props = new Properties()
    props.put("bootstrap.servers", "118.242.33.202:9092")
    props.put("acks", "all")
    props.put("retries", "0")
    props.put("batch.size", "16384");
    props.put("linger.ms", "1");
    props.put("buffer.memory", "33554432");
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

    val producer = new KafkaProducer[String,String](props);
    for (i <- 1 to 5) {
      producer.send(new ProducerRecord[String, String]("my-topic", Integer.toString(i), Integer.toString(i)))
      producer.close()
    }
  }
}
