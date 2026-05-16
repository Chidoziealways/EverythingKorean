import com.modrinth.minotaur.dependencies.DependencyType
import com.modrinth.minotaur.dependencies.ModDependency
import net.darkhax.curseforgegradle.TaskPublishCurseForge
import net.neoforged.moddevgradle.tasks.JarJar
import org.jetbrains.kotlin.gradle.utils.extendsFrom


plugins {
    id("convention")

    alias(libs.plugins.minotaur)
    alias(libs.plugins.curseforgegradle)
    alias(libs.plugins.moddevgradle)
}

val modId: String by project

val minecraftVersion = libs.versions.minecraft.asProvider().get()

val modGroupId: String by project

version = libs.versions.everythingkorean.get() + "-" + minecraftVersion
group = modGroupId

val jarJarConfig by configurations.creating

configurations.getByName("implementation").extendsFrom(jarJarConfig)

base {
    archivesName = modId
}

val libraries by configurations.creating

neoForge {
    version = libs.versions.neoforge.asProvider().get()

    parchment {
        mappingsVersion = "2025.09.14"
        minecraftVersion = "1.21.8"
    }

    mods {
        create(modId) {
            sourceSet(sourceSets.main.get())
        }
    }

    validateAccessTransformers = true

    runs {
        // Custom client run
        create("customClient") {
            client() // Sets type = "client"
            gameDirectory.set(project.layout.projectDirectory.dir("runs/client"))
            systemProperty("neoforge.enableGameTest", "true")
            programArguments.addAll(listOf(
                "-mixin.config=everythingkorean.mixins.json"
            ))
        }

        // Custom data generator run
        create("runCustomClientData") {
            clientData() // type = "clientData"
            gameDirectory.set(project.layout.projectDirectory.dir("runs/clientData"))
            programArguments.addAll(listOf(
                "--mod", "everythingkorean",
                "--all",
                "--output", file("src/generated/resources").absolutePath,
                "--existing", file("src/main/resources").absolutePath,
                "-mixin.config=everythingkorean.mixins.json"
            ))
        }

        // Custom dedicated server run
        create("runCustomServer") {
            server() // type = "server"
            gameDirectory.set(project.layout.projectDirectory.dir("runs/server"))
            programArguments.add("--nogui")
        }

        configureEach {
            // Recommended logging data for a userdev environment
            // The markers can be added/remove as needed separated by commas.
            // "SCAN": For mods scan.
            // "REGISTRIES": For firing of registry events.
            // "REGISTRYDUMP": For getting the contents of all registries.
            systemProperty("forge.logging.markers", "REGISTRIES")

            // Recommended logging level for the console
            // You can set various levels here.
            // Please read: https://stackoverflow.com/questions/2031163/when-to-use-the-different-log-levels
            logLevel = org.slf4j.event.Level.DEBUG
            additionalRuntimeClasspathConfiguration.extendsFrom(libraries)
        }
    }
}

sourceSets {
    getByName("main") {

        resources.srcDir("src/generated/resources/$modId")
    }
}

repositories {
    mavenLocal()
    // Forge and Maven Central included automatically
    maven {
        name = "Jared's maven"
        url = uri("https://maven.blamejared.com/")
    }
    maven {
        name = "ModMaven"
        url = uri("https://modmaven.dev")
    }
    maven {
        name = "GeckoLib"
        url = uri("https://dl.cloudsmith.io/public/geckolib3/geckolib/maven/")
    }

    maven {
        name = "Kotlin for Forge"
        url = uri("https://thedarkcolour.github.io/KotlinForForge/")
    }

}

dependencies {
    if (System.getProperty("idea.sync.active") != "true")
        annotationProcessor(variantOf(libs.mixin) { classifier("processor") })

    implementation(libs.jopt.simple)

    //implementation("net.Chidoziealways.everythingjapanese:everythingjapanese:1.17.0-1.21.8")

    implementation("net.Chidoziealways.everythingcore:EverythingCore:5.1.0")

    // Uncomment and add if you want those libs
    // implementation(fg.deobf("com.github.glitchfiend:TerraBlender-forge:$minecraftVersion-$terrablender_version"))
    implementation("software.bernie.geckolib:geckolib-neoforge-1.21.10:5.3-alpha-1")
}

tasks.named<Jar>("jar").configure {
    archiveClassifier.set("slim")
}

val jarJarTask by tasks.registering(JarJar::class) {
    description = "Embed Dependencies into the Mod Jar"
    group = "build"

    configuration(jarJarConfig)

    outputDirectory.set(layout.buildDirectory.dir("embed"))
}

tasks.jar {
    dependsOn(jarJarTask)
    from(jarJarTask.flatMap { it.outputDirectory })
}

modrinth {
    token = System.getenv("MODRINTH_TOKEN") ?: "Invalid/No API Token Found"
    projectId = "bj3FpcD7"
    versionType = "beta"
    versionNumber.set(project.version.toString())
    versionName = "Everything Korean ${project.version}"
    uploadFile.set(tasks.jar.flatMap { it.archiveFile })
    changelog.set(rootProject.file("changelog.md").readText(Charsets.UTF_8))
    gameVersions.set(listOf(minecraftVersion))
    dependencies.add(ModDependency("geckolib", DependencyType.REQUIRED))
    dependencies.add(ModDependency("everything-core", DependencyType.REQUIRED))
    loaders.set(listOf("neoforge"))

    //https://github.com/modrinth/minotaur#available-properties
}

tasks.register<TaskPublishCurseForge>("publishToCurseForge") {
    group = "publishing"
    apiToken = System.getenv("CURSEFORGE_TOKEN") ?: "Invalid/No API Token Found"
    doFirst {
        println("CurseForge: " + System.getenv("CURSEFORGE_TOKEN"))
    }

    val mainFile = upload(1354276, tasks.jar.flatMap { it.archiveFile })
    mainFile.releaseType = "beta"
    mainFile.addModLoader("NeoForge")
    mainFile.addGameVersion(minecraftVersion)
    mainFile.addEnvironment("Client", "Server")
    mainFile.addJavaVersion("Java 22")
    mainFile.changelogType = "markdown"
    mainFile.changelog = rootProject.file("changelog.md").readText(Charsets.UTF_8)
}

publishing {
    publications {
        create<MavenPublication>("everythingkorean") {
            from(components["java"])
            artifactId = base.archivesName.get()
        }
    }
    repositories {
        mavenLocal() // <-- local repo (~/.m2/repository)
        maven {
            url = uri("${project.buildDir}/repo")
        }
        // Or remote server
        // maven {
        //     url = uri("https://my.maven.repo/releases")
        //     credentials {
        //         username = "user"
        //         password = "pass"
        //     }
        // }
    }
}


tasks.named<DefaultTask>("publish").configure {
    finalizedBy("modrinth")
    finalizedBy("publishToCurseForge")
}

sourceSets.all {
    val dir = layout.buildDirectory.dir("sourcesSets/$name")
    output.setResourcesDir(dir)
    java.destinationDirectory.set(dir)
    kotlin.destinationDirectory.set(dir)
}

tasks.named<JavaCompile>("compileJava") {
    dependsOn(tasks.named("processResources"))
}