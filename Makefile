default:${JMOD}/tabou.html.jar

${JMOD}/%.jar:build/libs/%-0.1.jar
	cp $< $@

#build/libs/%-0.1.jar:%/GeoJsonWrite.java	
#build/libs/tabou.geojson-0.1.jar:tabou.geojson/GeoJsonWrite.java
#	gradle
