Check messages inside a Docker Image ->

Inside Docker Image:
docker exec -it containerName bash

TO check topic names:
/opt/kafka/bin/kafka-topics.sh \
  --bootstrap-server localhost:9092 \
  --list
  
To check messages:
/opt/kafka/bin/kafka-console-consumer.sh \
  --bootstrap-server localhost:9092 \
  --topic javaGuides \
  --from-beginning