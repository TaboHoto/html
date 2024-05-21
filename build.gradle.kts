//gradle publishToMavenLocal
defaultTasks("jar")
plugins{
  id("java-library")
  id("maven-publish")
}
group = "tabou.html"
version = "0.1"
repositories.mavenLocal()
repositories.mavenCentral()
dependencies{
 implementation("tabou.xml:xml:0.1")
 implementation("org.ccil.cowan.tagsoup:tagsoup:1.2.1")
}
sourceSets {
    main {
        java.srcDir(".")
    }
}
tasks.withType<JavaCompile>().configureEach{
  options.encoding = "UTF-8"
}

publishing {
 publications {
  create<MavenPublication>("maven") {
   from(components["java"])
  }
 }
}
